
package mods.aginsun.kingdoms.entities;

import cpw.mods.fml.client.FMLClientHandler;
import java.util.List;
import mods.aginsun.kingdoms.entities.EntityDefendArcher;
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
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import mods.aginsun.kingdoms.util.ChatMessage;

public class EntityDefendBandit
extends EntityNPC {
    private EntityPlayer player;
    private static ItemStack defaultHeldItem = new ItemStack((Item)Item.bow, 1);
    private boolean follow;
    private boolean checkPlayer;
    private boolean createdMarker;
    private EntityDefendMarker defend;

    public EntityDefendBandit(World world) {
        super(world, defaultHeldItem, 40.0f);
        this.player = FMLClientHandler.instance().getClient().thePlayer;
        this.follow = false;
        this.checkPlayer = true;
        this.createdMarker = false;
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
        Minecraft minecraft = Minecraft.getMinecraft();
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
        this.player = entityplayer;
        if (!this.follow) {
            this.follow = true;
            if (!this.worldObj.isRemote) {
                ChatMessage.add(entityplayer,"Bandit: I will follow you.");
            }
            this.defend.setDead();
            this.createdMarker = false;
        } else {
            this.follow = false;
            if (!this.worldObj.isRemote) {
                ChatMessage.add(entityplayer,"Bandit:I will guard this area.");
            }
        }
        return true;
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
                this.attackTime = 20;
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

