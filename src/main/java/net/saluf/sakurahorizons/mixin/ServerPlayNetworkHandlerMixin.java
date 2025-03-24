package net.saluf.sakurahorizons.mixin;

import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.Box;
import net.saluf.sakurahorizons.registry.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ServerPlayNetworkHandler.class)
public class ServerPlayNetworkHandlerMixin {

    @Shadow public ServerPlayerEntity player;

    @Redirect(method = "onPlayerInteractEntity", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/network/ServerPlayerEntity;canInteractWithEntityIn(Lnet/minecraft/util/math/Box;D)Z"))
    private boolean redirectCanInteractWithEntityIn(ServerPlayerEntity instance, Box box, double v) {
        System.out.println(player.getMainHandStack().getItem());
        if (player.getMainHandStack().getItem() == ModItems.NAGINATA) {
            return player.canInteractWithEntityIn(box, 10.0D);
        }
        return player.canInteractWithEntityIn(box, v);
    }
}
