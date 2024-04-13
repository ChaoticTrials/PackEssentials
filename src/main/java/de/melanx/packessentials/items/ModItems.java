package de.melanx.packessentials.items;

import de.melanx.packessentials.Modpack;
import de.melanx.packessentials.PackEssentials;
import net.minecraft.world.item.Item;
import org.moddingx.libx.annotation.registration.RegisterClass;

@RegisterClass(registry = "ITEMS")
public class ModItems {

    public static final Item snadFertilizer = new SnadFertilizerItem(PackEssentials.getInstance(), new Item.Properties(), Modpack.CAVESTONE);
}
