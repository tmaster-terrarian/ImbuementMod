package net.imbuemod.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.imbuemod.ImbueMod;
import net.imbuemod.WoodenCrateScreen;

@Environment(EnvType.CLIENT)
public class ImbueModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(ImbueMod.WOODEN_CRATE_SCREEN_HANDLER, WoodenCrateScreen::new);
    }
}