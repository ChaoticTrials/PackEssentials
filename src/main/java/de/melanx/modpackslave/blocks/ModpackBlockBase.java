package de.melanx.modpackslave.blocks;

import de.melanx.modpackslave.Modpack;
import de.melanx.modpackslave.SlaveConfig;
import net.minecraft.world.flag.FeatureElement;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.Item;
import org.moddingx.libx.base.BlockBase;
import org.moddingx.libx.mod.ModX;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Set;

public class ModpackBlockBase extends BlockBase implements FeatureElement {

    protected final Set<Modpack> modpacks;

    public ModpackBlockBase(ModX mod, Properties properties, Modpack... modpacks) {
        this(mod, properties, new Item.Properties(), modpacks);
    }

    public ModpackBlockBase(ModX mod, Properties properties, @Nullable Item.Properties itemProperties, Modpack... modpacks) {
        super(mod, properties, itemProperties);
        this.modpacks = Set.of(modpacks);
    }

    @Override
    public boolean isEnabled(@Nonnull FeatureFlagSet enabledFeatures) {
        return this.modpacks.contains(SlaveConfig.modpack);
    }
}
