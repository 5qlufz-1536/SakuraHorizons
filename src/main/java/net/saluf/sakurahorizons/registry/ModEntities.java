package net.saluf.sakurahorizons.registry;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.saluf.sakurahorizons.SakuraHorizonsMod;
import net.saluf.sakurahorizons.registry.entity.BambooSpearEntity;

public class ModEntities {

    public static EntityType<BambooSpearEntity> THROWN_BAMBOO_SPEAR = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(SakuraHorizonsMod.MOD_ID, "takeyari"),
            EntityType.Builder.<BambooSpearEntity>create(BambooSpearEntity::new, SpawnGroup.MISC)
                    .dimensions(0.5F, 0.5F)
                    .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(SakuraHorizonsMod.MOD_ID, "takeyari"))));

    public static void registerEntities() {

    }
}
