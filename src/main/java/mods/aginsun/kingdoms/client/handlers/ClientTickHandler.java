
package mods.aginsun.kingdoms.client.handlers;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import java.awt.Color;
import java.util.EnumSet;
import mods.aginsun.kingdoms.handlers.GoldKeeper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiInventory;

public class ClientTickHandler
implements ITickHandler {
    public void tickStart(EnumSet<TickType> type, Object ... tickData) {
    }

    public void tickEnd(EnumSet<TickType> type, Object ... tickData) {
        if (type.equals(EnumSet.of(TickType.RENDER))) {
            this.onRenderTick();
        } else if (type.equals(EnumSet.of(TickType.CLIENT))) {
            GuiScreen guiscreen = Minecraft.getMinecraft().currentScreen;
            if (guiscreen != null) {
                this.onTickInGUI(guiscreen);
            } else {
                this.onTickInGame();
            }
        }
    }

    public EnumSet<TickType> ticks() {
        return EnumSet.of(TickType.RENDER, TickType.CLIENT);
    }

    public String getLabel() {
        return "TaleofKingdomsClientTick";
    }

    public void onRenderTick() {
        Minecraft mc = Minecraft.getMinecraft();
        ScaledResolution scaled = new ScaledResolution(mc.gameSettings, mc.displayWidth, mc.displayHeight);
        if (mc.currentScreen instanceof GuiInventory && !mc.playerController.isInCreativeMode()) {
            mc.fontRenderer.drawString("Gold Total: " + GoldKeeper.getGoldTotal(), scaled.getScaledWidth() / 2 - 7, scaled.getScaledHeight() / 2 - 15, Color.RED.getRGB());
        }
    }

    public void onTickInGUI(GuiScreen guiscreen) {
    }

    public void onTickInGame() {
    }
}

