package de.melanx.modpackslave.data;

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
}
