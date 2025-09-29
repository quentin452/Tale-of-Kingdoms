/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiButton
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.entity.player.EntityPlayer
 */
package mods.aginsun.kingdoms.client.guis;

import mods.aginsun.kingdoms.client.guis.GuiScreenToK;
import mods.aginsun.kingdoms.client.guis.GuiToKLoading;
import mods.aginsun.kingdoms.handlers.Schematic;
import mods.aginsun.kingdoms.handlers.SchematicHandler;
import mods.aginsun.kingdoms.util.Buildings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;

public class GuiStartConquest
extends GuiScreenToK {
    public EntityPlayer player;
    private Minecraft mc;

    public GuiStartConquest(Minecraft minecraft) {
        this.mc = minecraft;
    }

    public void initGui() {
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(1, this.width / 2 - 70, this.height / 2, 140, 20, "Start new Conquest."));
        this.buttonList.add(new GuiButton(2, this.width / 2 - 70, this.height / 2 + 20, 140, 20, "Cancel."));
    }

    protected void actionPerformed(GuiButton guibutton) {
        if (guibutton.id == 1) {
            this.player = this.mc.thePlayer;
            Schematic schematic = new Schematic("/mods/aginsun/kingdoms/schematics/GuildCastle").setPosition((int)this.player.posX, (int)this.player.posY, (int)this.player.posZ).setSpeed(75);
            SchematicHandler.getInstance().addBuilding(schematic);
            Buildings.setBuildingTrue(0);
            this.mc.displayGuiScreen(null);
            this.mc.displayGuiScreen((GuiScreen)new GuiToKLoading());
        }
        if (guibutton.id == 2) {
            this.mc.displayGuiScreen(null);
        }
    }

    public void drawScreen(int i, int j, float f) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, "The Tale of Kingdoms ver 1.5-Pre Release", this.width / 2, this.height / 2 - 50, 0xFFFFFF);
        this.drawCenteredString(this.fontRendererObj, "The Great Tides of Darkness has come.", this.width / 2, this.height / 2 - 40, 0xFFFFFF);
        this.drawCenteredString(this.fontRendererObj, "The Reficules have come and it is up to you to save what is left.", this.width / 2, this.height / 2 - 30, 0xFFFFFF);
        this.drawCenteredString(this.fontRendererObj, "You are the last heir to the throne. The only hope of the overworld.", this.width / 2, this.height / 2 - 20, 0xFFFFFF);
        this.drawCenteredString(this.fontRendererObj, "Your adventure starts here, hero. The Guild will prepare you.", this.width / 2, this.height / 2 - 10, 0xFFFFFF);
        this.drawCenteredString(this.fontRendererObj, "Note: Build outside of the kingdom unless the location is specified for you.", this.width / 2, this.height / 2 + 40, 0xFFFFFF);
        this.drawCenteredString(this.fontRendererObj, "Note: selling is done through a block next to the npcs.", this.width / 2, this.height / 2 + 50, 0xFFFFFF);
        for (int k = 0; k < this.buttonList.size(); ++k) {
            GuiButton guibutton = (GuiButton)this.buttonList.get(k);
            guibutton.drawButton(this.mc, i, j);
        }
    }
}

