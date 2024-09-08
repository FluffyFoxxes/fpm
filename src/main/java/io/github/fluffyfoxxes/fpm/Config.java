package io.github.fluffyfoxxes.fpm;

import com.github.exopandora.shouldersurfing.api.model.Perspective;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = Fpm.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.IntValue CAMERA = BUILDER.comment("Camera mode (1 - Face, 2 - Back, 3 - First)").defineInRange("camera", 1, 1, 3);


    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static int camera;
    public static Perspective[] perspectives;
    public static int currPersp;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        camera = CAMERA.get();

        currPersp = 0;
    }
}
