package de.melanx.packessentials.data;

import de.melanx.packessentials.items.BuriedMobItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import org.moddingx.libx.datagen.DatagenContext;
import org.moddingx.libx.datagen.provider.model.ItemModelProviderBase;

public class ItemModelProvider extends ItemModelProviderBase {

    public ItemModelProvider(DatagenContext ctx) {
        super(ctx);
    }

    @Override
    protected void setup() {
        // NO-OP
    }

    @Override
    protected void defaultItem(ResourceLocation id, Item item) {
        if (item instanceof BuriedMobItem<?>) {
            this.withExistingParent(id.getPath(), this.modLoc("item/buried_mob_template"));
            return;
        }

        super.defaultItem(id, item);
    }
}
