
package mods.aginsun.kingdoms.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityNPC
extends EntityCreature {
    private ItemStack defaultHeldItem;
    protected World world;
    protected EntityPlayer player;

    public EntityNPC(World par1World, ItemStack defaultHeldItem, float i) {
        super(par1World);
        this.setHealth(i);
        this.world = par1World;
    }

    public ItemStack getHeldItem() {
        return this.defaultHeldItem;
    }

    protected boolean canDespawn() {
        return false;
    }

    public boolean canBePushed() {
        return true;
    }

    protected boolean isMovementCeased() {
        return false;
    }

    public boolean canInteractWith(EntityPlayer entityplayer) {
        if (this.isDead) {
            return false;
        }
        return entityplayer.getDistanceSqToEntity((Entity)this) <= 64.0;
    }
}

