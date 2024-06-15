package de.melanx.packessentials;

import net.minecraft.client.gui.components.toasts.*;
import net.minecraftforge.client.event.ToastAddEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ForgeEventHandler {

    @SubscribeEvent
    public void onToastAdd(ToastAddEvent event) {
        VanillaToastType toastType = VanillaToastType.getType(event.getToast());
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
