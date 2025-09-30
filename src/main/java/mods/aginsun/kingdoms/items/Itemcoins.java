
package mods.aginsun.kingdoms.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class Itemcoins extends Item {
    private IIcon icon;

    public Itemcoins() {
        super();
        this.maxStackSize = 1;
        this.setCreativeTab(CreativeTabs.tabMaterials);
        this.setUnlocalizedName("coins");
    }

    @Override
    public void registerIcons(IIconRegister reg) {
        this.icon = reg.registerIcon("taleofkingdoms:coins");
    }

    @Override
    public IIcon getIconFromDamage(int meta) {
        return this.icon;
    }
}

