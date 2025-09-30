
package mods.aginsun.kingdoms.entities;

import java.util.List;
import java.util.Random;
import mods.aginsun.kingdoms.entities.EntityDefendArcher;
import mods.aginsun.kingdoms.entities.EntityDefendBandit;
import mods.aginsun.kingdoms.entities.EntityDefendKnight;
import mods.aginsun.kingdoms.entities.EntityDefendPaladin;
import mods.aginsun.kingdoms.entities.EntityDefendWarrior;
import mods.aginsun.kingdoms.entities.EntityNPC;
import mods.aginsun.kingdoms.entities.EntityReficulGuardian;
import mods.aginsun.kingdoms.entities.EntityReficulMage;
import mods.aginsun.kingdoms.entities.EntityReficulSoldier;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.potion.Potion;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import mods.aginsun.kingdoms.util.ChatMessage;

public class EntityHired
extends EntityNPC {
    private World worldObj;
    private EntityPlayer player;
    private Random rand = new Random();
    private static ItemStack defaultHeldItem = new ItemStack(Item.swordIron, 1);
    public boolean isSwinging;
    public int swingProgressInt;
    protected int attackStrength;

    public EntityHired(World world) {
        super(world, defaultHeldItem, 40.0f);
        this.worldObj = world;
        this.isImmuneToFire = false;
        this.attackStrength = 10;
    }

    @Override
    public boolean canBePushed() {
        return false;
    }

    public boolean interact(EntityPlayer entityplayer) {
        this.player = entityplayer;
        if (EntityHired.defaultHeldItem.itemID == 267) {
            defaultHeldItem = new ItemStack((Item)Item.bow, 1);
            if (!this.worldObj.isRemote) {
                ChatMessage.add(this.player,"Hunter: I shall use my bow.");
            }
        } else {
            defaultHeldItem = new ItemStack(Item.swordIron, 1);
            if (!this.worldObj.isRemote) {
                ChatMessage.add(this.player,"Hunter: I shall use my sword.");
            }
        }
        return true;
    }

    protected void updateEntityActionState() {
        Entity entity1;
        List list;
        float f;
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
        for (int j = 0; j < this.worldObj.loadedEntityList.size(); ++j) {
            Entity entity = (Entity)this.worldObj.loadedEntityList.get(j);
            if (!(entity instanceof EntityPlayer)) continue;
            this.player = (EntityPlayer)entity;
        }
        if (!this.hasAttacked && !this.hasPath() && this.ridingEntity == null && this.player != null && (f = this.player.getDistanceToEntity((Entity)this)) > 5.0f) {
            this.getPathOrWalkableBlock((Entity)this.player, f);
        }
        if (this.entityToAttack == null && !this.hasPath() && !(list = this.worldObj.getEntitiesWithinAABB(EntityCreature.class, AxisAlignedBB.getBoundingBox((double)this.posX, (double)this.posY, (double)this.posZ, (double)(this.posX + 1.0), (double)(this.posY + 1.0), (double)(this.posZ + 1.0)).expand(16.0, 4.0, 16.0))).isEmpty() && this.canEntityBeSeen(entity1 = (Entity)list.get(this.worldObj.rand.nextInt(list.size()))) && (entity1 instanceof EntityMob || entity1 instanceof EntityReficulSoldier || entity1 instanceof EntityReficulGuardian || entity1 instanceof EntityReficulMage)) {
            this.entityToAttack = entity1;
        }
    }

    private void getPathOrWalkableBlock(Entity entity, float f) {
        PathEntity pathentity = this.worldObj.getPathEntityToEntity((Entity)this, entity, 16.0f, true, false, false, true);
        if (pathentity == null && f > 12.0f) {
            int i = MathHelper.floor_double((double)entity.posX) - 2;
            int j = MathHelper.floor_double((double)entity.posZ) - 2;
            int k = MathHelper.floor_double((double)entity.boundingBox.minY);
            for (int l = 0; l <= 4; ++l) {
                for (int i1 = 0; i1 <= 4; ++i1) {
                    if (l >= 1 && i1 >= 1 && l <= 3 && i1 <= 3 || !this.worldObj.isBlockNormalCube(i + l, k - 1, j + i1) || this.worldObj.isBlockNormalCube(i + l, k, j + i1) || this.worldObj.isBlockNormalCube(i + l, k + 1, j + i1)) continue;
                    this.setLocationAndAngles((float)(i + l) + 0.5f, k, (float)(j + i1) + 0.5f, this.rotationYaw, this.rotationPitch);
                    return;
                }
            }
        } else {
            this.setPathToEntity(pathentity);
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

    protected void attackEntity(Entity entity, float f) {
        if (EntityHired.defaultHeldItem.itemID == 267) {
            if (this.attackTime <= 0 && f < 2.0f && entity.boundingBox.maxY > this.boundingBox.minY && entity.boundingBox.minY < this.boundingBox.maxY) {
                this.swingItem();
                this.attackTime = 20;
                this.attackEntityAsMob(entity);
            }
        } else if (f < 10.0f) {
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
            }
            this.rotationYaw = (float)(Math.atan2(d1, d) * 180.0 / 3.1415927410125732) - 90.0f;
            this.hasAttacked = true;
        }
    }

    public boolean attackEntityFrom(DamageSource damagesource, int i) {
        if (this.rand.nextInt(2) == 0) {
            boolean flag = true;
            Entity entity = damagesource.getSourceOfDamage();
            if (!this.worldObj.isRemote && entity instanceof EntityDefendBandit || entity instanceof EntityDefendKnight || entity instanceof EntityDefendPaladin || entity instanceof EntityDefendWarrior || entity instanceof EntityDefendArcher || entity instanceof EntityHired || entity instanceof EntityPlayer || entity instanceof EntityPlayerSP) {
                flag = false;
            }
            if (flag) {
                super.attackEntityFrom(damagesource, (float)i);
            }
        }
        return true;
    }

    public void swingItem() {
        if (!this.isSwinging || this.swingProgressInt < 0) {
            this.swingProgressInt = -1;
            this.isSwinging = true;
        }
    }
}

