package de.melanx.packessentials.items;

import de.melanx.packessentials.Modpack;
import de.melanx.packessentials.base.item.PackItemBase;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.BrushItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BrushableBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BrushableBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import org.moddingx.libx.mod.ModX;

import javax.annotation.Nonnull;

public class AncientBrushItem extends PackItemBase {

    private static final BrushItem BRUSH = (BrushItem) Items.BRUSH;

    public AncientBrushItem(ModX mod, Properties properties, Modpack... modpacks) {
        super(mod, properties, modpacks);
    }

    @Nonnull
    @Override
    public InteractionResult useOn(@Nonnull UseOnContext context) {
        Player player = context.getPlayer();
        if (player != null && this.calculateHitResult(player).getType() == HitResult.Type.BLOCK) {
            player.startUsingItem(context.getHand());
        }

        return InteractionResult.CONSUME;
    }

    @Nonnull
    @Override
    public UseAnim getUseAnimation(@Nonnull ItemStack stack) {
        return UseAnim.BRUSH;
    }

    @Override
    public int getUseDuration(@Nonnull ItemStack stack) {
        return 200;
    }

    // [Copy from BrushItem#onUseTick]
    // `useDuration % 10 != 5` was changed to `useDuration % 20 != 5` to increase duration
    @Override
    public void onUseTick(@Nonnull Level level, @Nonnull LivingEntity livingEntity, @Nonnull ItemStack stack, int remainingUseDuration) {
        if (remainingUseDuration < 0 || !(livingEntity instanceof Player player)) {
            livingEntity.releaseUsingItem();
            return;
        }

        HitResult hitResult = this.calculateHitResult(livingEntity);
        if (!(hitResult instanceof BlockHitResult blockHitResult) || hitResult.getType() != HitResult.Type.BLOCK) {
            livingEntity.releaseUsingItem();
            return;
        }

        int useDuration = this.getUseDuration(stack) - remainingUseDuration + 1;
        if (useDuration % 20 != 5) {
            return;
        }

        BlockPos blockPos = blockHitResult.getBlockPos();
        BlockState blockState = level.getBlockState(blockPos);
        HumanoidArm humanoidArm = livingEntity.getUsedItemHand() == InteractionHand.MAIN_HAND ? player.getMainArm() : player.getMainArm().getOpposite();
        BRUSH.spawnDustParticles(level, blockHitResult, blockState, livingEntity.getViewVector(0.0F), humanoidArm);

        Block block = blockState.getBlock();
        SoundEvent soundEvent = block instanceof BrushableBlock brushableBlock ? brushableBlock.getBrushSound() : SoundEvents.BRUSH_GENERIC;
        level.playSound(player, blockPos, soundEvent, SoundSource.BLOCKS);

        if (!level.isClientSide()) {
            BlockEntity blockEntity = level.getBlockEntity(blockPos);
            if (blockEntity instanceof BrushableBlockEntity brushableBlockEntity) {
                boolean brushed = brushableBlockEntity.brush(level.getGameTime(), player, blockHitResult.getDirection());
                if (brushed) {
                    EquipmentSlot equipmentSlot = stack.equals(player.getItemBySlot(EquipmentSlot.OFFHAND)) ? EquipmentSlot.OFFHAND : EquipmentSlot.MAINHAND;
                    stack.hurtAndBreak(1, livingEntity, (entity) -> entity.broadcastBreakEvent(equipmentSlot));
                }
            }
        }
    }

    private HitResult calculateHitResult(LivingEntity entity) {
        return ProjectileUtil.getHitResultOnViewVector(entity,
                player -> !player.isSpectator() && player.isPickable(),
                BrushItem.MAX_BRUSH_DISTANCE);
    }
}
