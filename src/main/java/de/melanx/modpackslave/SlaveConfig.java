package de.melanx.modpackslave;

import org.moddingx.libx.annotation.config.RegisterConfig;
import org.moddingx.libx.config.Config;

@RegisterConfig
public class SlaveConfig {

    @Config("The modpack you want to load content for. You should not edit this if you downloaded an existing modpack!")
    public static Modpack modpack = Modpack.CAVESTONE;
}
