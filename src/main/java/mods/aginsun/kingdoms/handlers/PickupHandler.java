
package mods.aginsun.kingdoms.handlers;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import mods.aginsun.kingdoms.TaleOfKingdoms;
import mods.aginsun.kingdoms.handlers.GoldKeeper;
import mods.aginsun.kingdoms.handlers.WorthyKeeper;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

public class PickupHandler {
    @SubscribeEvent
    public void onItemPickup(EntityItemPickupEvent event) {
        EntityItem item = event.item;
        EntityPlayer player = event.entityPlayer;
        ItemStack itemstack = item.getEntityItem();
        
        if (itemstack.getItem() == TaleOfKingdoms.coins) {
            // Remove the coin item from inventory to prevent duplication
            player.inventory.consumeInventoryItem(TaleOfKingdoms.coins);
            GoldKeeper.addGold(2);
            WorthyKeeper.getInstance().addWorthy(1.0f);
        }
    }
}

