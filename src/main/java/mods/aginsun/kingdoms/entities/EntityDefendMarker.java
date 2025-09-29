/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.world.World
 */
package mods.aginsun.kingdoms.entities;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityDefendMarker
extends Entity {
    public EntityDefendMarker(World world) {
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

