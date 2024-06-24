package de.melanx.packessentials.blocks;

import de.melanx.packessentials.Modpack;
import de.melanx.packessentials.PackEssentials;
import de.melanx.packessentials.base.InfestedBlockBase;
import de.melanx.packessentials.base.block.CompressedBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.moddingx.libx.annotation.registration.RegisterClass;

@RegisterClass(registry = "BLOCKS", priority = 1)
public class ModBlocks {

    public static final CompressedBlock compressedCobblestone = new CompressedBlock(PackEssentials.getInstance(), Blocks.COBBLESTONE, 1, Modpack.CAVESTONE);
    public static final CompressedBlock compressedGravel = new CompressedBlock(PackEssentials.getInstance(), Blocks.GRAVEL, 1, Modpack.CAVESTONE);
    public static final CompressedBlock compressedSand = new CompressedBlock(PackEssentials.getInstance(), Blocks.SAND, 1, Modpack.CAVESTONE);
    public static final CompressedBlock compressedAndesite = new CompressedBlock(PackEssentials.getInstance(), Blocks.ANDESITE, 1, Modpack.CAVESTONE);
    public static final CompressedBlock compressedDiorite = new CompressedBlock(PackEssentials.getInstance(), Blocks.DIORITE, 1, Modpack.CAVESTONE);
    public static final CompressedBlock compressedGranite = new CompressedBlock(PackEssentials.getInstance(), Blocks.GRANITE, 1, Modpack.CAVESTONE);
    public static final CompressedBlock compressedCobbledDeepslate = new CompressedBlock(PackEssentials.getInstance(), Blocks.COBBLED_DEEPSLATE, 1, Modpack.CAVESTONE);
    public static final CompressedBlock compressedTuff = new CompressedBlock(PackEssentials.getInstance(), Blocks.TUFF, 1, Modpack.CAVESTONE);
    public static final CompressedBlock compressedNetherrack = new CompressedBlock(PackEssentials.getInstance(), Blocks.NETHERRACK, 1, Modpack.CAVESTONE);

    public static final CompressedBlock doubleCompressedCobblestone = new CompressedBlock(PackEssentials.getInstance(), Blocks.COBBLESTONE, 2, Modpack.CAVESTONE);
    public static final CompressedBlock doubleCompressedGravel = new CompressedBlock(PackEssentials.getInstance(), Blocks.GRAVEL, 2, Modpack.CAVESTONE);
    public static final CompressedBlock doubleCompressedSand = new CompressedBlock(PackEssentials.getInstance(), Blocks.SAND, 2, Modpack.CAVESTONE);
    public static final CompressedBlock doubleCompressedAndesite = new CompressedBlock(PackEssentials.getInstance(), Blocks.ANDESITE, 2, Modpack.CAVESTONE);
    public static final CompressedBlock doubleCompressedDiorite = new CompressedBlock(PackEssentials.getInstance(), Blocks.DIORITE, 2, Modpack.CAVESTONE);
    public static final CompressedBlock doubleCompressedGranite = new CompressedBlock(PackEssentials.getInstance(), Blocks.GRANITE, 2, Modpack.CAVESTONE);
    public static final CompressedBlock doubleCompressedCobbledDeepslate = new CompressedBlock(PackEssentials.getInstance(), Blocks.COBBLED_DEEPSLATE, 2, Modpack.CAVESTONE);
    public static final CompressedBlock doubleCompressedTuff = new CompressedBlock(PackEssentials.getInstance(), Blocks.TUFF, 2, Modpack.CAVESTONE);
    public static final CompressedBlock doubleCompressedNetherrack = new CompressedBlock(PackEssentials.getInstance(), Blocks.NETHERRACK, 2, Modpack.CAVESTONE);

    public static final Block snad = new SnadBlock(0xDB7093, BlockBehaviour.Properties.copy(Blocks.SAND), Modpack.CAVESTONE);
    public static final Block redSnad = new SnadBlock(0xA92B39, BlockBehaviour.Properties.copy(Blocks.RED_SAND), Modpack.CAVESTONE);

    public static final Block infestedCobbledDeepslate = new InfestedBlockBase(PackEssentials.getInstance(), Blocks.COBBLED_DEEPSLATE, Modpack.CAVESTONE);
    public static final Block infestedDeepslateBricks = new InfestedBlockBase(PackEssentials.getInstance(), Blocks.DEEPSLATE_BRICKS, Modpack.CAVESTONE);
    public static final Block infestedDeepslateTiles = new InfestedBlockBase(PackEssentials.getInstance(), Blocks.DEEPSLATE_TILES, Modpack.CAVESTONE);
    public static final Block infestedNetherBricks = new InfestedBlockBase(PackEssentials.getInstance(), Blocks.NETHER_BRICKS, Modpack.CAVESTONE);
}
