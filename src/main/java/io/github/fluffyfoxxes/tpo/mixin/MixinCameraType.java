package io.github.fluffyfoxxes.tpo.mixin;

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
        cir.setReturnValue(false);
    }

    @Inject(
            method = "isMirrored",
            at = @At("RETURN"),
            cancellable = true)
    public void isMirrored(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }
}
