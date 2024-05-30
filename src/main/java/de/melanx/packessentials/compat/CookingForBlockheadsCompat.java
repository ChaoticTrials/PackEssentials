package de.melanx.packessentials.compat;

import de.melanx.packessentials.Features;
import de.melanx.packessentials.PackConfig;
import net.blay09.mods.cookingforblockheads.block.BlockKitchen;
import net.blay09.mods.cookingforblockheads.tile.FridgeBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.state.BlockState;

public class CookingForBlockheadsCompat {

    public static void fridgeMakesSnow(Level level, BlockPos pos, BlockState state, FridgeBlockEntity blockEntity) {
        if (!Features.isEnabled(Features.FRIDGE_FOR_SNOW) || level.getDayTime() % 20 == 0) {
            return;
        }

        boolean isOpen = blockEntity.getDoorAnimator().getNumPlayersUsing() > 0 || blockEntity.getDoorAnimator().isForcedOpen();
        if (isOpen && level.random.nextDouble() < PackConfig.snowChance) {
            BlockPos relativePos = blockEntity.getBaseFridge().getBlockPos().relative(level.getBlockState(pos).getValue(BlockKitchen.FACING));
            BlockState blockState = level.getBlockState(relativePos);

            if (!Blocks.SNOW.defaultBlockState().canSurvive(level, relativePos)) {
                return;
            }

            if (blockState.isAir()) {
                level.setBlock(relativePos, Blocks.SNOW.defaultBlockState(), Block.UPDATE_CLIENTS);
                return;
            }

            if (blockState.is(Blocks.SNOW)) {
                int layers = blockState.getValue(SnowLayerBlock.LAYERS);
                if (layers < 8) {
                    level.setBlock(relativePos, blockState.setValue(SnowLayerBlock.LAYERS, layers + 1), Block.UPDATE_CLIENTS);
                }
            }
        }
    }
}
