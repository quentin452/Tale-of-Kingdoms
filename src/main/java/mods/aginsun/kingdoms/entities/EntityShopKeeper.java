
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
import net.minecraft.client.Minecraft;
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
            Minecraft minecraft = Minecraft.getMinecraft();
            int i = 0;
            int j = 0;
            String s = "";
            for (int k = 256; k < 32000; ++k) {
                boolean flag2 = false;
                boolean flag3 = false;
                Item item = Item.getItemById(k);
                if (item == null) continue;
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
                if (item == net.minecraft.init.Items.mushroom_stew || 
                    item == net.minecraft.init.Items.wooden_hoe ||
                    item == net.minecraft.init.Items.iron_hoe || 
                    item == net.minecraft.init.Items.leather_chestplate || 
                    item == net.minecraft.init.Items.iron_chestplate ||
                    item == net.minecraft.init.Items.iron_leggings || 
                    item == net.minecraft.init.Items.diamond_chestplate || 
                    item == net.minecraft.init.Items.golden_chestplate ||
                    item == net.minecraft.init.Items.golden_leggings || 
                    item == net.minecraft.init.Items.flint || 
                    item == net.minecraft.init.Items.porkchop || 
                    item == net.minecraft.init.Items.cooked_porkchop || 
                    item == net.minecraft.init.Items.wooden_door || 
                    item == net.minecraft.init.Items.lava_bucket ||
                    item == net.minecraft.init.Items.iron_door || 
                    item == net.minecraft.init.Items.redstone || 
                    item == net.minecraft.init.Items.leather || 
                    item == net.minecraft.init.Items.fishing_rod || 
                    item == net.minecraft.init.Items.fish ||
                    item == net.minecraft.init.Items.cooked_fished || 
                    item == net.minecraft.init.Items.sugar || 
                    item == net.minecraft.init.Items.bed || 
                    item == net.minecraft.init.Items.repeater || 
                    item == net.minecraft.init.Items.melon || 
                    item == net.minecraft.init.Items.bow || 
                    item == net.minecraft.init.Items.arrow ||
                    item == net.minecraft.init.Items.pumpkin_seeds || 
                    item == net.minecraft.init.Items.cooked_chicken ||
                    item == net.minecraft.init.Items.glowstone_dust || 
                    item == net.minecraft.init.Items.cake || 
                    item == net.minecraft.init.Items.flint || 
                    item == net.minecraft.init.Items.clay_ball || 
                    item == net.minecraft.init.Items.iron_ingot || 
                    item == net.minecraft.init.Items.diamond || 
                    item == net.minecraft.init.Items.apple || 
                    item == net.minecraft.init.Items.string || 
                    item == net.minecraft.init.Items.feather || 
                    flag2 || flag3) {
                    j = 0;
                }
                if (j <= 0 || s1.equals("null.name") || s1.equals(s2)) continue;
                this.itemget[i] = k;
                ++i;
            }
            minecraft.displayGuiScreen((GuiScreen)new GuiShopList(entityplayer, this.worldObj, this.itemget));
        }
        return true;
    }
}

