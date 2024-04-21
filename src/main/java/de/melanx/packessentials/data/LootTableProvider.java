package de.melanx.packessentials.data;

import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.InfestedBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import org.moddingx.libx.datagen.DatagenContext;
import org.moddingx.libx.datagen.provider.loot.BlockLootProviderBase;

import javax.annotation.Nullable;

public class LootTableProvider extends BlockLootProviderBase {

    protected static final LootItemCondition.Builder HAS_SILK_TOUCH = MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))));

    public LootTableProvider(DatagenContext ctx) {
        super(ctx);
    }

    @Override
    protected void setup() {
        // NO-OP
    }

    @Nullable
    @Override
    protected LootTable.Builder defaultBehavior(Block block) {
        if (block instanceof InfestedBlock) {
            return LootTable.lootTable().withPool(LootPool.lootPool()
                    .when(LootTableProvider.HAS_SILK_TOUCH)
                    .setRolls(ConstantValue.exactly(1.0F))
                    .add(LootItem.lootTableItem(block)));
        }

        return super.defaultBehavior(block);
    }
}
