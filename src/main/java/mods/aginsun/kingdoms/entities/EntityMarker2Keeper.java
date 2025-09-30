
package mods.aginsun.kingdoms.entities;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityMarker2Keeper
extends Entity {
    public EntityMarker2Keeper(World world) {
        super(world);
        this.setSize(5.0E-6f, 5.0E-6f);
    }

    public boolean canBePushed() {
        return false;
    }

    public void entityInit() {
    }

    public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
    }
}

