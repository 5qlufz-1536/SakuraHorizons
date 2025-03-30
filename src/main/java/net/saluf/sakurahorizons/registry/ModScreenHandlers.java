package net.saluf.sakurahorizons.registry;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.saluf.sakurahorizons.SakuraHorizonsMod;
import net.saluf.sakurahorizons.custom.MortarScreenHandler;

public class ModScreenHandlers {
    public static ScreenHandlerType<MortarScreenHandler> MORTAR_SCREEN_HANDLER;

    public static void registerScreenHandlers() {
        MORTAR_SCREEN_HANDLER = Registry.register(Registries.SCREEN_HANDLER,
                Identifier.of(SakuraHorizonsMod.MOD_ID, "mortar"),
                new ScreenHandlerType<>(MortarScreenHandler::new, FeatureSet.empty()));
    }
}
