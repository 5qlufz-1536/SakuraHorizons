package net.saluf.sakurahorizons.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TridentItem;
import net.minecraft.item.consume.UseAction;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.saluf.sakurahorizons.registry.entity.BambooSpearEntity;

public class BambooSpearItem extends TridentItem {

    public BambooSpearItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 72000;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.SPEAR;
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

            float f = MathHelper.cos(-pitch * rad - (float)Math.PI);
            float f1 = MathHelper.sin(-pitch * rad - (float)Math.PI);
            float f2 = MathHelper.cos(-yaw * rad - (float)Math.PI);
            float f3 = MathHelper.sin(-yaw * rad - (float)Math.PI);

            double x = f3 * f;
            double y = f1;
            double z = f2 * f;

            BambooSpearEntity spearEntity = new BambooSpearEntity(world, player);
            spearEntity.setAngles(user.getYaw(), user.getPitch());
            spearEntity.setVelocity(x * velocity, y * velocity, z * velocity);
            world.spawnEntity(spearEntity);
            if (!player.isCreative()) {
                player.getInventory().removeOne(stack);
            }
            player.getItemCooldownManager().set(this.getDefaultStack(), 10);
        }

        return false;
    }
}
