package mods.aginsun.kingdoms.entities;

import mods.aginsun.kingdoms.client.guis.GuiShopList;
import mods.aginsun.kingdoms.entities.EntityNPC;
import mods.aginsun.kingdoms.handlers.GoldKeeper;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
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
            Minecraft minecraft = ModLoader.getMinecraftInstance();
            int i = 0;
            for (int j = 0; j < 256; ++j) {
                String s2;
                String s1;
                Item item;
                ItemStack itemstack;
                if (Block.blocksList[j] == null || (itemstack = new ItemStack(Block.blocksList[j].blockID, 1, 0)) == null || (item = itemstack.getItem()) == null || (s1 = item.getUnlocalizedName()) == null) continue;
                int k = GoldKeeper.priceItem(s1);
                if (itemstack == null || (s2 = String.valueOf(item.getUnlocalizedName()) + ".name") == null) continue;
                String s3 = this.st.translateKey(s2);
                int l = itemstack.itemID;
                if (l == 26 || l == 34 || l == 36 || l == 43 || l == 51 || l == 52 || l == 55 || l == 59 || l == 60 || l == 62 || l == 63 || l == 64 || l == 68 || l == 71 || l == 74 || l == 75 || l == 78 || l == 90 || l == 93 || l == 94 || l == 97 || l == 99 || l == 100 || l == 104 || l == 105 || l == 110 || l == 92 || l == Item.clay.itemID || l == Item.ingotIron.itemID || l == Item.diamond.itemID || l == Item.fishRaw.itemID || l == Item.appleRed.itemID || l == Item.silk.itemID || l == Item.feather.itemID) {
                    k = 0;
                }
                if (k <= 0 || s2.equals("null.name") || s2.equals(s3)) continue;
                this.itemget[i] = itemstack.itemID;
                ++i;
            }
            minecraft.displayGuiScreen((GuiScreen)new GuiShopList(entityplayer, this.worldObj, this.itemget));
        }
        return true;
    }
}

