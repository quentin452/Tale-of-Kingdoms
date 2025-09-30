
package mods.aginsun.kingdoms.entities;

import java.util.List;
import mods.aginsun.kingdoms.entities.EntityDefendArcher;
import mods.aginsun.kingdoms.entities.EntityDefendBandit;
import mods.aginsun.kingdoms.entities.EntityDefendKnight;
import mods.aginsun.kingdoms.entities.EntityDefendMage;
import mods.aginsun.kingdoms.entities.EntityDefendPaladin;
import mods.aginsun.kingdoms.entities.EntityDefendWarrior;
import mods.aginsun.kingdoms.entities.EntityHired;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.init.Blocks;

public class EntityLightningBoltAttack
extends EntityLightningBolt {
    private int lightningState;
    public long boltVertex = 0L;
    private int boltLivingTime;

    public EntityLightningBoltAttack(World world, double d, double d1, double d2) {
        super(world, d - 1000000.0, d1 - 1000000.0, d2 - 1000000.0);
        this.setLocationAndAngles(d, d1, d2, 0.0f, 0.0f);
        this.lightningState = 2;
        this.boltVertex = this.rand.nextLong();
        this.boltLivingTime = this.rand.nextInt(3) + 1;
        if (world.difficultySetting.getDifficultyId() >= 2 && world.doChunksNearChunkExist(MathHelper.floor_double((double)d), MathHelper.floor_double((double)d1), MathHelper.floor_double((double)d2), 10)) {
            int i = MathHelper.floor_double((double)d);
            int j = MathHelper.floor_double((double)d1);
            int k = MathHelper.floor_double((double)d2);
            if (world.getBlock(i, j, k) == Blocks.air) {
                // empty if block
            }
            for (int l = 0; l < 4; ++l) {
                int i1 = MathHelper.floor_double((double)d) + this.rand.nextInt(3) - 1;
                int j1 = MathHelper.floor_double((double)d1) + this.rand.nextInt(3) - 1;
                int k1 = MathHelper.floor_double((double)d2) + this.rand.nextInt(3) - 1;
                if (world.getBlock(i1, j1, k1) != Blocks.air) continue;
            }
        }
    }

    public void onUpdate() {
        if (this.lightningState == 2) {
            this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "ambient.weather.thunder", 10000.0f, 0.8f + this.rand.nextFloat() * 0.2f);
            this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "random.explode", 2.0f, 0.5f + this.rand.nextFloat() * 0.2f);
        }
        --this.lightningState;
        if (this.lightningState < 0) {
            if (this.boltLivingTime == 0) {
                this.setDead();
            } else if (this.lightningState < -this.rand.nextInt(10)) {
                --this.boltLivingTime;
                this.lightningState = 1;
                this.boltVertex = this.rand.nextLong();
                int i = MathHelper.floor_double((double)this.posX);
                int j = MathHelper.floor_double((double)this.posY);
                int k = MathHelper.floor_double((double)this.posZ);
                if (!this.worldObj.doChunksNearChunkExist(i, j, k, 10) || this.worldObj.getBlock(i, j, k) == Blocks.air) {
                    // empty if block
                }
            }
        }
        if (this.lightningState >= 0) {
            double d = 3.0;
            List<Entity> list = this.worldObj.getEntitiesWithinAABBExcludingEntity((Entity)this, AxisAlignedBB.getBoundingBox((double)(this.posX - d), (double)(this.posY - d), (double)(this.posZ - d), (double)(this.posX + d), (double)(this.posY + 6.0 + d), (double)(this.posZ + d)));
            for (int l = 0; l < list.size(); ++l) {
                boolean flag = true;
                Entity entity = list.get(l);
                if (entity instanceof EntityDefendBandit || entity instanceof EntityDefendMage || entity instanceof EntityDefendKnight || entity instanceof EntityDefendPaladin || entity instanceof EntityDefendWarrior || entity instanceof EntityDefendArcher || entity instanceof EntityHired || entity instanceof EntityPlayer || entity instanceof EntityPlayerSP) {
                    flag = false;
                }
                if (!flag) continue;
                entity.setFire(8);
            }
            this.worldObj.lastLightningBolt = 2;
        }
    }

    protected void entityInit() {
    }

    protected void readEntityFromNBT(NBTTagCompound nbttagcompound) {
    }

    protected void writeEntityToNBT(NBTTagCompound nbttagcompound) {
    }

    public boolean isInRangeToRenderVec3D(Vec3 vec3d) {
        return this.lightningState >= 0;
    }
}

