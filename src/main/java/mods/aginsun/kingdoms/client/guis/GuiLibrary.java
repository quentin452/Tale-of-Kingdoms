package mods.aginsun.kingdoms.client.guis;

import mods.aginsun.kingdoms.client.guis.GuiScreenToK;
import mods.aginsun.kingdoms.entities.EntityLibraryKeeper;
import mods.aginsun.kingdoms.handlers.GoldKeeper;
import mods.aginsun.kingdoms.util.UtilToK;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import mods.aginsun.kingdoms.util.ChatMessage;

public class GuiLibrary
extends GuiScreenToK {
    private World worldObj;
    public EntityPlayer entityplayer;
    boolean goldchecker = false;
    private EntityLibraryKeeper get;

    public GuiLibrary(EntityPlayer entityplayer1, World world, EntityLibraryKeeper entitylibrarykeeper) {
        this.entityplayer = entityplayer1;
        this.worldObj = world;
        this.get = entitylibrarykeeper;
    }

    public void initGui() {
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(1, this.width / 2 - 70, 80, 140, 20, "Study in the library"));
        this.buttonList.add(new GuiButton(2, this.width / 2 - 70, 100, 140, 20, "Invest for the library"));
        this.buttonList.add(new GuiButton(4, this.width / 2 - 70, 120, 140, 20, "Research on Excalibur"));
        this.buttonList.add(new GuiButton(3, this.width / 2 - 70, 140, 140, 20, "Exit"));
    }

    protected void actionPerformed(GuiButton guibutton) {
        if (guibutton.id == 1) {
            if (this.get.studied) {
                this.worldObj.spawnEntityInWorld((Entity)new EntityXPOrb(this.worldObj, this.entityplayer.posX, this.entityplayer.posY, this.entityplayer.posZ, 150));
                if (!this.worldObj.isRemote) {
                    ChatMessage.add(this.entityplayer,"You have gained experience.");
                }
                this.get.studied = false;
            } else if (!this.worldObj.isRemote) {
                ChatMessage.add(this.entityplayer,"You have already studied for a while, go back in a few moments");
            }
            this.goldchecker = false;
        }
        if (guibutton.id == 2) {
            if (500 + UtilToK.libraryInvestment * 2 <= GoldKeeper.getGoldTotal()) {
                UtilToK.libraryInvestment += 5;
                if (!this.worldObj.isRemote) {
                    ChatMessage.add(this.entityplayer,"Tax is now increased by " + UtilToK.libraryInvestment + " gold per house.");
                }
                GoldKeeper.decreaseGold(500 + UtilToK.libraryInvestment * 2);
            } else {
                this.goldchecker = true;
            }
        }
        if (guibutton.id == 3) {
            this.mc.displayGuiScreen(null);
            this.goldchecker = false;
        }
        if (guibutton.id == 4) {
            // empty if block
        }
    }

    public void onGuiClosed() {
        if (!this.worldObj.isRemote) {
            ChatMessage.add(this.entityplayer,"Librarian: I will see you again hero.");
        }
    }

    public void drawScreen(int i, int j, float f) {
        for (int k = 0; k < this.buttonList.size(); ++k) {
            GuiButton guibutton = (GuiButton)this.buttonList.get(k);
            guibutton.drawButton(this.mc, i, j);
        }
        if (this.goldchecker) {
            this.drawCenteredString(this.fontRendererObj, "The Library Total Money: " + GoldKeeper.getGoldTotal() + " Gold Coins - NOT ENOUGH GOLD", this.width / 2, 20, 0xFFFFFF);
        } else {
            this.drawCenteredString(this.fontRendererObj, "The Library  Total Money: " + GoldKeeper.getGoldTotal() + " Gold Coins", this.width / 2, 20, 0xFFFFFF);
        }
        this.drawCenteredString(this.fontRendererObj, "Note: The more you invest, the more knowledge people gain to yield more tax.", this.width / 2, 170, 0xFFFFFF);
    }
}

