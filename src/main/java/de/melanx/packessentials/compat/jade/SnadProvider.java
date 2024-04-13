package de.melanx.packessentials.compat.jade;

import de.melanx.packessentials.PackEssentials;
import de.melanx.packessentials.blocks.SnadBlock;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;
import snownee.jade.api.ui.IElementHelper;

public class SnadProvider implements IBlockComponentProvider {

    public static final ResourceLocation UID = PackEssentials.getInstance().resource("snad");
    public static final SnadProvider INSTANCE = new SnadProvider();
    public static final Component FULL = Component.translatable("packessentials.compat.jade.snad.fertilizer_full").withStyle(ChatFormatting.GREEN);
    public static final Component HALF = Component.translatable("packessentials.compat.jade.snad.fertilizer_half").withStyle(ChatFormatting.YELLOW);
    public static final Component EMPTY = Component.translatable("packessentials.compat.jade.snad.fertilizer_empty").withStyle(ChatFormatting.RED);

    @Override
    public void appendTooltip(ITooltip tooltip, BlockAccessor accessor, IPluginConfig config) {
        if (!config.get(UID)) {
            return;
        }

        IElementHelper helper = tooltip.getElementHelper();
        int fertilizer = accessor.getBlockState().getValue(SnadBlock.FERTILIZER);
        tooltip.add(helper.text(fertilizer == SnadBlock.MAX_FERTILIZER_LEVEL ? FULL : fertilizer == 0 ? EMPTY : HALF));
    }

    @Override
    public ResourceLocation getUid() {
        return UID;
    }
}
