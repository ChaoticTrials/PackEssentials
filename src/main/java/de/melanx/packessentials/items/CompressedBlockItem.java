package de.melanx.packessentials.items;

import de.melanx.packessentials.blocks.CompressedBlock;
import net.minecraft.network.chat.Component;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nonnull;

public class CompressedBlockItem extends BlockItem {

    public CompressedBlockItem(CompressedBlock block, Properties properties) {
        super(block, properties);
    }

    @Nonnull
    @Override
    public Component getName(@Nonnull ItemStack stack) {
        return this.getBlock().getName();
    }

    @Override
    public boolean isEnabled(@Nonnull FeatureFlagSet enabledFeatures) {
        return this.getBlock().isEnabled(enabledFeatures);
    }
}
