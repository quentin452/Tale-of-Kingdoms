/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiButton
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.world.World
 *  org.lwjgl.opengl.GL11
 */
package mods.aginsun.kingdoms.client.guis;

import mods.aginsun.kingdoms.client.guis.GuiScreenToK;
import mods.aginsun.kingdoms.handlers.GoldKeeper;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class GuiBank
extends GuiScreenToK {
    private World worldObj;
    public EntityPlayer entityplayer;
    boolean check = false;

    public GuiBank(EntityPlayer entityplayer1, World world) {
        this.entityplayer = entityplayer1;
        this.worldObj = world;
    }

    public void initGui() {
        this.buttonList.add(new GuiButton(1, this.width / 2 - 95, 55, 90, 20, "Deposit 1."));
        this.buttonList.add(new GuiButton(2, this.width / 2 - 95, 75, 90, 20, "Deposit 10."));
        this.buttonList.add(new GuiButton(3, this.width / 2 - 95, 95, 90, 20, "Deposit 100."));
        this.buttonList.add(new GuiButton(4, this.width / 2 - 95, 115, 90, 20, "Deposit 1000."));
        this.buttonList.add(new GuiButton(5, this.width / 2 - 95, 135, 90, 20, "Deposit 10000."));
        this.buttonList.add(new GuiButton(6, this.width / 2 - 95, 155, 90, 20, "Deposit All."));
        this.buttonList.add(new GuiButton(7, this.width / 2 + 5, 55, 90, 20, "Withdraw 1."));
        this.buttonList.add(new GuiButton(8, this.width / 2 + 5, 75, 90, 20, "Withdraw 10."));
        this.buttonList.add(new GuiButton(9, this.width / 2 + 5, 95, 90, 20, "Withdraw 100."));
        this.buttonList.add(new GuiButton(10, this.width / 2 + 5, 115, 90, 20, "Withdraw 1000."));
        this.buttonList.add(new GuiButton(11, this.width / 2 + 5, 135, 90, 20, "Withdraw 10000."));
        this.buttonList.add(new GuiButton(12, this.width / 2 + 5, 155, 90, 20, "Withdraw All."));
        this.buttonList.add(new GuiButton(13, this.width / 2 - 45, 195, 90, 20, "Cancel."));
    }

    protected void actionPerformed(GuiButton guibutton) {
        if (guibutton.id == 1) {
            this.check = false;
            int i = 1;
            if (GoldKeeper.getGoldTotal() >= i) {
                GoldKeeper.decreaseGold(i);
                GoldKeeper.addBankGold(i);
            } else {
                this.check = true;
            }
        }
        if (guibutton.id == 2) {
            this.check = false;
            int byte0 = 10;
            if (GoldKeeper.getGoldTotal() >= byte0) {
                GoldKeeper.decreaseGold(byte0);
                GoldKeeper.addBankGold(byte0);
            } else {
                this.check = true;
            }
        }
        if (guibutton.id == 3) {
            this.check = false;
            int byte1 = 100;
            if (GoldKeeper.getGoldTotal() >= byte1) {
                GoldKeeper.decreaseGold(byte1);
                GoldKeeper.addBankGold(byte1);
            } else {
                this.check = true;
            }
        }
        if (guibutton.id == 4) {
            this.check = false;
            int c = 1000;
            if (GoldKeeper.getGoldTotal() >= c) {
                GoldKeeper.decreaseGold(c);
                GoldKeeper.addBankGold(c);
            } else {
                this.check = true;
            }
        }
        if (guibutton.id == 5) {
            this.check = false;
            int c1 = 10000;
            if (GoldKeeper.getGoldTotal() >= c1) {
                GoldKeeper.decreaseGold(c1);
                GoldKeeper.addBankGold(c1);
            } else {
                this.check = true;
            }
        }
        if (guibutton.id == 6) {
            this.check = false;
            GoldKeeper.addBankGold(GoldKeeper.getGoldTotal());
            GoldKeeper.decreaseGold(GoldKeeper.getGoldTotal());
        }
        if (guibutton.id == 7) {
            this.check = false;
            int j = 1;
            if (GoldKeeper.getBankGold() >= j) {
                GoldKeeper.addGold(j);
                GoldKeeper.decreaseBankGold(j);
            } else {
                this.check = true;
            }
        }
        if (guibutton.id == 8) {
            this.check = false;
            int byte2 = 10;
            if (GoldKeeper.getBankGold() >= byte2) {
                GoldKeeper.addGold(byte2);
                GoldKeeper.decreaseBankGold(byte2);
            } else {
                this.check = true;
            }
        }
        if (guibutton.id == 9) {
            this.check = false;
            int byte3 = 100;
            if (GoldKeeper.getBankGold() >= byte3) {
                GoldKeeper.addGold(byte3);
                GoldKeeper.decreaseBankGold(byte3);
            } else {
                this.check = true;
            }
        }
        if (guibutton.id == 10) {
            this.check = false;
            int c2 = 1000;
            if (GoldKeeper.getBankGold() >= c2) {
                GoldKeeper.addGold(c2);
                GoldKeeper.decreaseBankGold(c2);
            } else {
                this.check = true;
            }
        }
        if (guibutton.id == 11) {
            this.check = false;
            int c3 = 10000;
            if (GoldKeeper.getBankGold() >= c3) {
                GoldKeeper.addGold(c3);
                GoldKeeper.decreaseBankGold(c3);
            } else {
                this.check = true;
            }
        }
        if (guibutton.id == 12) {
            GoldKeeper.addGold(GoldKeeper.getBankGold());
            GoldKeeper.setBankGold(0);
        }
        if (guibutton.id == 13) {
            if (!this.worldObj.isRemote) {
                this.entityplayer.addChatMessage("Banker: I promise I won't spend this!");
            }
            this.mc.displayGuiScreen(null);
        }
    }

    public void drawScreen(int i, int j, float f) {
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        int c = 255;
        int c1 = 255;
        ResourceLocation resource = new ResourceLocation("taleofkingdoms", "textures/guis/crafting.png");
        this.mc.renderEngine.bindTexture(resource);
        int i1 = (this.width - c) / 2;
        this.drawTexturedModalRect(i1, 0, 0, 0, c, c1);
        for (int l = 0; l < this.buttonList.size(); ++l) {
            GuiButton guibutton = (GuiButton)this.buttonList.get(l);
            guibutton.drawButton(this.mc, i, j);
        }
        this.drawCenteredString(this.fontRendererObj, "Bank Menu -", this.width / 2, 15, 0xFFFFFF);
        this.drawCenteredString(this.fontRendererObj, "Total Money You Have: " + GoldKeeper.getGoldTotal() + " Gold Coins", this.width / 2, 25, 0xFFFFFF);
        this.drawCenteredString(this.fontRendererObj, "Total Money in the Bank: " + GoldKeeper.getBankGold() + " Gold Coins", this.width / 2, 35, 0xFFFFFF);
        if (this.check) {
            this.drawCenteredString(this.fontRendererObj, "Don't Have Enough Gold", this.width / 2, 45, 0xFFFFFF);
        }
    }

    @Override
    protected void keyTyped(char par1, int par2) {
        if (par2 == 1 || par2 == this.mc.gameSettings.keyBindInventory.keyCode) {
            this.mc.thePlayer.closeScreen();
        }
    }
}

