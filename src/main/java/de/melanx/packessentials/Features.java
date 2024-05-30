package de.melanx.packessentials;

import java.util.Set;

public class Features {

    public static Set<Modpack> COMPOSTER = Set.of(Modpack.CAVESTONE);
    public static Set<Modpack> FRIDGE_FOR_SNOW = Set.of(Modpack.CAVESTONE);

    public static boolean isEnabled(Set<Modpack> modpacks) {
        return modpacks.contains(PackConfig.modpack);
    }
}
