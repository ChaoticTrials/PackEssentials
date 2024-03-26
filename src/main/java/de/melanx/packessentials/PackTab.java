package de.melanx.packessentials;

import de.melanx.packessentials.blocks.ModBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.moddingx.libx.creativetab.CreativeTabX;
import org.moddingx.libx.mod.ModX;

public class PackTab extends CreativeTabX {

    protected PackTab(ModX mod) {
        super(mod);
    }

    @Override
    protected void buildTab(CreativeModeTab.Builder builder) {
        builder.title(Component.literal(PackConfig.modpack.getName()));
        builder.icon(() -> new ItemStack(ModBlocks.compressedCobblestone));
    }

    @Override
    protected void addItems(TabContext ctx) {
        this.addModItems(ctx);
    }
}
