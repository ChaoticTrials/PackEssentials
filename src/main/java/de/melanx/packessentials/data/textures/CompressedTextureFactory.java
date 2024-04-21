package de.melanx.packessentials.data.textures;

import de.melanx.packessentials.PackEssentials;
import de.melanx.packessentials.base.block.CompressedBlock;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.moddingx.libx.datagen.provider.texture.TextureBuilder;
import org.moddingx.libx.datagen.provider.texture.TextureFactory;
import org.moddingx.libx.datagen.provider.texture.TextureHelper;
import org.moddingx.libx.datagen.provider.texture.Textures;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;

public class CompressedTextureFactory implements TextureFactory {

    private static final ExistingFileHelper.ResourceType TEXTURE = new ExistingFileHelper.ResourceType(PackType.CLIENT_RESOURCES, ".png", "textures");
    private final ResourceLocation darker;
    private final ResourceLocation source;
    private final ExistingFileHelper fileHelper;
    private final int compressionLevel;

    public CompressedTextureFactory(CompressedBlock block, ExistingFileHelper fileHelper) {
        ResourceLocation resource = PackEssentials.getInstance().resource("block/" + ForgeRegistries.BLOCKS.getKey(block).getPath());
        this.darker = resource;
        this.source = new ResourceLocation(ForgeRegistries.BLOCKS.getKey(block.getBaseBlock()).getNamespace(), "block/" + ForgeRegistries.BLOCKS.getKey(block.getBaseBlock()).getPath());
        this.fileHelper = fileHelper;
        this.compressionLevel = block.getCompression();
    }

    @Override
    public Dimension getSize() {
        return new Dimension(16, 16);
    }

    @Override
    public void addTextures(TextureBuilder builder) {
        builder.addTexture(this.source, 16);
        builder.addFakeTexture(this.source, this.source, this::setDarker);
    }

    @Override
    public void generate(BufferedImage image, Textures textures) {
        TextureHelper.copyImage(image, textures, this.source, 0, 0, 16, 16, 0, 0);
        this.fileHelper.trackGenerated(this.darker, TEXTURE);
    }

    private BufferedImage setDarker(BufferedImage image) {
        BufferedImage dest = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());

        int centerX = image.getWidth() / 2;
        int centerY = image.getHeight() / 2;
        int maxDistance = (int) Math.sqrt(centerX * centerX + centerY * centerY);

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                Color color = new Color(image.getRGB(x, y));

                int distance = (int) Math.sqrt((centerX - x) * (centerX - x) + (centerY - y) * (centerY - y));
                float compression = (float) this.compressionLevel / CompressedBlock.MAX_COMPRESSION;
                float brightness = 1 - compression - (((float) distance / maxDistance) * compression);
                int r = (int) (color.getRed() * brightness);
                int g = (int) (color.getGreen() * brightness);
                int b = (int) (color.getBlue() * brightness);

                dest.setRGB(x, y, new Color(r, g, b).getRGB());
            }
        }

        return dest;
    }

//    private BufferedImage setDarker(BufferedImage image) {
//        BufferedImage dest = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
//        for (int x = 0; x < image.getWidth(); x++) {
//            for (int y = 0; y < image.getHeight(); y++) {
//                Color color = new Color(image.getRGB(x, y));
//                int r = (int) (color.getRed() * (1 - (float) this.compressionLevel / CompressedBlock.MAX_COMPRESSION));
//                int g = (int) (color.getGreen() * (1 - (float) this.compressionLevel / CompressedBlock.MAX_COMPRESSION));
//                int b = (int) (color.getBlue() * (1 - (float) this.compressionLevel / CompressedBlock.MAX_COMPRESSION));
//
//                dest.setRGB(x, y, new Color(r, g, b).getRGB());
//            }
//        }
//
//        return dest;
//    }
}
