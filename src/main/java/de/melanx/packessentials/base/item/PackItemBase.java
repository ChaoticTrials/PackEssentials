package de.melanx.packessentials.base.item;

import de.melanx.packessentials.Modpack;
import de.melanx.packessentials.base.PackElement;
import org.moddingx.libx.base.ItemBase;
import org.moddingx.libx.mod.ModX;

import java.util.Set;

public class PackItemBase extends ItemBase implements PackElement {

    private final Set<Modpack> modpacks;

    public PackItemBase(ModX mod, Properties properties, Modpack... modpacks) {
        super(mod, properties);
        this.modpacks = Set.of(modpacks);
    }

    @Override
    public Set<Modpack> getModpacks() {
        return this.modpacks;
    }
}
