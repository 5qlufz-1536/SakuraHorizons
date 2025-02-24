package net.saluf.sakurahorizons;

import net.fabricmc.api.ModInitializer;
import net.saluf.sakurahorizons.registry.ModItems;

public class SakuraHorizonsMod implements ModInitializer {
    public static final String MOD_ID = "sakurahorizons";

    @Override
    public void onInitialize() {
        ModItems.registerModItems();
        System.out.println("Mod初期化完了");
    }
}
