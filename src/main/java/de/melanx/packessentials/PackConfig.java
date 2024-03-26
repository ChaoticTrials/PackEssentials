package de.melanx.packessentials;

import org.moddingx.libx.annotation.config.RegisterConfig;
import org.moddingx.libx.config.Config;

@RegisterConfig
public class PackConfig {

    @Config("The modpack you want to load content for. You should not edit this if you downloaded an existing modpack!")
    public static Modpack modpack = Modpack.CAVESTONE;
}
