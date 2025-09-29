/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.GuiButton
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.ResourceLocation
 */
package mods.aginsun.kingdoms.client.guis;

import mods.aginsun.kingdoms.client.guis.GuiShopList;
import mods.aginsun.kingdoms.client.guis.GuiStockList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class GuiButtonShop
extends GuiButton {
    private GuiShopList gui;
    private GuiStockList gui2;
    private Item item;
    private Integer itemID;
    protected int width;
    protected int height;
    public int xPosition;
    public int yPosition;
    private String displayString;
    public int id;
    public boolean enabled;
    public boolean enabled2;

    public GuiButtonShop(Integer integer, GuiShopList guishoplist, int i, int j, int k, int l, int i1, String s) {
        super(i, j, k, 200, 20, s);
        Item item1;
        this.gui = guishoplist;
        this.itemID = integer;
        this.item = item1 = new ItemStack(integer.intValue(), 1, 0).getItem();
        this.width = 200;
        this.height = 20;
        this.enabled = true;
        this.enabled2 = true;
        this.id = i;
        this.xPosition = j;
        this.yPosition = k;
        this.width = l;
        this.height = i1;
        this.displayString = s;
    }

    public GuiButtonShop(Item item1, GuiStockList guistocklist, int i, int j, int k, int l, int i1, String s) {
        super(i, j, k, 200, 20, s);
        this.gui2 = guistocklist;
        this.item = item1;
        this.width = 200;
        this.height = 20;
        this.enabled = true;
        this.enabled2 = true;
        this.id = i;
        this.xPosition = j;
        this.yPosition = k;
        this.width = l;
        this.height = i1;
        this.displayString = s;
    }

    protected int getHoverState(boolean flag) {
        int byte0 = 1;
        if (!this.enabled) {
            byte0 = 0;
        } else if (flag) {
            byte0 = 2;
        }
        return byte0;
    }

    public void drawButton(Minecraft minecraft, int i, int j) {
        if (!this.enabled2) {
            return;
        }
        FontRenderer fontrenderer = minecraft.fontRenderer;
        ResourceLocation resource = new ResourceLocation("taleofkingdoms", "textures/guis/gui.png");
        minecraft.renderEngine.bindTexture(resource);
        boolean flag = i >= this.xPosition && j >= this.yPosition && i < this.xPosition + this.width && j < this.yPosition + this.height;
        int k = this.getHoverState(flag);
        if (this.gui != null) {
            k = this.gui.itemSelected == this.itemID ? 2 : 1;
        }
        if (this.gui2 != null) {
            k = this.gui2.itemSelected == this.item ? 2 : 1;
        }
        this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 46 + k * 20, this.width / 2, this.height);
        this.drawTexturedModalRect(this.xPosition + this.width / 2, this.yPosition, 200 - this.width / 2, 46 + k * 20, this.width / 2, this.height);
        this.mouseDragged(minecraft, i, j);
        if (!this.enabled) {
            this.drawCenteredString(fontrenderer, this.displayString, this.xPosition + this.width / 2 - 20, this.yPosition + (this.height - 8) / 2, -13312);
        } else if (!flag) {
            this.drawCenteredString(fontrenderer, this.displayString, this.xPosition + this.width / 2 - 20, this.yPosition + (this.height - 8) / 2, 0xFFFFFF);
        } else {
            this.drawCenteredString(fontrenderer, this.displayString, this.xPosition + this.width / 2 - 20, this.yPosition + (this.height - 8) / 2, 52224);
        }
    }
}

