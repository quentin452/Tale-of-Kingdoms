/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.FMLCommonHandler
 *  net.minecraft.client.gui.GuiButton
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.ItemStack
 *  net.minecraft.world.World
 */
package mods.aginsun.kingdoms.client.guis;

import cpw.mods.fml.common.FMLCommonHandler;
import mods.aginsun.kingdoms.client.guis.GuiButtonShop;
import mods.aginsun.kingdoms.client.guis.GuiPriceBar;
import mods.aginsun.kingdoms.client.guis.GuiScreenToK;
import mods.aginsun.kingdoms.handlers.GoldKeeper;
import mods.aginsun.kingdoms.handlers.ResourceHandler;
import mods.aginsun.kingdoms.handlers.WorkerHandler;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import mods.aginsun.kingdoms.util.ChatMessage;

public class GuiQuarry
extends GuiScreenToK {
    private World worldObj = FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(0);
    public EntityPlayer entityplayer;
    boolean goldchecker = false;
    private GuiPriceBar bar;

    public GuiQuarry(EntityPlayer entityplayer1, World world) {
        this.entityplayer = entityplayer1;
        this.worldObj = world;
    }

    public void initGui() {
        this.bar = new GuiPriceBar(0, this.width / 2 - 100, 40, 90, 12, 1.0f, "red");
        this.bar.setBar((float)ResourceHandler.getInstance().getCobblePool() / 320.0f);
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, 75, 90, 20, "Collect 64"));
        this.buttonList.add(new GuiButton(2, this.width / 2 - 100, 95, 90, 20, "Buy Worker."));
        this.buttonList.add(new GuiButton(3, this.width / 2 - 100, 115, 90, 20, "Cancel."));
    }

    protected void actionPerformed(GuiButton guibutton) {
        if (guibutton.id == 1 && ResourceHandler.getInstance().getCobblePool() >= 64) {
            ItemStack itemstack = new ItemStack(4, 64, 0);
            EntityItem entityitem = new EntityItem(this.worldObj, this.entityplayer.posX, this.entityplayer.posY, this.entityplayer.posZ, itemstack);
            this.worldObj.spawnEntityInWorld((Entity)entityitem);
            this.goldchecker = false;
            ResourceHandler.getInstance().decreaseCobblePool(64);
        } else if (guibutton.id == 1 && ResourceHandler.getInstance().getCobblePool() < 64 && !this.worldObj.isRemote) {
            ChatMessage.add(this.entityplayer,"Foreman: Come back again later when we have the resources.");
        }
        if (guibutton.id == 2) {
            if (GoldKeeper.getGoldTotal() >= 1500) {
                if (WorkerHandler.getInstance().getQuarryMembers() < 12) {
                    WorkerHandler.getInstance().addQuarryMember();
                    GoldKeeper.decreaseGold(1500);
                    if (!this.worldObj.isRemote) {
                        ChatMessage.add(this.entityplayer,"Foreman: He will begin to work immediately.");
                    }
                } else if (!this.worldObj.isRemote) {
                    ChatMessage.add(this.entityplayer,"Foreman: We have reached the capacity of men. Hire civilian workers instead.");
                }
            } else {
                this.goldchecker = true;
            }
        }
        if (guibutton.id == 3) {
            this.mc.displayGuiScreen(null);
        }
    }

    public void drawScreen(int i, int j, float f) {
        for (int k = 0; k < this.buttonList.size(); ++k) {
            if (this.buttonList.get(k) instanceof GuiButtonShop) {
                GuiButtonShop guibuttonshop = (GuiButtonShop)((Object)this.buttonList.get(k));
                guibuttonshop.drawButton(this.mc, i, j);
            }
            GuiButton guibutton = (GuiButton)this.buttonList.get(k);
            guibutton.drawButton(this.mc, i, j);
        }
        if (!this.goldchecker) {
            this.drawCenteredString(this.fontRendererObj, "Foreman Menu - Total Money: " + GoldKeeper.getGoldTotal() + " Gold Coins", this.width / 2, 15, 0xFFFFFF);
        } else {
            this.drawCenteredString(this.fontRendererObj, "Foreman Menu - Total Money: " + GoldKeeper.getGoldTotal() + " Gold Coins - NOT ENOUGH GOLD", this.width / 2, 15, 0xFFFFFF);
        }
        this.drawString(this.fontRendererObj, "-Resources-    Note: Worker cost 1500 gold coins.", this.width / 2 - 87, 55, 0xFFFFFF);
        this.bar.drawBar();
    }
}

