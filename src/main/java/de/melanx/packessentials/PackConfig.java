package de.melanx.packessentials;

import org.moddingx.libx.annotation.config.RegisterConfig;
import org.moddingx.libx.config.Config;
import org.moddingx.libx.config.Group;
import org.moddingx.libx.config.validate.DoubleRange;
import org.moddingx.libx.config.validate.IntRange;

@RegisterConfig
public class PackConfig {

    @Config("The modpack you want to load content for. You should not edit this if you downloaded an existing modpack!")
    public static Modpack modpack = Modpack.CAVESTONE;

    @Config("The chance for putting a crop near a full composter")
    @DoubleRange(min = 0, max = 1)
    public static double composterSpreading = 0.05;

    @Config({"The chance for an open fridge to generate some snow layers each second",
            "Requires 'Cooking for Blockheads' to be loaded"})
    @DoubleRange(min = 0, max = 1)
    public static double snowChance = 0.001;

    @Group("Remove annoying toasts")
    public static class Toasts {

        @Config
        public static boolean disableAdvancementToasts = false;

        @Config
        public static boolean disableRecipeToasts = false;

        @Config
        public static boolean disableSystemToasts = false;

        @Config
        public static boolean disableTutorialToasts = true;
    }

    @Group
    public static class Snad {

        @Config({"The amount of extra random ticks each tick.",
                "This is extra to the fertilization level."})
        @IntRange(min = 1, max = 50)
        public static int growthBooster = 1;

        @Config("The chance to decrease the fertilization of Snad")
        @DoubleRange(min = 0, max = 1)
        public static double decreaseFertilizationChance = 0.05;
    }

    @Group
    public static class BuriedMobs {

        @Config
        @DoubleRange(min = 0, max = 1)
        public static double minChance = 0.05;

        @Config
        @DoubleRange(min = 0, max = 1)
        public static double maxChance = 0.1;
    }
}
