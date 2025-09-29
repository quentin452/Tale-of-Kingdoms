/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiButton
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.ChunkCoordinates
 *  net.minecraft.world.World
 */
package mods.aginsun.kingdoms.client.guis;

import mods.aginsun.kingdoms.client.guis.GuiScreenToK;
import mods.aginsun.kingdoms.handlers.GoldKeeper;
import mods.aginsun.kingdoms.util.UtilToK;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;

public class GuiWardenMenu
extends GuiScreenToK {
    private World worldObj;
    public EntityPlayer player;
    boolean goldchecker;

    public GuiWardenMenu(EntityPlayer player, World world) {
        this.player = player;
        this.goldchecker = false;
        this.worldObj = world;
    }

    public void initGui() {
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(1, this.width / 2 + 110, 160, 100, 20, "Recruit a Knight."));
        this.buttonList.add(new GuiButton(2, this.width / 2 + 110, 180, 100, 20, "Recruit an Archer."));
        this.buttonList.add(new GuiButton(4, this.width / 2 + 110, 200, 100, 20, "Recall defenders"));
        this.buttonList.add(new GuiButton(3, this.width / 2 + 110, 220, 100, 20, "Exit"));
    }

    protected void actionPerformed(GuiButton guibutton) {
        if (guibutton.id == 1) {
            if (1000 <= GoldKeeper.getGoldTotal()) {
                UtilToK.spawnEntity(this.worldObj, "DefendWarrior", new ChunkCoordinates((int)this.player.posX, (int)this.player.posY, (int)this.player.posZ));
                GoldKeeper.decreaseGold(1000);
            } else {
                this.goldchecker = true;
            }
        }
        if (guibutton.id == 2) {
            if (1000 <= GoldKeeper.getGoldTotal()) {
                UtilToK.spawnEntity(this.worldObj, "DefendArcher", new ChunkCoordinates((int)this.player.posX, (int)this.player.posY, (int)this.player.posZ));
                GoldKeeper.decreaseGold(1000);
            } else {
                this.goldchecker = true;
            }
        }
        if (guibutton.id == 3) {
            this.mc.displayGuiScreen(null);
            this.goldchecker = false;
        }
    }

    public void onGuiClosed() {
        this.player.addChatMessage("Warden: Good Day.");
    }

    public void drawScreen(int i, int j, float f) {
        for (int k = 0; k < this.buttonList.size(); ++k) {
            GuiButton guibutton = (GuiButton)this.buttonList.get(k);
            guibutton.drawButton(this.mc, i, j);
        }
        if (this.goldchecker) {
            this.drawCenteredString(this.fontRenderer, "Barracks Total Money: " + GoldKeeper.getGoldTotal() + " Gold Coins - NOT ENOUGH GOLD", this.width / 2, 20, 0xFFCC00);
        } else {
            this.drawCenteredString(this.fontRenderer, "Barracks  Total Money: " + GoldKeeper.getGoldTotal() + " Gold Coins", this.width / 2, 10, 0xFFCC00);
        }
        this.drawCenteredString(this.fontRenderer, "Note: The knights and archers will upgrade if they damage enough monsters!", this.width / 2, 20, 0xFFCC00);
        this.drawCenteredString(this.fontRenderer, " 1000 gold per hire.", this.width / 2, 30, 0xFFCC00);
    }
}

