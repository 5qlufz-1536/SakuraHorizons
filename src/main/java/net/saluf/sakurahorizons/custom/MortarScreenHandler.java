package net.saluf.sakurahorizons.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import org.jetbrains.annotations.Nullable;

public class MortarScreenHandler extends ScreenHandler {
    public static Inventory inventory;

    public MortarScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(null, syncId);
        MortarScreenHandler.inventory = inventory;
        checkSize(inventory, 9);
        inventory.onOpen(playerInventory.player);

        int gridSize = 18;

        for (int i = 0; i < 9; i++) {
            addSlot(new Slot(playerInventory, i, 8 + i * gridSize, 142));
        }

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                addSlot(new Slot(playerInventory, 9 + col + row * 9, 8 + col * gridSize, 84 + row * gridSize));
            }
        }

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                addSlot(new Slot(inventory, col + row * 3, 62 + col * gridSize, 17 + row * gridSize));
            }
        }
    }

    public MortarScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(9));
    }

    public MortarScreenHandler(@Nullable ScreenHandlerType<?> type, int syncId) {
        super(type, syncId);
    }


    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return inventory.canPlayerUse(player);
    }
}
