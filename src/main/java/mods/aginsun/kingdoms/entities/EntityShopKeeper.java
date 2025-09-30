
package mods.aginsun.kingdoms.entities;

import mods.aginsun.kingdoms.client.guis.GuiShopList;
import mods.aginsun.kingdoms.entities.EntityNPC;
import mods.aginsun.kingdoms.handlers.GoldKeeper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.src.ModLoader;
import net.minecraft.util.StringTranslate;
import net.minecraft.world.World;

public class EntityShopKeeper
extends EntityNPC {
    private World worldObj;
    private Integer[] itemget = new Integer[200];
    private StringTranslate st = new StringTranslate();

    public EntityShopKeeper(World world) {
        super(world, null, 100.0f);
        this.worldObj = world;
        this.isImmuneToFire = false;
    }

    @Override
    protected boolean canDespawn() {
        return false;
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityplayer) {
        if (this.isDead) {
            return false;
        }
        return entityplayer.getDistanceSqToEntity((Entity)this) <= 64.0;
    }

    protected void jump() {
    }

    @Override
    protected boolean isMovementCeased() {
        return true;
    }

    @Override
    public boolean canBePushed() {
        return false;
    }

    public boolean interact(EntityPlayer entityplayer) {
        if (this.canInteractWith(entityplayer)) {
            this.heal(100.0f);
            Minecraft minecraft = ModLoader.getMinecraftInstance();
            int i = 0;
            int j = 0;
            String s = "";
            for (int k = 256; k < 32000; ++k) {
                boolean flag2 = false;
                boolean flag3 = false;
                if (Item.itemsList[k] == null) continue;
                ItemStack itemstack = new ItemStack(Item.itemsList[k].itemID, 1, 0);
                Item item = itemstack.getItem();
                if (item instanceof ItemFood) {
                    flag2 = true;
                }
                if (item instanceof ItemArmor) {
                    flag3 = true;
                }
                if (item instanceof ItemSword) {
                    flag3 = true;
                }
                if (item instanceof ItemTool) {
                    flag3 = true;
                }
                if (item != null) {
                    s = item.getUnlocalizedName();
                }
                if (s != null) {
                    j = GoldKeeper.priceItem(s);
                }
                String s1 = String.valueOf(item.getUnlocalizedName()) + ".name";
                String s2 = this.st.translateKey(s1);
                int l = itemstack.itemID;
                if (l == 26 || l == 34 || l == 36 || l == 43 || l == 51 || l == 52 || l == 55 || l == 59 || l == 60 || l == 62 || l == 63 || l == 64 || l == 68 || l == 71 || l == 74 || l == 75 || l == 78 || l == 90 || l == 93 || l == 94 || l == 97 || l == 99 || l == 100 || l == 104 || l == 261 || l == 262 || l == 105 || l == 110 || l == 92 || l == 354 || l == Item.flint.itemID || l == Item.clay.itemID || l == Item.ingotIron.itemID || l == Item.diamond.itemID || l == Item.fishRaw.itemID || l == Item.appleRed.itemID || l == Item.silk.itemID || l == Item.feather.itemID || flag2 || flag3) {
                    j = 0;
                }
                if (j <= 0 || s1.equals("null.name") || s1.equals(s2)) continue;
                this.itemget[i] = itemstack.itemID;
                ++i;
            }
            minecraft.displayGuiScreen((GuiScreen)new GuiShopList(entityplayer, this.worldObj, this.itemget));
        }
        return true;
    }
}

