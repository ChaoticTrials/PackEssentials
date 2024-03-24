package de.melanx.modpackslave.items;

import de.melanx.modpackslave.Modpack;
import de.melanx.modpackslave.SlaveConfig;
import net.minecraft.world.flag.FeatureElement;
import net.minecraft.world.flag.FeatureFlagSet;
import org.moddingx.libx.base.ItemBase;
import org.moddingx.libx.mod.ModX;

import javax.annotation.Nonnull;
import java.util.Set;

public class ModpackItemBase extends ItemBase implements FeatureElement {

    private final Set<Modpack> modpacks;

    public ModpackItemBase(ModX mod, Properties properties, Modpack... modpacks) {
        super(mod, properties);
        this.modpacks = Set.of(modpacks);
    }

    @Override
    public boolean isEnabled(@Nonnull FeatureFlagSet enabledFeatures) {
        return this.modpacks.contains(SlaveConfig.modpack);
    }
}
