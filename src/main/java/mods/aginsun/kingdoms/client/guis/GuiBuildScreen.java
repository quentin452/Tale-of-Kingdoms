/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.client.gui.GuiButton
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.world.World
 *  org.lwjgl.opengl.GL11
 */
package mods.aginsun.kingdoms.client.guis;

import mods.aginsun.kingdoms.client.guis.GuiButtonShop;
import mods.aginsun.kingdoms.client.guis.GuiPriceBar;
import mods.aginsun.kingdoms.client.guis.GuiScreenToK;
import mods.aginsun.kingdoms.handlers.GoldKeeper;
import mods.aginsun.kingdoms.handlers.ResourceHandler;
import mods.aginsun.kingdoms.handlers.SchematicHandler;
import mods.aginsun.kingdoms.handlers.SchematicRegistry;
import mods.aginsun.kingdoms.util.Buildings;
import mods.aginsun.kingdoms.util.UtilToK;
import net.minecraft.block.Block;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class GuiBuildScreen
extends GuiScreenToK {
    private World worldObj;
    private String x = "Build ";
    private GuiPriceBar woodBar;
    private GuiPriceBar cobblestoneBar;

    public GuiBuildScreen(EntityPlayer entityplayer1, World world) {
        this.worldObj = world;
    }

    public void initGui() {
        this.buttonList.clear();
        if (UtilToK.townX != 0 && UtilToK.townY != 0 && UtilToK.townZ != 0) {
            SchematicRegistry.registerAllBuildings(UtilToK.townX, UtilToK.townY, UtilToK.townZ);
        } else {
            SchematicRegistry.registerAllBuildings((int)this.mc.thePlayer.posX, (int)this.mc.thePlayer.posY, (int)this.mc.thePlayer.posZ);
        }
        this.woodBar = new GuiPriceBar(0, this.width / 2 - 100, 40, 90, 12, 1.0f, "red");
        this.woodBar.setBar((float)ResourceHandler.getInstance().getwoodResource() / 320.0f);
        this.cobblestoneBar = new GuiPriceBar(1, this.width / 2 - 100, 60, 90, 12, 1.0f, "red");
        this.cobblestoneBar.setBar((float)ResourceHandler.getInstance().getcobbleResource() / 320.0f);
        this.buttonList.add(new GuiButton(1, this.width / 2 - 25, 220, 50, 20, "Exit"));
        this.buttonList.add(new GuiButton(2, this.width / 2 - 110, 80, 110, 20, "Give 64 Wood Logs"));
        this.buttonList.add(new GuiButton(3, this.width / 2 + 5, 80, 110, 20, "Give 64 Cobblestone"));
        if (!Buildings.getBuilding(1)) {
            this.addButton(4, this.width / 2 - 55, 130, "Build Tier 1 City Base");
        } else if (!Buildings.getBuilding(8) && Buildings.getBuilding(1)) {
            if (!Buildings.getBuilding(2)) {
                this.addButton(5, this.width / 2 - 120, 120, this.x + "Small House");
            }
            if (!Buildings.getBuilding(3)) {
                this.addButton(6, this.width / 2 + 5, 120, this.x + "Small House");
            }
            if (!Buildings.getBuilding(4)) {
                this.addButton(7, this.width / 2 - 120, 180, this.x + "Large House");
            }
            if (!Buildings.getBuilding(6)) {
                this.addButton(8, this.width / 2 - 120, 140, this.x + "Item Shop");
            }
            if (!Buildings.getBuilding(7)) {
                this.addButton(9, this.width / 2 - 120, 160, this.x + "Stock Market");
            }
            if (!Buildings.getBuilding(8) && this.buttonList.size() == 3) {
                this.addButton(10, this.width / 2 - 55, 130, "Build Tier 2 City Base");
            }
        } else if (Buildings.getBuilding(8) && !Buildings.getBuilding(16)) {
            if (!Buildings.getBuilding(9)) {
                this.addButton(11, this.width / 2 - 120, 120, this.x + "Small House");
            }
            if (!Buildings.getBuilding(10)) {
                this.addButton(12, this.width / 2 - 120, 180, this.x + "Small House");
            }
            if (!Buildings.getBuilding(11)) {
                this.addButton(13, this.width / 2 - 120, 140, this.x + "Large House");
            }
            if (!Buildings.getBuilding(12)) {
                this.addButton(14, this.width / 2 - 120, 160, this.x + "Builder House");
            }
            if (!Buildings.getBuilding(13)) {
                this.addButton(15, this.width / 2 + 5, 120, this.x + "Barracks");
            }
            if (!Buildings.getBuilding(14)) {
                this.addButton(16, this.width / 2 + 5, 140, this.x + "Food Shop");
            }
            if (!Buildings.getBuilding(15)) {
                this.addButton(17, this.width / 2 + 5, 160, this.x + "Blocks Shop");
            }
            if (!Buildings.getBuilding(16) && this.buttonList.size() == 3) {
                this.addButton(18, this.width / 2 - 55, 130, "Build Tier 3 City Base");
            }
        } else if (Buildings.getBuilding(16) && !Buildings.getBuilding(25)) {
            if (!Buildings.getBuilding(17)) {
                this.addButton(19, this.width / 2 - 120, 140, this.x + "Small House");
            }
            if (!Buildings.getBuilding(18)) {
                this.addButton(20, this.width / 2 - 120, 160, this.x + "Small House");
            }
            if (!Buildings.getBuilding(19)) {
                this.addButton(21, this.width / 2 - 120, 180, this.x + "Small House");
            }
            if (!Buildings.getBuilding(20)) {
                this.addButton(22, this.width / 2 + 5, 160, this.x + "Large House");
            }
            if (!Buildings.getBuilding(21)) {
                this.addButton(23, this.width / 2 - 120, 120, this.x + "Tavern");
            }
            if (!Buildings.getBuilding(22)) {
                this.addButton(24, this.width / 2 + 5, 140, this.x + "Chapel");
            }
            if (!Buildings.getBuilding(23)) {
                this.addButton(25, this.width / 2 + 5, 180, this.x + "Library");
            }
            if (!Buildings.getBuilding(24)) {
                this.addButton(26, this.width / 2 + 5, 120, this.x + "Mage Hall");
            }
            if (!Buildings.getBuilding(25) && this.buttonList.size() == 3) {
                this.addButton(27, this.width / 2 - 55, 130, "Build Tier 4 City Base");
            }
        } else if (Buildings.getBuilding(25) && !Buildings.getBuilding(26)) {
            if (!Buildings.getBuilding(31)) {
                this.addButton(28, this.width / 2 - 120, 120, this.x + "LightHouse");
            }
            if (!Buildings.getBuilding(29)) {
                this.addButton(29, this.width / 2 - 120, 140, this.x + "Eastern Tower");
            }
            if (!Buildings.getBuilding(30)) {
                this.addButton(30, this.width / 2 - 120, 160, this.x + "Fish Hut");
            }
            if (!Buildings.getBuilding(32)) {
                this.addButton(31, this.width / 2 + 5, 140, this.x + "Mill");
            }
            if (!Buildings.getBuilding(33)) {
                this.addButton(32, this.width / 2 + 5, 120, this.x + "Observer Post");
            }
            if (!Buildings.getBuilding(26) && this.buttonList.size() == 3) {
                this.buttonList.add(new GuiButton(33, this.width / 2 - 65, 130, 140, 20, "Build Bridge To Next Part"));
            }
        } else if (Buildings.getBuilding(26) && !Buildings.getBuilding(27)) {
            if (!Buildings.getBuilding(34)) {
                this.addButton(34, this.width / 2 - 120, 120, this.x + "Small House");
            }
            if (!Buildings.getBuilding(35)) {
                this.addButton(35, this.width / 2 - 120, 140, this.x + "Small House");
            }
            if (!Buildings.getBuilding(36)) {
                this.addButton(36, this.width / 2 - 120, 160, this.x + "Small House");
            }
            if (!Buildings.getBuilding(37)) {
                this.addButton(37, this.width / 2 - 120, 180, this.x + "Small House");
            }
            if (!Buildings.getBuilding(38)) {
                this.addButton(38, this.width / 2 - 120, 200, this.x + "Large House");
            }
            if (!Buildings.getBuilding(39)) {
                this.addButton(39, this.width / 2 + 5, 120, this.x + "Center Tower");
            }
            if (!Buildings.getBuilding(40)) {
                this.addButton(40, this.width / 2 + 5, 140, this.x + "Northern Tower");
            }
            if (!Buildings.getBuilding(28)) {
                this.addButton(41, this.width / 2 + 5, 160, this.x + "Colloseum");
            }
            if (!Buildings.getBuilding(41)) {
                this.addButton(42, this.width / 2 + 5, 180, this.x + "Stables");
            }
            if (!Buildings.getBuilding(42)) {
                this.addButton(43, this.width / 2 + 5, 200, this.x + "Zeppelin");
            }
            if (!Buildings.getBuilding(27) && this.buttonList.size() == 3) {
                this.addButton(44, this.width / 2 - 65, 130, "Build Castle");
            }
        }
    }

    public void actionPerformed(GuiButton guibutton) {
        int speed = 200;
        if (guibutton.id == 1) {
            this.mc.displayGuiScreen(null);
        } else if (guibutton.id == 2) {
            int j = this.mc.thePlayer.inventory.getInventorySlotContainItem(Block.wood.blockID);
            if (j >= 0 && this.mc.thePlayer.inventory.getStackInSlot((int)j).stackSize == 64) {
                this.mc.thePlayer.inventory.setInventorySlotContents(j, null);
                ResourceHandler.getInstance().addwoodResource(64);
            }
        } else if (guibutton.id == 3) {
            int j = this.mc.thePlayer.inventory.getInventorySlotContainItem(Block.cobblestone.blockID);
            if (j >= 0 && this.mc.thePlayer.inventory.getStackInSlot((int)j).stackSize == 64) {
                this.mc.thePlayer.inventory.setInventorySlotContents(j, null);
                ResourceHandler.getInstance().addcobbleResource(64);
            }
        } else if (guibutton.id == 4) {
            UtilToK.townX = (int)this.mc.thePlayer.posX;
            UtilToK.townY = (int)this.mc.thePlayer.posY;
            UtilToK.townZ = (int)this.mc.thePlayer.posZ;
            this.createBuilding(1, 100, 0, 0);
        }
        switch (guibutton.id) {
            case 5: {
                if (!this.x(128, 192)) break;
                this.createBuilding(2, speed, 128, 192);
                break;
            }
            case 6: {
                if (!this.x(128, 192)) break;
                this.createBuilding(3, speed, 128, 192);
                break;
            }
            case 7: {
                if (!this.x(320, 192)) break;
                this.createBuilding(4, speed, 320, 192);
                break;
            }
            case 8: {
                if (!this.x(256, 256)) break;
                this.createBuilding(6, speed, 256, 256);
                break;
            }
            case 9: {
                if (!this.x(128, 128)) break;
                this.createBuilding(7, speed, 192, 192);
                break;
            }
            case 10: {
                if (!this.x(128, 128)) break;
                this.createBuilding(8, speed, 128, 128);
                break;
            }
            case 11: {
                if (!this.x(128, 192)) break;
                this.createBuilding(9, speed, 128, 192);
                break;
            }
            case 12: {
                if (!this.x(128, 192)) break;
                this.createBuilding(10, speed, 128, 192);
                break;
            }
            case 13: {
                if (!this.x(320, 192)) break;
                this.createBuilding(11, speed, 320, 192);
                break;
            }
            case 14: {
                if (!this.x(128, 128)) break;
                this.createBuilding(12, speed, 128, 128);
                break;
            }
            case 15: {
                if (!this.x(320, 320)) break;
                this.createBuilding(13, speed, 320, 320);
                break;
            }
            case 16: {
                if (!this.x(256, 192)) break;
                this.createBuilding(14, speed, 256, 192);
                break;
            }
            case 17: {
                if (!this.x(320, 256)) break;
                this.createBuilding(15, speed, 320, 256);
                break;
            }
            case 18: {
                if (!this.x(128, 128)) break;
                this.createBuilding(16, speed, 128, 128);
                break;
            }
            case 19: {
                if (!this.x(128, 192)) break;
                this.createBuilding(17, speed, 128, 192);
                break;
            }
            case 20: {
                if (!this.x(128, 192)) break;
                this.createBuilding(18, speed, 128, 192);
                break;
            }
            case 21: {
                if (!this.x(128, 192)) break;
                this.createBuilding(19, speed, 128, 192);
                break;
            }
            case 22: {
                if (!this.x(320, 192)) break;
                this.createBuilding(20, speed, 320, 192);
                break;
            }
            case 23: {
                if (!this.x(128, 320)) break;
                this.createBuilding(21, speed, 128, 320);
                break;
            }
            case 24: {
                if (!this.x(320, 320)) break;
                this.createBuilding(22, speed, 320, 320);
                break;
            }
            case 25: {
                if (!this.x(256, 256)) break;
                this.createBuilding(23, speed, 256, 256);
                break;
            }
            case 26: {
                if (!this.x(320, 256)) break;
                this.createBuilding(24, speed, 320, 256);
                break;
            }
            case 27: {
                if (!this.x(256, 256)) break;
                this.createBuilding(25, 800, 256, 256);
                break;
            }
            case 28: {
                if (!this.x(128, 128)) break;
                this.createBuilding(31, speed, 128, 128);
                break;
            }
            case 29: {
                if (!this.x(256, 128)) break;
                this.createBuilding(29, speed, 256, 128);
                break;
            }
            case 30: {
                if (!this.x(128, 192)) break;
                this.createBuilding(30, speed, 128, 192);
                break;
            }
            case 31: {
                if (!this.x(128, 128)) break;
                this.createBuilding(32, speed, 128, 128);
                break;
            }
            case 32: {
                if (!this.x(64, 128)) break;
                this.createBuilding(33, speed, 64, 128);
                break;
            }
            case 33: {
                if (!this.x(64, 0)) break;
                this.createBuilding(26, 5, 64, 0);
                break;
            }
            case 34: {
                if (!this.x(320, 192)) break;
                this.createBuilding(34, speed, 320, 192);
                break;
            }
            case 35: {
                if (!this.x(320, 192)) break;
                this.createBuilding(35, speed, 320, 192);
                break;
            }
            case 36: {
                if (!this.x(128, 192)) break;
                this.createBuilding(36, speed, 128, 192);
                break;
            }
            case 37: {
                if (!this.x(128, 192)) break;
                this.createBuilding(37, speed, 128, 192);
                break;
            }
            case 38: {
                if (!this.x(320, 256)) break;
                this.createBuilding(38, speed, 320, 256);
                break;
            }
            case 39: {
                if (!this.x(256, 256)) break;
                this.createBuilding(39, speed, 256, 256);
                break;
            }
            case 40: {
                if (!this.x(256, 256)) break;
                this.createBuilding(40, speed, 256, 256);
                break;
            }
            case 41: {
                if (!this.x(320, 320)) break;
                this.createBuilding(28, speed, 320, 320);
                break;
            }
            case 42: {
                if (!this.x(320, 256)) break;
                this.createBuilding(41, speed, 320, 256);
                this.createBuilding(43, speed, 0, 0);
                this.createBuilding(44, speed, 0, 0);
                break;
            }
            case 43: {
                if (!this.x(256, 320)) break;
                this.createBuilding(42, speed, 256, 320);
                break;
            }
            case 44: {
                if (!this.x(320, 320)) break;
                this.createBuilding(27, speed, 320, 320);
            }
        }
        this.initGui();
    }

    private void createBuilding(int buildingNumber, int speed, int resource1, int resource2) {
        SchematicHandler.getInstance().addBuilding(SchematicRegistry.getSchematic(buildingNumber).setSpeed(speed));
        ResourceHandler.getInstance().decreasecobbleResource(resource1);
        ResourceHandler.getInstance().decreasewoodResource(resource2);
        Buildings.setBuildingTrue(buildingNumber);
    }

    private boolean x(int i, int j) {
        return ResourceHandler.getInstance().getcobbleResource() >= i && ResourceHandler.getInstance().getwoodResource() >= j;
    }

    private void addButton(int id, int posX, int posZ, String name) {
        this.buttonList.add(new GuiButton(id, posX, posZ, 120, 20, name));
    }

    public void drawScreen(int i, int j, float f) {
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        int c = 255;
        int c1 = 255;
        ResourceLocation resource = new ResourceLocation("taleofkingdoms", "/textures/guis/crafting.png");
        if (resource != null) {
            this.mc.renderEngine.bindTexture(resource);
        }
        int i1 = (this.width - c) / 2;
        this.drawTexturedModalRect(i1, 0, 0, 0, c, c1);
        for (int l = 0; l < this.buttonList.size(); ++l) {
            if (this.buttonList.get(l) instanceof GuiButtonShop) {
                GuiButtonShop guibuttonshop = (GuiButtonShop)((Object)this.buttonList.get(l));
                guibuttonshop.drawButton(this.mc, i, j);
            }
            if (!(this.buttonList.get(l) instanceof GuiButton)) continue;
            GuiButton guibutton = (GuiButton)this.buttonList.get(l);
            guibutton.drawButton(this.mc, i, j);
        }
        if (!Buildings.isTier2 && !this.worldObj.isRemote) {
            this.drawCenteredString(this.fontRendererObj, "Build Menu Tier 1 - Total Money: " + GoldKeeper.getGoldTotal() + " Gold Coins", this.width / 2, 15, 0xFFCC00);
        }
        if (Buildings.isTier2 && !Buildings.isTier3) {
            this.drawCenteredString(this.fontRendererObj, "Build Menu Tier 2 - Total Money: " + GoldKeeper.getGoldTotal() + " Gold Coins", this.width / 2, 15, 0xFFCC00);
        }
        if (Buildings.isTier3) {
            this.drawCenteredString(this.fontRendererObj, "Build Menu Tier 3 - Total Money: " + GoldKeeper.getGoldTotal() + " Gold Coins", this.width / 2, 15, 0xFFCC00);
        }
        if (this.woodBar != null) {
            this.woodBar.drawBar();
        }
        if (this.cobblestoneBar != null) {
            this.cobblestoneBar.drawBar();
        }
        this.drawString(this.fontRendererObj, "0       160      320 ", this.width / 2 - 100, 30, 0xFFFFFF);
        this.drawString(this.fontRendererObj, "logs Resource", this.width / 2, 40, 0xFFCC00);
        this.drawString(this.fontRendererObj, "CobbleStone Resource", this.width / 2, 60, 0xFFCC00);
    }
}

