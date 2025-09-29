/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityClientPlayerMP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.pathfinding.PathEntity
 *  net.minecraft.src.ModLoader
 *  net.minecraft.util.MathHelper
 *  net.minecraft.world.World
 */
package mods.aginsun.kingdoms.entities;

import mods.aginsun.kingdoms.entities.EntityNPC;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.src.ModLoader;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import mods.aginsun.kingdoms.util.ChatMessage;

public class EntityLostVillager
extends EntityNPC {
    private World worldObj;
    private boolean follow = true;

    public EntityLostVillager(World world) {
        super(world, null, 20.0f);
        this.worldObj = world;
        this.isImmuneToFire = true;
    }

    @Override
    protected boolean isMovementCeased() {
        return this.follow;
    }

    public boolean interact(EntityPlayer entityplayer) {
        this.follow = false;
        if (!this.worldObj.isRemote) {
            ChatMessage.add(entityplayer,"Lost Villager: Thank the heavens! Our village is attacked by the reficuls! Please lead me back to the guild.");
        }
        return true;
    }

    protected void jump() {
        if (!this.follow) {
            this.motionY = 0.42f;
            if (this.isSprinting()) {
                float f = this.rotationYaw * 0.01745329f;
                this.motionX -= (double)(MathHelper.sin((float)f) * 0.2f);
                this.motionZ += (double)(MathHelper.cos((float)f) * 0.2f);
            }
            this.isAirBorne = true;
        }
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (!this.follow) {
            Minecraft minecraft = ModLoader.getMinecraftInstance();
            EntityClientPlayerMP entityplayersp = minecraft.thePlayer;
            if (entityplayersp != null) {
                float f = entityplayersp.getDistanceToEntity((Entity)this);
                PathEntity pathentity = f > 5.0f && f < 18.0f ? this.worldObj.getPathEntityToEntity((Entity)this, (Entity)entityplayersp, 16.0f, true, false, false, true) : null;
                this.setPathToEntity(pathentity);
            }
        }
    }
}

