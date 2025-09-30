
package mods.aginsun.kingdoms.client.guis;

import cpw.mods.fml.common.FMLCommonHandler;
import mods.aginsun.kingdoms.client.guis.GuiButtonShop;
import mods.aginsun.kingdoms.client.guis.GuiPriceBar;
import mods.aginsun.kingdoms.client.guis.GuiScreenToK;
import mods.aginsun.kingdoms.handlers.GoldKeeper;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StringTranslate;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;
import mods.aginsun.kingdoms.util.ChatMessage;

public class GuiStockList
extends GuiScreenToK {
    private World worldObj = FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(0);
    private EntityPlayer entityplayer;
    private StringTranslate st = new StringTranslate();
    int checkBounty = 0;
    private Item[] item = new Item[9];
    boolean reachedend = false;
    public Item itemSelected;
    boolean goldchecker = false;
    private GuiPriceBar[] loadbar = new GuiPriceBar[8];
    public int shopcounter = 20;

    public GuiStockList(EntityPlayer entityplayer1, World world) {
    this.entityplayer = entityplayer1;
    this.worldObj = world;
    this.setItemList();
    this.itemSelected = Items.flint;
    }

    public void setItemList() {
    this.item[1] = Items.flint;
    this.item[2] = Items.clay_ball;
    this.item[3] = Items.iron_ingot;
    this.item[4] = Items.diamond;
    this.item[5] = Items.fish;
    this.item[6] = Items.apple;
    this.item[7] = Items.string;
    this.item[8] = Items.feather;
        this.initGui();
    }

    public void initGui() {
        this.buttonList.clear();
        this.loadbar[0] = new GuiPriceBar(0, this.width / 2 - 100, 43, 90, 12, 1.0f, "red");
        this.loadbar[1] = new GuiPriceBar(0, this.width / 2 - 100, 63, 90, 12, 1.0f, "red");
        this.loadbar[2] = new GuiPriceBar(0, this.width / 2 - 100, 83, 90, 12, 1.0f, "red");
        this.loadbar[3] = new GuiPriceBar(0, this.width / 2 - 100, 103, 90, 12, 1.0f, "red");
        this.loadbar[4] = new GuiPriceBar(0, this.width / 2 - 100, 123, 90, 12, 1.0f, "red");
        this.loadbar[5] = new GuiPriceBar(0, this.width / 2 - 100, 143, 90, 12, 1.0f, "red");
        this.loadbar[6] = new GuiPriceBar(0, this.width / 2 - 100, 163, 90, 12, 1.0f, "red");
        this.loadbar[7] = new GuiPriceBar(0, this.width / 2 - 100, 183, 90, 12, 1.0f, "red");
        this.loadbar[0].setBar(GoldKeeper.flint / 200.0f);
        this.loadbar[1].setBar(GoldKeeper.clay / 200.0f);
        this.loadbar[2].setBar(GoldKeeper.iron / 200.0f);
        this.loadbar[3].setBar(GoldKeeper.diamond / 200.0f);
        this.loadbar[4].setBar(GoldKeeper.fish / 200.0f);
        this.loadbar[5].setBar(GoldKeeper.apple / 200.0f);
        this.loadbar[6].setBar(GoldKeeper.string / 200.0f);
        this.loadbar[7].setBar(GoldKeeper.feather / 200.0f);
        if (this.item[1] != null) {
            String s = String.valueOf(this.item[1].getUnlocalizedName()) + ".name";
            s = this.st.translateKey(s);
            this.buttonList.add(new GuiButtonShop(this.item[1], this, 8, this.width / 2 + 20, 40, 90, 20, s));
        }
        if (this.item[2] != null) {
            String s1 = String.valueOf(this.item[2].getUnlocalizedName()) + ".name";
            s1 = this.st.translateKey(s1);
            this.buttonList.add(new GuiButtonShop(this.item[2], this, 9, this.width / 2 + 20, 60, 90, 20, s1));
        }
        if (this.item[3] != null) {
            String s2 = String.valueOf(this.item[3].getUnlocalizedName()) + ".name";
            s2 = this.st.translateKey(s2);
            this.buttonList.add(new GuiButtonShop(this.item[3], this, 10, this.width / 2 + 20, 80, 90, 20, s2));
        }
        if (this.item[4] != null) {
            String s3 = String.valueOf(this.item[4].getUnlocalizedName()) + ".name";
            s3 = this.st.translateKey(s3);
            this.buttonList.add(new GuiButtonShop(this.item[4], this, 11, this.width / 2 + 20, 100, 90, 20, s3));
        }
        if (this.item[5] != null) {
            String s4 = String.valueOf(this.item[5].getUnlocalizedName()) + ".name";
            s4 = this.st.translateKey(s4);
            this.buttonList.add(new GuiButtonShop(this.item[5], this, 12, this.width / 2 + 20, 120, 90, 20, s4));
        }
        if (this.item[6] != null) {
            String s5 = String.valueOf(this.item[6].getUnlocalizedName()) + ".name";
            s5 = this.st.translateKey(s5);
            this.buttonList.add(new GuiButtonShop(this.item[6], this, 13, this.width / 2 + 20, 140, 90, 20, s5));
        }
        if (this.item[7] != null) {
            String s6 = String.valueOf(this.item[7].getUnlocalizedName()) + ".name";
            s6 = this.st.translateKey(s6);
            this.buttonList.add(new GuiButtonShop(this.item[7], this, 14, this.width / 2 + 20, 160, 90, 20, s6));
        }
        if (this.item[8] != null) {
            String s7 = String.valueOf(this.item[8].getUnlocalizedName()) + ".name";
            s7 = this.st.translateKey(s7);
            this.buttonList.add(new GuiButtonShop(this.item[8], this, 15, this.width / 2 + 20, 180, 90, 20, s7));
        }
        this.buttonList.add(new GuiButton(18, this.width / 2 + 130, 160, 80, 20, "Buy Item"));
        this.buttonList.add(new GuiButton(19, this.width / 2 + 130, 220, 80, 20, "Exit"));
        this.buttonList.add(new GuiButton(21, this.width / 2 + 130, 200, 80, 20, "Buy 16 Items"));
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    public void onGuiClosed() {
        if (this.worldObj.isRemote) {
            ChatMessage.add(this.entityplayer,"Stock Keeper: Keep a look out on your stock supplies!");
        }
    }

    protected void actionPerformed(GuiButton guibutton) {
        if (guibutton.id == 8) {
            this.itemSelected = this.item[1];
            this.goldchecker = false;
        }
        if (guibutton.id == 9) {
            this.itemSelected = this.item[2];
            this.goldchecker = false;
        }
        if (guibutton.id == 10) {
            this.itemSelected = this.item[3];
            this.goldchecker = false;
        }
        if (guibutton.id == 11) {
            this.itemSelected = this.item[4];
            this.goldchecker = false;
        }
        if (guibutton.id == 12) {
            this.itemSelected = this.item[5];
            this.goldchecker = false;
        }
        if (guibutton.id == 13) {
            this.itemSelected = this.item[6];
            this.goldchecker = false;
        }
        if (guibutton.id == 14) {
            this.itemSelected = this.item[7];
            this.goldchecker = false;
        }
        if (guibutton.id == 15) {
            this.itemSelected = this.item[8];
            this.goldchecker = false;
        }
        if (guibutton.id == 18) {
            ItemStack itemstack = new ItemStack(this.itemSelected, 1, 0);
            String s = this.itemSelected.getUnlocalizedName();
            int i = GoldKeeper.priceItem(s);
            float f = 0.0f;
            if (this.itemSelected == Items.flint) {
                f = GoldKeeper.flint;
            }
            if (this.itemSelected == Items.clay_ball) {
                f = GoldKeeper.clay;
            }
            if (this.itemSelected == Items.iron_ingot) {
                f = GoldKeeper.iron;
            }
            if (this.itemSelected == Items.diamond) {
                f = GoldKeeper.diamond;
            }
            if (this.itemSelected == Items.fish) {
                f = GoldKeeper.fish;
            }
            if (this.itemSelected == Items.apple) {
                f = GoldKeeper.apple;
            }
            if (this.itemSelected == Items.string) {
                f = GoldKeeper.string;
            }
            if (this.itemSelected == Items.feather) {
                f = GoldKeeper.feather;
            }
            if ((i = (int)((float)i + (float)i * (f /= 100.0f))) <= GoldKeeper.getGoldTotal()) {
                EntityItem entityitem = new EntityItem(this.worldObj, this.entityplayer.posX, this.entityplayer.posY, this.entityplayer.posZ, itemstack);
                this.entityplayer.joinEntityItemWithWorld(entityitem);
                if (FMLCommonHandler.instance().getEffectiveSide().isServer()) {
                    GoldKeeper.decreaseGold(i);
                }
            } else {
                this.goldchecker = true;
            }
        }
        if (guibutton.id == 21 && this.shopcounter >= 16) {
            ItemStack itemstack1 = new ItemStack(this.itemSelected, 1, 0);
            String s1 = this.itemSelected.getUnlocalizedName();
            int j = GoldKeeper.priceItem(s1);
            float f1 = 0.0f;
            if (this.itemSelected == Items.flint) {
                f1 = GoldKeeper.flint;
            }
            if (this.itemSelected == Items.clay_ball) {
                f1 = GoldKeeper.clay;
            }
            if (this.itemSelected == Items.iron_ingot) {
                f1 = GoldKeeper.iron;
            }
            if (this.itemSelected == Items.diamond) {
                f1 = GoldKeeper.diamond;
            }
            if (this.itemSelected == Items.fish) {
                f1 = GoldKeeper.fish;
            }
            if (this.itemSelected == Items.apple) {
                f1 = GoldKeeper.apple;
            }
            if (this.itemSelected == Items.string) {
                f1 = GoldKeeper.string;
            }
            if (this.itemSelected == Items.feather) {
                f1 = GoldKeeper.feather;
            }
            if ((j = (int)((float)j + (float)j * (f1 /= 100.0f))) * 16 <= GoldKeeper.getGoldTotal()) {
                this.shopcounter = 0;
            } else {
                this.goldchecker = true;
            }
        }
        if (guibutton.id == 19) {
            this.mc.displayGuiScreen(null);
            this.goldchecker = false;
        }
        if (guibutton.id == 20) {
            this.goldchecker = false;
        }
    }

    public void drawScreen(int i, int j, float f) {
        if (this.shopcounter < 16) {
            ItemStack itemstack = new ItemStack(this.itemSelected, 1, 0);
            String s2 = this.itemSelected.getUnlocalizedName();
            int j1 = GoldKeeper.priceItem(s2);
            float f2 = 0.0f;
            if (this.itemSelected == Items.flint) {
                f2 = GoldKeeper.flint;
            }
            if (this.itemSelected == Items.clay_ball) {
                f2 = GoldKeeper.clay;
            }
            if (this.itemSelected == Items.iron_ingot) {
                f2 = GoldKeeper.iron;
            }
            if (this.itemSelected == Items.diamond) {
                f2 = GoldKeeper.diamond;
            }
            if (this.itemSelected == Items.fish) {
                f2 = GoldKeeper.fish;
            }
            if (this.itemSelected == Items.apple) {
                f2 = GoldKeeper.apple;
            }
            if (this.itemSelected == Items.string) {
                f2 = GoldKeeper.string;
            }
            if (this.itemSelected == Items.feather) {
                f2 = GoldKeeper.feather;
            }
            if ((j1 = (int)((float)j1 + (float)j1 * (f2 /= 100.0f))) <= GoldKeeper.getGoldTotal()) {
                EntityItem entityitem = new EntityItem(this.worldObj, this.entityplayer.posX, this.entityplayer.posY, this.entityplayer.posZ, itemstack);
                this.entityplayer.joinEntityItemWithWorld(entityitem);
                GoldKeeper.decreaseGold(j1);
            }
            ++this.shopcounter;
        }
        this.drawDefaultBackground();
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        int c = 255;
        int c1 = 255;
        ResourceLocation resource = new ResourceLocation("taleofkingdoms", "textures/guis/crafting.png");
        this.mc.renderEngine.bindTexture(resource);
        int k1 = (this.width - c) / 2;
        this.drawTexturedModalRect(k1, 0, 0, 0, c, c1);
        for (int l = 0; l < this.buttonList.size(); ++l) {
            if (this.buttonList.get(l) instanceof GuiButtonShop) {
                GuiButtonShop guibuttonshop = (GuiButtonShop)((Object)this.buttonList.get(l));
                guibuttonshop.drawButton(this.mc, i, j);
            }
            if (!(this.buttonList.get(l) instanceof GuiButton)) continue;
            GuiButton guibutton = (GuiButton)this.buttonList.get(l);
            guibutton.drawButton(this.mc, i, j);
        }
        this.drawCenteredString(this.fontRendererObj, "Stock Menu - Total Money: " + GoldKeeper.getGoldTotal() + " Gold Coins", this.width / 2, 15, 0xFFCC00);
        String s = String.valueOf(this.itemSelected.getUnlocalizedName()) + ".name";
        String s1 = this.st.translateKey(s);
        int i1 = GoldKeeper.priceItem(String.valueOf(this.itemSelected.getUnlocalizedName()));
        float f1 = 0.0f;
        if (this.itemSelected == net.minecraft.init.Items.flint) {
            f1 = GoldKeeper.flint;
        }
        if (this.itemSelected == net.minecraft.init.Items.clay_ball) {
            f1 = GoldKeeper.clay;
        }
        if (this.itemSelected == net.minecraft.init.Items.iron_ingot) {
            f1 = GoldKeeper.iron;
        }
        if (this.itemSelected == net.minecraft.init.Items.diamond) {
            f1 = GoldKeeper.diamond;
        }
        if (this.itemSelected == net.minecraft.init.Items.fish) {
            f1 = GoldKeeper.fish;
        }
        if (this.itemSelected == net.minecraft.init.Items.apple) {
            f1 = GoldKeeper.apple;
        }
        if (this.itemSelected == net.minecraft.init.Items.string) {
            f1 = GoldKeeper.string;
        }
        if (this.itemSelected == net.minecraft.init.Items.feather) {
            f1 = GoldKeeper.feather;
        }
        i1 = (int)((float)i1 + (float)i1 * (f1 /= 100.0f));
        if (this.goldchecker) {
            this.drawCenteredString(this.fontRendererObj, "Selected Item Cost: " + s1 + " - NOT ENOUGH GOLD", this.width / 2, 30, 0xFFCC00);
        } else {
            this.drawCenteredString(this.fontRendererObj, "Selected Item Cost: " + s1 + " - " + i1 + " Gold coins", this.width / 2, 30, 0xFFCC00);
        }
        this.drawCenteredString(this.fontRendererObj, "Note: Full bar means full cost!", this.width / 2, 200, 0xFFCC00);
        for (int l1 = 0; l1 < 8; ++l1) {
            this.loadbar[l1].drawBar();
        }
        super.drawScreen(i, j, f);
    }

    @Override
    protected void keyTyped(char par1, int par2) {
        if (par2 == 1 || par2 == this.mc.gameSettings.keyBindInventory.getKeyCode()) {
            this.mc.thePlayer.closeScreen();
        }
    }
}

