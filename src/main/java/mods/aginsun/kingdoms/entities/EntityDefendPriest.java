
package mods.aginsun.kingdoms.entities;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import java.util.List;
import mods.aginsun.kingdoms.entities.EntityDefendArcher;
import mods.aginsun.kingdoms.entities.EntityDefendBandit;
import mods.aginsun.kingdoms.entities.EntityDefendKnight;
import mods.aginsun.kingdoms.entities.EntityDefendMage;
import mods.aginsun.kingdoms.entities.EntityDefendPaladin;
import mods.aginsun.kingdoms.entities.EntityDefendWarrior;
import mods.aginsun.kingdoms.entities.EntityHired;
import mods.aginsun.kingdoms.entities.EntityNPC;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import mods.aginsun.kingdoms.util.ChatMessage;

public class EntityDefendPriest
extends EntityNPC {
    private World worldObj = FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(0);
    private EntityPlayer player;
    private static ItemStack defaultHeldItem = new ItemStack(Item.stick, 1);
    private boolean follow;
    private boolean checkPlayer;
    private int healCounter;
    private int whenHealing;
    protected int attackStrength;
    public boolean isSwinging;
    public int swingProgressInt;

    public EntityDefendPriest(World world) {
        super(world, defaultHeldItem, 40.0f);
        this.player = FMLClientHandler.instance().getClient().thePlayer;
        this.follow = false;
        this.checkPlayer = true;
        this.healCounter = 0;
        this.whenHealing = 0;
        this.worldObj = world;
        this.isImmuneToFire = false;
        this.attackStrength = 10;
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.whenHealing < 50) {
            for (int i = 0; i < 2; ++i) {
                this.worldObj.spawnParticle("heart", this.posX + (this.rand.nextDouble() - 0.5) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height - 0.25, this.posZ + (this.rand.nextDouble() - 0.5) * (double)this.width, (this.rand.nextDouble() - 0.5) * 2.0, -this.rand.nextDouble(), (this.rand.nextDouble() - 0.5) * 2.0);
            }
        }
        ++this.whenHealing;
        if (this.whenHealing > 500) {
            this.whenHealing = 100;
        }
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
                ChatMessage.add(entityplayer,"Priest: I will follow you.");
            }
        } else {
            this.follow = false;
            if (!this.worldObj.isRemote) {
                ChatMessage.add(entityplayer,"Priest: I will guard this area.");
            }
        }
        return true;
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
        boolean flag = false;
        List list = this.worldObj.getEntitiesWithinAABB(EntityLiving.class, AxisAlignedBB.getBoundingBox((double)this.posX, (double)this.posY, (double)this.posZ, (double)(this.posX + 1.0), (double)(this.posY + 1.0), (double)(this.posZ + 1.0)).expand(16.0, 4.0, 16.0));
        if (!list.isEmpty()) {
            EntityLivingBase entityliving = (EntityLivingBase)list.get(this.worldObj.rand.nextInt(list.size()));
            if (this.healCounter > 20 && (entityliving instanceof EntityDefendBandit || entityliving instanceof EntityDefendKnight || entityliving instanceof EntityDefendMage || entityliving instanceof EntityDefendPaladin || entityliving instanceof EntityDefendWarrior || entityliving instanceof EntityDefendArcher || entityliving instanceof EntityHired || entityliving instanceof EntityPlayer || entityliving instanceof EntityPlayerSP) && entityliving.getHealth() < 15.0f) {
                entityliving.heal(2.0f);
                System.out.println("heal");
                flag = true;
                this.whenHealing = 0;
            }
        }
        if (flag) {
            this.healCounter = 0;
        }
        ++this.healCounter;
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

