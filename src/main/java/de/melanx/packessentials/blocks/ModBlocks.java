package de.melanx.packessentials.blocks;

import de.melanx.packessentials.Modpack;
import de.melanx.packessentials.PackEssentials;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.moddingx.libx.annotation.registration.RegisterClass;

@RegisterClass(registry = "BLOCKS", priority = 1)
public class ModBlocks {

    public static final Block compressedCobblestone = new CompressedBlock(PackEssentials.getInstance(), Blocks.COBBLESTONE, 1, Modpack.CAVESTONE);
    public static final Block compressedCobbledDeepslate = new CompressedBlock(PackEssentials.getInstance(), Blocks.COBBLED_DEEPSLATE, 1, Modpack.CAVESTONE);
    public static final Block doubleCompressedCobblestone = new CompressedBlock(PackEssentials.getInstance(), Blocks.COBBLESTONE, 2, Modpack.CAVESTONE);
    public static final Block doubleCompressedCobbledDeepslate = new CompressedBlock(PackEssentials.getInstance(), Blocks.COBBLED_DEEPSLATE, 2, Modpack.CAVESTONE);

    public static final Block snad = new SnadBlock(0xDB7093, BlockBehaviour.Properties.copy(Blocks.SAND), Modpack.CAVESTONE);
    public static final Block redSnad = new SnadBlock(0xA92B39, BlockBehaviour.Properties.copy(Blocks.RED_SAND), Modpack.CAVESTONE);
}
