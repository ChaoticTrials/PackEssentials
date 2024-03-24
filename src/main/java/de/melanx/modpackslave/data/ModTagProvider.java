package de.melanx.modpackslave.data;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import org.moddingx.libx.datagen.DatagenContext;
import org.moddingx.libx.datagen.provider.tags.CommonTagsProviderBase;

public class ModTagProvider extends CommonTagsProviderBase {

    public ModTagProvider(DatagenContext ctx) {
        super(ctx);
    }

    @Override
    public void setup() {
        // NO-OP
    }

    @Override
    public void defaultBlockTags(Block block) {
        this.block(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
    }
}
