/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraftforge.event.ForgeSubscribe
 *  net.minecraftforge.event.entity.living.LivingDeathEvent
 */
package mods.aginsun.kingdoms.handlers;

import mods.aginsun.kingdoms.handlers.ItemDropHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class EntityLivingHandler {
    @ForgeSubscribe
    public void onEntityLivingDeath(LivingDeathEvent event) {
        if (event.source.getDamageType().equals("player")) {
            ItemDropHelper.dropCoins((EntityPlayer)event.source.getSourceOfDamage(), event.entityLiving);
        }
    }
}

