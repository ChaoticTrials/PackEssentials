package de.melanx.packessentials.client;

import com.mojang.blaze3d.platform.Window;
import de.melanx.packessentials.PackConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.toasts.*;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.client.event.ToastAddEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import javax.annotation.Nullable;

public class ForgeEventHandlerClient {

    @SubscribeEvent
    public void updateScreen(ScreenEvent.Opening event) {
        if (PackConfig.titleScreenScale <= 0 || !(event.getScreen() instanceof TitleScreen)) {
            return;
        }

        Minecraft mc = Minecraft.getInstance();
        Window window = mc.getWindow();
        int scale = window.calculateScale(PackConfig.titleScreenScale, mc.isEnforceUnicode());
        window.setGuiScale(scale);
    }

    @SubscribeEvent
    public void closeScreen(ScreenEvent.Closing event) {
        if (PackConfig.titleScreenScale <= 0 || !(event.getScreen() instanceof TitleScreen)) {
            return;
        }

        Minecraft mc = Minecraft.getInstance();
        int scale = mc.getWindow().calculateScale(mc.options.guiScale().get(), mc.isEnforceUnicode());
        mc.getWindow().setGuiScale(scale);
    }

    @SubscribeEvent
    public void onToastAdd(ToastAddEvent event) {
        VanillaToastType toastType = VanillaToastType.getType(event.getToast());
        if (toastType == null) {
            return;
        }

        switch (toastType) {
            case ADVANCEMENT -> event.setCanceled(PackConfig.Toasts.disableAdvancementToasts);
            case RECIPE -> event.setCanceled(PackConfig.Toasts.disableRecipeToasts);
            case SYSTEM -> event.setCanceled(PackConfig.Toasts.disableSystemToasts);
            case TUTORIAL -> event.setCanceled(PackConfig.Toasts.disableTutorialToasts);
        }
    }

    private enum VanillaToastType {
        ADVANCEMENT,
        RECIPE,
        SYSTEM,
        TUTORIAL;

        @Nullable
        public static VanillaToastType getType(Toast toast) {
            if (toast instanceof AdvancementToast) {
                return ADVANCEMENT;
            }

            if (toast instanceof RecipeToast) {
                return RECIPE;
            }

            if (toast instanceof SystemToast) {
                return SYSTEM;
            }

            if (toast instanceof TutorialToast) {
                return TUTORIAL;
            }

            return null;
        }
    }
}
