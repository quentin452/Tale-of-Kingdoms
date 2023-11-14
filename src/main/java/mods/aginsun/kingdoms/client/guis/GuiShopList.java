package mods.aginsun.kingdoms.client.guis;

import cpw.mods.fml.common.FMLCommonHandler;
import mods.aginsun.kingdoms.TaleOfKingdoms;
import mods.aginsun.kingdoms.entities.EntityForgeKeeper;
import mods.aginsun.kingdoms.handlers.GoldKeeper;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StringTranslate;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public final class GuiShopList extends GuiScreen {

   public World worldObj = FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(0);
   public EntityPlayer entityplayer;
   public GoldKeeper gold;
   public StringTranslate st = new StringTranslate();
    private int currentGui = 0;
    private int price;
    private int shopcounter = 20;
   private final int[] item = new int[200];
   private final Integer[] itemget;
   boolean reachedend = false;
   public Integer itemSelected;
   private boolean goldchecker = false;
    private String stringoutput = "";
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
        byte i = 0;
        int var3 = i + this.currentGui * 16;
        if (this.itemget == null) {
            return;
        }
        for (int j = 0; j < 16 && (var3 + j) < this.itemget.length; ++j) {
            if (this.itemget[var3 + j] != null && this.itemget[var3 + j] != 0) {
                this.item[j + 1] = this.itemget[var3 + j];
            } else {
                this.item[j + 1] = 0;
            }
        }
        if (var3 + 17 < this.itemget.length) {
            this.reachedend = this.itemget[var3 + 17] == null || this.itemget[var3 + 17] == 0;
        } else {
            this.reachedend = false;
        }
        this.initGui();
    }


   public void initGui() {
      this.buttonList.clear();
      Item item16;
      String s15;
      if(this.item[1] != 0) {
         item16 = (new ItemStack(Item.getItemById(this.item[1]), 1, 0)).getItem();
          assert item16 != null;
          s15 = item16.getUnlocalizedName() + ".name";
         s15 = this.st.translateKey(s15);
         this.buttonList.add(new GuiButtonShop(this.item[1], this, 0, this.width / 2 - 90, 40, 90, 20, s15));
      }

      if(this.item[2] != 0) {
         item16 = (new ItemStack(Item.getItemById(this.item[2]), 1, 0)).getItem();
          assert item16 != null;
          s15 = item16.getUnlocalizedName() + ".name";
         s15 = this.st.translateKey(s15);
         this.buttonList.add(new GuiButtonShop(this.item[2], this, 1, this.width / 2 - 90, 60, 90, 20, s15));
      }

      if(this.item[3] != 0) {
         item16 = (new ItemStack(Item.getItemById(this.item[3]), 1, 0)).getItem();
          assert item16 != null;
          s15 = item16.getUnlocalizedName() + ".name";
         s15 = this.st.translateKey(s15);
         this.buttonList.add(new GuiButtonShop(this.item[3], this, 2, this.width / 2 - 90, 80, 90, 20, s15));
      }

      if(this.item[4] != 0) {
         item16 = (new ItemStack(Item.getItemById(this.item[4]), 1, 0)).getItem();
          assert item16 != null;
          s15 = item16.getUnlocalizedName() + ".name";
         s15 = this.st.translateKey(s15);
         this.buttonList.add(new GuiButtonShop(this.item[4], this, 3, this.width / 2 - 90, 100, 90, 20, s15));
      }

      if(this.item[5] != 0) {
         item16 = (new ItemStack(Item.getItemById(this.item[5]), 1, 0)).getItem();
          assert item16 != null;
          s15 = item16.getUnlocalizedName() + ".name";
         s15 = this.st.translateKey(s15);
         this.buttonList.add(new GuiButtonShop(this.item[5], this, 4, this.width / 2 - 90, 120, 90, 20, s15));
      }

      if(this.item[6] != 0) {
         item16 = (new ItemStack(Item.getItemById(this.item[6]), 1, 0)).getItem();
          assert item16 != null;
          s15 = item16.getUnlocalizedName() + ".name";
         s15 = this.st.translateKey(s15);
         this.buttonList.add(new GuiButtonShop(this.item[6], this, 5, this.width / 2 - 90, 140, 90, 20, s15));
      }

      if(this.item[7] != 0) {
         item16 = (new ItemStack(Item.getItemById(this.item[7]), 1, 0)).getItem();
          assert item16 != null;
          s15 = item16.getUnlocalizedName() + ".name";
         s15 = this.st.translateKey(s15);
         this.buttonList.add(new GuiButtonShop(this.item[7], this, 6, this.width / 2 - 90, 160, 90, 20, s15));
      }

      if(this.item[8] != 0) {
         item16 = (new ItemStack(Item.getItemById(this.item[8]), 1, 0)).getItem();
          assert item16 != null;
          s15 = item16.getUnlocalizedName() + ".name";
         s15 = this.st.translateKey(s15);
         this.buttonList.add(new GuiButtonShop(this.item[8], this, 7, this.width / 2 - 90, 180, 90, 20, s15));
      }

      if(this.item[9] != 0) {
         item16 = (new ItemStack(Item.getItemById(this.item[9]), 1, 0)).getItem();
          assert item16 != null;
          s15 = item16.getUnlocalizedName() + ".name";
         s15 = this.st.translateKey(s15);
         this.buttonList.add(new GuiButtonShop(this.item[9], this, 8, this.width / 2 + 20, 40, 90, 20, s15));
      }

      if(this.item[10] != 0) {
         item16 = (new ItemStack(Item.getItemById(this.item[10]), 1, 0)).getItem();
          assert item16 != null;
          s15 = item16.getUnlocalizedName() + ".name";
         s15 = this.st.translateKey(s15);
         this.buttonList.add(new GuiButtonShop(this.item[10], this, 9, this.width / 2 + 20, 60, 90, 20, s15));
      }

      if(this.item[11] != 0) {
         item16 = (new ItemStack(Item.getItemById(this.item[11]), 1, 0)).getItem();
          assert item16 != null;
          s15 = item16.getUnlocalizedName() + ".name";
         s15 = this.st.translateKey(s15);
         this.buttonList.add(new GuiButtonShop(this.item[11], this, 10, this.width / 2 + 20, 80, 90, 20, s15));
      }

      if(this.item[12] != 0) {
         item16 = (new ItemStack(Item.getItemById(this.item[12]), 1, 0)).getItem();
          assert item16 != null;
          s15 = item16.getUnlocalizedName() + ".name";
         s15 = this.st.translateKey(s15);
         this.buttonList.add(new GuiButtonShop(this.item[12], this, 11, this.width / 2 + 20, 100, 90, 20, s15));
      }

      if(this.item[13] != 0) {
         item16 = (new ItemStack(Item.getItemById(this.item[13]), 1, 0)).getItem();
          assert item16 != null;
          s15 = item16.getUnlocalizedName() + ".name";
         s15 = this.st.translateKey(s15);
         this.buttonList.add(new GuiButtonShop(this.item[13], this, 12, this.width / 2 + 20, 120, 90, 20, s15));
      }

      if(this.item[14] != 0) {
         item16 = (new ItemStack(Item.getItemById(this.item[14]), 1, 0)).getItem();
          assert item16 != null;
          s15 = item16.getUnlocalizedName() + ".name";
         s15 = this.st.translateKey(s15);
         this.buttonList.add(new GuiButtonShop(this.item[14], this, 13, this.width / 2 + 20, 140, 90, 20, s15));
      }

      if(this.item[15] != 0) {
         item16 = (new ItemStack(Item.getItemById(this.item[15]), 1, 0)).getItem();
          assert item16 != null;
          s15 = item16.getUnlocalizedName() + ".name";
         s15 = this.st.translateKey(s15);
         this.buttonList.add(new GuiButtonShop(this.item[15], this, 14, this.width / 2 + 20, 160, 90, 20, s15));
      }

      if(this.item[16] != 0) {
         item16 = (new ItemStack(Item.getItemById(this.item[16]), 1, 0)).getItem();
          assert item16 != null;
          s15 = item16.getUnlocalizedName() + ".name";
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
      if(!this.worldObj.isRemote) {
         this.entityplayer.addChatMessage(new ChatComponentText("Shop Keeper: Thank you! Come back again!"));
      }

   }

   protected void actionPerformed(GuiButton guibutton) {
      Item itemstack1;
       String stringGet;
       if(guibutton.id == 0) {
         this.itemSelected = this.item[1];
         this.goldchecker = false;
           itemstack1 = (new ItemStack(Item.getItemById(this.itemSelected), 1, 0)).getItem();
           assert itemstack1 != null;
           stringGet = itemstack1.getUnlocalizedName() + ".name";
           this.stringoutput = this.st.translateKey(stringGet);

           this.price = GoldKeeper.priceItem(String.valueOf(itemstack1.getUnlocalizedName()));
           this.price = (int)(this.price + this.price * 0.8D);
           if(itemstack1 instanceof ItemFood) {
              this.price = (int)(this.price + this.price * 0.2D);
           }
       }

      if(guibutton.id == 1) {
         this.itemSelected = this.item[2];
         this.goldchecker = false;
          itemstack1 = (new ItemStack(Item.getItemById(this.itemSelected), 1, 0)).getItem();
          assert itemstack1 != null;
          stringGet = itemstack1.getUnlocalizedName() + ".name";
          this.stringoutput = this.st.translateKey(stringGet);

          this.price = GoldKeeper.priceItem(String.valueOf(itemstack1.getUnlocalizedName()));
          this.price = (int)(this.price + this.price * 0.8D);
          if(itemstack1 instanceof ItemFood) {
             this.price = (int)(this.price + this.price * 0.2D);
          }
      }

      if(guibutton.id == 2) {
         this.itemSelected = this.item[3];
         this.goldchecker = false;
          itemstack1 = (new ItemStack(Item.getItemById(this.itemSelected), 1, 0)).getItem();
          assert itemstack1 != null;
          stringGet = itemstack1.getUnlocalizedName() + ".name";
          this.stringoutput = this.st.translateKey(stringGet);

          this.price = GoldKeeper.priceItem(String.valueOf(itemstack1.getUnlocalizedName()));
          this.price = (int)(this.price + this.price * 0.8D);
          if(itemstack1 instanceof ItemFood) {
             this.price = (int)(this.price + this.price * 0.2D);
          }
      }

      if(guibutton.id == 3) {
         this.itemSelected = this.item[4];
         this.goldchecker = false;
          itemstack1 = (new ItemStack(Item.getItemById(this.itemSelected), 1, 0)).getItem();
          assert itemstack1 != null;
          stringGet = itemstack1.getUnlocalizedName() + ".name";
          this.stringoutput = this.st.translateKey(stringGet);

          this.price = GoldKeeper.priceItem(String.valueOf(itemstack1.getUnlocalizedName()));
          this.price = (int)(this.price + this.price * 0.8D);
          if(itemstack1 instanceof ItemFood) {
             this.price = (int)(this.price + this.price * 0.2D);
          }
      }

      if(guibutton.id == 4) {
         this.itemSelected = this.item[5];
         this.goldchecker = false;
          itemstack1 = (new ItemStack(Item.getItemById(this.itemSelected), 1, 0)).getItem();
          assert itemstack1 != null;
          stringGet = itemstack1.getUnlocalizedName() + ".name";
          this.stringoutput = this.st.translateKey(stringGet);

          this.price = GoldKeeper.priceItem(String.valueOf(itemstack1.getUnlocalizedName()));
          this.price = (int)(this.price + this.price * 0.8D);
          if(itemstack1 instanceof ItemFood) {
             this.price = (int)(this.price + this.price * 0.2D);
          }
      }

      if(guibutton.id == 5) {
         this.itemSelected = this.item[6];
         this.goldchecker = false;
          itemstack1 = (new ItemStack(Item.getItemById(this.itemSelected), 1, 0)).getItem();
          assert itemstack1 != null;
          stringGet = itemstack1.getUnlocalizedName() + ".name";
          this.stringoutput = this.st.translateKey(stringGet);

          this.price = GoldKeeper.priceItem(String.valueOf(itemstack1.getUnlocalizedName()));
          this.price = (int)(this.price + this.price * 0.8D);
          if(itemstack1 instanceof ItemFood) {
             this.price = (int)(this.price + this.price * 0.2D);
          }
      }

      if(guibutton.id == 6) {
         this.itemSelected = this.item[7];
         this.goldchecker = false;
          itemstack1 = (new ItemStack(Item.getItemById(this.itemSelected), 1, 0)).getItem();
          assert itemstack1 != null;
          stringGet = itemstack1.getUnlocalizedName() + ".name";
          this.stringoutput = this.st.translateKey(stringGet);

          this.price = GoldKeeper.priceItem(String.valueOf(itemstack1.getUnlocalizedName()));
          this.price = (int)(this.price + this.price * 0.8D);
          if(itemstack1 instanceof ItemFood) {
             this.price = (int)(this.price + this.price * 0.2D);
          }
      }

      if(guibutton.id == 7) {
         this.itemSelected = this.item[8];
         this.goldchecker = false;
          itemstack1 = (new ItemStack(Item.getItemById(this.itemSelected), 1, 0)).getItem();
          assert itemstack1 != null;
          stringGet = itemstack1.getUnlocalizedName() + ".name";
          this.stringoutput = this.st.translateKey(stringGet);

          this.price = GoldKeeper.priceItem(String.valueOf(itemstack1.getUnlocalizedName()));
          this.price = (int)(this.price + this.price * 0.8D);
          if(itemstack1 instanceof ItemFood) {
             this.price = (int)(this.price + this.price * 0.2D);
          }
      }

      if(guibutton.id == 8) {
         this.itemSelected = this.item[9];
         this.goldchecker = false;
          itemstack1 = (new ItemStack(Item.getItemById(this.itemSelected), 1, 0)).getItem();
          assert itemstack1 != null;
          stringGet = itemstack1.getUnlocalizedName() + ".name";
          this.stringoutput = this.st.translateKey(stringGet);

          this.price = GoldKeeper.priceItem(String.valueOf(itemstack1.getUnlocalizedName()));
          this.price = (int)(this.price + this.price * 0.8D);
          if(itemstack1 instanceof ItemFood) {
             this.price = (int)(this.price + this.price * 0.2D);
          }
      }

      if(guibutton.id == 9) {
         this.itemSelected = this.item[10];
         this.goldchecker = false;
          itemstack1 = (new ItemStack(Item.getItemById(this.itemSelected), 1, 0)).getItem();
          assert itemstack1 != null;
          stringGet = itemstack1.getUnlocalizedName() + ".name";
          this.stringoutput = this.st.translateKey(stringGet);

          this.price = GoldKeeper.priceItem(String.valueOf(itemstack1.getUnlocalizedName()));
          this.price = (int)(this.price + this.price * 0.8D);
          if(itemstack1 instanceof ItemFood) {
             this.price = (int)(this.price + this.price * 0.2D);
          }
      }

      if(guibutton.id == 10) {
         this.itemSelected = this.item[11];
         this.goldchecker = false;
          itemstack1 = (new ItemStack(Item.getItemById(this.itemSelected), 1, 0)).getItem();
          assert itemstack1 != null;
          stringGet = itemstack1.getUnlocalizedName() + ".name";
          this.stringoutput = this.st.translateKey(stringGet);

          this.price = GoldKeeper.priceItem(String.valueOf(itemstack1.getUnlocalizedName()));
          this.price = (int)(this.price + this.price * 0.8D);
          if(itemstack1 instanceof ItemFood) {
             this.price = (int)(this.price + this.price * 0.2D);
          }
      }

      if(guibutton.id == 11) {
         this.itemSelected = this.item[12];
         this.goldchecker = false;
          itemstack1 = (new ItemStack(Item.getItemById(this.itemSelected), 1, 0)).getItem();
          assert itemstack1 != null;
          stringGet = itemstack1.getUnlocalizedName() + ".name";
          this.stringoutput = this.st.translateKey(stringGet);

          this.price = GoldKeeper.priceItem(String.valueOf(itemstack1.getUnlocalizedName()));
          this.price = (int)(this.price + this.price * 0.8D);
          if(itemstack1 instanceof ItemFood) {
             this.price = (int)(this.price + this.price * 0.2D);
          }
      }

      if(guibutton.id == 12) {
         this.itemSelected = this.item[13];
         this.goldchecker = false;
          itemstack1 = (new ItemStack(Item.getItemById(this.itemSelected), 1, 0)).getItem();
          assert itemstack1 != null;
          stringGet = itemstack1.getUnlocalizedName() + ".name";
          this.stringoutput = this.st.translateKey(stringGet);

          this.price = GoldKeeper.priceItem(String.valueOf(itemstack1.getUnlocalizedName()));
          this.price = (int)(this.price + this.price * 0.8D);
          if(itemstack1 instanceof ItemFood) {
             this.price = (int)(this.price + this.price * 0.2D);
          }
      }

      if(guibutton.id == 13) {
         this.itemSelected = this.item[14];
         this.goldchecker = false;
          itemstack1 = (new ItemStack(Item.getItemById(this.itemSelected), 1, 0)).getItem();
          assert itemstack1 != null;
          stringGet = itemstack1.getUnlocalizedName() + ".name";
          this.stringoutput = this.st.translateKey(stringGet);

          this.price = GoldKeeper.priceItem(String.valueOf(itemstack1.getUnlocalizedName()));
          this.price = (int)(this.price + this.price * 0.8D);
          if(itemstack1 instanceof ItemFood) {
             this.price = (int)(this.price + this.price * 0.2D);
          }
      }

      if(guibutton.id == 14) {
         this.itemSelected = this.item[15];
         this.goldchecker = false;
          itemstack1 = (new ItemStack(Item.getItemById(this.itemSelected), 1, 0)).getItem();
          assert itemstack1 != null;
          stringGet = itemstack1.getUnlocalizedName() + ".name";
          this.stringoutput = this.st.translateKey(stringGet);

          this.price = GoldKeeper.priceItem(String.valueOf(itemstack1.getUnlocalizedName()));
          this.price = (int)(this.price + this.price * 0.8D);
          if(itemstack1 instanceof ItemFood) {
             this.price = (int)(this.price + this.price * 0.2D);
          }
      }

      if(guibutton.id == 15) {
         this.itemSelected = this.item[16];
         this.goldchecker = false;
          itemstack1 = (new ItemStack(Item.getItemById(this.itemSelected), 1, 0)).getItem();
          assert itemstack1 != null;
          stringGet = itemstack1.getUnlocalizedName() + ".name";
          this.stringoutput = this.st.translateKey(stringGet);

          this.price = GoldKeeper.priceItem(String.valueOf(itemstack1.getUnlocalizedName()));
          this.price = (int)(this.price + this.price * 0.8D);
          if(itemstack1 instanceof ItemFood) {
             this.price = (int)(this.price + this.price * 0.2D);
          }
      }

      if(guibutton.id == 16) {
         if(!this.reachedend) {
            ++this.currentGui;
         }

         this.setItemList();
         this.goldchecker = false;
         if(this.itemSelected != null) {
            itemstack1 = (new ItemStack(Item.getItemById(this.itemSelected), 1, 0)).getItem();
             assert itemstack1 != null;
             stringGet = itemstack1.getUnlocalizedName() + ".name";
             this.stringoutput = this.st.translateKey(stringGet);

             this.price = GoldKeeper.priceItem(String.valueOf(itemstack1.getUnlocalizedName()));
            this.price = (int)(this.price + this.price * 0.8D);
            if(itemstack1 instanceof ItemFood) {
               this.price = (int)(this.price + this.price * 0.2D);
            }
         }
      }

      if(guibutton.id == 17) {
         if(this.currentGui != 0) {
            --this.currentGui;
         }

         this.setItemList();
         this.goldchecker = false;
         if(this.itemSelected != null) {
            itemstack1 = (new ItemStack(Item.getItemById(this.itemSelected), 1, 0)).getItem();
             assert itemstack1 != null;
             stringGet = itemstack1.getUnlocalizedName() + ".name";
             this.stringoutput = this.st.translateKey(stringGet);

             this.price = GoldKeeper.priceItem(String.valueOf(itemstack1.getUnlocalizedName()));
            this.price = (int)(this.price + this.price * 0.8D);
            if(itemstack1 instanceof ItemFood) {
               this.price = (int)(this.price + this.price * 0.2D);
            }
         }
      }

      Item item20;
      String s1;
      int j;
      ItemStack var7;
       if (guibutton.id == 18 && (this.itemSelected != null)) {
               var7 = new ItemStack(Item.getItemById(this.itemSelected), 1, 0);
               item20 = var7.getItem();
               if (item20 != null) {
                   s1 = item20.getUnlocalizedName();
                   j = GoldKeeper.priceItem(s1);
                   j = (int)(j + j * 0.8D);
                   if (item20 instanceof ItemFood) {
                       j = (int)(j + j * 0.2D);
                   }

                   if (j <= GoldKeeper.getGoldTotal()) {
                       EntityItem entityitem = new EntityItem(this.worldObj, this.entityplayer.posX, this.entityplayer.posY, this.entityplayer.posZ, var7);
                       this.worldObj.spawnEntityInWorld(entityitem);
                       GoldKeeper.decreaseGold(j);
                   } else {
                       this.goldchecker = true;
                   }
               }

       }
       if (guibutton.id == 21 && this.shopcounter >= 16 && (this.itemSelected != null)) {
               var7 = new ItemStack(Item.getItemById(this.itemSelected), 1, 0);
               item20 = var7.getItem();
               assert item20 != null;
               s1 = item20.getUnlocalizedName();
               j = GoldKeeper.priceItem(s1);
               j = (int)(j + j * 0.8D);
               if (item20 instanceof ItemFood) {
                   j = (int)(j + j * 0.2D);
               }

               if (j * 16 <= GoldKeeper.getGoldTotal()) {
                   this.shopcounter = 0;
               } else {
                   this.goldchecker = true;
               }

       }

      if(guibutton.id == 19) {
         this.mc.displayGuiScreen(null);
         this.goldchecker = false;
      }

      if(guibutton.id == 20) {
         this.mc.displayGuiScreen(null);
         this.entityplayer.openGui(TaleOfKingdoms.instance, 1, this.worldObj, (int)this.entityplayer.posX, (int)this.entityplayer.posY, (int)this.entityplayer.posZ);
         this.goldchecker = false;
      }

   }

   public void drawScreen(int i, int j, float f) {
      int j1;
      if(this.shopcounter < 16) {
         ItemStack l = new ItemStack(Item.getItemById(this.itemSelected), 1, 0);
         Item guibutton = l.getItem();
          assert guibutton != null;
          String resource = guibutton.getUnlocalizedName();
         j1 = GoldKeeper.priceItem(resource);
         j1 = (int)(j1 + j1 * 0.8D);
         if(guibutton instanceof ItemFood) {
            j1 = (int)(j1 + j1 * 0.2D);
         }

         if(j1 <= GoldKeeper.getGoldTotal()) {
            EntityItem entityitem = new EntityItem(this.worldObj, this.entityplayer.posX, this.entityplayer.posY, this.entityplayer.posZ, l);
            this.entityplayer.joinEntityItemWithWorld(entityitem);
            GoldKeeper.decreaseGold(j1);
         }

         ++this.shopcounter;
      }

      this.drawDefaultBackground();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      short var9 = 255;
      short var11 = 255;
      ResourceLocation var14 = new ResourceLocation("taleofkingdoms", "textures/guis/crafting.png");
      this.mc.renderEngine.bindTexture(var14);
      j1 = (this.width - var9) / 2;
      this.drawTexturedModalRect(j1, 0, 0, 0, var9, var11);

       for (Object o : this.buttonList) {
           if (o instanceof GuiButtonShop) {
               GuiButtonShop var12 = (GuiButtonShop) o;
               var12.drawButton(this.mc, i, j);
           }

           if (o instanceof GuiButton) {
               GuiButton var13 = (GuiButton) o;
               var13.drawButton(this.mc, i, j);
           }
       }

      this.drawString(this.fontRendererObj, "Shop Menu - Total Money: " + GoldKeeper.getGoldTotal() + " Gold Coins", this.width / 2, 15, 16763904);
      if(this.goldchecker) {
         this.drawString(this.fontRendererObj, "Selected Item Cost: " + this.stringoutput + " - NOT ENOUGH GOLD", this.width / 2, 30, 16763904);
      } else {
         this.drawString(this.fontRendererObj, "Selected Item Cost: " + this.stringoutput + " - " + this.price + " Gold coins", this.width / 2, 30, 16763904);
      }

      super.drawScreen(i, j, f);
   }

   protected void keyTyped(char par1, int par2) {
      if(par2 == 1 || par2 == this.mc.gameSettings.keyBindInventory.getKeyCode()) {
         this.mc.thePlayer.closeScreen();
      }

   }
}
