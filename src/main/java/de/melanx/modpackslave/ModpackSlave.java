package de.melanx.modpackslave;

import de.melanx.modpackslave.data.*;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.moddingx.libx.creativetab.CreativeTabX;
import org.moddingx.libx.datagen.DatagenSystem;
import org.moddingx.libx.mod.ModXRegistration;

@Mod("modpackslave")
public final class ModpackSlave extends ModXRegistration {

    private static ModpackSlave instance;
    private static CreativeTabX creativeTab;

    public ModpackSlave() {
        instance = this;
        creativeTab = new ModpackTab(this);

        DatagenSystem.create(this, system -> {
            system.addDataProvider(BlockStateProvider::new);
            system.addDataProvider(ItemModelProvider::new);
            system.addDataProvider(LootTableProvider::new);
            system.addDataProvider(ModTagProvider::new);
            system.addDataProvider(RecipeProvider::new);
        });
    }

    @Override
    protected void setup(FMLCommonSetupEvent event) {
        // NO-OP
    }

    @Override
    protected void clientSetup(FMLClientSetupEvent event) {
        // NO-OP
    }

    public static ModpackSlave getInstance() {
        return instance;
    }

    public static CreativeTabX getCreativeTab() {
        return creativeTab;
    }
}
