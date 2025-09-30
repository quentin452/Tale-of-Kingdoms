
package mods.aginsun.kingdoms.client.guis;

import net.minecraft.client.gui.GuiScreen;

public class GuiScreenToK
extends GuiScreen {
    public boolean doesGuiPauseGame() {
        return false;
    }

    protected void keyTyped(char par1, int par2) {
        if (par2 == 1 || par2 == this.mc.gameSettings.keyBindInventory.keyCode) {
            this.mc.thePlayer.closeScreen();
        }
    }
}

