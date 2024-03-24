package de.melanx.modpackslave.data;

import de.melanx.modpackslave.blocks.ModBlocks;
import net.minecraft.world.level.block.Blocks;
import org.moddingx.libx.datagen.DatagenContext;
import org.moddingx.libx.datagen.provider.recipe.RecipeProviderBase;
import org.moddingx.libx.datagen.provider.recipe.crafting.CompressionExtension;

public class RecipeProvider extends RecipeProviderBase implements CompressionExtension {

    public RecipeProvider(DatagenContext ctx) {
        super(ctx);
    }

    @Override
    protected void setup() {
        this.compress(Blocks.COBBLESTONE, ModBlocks.compressedCobblestone);
        this.compress(Blocks.COBBLED_DEEPSLATE, ModBlocks.compressedCobbledDeepslate);

        this.compress(ModBlocks.compressedCobblestone, ModBlocks.doubleCompressedCobblestone);
        this.compress(ModBlocks.compressedCobbledDeepslate, ModBlocks.doubleCompressedCobbledDeepslate);
    }
}
