/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityList
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.monster.EntityMob
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.MathHelper
 *  net.minecraft.world.World
 */
package mods.aginsun.kingdoms.entities;

import java.util.List;
import java.util.Random;
import mods.aginsun.kingdoms.entities.EntityNPC;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import mods.aginsun.kingdoms.util.ChatMessage;

public class EntityVillageMember
extends EntityNPC {
    private boolean hasAxe = false;
    private boolean hasPick = false;

    public EntityVillageMember(World world) {
        super(world, null, 30.0f);
        this.worldObj = world;
        this.isImmuneToFire = false;
    }

    @Override
    public boolean canBePushed() {
        return false;
    }

    public boolean interact(EntityPlayer entityplayer) {
        ItemStack itemstack = entityplayer.inventory.getCurrentItem();
        if (!(itemstack == null || this.hasAxe || itemstack.itemID != 271 && itemstack.itemID != 275 && itemstack.itemID != 258)) {
            entityplayer.inventory.setInventorySlotContents(entityplayer.inventory.currentItem, null);
            this.hasAxe = true;
        }
        if (!(itemstack == null || this.hasPick || itemstack.itemID != 257 && itemstack.itemID != 270 && itemstack.itemID != 274)) {
            entityplayer.inventory.setInventorySlotContents(entityplayer.inventory.currentItem, null);
            this.hasPick = true;
        }
        if (!(this.hasPick || this.hasAxe || this.world.isRemote)) {
            ChatMessage.add(entityplayer,"Villager: My king! Do you need a worker? Give me an axe and a pickaxe and I will work for you.");
        }
        if (!this.hasPick && this.hasAxe && !this.world.isRemote) {
            ChatMessage.add(entityplayer,"Villager: I still need a pickaxe sir.");
        }
        if (this.hasPick && !this.hasAxe && !this.world.isRemote) {
            ChatMessage.add(entityplayer,"Villager: I still need an axe sir.");
        }
        if (this.hasPick && this.hasAxe && !this.world.isRemote) {
            ChatMessage.add(entityplayer,"Worker: I am now a worker sir! Lead the way!");
            EntityLiving entityliving = (EntityLiving)EntityList.createEntityByName((String)"WorkerMember", (World)this.worldObj);
            entityliving.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
            this.worldObj.spawnEntityInWorld((Entity)entityliving);
            this.setDead();
        }
        return true;
    }

    protected void updateEntityActionState() {
        super.updateEntityActionState();
        List list = this.worldObj.getEntitiesWithinAABB(EntityMob.class, AxisAlignedBB.getBoundingBox((double)this.posX, (double)this.posY, (double)this.posZ, (double)(this.posX + 1.0), (double)(this.posY + 1.0), (double)(this.posZ + 1.0)).expand(20.0, 4.0, 20.0));
        if (!list.isEmpty()) {
            Entity entity = (Entity)list.get(this.worldObj.rand.nextInt(list.size()));
            entity.setDead();
        }
    }

    protected void jump() {
        Random random = new Random();
        if (random.nextInt(15) == 0) {
            this.motionY = 0.42f;
            if (this.isSprinting()) {
                float f = this.rotationYaw * 0.01745329f;
                this.motionX -= (double)(MathHelper.sin((float)f) * 0.2f);
                this.motionZ += (double)(MathHelper.cos((float)f) * 0.2f);
            }
            this.isAirBorne = true;
        }
    }
}

