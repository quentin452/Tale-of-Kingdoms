/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.projectile.EntityThrowable
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MathHelper
 *  net.minecraft.util.MovingObjectPosition
 *  net.minecraft.world.World
 */
package mods.aginsun.kingdoms.entities;

import java.util.List;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityPowerWave
extends EntityThrowable {
    private World worldObj;
    private int counter = 0;
    private EntityLiving entityplayer;
    int duration = 0;
    boolean isDrive = true;

    public EntityPowerWave(World world) {
        super(world);
        this.worldObj = world;
        this.setSize(5.0E-6f, 5.0E-6f);
    }

    public EntityPowerWave(World world, EntityLiving entityliving, int i) {
        super(world, (EntityLivingBase)entityliving);
        this.worldObj = world;
        this.setSize(5.0E-6f, 5.0E-6f);
        this.entityplayer = entityliving;
        this.duration = i;
    }

    public EntityPowerWave(World world, double d, double d1, double d2) {
        super(world, d, d1, d2);
        this.worldObj = world;
        this.setSize(5.0E-6f, 5.0E-6f);
    }

    protected void onThrowableCollision(MovingObjectPosition movingobjectposition) {
        if (movingobjectposition.entityHit != null) {
            // empty if block
        }
    }

    public void onUpdate() {
        super.onUpdate();
        ++this.counter;
        if (this.counter % 2 == 0 && this.counter > 1) {
            List list;
            int i = MathHelper.floor_double((double)this.posX);
            int j = MathHelper.floor_double((double)this.posY);
            int k = MathHelper.floor_double((double)this.posZ);
            for (int l = j; l > 1; --l) {
                int i1 = this.worldObj.getBlockId(i, l, k);
                if (i1 == 0) continue;
                j = l;
                break;
            }
            if (!(list = this.worldObj.getEntitiesWithinAABB(EntityLiving.class, AxisAlignedBB.getBoundingBox((double)this.posX, (double)this.posY, (double)this.posZ, (double)(this.posX + 1.0), (double)(this.posY + 1.0), (double)(this.posZ + 1.0)).expand(5.0, 5.0, 5.0))).isEmpty()) {
                boolean flag = true;
                EntityLivingBase entityliving = (EntityLivingBase)list.get(this.worldObj.rand.nextInt(list.size()));
                if (entityliving instanceof EntityPlayer) {
                    flag = false;
                }
                if (this.entityplayer != null && flag) {
                    entityliving.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this.entityplayer), 10.0f);
                }
            }
            this.worldObj.newExplosion(null, (double)i, (double)(j + 1), (double)k, 1.0f, false, false);
        }
        if (this.counter >= this.duration) {
            this.setDead();
        }
    }

    public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
    }

    protected void onImpact(MovingObjectPosition movingobjectposition) {
    }
}

