package net.imbuemod.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.imbuemod.BlockRegistry;
import net.imbuemod.ImbueMod;
import net.imbuemod.TestScreen;
import net.imbuemod.WoodenCrateScreen;
import net.minecraft.client.render.RenderLayer;

@Environment(EnvType.CLIENT)
public class ImbueModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(ImbueMod.WOODEN_CRATE_SCREEN_HANDLER, WoodenCrateScreen::new);
        ScreenRegistry.register(ImbueMod.TEST_SCREEN_HANDLER, TestScreen::new);
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.SMALL_GLOWSHROOM, RenderLayer.getCutout());
    }
}