/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityClientPlayerMP
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.EntityList
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.monster.EntityMob
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.projectile.EntityArrow
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.pathfinding.PathEntity
 *  net.minecraft.src.ModLoader
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.MathHelper
 *  net.minecraft.world.World
 */
package mods.aginsun.kingdoms.entities;

import java.util.List;
import mods.aginsun.kingdoms.entities.EntityDefendBandit;
import mods.aginsun.kingdoms.entities.EntityDefendKnight;
import mods.aginsun.kingdoms.entities.EntityDefendMage;
import mods.aginsun.kingdoms.entities.EntityDefendMarker;
import mods.aginsun.kingdoms.entities.EntityDefendPaladin;
import mods.aginsun.kingdoms.entities.EntityDefendWarrior;
import mods.aginsun.kingdoms.entities.EntityHired;
import mods.aginsun.kingdoms.entities.EntityNPC;
import mods.aginsun.kingdoms.entities.EntityReficulGuardian;
import mods.aginsun.kingdoms.entities.EntityReficulMage;
import mods.aginsun.kingdoms.entities.EntityReficulSoldier;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.src.ModLoader;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import mods.aginsun.kingdoms.util.ChatMessage;

public class EntityDefendArcher
extends EntityNPC {
    private World worldObj;
    private static ItemStack defaultHeldItem = new ItemStack((Item)Item.bow, 1);
    private int level = 0;
    private boolean follow = false;
    private boolean checkPlayer = true;
    private boolean createdMarker = false;
    private EntityDefendMarker defend;
    protected int attackStrength;

    public EntityDefendArcher(World world) {
        super(world, defaultHeldItem, 40.0f);
        this.worldObj = world;
        this.isImmuneToFire = false;
        this.attackStrength = 10;
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
        Minecraft minecraft = ModLoader.getMinecraftInstance();
        EntityClientPlayerMP entityplayersp = minecraft.thePlayer;
        if (this.follow) {
            if (entityplayersp != null) {
                float f = entityplayersp.getDistanceToEntity((Entity)this);
                PathEntity pathentity = f > 5.0f && f < 18.0f ? this.worldObj.getPathEntityToEntity((Entity)this, (Entity)entityplayersp, 16.0f, true, false, false, true) : null;
                this.setPathToEntity(pathentity);
            }
        } else {
            if (!this.createdMarker) {
                System.out.println("Defend Location");
                this.defend = (EntityDefendMarker)EntityList.createEntityByName((String)"DefendMark", (World)this.worldObj);
                this.defend.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
                this.worldObj.spawnEntityInWorld((Entity)this.defend);
                this.createdMarker = true;
            }
            if (this.createdMarker && this.defend != null) {
                float f1 = this.defend.getDistanceToEntity((Entity)this);
                PathEntity pathentity1 = f1 > 5.0f && f1 < 40.0f ? this.worldObj.getPathEntityToEntity((Entity)this, (Entity)this.defend, 40.0f, true, false, false, true) : null;
                this.setPathToEntity(pathentity1);
            }
        }
    }

    public boolean interact(EntityPlayer entityplayer) {
        if (!this.follow) {
            this.follow = true;
            if (!this.worldObj.isRemote) {
                ChatMessage.add(entityplayer,"Archer: I will follow you.");
            }
            this.defend.setDead();
            this.createdMarker = false;
        } else {
            this.follow = false;
            if (!this.worldObj.isRemote) {
                ChatMessage.add(entityplayer,"Archer:I will guard this area.");
            }
        }
        return true;
    }

    public void upgrade() {
        EntityLiving entityliving = (EntityLiving)EntityList.createEntityByName((String)"DefendBandit", (World)this.worldObj);
        entityliving.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
        if (!this.worldObj.isRemote) {
            this.worldObj.spawnEntityInWorld((Entity)entityliving);
        }
        this.setDead();
    }

    protected void updateEntityActionState() {
        Entity entity1;
        List list;
        super.updateEntityActionState();
        if (this.checkPlayer) {
            for (int i = 0; i < this.worldObj.loadedEntityList.size(); ++i) {
                Entity entity = (Entity)this.worldObj.loadedEntityList.get(i);
                if (!(entity instanceof EntityPlayer)) continue;
                this.player = (EntityPlayer)entity;
            }
            if (this.player != null && this.player.getDistanceSqToEntity((Entity)this) <= 64.0) {
                this.follow = true;
            }
        }
        this.checkPlayer = false;
        if (this.entityToAttack == null && !this.hasPath() && !(list = this.worldObj.getEntitiesWithinAABB(EntityCreature.class, AxisAlignedBB.getBoundingBox((double)this.posX, (double)this.posY, (double)this.posZ, (double)(this.posX + 1.0), (double)(this.posY + 1.0), (double)(this.posZ + 1.0)).expand(16.0, 4.0, 16.0))).isEmpty() && this.canEntityBeSeen(entity1 = (Entity)list.get(this.worldObj.rand.nextInt(list.size()))) && (entity1 instanceof EntityMob || entity1 instanceof EntityReficulSoldier || entity1 instanceof EntityReficulGuardian || entity1 instanceof EntityReficulMage)) {
            this.entityToAttack = entity1;
        }
    }

    protected void attackEntity(Entity entity, float f) {
        if (f < 10.0f) {
            double d = entity.posX - this.posX;
            double d1 = entity.posZ - this.posZ;
            if (this.attackTime == 0) {
                EntityArrow entityarrow = new EntityArrow(this.worldObj, (EntityLivingBase)this, 1.0f);
                double d2 = entity.posY + (double)entity.getEyeHeight() - (double)0.7f - entityarrow.posY;
                float f1 = MathHelper.sqrt_double((double)(d * d + d1 * d1)) * 0.2f;
                this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 1.0f, 1.0f / (this.rand.nextFloat() * 0.4f + 0.8f));
                this.worldObj.spawnEntityInWorld((Entity)entityarrow);
                entityarrow.setThrowableHeading(d, d2 + (double)f1, d1, 1.6f, 12.0f);
                this.attackTime = 30;
                ++this.level;
                if (this.level > 12) {
                    this.upgrade();
                }
            }
            this.rotationYaw = (float)(Math.atan2(d1, d) * 180.0 / 3.1415927410125732) - 90.0f;
            this.hasAttacked = true;
        }
    }

    public boolean attackEntityFrom(DamageSource damagesource, int i) {
        boolean flag = true;
        Entity entity = damagesource.getSourceOfDamage();
        if (entity instanceof EntityDefendBandit || entity instanceof EntityDefendKnight || entity instanceof EntityDefendMage || entity instanceof EntityDefendPaladin || entity instanceof EntityDefendWarrior || entity instanceof EntityDefendArcher || entity instanceof EntityHired || entity instanceof EntityPlayer || entity instanceof EntityPlayerSP) {
            flag = false;
        }
        if (flag) {
            super.attackEntityFrom(damagesource, (float)i);
        }
        return true;
    }

    public void onDeath(DamageSource damagesource) {
    }
}

