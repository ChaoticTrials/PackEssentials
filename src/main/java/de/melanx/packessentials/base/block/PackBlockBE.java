package de.melanx.packessentials.base.block;

import de.melanx.packessentials.Modpack;
import de.melanx.packessentials.base.PackElement;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.moddingx.libx.base.tile.BlockBE;
import org.moddingx.libx.mod.ModX;

import javax.annotation.Nullable;
import java.util.Set;

public class PackBlockBE<T extends BlockEntity> extends BlockBE<T> implements PackElement {

    private final Set<Modpack> modpacks;

    public PackBlockBE(ModX mod, Class<T> beClass, Properties properties, Modpack... modpacks) {
        this(mod, beClass, properties, new Item.Properties(), modpacks);
    }

    public PackBlockBE(ModX mod, Class<T> beClass, Properties properties, @Nullable Item.Properties itemProperties, Modpack... modpacks) {
        super(mod, beClass, properties, itemProperties);
        this.modpacks = Set.of(modpacks);
    }

    @Override
    public Set<Modpack> getModpacks() {
        return this.modpacks;
    }

    protected static <E extends BlockEntity, A extends BlockEntity> BlockEntityTicker<A> createTickerHelper(BlockEntityType<A> serverType, BlockEntityType<E> clientType, BlockEntityTicker<? super E> ticker) {
        //noinspection unchecked
        return clientType == serverType ? (BlockEntityTicker<A>) ticker : null;
    }
}
