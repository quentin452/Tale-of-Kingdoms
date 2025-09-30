package mods.aginsun.kingdoms.client.guis;

import mods.aginsun.kingdoms.client.guis.GuiScreenToK;
import mods.aginsun.kingdoms.handlers.GoldKeeper;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import mods.aginsun.kingdoms.util.ChatMessage;

public class GuiFoodKeeper
extends GuiScreenToK {
    private World worldObj;
    public EntityPlayer entityplayer;
    boolean goldchecker = false;
    public boolean freebread = true;
    public Item item;

    public GuiFoodKeeper(EntityPlayer entityplayer1, World world) {
        this.entityplayer = entityplayer1;
        this.worldObj = world;
    }

    public void initGui() {
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(2, this.width / 2 + 110, 160, 120, 20, "Give me some bread!"));
        this.buttonList.add(new GuiButton(3, this.width / 2 + 110, 180, 120, 20, "Exit."));
    }

    public void actionPerformed(GuiButton guibutton) {
        if (guibutton.id == 1) {
            this.initGui();
        }
        if (guibutton.id == 2) {
            if (this.freebread) {
                if (!this.worldObj.isRemote) {
                    ChatMessage.add(this.entityplayer, "Farmer: Here, take a bread!");
                }
                ItemStack itemstack = new ItemStack(297, 1, 0);
                EntityItem entityitem = new EntityItem(this.worldObj, this.entityplayer.posX, this.entityplayer.posY, this.entityplayer.posZ, itemstack);
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
                this.freebread = false;
            } else if (!this.worldObj.isRemote) {
                ChatMessage.add(this.entityplayer, "Farmer: You got your bread for now!");
            }
        }
        if (guibutton.id == 3) {
            this.mc.displayGuiScreen(null);
        }
    }

    public void drawScreen(int i, int j, float f) {
        for (int k = 0; k < this.buttonList.size(); ++k) {
            GuiButton guibutton = (GuiButton)this.buttonList.get(k);
            guibutton.drawButton(this.mc, i, j);
        }
        if (this.goldchecker) {
            this.drawCenteredString(this.fontRendererObj, "The Guild Order  Total Money: " + GoldKeeper.getGoldTotal() + " Gold Coins - NOT ENOUGH GOLD", this.width / 2, 20, 0xFFEE00);
        } else {
            this.drawCenteredString(this.fontRendererObj, "Total Money: " + GoldKeeper.getGoldTotal() + " Gold Coins", this.width / 2, 0, 0xFFEE00);
        }
    }

    @Override
    protected void keyTyped(char par1, int par2) {
        if (par2 == 1 || par2 == this.mc.gameSettings.keyBindInventory.getKeyCode()) {
            this.mc.thePlayer.closeScreen();
        }
    }
}

