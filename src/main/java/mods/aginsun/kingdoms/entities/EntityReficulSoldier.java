
package mods.aginsun.kingdoms.entities;

import java.util.Random;
import mods.aginsun.kingdoms.entities.EntityNPC;
import mods.aginsun.kingdoms.handlers.WorthyKeeper;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityReficulSoldier
extends EntityNPC {
    private static ItemStack defaultHeldItem = new ItemStack(Items.iron_sword, 1);
    private EntityPlayer player;
    private boolean playerPresence = true;
    private Random rand = new Random();
    private World worldObj;
    protected int attackStrength;
    public boolean isSwinging;
    public int swingProgressInt;

    public EntityReficulSoldier(World world) {
        super(world, defaultHeldItem, 40.0f);
        this.worldObj = world;
        this.attackStrength = 4;
        this.isImmuneToFire = true;
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
        for (int i = 0; i < 2; ++i) {
            this.worldObj.spawnParticle("portal", this.posX + (this.rand.nextDouble() - 0.5) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height - 0.25, this.posZ + (this.rand.nextDouble() - 0.5) * (double)this.width, (this.rand.nextDouble() - 0.5) * 2.0, -this.rand.nextDouble(), (this.rand.nextDouble() - 0.5) * 2.0);
        }
    }

    protected boolean teleportToEntity(Entity entity) {
        Vec3 vec3d = Vec3.createVectorHelper((double)(this.posX - entity.posX), (double)(this.boundingBox.minY + (double)(this.height / 2.0f) - entity.posY + (double)entity.getEyeHeight()), (double)(this.posZ - entity.posZ));
        vec3d = vec3d.normalize();
        double d = 16.0;
        double d1 = this.posX + (this.rand.nextDouble() - 0.5) * 8.0 - vec3d.xCoord * d;
        double d2 = this.posY + (double)(this.rand.nextInt(16) - 8) - vec3d.yCoord * d;
        double d3 = this.posZ + (this.rand.nextDouble() - 0.5) * 8.0 - vec3d.zCoord * d;
        return this.teleportTo(d1, d2, d3);
    }

    protected boolean teleportTo(double d, double d1, double d2) {
        if (this.rand.nextInt(10) == 0) {
            int k;
            int j;
            double d3 = this.posX;
            double d4 = this.posY;
            double d5 = this.posZ;
            this.posX = d;
            this.posY = d1;
            this.posZ = d2;
            boolean flag = false;
            int i = MathHelper.floor_double((double)this.posX);
            if (this.worldObj.blockExists(i, j = MathHelper.floor_double((double)this.posY), k = MathHelper.floor_double((double)this.posZ))) {
                boolean flag1 = false;
                while (!flag1 && j > 0) {
                    net.minecraft.block.Block blockBelow = this.worldObj.getBlock(i, j - 1, k);
                    if (blockBelow.isAir(this.worldObj, i, j - 1, k) || !blockBelow.getMaterial().isSolid()) {
                        this.posY -= 1.0;
                        --j;
                        continue;
                    }
                    flag1 = true;
                }
                if (flag1) {
                    this.setPosition(this.posX, this.posY, this.posZ);
                    if (this.worldObj.getCollidingBoundingBoxes((Entity)this, this.boundingBox).size() == 0 && !this.worldObj.isAnyLiquid(this.boundingBox)) {
                        flag = true;
                    }
                }
            }
            if (!flag) {
                this.setPosition(d3, d4, d5);
                return false;
            }
            int l = 128;
            for (int j1 = 0; j1 < l; ++j1) {
                double d6 = (double)j1 / ((double)l - 1.0);
                float f = (this.rand.nextFloat() - 0.5f) * 0.2f;
                float f1 = (this.rand.nextFloat() - 0.5f) * 0.2f;
                float f2 = (this.rand.nextFloat() - 0.5f) * 0.2f;
                double d7 = d3 + (this.posX - d3) * d6 + (this.rand.nextDouble() - 0.5) * (double)this.width * 2.0;
                double d8 = d4 + (this.posY - d4) * d6 + this.rand.nextDouble() * (double)this.height;
                double d9 = d5 + (this.posZ - d5) * d6 + (this.rand.nextDouble() - 0.5) * (double)this.width * 2.0;
                this.worldObj.spawnParticle("portal", d7, d8, d9, (double)f, (double)f1, (double)f2);
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

    protected void attackEntity(Entity entity, float f) {
        if (this.attackTime <= 0 && f < 2.0f && entity.boundingBox.maxY > this.boundingBox.minY && entity.boundingBox.minY < this.boundingBox.maxY) {
            this.attackTime = 20;
            this.swingItem();
            this.attackEntityAsMob(entity);
            entity.setFire(8);
        }
    }

    public void onDeath(DamageSource damagesource) {
        WorthyKeeper.getInstance().addWorthy(70.0f);
    }

    @Override
    protected boolean isMovementCeased() {
        return this.playerPresence;
    }

    public void knockBack(Entity entity, int i, double d, double d1) {
        if (this.rand.nextInt(2) == 0) {
            this.isAirBorne = true;
            float f = MathHelper.sqrt_double((double)(d * d + d1 * d1));
            float f1 = 0.4f;
            this.motionX /= 2.0;
            this.motionY /= 2.0;
            this.motionZ /= 2.0;
            this.motionX -= d / (double)f * (double)f1;
            this.motionY += (double)0.4f;
            this.motionZ -= d1 / (double)f * (double)f1;
            if (this.motionY > (double)0.4f) {
                this.motionY = 0.4f;
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

    protected void updateEntityActionState() {
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
        if (this.player != null) {
            if (this.player.getDistanceSqToEntity((Entity)this) <= 220.0 && this.worldObj.difficultySetting != 0) {
            if (this.player.getDistanceSqToEntity((Entity)this) <= 220.0 && this.worldObj.difficultySetting != net.minecraft.world.EnumDifficulty.PEACEFUL) {
                this.playerPresence = false;
                if (this.rand.nextInt(6) == 0) {
                    this.teleportToEntity((Entity)this.player);
                    if (this.rand.nextInt(10) == 0) {
                        for (int k = 0; k < 2; ++k) {
                            this.worldObj.spawnParticle("largesmoke", this.posX + (this.rand.nextDouble() - 0.5) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height - 0.25, this.posZ + (this.rand.nextDouble() - 0.5) * (double)this.width, (this.rand.nextDouble() - 0.5) * 2.0, -this.rand.nextDouble(), (this.rand.nextDouble() - 0.5) * 2.0);
                        }
                    }
                }
            } else {
                this.playerPresence = true;
            }
        }
    }

    protected Entity findPlayerToAttack() {
        EntityPlayer entityplayer = this.worldObj.getClosestPlayerToEntity((Entity)this, 16.0);
        if (entityplayer != null && this.canEntityBeSeen((Entity)entityplayer) && this.worldObj.difficultySetting != net.minecraft.world.EnumDifficulty.PEACEFUL) {
            return entityplayer;
        }
        return null;
    }

    public boolean attackEntityFrom(DamageSource damagesource, int i) {
        if (!this.playerPresence && this.worldObj.difficultySetting != net.minecraft.world.EnumDifficulty.PEACEFUL) {
            if (super.attackEntityFrom(damagesource, (float)i)) {
                Entity entity = damagesource.getSourceOfDamage();
                if (this.riddenByEntity == entity || this.ridingEntity == entity) {
                    return true;
                }
                if (entity != this) {
                    this.entityToAttack = entity;
                }
                return true;
            }
            return false;
        }
        return true;
    }
}

