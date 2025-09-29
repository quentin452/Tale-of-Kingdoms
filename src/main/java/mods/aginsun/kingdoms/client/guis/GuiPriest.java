/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.FMLCommonHandler
 *  net.minecraft.client.gui.GuiButton
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityList
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.world.World
 */
package mods.aginsun.kingdoms.client.guis;

import cpw.mods.fml.common.FMLCommonHandler;
import mods.aginsun.kingdoms.client.guis.GuiScreenToK;
import mods.aginsun.kingdoms.handlers.GoldKeeper;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiPriest
extends GuiScreenToK {
    private World worldObj = FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(0);
    public EntityPlayer entityplayer;
    boolean goldchecker = false;

    public GuiPriest(EntityPlayer entityplayer1, World world) {
        this.entityplayer = entityplayer1;
        this.worldObj = world;
    }

    public void initGui() {
        String s = "";
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(1, this.width / 2 + 100, 160, 110, 20, s));
        this.buttonList.add(new GuiButton(2, this.width / 2 + 100, 180, 110, 20, "Recruit a Priestess"));
        this.buttonList.add(new GuiButton(4, this.width / 2 + 100, 200, 110, 20, "Rejuvinate"));
        this.buttonList.add(new GuiButton(3, this.width / 2 + 100, 220, 110, 20, "Exit"));
    }

    protected void actionPerformed(GuiButton guibutton) {
        if (guibutton.id == 1) {
            // empty if block
        }
        if (guibutton.id == 2) {
            if (2000 <= GoldKeeper.getGoldTotal()) {
                EntityLiving entityliving = (EntityLiving)EntityList.createEntityByName((String)"DefendPriest", (World)this.worldObj);
                entityliving.setLocationAndAngles(this.entityplayer.posX, this.entityplayer.posY, this.entityplayer.posZ, 0.0f, 0.0f);
                this.worldObj.spawnEntityInWorld((Entity)entityliving);
                GoldKeeper.decreaseGold(2000);
            } else {
                this.goldchecker = true;
            }
        }
        if (guibutton.id == 3) {
            this.mc.displayGuiScreen(null);
            this.goldchecker = false;
        }
        if (guibutton.id == 4) {
            this.entityplayer.getFoodStats().setFoodLevel(20);
            this.entityplayer.heal(20.0f);
            if (!this.worldObj.isRemote) {
                this.entityplayer.addChatMessage("Head Priest: You are now rejuvinated.");
            }
        }
    }

    public void onGuiClosed() {
        if (!this.worldObj.isRemote) {
            this.entityplayer.addChatMessage("Head Priest: May the light be with you.");
        }
    }

    public void drawScreen(int i, int j, float f) {
        for (int k = 0; k < this.buttonList.size(); ++k) {
            GuiButton guibutton = (GuiButton)this.buttonList.get(k);
            guibutton.drawButton(this.mc, i, j);
        }
        if (this.goldchecker) {
            this.drawCenteredString(this.fontRendererObj, "The Chapel Total Money: " + GoldKeeper.getGoldTotal() + " Gold Coins - NOT ENOUGH GOLD", this.width / 2, 20, 0xFFCC00);
        } else {
            this.drawCenteredString(this.fontRendererObj, "The Chapel Total Money: " + GoldKeeper.getGoldTotal() + " Gold Coins", this.width / 2, 10, 0xFFCC00);
        }
        this.drawCenteredString(this.fontRendererObj, "Note: Recruiting a priest cost 2000", this.width / 2, 20, 0xFFCC00);
    }
}

