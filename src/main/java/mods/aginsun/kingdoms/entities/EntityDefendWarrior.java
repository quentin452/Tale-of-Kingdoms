
package mods.aginsun.kingdoms.entities;

import cpw.mods.fml.client.FMLClientHandler;
import java.util.List;
import java.util.Random;
import mods.aginsun.kingdoms.entities.EntityDefendArcher;
import mods.aginsun.kingdoms.entities.EntityDefendBandit;
import mods.aginsun.kingdoms.entities.EntityDefendKnight;
import mods.aginsun.kingdoms.entities.EntityDefendMarker;
import mods.aginsun.kingdoms.entities.EntityDefendPaladin;
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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.potion.Potion;
import net.minecraft.client.Minecraft;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import mods.aginsun.kingdoms.util.ChatMessage;

public class EntityDefendWarrior
extends EntityNPC {
    private World worldObj;
    private Random rand = new Random();
    private EntityPlayer player;
    private static ItemStack defaultHeldItem = new ItemStack(Item.swordIron, 1);
    private int level;
    private boolean follow;
    private boolean checkPlayer;
    private boolean createdMarker;
    private EntityDefendMarker defend;
    protected int attackStrength;
    public boolean isSwinging;
    public int swingProgressInt;

    public EntityDefendWarrior(World world) {
        super(world, defaultHeldItem, 40.0f);
        this.player = FMLClientHandler.instance().getClient().thePlayer;
        this.level = 0;
        this.follow = false;
        this.checkPlayer = true;
        this.createdMarker = false;
        this.worldObj = world;
        this.isImmuneToFire = false;
        this.attackStrength = 6;
    }

    @Override
    protected boolean canDespawn() {
        return false;
    }

    public void upgrade() {
        EntityLiving entityliving = (EntityLiving)EntityList.createEntityByName((String)"DefendKnight", (World)this.worldObj);
        entityliving.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
        if (!this.worldObj.isRemote) {
            this.worldObj.spawnEntityInWorld((Entity)entityliving);
        }
        this.setDead();
    }

    @Override
    public boolean canBePushed() {
        return true;
    }

    @Override
    protected boolean isMovementCeased() {
        return false;
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
                ChatMessage.add(entityplayer,"Warrior: I will follow you.");
            }
            this.defend.setDead();
            this.createdMarker = false;
        } else {
            this.follow = false;
            if (!this.worldObj.isRemote) {
                ChatMessage.add(entityplayer,"Warrior:I will guard this area.");
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
        if (this.attackTime <= 0 && f < 2.0f && entity.boundingBox.maxY > this.boundingBox.minY && entity.boundingBox.minY < this.boundingBox.maxY) {
            this.attackTime = 20;
            this.swingItem();
            this.attackEntityAsMob(entity);
            ++this.level;
            if (this.level > 7) {
                this.upgrade();
            }
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

    public void swingItem() {
        if (!this.isSwinging || this.swingProgressInt < 0) {
            this.swingProgressInt = -1;
            this.isSwinging = true;
        }
    }

    public boolean attackEntityFrom(DamageSource damagesource, int i) {
        if (this.rand.nextInt(3) == 0) {
            boolean flag = true;
            Entity entity = damagesource.getSourceOfDamage();
            if (entity instanceof EntityDefendBandit || entity instanceof EntityDefendKnight || entity instanceof EntityDefendPaladin || entity instanceof EntityDefendWarrior || entity instanceof EntityDefendArcher || entity instanceof EntityHired || entity instanceof EntityPlayer || entity instanceof EntityPlayerSP) {
                flag = false;
            }
            if (flag) {
                super.attackEntityFrom(damagesource, (float)i);
            }
        }
        return true;
    }

    public void onDeath(DamageSource damagesource) {
    }
}

