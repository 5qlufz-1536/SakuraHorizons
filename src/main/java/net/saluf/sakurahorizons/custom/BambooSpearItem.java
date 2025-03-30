package net.saluf.sakurahorizons.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TridentItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;
import net.saluf.sakurahorizons.registry.entity.BambooSpearEntity;

public class BambooSpearItem extends TridentItem {

    public BambooSpearItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 73000;
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {

        user.setCurrentHand(hand);

        return ActionResult.CONSUME;
    }


    @Override
    public boolean onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {

        PlayerEntity player = (PlayerEntity) user;

        int chargeTime = this.getMaxUseTime(stack, user) - remainingUseTicks;

        float velocity = MathHelper.clamp((float)chargeTime / 20.0F, 0.0F, 1.0F) * 2.5F;

        if (!world.isClient) {

            float pitch = player.getPitch();
            float yaw = player.getYaw();
            float rad = 0.017453292F;

            double x = -MathHelper.sin(yaw * rad) * MathHelper.cos(pitch * rad);
            double y = -MathHelper.sin(pitch * rad);
            double z = MathHelper.cos(yaw * rad) * MathHelper.cos(pitch * rad);

            BambooSpearEntity spearEntity = new BambooSpearEntity(world, user.getPos().x, user.getPos().y, user.getPos().z, stack.copyWithCount(1));
            spearEntity.setAngles(yaw, pitch);
            spearEntity.setVelocity(x * velocity, y * velocity, z * velocity);
            world.spawnEntity(spearEntity);
            if (!player.isCreative()) {
                player.getInventory().removeOne(stack);
            }
            player.getItemCooldownManager().set(this.getDefaultStack(), 10);
        }

        return false;
    }

    @Override
    public ProjectileEntity createEntity(World world, Position pos, ItemStack stack, Direction direction) {
        BambooSpearEntity bambooSpearEntity = new BambooSpearEntity(world, pos.getX(), pos.getY(), pos.getZ(), stack.copyWithCount(1));
        bambooSpearEntity.pickupType = PersistentProjectileEntity.PickupPermission.ALLOWED;
        return bambooSpearEntity;
    }
}
