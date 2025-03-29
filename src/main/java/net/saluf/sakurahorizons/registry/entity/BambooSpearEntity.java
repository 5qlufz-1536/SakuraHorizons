package net.saluf.sakurahorizons.registry.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.saluf.sakurahorizons.registry.ModEntities;
import net.saluf.sakurahorizons.registry.ModItems;

public class BambooSpearEntity extends ThrownItemEntity {

    public BambooSpearEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public BambooSpearEntity(World world, LivingEntity owner) {
        super(ModEntities.THROWN_BAMBOO_SPEAR, owner, world, new ItemStack(ModItems.TAKEYARI));
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.TAKEYARI;
    }

    @Override
    public void tick() {
        super.tick();

        if (this.isOnGround() || this.isCollidable()) {
            this.setVelocity(0.0, 0.0, 0.0);
            this.groundCollision = true;
        }
    }
}
