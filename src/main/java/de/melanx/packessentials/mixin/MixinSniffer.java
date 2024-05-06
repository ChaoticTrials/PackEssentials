package de.melanx.packessentials.mixin;

import de.melanx.packessentials.PackLootContextParamSets;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.animal.sniffer.Sniffer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Sniffer.class)
public class MixinSniffer {

    @Redirect(
            method = "dropSeed",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/storage/loot/LootTable;getRandomItems(Lnet/minecraft/world/level/storage/loot/LootParams;)Lit/unimi/dsi/fastutil/objects/ObjectArrayList;")
    )
    public ObjectArrayList<ItemStack> dropSeed(LootTable lootTable, LootParams params) {
        Sniffer sniffer = (Sniffer) (Object) this;
        ServerLevel level = (ServerLevel) sniffer.level();
        LootParams.Builder builder = new LootParams.Builder(level);
        LootParams lootParams = builder.withParameter(LootContextParams.ORIGIN, sniffer.getHeadPosition())
                .withParameter(LootContextParams.THIS_ENTITY, sniffer)
                .withParameter(LootContextParams.BLOCK_STATE, level.getBlockState(sniffer.getHeadBlock().below()))
                .create(PackLootContextParamSets.LOCATED_GIFT);

        return lootTable.getRandomItems(lootParams);
    }
}
