package de.melanx.packessentials.data;

import org.moddingx.libx.datagen.DatagenContext;
import org.moddingx.libx.datagen.provider.loot.BlockLootProviderBase;

public class LootTableProvider extends BlockLootProviderBase {

    public LootTableProvider(DatagenContext ctx) {
        super(ctx);
    }

    @Override
    protected void setup() {
        // NO-OP
    }
}
