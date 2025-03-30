package net.saluf.sakurahorizons.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.saluf.sakurahorizons.SakuraHorizonsMod;
import net.saluf.sakurahorizons.custom.MortarBlockEntity;



public class ModBlockEntities {

    public static BlockEntityType<MortarBlockEntity> MORTAR_ENTITY;

    public static void registerBlockEntities() {
        MORTAR_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                Identifier.of(SakuraHorizonsMod.MOD_ID, "mortar"),
                FabricBlockEntityTypeBuilder.create(MortarBlockEntity::new, ModBlocks.MORTAR).build());
    }
}
