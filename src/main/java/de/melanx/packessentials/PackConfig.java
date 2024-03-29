package de.melanx.packessentials;

import org.moddingx.libx.annotation.config.RegisterConfig;
import org.moddingx.libx.config.Config;
import org.moddingx.libx.config.Group;
import org.moddingx.libx.config.validate.IntRange;

@RegisterConfig
public class PackConfig {

    @Config("The modpack you want to load content for. You should not edit this if you downloaded an existing modpack!")
    public static Modpack modpack = Modpack.CAVESTONE;

    @Group
    public static class Snad {

        @Config("The amount of extra random ticks each tick.")
        @IntRange(min = 1, max = 50)
        public static int growthBooster = 3;
    }
}
