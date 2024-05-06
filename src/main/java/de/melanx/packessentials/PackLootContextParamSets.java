package de.melanx.packessentials;

import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;

public class PackLootContextParamSets {

    public static final LootContextParamSet LOCATED_GIFT = LootContextParamSets.register(PackEssentials.getInstance().modid + ":located_gift", builder -> {
        builder.required(LootContextParams.THIS_ENTITY).required(LootContextParams.THIS_ENTITY).optional(LootContextParams.BLOCK_STATE);
    });
}
