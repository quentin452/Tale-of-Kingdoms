package mods.aginsun.kingdoms.client.guis;

import mods.aginsun.kingdoms.client.guis.GuiPriceBar;
import mods.aginsun.kingdoms.client.guis.GuiScreenToK;
import mods.aginsun.kingdoms.entities.EntityHired;
import mods.aginsun.kingdoms.handlers.GoldKeeper;
import mods.aginsun.kingdoms.handlers.HunterKeeper;
import mods.aginsun.kingdoms.handlers.WorthyKeeper;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import mods.aginsun.kingdoms.util.ChatMessage;

public class GuiHunter
extends GuiScreenToK {
    private World worldObj;
    public EntityPlayer player;
    boolean goldchecker = false;
    private GuiPriceBar worthness;
    private float worthyness;

    public GuiHunter(EntityPlayer player, World world) {
        this.player = player;
        this.worthyness = WorthyKeeper.getInstance().getWorthy();
        this.worldObj = world;
    }

    public void initGui() {
        this.buttonList.clear();
        if (!HunterKeeper.getInstance().getHunter()) {
            this.buttonList.add(new GuiButton(1, this.width / 2 + 110, 140, 100, 20, "Sign contract!"));
        } else {
            this.buttonList.add(new GuiButton(1, this.width / 2 + 110, 140, 100, 20, "discard contract!"));
        }
        this.buttonList.add(new GuiButton(2, this.width / 2 + 110, 160, 100, 20, "Hire Hunters"));
        this.buttonList.add(new GuiButton(4, this.width / 2 + 110, 180, 100, 20, "Fix the Guild"));
        this.buttonList.add(new GuiButton(5, this.width / 2 + 110, 200, 100, 20, "Retire Hunters"));
        this.buttonList.add(new GuiButton(3, this.width / 2 + 110, 220, 100, 20, "Exit"));
        this.worthness = new GuiPriceBar(0, this.width / 2 + 110, 120, 125, 12, 1.0f, "red");
        this.worthness.setBar(this.worthyness / 10000.0f);
    }

    protected void actionPerformed(GuiButton guibutton) {
        if (guibutton.id == 1) {
            if (!HunterKeeper.getInstance().getHunter()) {
                ChatMessage.add(this.player,"Guild Master: You are now one of us my friend. Kill monsters and you will soon be worthy of your title.");
            } else {
                ChatMessage.add(this.player,"Why does one wanna do this :P");
            }
            this.initGui();
        } else if (guibutton.id == 1) {
            if (!this.worldObj.isRemote) {
                ChatMessage.add(this.player,"Guild Master: We will await your participation, hero.");
            }
            this.initGui();
        }
        this.goldchecker = false;
        if (guibutton.id == 2) {
            if (1500 <= GoldKeeper.getGoldTotal()) {
                EntityHired entityliving = new EntityHired(this.worldObj);
                EntityList.createEntityByName((String)"Hired", (World)this.worldObj);
                entityliving.setLocationAndAngles(this.player.posX, this.player.posY, this.player.posZ, 0.0f, 0.0f);
                this.worldObj.spawnEntityInWorld((Entity)entityliving);
                GoldKeeper.decreaseGold(1500);
            } else {
                this.goldchecker = true;
            }
        }
        if (guibutton.id == 3) {
            this.mc.displayGuiScreen(null);
            this.goldchecker = false;
        }
        if (guibutton.id == 4) {
            InventoryPlayer inventoryplayer = this.player.inventory;
            boolean flag = false;
            if (inventoryplayer.hasItem(17)) {
                for (int j = 0; j < inventoryplayer.mainInventory.length; ++j) {
                    ItemStack itemstack;
                    if (inventoryplayer.mainInventory[j] == null || inventoryplayer.mainInventory[j].itemID != 17 || itemstack.stackSize != (itemstack = inventoryplayer.getStackInSlot(j)).getMaxStackSize() || flag) continue;
                    inventoryplayer.setInventorySlotContents(j, null);
                    flag = true;
                }
            }
            if (!flag) {
                if (!this.worldObj.isRemote) {
                    ChatMessage.add(this.player,"Guild Master: We need more resources.");
                }
            } else if (!this.worldObj.isRemote) {
                ChatMessage.add(this.player,"Guild Master: The guild has been fixed. Thank you.");
            }
        }
        if (guibutton.id == 5 && !this.worldObj.loadedEntityList.isEmpty()) {
            for (int i = 0; i < this.worldObj.loadedEntityList.size(); ++i) {
                Entity entity = (Entity)this.worldObj.loadedEntityList.get(i);
                if (!(entity instanceof EntityHired)) continue;
                EntityHired entityhired = (EntityHired)entity;
                entityhired.setDead();
                GoldKeeper.addGold(1000);
            }
        }
    }

    public void onGuiClosed() {
        if (!this.worldObj.isRemote) {
            ChatMessage.add(this.player,"Guild Master: Good Hunting.");
        }
    }

    public void drawScreen(int i, int j, float f) {
        for (int k = 0; k < this.buttonList.size(); ++k) {
            GuiButton guibutton = (GuiButton)this.buttonList.get(k);
            guibutton.drawButton(this.mc, i, j);
        }
        this.drawCenteredString(this.fontRendererObj, "Path to Kingship", this.width / 2 + 100, 110, 0xAA44FF);
        if (this.goldchecker) {
            this.drawCenteredString(this.fontRendererObj, "The Guild Order  Total Money: " + GoldKeeper.getGoldTotal() + " Gold Coins - NOT ENOUGH GOLD", this.width / 2, 20, 0xFFEE00);
        } else {
            this.drawCenteredString(this.fontRendererObj, "The Guild Order  Total Money: " + GoldKeeper.getGoldTotal() + " Gold Coins", this.width / 2, 0, 0xFFEE00);
        }
        this.drawCenteredString(this.fontRendererObj, "Note: Hiring Cost 1500 gold, Retiring will Refund 1000. Fixing the Guild need 64 wood.", this.width / 2, 10, 0xFFEE00);
        this.worthness.drawBar();
    }
}

