package de.melanx.packessentials.mixin;

import com.mojang.blaze3d.platform.Window;
import de.melanx.packessentials.PackConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Minecraft.class)
public abstract class MixinMinecraft {

    @Redirect(
            method = "resizeDisplay",
            at = @At(
                    value = "INVOKE",
                    target = "Lcom/mojang/blaze3d/platform/Window;calculateScale(IZ)I"
            )
    )
    public int fixedSize(Window window, int guiScale, boolean forceUnicode) {
        boolean doScaling = ((Minecraft) (Object) this).screen instanceof TitleScreen && PackConfig.titleScreenScale > 0;
        return window.calculateScale(doScaling ? PackConfig.titleScreenScale : guiScale, forceUnicode);
    }
}
