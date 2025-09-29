/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiButton
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.Item
 */
package mods.aginsun.kingdoms.client.guis;

import java.awt.Color;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;

public class GuiFisher
extends GuiScreen {
    EntityPlayer player;

    public GuiFisher(EntityPlayer player) {
        this.player = player;
    }

    public void initGui() {
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(1, this.width / 2 - 60, this.height / 2 - 10, 120, 20, "Get Fishing Rod!"));
        this.buttonList.add(new GuiButton(2, this.width / 2 - 60, this.height / 2 + 10, 120, 20, "Exit!"));
    }

    public void actionPerformed(GuiButton guibutton) {
        if (guibutton.id == 1) {
            this.player.dropItem(Item.fishingRod.itemID, 1);
            this.mc.thePlayer.addChatMessage("Here ya go, your new beautiful fishing rod!");
        }
        if (guibutton.id == 2) {
            this.mc.setIngameFocus();
        }
    }

    public void drawScreen(int i, int j, float f) {
        this.drawString(this.mc.fontRenderer, "Get your best fishing rods here lad.", this.width / 2 - this.mc.fontRenderer.getStringWidth("Get your best fishing rods here lad.") / 2, this.height / 2 - 30, Color.ORANGE.getRGB());
        super.drawScreen(i, j, f);
    }
}

