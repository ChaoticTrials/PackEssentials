package de.melanx.packessentials.blocks;

import de.melanx.packessentials.Modpack;
import de.melanx.packessentials.PackEssentials;
import de.melanx.packessentials.items.CompressedBlockItem;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.registries.ForgeRegistries;
import org.moddingx.libx.mod.ModX;
import org.moddingx.libx.registration.RegistrationContext;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;

public class CompressedBlock extends PackBlockBase {

    private static final int COMPRESSION_SIZE = 9;
    private static final int MAX_COMPRESSION = 9;
    private final Block baseBlock;
    private final int compression;
    private final CompressedBlockItem item;
    private final Component tooltip;

    public CompressedBlock(ModX mod, Block baseBlock, int compression, Modpack... modpacks) {
        this(mod, new Item.Properties(), baseBlock, compression, modpacks);
    }

    public CompressedBlock(ModX mod, @Nullable Item.Properties itemProperties, Block baseBlock, int compression, Modpack... modpacks) {
        super(mod, Properties.copy(baseBlock), null, modpacks);
        if (compression <= 0) {
            throw new IllegalStateException("Making a compressed block without compression makes no sense");
        }
        if (compression > MAX_COMPRESSION) {
            throw new IllegalStateException("Too high compression of " + compression + ", choose below " + MAX_COMPRESSION + 1);
        }
        this.baseBlock = baseBlock;
        this.compression = compression;
        this.tooltip = Component.translatable("packessentials.block.compressed.tooltip", (int) Math.pow(COMPRESSION_SIZE, this.compression), this.baseBlock.getName()).withStyle(ChatFormatting.GRAY);

        if (itemProperties == null) {
            this.item = null;
        } else {
            this.item = new CompressedBlockItem(this, itemProperties) {

                @Override
                public void initializeClient(@Nonnull Consumer<IClientItemExtensions> consumer) {
                    CompressedBlock.this.initializeItemClient(consumer);
                }

                @Override
                public int getBurnTime(ItemStack stack, @Nullable RecipeType<?> recipeType) {
                    return CompressedBlock.this.getBurnTime(stack, recipeType);
                }
            };
        }
    }

    private boolean hasItem() {
        return this.item != null;
    }

    @Override
    public void appendHoverText(@Nonnull ItemStack stack, @Nullable BlockGetter level, @Nonnull List<Component> tooltip, @Nonnull TooltipFlag flag) {
        tooltip.add(this.tooltip);
    }

    @Nonnull
    @Override
    public MutableComponent getName() {
        return Component.translatable(PackEssentials.getInstance().modid + ".block.compressed_" + this.compression, this.baseBlock.getName());
    }

    @SuppressWarnings("MethodDoesntCallSuperMethod")
    @Override
    public void registerAdditional(RegistrationContext ctx, EntryCollector builder) {
        if (this.hasItem()) {
            builder.register(Registries.ITEM, this.item);
        }
    }

    @SuppressWarnings("MethodDoesntCallSuperMethod")
    @Override
    public void initTracking(RegistrationContext ctx, TrackingCollector builder) throws ReflectiveOperationException {
        if (this.hasItem()) {
            builder.track(ForgeRegistries.ITEMS, CompressedBlock.class.getDeclaredField("item"));
        }
    }
}
