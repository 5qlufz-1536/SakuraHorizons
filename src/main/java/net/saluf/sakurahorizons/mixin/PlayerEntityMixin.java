package net.saluf.sakurahorizons.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.saluf.sakurahorizons.registry.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {
    @Inject(method = "getEntityInteractionRange", at = @At("HEAD"), cancellable = true)
    private void onGetEntityInteractionRange(CallbackInfoReturnable<Double> cir) {
        PlayerEntity player = (PlayerEntity) (Object) this;
        if (player.getMainHandStack().getItem() == ModItems.NAGINATA) {
            cir.setReturnValue(10.0D);
        }
    }
}
