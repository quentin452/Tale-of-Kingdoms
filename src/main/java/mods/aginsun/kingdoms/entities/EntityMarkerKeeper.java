/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.src.ModLoader
 *  net.minecraft.world.World
 */
package mods.aginsun.kingdoms.entities;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;

public class EntityMarkerKeeper
extends Entity {
    public int treelife = 8;
    public EntityPlayer player;
    private World world;

    public EntityMarkerKeeper(World world1) {
        super(world1);
        this.world = world1;
        this.setSize(5.0E-6f, 5.0E-6f);
        Minecraft minecraft = ModLoader.getMinecraftInstance();
        this.player = minecraft.thePlayer;
    }

    public boolean canBePushed() {
        return false;
    }

    public void entityInit() {
        --this.treelife;
        System.out.println(this.treelife);
        this.onLivingUpdate();
    }

    public void onLivingUpdate() {
        int i = (int)this.posY;
        int j = (int)this.posY - 1;
        if (this.treelife == 0) {
            while (this.worldObj.getBlockId((int)this.posX, i, (int)this.posZ) == 17 && this.player != null) {
                this.worldObj.setBlock((int)this.posX, i, (int)this.posZ, 0);
                ItemStack itemstack = new ItemStack(17, 1, 0);
                EntityItem entityitem = new EntityItem(this.worldObj, this.player.posX, this.player.posY, this.player.posZ, itemstack);
                this.world.spawnEntityInWorld((Entity)entityitem);
                itemstack = new ItemStack(17, 1, 0);
                entityitem = new EntityItem(this.worldObj, this.player.posX, this.player.posY, this.player.posZ, itemstack);
                this.world.spawnEntityInWorld((Entity)entityitem);
                ++i;
            }
            int k = j;
            while (this.worldObj.getBlockId((int)this.posX, k, (int)this.posZ) == 17 && this.player != null) {
                this.worldObj.setBlock((int)this.posX, k, (int)this.posZ, 0);
                ItemStack itemstack1 = new ItemStack(17, 1, 0);
                EntityItem entityitem1 = new EntityItem(this.worldObj, this.player.posX, this.player.posY, this.player.posZ, itemstack1);
                this.world.spawnEntityInWorld((Entity)entityitem1);
                itemstack1 = new ItemStack(17, 1, 0);
                entityitem1 = new EntityItem(this.worldObj, this.player.posX, this.player.posY, this.player.posZ, itemstack1);
                this.world.spawnEntityInWorld((Entity)entityitem1);
                --k;
            }
            this.setDead();
        }
    }

    public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
    }
}

