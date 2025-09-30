
package mods.aginsun.kingdoms.entities;

import java.util.Random;
import mods.aginsun.kingdoms.entities.EntityNPC;
import mods.aginsun.kingdoms.handlers.WorthyKeeper;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityReficulGuardian
extends EntityNPC {
    private static ItemStack defaultHeldItem = new ItemStack((Item)Item.bow, 1);
    private EntityPlayer player;
    private boolean playerPresence = true;
    private Random rand = new Random();
    private World worldObj;
    protected int attackStrength;

    public EntityReficulGuardian(World world) {
        super(world, defaultHeldItem, 30.0f);
        this.worldObj = world;
        this.attackStrength = 7;
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
                    int i1 = this.worldObj.getBlockId(i, j - 1, k);
                    if (i1 == 0 || !Block.blocksList[i1].blockMaterial.isSolid()) {
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

    public void onDeath(DamageSource damagesource) {
        WorthyKeeper.getInstance().addWorthy(70.0f);
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
                if (this.rand.nextInt(8) != 0) {
                    this.worldObj.spawnEntityInWorld((Entity)entityarrow);
                    entityarrow.setThrowableHeading(d, d2 + (double)f1, d1, 1.6f, 12.0f);
                }
                this.attackTime = 30;
            }
            this.rotationYaw = (float)(Math.atan2(d1, d) * 180.0 / 3.1415927410125732) - 90.0f;
            this.hasAttacked = true;
        }
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

    protected void updateEntityActionState() {
        super.updateEntityActionState();
        for (int i = 0; i < this.worldObj.loadedEntityList.size(); ++i) {
            Entity entity = (Entity)this.worldObj.loadedEntityList.get(i);
            if (!(entity instanceof EntityPlayer)) continue;
            this.player = (EntityPlayer)entity;
        }
        if (this.player != null) {
            if (this.player.getDistanceSqToEntity((Entity)this) <= 220.0 && this.worldObj.difficultySetting != 0) {
                this.playerPresence = false;
                if (this.rand.nextInt(6) == 0) {
                    this.teleportToEntity((Entity)this.player);
                    if (this.rand.nextInt(10) == 0) {
                        for (int j = 0; j < 2; ++j) {
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
        if (entityplayer != null && this.canEntityBeSeen((Entity)entityplayer) && this.worldObj.difficultySetting != 0) {
            return entityplayer;
        }
        return null;
    }

    public boolean attackEntityFrom(DamageSource damagesource, int i) {
        if (!this.playerPresence && this.worldObj.difficultySetting != 0) {
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

