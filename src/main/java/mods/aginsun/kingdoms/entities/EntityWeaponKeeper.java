
package mods.aginsun.kingdoms.entities;

import mods.aginsun.kingdoms.client.guis.GuiShopList;
import mods.aginsun.kingdoms.entities.EntityNPC;
import mods.aginsun.kingdoms.handlers.GoldKeeper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.init.Items;
import net.minecraft.util.StringTranslate;
import net.minecraft.world.World;

public class EntityWeaponKeeper
extends EntityNPC {
    private World worldObj;
    private Integer[] itemget = new Integer[200];
    private StringTranslate st = new StringTranslate();

    public EntityWeaponKeeper(World world) {
        super(world, null, 100.0f);
        this.worldObj = world;
        this.isImmuneToFire = false;
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
                    flag3 = false;
                }
                if (item instanceof ItemSword) {
                    flag3 = false;
                }
                if (item instanceof ItemTool) {
                    flag3 = false;
                }
                if (item != null) {
                    s = item.getUnlocalizedName();
                }
                if (s != null) {
                    j = GoldKeeper.priceItem(s);
                }
                String s1 = String.valueOf(item.getUnlocalizedName()) + ".name";
                String s2 = this.st.translateKey(s1);
                                
                if (item == Items.mushroom_stew || 
                    item == Items.wooden_hoe ||
                    item == Items.stone_hoe ||
                    item == Items.iron_hoe || 
                    item == Items.diamond_hoe ||
                    item == Items.golden_hoe ||
                    item == Items.wooden_door || 
                    item == Items.iron_door || 
                    item == Items.lava_bucket ||
                    item == Items.redstone || 
                    item == Items.leather || 
                    item == Items.fishing_rod || 
                    item == Items.fish ||
                    item == Items.cooked_fished || 
                    item == Items.sugar || 
                    item == Items.bed || 
                    item == Items.repeater || 
                    item == Items.melon || 
                    item == Items.pumpkin_seeds || 
                    item == Items.cooked_chicken ||
                    item == Items.glowstone_dust || 
                    item == Items.cake || 
                    item == Items.flint || 
                    item == Items.clay_ball || 
                    item == Items.iron_ingot || 
                    item == Items.diamond || 
                    item == Items.fish || 
                    item == Items.apple || 
                    item == Items.string || 
                    item == Items.feather || 
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

