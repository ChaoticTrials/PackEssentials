package de.melanx.packessentials;

import de.melanx.packessentials.data.ModTagProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.BoundingBox;

import java.util.ArrayList;
import java.util.List;

public class CoreUtil {

    public static void tickComposter(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        int compost = state.getValue(ComposterBlock.LEVEL);
        if (compost < 7) {
            level.getBlockTicks().clearArea(new BoundingBox(pos));
            return;
        }

        if (compost == 8) {
            List<Block> blocks = new ArrayList<>();
            //noinspection deprecation
            for (Holder<Block> holder : BuiltInRegistries.BLOCK.getTagOrEmpty(ModTagProvider.COMPOSTER_GROWABLE)) {
                blocks.add(holder.value());
            }

            if (!blocks.isEmpty()) {
                for (int i = 0; i < 16; i++) {
                    if (random.nextDouble() < PackConfig.composterSpreading) {
                        BlockPos offset = pos.offset(random.nextInt(5) - 2, (random.nextInt(3) - 1) * (random.nextInt(3) / 2), random.nextInt(5) - 2);
                        BlockState possiblePlant = blocks.get(random.nextInt(blocks.size())).defaultBlockState();
                        if (!possiblePlant.getFluidState().isEmpty() && !possiblePlant.getFluidState().is(level.getFluidState(offset).getType())) {
                            continue;
                        }

                        if (possiblePlant.getFluidState().isEmpty() && !level.getBlockState(offset).isAir()) {
                            continue;
                        }

                        BlockState belowOffset = level.getBlockState(offset.below());
                        if (!belowOffset.is(BlockTags.DIRT) && !belowOffset.is(Blocks.FARMLAND)) {
                            continue;
                        }

                        if (possiblePlant.canSurvive(level, offset)) {
                            level.setBlock(offset, possiblePlant, Block.UPDATE_ALL_IMMEDIATE);
                        }
                    }
                }
            }
        }

        if (!level.getBlockTicks().hasScheduledTick(pos, state.getBlock())) {
            level.scheduleTick(pos, state.getBlock(), random.nextInt(Level.TICKS_PER_DAY / 2));
        }
    }
}

// todo on destroy, on empty