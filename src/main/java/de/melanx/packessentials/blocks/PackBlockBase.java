package de.melanx.packessentials.blocks;

import de.melanx.packessentials.Modpack;
import de.melanx.packessentials.PackConfig;
import net.minecraft.world.flag.FeatureElement;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.Item;
import org.moddingx.libx.base.BlockBase;
import org.moddingx.libx.mod.ModX;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Set;

public class PackBlockBase extends BlockBase implements FeatureElement {

    protected final Set<Modpack> modpacks;

    public PackBlockBase(ModX mod, Properties properties, Modpack... modpacks) {
        this(mod, properties, new Item.Properties(), modpacks);
    }

    public PackBlockBase(ModX mod, Properties properties, @Nullable Item.Properties itemProperties, Modpack... modpacks) {
        super(mod, properties, itemProperties);
        this.modpacks = Set.of(modpacks);
    }

    @Override
    public boolean isEnabled(@Nonnull FeatureFlagSet enabledFeatures) {
        return this.modpacks.contains(PackConfig.modpack);
    }
}
