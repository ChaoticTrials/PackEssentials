package de.melanx.packessentials.client;

import de.melanx.packessentials.items.BuriedMobItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

public class ClientPackEssentials {

    public ClientPackEssentials() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::registerItemColor);
    }

    private void registerItemColor(RegisterColorHandlersEvent.Item event) {
        Item[] items = ForgeRegistries.ITEMS.getValues().stream()
                .filter(item -> item instanceof BuriedMobItem<?>)
                .toArray(Item[]::new);
        //noinspection deprecation
        event.getItemColors().register(((stack, tintIndex) -> 0xFF000000 | ((BuriedMobItem<?>) stack.getItem()).spawnEggItem.get().getColor(tintIndex)), items);
    }
}
