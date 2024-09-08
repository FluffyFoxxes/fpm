package io.github.fluffyfoxxes.fpm.mixin;

import com.github.exopandora.shouldersurfing.api.model.Perspective;
import io.github.fluffyfoxxes.fpm.Config;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Perspective.class)
public class MixinPerspective {
    @Inject(
            method = "next",
            at = @At("RETURN"),
            cancellable = true,
            remap = false)
    public void next(CallbackInfoReturnable<Perspective> cir) {
        switch (Config.camera) {
            case 1:
                Config.perspectives = new Perspective[]{Perspective.THIRD_PERSON_FRONT};
                break;
            case 2:
                Config.perspectives = new Perspective[]{Perspective.SHOULDER_SURFING, Perspective.THIRD_PERSON_BACK};
                break;
            default:
                Config.perspectives = new Perspective[]{Perspective.FIRST_PERSON};
                break;
        }

        Config.currPersp = (Config.currPersp + 1) % Config.perspectives.length;

        cir.setReturnValue(Config.perspectives[Config.currPersp]);
    }
}
