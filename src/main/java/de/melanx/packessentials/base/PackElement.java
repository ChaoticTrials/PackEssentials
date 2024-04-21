package de.melanx.packessentials.base;

import de.melanx.packessentials.Modpack;
import de.melanx.packessentials.PackConfig;
import net.minecraft.world.flag.FeatureElement;
import net.minecraft.world.flag.FeatureFlagSet;

import javax.annotation.Nonnull;
import java.util.Set;

public interface PackElement extends FeatureElement {

    Set<Modpack> getModpacks();

    @Override
    default boolean isEnabled(@Nonnull FeatureFlagSet enabledFeatures) {
        return this.getModpacks().contains(PackConfig.modpack);
    }
}
