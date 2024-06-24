package de.melanx.packessentials.data;

import de.melanx.packessentials.PackEssentials;
import de.melanx.packessentials.base.block.CompressedBlock;
import de.melanx.packessentials.blocks.SnadBlock;
import de.melanx.packessentials.items.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
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
    public static final TagKey<Item> BURIED_MOBS = TagKey.create(Registries.ITEM, PackEssentials.getInstance().resource("buried_mobs"));
    public static final TagKey<Item> COMMON_BURIED_MOBS = TagKey.create(Registries.ITEM, PackEssentials.getInstance().resource("buried_mobs/common"));
    public static final TagKey<Item> UNCOMMON_BURIED_MOBS = TagKey.create(Registries.ITEM, PackEssentials.getInstance().resource("buried_mobs/uncommon"));
    public static final TagKey<Item> RARE_BURIED_MOBS = TagKey.create(Registries.ITEM, PackEssentials.getInstance().resource("buried_mobs/rare"));
    public static final TagKey<Item> EPIC_BURIED_MOBS = TagKey.create(Registries.ITEM, PackEssentials.getInstance().resource("buried_mobs/epic"));

    @Override
    public void setup() {
        this.block(SNAD_PLANT).add(Blocks.CACTUS).add(Blocks.SUGAR_CANE).add(Blocks.BAMBOO).add(Blocks.BAMBOO_SAPLING);
        this.block(COMPOSTER_GROWABLE).add(Blocks.SWEET_BERRY_BUSH).addTag(BlockTags.CROPS).add(Blocks.KELP, Blocks.SEAGRASS);

        //noinspection unchecked
        this.item(BURIED_MOBS).addTags(COMMON_BURIED_MOBS, UNCOMMON_BURIED_MOBS, RARE_BURIED_MOBS, EPIC_BURIED_MOBS);
        this.item(COMMON_BURIED_MOBS).add(ModItems.buriedChicken, ModItems.buriedCod, ModItems.buriedCow,
                ModItems.buriedPig, ModItems.buriedSalmon, ModItems.buriedSheep, ModItems.buriedSquid);
        this.item(UNCOMMON_BURIED_MOBS).add(ModItems.buriedCat, ModItems.buriedFox, ModItems.buriedGlowSquid,
                ModItems.buriedGoat, ModItems.buriedOcelot, ModItems.buriedPufferfish, ModItems.buriedRabbit,
                ModItems.buriedTadpole, ModItems.buriedTropicalFish, ModItems.buriedWolf);
        this.item(RARE_BURIED_MOBS).add(ModItems.buriedAxolotl, ModItems.buriedCamel, ModItems.buriedDonkey,
                ModItems.buriedDolphin, ModItems.buriedHorse, ModItems.buriedLlama, ModItems.buriedMule,
                ModItems.buriedPanda, ModItems.buriedParrot, ModItems.buriedPolarBear, ModItems.buriedStrider);
        this.item(EPIC_BURIED_MOBS).add(ModItems.buriedAllay, ModItems.buriedMooshroom);
    }

    @Override
    public void defaultBlockTags(Block block) {
        if (block instanceof SnadBlock) {
            this.block(BlockTags.MINEABLE_WITH_SHOVEL).add(block);
            return;
        }

        if (block instanceof CompressedBlock compressedBlock &&
                (compressedBlock.getBaseBlock() == Blocks.GRAVEL ||
                        compressedBlock.getBaseBlock() == Blocks.SAND)) {
            this.block(BlockTags.MINEABLE_WITH_SHOVEL).add(block);
            return;
        }

        this.block(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
    }
}
