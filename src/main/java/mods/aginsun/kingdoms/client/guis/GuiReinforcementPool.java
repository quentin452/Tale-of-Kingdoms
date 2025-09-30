
package mods.aginsun.kingdoms.client.guis;

import mods.aginsun.kingdoms.client.guis.GuiPriceBar;
import mods.aginsun.kingdoms.client.guis.GuiScreenToK;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class GuiReinforcementPool
extends GuiScreenToK {
    private GuiPriceBar knightPool;
    private float soldierNumber;

    public GuiReinforcementPool(EntityPlayer entityplayer1, World world, EntityCreature entitycreature) {
    }

    public void initGui() {
        this.buttonList.clear();
        this.knightPool = new GuiPriceBar(0, this.width / 2 - 100, 40, 90, 12, 1.0f, "red");
        this.knightPool.setBar(this.soldierNumber / 80.0f);
    }

    protected void actionPerformed(GuiButton guibutton) {
        if (guibutton.id == 0) {
            // empty if block
        }
        if (guibutton.id == 1) {
            // empty if block
        }
        if (guibutton.id == 2) {
            this.mc.displayGuiScreen(null);
        }
    }

    public void drawScreen(int i, int j, float f) {
        this.drawDefaultBackground();
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        int c = 255;
        int c1 = 255;
        ResourceLocation resource = new ResourceLocation("taleofkingdoms", "textures/guis/crafting.png");
        this.mc.renderEngine.bindTexture(resource);
        int i1 = (this.width - c) / 2;
        this.drawTexturedModalRect(i1, 0, 0, 0, c, c1);
        for (int l = 0; l < this.buttonList.size(); ++l) {
            if (!(this.buttonList.get(l) instanceof GuiButton)) continue;
            GuiButton guibutton = (GuiButton)this.buttonList.get(l);
            guibutton.drawButton(this.mc, i, j);
        }
        this.drawCenteredString(this.fontRendererObj, "Reinforcement Pool", this.width / 2, 15, 0xFFFFFF);
        this.knightPool.drawBar();
        super.drawScreen(i, j, f);
    }
}

