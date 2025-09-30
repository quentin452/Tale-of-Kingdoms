
package mods.aginsun.kingdoms.handlers;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import mods.aginsun.kingdoms.handlers.ItemDropHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class EntityLivingHandler {
    @SubscribeEvent
    public void onEntityLivingDeath(LivingDeathEvent event) {
        if (event.source.getDamageType().equals("player")) {
            ItemDropHelper.dropCoins((EntityPlayer)event.source.getSourceOfDamage(), event.entityLiving);
        }
    }
}

