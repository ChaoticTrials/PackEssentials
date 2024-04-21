package de.melanx.packessentials.items;

import de.melanx.packessentials.Modpack;
import de.melanx.packessentials.base.item.PackItemBase;
import de.melanx.packessentials.blocks.ModBlocks;
import de.melanx.packessentials.blocks.SnadBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;
import org.moddingx.libx.mod.ModX;

import javax.annotation.Nonnull;

public class SnadFertilizerItem extends PackItemBase {

    public SnadFertilizerItem(ModX mod, Properties properties, Modpack... modpacks) {
        super(mod, properties, modpacks);
    }

    @Nonnull
    @Override
    public InteractionResult useOn(@Nonnull UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();

        BlockState state = level.getBlockState(pos);
        Block futureBlock;
        if (state.is(Tags.Blocks.SAND_COLORLESS)) {
            futureBlock = ModBlocks.snad;
        } else if (state.is(Tags.Blocks.SAND_RED)) {
            futureBlock = ModBlocks.redSnad;
        } else if ((state.is(ModBlocks.snad) || state.is(ModBlocks.redSnad)) && state.getValue(SnadBlock.FERTILIZER) < SnadBlock.MAX_FERTILIZER_LEVEL) {
            int fertilizer = state.getValue(SnadBlock.FERTILIZER);
            level.setBlock(pos, state.setValue(SnadBlock.FERTILIZER, ++fertilizer), Block.UPDATE_ALL_IMMEDIATE);
            context.getItemInHand().shrink(1);
            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.PASS;
        }

        level.setBlock(pos, futureBlock.defaultBlockState().setValue(SnadBlock.FERTILIZER, SnadBlock.MAX_FERTILIZER_LEVEL), Block.UPDATE_ALL_IMMEDIATE);
        context.getItemInHand().shrink(1);

        return InteractionResult.SUCCESS;
    }
}
