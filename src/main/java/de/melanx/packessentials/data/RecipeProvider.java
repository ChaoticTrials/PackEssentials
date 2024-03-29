package de.melanx.packessentials.data;

import de.melanx.packessentials.blocks.ModBlocks;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import org.moddingx.libx.datagen.DatagenContext;
import org.moddingx.libx.datagen.provider.recipe.RecipeProviderBase;
import org.moddingx.libx.datagen.provider.recipe.crafting.CompressionExtension;
import org.moddingx.libx.datagen.provider.recipe.crafting.CraftingExtension;

public class RecipeProvider extends RecipeProviderBase implements CompressionExtension, CraftingExtension {

    public RecipeProvider(DatagenContext ctx) {
        super(ctx);
    }

    @Override
    protected void setup() {
        this.compress(Blocks.COBBLESTONE, ModBlocks.compressedCobblestone);
        this.compress(Blocks.COBBLED_DEEPSLATE, ModBlocks.compressedCobbledDeepslate);

        this.compress(ModBlocks.compressedCobblestone, ModBlocks.doubleCompressedCobblestone);
        this.compress(ModBlocks.compressedCobbledDeepslate, ModBlocks.doubleCompressedCobbledDeepslate);

        this.snad(Ingredient.of(Tags.Items.SAND_COLORLESS), ModBlocks.snad);
        this.snad(Ingredient.of(Tags.Items.SAND_RED), ModBlocks.redSnad);
    }

    private void snad(Ingredient base, ItemLike snad) {
        this.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(snad, 2), "SB", "BS", 'B', Items.BONE_MEAL, 'S', base);
    }
}
