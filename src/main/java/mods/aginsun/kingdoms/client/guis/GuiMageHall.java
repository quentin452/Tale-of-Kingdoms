/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.FMLCommonHandler
 *  net.minecraft.client.gui.GuiButton
 *  net.minecraft.enchantment.EnchantmentData
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityList
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.ItemStack
 *  net.minecraft.world.World
 */
package mods.aginsun.kingdoms.client.guis;

import cpw.mods.fml.common.FMLCommonHandler;
import java.util.List;
import java.util.Random;
import mods.aginsun.kingdoms.client.guis.GuiScreenToK;
import mods.aginsun.kingdoms.handlers.GoldKeeper;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class GuiMageHall
extends GuiScreenToK {
    private World worldObj = FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(0);
    public EntityPlayer entityplayer;
    boolean goldchecker = false;
    int price = 500;

    public GuiMageHall(EntityPlayer entityplayer1, World world) {
        this.entityplayer = entityplayer1;
        this.worldObj = world;
    }

    public void initGui() {
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(2, this.width / 2 + 90, 200, 125, 20, "Recruit a Mage"));
        this.buttonList.add(new GuiButton(3, this.width / 2 + 90, 220, 125, 20, "Exit"));
    }

    protected void actionPerformed(GuiButton guibutton) {
        if (guibutton.id == 1) {
            // empty if block
        }
        if (guibutton.id == 2) {
            if (2000 <= GoldKeeper.getGoldTotal()) {
                EntityLiving entityliving = (EntityLiving)EntityList.createEntityByName((String)"DefendMage", (World)this.worldObj);
                entityliving.setLocationAndAngles(this.entityplayer.posX, this.entityplayer.posY, this.entityplayer.posZ, 0.0f, 0.0f);
                this.worldObj.spawnEntityInWorld((Entity)entityliving);
                GoldKeeper.decreaseGold(2000);
            } else {
                this.goldchecker = true;
            }
        }
        if (guibutton.id == 3) {
            this.mc.displayGuiScreen(null);
            this.goldchecker = false;
        }
        if (guibutton.id == 4) {
            ItemStack itemstack = this.entityplayer.inventory.getCurrentItem();
            if (this.price <= GoldKeeper.getGoldTotal() && itemstack != null) {
                Random random = new Random();
                int[] ai = new int[3];
                for (int j = 0; j < 3; ++j) {
                    ai[j] = EnchantmentHelper.calcItemStackEnchantability((Random)random, (int)j, (int)30, (ItemStack)itemstack);
                }
                int k = random.nextInt(3);
                List list1 = EnchantmentHelper.buildEnchantmentList((Random)random, (ItemStack)itemstack, (int)ai[k]);
                if (list1 != null) {
                    for (EnchantmentData enchantmentdata : list1) {
                        itemstack.addEnchantment(enchantmentdata.enchantmentobj, enchantmentdata.enchantmentLevel);
                    }
                    GoldKeeper.decreaseGold(500);
                } else if (!this.worldObj.isRemote) {
                    this.entityplayer.addChatMessage("Head Mage: I can't enchant this item.");
                }
            }
        } else {
            this.goldchecker = true;
        }
    }

    public void onGuiClosed() {
        if (!this.worldObj.isRemote) {
            this.entityplayer.addChatMessage("Head Mage: Magic dwells in you.");
        }
    }

    public void drawScreen(int i, int j, float f) {
        for (int k = 0; k < this.buttonList.size(); ++k) {
            GuiButton guibutton = (GuiButton)this.buttonList.get(k);
            guibutton.drawButton(this.mc, i, j);
        }
        this.drawCenteredString(this.fontRenderer, "The Mage Hall Total Money: " + GoldKeeper.getGoldTotal() + " Gold Coins", this.width / 2, 10, 0xFFCC00);
        if (this.goldchecker) {
            this.drawCenteredString(this.fontRenderer, "Selected Item Cost to enchant: " + this.price + " - NOT ENOUGH GOLD", this.width / 2, 30, 0xFFCC00);
        } else {
            this.drawCenteredString(this.fontRenderer, "Selected Item Cost to enchant: " + this.price, this.width / 2, 20, 0xFFCC00);
        }
        this.drawCenteredString(this.fontRenderer, "Note: Recruiting a mage cost 2000", this.width / 2, 30, 0xFFCC00);
    }
}

