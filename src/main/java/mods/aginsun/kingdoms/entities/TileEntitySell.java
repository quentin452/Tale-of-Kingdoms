/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.client.FMLClientHandler
 *  cpw.mods.fml.common.FMLCommonHandler
 *  net.minecraft.client.entity.EntityClientPlayerMP
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.world.WorldServer
 */
package mods.aginsun.kingdoms.entities;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import mods.aginsun.kingdoms.handlers.GoldKeeper;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.WorldServer;

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
                if (item.itemID == Item.flint.itemID) {
                    f = GoldKeeper.flint;
                }
                if (item.itemID == Item.clay.itemID) {
                    f = GoldKeeper.clay;
                }
                if (item.itemID == Item.ingotIron.itemID) {
                    f = GoldKeeper.iron;
                }
                if (item.itemID == Item.diamond.itemID) {
                    f = GoldKeeper.diamond;
                }
                if (item.itemID == Item.fishRaw.itemID) {
                    f = GoldKeeper.fish;
                }
                if (item.itemID == Item.appleRed.itemID) {
                    f = GoldKeeper.apple;
                }
                if (item.itemID == Item.silk.itemID) {
                    f = GoldKeeper.string;
                }
                if (item.itemID == Item.feather.itemID) {
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

    public void openChest() {
    }

    public void closeChest() {
        WorldServer world = FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(0);
        EntityClientPlayerMP entityplayer = FMLClientHandler.instance().getClient().thePlayer;
        if (!world.isRemote) {
            entityplayer.addChatMessage("Shop Keeper: Thank you for selling your stuff here!");
        }
    }

    public String getInvName() {
        return "TeSell";
    }

    public boolean isInvNameLocalized() {
        return false;
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

