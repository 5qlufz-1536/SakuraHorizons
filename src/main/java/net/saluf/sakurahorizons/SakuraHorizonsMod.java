package net.saluf.sakurahorizons;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.saluf.sakurahorizons.registry.ModBlocks;
import net.saluf.sakurahorizons.registry.ModItemGroups;
import net.saluf.sakurahorizons.registry.ModItems;

public class SakuraHorizonsMod implements ModInitializer {
    public static final String MOD_ID = "sakurahorizons";

    @Override
    public void onInitialize() {
        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RICE_CROP_BLOCK, RenderLayer.getCutout());
        System.out.println("Mod初期化完了");
    }
}
