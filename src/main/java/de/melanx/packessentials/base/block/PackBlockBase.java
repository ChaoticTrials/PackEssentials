package de.melanx.packessentials.base.block;

import de.melanx.packessentials.Modpack;
import de.melanx.packessentials.base.PackElement;
import net.minecraft.world.item.Item;
import org.moddingx.libx.base.BlockBase;
import org.moddingx.libx.mod.ModX;

import javax.annotation.Nullable;
import java.util.Set;

public class PackBlockBase extends BlockBase implements PackElement {

    protected final Set<Modpack> modpacks;

    public PackBlockBase(ModX mod, Properties properties, Modpack... modpacks) {
        this(mod, properties, new Item.Properties(), modpacks);
    }

    public PackBlockBase(ModX mod, Properties properties, @Nullable Item.Properties itemProperties, Modpack... modpacks) {
        super(mod, properties, itemProperties);
        this.modpacks = Set.of(modpacks);
    }

    @Override
    public Set<Modpack> getModpacks() {
        return this.modpacks;
    }
}
