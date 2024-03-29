package de.melanx.packessentials;

import de.melanx.packessentials.data.*;
import de.melanx.packessentials.data.textures.TextureProvider;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.moddingx.libx.creativetab.CreativeTabX;
import org.moddingx.libx.datagen.DatagenSystem;
import org.moddingx.libx.mod.ModXRegistration;

@Mod("packessentials")
public final class PackEssentials extends ModXRegistration {

    private static PackEssentials instance;
    private static CreativeTabX creativeTab;

    public PackEssentials() {
        instance = this;
        creativeTab = new PackTab(this);

        DatagenSystem.create(this, system -> {
            system.addDataProvider(TextureProvider::new);
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

    public static PackEssentials getInstance() {
        return instance;
    }

    public static CreativeTabX getCreativeTab() {
        return creativeTab;
    }
}
