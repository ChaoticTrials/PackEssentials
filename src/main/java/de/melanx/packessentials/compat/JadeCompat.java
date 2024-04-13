package de.melanx.packessentials.compat;

import de.melanx.packessentials.blocks.SnadBlock;
import de.melanx.packessentials.compat.jade.SnadProvider;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

@WailaPlugin
public class JadeCompat implements IWailaPlugin {

    @Override
    public void registerClient(IWailaClientRegistration registration) {
        registration.registerBlockComponent(SnadProvider.INSTANCE, SnadBlock.class);
    }
}
