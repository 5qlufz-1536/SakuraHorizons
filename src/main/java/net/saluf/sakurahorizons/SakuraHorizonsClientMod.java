package net.saluf.sakurahorizons;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.saluf.sakurahorizons.client.MortarScreen;
import net.saluf.sakurahorizons.registry.ModScreenHandlers;

public class SakuraHorizonsClientMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlers.MORTAR_SCREEN_HANDLER, MortarScreen::new);
    }
}
