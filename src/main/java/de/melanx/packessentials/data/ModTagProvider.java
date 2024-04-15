package de.melanx.packessentials.data;

import de.melanx.packessentials.PackEssentials;
import de.melanx.packessentials.blocks.SnadBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.moddingx.libx.datagen.DatagenContext;
import org.moddingx.libx.datagen.provider.tags.CommonTagsProviderBase;

public class ModTagProvider extends CommonTagsProviderBase {

    public ModTagProvider(DatagenContext ctx) {
        super(ctx);
    }

    public static final TagKey<Block> SNAD_PLANT = TagKey.create(Registries.BLOCK, PackEssentials.getInstance().resource("snad_plant"));
    public static final TagKey<Block> COMPOSTER_GROWABLE = TagKey.create(Registries.BLOCK, PackEssentials.getInstance().resource("composter_growable"));

    @Override
    public void setup() {
        this.block(SNAD_PLANT).add(Blocks.CACTUS).add(Blocks.SUGAR_CANE).add(Blocks.BAMBOO).add(Blocks.BAMBOO_SAPLING);
        this.block(COMPOSTER_GROWABLE).add(Blocks.SWEET_BERRY_BUSH).addTag(BlockTags.CROPS).add(Blocks.KELP, Blocks.SEAGRASS);
    }

    @Override
    public void defaultBlockTags(Block block) {
        if (block instanceof SnadBlock) {
            this.block(BlockTags.MINEABLE_WITH_SHOVEL).add(block);
            return;
        }

        this.block(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
    }
}
