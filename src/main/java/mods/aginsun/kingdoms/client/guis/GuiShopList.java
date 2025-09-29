/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.FMLCommonHandler
 *  net.minecraft.client.gui.GuiButton
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemFood
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.StringTranslate
 *  net.minecraft.world.World
 *  org.lwjgl.opengl.GL11
 */
package mods.aginsun.kingdoms.client.guis;

import cpw.mods.fml.common.FMLCommonHandler;
import mods.aginsun.kingdoms.TaleOfKingdoms;
import mods.aginsun.kingdoms.client.guis.GuiButtonShop;
import mods.aginsun.kingdoms.entities.EntityForgeKeeper;
import mods.aginsun.kingdoms.handlers.GoldKeeper;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StringTranslate;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class GuiShopList
extends GuiScreen {
    public World worldObj = FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(0);
    public EntityPlayer entityplayer;
    public GoldKeeper gold;
    public StringTranslate st = new StringTranslate();
    int checkBounty = 0;
    int currentGui = 0;
    private Integer[] item = new Integer[200];
    private Integer[] itemget = new Integer[200];
    boolean reachedend = false;
    public Integer itemSelected;
    boolean goldchecker = false;
    String stringGet = "";
    String stringoutput = "";
    int price;
    public int shopcounter = 20;
    public static TaleOfKingdoms taleofkingdoms;
    public EntityForgeKeeper forgekeeper;

    public GuiShopList(EntityPlayer entityplayer1, World world, Integer[] ainteger) {
        this.itemget = ainteger;
        this.entityplayer = entityplayer1;
        this.worldObj = world;
        this.setItemList();
        this.itemSelected = this.itemget[0];
    }

    public void setItemList() {
        int i = 0;
        i += this.currentGui * 16;
        for (int j = 0; j <= 16; ++j) {
            this.item[j + 1] = this.itemget[i + j] != null ? this.itemget[i + j] : null;
        }
        this.reachedend = this.itemget[i + 17] == null;
        this.initGui();
    }

    public void initGui() {
        this.buttonList.clear();
        if (this.item[1] != null) {
            Item item1 = new ItemStack(this.item[1].intValue(), 1, 0).getItem();
            String s = String.valueOf(item1.getUnlocalizedName()) + ".name";
            s = this.st.translateKey(s);
            this.buttonList.add(new GuiButtonShop(this.item[1], this, 0, this.width / 2 - 90, 40, 90, 20, s));
        }
        if (this.item[2] != null) {
            Item item2 = new ItemStack(this.item[2].intValue(), 1, 0).getItem();
            String s1 = String.valueOf(item2.getUnlocalizedName()) + ".name";
            s1 = this.st.translateKey(s1);
            this.buttonList.add(new GuiButtonShop(this.item[2], this, 1, this.width / 2 - 90, 60, 90, 20, s1));
        }
        if (this.item[3] != null) {
            Item item3 = new ItemStack(this.item[3].intValue(), 1, 0).getItem();
            String s2 = String.valueOf(item3.getUnlocalizedName()) + ".name";
            s2 = this.st.translateKey(s2);
            this.buttonList.add(new GuiButtonShop(this.item[3], this, 2, this.width / 2 - 90, 80, 90, 20, s2));
        }
        if (this.item[4] != null) {
            Item item4 = new ItemStack(this.item[4].intValue(), 1, 0).getItem();
            String s3 = String.valueOf(item4.getUnlocalizedName()) + ".name";
            s3 = this.st.translateKey(s3);
            this.buttonList.add(new GuiButtonShop(this.item[4], this, 3, this.width / 2 - 90, 100, 90, 20, s3));
        }
        if (this.item[5] != null) {
            Item item5 = new ItemStack(this.item[5].intValue(), 1, 0).getItem();
            String s4 = String.valueOf(item5.getUnlocalizedName()) + ".name";
            s4 = this.st.translateKey(s4);
            this.buttonList.add(new GuiButtonShop(this.item[5], this, 4, this.width / 2 - 90, 120, 90, 20, s4));
        }
        if (this.item[6] != null) {
            Item item6 = new ItemStack(this.item[6].intValue(), 1, 0).getItem();
            String s5 = String.valueOf(item6.getUnlocalizedName()) + ".name";
            s5 = this.st.translateKey(s5);
            this.buttonList.add(new GuiButtonShop(this.item[6], this, 5, this.width / 2 - 90, 140, 90, 20, s5));
        }
        if (this.item[7] != null) {
            Item item7 = new ItemStack(this.item[7].intValue(), 1, 0).getItem();
            String s6 = String.valueOf(item7.getUnlocalizedName()) + ".name";
            s6 = this.st.translateKey(s6);
            this.buttonList.add(new GuiButtonShop(this.item[7], this, 6, this.width / 2 - 90, 160, 90, 20, s6));
        }
        if (this.item[8] != null) {
            Item item8 = new ItemStack(this.item[8].intValue(), 1, 0).getItem();
            String s7 = String.valueOf(item8.getUnlocalizedName()) + ".name";
            s7 = this.st.translateKey(s7);
            this.buttonList.add(new GuiButtonShop(this.item[8], this, 7, this.width / 2 - 90, 180, 90, 20, s7));
        }
        if (this.item[9] != null) {
            Item item9 = new ItemStack(this.item[9].intValue(), 1, 0).getItem();
            String s8 = String.valueOf(item9.getUnlocalizedName()) + ".name";
            s8 = this.st.translateKey(s8);
            this.buttonList.add(new GuiButtonShop(this.item[9], this, 8, this.width / 2 + 20, 40, 90, 20, s8));
        }
        if (this.item[10] != null) {
            Item item10 = new ItemStack(this.item[10].intValue(), 1, 0).getItem();
            String s9 = String.valueOf(item10.getUnlocalizedName()) + ".name";
            s9 = this.st.translateKey(s9);
            this.buttonList.add(new GuiButtonShop(this.item[10], this, 9, this.width / 2 + 20, 60, 90, 20, s9));
        }
        if (this.item[11] != null) {
            Item item11 = new ItemStack(this.item[11].intValue(), 1, 0).getItem();
            String s10 = String.valueOf(item11.getUnlocalizedName()) + ".name";
            s10 = this.st.translateKey(s10);
            this.buttonList.add(new GuiButtonShop(this.item[11], this, 10, this.width / 2 + 20, 80, 90, 20, s10));
        }
        if (this.item[12] != null) {
            Item item12 = new ItemStack(this.item[12].intValue(), 1, 0).getItem();
            String s11 = String.valueOf(item12.getUnlocalizedName()) + ".name";
            s11 = this.st.translateKey(s11);
            this.buttonList.add(new GuiButtonShop(this.item[12], this, 11, this.width / 2 + 20, 100, 90, 20, s11));
        }
        if (this.item[13] != null) {
            Item item13 = new ItemStack(this.item[13].intValue(), 1, 0).getItem();
            String s12 = String.valueOf(item13.getUnlocalizedName()) + ".name";
            s12 = this.st.translateKey(s12);
            this.buttonList.add(new GuiButtonShop(this.item[13], this, 12, this.width / 2 + 20, 120, 90, 20, s12));
        }
        if (this.item[14] != null) {
            Item item14 = new ItemStack(this.item[14].intValue(), 1, 0).getItem();
            String s13 = String.valueOf(item14.getUnlocalizedName()) + ".name";
            s13 = this.st.translateKey(s13);
            this.buttonList.add(new GuiButtonShop(this.item[14], this, 13, this.width / 2 + 20, 140, 90, 20, s13));
        }
        if (this.item[15] != null) {
            Item item15 = new ItemStack(this.item[15].intValue(), 1, 0).getItem();
            String s14 = String.valueOf(item15.getUnlocalizedName()) + ".name";
            s14 = this.st.translateKey(s14);
            this.buttonList.add(new GuiButtonShop(this.item[15], this, 14, this.width / 2 + 20, 160, 90, 20, s14));
        }
        if (this.item[16] != null) {
            Item item16 = new ItemStack(this.item[16].intValue(), 1, 0).getItem();
            String s15 = String.valueOf(item16.getUnlocalizedName()) + ".name";
            s15 = this.st.translateKey(s15);
            this.buttonList.add(new GuiButtonShop(this.item[16], this, 15, this.width / 2 + 20, 180, 90, 20, s15));
        }
        this.buttonList.add(new GuiButton(17, this.width / 2 - 120, 220, 70, 20, "Back"));
        this.buttonList.add(new GuiButton(16, this.width / 2 - 120, 200, 70, 20, "Next"));
        this.buttonList.add(new GuiButton(18, this.width / 2 - 35, 200, 70, 20, "Buy Item"));
        this.buttonList.add(new GuiButton(19, this.width / 2 + 50, 220, 70, 20, "Exit"));
        this.buttonList.add(new GuiButton(20, this.width / 2 + 50, 200, 70, 20, "Sell Item"));
        this.buttonList.add(new GuiButton(21, this.width / 2 - 35, 220, 70, 20, "Buy 16 Items"));
    }

    public boolean doesGuiPauseGame() {
        return false;
    }

    public void onGuiClosed() {
        if (!this.worldObj.isRemote) {
            this.entityplayer.addChatMessage("Shop Keeper: Thank you! Come back again!");
        }
    }

    protected void actionPerformed(GuiButton guibutton) {
        if (guibutton.id == 0) {
            this.itemSelected = this.item[1];
            this.goldchecker = false;
            if (this.itemSelected != null) {
                Item item1 = new ItemStack(this.itemSelected.intValue(), 1, 0).getItem();
                this.stringGet = String.valueOf(item1.getUnlocalizedName()) + ".name";
                if (this.stringGet != null) {
                    this.stringoutput = this.st.translateKey(this.stringGet);
                }
                this.price = GoldKeeper.priceItem(String.valueOf(item1.getUnlocalizedName()));
                this.price = (int)((double)this.price + (double)this.price * 0.8);
                if (item1 instanceof ItemFood) {
                    this.price = (int)((double)this.price + (double)this.price * 0.2);
                }
            }
        }
        if (guibutton.id == 1) {
            this.itemSelected = this.item[2];
            this.goldchecker = false;
            if (this.itemSelected != null) {
                Item item2 = new ItemStack(this.itemSelected.intValue(), 1, 0).getItem();
                this.stringGet = String.valueOf(item2.getUnlocalizedName()) + ".name";
                if (this.stringGet != null) {
                    this.stringoutput = this.st.translateKey(this.stringGet);
                }
                this.price = GoldKeeper.priceItem(String.valueOf(item2.getUnlocalizedName()));
                this.price = (int)((double)this.price + (double)this.price * 0.8);
                if (item2 instanceof ItemFood) {
                    this.price = (int)((double)this.price + (double)this.price * 0.2);
                }
            }
        }
        if (guibutton.id == 2) {
            this.itemSelected = this.item[3];
            this.goldchecker = false;
            if (this.itemSelected != null) {
                Item item3 = new ItemStack(this.itemSelected.intValue(), 1, 0).getItem();
                this.stringGet = String.valueOf(item3.getUnlocalizedName()) + ".name";
                if (this.stringGet != null) {
                    this.stringoutput = this.st.translateKey(this.stringGet);
                }
                this.price = GoldKeeper.priceItem(String.valueOf(item3.getUnlocalizedName()));
                this.price = (int)((double)this.price + (double)this.price * 0.8);
                if (item3 instanceof ItemFood) {
                    this.price = (int)((double)this.price + (double)this.price * 0.2);
                }
            }
        }
        if (guibutton.id == 3) {
            this.itemSelected = this.item[4];
            this.goldchecker = false;
            if (this.itemSelected != null) {
                Item item4 = new ItemStack(this.itemSelected.intValue(), 1, 0).getItem();
                this.stringGet = String.valueOf(item4.getUnlocalizedName()) + ".name";
                if (this.stringGet != null) {
                    this.stringoutput = this.st.translateKey(this.stringGet);
                }
                this.price = GoldKeeper.priceItem(String.valueOf(item4.getUnlocalizedName()));
                this.price = (int)((double)this.price + (double)this.price * 0.8);
                if (item4 instanceof ItemFood) {
                    this.price = (int)((double)this.price + (double)this.price * 0.2);
                }
            }
        }
        if (guibutton.id == 4) {
            this.itemSelected = this.item[5];
            this.goldchecker = false;
            if (this.itemSelected != null) {
                Item item5 = new ItemStack(this.itemSelected.intValue(), 1, 0).getItem();
                this.stringGet = String.valueOf(item5.getUnlocalizedName()) + ".name";
                if (this.stringGet != null) {
                    this.stringoutput = this.st.translateKey(this.stringGet);
                }
                this.price = GoldKeeper.priceItem(String.valueOf(item5.getUnlocalizedName()));
                this.price = (int)((double)this.price + (double)this.price * 0.8);
                if (item5 instanceof ItemFood) {
                    this.price = (int)((double)this.price + (double)this.price * 0.2);
                }
            }
        }
        if (guibutton.id == 5) {
            this.itemSelected = this.item[6];
            this.goldchecker = false;
            if (this.itemSelected != null) {
                Item item6 = new ItemStack(this.itemSelected.intValue(), 1, 0).getItem();
                this.stringGet = String.valueOf(item6.getUnlocalizedName()) + ".name";
                if (this.stringGet != null) {
                    this.stringoutput = this.st.translateKey(this.stringGet);
                }
                this.price = GoldKeeper.priceItem(String.valueOf(item6.getUnlocalizedName()));
                this.price = (int)((double)this.price + (double)this.price * 0.8);
                if (item6 instanceof ItemFood) {
                    this.price = (int)((double)this.price + (double)this.price * 0.2);
                }
            }
        }
        if (guibutton.id == 6) {
            this.itemSelected = this.item[7];
            this.goldchecker = false;
            if (this.itemSelected != null) {
                Item item7 = new ItemStack(this.itemSelected.intValue(), 1, 0).getItem();
                this.stringGet = String.valueOf(item7.getUnlocalizedName()) + ".name";
                if (this.stringGet != null) {
                    this.stringoutput = this.st.translateKey(this.stringGet);
                }
                this.price = GoldKeeper.priceItem(String.valueOf(item7.getUnlocalizedName()));
                this.price = (int)((double)this.price + (double)this.price * 0.8);
                if (item7 instanceof ItemFood) {
                    this.price = (int)((double)this.price + (double)this.price * 0.2);
                }
            }
        }
        if (guibutton.id == 7) {
            this.itemSelected = this.item[8];
            this.goldchecker = false;
            if (this.itemSelected != null) {
                Item item8 = new ItemStack(this.itemSelected.intValue(), 1, 0).getItem();
                this.stringGet = String.valueOf(item8.getUnlocalizedName()) + ".name";
                if (this.stringGet != null) {
                    this.stringoutput = this.st.translateKey(this.stringGet);
                }
                this.price = GoldKeeper.priceItem(String.valueOf(item8.getUnlocalizedName()));
                this.price = (int)((double)this.price + (double)this.price * 0.8);
                if (item8 instanceof ItemFood) {
                    this.price = (int)((double)this.price + (double)this.price * 0.2);
                }
            }
        }
        if (guibutton.id == 8) {
            this.itemSelected = this.item[9];
            this.goldchecker = false;
            if (this.itemSelected != null) {
                Item item9 = new ItemStack(this.itemSelected.intValue(), 1, 0).getItem();
                this.stringGet = String.valueOf(item9.getUnlocalizedName()) + ".name";
                if (this.stringGet != null) {
                    this.stringoutput = this.st.translateKey(this.stringGet);
                }
                this.price = GoldKeeper.priceItem(String.valueOf(item9.getUnlocalizedName()));
                this.price = (int)((double)this.price + (double)this.price * 0.8);
                if (item9 instanceof ItemFood) {
                    this.price = (int)((double)this.price + (double)this.price * 0.2);
                }
            }
        }
        if (guibutton.id == 9) {
            this.itemSelected = this.item[10];
            this.goldchecker = false;
            if (this.itemSelected != null) {
                Item item10 = new ItemStack(this.itemSelected.intValue(), 1, 0).getItem();
                this.stringGet = String.valueOf(item10.getUnlocalizedName()) + ".name";
                if (this.stringGet != null) {
                    this.stringoutput = this.st.translateKey(this.stringGet);
                }
                this.price = GoldKeeper.priceItem(String.valueOf(item10.getUnlocalizedName()));
                this.price = (int)((double)this.price + (double)this.price * 0.8);
                if (item10 instanceof ItemFood) {
                    this.price = (int)((double)this.price + (double)this.price * 0.2);
                }
            }
        }
        if (guibutton.id == 10) {
            this.itemSelected = this.item[11];
            this.goldchecker = false;
            if (this.itemSelected != null) {
                Item item11 = new ItemStack(this.itemSelected.intValue(), 1, 0).getItem();
                this.stringGet = String.valueOf(item11.getUnlocalizedName()) + ".name";
                if (this.stringGet != null) {
                    this.stringoutput = this.st.translateKey(this.stringGet);
                }
                this.price = GoldKeeper.priceItem(String.valueOf(item11.getUnlocalizedName()));
                this.price = (int)((double)this.price + (double)this.price * 0.8);
                if (item11 instanceof ItemFood) {
                    this.price = (int)((double)this.price + (double)this.price * 0.2);
                }
            }
        }
        if (guibutton.id == 11) {
            this.itemSelected = this.item[12];
            this.goldchecker = false;
            if (this.itemSelected != null) {
                Item item12 = new ItemStack(this.itemSelected.intValue(), 1, 0).getItem();
                this.stringGet = String.valueOf(item12.getUnlocalizedName()) + ".name";
                if (this.stringGet != null) {
                    this.stringoutput = this.st.translateKey(this.stringGet);
                }
                this.price = GoldKeeper.priceItem(String.valueOf(item12.getUnlocalizedName()));
                this.price = (int)((double)this.price + (double)this.price * 0.8);
                if (item12 instanceof ItemFood) {
                    this.price = (int)((double)this.price + (double)this.price * 0.2);
                }
            }
        }
        if (guibutton.id == 12) {
            this.itemSelected = this.item[13];
            this.goldchecker = false;
            if (this.itemSelected != null) {
                Item item13 = new ItemStack(this.itemSelected.intValue(), 1, 0).getItem();
                this.stringGet = String.valueOf(item13.getUnlocalizedName()) + ".name";
                if (this.stringGet != null) {
                    this.stringoutput = this.st.translateKey(this.stringGet);
                }
                this.price = GoldKeeper.priceItem(String.valueOf(item13.getUnlocalizedName()));
                this.price = (int)((double)this.price + (double)this.price * 0.8);
                if (item13 instanceof ItemFood) {
                    this.price = (int)((double)this.price + (double)this.price * 0.2);
                }
            }
        }
        if (guibutton.id == 13) {
            this.itemSelected = this.item[14];
            this.goldchecker = false;
            if (this.itemSelected != null) {
                Item item14 = new ItemStack(this.itemSelected.intValue(), 1, 0).getItem();
                this.stringGet = String.valueOf(item14.getUnlocalizedName()) + ".name";
                if (this.stringGet != null) {
                    this.stringoutput = this.st.translateKey(this.stringGet);
                }
                this.price = GoldKeeper.priceItem(String.valueOf(item14.getUnlocalizedName()));
                this.price = (int)((double)this.price + (double)this.price * 0.8);
                if (item14 instanceof ItemFood) {
                    this.price = (int)((double)this.price + (double)this.price * 0.2);
                }
            }
        }
        if (guibutton.id == 14) {
            this.itemSelected = this.item[15];
            this.goldchecker = false;
            if (this.itemSelected != null) {
                Item item15 = new ItemStack(this.itemSelected.intValue(), 1, 0).getItem();
                this.stringGet = String.valueOf(item15.getUnlocalizedName()) + ".name";
                if (this.stringGet != null) {
                    this.stringoutput = this.st.translateKey(this.stringGet);
                }
                this.price = GoldKeeper.priceItem(String.valueOf(item15.getUnlocalizedName()));
                this.price = (int)((double)this.price + (double)this.price * 0.8);
                if (item15 instanceof ItemFood) {
                    this.price = (int)((double)this.price + (double)this.price * 0.2);
                }
            }
        }
        if (guibutton.id == 15) {
            this.itemSelected = this.item[16];
            this.goldchecker = false;
            if (this.itemSelected != null) {
                Item item16 = new ItemStack(this.itemSelected.intValue(), 1, 0).getItem();
                this.stringGet = String.valueOf(item16.getUnlocalizedName()) + ".name";
                if (this.stringGet != null) {
                    this.stringoutput = this.st.translateKey(this.stringGet);
                }
                this.price = GoldKeeper.priceItem(String.valueOf(item16.getUnlocalizedName()));
                this.price = (int)((double)this.price + (double)this.price * 0.8);
                if (item16 instanceof ItemFood) {
                    this.price = (int)((double)this.price + (double)this.price * 0.2);
                }
            }
        }
        if (guibutton.id == 16) {
            if (!this.reachedend) {
                ++this.currentGui;
            }
            this.setItemList();
            this.goldchecker = false;
            if (this.itemSelected != null) {
                Item item17 = new ItemStack(this.itemSelected.intValue(), 1, 0).getItem();
                this.stringGet = String.valueOf(item17.getUnlocalizedName()) + ".name";
                if (this.stringGet != null) {
                    this.stringoutput = this.st.translateKey(this.stringGet);
                }
                this.price = GoldKeeper.priceItem(String.valueOf(item17.getUnlocalizedName()));
                this.price = (int)((double)this.price + (double)this.price * 0.8);
                if (item17 instanceof ItemFood) {
                    this.price = (int)((double)this.price + (double)this.price * 0.2);
                }
            }
        }
        if (guibutton.id == 17) {
            if (this.currentGui != 0) {
                --this.currentGui;
            }
            this.setItemList();
            this.goldchecker = false;
            if (this.itemSelected != null) {
                Item item18 = new ItemStack(this.itemSelected.intValue(), 1, 0).getItem();
                this.stringGet = String.valueOf(item18.getUnlocalizedName()) + ".name";
                if (this.stringGet != null) {
                    this.stringoutput = this.st.translateKey(this.stringGet);
                }
                this.price = GoldKeeper.priceItem(String.valueOf(item18.getUnlocalizedName()));
                this.price = (int)((double)this.price + (double)this.price * 0.8);
                if (item18 instanceof ItemFood) {
                    this.price = (int)((double)this.price + (double)this.price * 0.2);
                }
            }
        }
        if (guibutton.id == 18) {
            ItemStack itemstack = new ItemStack(this.itemSelected.intValue(), 1, 0);
            Item item19 = itemstack.getItem();
            String s = item19.getUnlocalizedName();
            int i = GoldKeeper.priceItem(s);
            i = (int)((double)i + (double)i * 0.8);
            if (item19 instanceof ItemFood) {
                i = (int)((double)i + (double)i * 0.2);
            }
            if (i <= GoldKeeper.getGoldTotal()) {
                EntityItem entityitem = new EntityItem(this.worldObj, this.entityplayer.posX, this.entityplayer.posY, this.entityplayer.posZ, itemstack);
                this.worldObj.spawnEntityInWorld((Entity)entityitem);
                GoldKeeper.decreaseGold(i);
            } else {
                this.goldchecker = true;
            }
        }
        if (guibutton.id == 21 && this.shopcounter >= 16) {
            ItemStack itemstack1 = new ItemStack(this.itemSelected.intValue(), 1, 0);
            Item item20 = itemstack1.getItem();
            String s1 = item20.getUnlocalizedName();
            int j = GoldKeeper.priceItem(s1);
            j = (int)((double)j + (double)j * 0.8);
            if (item20 instanceof ItemFood) {
                j = (int)((double)j + (double)j * 0.2);
            }
            if (j * 16 <= GoldKeeper.getGoldTotal()) {
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
            this.mc.displayGuiScreen(null);
            this.entityplayer.openGui((Object)TaleOfKingdoms.instance, 1, this.worldObj, (int)this.entityplayer.posX, (int)this.entityplayer.posY, (int)this.entityplayer.posZ);
            this.goldchecker = false;
        }
    }

    public void drawScreen(int i, int j, float f) {
        if (this.shopcounter < 16) {
            ItemStack itemstack = new ItemStack(this.itemSelected.intValue(), 1, 0);
            Item item1 = itemstack.getItem();
            String s = item1.getUnlocalizedName();
            int i1 = GoldKeeper.priceItem(s);
            i1 = (int)((double)i1 + (double)i1 * 0.8);
            if (item1 instanceof ItemFood) {
                i1 = (int)((double)i1 + (double)i1 * 0.2);
            }
            if (i1 <= GoldKeeper.getGoldTotal()) {
                EntityItem entityitem = new EntityItem(this.worldObj, this.entityplayer.posX, this.entityplayer.posY, this.entityplayer.posZ, itemstack);
                this.entityplayer.joinEntityItemWithWorld(entityitem);
                GoldKeeper.decreaseGold(i1);
            }
            ++this.shopcounter;
        }
        this.drawDefaultBackground();
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        int c = 255;
        int c1 = 255;
        ResourceLocation resource = new ResourceLocation("taleofkingdoms", "textures/guis/crafting.png");
        this.mc.renderEngine.bindTexture(resource);
        int j1 = (this.width - c) / 2;
        this.drawTexturedModalRect(j1, 0, 0, 0, c, c1);
        for (int l = 0; l < this.buttonList.size(); ++l) {
            if (this.buttonList.get(l) instanceof GuiButtonShop) {
                GuiButtonShop guibuttonshop = (GuiButtonShop)((Object)this.buttonList.get(l));
                guibuttonshop.drawButton(this.mc, i, j);
            }
            if (!(this.buttonList.get(l) instanceof GuiButton)) continue;
            GuiButton guibutton = (GuiButton)this.buttonList.get(l);
            guibutton.drawButton(this.mc, i, j);
        }
        this.drawCenteredString(this.fontRenderer, "Shop Menu - Total Money: " + GoldKeeper.getGoldTotal() + " Gold Coins", this.width / 2, 15, 0xFFCC00);
        if (this.goldchecker) {
            this.drawCenteredString(this.fontRenderer, "Selected Item Cost: " + this.stringoutput + " - NOT ENOUGH GOLD", this.width / 2, 30, 0xFFCC00);
        } else {
            this.drawCenteredString(this.fontRenderer, "Selected Item Cost: " + this.stringoutput + " - " + this.price + " Gold coins", this.width / 2, 30, 0xFFCC00);
        }
        super.drawScreen(i, j, f);
    }

    protected void keyTyped(char par1, int par2) {
        if (par2 == 1 || par2 == this.mc.gameSettings.keyBindInventory.keyCode) {
            this.mc.thePlayer.closeScreen();
        }
    }
}

