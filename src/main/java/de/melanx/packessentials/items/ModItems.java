package de.melanx.packessentials.items;

import de.melanx.packessentials.Modpack;
import de.melanx.packessentials.PackEssentials;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import org.moddingx.libx.annotation.registration.RegisterClass;

@RegisterClass(registry = "ITEMS")
public class ModItems {

    public static final Item ancientBrush = new AncientBrushItem(PackEssentials.getInstance(), new Item.Properties(), Modpack.CAVESTONE);
    public static final Item snadFertilizer = new SnadFertilizerItem(PackEssentials.getInstance(), new Item.Properties(), Modpack.CAVESTONE);

    public static final Item buriedAllay = new BuriedMobItem<>(PackEssentials.getInstance(), new Item.Properties(), EntityType.ALLAY, Modpack.CAVESTONE);
    public static final Item buriedAxolotl = new BuriedMobItem<>(PackEssentials.getInstance(), new Item.Properties(), EntityType.AXOLOTL, Modpack.CAVESTONE);
    public static final Item buriedCamel = new BuriedMobItem<>(PackEssentials.getInstance(), new Item.Properties(), EntityType.CAMEL, Modpack.CAVESTONE);
    public static final Item buriedCat = new BuriedMobItem<>(PackEssentials.getInstance(), new Item.Properties(), EntityType.CAT, Modpack.CAVESTONE);
    public static final Item buriedChicken = new BuriedMobItem<>(PackEssentials.getInstance(), new Item.Properties(), EntityType.CHICKEN, Modpack.CAVESTONE);
    public static final Item buriedCod = new BuriedMobItem<>(PackEssentials.getInstance(), new Item.Properties(), EntityType.COD, Modpack.CAVESTONE);
    public static final Item buriedCow = new BuriedMobItem<>(PackEssentials.getInstance(), new Item.Properties(), EntityType.COW, Modpack.CAVESTONE);
    public static final Item buriedDonkey = new BuriedMobItem<>(PackEssentials.getInstance(), new Item.Properties(), EntityType.DONKEY, Modpack.CAVESTONE);
    public static final Item buriedDolphin = new BuriedMobItem<>(PackEssentials.getInstance(), new Item.Properties(), EntityType.DOLPHIN, Modpack.CAVESTONE);
    public static final Item buriedFox = new BuriedMobItem<>(PackEssentials.getInstance(), new Item.Properties(), EntityType.FOX, Modpack.CAVESTONE);
    public static final Item buriedGlowSquid = new BuriedMobItem<>(PackEssentials.getInstance(), new Item.Properties(), EntityType.GLOW_SQUID, Modpack.CAVESTONE);
    public static final Item buriedGoat = new BuriedMobItem<>(PackEssentials.getInstance(), new Item.Properties(), EntityType.GOAT, Modpack.CAVESTONE);
    public static final Item buriedHorse = new BuriedMobItem<>(PackEssentials.getInstance(), new Item.Properties(), EntityType.HORSE, Modpack.CAVESTONE);
    public static final Item buriedLlama = new BuriedMobItem<>(PackEssentials.getInstance(), new Item.Properties(), EntityType.LLAMA, Modpack.CAVESTONE);
    public static final Item buriedMooshroom = new BuriedMobItem<>(PackEssentials.getInstance(), new Item.Properties(), EntityType.MOOSHROOM, Modpack.CAVESTONE);
    public static final Item buriedMule = new BuriedMobItem<>(PackEssentials.getInstance(), new Item.Properties(), EntityType.MULE, Modpack.CAVESTONE);
    public static final Item buriedOcelot = new BuriedMobItem<>(PackEssentials.getInstance(), new Item.Properties(), EntityType.OCELOT, Modpack.CAVESTONE);
    public static final Item buriedPanda = new BuriedMobItem<>(PackEssentials.getInstance(), new Item.Properties(), EntityType.PANDA, Modpack.CAVESTONE);
    public static final Item buriedParrot = new BuriedMobItem<>(PackEssentials.getInstance(), new Item.Properties(), EntityType.PARROT, Modpack.CAVESTONE);
    public static final Item buriedPig = new BuriedMobItem<>(PackEssentials.getInstance(), new Item.Properties(), EntityType.PIG, Modpack.CAVESTONE);
    public static final Item buriedPolarBear = new BuriedMobItem<>(PackEssentials.getInstance(), new Item.Properties(), EntityType.POLAR_BEAR, Modpack.CAVESTONE);
    public static final Item buriedPufferfish = new BuriedMobItem<>(PackEssentials.getInstance(), new Item.Properties(), EntityType.PUFFERFISH, Modpack.CAVESTONE);
    public static final Item buriedRabbit = new BuriedMobItem<>(PackEssentials.getInstance(), new Item.Properties(), EntityType.RABBIT, Modpack.CAVESTONE);
    public static final Item buriedSalmon = new BuriedMobItem<>(PackEssentials.getInstance(), new Item.Properties(), EntityType.SALMON, Modpack.CAVESTONE);
    public static final Item buriedSheep = new BuriedMobItem<>(PackEssentials.getInstance(), new Item.Properties(), EntityType.SHEEP, Modpack.CAVESTONE);
    public static final Item buriedSquid = new BuriedMobItem<>(PackEssentials.getInstance(), new Item.Properties(), EntityType.SQUID, Modpack.CAVESTONE);
    public static final Item buriedStrider = new BuriedMobItem<>(PackEssentials.getInstance(), new Item.Properties(), EntityType.STRIDER, Modpack.CAVESTONE);
    public static final Item buriedTadpole = new BuriedMobItem<>(PackEssentials.getInstance(), new Item.Properties(), EntityType.TADPOLE, Modpack.CAVESTONE);
    public static final Item buriedTropicalFish = new BuriedMobItem<>(PackEssentials.getInstance(), new Item.Properties(), EntityType.TROPICAL_FISH, Modpack.CAVESTONE);
    public static final Item buriedWolf = new BuriedMobItem<>(PackEssentials.getInstance(), new Item.Properties(), EntityType.WOLF, Modpack.CAVESTONE);
}
