
package mods.aginsun.kingdoms.client.guis;

import mods.aginsun.kingdoms.entities.TileEntitySell;
import mods.aginsun.kingdoms.handlers.GoldKeeper;
import mods.aginsun.kingdoms.inventory.ContainerSell;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiSell
extends GuiContainer {
    public GuiSell(InventoryPlayer player_inventory, TileEntitySell tileentitysell) {
        super((Container)new ContainerSell(tileentitysell, player_inventory));
    }

    protected void drawGuiContainerForegroundLayer(int i, int j) {
        this.fontRendererObj.drawString("Total Money: ", 25, 40, 0x404040);
        this.fontRendererObj.drawString(GoldKeeper.getGoldTotal() + " Gold Coins", 30, 50, 0x404040);
        this.fontRendererObj.drawString("Inventory", 8, this.ySize - 96 + 2, 0x404040);
        this.fontRendererObj.drawString("Sell Menu", 25, 20, 0x404040);
    }

    protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        ResourceLocation resource = new ResourceLocation("taleofkingdoms", "textures/guis/guisell.png");
        this.mc.renderEngine.bindTexture(resource);
        int l = (this.width - this.xSize) / 2;
        int i1 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(l, i1, 0, 0, this.xSize, this.ySize);
    }

    protected void keyTyped(char par1, int par2) {
        if (par2 == 1 || par2 == this.mc.gameSettings.keyBindInventory.keyCode) {
            this.mc.thePlayer.closeScreen();
        }
    }
}

