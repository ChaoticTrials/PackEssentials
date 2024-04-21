package de.melanx.packessentials.data;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.InfestedBlock;
import net.minecraftforge.client.model.generators.ModelFile;
import org.moddingx.libx.datagen.DatagenContext;
import org.moddingx.libx.datagen.provider.model.BlockStateProviderBase;

public class BlockStateProvider extends BlockStateProviderBase {

    public BlockStateProvider(DatagenContext ctx) {
        super(ctx);
    }

    @Override
    protected void setup() {
        // NO-OP
    }

    @Override
    protected ModelFile defaultModel(ResourceLocation id, Block block) {
        if (block instanceof InfestedBlock infested) {
            return this.models().cubeAll(id.getPath(), this.blockTexture(infested.getHostBlock()));
        }

        return super.defaultModel(id, block);
    }
}
