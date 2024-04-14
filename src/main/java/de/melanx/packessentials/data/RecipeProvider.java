package de.melanx.packessentials.data;

import de.melanx.packessentials.blocks.ModBlocks;
import de.melanx.packessentials.items.ModItems;
import net.minecraft.Util;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;
import org.moddingx.libx.datagen.DatagenContext;
import org.moddingx.libx.datagen.provider.recipe.RecipeProviderBase;
import org.moddingx.libx.datagen.provider.recipe.crafting.CompressionExtension;
import org.moddingx.libx.datagen.provider.recipe.crafting.CraftingExtension;

import java.util.HashMap;
import java.util.Map;

public class RecipeProvider extends RecipeProviderBase implements CompressionExtension, CraftingExtension {

    private static final Map<SlabBlock, Block> SLAB_TO_BLOCK = Util.make(() -> {
                Map<SlabBlock, Block> map = new HashMap<>();
                map.put((SlabBlock) Blocks.PRISMARINE_SLAB, Blocks.PRISMARINE);
                map.put((SlabBlock) Blocks.PRISMARINE_BRICK_SLAB, Blocks.PRISMARINE_BRICKS);
                map.put((SlabBlock) Blocks.DARK_PRISMARINE_SLAB, Blocks.DARK_PRISMARINE);
                map.put((SlabBlock) Blocks.OAK_SLAB, Blocks.OAK_PLANKS);
                map.put((SlabBlock) Blocks.SPRUCE_SLAB, Blocks.SPRUCE_PLANKS);
                map.put((SlabBlock) Blocks.BIRCH_SLAB, Blocks.BIRCH_PLANKS);
                map.put((SlabBlock) Blocks.JUNGLE_SLAB, Blocks.JUNGLE_PLANKS);
                map.put((SlabBlock) Blocks.ACACIA_SLAB, Blocks.ACACIA_PLANKS);
                map.put((SlabBlock) Blocks.CHERRY_SLAB, Blocks.CHERRY_PLANKS);
                map.put((SlabBlock) Blocks.DARK_OAK_SLAB, Blocks.DARK_OAK_PLANKS);
                map.put((SlabBlock) Blocks.MANGROVE_SLAB, Blocks.MANGROVE_PLANKS);
                map.put((SlabBlock) Blocks.BAMBOO_SLAB, Blocks.BAMBOO);
                map.put((SlabBlock) Blocks.BAMBOO_MOSAIC_SLAB, Blocks.BAMBOO_MOSAIC);
                map.put((SlabBlock) Blocks.STONE_SLAB, Blocks.STONE);
                map.put((SlabBlock) Blocks.SMOOTH_STONE_SLAB, Blocks.SMOOTH_STONE);
                map.put((SlabBlock) Blocks.SANDSTONE_SLAB, Blocks.SANDSTONE);
                map.put((SlabBlock) Blocks.CUT_SANDSTONE_SLAB, Blocks.CUT_SANDSTONE);
                map.put((SlabBlock) Blocks.COBBLESTONE_SLAB, Blocks.COBBLESTONE);
                map.put((SlabBlock) Blocks.BRICK_SLAB, Blocks.BRICKS);
                map.put((SlabBlock) Blocks.STONE_BRICK_SLAB, Blocks.STONE_BRICKS);
                map.put((SlabBlock) Blocks.MUD_BRICK_SLAB, Blocks.MUD_BRICKS);
                map.put((SlabBlock) Blocks.NETHER_BRICK_SLAB, Blocks.NETHER_BRICKS);
                map.put((SlabBlock) Blocks.QUARTZ_SLAB, Blocks.QUARTZ_BLOCK);
                map.put((SlabBlock) Blocks.RED_SANDSTONE_SLAB, Blocks.RED_SANDSTONE);
                map.put((SlabBlock) Blocks.CUT_RED_SANDSTONE_SLAB, Blocks.CUT_RED_SANDSTONE);
                map.put((SlabBlock) Blocks.PURPUR_SLAB, Blocks.PURPUR_BLOCK);
                map.put((SlabBlock) Blocks.POLISHED_GRANITE_SLAB, Blocks.POLISHED_GRANITE);
                map.put((SlabBlock) Blocks.SMOOTH_RED_SANDSTONE_SLAB, Blocks.SMOOTH_RED_SANDSTONE);
                map.put((SlabBlock) Blocks.MOSSY_STONE_BRICK_SLAB, Blocks.MOSSY_STONE_BRICKS);
                map.put((SlabBlock) Blocks.POLISHED_DIORITE_SLAB, Blocks.POLISHED_DIORITE);
                map.put((SlabBlock) Blocks.MOSSY_COBBLESTONE_SLAB, Blocks.MOSSY_COBBLESTONE);
                map.put((SlabBlock) Blocks.END_STONE_BRICK_SLAB, Blocks.END_STONE_BRICKS);
                map.put((SlabBlock) Blocks.SMOOTH_SANDSTONE_SLAB, Blocks.SMOOTH_SANDSTONE);
                map.put((SlabBlock) Blocks.SMOOTH_QUARTZ_SLAB, Blocks.SMOOTH_QUARTZ);
                map.put((SlabBlock) Blocks.GRANITE_SLAB, Blocks.GRANITE);
                map.put((SlabBlock) Blocks.ANDESITE_SLAB, Blocks.ANDESITE);
                map.put((SlabBlock) Blocks.RED_NETHER_BRICK_SLAB, Blocks.RED_NETHER_BRICKS);
                map.put((SlabBlock) Blocks.POLISHED_ANDESITE_SLAB, Blocks.POLISHED_ANDESITE);
                map.put((SlabBlock) Blocks.DIORITE_SLAB, Blocks.DIORITE);
                map.put((SlabBlock) Blocks.CRIMSON_SLAB, Blocks.CRIMSON_PLANKS);
                map.put((SlabBlock) Blocks.WARPED_SLAB, Blocks.WARPED_PLANKS);
                map.put((SlabBlock) Blocks.BLACKSTONE_SLAB, Blocks.BLACKSTONE);
                map.put((SlabBlock) Blocks.POLISHED_BLACKSTONE_BRICK_SLAB, Blocks.POLISHED_BLACKSTONE_BRICKS);
                map.put((SlabBlock) Blocks.POLISHED_BLACKSTONE_SLAB, Blocks.POLISHED_BLACKSTONE);
                map.put((SlabBlock) Blocks.OXIDIZED_CUT_COPPER_SLAB, Blocks.OXIDIZED_CUT_COPPER);
                map.put((SlabBlock) Blocks.WEATHERED_CUT_COPPER_SLAB, Blocks.WEATHERED_CUT_COPPER);
                map.put((SlabBlock) Blocks.EXPOSED_CUT_COPPER_SLAB, Blocks.EXPOSED_CUT_COPPER);
                map.put((SlabBlock) Blocks.CUT_COPPER_SLAB, Blocks.CUT_COPPER);
                map.put((SlabBlock) Blocks.WAXED_OXIDIZED_CUT_COPPER_SLAB, Blocks.WAXED_OXIDIZED_CUT_COPPER);
                map.put((SlabBlock) Blocks.WAXED_WEATHERED_CUT_COPPER_SLAB, Blocks.WAXED_WEATHERED_CUT_COPPER);
                map.put((SlabBlock) Blocks.WAXED_EXPOSED_CUT_COPPER_SLAB, Blocks.WAXED_EXPOSED_CUT_COPPER);
                map.put((SlabBlock) Blocks.WAXED_CUT_COPPER_SLAB, Blocks.WAXED_CUT_COPPER);
                map.put((SlabBlock) Blocks.COBBLED_DEEPSLATE_SLAB, Blocks.COBBLED_DEEPSLATE);
                map.put((SlabBlock) Blocks.POLISHED_DEEPSLATE_SLAB, Blocks.POLISHED_DEEPSLATE);
                map.put((SlabBlock) Blocks.DEEPSLATE_TILE_SLAB, Blocks.DEEPSLATE_TILES);
                map.put((SlabBlock) Blocks.DEEPSLATE_BRICK_SLAB, Blocks.DEEPSLATE_BRICKS);
                return map;
            }
    );

    public RecipeProvider(DatagenContext ctx) {
        super(ctx);
    }

    @Override
    protected void setup() {
        this.compress(Blocks.COBBLESTONE, ModBlocks.compressedCobblestone);
        this.compress(Blocks.ANDESITE, ModBlocks.compressedAndesite);
        this.compress(Blocks.DIORITE, ModBlocks.compressedDiorite);
        this.compress(Blocks.GRANITE, ModBlocks.compressedGranite);
        this.compress(Blocks.COBBLED_DEEPSLATE, ModBlocks.compressedCobbledDeepslate);
        this.compress(Blocks.TUFF, ModBlocks.compressedTuff);
        this.compress(Blocks.NETHERRACK, ModBlocks.compressedNetherrack);

        this.compress(ModBlocks.compressedCobblestone, ModBlocks.doubleCompressedCobblestone);
        this.compress(ModBlocks.compressedAndesite, ModBlocks.doubleCompressedAndesite);
        this.compress(ModBlocks.compressedDiorite, ModBlocks.doubleCompressedDiorite);
        this.compress(ModBlocks.compressedGranite, ModBlocks.doubleCompressedGranite);
        this.compress(ModBlocks.compressedCobbledDeepslate, ModBlocks.doubleCompressedCobbledDeepslate);
        this.compress(ModBlocks.compressedTuff, ModBlocks.doubleCompressedTuff);
        this.compress(ModBlocks.compressedNetherrack, ModBlocks.doubleCompressedNetherrack);

        this.snad(Ingredient.of(Tags.Items.SAND_COLORLESS), ModBlocks.snad);
        this.snad(Ingredient.of(Tags.Items.SAND_RED), ModBlocks.redSnad);

        this.shaped(RecipeCategory.MISC, new ItemStack(ModItems.snadFertilizer, 3), "GGG", "GBG", "GGG", 'G', Ingredient.of(Items.GRASS, Items.FERN, Items.SEAGRASS), 'B', Items.BONE_MEAL);

        this.slabs();
    }

    private void snad(Ingredient base, ItemLike snad) {
        this.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(snad, 2), "SB", "BS", 'B', ModItems.snadFertilizer, 'S', base);
    }

    private void slabs() {
        for (SlabBlock slab : ForgeRegistries.BLOCKS.getValues().stream().filter(block -> block instanceof SlabBlock).map(block -> (SlabBlock) block).toList()) {
            Block block = SLAB_TO_BLOCK.get(slab);

            if (slab == Blocks.PETRIFIED_OAK_SLAB) {
                continue;
            }

            if (block == null) {
                throw new RuntimeException("Missing slab entry for crafting recipe: " + slab);
            }

            ResourceLocation id = this.loc(block);
            this.shapeless(new ResourceLocation(id.getNamespace(), "slabs_to_block/" + id.getPath()), block, slab, slab);
        }
    }
}
