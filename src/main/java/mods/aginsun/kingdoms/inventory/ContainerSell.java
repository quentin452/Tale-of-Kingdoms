
package mods.aginsun.kingdoms.inventory;

import mods.aginsun.kingdoms.entities.TileEntitySell;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerSell
extends Container {
    protected TileEntitySell tile_entity;

    public ContainerSell(TileEntitySell tile_entity, InventoryPlayer player_inventory) {
        this.tile_entity = tile_entity;
        this.addSlotToContainer(new Slot((IInventory)tile_entity, 0, 116, 35));
        this.bindPlayerInventory(player_inventory);
    }

    public boolean canInteractWith(EntityPlayer player) {
        return this.tile_entity.isUseableByPlayer(player);
    }

    protected void bindPlayerInventory(InventoryPlayer player_inventory) {
        int i;
        for (i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot((IInventory)player_inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for (i = 0; i < 9; ++i) {
            this.addSlotToContainer(new Slot((IInventory)player_inventory, i, 8 + i * 18, 142));
        }
    }

    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int i) {
        ItemStack stack = null;
        Slot slot_object = (Slot)this.inventorySlots.get(i);
        if (slot_object != null && slot_object.getHasStack()) {
            ItemStack stack_in_slot = slot_object.getStack();
            stack = stack_in_slot.copy();
            if (i == 0 ? !this.mergeItemStack(stack_in_slot, 1, this.inventorySlots.size(), true) : !this.mergeItemStack(stack_in_slot, 0, 1, false)) {
                return null;
            }
            if (stack_in_slot.stackSize == 0) {
                slot_object.putStack(null);
            } else {
                slot_object.onSlotChanged();
            }
        }
        return stack;
    }
}

