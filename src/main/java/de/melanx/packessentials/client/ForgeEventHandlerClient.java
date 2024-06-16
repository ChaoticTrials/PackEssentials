package de.melanx.packessentials.client;

import com.mojang.blaze3d.platform.Window;
import de.melanx.packessentials.PackConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ForgeEventHandlerClient {

    private static double prevScale = 0;

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
}
