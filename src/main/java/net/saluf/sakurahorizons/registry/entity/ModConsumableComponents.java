package net.saluf.sakurahorizons.registry.entity;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;

import java.util.List;

import static net.minecraft.component.type.ConsumableComponents.drink;
import static net.minecraft.component.type.ConsumableComponents.food;

public class ModConsumableComponents {

    public static final ConsumableComponent GOLDEN_APPLE = food()
            .consumeEffect(
                    new ApplyEffectsConsumeEffect(
                            List.of(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 1), new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 0))
                    )
            )
            .build();
    public static final ConsumableComponent POISONOUS_POTATO = food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 0), 0.6F))
            .build();
    public static final ConsumableComponent PUFFERFISH = food()
            .consumeEffect(
                    new ApplyEffectsConsumeEffect(
                            List.of(
                                    new StatusEffectInstance(StatusEffects.POISON, 1200, 1),
                                    new StatusEffectInstance(StatusEffects.HUNGER, 300, 2),
                                    new StatusEffectInstance(StatusEffects.NAUSEA, 300, 0)
                            )
                    )
            )
            .build();
    public  static final ConsumableComponent TONYU = drink()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.REGENERATION,200,1)))
            .build();
    public static final ConsumableComponent AMAZAKE = drink()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.SPEED,1200,2)))
            .build();

    {
    }
}