package de.melanx.packessentials.blocks;

import de.melanx.packessentials.Modpack;
import de.melanx.packessentials.PackConfig;
import de.melanx.packessentials.data.ModTagProvider;
import de.melanx.packessentials.items.PackBlockItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.flag.FeatureElement;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.registries.ForgeRegistries;
import org.moddingx.libx.creativetab.CreativeTabItemProvider;
import org.moddingx.libx.registration.Registerable;
import org.moddingx.libx.registration.RegistrationContext;

import javax.annotation.Nonnull;
import java.util.Set;
import java.util.stream.Stream;

public class SnadBlock extends FallingBlock implements Registerable, FeatureElement, CreativeTabItemProvider {

    protected final Set<Modpack> modpacks;
    private final Item item;
    private final int dustColor;

    public SnadBlock(int dustColor, Properties properties, Modpack... modpacks) {
        super(properties.randomTicks());
        this.dustColor = dustColor;
        this.modpacks = Set.of(modpacks);
        this.item = new PackBlockItem(this, new Item.Properties());
    }

    @Override
    public boolean canSustainPlant(@Nonnull BlockState state, @Nonnull BlockGetter level, @Nonnull BlockPos pos, @Nonnull Direction facing, @Nonnull IPlantable plantable) {
        if (plantable.getPlantType(level, pos) == PlantType.DESERT) {
            return true;
        }

        if (plantable.getPlantType(level, pos) == PlantType.BEACH) {
            for (Direction direction : Direction.Plane.HORIZONTAL) {
                boolean isWatered = level.getFluidState(pos.relative(direction)).is(FluidTags.WATER) || level.getBlockState(pos.relative(direction)).is(Blocks.FROSTED_ICE);
                if (isWatered) {
                    return true;
                }
            }
        }

        return false;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void randomTick(@Nonnull BlockState state, @Nonnull ServerLevel level, @Nonnull BlockPos pos, @Nonnull RandomSource random) {
        super.tick(state, level, pos, random);
        SnadBlock.growthBoost(level, pos, random);
    }

    private static void growthBoost(ServerLevel level, BlockPos pos, RandomSource random) {
        Block plant = level.getBlockState(pos.above()).getBlock();

        if (!plant.defaultBlockState().is(ModTagProvider.SNAD_PLANT)) {
            return;
        }

        boolean isSamePlant = true;
        int currentHeight = 1;

        while (isSamePlant) {
            BlockPos currentPos = pos.above(currentHeight);

            if (currentPos.getY() >= level.getMaxBuildHeight()) {
                isSamePlant = false;
                continue;
            }

            Block nextPlant = level.getBlockState(currentPos).getBlock();
            if (plant.defaultBlockState() == nextPlant.defaultBlockState()) {
                for (int i = 0; i < PackConfig.Snad.growthBooster; i++) {
                    //noinspection deprecation
                    nextPlant.randomTick(level.getBlockState(currentPos), level, currentPos, random);
                }
                currentHeight++;
                continue;
            }

            isSamePlant = false;
        }
    }

    @Override
    public int getDustColor(@Nonnull BlockState state, @Nonnull BlockGetter level, @Nonnull BlockPos pos) {
        return this.dustColor;
    }

    @Override
    public void registerAdditional(RegistrationContext ctx, EntryCollector builder) {
        builder.register(Registries.ITEM, this.item);
    }

    @Override
    public void initTracking(RegistrationContext ctx, TrackingCollector builder) throws ReflectiveOperationException {
        builder.track(ForgeRegistries.ITEMS, SnadBlock.class.getDeclaredField("item"));
    }

    @Override
    public Stream<ItemStack> makeCreativeTabStacks() {
        return Stream.of(new ItemStack(this));
    }

    @Override
    public boolean isEnabled(@Nonnull FeatureFlagSet enabledFeatures) {
        return this.modpacks.contains(PackConfig.modpack);
    }
}
