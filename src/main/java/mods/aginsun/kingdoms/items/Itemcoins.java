
package mods.aginsun.kingdoms.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Itemcoins
extends Item {
    public Itemcoins(int i) {
        super(i);
        this.maxStackSize = 1;
        this.setCreativeTab(CreativeTabs.tabMaterials);
    }

    public void registerIcons(IconRegister par1IconRegister) {
        this.itemIcon = par1IconRegister.registerIcon("taleofkingdoms:coins");
    }
}

