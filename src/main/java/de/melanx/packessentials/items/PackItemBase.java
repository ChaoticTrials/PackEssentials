package de.melanx.packessentials.items;

import de.melanx.packessentials.Modpack;
import de.melanx.packessentials.PackConfig;
import net.minecraft.world.flag.FeatureElement;
import net.minecraft.world.flag.FeatureFlagSet;
import org.moddingx.libx.base.ItemBase;
import org.moddingx.libx.mod.ModX;

import javax.annotation.Nonnull;
import java.util.Set;

public class PackItemBase extends ItemBase implements FeatureElement {

    private final Set<Modpack> modpacks;

    public PackItemBase(ModX mod, Properties properties, Modpack... modpacks) {
        super(mod, properties);
        this.modpacks = Set.of(modpacks);
    }

    @Override
    public boolean isEnabled(@Nonnull FeatureFlagSet enabledFeatures) {
        return this.modpacks.contains(PackConfig.modpack);
    }
}
