
package mods.aginsun.kingdoms.entities;

import cpw.mods.fml.client.FMLClientHandler;
import java.util.List;
import mods.aginsun.kingdoms.entities.EntityDefendArcher;
import mods.aginsun.kingdoms.entities.EntityDefendBandit;
import mods.aginsun.kingdoms.entities.EntityDefendKnight;
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
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.potion.Potion;
import net.minecraft.client.Minecraft;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import mods.aginsun.kingdoms.util.ChatMessage;

public class EntityDefendMage
extends EntityNPC {
    private EntityPlayer player;
    private static ItemStack defaultHeldItem;
    private boolean follow;
    private boolean checkPlayer;
    protected int attackStrength;
    public boolean isSwinging;
    public int swingProgressInt;

    public EntityDefendMage(World world) {
        super(world, defaultHeldItem, 40.0f);
        this.player = FMLClientHandler.instance().getClient().thePlayer;
        defaultHeldItem = new ItemStack(Items.stick, 1);
        this.follow = false;
        this.checkPlayer = true;
        this.worldObj = world;
        this.isImmuneToFire = false;
        this.attackStrength = 10;
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.follow) {
            Minecraft minecraft = Minecraft.getMinecraft();
            EntityClientPlayerMP entityplayersp = minecraft.thePlayer;
            if (entityplayersp != null) {
                float f = entityplayersp.getDistanceToEntity((Entity)this);
                PathEntity pathentity = f > 5.0f && f < 18.0f ? this.worldObj.getPathEntityToEntity((Entity)this, (Entity)entityplayersp, 16.0f, true, false, false, true) : null;
                this.setPathToEntity(pathentity);
            }
        }
    }

    public boolean interact(EntityPlayer entityplayer) {
        this.player = entityplayer;
        if (!this.follow) {
            this.follow = true;
            if (!this.worldObj.isRemote) {
                ChatMessage.add(entityplayer,"Mage: I will follow you.");
            }
        } else {
            this.follow = false;
            if (!this.worldObj.isRemote) {
                ChatMessage.add(entityplayer,"Mage: I will guard this area.");
            }
        }
        return true;
    }

    protected void updateEntityActionState() {
        Entity entity1;
        List list;
        super.updateEntityActionState();
        int i = 6;
        if (this.isSwinging) {
            ++this.swingProgressInt;
            if (this.swingProgressInt >= i) {
                this.swingProgressInt = 0;
                this.isSwinging = false;
            }
        } else {
            this.swingProgressInt = 0;
        }
        this.swingProgress = (float)this.swingProgressInt / (float)i;
        if (this.checkPlayer) {
            for (int j = 0; j < this.worldObj.loadedEntityList.size(); ++j) {
                Entity entity = (Entity)this.worldObj.loadedEntityList.get(j);
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
            if (this.attackTime == 0) {
                this.attackTime = 80;
                this.swingItem();
                this.attackEntityAsMob(entity);
                this.faceEntity(entity, 30.0f, 30.0f);
            }
            this.hasAttacked = true;
        }
    }

    public boolean attackEntityAsMob(Entity entity) {
        int i = this.attackStrength;
        if (this.isPotionActive(Potion.damageBoost)) {
            i += 3 << this.getActivePotionEffect(Potion.damageBoost).getAmplifier();
        }
        if (this.isPotionActive(Potion.weakness)) {
            i -= 2 << this.getActivePotionEffect(Potion.weakness).getAmplifier();
        }
        return entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), (float)i);
    }

    @Override
    public ItemStack getHeldItem() {
        return defaultHeldItem;
    }

    public boolean attackEntityFrom(DamageSource damagesource, int i) {
        boolean flag = true;
        Entity entity = damagesource.getSourceOfDamage();
        if (entity instanceof EntityDefendBandit || entity instanceof EntityDefendKnight || entity instanceof EntityDefendPaladin || entity instanceof EntityDefendWarrior || entity instanceof EntityDefendArcher || entity instanceof EntityHired || entity instanceof EntityDefendMage || entity instanceof EntityPlayer || entity instanceof EntityPlayerSP) {
            flag = false;
        }
        if (flag) {
            super.attackEntityFrom(damagesource, (float)i);
        }
        return true;
    }

    public void onDeath(DamageSource damagesource) {
    }

    public void swingItem() {
        if (!this.isSwinging || this.swingProgressInt < 0) {
            this.swingProgressInt = -1;
            this.isSwinging = true;
        }
    }
}

