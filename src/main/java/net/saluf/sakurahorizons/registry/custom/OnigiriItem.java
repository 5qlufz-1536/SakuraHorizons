package net.saluf.sakurahorizons.registry.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

import java.util.List;

public class OnigiriItem extends Item {

    public OnigiriItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("美味しくて栄養満点！"));
        super.appendTooltip(stack, context, tooltip, type);
    }
}
