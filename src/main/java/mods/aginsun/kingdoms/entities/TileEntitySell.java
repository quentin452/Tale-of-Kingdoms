
package mods.aginsun.kingdoms.entities;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import mods.aginsun.kingdoms.handlers.GoldKeeper;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.WorldServer;
import mods.aginsun.kingdoms.util.ChatMessage;

public class TileEntitySell
implements IInventory {
    private ItemStack[] inventory = new ItemStack[1];
    public GoldKeeper gold;

    public int getSizeInventory() {
        return this.inventory.length;
    }

    public ItemStack getStackInSlot(int i) {
        int j = 0;
        if (this.inventory[i] != null) {
            for (int k = 0; k < this.inventory[i].stackSize; ++k) {
                Item item = this.inventory[i].getItem();
                String s = item.getUnlocalizedName();
                j = GoldKeeper.priceItem(s);
                float f = 0.0f;
                if (item == Items.flint) {
                    f = GoldKeeper.flint;
                }
                if (item == Items.clay_ball) {
                    f = GoldKeeper.clay;
                }
                if (item == Items.iron_ingot) {
                    f = GoldKeeper.iron;
                }
                if (item == Items.diamond) {
                    f = GoldKeeper.diamond;
                }
                if (item == Items.fish) {
                    f = GoldKeeper.fish;
                }
                if (item == Items.apple) {
                    f = GoldKeeper.apple;
                }
                if (item == Items.string) {
                    f = GoldKeeper.string;
                }
                if (item == Items.feather) {
                    f = GoldKeeper.feather;
                }
                j = (int)((float)j + (float)j * (f /= 100.0f));
                if (!FMLCommonHandler.instance().getEffectiveSide().isServer()) continue;
                GoldKeeper.addGold(j);
            }
            if (j != 0) {
                this.inventory[i] = null;
            }
        }
        return this.inventory[i];
    }

    public void setInventorySlotContents(int i, ItemStack itemstack) {
        this.inventory[i] = itemstack;
        if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit()) {
            itemstack.stackSize = this.getInventoryStackLimit();
        }
    }

    public ItemStack decrStackSize(int i, int j) {
        if (this.inventory[i] != null) {
            if (this.inventory[i].stackSize <= j) {
                ItemStack itemstack = this.inventory[i];
                this.inventory[i] = null;
                return itemstack;
            }
            ItemStack itemstack1 = this.inventory[i].splitStack(j);
            if (this.inventory[i].stackSize == 0) {
                this.inventory[i] = null;
            }
            return itemstack1;
        }
        return null;
    }

    public ItemStack getStackInSlotOnClosing(int slotIndex) {
        return null;
    }

    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public void openInventory() {
        // No action needed for opening inventory
    }

    @Override
    public void closeInventory() {
        WorldServer world = FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(0);
        EntityClientPlayerMP entityplayer = FMLClientHandler.instance().getClient().thePlayer;
        if (!world.isRemote) {
            ChatMessage.add(entityplayer,"Shop Keeper: Thank you for selling your stuff here!");
        }
    }

    @Override
    public String getInventoryName() {
        return "TeSell";
    }

    @Override
    public boolean hasCustomInventoryName() {
        return false;
    }

    @Override
    public void markDirty() {
        // No action needed for this inventory
    }

    public boolean isItemValidForSlot(int i, ItemStack itemstack) {
        return false;
    }

    public void onInventoryChanged() {
    }

    public boolean isUseableByPlayer(EntityPlayer entityplayer) {
        return true;
    }
}

