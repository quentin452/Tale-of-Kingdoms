
package mods.aginsun.kingdoms.client.handlers;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import java.awt.Color;
import mods.aginsun.kingdoms.handlers.GoldKeeper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiInventory;

public class ClientTickHandler {
    
    @SubscribeEvent
    public void onRenderTick(TickEvent.RenderTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            this.onRenderTick();
        }
    }
    
    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            GuiScreen guiscreen = Minecraft.getMinecraft().currentScreen;
            if (guiscreen != null) {
                this.onTickInGUI(guiscreen);
            } else {
                this.onTickInGame();
            }
        }
    }

    public void onRenderTick() {
        Minecraft mc = Minecraft.getMinecraft();
        ScaledResolution scaled = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
        if (mc.currentScreen instanceof GuiInventory && !mc.playerController.isInCreativeMode()) {
            mc.fontRenderer.drawString("Gold Total: " + GoldKeeper.getGoldTotal(), scaled.getScaledWidth() / 2 - 7, scaled.getScaledHeight() / 2 - 15, Color.RED.getRGB());
        }
    }

    public void onTickInGUI(GuiScreen guiscreen) {
    }

    public void onTickInGame() {
    }
}

