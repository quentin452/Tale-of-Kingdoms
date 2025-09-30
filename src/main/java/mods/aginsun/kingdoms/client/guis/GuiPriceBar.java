
package mods.aginsun.kingdoms.client.guis;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import org.lwjgl.opengl.GL11;

public class GuiPriceBar
extends Gui {
    public int xPosition;
    public int borderColor = -10592674;
    public int yPosition;
    private int width;
    private int height;
    public float barPosition;
    public int id;
    public boolean border;
    public int colour;

    public GuiPriceBar(int i, int j, int k, int l, int i1, float f) {
        this.barPosition = f >= 0.0f && f <= 1.0f ? f : 0.0f;
        this.id = i;
        this.colour = -2553077;
        this.xPosition = j;
        this.yPosition = k;
        this.width = l;
        this.height = i1;
        this.border = true;
    }

    public GuiPriceBar(int i, int j, int k, int l, int i1, float f, int j1) {
        this(i, j, k, l, i1, f);
        this.colour = j1;
    }

    public GuiPriceBar(int i, int j, int k, int l, int i1, float f, String s) {
        this(i, j, k, l, i1, f);
        this.colour = s.equalsIgnoreCase("red") ? -2553077 : (s.equalsIgnoreCase("green") ? -16298223 : (s.equalsIgnoreCase("blue") ? -15000608 : -1));
    }

    public void setBar(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            this.barPosition = f;
        }
    }

    public void drawBar() {
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        if (this.border) {
            GuiPriceBar.drawRect((int)this.xPosition, (int)this.yPosition, (int)(this.xPosition + this.width), (int)(this.yPosition + this.height), (int)this.borderColor);
        }
        GuiPriceBar.drawRect((int)(this.xPosition + 1), (int)(this.yPosition + 1), (int)(this.xPosition + 1 + this.width - 2), (int)(this.yPosition + 1 + this.height - 2), (int)-16777216);
        GuiPriceBar.drawRect((int)(this.xPosition + 1), (int)(this.yPosition + 1), (int)(this.xPosition + 1 + (int)(this.barPosition * (float)(this.width - 2))), (int)(this.yPosition + 1 + this.height - 2), (int)this.colour);
    }

    public boolean mousePressed(Minecraft minecraft, int i, int j) {
        return i >= this.xPosition && j >= this.yPosition && i < this.xPosition + this.width && j < this.yPosition + this.height;
    }
}

