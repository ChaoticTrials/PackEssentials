package de.melanx.packessentials.data.textures;

import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.moddingx.libx.datagen.provider.texture.*;

import java.awt.Dimension;
import java.awt.image.BufferedImage;

public class FlipTextureFactory implements TextureFactory {

    private static final ExistingFileHelper.ResourceType TEXTURE = new ExistingFileHelper.ResourceType(PackType.CLIENT_RESOURCES, ".png", "textures");
    private final ResourceLocation flipped;
    private final ResourceLocation source;
    private final ExistingFileHelper fileHelper;

    public FlipTextureFactory(ResourceLocation flipped, ResourceLocation source, ExistingFileHelper fileHelper) {
        this.flipped = flipped;
        this.source = source;
        this.fileHelper = fileHelper;
    }

    @Override
    public Dimension getSize() {
        return new Dimension(16, 16);
    }

    @Override
    public void addTextures(TextureBuilder builder) {
        builder.addTexture(this.source, 16);
        builder.addFakeTexture(this.source, this.source, img -> ImageTransforms.flip(img, Direction.Axis.X));
    }

    @Override
    public void generate(BufferedImage image, Textures textures) {
        TextureHelper.copyImage(image, textures, this.source, 0, 0, 16, 16, 0, 0);
        this.fileHelper.trackGenerated(this.flipped, TEXTURE);
    }
}
