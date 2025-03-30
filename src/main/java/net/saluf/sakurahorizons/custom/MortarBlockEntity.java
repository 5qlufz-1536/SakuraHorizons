package net.saluf.sakurahorizons.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.saluf.sakurahorizons.registry.ModBlockEntities;
import net.saluf.sakurahorizons.util.ImplementedInventory;
import org.jetbrains.annotations.Nullable;

public class MortarBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    public static DefaultedList<ItemStack> items = DefaultedList.ofSize(9, ItemStack.EMPTY);

    public MortarBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.MORTAR_ENTITY, pos, state);
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("臼");
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new MortarScreenHandler(syncId, playerInventory, this);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }

    @Override
    public void markDirty() {
        super.markDirty();
    }
}
