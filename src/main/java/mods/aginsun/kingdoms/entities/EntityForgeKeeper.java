package mods.aginsun.kingdoms.entities;

import mods.aginsun.kingdoms.client.guis.GuiShopList;
import mods.aginsun.kingdoms.entities.EntityNPC;
import mods.aginsun.kingdoms.handlers.GoldKeeper;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.client.Minecraft;
import net.minecraft.util.StringTranslate;
import net.minecraft.world.World;

public class EntityForgeKeeper
extends EntityNPC {
    private World worldObj;
    Integer[] itemget = new Integer[200];
    private GoldKeeper gold;
    private StringTranslate st = new StringTranslate();

    public EntityForgeKeeper(World world) {
        super(world, null, 100.0f);
        this.worldObj = world;
        this.isImmuneToFire = false;
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
            for (Object obj : Block.blockRegistry) {
                Block block = (Block) obj;
                if (block == null) continue;
                Item item = Item.getItemFromBlock(block);
                if (item == null) continue;
                String s1 = item.getUnlocalizedName();
                if (s1 == null) continue;
                int k = GoldKeeper.priceItem(s1);
                String s2 = String.valueOf(item.getUnlocalizedName()) + ".name";
                String s3 = this.st.translateKey(s2);
                int l = Item.getIdFromItem(item);
                if (item == Items.mushroom_stew || item == Items.wooden_hoe || item == Items.iron_hoe || 
                    item == Items.leather_chestplate || item == Items.spawn_egg || 
                    item == Items.redstone || item == Items.wheat_seeds || item == Items.wheat || 
                    item == Items.bread || item == Items.wooden_door || item == Items.iron_door || 
                    item == Items.snowball || item == Items.fishing_rod || 
                    item == Items.cooked_fished || item == Items.fish || item == Items.sugar || 
                    item == Items.bed || item == Items.repeater || item == Items.cake || 
                    item == Items.pumpkin_seeds || item == Items.melon_seeds || item == Items.cooked_chicken || 
                    item == Items.glowstone_dust || item == Items.clay_ball || item == Items.iron_ingot || 
                    item == Items.diamond || item == Items.apple || 
                    item == Items.string || item == Items.feather) {
                    k = 0;
                }
                if (k <= 0 || s2.equals("null.name") || s2.equals(s3)) continue;
                this.itemget[i] = l;
                ++i;
            }
            minecraft.displayGuiScreen((GuiScreen)new GuiShopList(entityplayer, this.worldObj, this.itemget));
        }
        return true;
    }
}

