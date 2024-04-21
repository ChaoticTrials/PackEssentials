package de.melanx.packessentials.base;

import de.melanx.packessentials.Modpack;
import de.melanx.packessentials.base.item.PackBlockItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.InfestedBlock;
import net.minecraftforge.registries.ForgeRegistries;
import org.moddingx.libx.creativetab.CreativeTabItemProvider;
import org.moddingx.libx.mod.ModX;
import org.moddingx.libx.registration.Registerable;
import org.moddingx.libx.registration.RegistrationContext;

import javax.annotation.OverridingMethodsMustInvokeSuper;
import java.util.Set;
import java.util.stream.Stream;

public class InfestedBlockBase extends InfestedBlock implements PackElement, Registerable, CreativeTabItemProvider {

    protected final ModX mod;
    protected final Set<Modpack> modpacks;
    private final Item item;

    public InfestedBlockBase(ModX mod, Block host, Modpack... modpacks) {
        this(mod, new Item.Properties(), host, modpacks);
    }

    public InfestedBlockBase(ModX mod, Item.Properties itemProperties, Block host, Modpack... modpacks) {
        super(host, Properties.copy(host));
        this.mod = mod;
        this.modpacks = Set.of(modpacks);
        this.item = new PackBlockItem(this, itemProperties);
    }

    @Override
    public Set<Modpack> getModpacks() {
        return this.modpacks;
    }

    @Override
    public Stream<ItemStack> makeCreativeTabStacks() {
        return Stream.of(new ItemStack(this));
    }

    @Override
    @OverridingMethodsMustInvokeSuper
    public void registerAdditional(RegistrationContext ctx, EntryCollector builder) {
        builder.register(Registries.ITEM, this.item);
    }

    @Override
    @OverridingMethodsMustInvokeSuper
    public void initTracking(RegistrationContext ctx, TrackingCollector builder) throws ReflectiveOperationException {
        builder.track(ForgeRegistries.ITEMS, InfestedBlockBase.class.getDeclaredField("item"));
    }
}
