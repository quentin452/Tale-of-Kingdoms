/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.monster.EntityBlaze
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.DamageSource
 *  net.minecraft.world.World
 */
package mods.aginsun.kingdoms.entities;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntitySlash
extends EntityBlaze {
    public int counter = 0;
    public int speed = 200;
    public EntityPlayer entityplayer;
    public World worldObj;
    public boolean explode = false;
    public boolean surround = false;
    public double range = 0.0;

    public EntitySlash(World world) {
        super(world);
        this.worldObj = world;
    }

    public boolean attackEntityFrom(DamageSource damagesource, int i) {
        return false;
    }

    public void onDeath(DamageSource damagesource) {
    }

    public int getEntityBrightnessForRender(float f) {
        return 0xF000F0;
    }

    public float getEntityBrightness(float f) {
        return 1.0f;
    }

    public void onUpdate() {
        List list;
        this.counter += this.speed;
        if (this.counter > 200) {
            this.setDead();
        }
        if (this.counter % 2 == 0 && this.explode && this.speed != 200) {
            this.worldObj.newExplosion(null, this.posX, this.posY + 1.0, this.posZ, 2.0f, true, false);
        }
        if (this.counter % 2 == 0 && this.surround && !(list = this.worldObj.getEntitiesWithinAABB(EntityLiving.class, AxisAlignedBB.getBoundingBox((double)this.posX, (double)this.posY, (double)this.posZ, (double)(this.posX + 1.0), (double)(this.posY + 1.0), (double)(this.posZ + 1.0)).expand(this.range, this.range, this.range))).isEmpty()) {
            boolean flag = true;
            EntityLivingBase entityliving = (EntityLivingBase)list.get(this.worldObj.rand.nextInt(list.size()));
            if (entityliving instanceof EntityPlayer || entityliving instanceof EntitySlash) {
                flag = false;
            }
            if (this.entityplayer != null && flag) {
                this.worldObj.newExplosion((Entity)this.entityplayer, entityliving.posX, entityliving.posY + 1.0, entityliving.posZ, 1.0f, true, false);
            }
        }
    }

    protected void attackEntity(Entity entity, float f) {
    }

    protected void fall(float f) {
    }

    public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
    }

    protected int getDropItemId() {
        return 0;
    }

    public boolean isBurning() {
        return false;
    }

    protected void dropFewItems(boolean flag, int i) {
    }

    public boolean func_40151_ac() {
        return false;
    }

    public void func_40150_a(boolean flag) {
    }

    protected boolean func_40147_Y() {
        return true;
    }
}

