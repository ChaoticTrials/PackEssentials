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
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.registries.ForgeRegistries;
import org.moddingx.libx.creativetab.CreativeTabItemProvider;
import org.moddingx.libx.registration.Registerable;
import org.moddingx.libx.registration.RegistrationContext;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Set;
import java.util.stream.Stream;

public class SnadBlock extends FallingBlock implements Registerable, FeatureElement, CreativeTabItemProvider {

    public static final int MAX_FERTILIZER_LEVEL = 3;
    public static final IntegerProperty FERTILIZER = IntegerProperty.create("fertilizer", 0, MAX_FERTILIZER_LEVEL);
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
        SnadBlock.decreaseFertilizerLevel(level, pos, random);
    }

    @Override
    protected void createBlockStateDefinition(@Nonnull StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FERTILIZER);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(@Nonnull BlockPlaceContext context) {
        BlockState state = this.defaultBlockState();
        state.setValue(FERTILIZER, 0);
        return state;
    }

    private static void growthBoost(ServerLevel level, BlockPos pos, RandomSource random) {
        BlockState plant = level.getBlockState(pos.above());

        if (!plant.is(ModTagProvider.SNAD_PLANT)) {
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
            if (plant.is(nextPlant)) {
                for (int i = 0; i < PackConfig.Snad.growthBooster + level.getBlockState(pos).getValue(FERTILIZER); i++) {
                    //noinspection deprecation
                    nextPlant.randomTick(level.getBlockState(currentPos), level, currentPos, random);
                }
                currentHeight++;
                continue;
            }

            isSamePlant = false;
        }
    }

    private static void decreaseFertilizerLevel(ServerLevel level, BlockPos pos, RandomSource random) {
        BlockState state = level.getBlockState(pos);
        int fertilizer = state.getValue(FERTILIZER);
        if (fertilizer > MAX_FERTILIZER_LEVEL || fertilizer < 0) {
            throw new IllegalStateException("Invalid fertilizer value: " + fertilizer);
        }

        if (fertilizer == 0 || random.nextDouble() > PackConfig.Snad.decreaseFertilizationChance) {
            return;
        }

        level.setBlock(pos, state.setValue(FERTILIZER, --fertilizer), Block.UPDATE_ALL_IMMEDIATE);
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
