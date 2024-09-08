package io.github.fluffyfoxxes.fpm.mixin;

import io.github.fluffyfoxxes.fpm.Config;
import net.minecraft.client.CameraType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(CameraType.class)
public class MixinCameraType {
    @Inject(
            method = "isFirstPerson",
            at = @At("RETURN"),
            cancellable = true)
    public void isFirstPerson(CallbackInfoReturnable<Boolean> cir) {
        if (Config.camera == 1 || Config.camera == 2) {
            cir.setReturnValue(false);
        } else {
            cir.setReturnValue(true);
        }
    }

    @Inject(
            method = "isMirrored",
            at = @At("RETURN"),
            cancellable = true)
    public void isMirrored(CallbackInfoReturnable<Boolean> cir) {
        if (Config.camera == 1) {
            cir.setReturnValue(true);
        } else {
            cir.setReturnValue(false);
        }
    }
}
