package de.melanx.modpackslave.blocks;

import de.melanx.modpackslave.Modpack;
import de.melanx.modpackslave.ModpackSlave;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.moddingx.libx.annotation.registration.RegisterClass;

@RegisterClass(registry = "BLOCKS", priority = 1)
public class ModBlocks {

    public static final Block compressedCobblestone = new CompressedBlock(ModpackSlave.getInstance(), Blocks.COBBLESTONE, 1, Modpack.CAVESTONE);
    public static final Block compressedCobbledDeepslate = new CompressedBlock(ModpackSlave.getInstance(), Blocks.COBBLED_DEEPSLATE, 1, Modpack.CAVESTONE);
    public static final Block doubleCompressedCobblestone = new CompressedBlock(ModpackSlave.getInstance(), Blocks.COBBLESTONE, 2, Modpack.CAVESTONE);
    public static final Block doubleCompressedCobbledDeepslate = new CompressedBlock(ModpackSlave.getInstance(), Blocks.COBBLED_DEEPSLATE, 2, Modpack.CAVESTONE);
}
