
package mods.aginsun.kingdoms.entities;

import mods.aginsun.kingdoms.client.guis.GuiShopList;
import mods.aginsun.kingdoms.handlers.GoldKeeper;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraft.init.Items;

public class EntityFoodKeeper extends EntityNPC {
    private World worldObj;
    private Integer[] itemget = new Integer[200];

    public EntityFoodKeeper(World world) {
        super(world, null, 100.0f);
        this.worldObj = world;
        this.isImmuneToFire = false;
    }

    @Override
    public boolean canBePushed() {
        return false;
    }

    @Override
    public boolean interact(EntityPlayer entityplayer) {
        if (this.canInteractWith(entityplayer)) {
            this.heal(100.0f);
            Minecraft minecraft = Minecraft.getMinecraft();
            int i = 0;
            int j = 0;
            String s = "";
            for (Object obj : Item.itemRegistry) {
                if (!(obj instanceof Item)) continue;
                Item item = (Item) obj;
                boolean flag1 = false;
                if (item instanceof ItemFood) {
                    flag1 = true;
                }
                if (item != null) {
                    s = item.getUnlocalizedName();
                }
                if (Item.getIdFromItem(item) == Item.getIdFromItem(Items.cake)) {
                    flag1 = true;
                }
                if (s != null) {
                    j = GoldKeeper.priceItem(s);
                }
                String s1 = item.getUnlocalizedName() + ".name";
                String s2 = StatCollector.translateToLocal(s1);
                int l = Item.getIdFromItem(item);
                if (l == Item.getIdFromItem(Items.mushroom_stew) || l == Item.getIdFromItem(Items.wooden_hoe) || l == Item.getIdFromItem(Items.iron_hoe) 
                        || l == Item.getIdFromItem(Items.leather_chestplate) || l == Item.getIdFromItem(Items.iron_chestplate) || l == Item.getIdFromItem(Items.iron_leggings) 
                        || l == Item.getIdFromItem(Items.diamond_chestplate) || l == Item.getIdFromItem(Items.golden_chestplate) || l == Item.getIdFromItem(Items.golden_leggings) 
                        || l == Item.getIdFromItem(Items.flint) || l == Item.getIdFromItem(Items.porkchop) || l == Item.getIdFromItem(Items.cooked_porkchop) 
                        || l == Item.getIdFromItem(Items.wooden_door) || l == Item.getIdFromItem(Items.iron_door) || l == Item.getIdFromItem(Items.redstone) 
                        || l == Item.getIdFromItem(Items.snowball) || l == Item.getIdFromItem(Items.leather) || l == Item.getIdFromItem(Items.fishing_rod) 
                        || l == Item.getIdFromItem(Items.fish) || l == Item.getIdFromItem(Items.cooked_fished) || l == Item.getIdFromItem(Items.sugar) 
                        || l == Item.getIdFromItem(Items.cake) || l == Item.getIdFromItem(Items.bed) || l == Item.getIdFromItem(Items.melon) 
                        || l == Item.getIdFromItem(Items.pumpkin_seeds) || l == Item.getIdFromItem(Items.cooked_chicken) || !flag1
                        || l == Item.getIdFromItem(Item.getItemFromBlock(net.minecraft.init.Blocks.clay))
                        || l == Item.getIdFromItem(Items.iron_ingot)
                        || l == Item.getIdFromItem(Items.diamond)
                        || l == Item.getIdFromItem(Items.fish)
                        || l == Item.getIdFromItem(Items.apple)
                        || l == Item.getIdFromItem(Items.string)
                        || l == Item.getIdFromItem(Items.feather)) {
                    j = 0;
                }
                if (j <= 0 || s1.equals("null.name") || s1.equals(s2)) continue;
                this.itemget[i] = l;
                ++i;
            }
            minecraft.displayGuiScreen(new GuiShopList(entityplayer, this.worldObj, this.itemget));
        }
        return true;
    }
}

