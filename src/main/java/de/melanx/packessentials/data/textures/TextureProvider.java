package de.melanx.packessentials.data.textures;

import de.melanx.packessentials.PackEssentials;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.moddingx.libx.datagen.DatagenContext;
import org.moddingx.libx.datagen.provider.texture.TextureProviderBase;

public class TextureProvider extends TextureProviderBase {

    private final ExistingFileHelper fileHelper;

    public TextureProvider(DatagenContext ctx) {
        super(ctx);
        this.fileHelper = ctx.fileHelper();
    }

    @Override
    public void setup() {
        ResourceLocation sand = new ResourceLocation("minecraft", "block/sand");
        ResourceLocation redSand = new ResourceLocation("minecraft", "block/red_sand");
        ResourceLocation snad = PackEssentials.getInstance().resource("block/snad");
        ResourceLocation redSnad = PackEssentials.getInstance().resource("block/red_snad");

        this.texture(snad, new FlipTextureFactory(snad, sand, this.fileHelper));
        this.texture(redSnad, new FlipTextureFactory(redSnad, redSand, this.fileHelper));
    }
}
