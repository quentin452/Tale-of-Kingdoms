
package mods.aginsun.kingdoms.handlers;

import cpw.mods.fml.common.IPickupNotifier;
import mods.aginsun.kingdoms.TaleOfKingdoms;
import mods.aginsun.kingdoms.handlers.GoldKeeper;
import mods.aginsun.kingdoms.handlers.WorthyKeeper;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class PickupHandler
implements IPickupNotifier {
    public void notifyPickup(EntityItem item, EntityPlayer player) {
        ItemStack itemstack = item.getEntityItem();
        if (itemstack.itemID == TaleOfKingdoms.coins.itemID) {
            player.inventory.consumeInventoryItem(itemstack.itemID);
            GoldKeeper.addGold(2);
            WorthyKeeper.getInstance().addWorthy(1.0f);
        }
    }
}

