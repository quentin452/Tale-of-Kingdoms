
package mods.aginsun.kingdoms.client.guis;

import java.awt.Color;
import mods.aginsun.kingdoms.handlers.GoldKeeper;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.init.Items;
import net.minecraft.world.World;
import mods.aginsun.kingdoms.util.ChatMessage;

public class GuiStableMaster
extends GuiScreen {
    public void initGui() {
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(1, this.width / 2 - 60, this.height / 2 - 10, 120, 20, "Buy Starter Kit!"));
        this.buttonList.add(new GuiButton(2, this.width / 2 - 60, this.height / 2 - 10, 120, 20, "Buy Expert Kit!"));
        this.buttonList.add(new GuiButton(3, this.width / 2 - 60, this.height / 2 + 10, 120, 20, "Exit!"));
    }

    public void actionPerformed(GuiButton guibutton) {
        if (guibutton.id == 1) {
            if (GoldKeeper.getGoldTotal() >= 1500) {
                this.mc.thePlayer.entityDropItem(new net.minecraft.item.ItemStack(Items.saddle, 1), 0.0F);
                this.mc.thePlayer.entityDropItem(new net.minecraft.item.ItemStack(Items.lead, 1), 0.0F);
                this.mc.thePlayer.entityDropItem(new net.minecraft.item.ItemStack(Items.wheat, 15), 0.0F);
                this.mc.thePlayer.entityDropItem(new net.minecraft.item.ItemStack(Items.name_tag, 1), 0.0F);
            } else {
                ChatMessage.add(this.mc.thePlayer,"You don't have enough money!");
            }
        } else if (guibutton.id == 2) {
            if (GoldKeeper.getGoldTotal() >= 7500) {
                this.mc.thePlayer.entityDropItem(new net.minecraft.item.ItemStack(Items.diamond_horse_armor, 1), 0.0F);
                this.mc.thePlayer.entityDropItem(new net.minecraft.item.ItemStack(Items.wheat, 64), 0.0F);
                EntityHorse entity = new EntityHorse((World)this.mc.theWorld);
                entity.setHorseType(0);
                this.mc.theWorld.spawnEntityInWorld((Entity)entity);
            } else {
                ChatMessage.add(this.mc.thePlayer,"You don't have enough money!");
            }
        } else if (guibutton.id == 3) {
            this.mc.setIngameFocus();
        }
    }

    public void drawScreen(int i, int j, float f) {
    String s = "Starter Kit: Saddle, lead, wheat and a name tag for the price of 1500 gold!";
    String s1 = "Expert Kit: Horse armor, a stack of wheat and a horse for the low price of 7500 gold!";
    this.drawString(this.mc.fontRenderer, s, this.width / 2 - this.mc.fontRenderer.getStringWidth(s) / 2, this.height / 2 - 30, Color.ORANGE.getRGB());
    this.drawString(this.mc.fontRenderer, s1, this.width / 2 - this.mc.fontRenderer.getStringWidth(s1) / 2, this.height / 2 - 15, Color.ORANGE.getRGB());
    }
}

