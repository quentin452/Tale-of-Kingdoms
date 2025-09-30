
package mods.aginsun.kingdoms.entities;

import java.util.List;
import java.util.Random;
import mods.aginsun.kingdoms.entities.EntityNPC;
import mods.aginsun.kingdoms.entities.EntityReficulGuardian;
import mods.aginsun.kingdoms.entities.EntityReficulMage;
import mods.aginsun.kingdoms.entities.EntityReficulSoldier;
import mods.aginsun.kingdoms.util.UtilToK;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.potion.Potion;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import mods.aginsun.kingdoms.util.ChatMessage;

public class EntityGuildMaster
extends EntityNPC {
    private World worldObj;
    private EntityPlayer player;
    private int talk;
    private int counterHeal;
    boolean get;
    boolean said;
    public boolean isSwinging;
    public int swingProgressInt;
    protected int attackStrength;

    public EntityGuildMaster(World world) {
        super(world, new ItemStack(Items.iron_sword, 1), 100.0f);
        this.rand = new Random();
        this.talk = 0;
        this.counterHeal = 0;
        this.get = true;
        this.said = false;
        this.worldObj = world;
        this.isImmuneToFire = true;
        this.attackStrength = 10;
    }

    @Override
    public boolean canBePushed() {
        return false;
    }

    public boolean interact(EntityPlayer entityplayer) {
        this.player = entityplayer;
        boolean flag = false;
        if (!this.worldObj.loadedEntityList.isEmpty()) {
            for (int i = 0; i < this.worldObj.loadedEntityList.size(); ++i) {
                Entity entity = (Entity)this.worldObj.loadedEntityList.get(i);
                if (entity instanceof EntityReficulGuardian && entity.getDistanceSqToEntity((Entity)this) <= 2000.0) {
                    flag = true;
                }
                if (entity instanceof EntityReficulMage && entity.getDistanceSqToEntity((Entity)this) <= 2000.0) {
                    flag = true;
                }
                if (!(entity instanceof EntityReficulSoldier) || !(entity.getDistanceSqToEntity((Entity)this) <= 2000.0)) continue;
                flag = true;
            }
        }
        int j = this.worldObj.getWorldInfo().getSpawnX() + 30;
        int k = this.worldObj.getWorldInfo().getSpawnY();
        int l = this.worldObj.getWorldInfo().getSpawnZ() + 40;
        int i1 = (int)this.posX;
        int j1 = (int)this.posY;
        int k1 = (int)this.posZ;
        if (this.get) {
            if (j - 50 < i1 && j + 50 > i1 && k - 50 < j1 && k + 50 > j1 && l - 50 < k1 && l + 50 > k1) {
                if (flag && !UtilToK.guildFightEnded) {
                    if (this.talk == 0) {
                        if (!this.worldObj.isRemote) {
                            ChatMessage.add(this.player,"Guild Master: My apprentice! The guild is under attack, and I came here to ask for your help. Please let us hurry back to the guild!");
                        }
                        ItemStack itemstack = new ItemStack(267, 1, 0);
                        EntityItem entityitem = new EntityItem(this.worldObj, this.player.posX, this.player.posY, this.player.posZ, itemstack);
                        this.player.joinEntityItemWithWorld(entityitem);
                    } else if (this.talk > 2 && this.talk < 5 && !this.worldObj.isRemote) {
                        ChatMessage.add(this.player,"Master: Keep close and I will heal you.");
                    } else if (!this.worldObj.isRemote) {
                        ChatMessage.add(this.player,"Master: Lets take this bastards down. There are still some left.");
                    }
                    ++this.talk;
                } else {
                    this.get = true;
                    InventoryPlayer inventoryplayer = entityplayer.inventory;
                    if (inventoryplayer.hasItem(17)) {
                        for (int i2 = 0; i2 < inventoryplayer.mainInventory.length; ++i2) {
                            ItemStack itemstack1;
                            if (inventoryplayer.mainInventory[i2] == null || inventoryplayer.mainInventory[i2].itemID != 17 || itemstack1.stackSize != (itemstack1 = inventoryplayer.getStackInSlot(i2)).getMaxStackSize() || !this.get) continue;
                            this.get = false;
                            inventoryplayer.setInventorySlotContents(i2, null);
                        }
                    }
                    if (!this.get && !this.worldObj.isRemote) {
                        ChatMessage.add(this.player,"Master: We have now supplies to build the guild. Talk to me again if you want to repair the guild.");
                    } else if (!this.worldObj.isRemote) {
                        ChatMessage.add(this.player,"Master: We did the best we could. Now, we should rebuild the guild and gather 64 wood while the rest do some cleanup and construction.");
                    }
                }
            } else if (!this.worldObj.isRemote) {
                ChatMessage.add(this.player,"Master: We are too far from the guild!");
            }
        } else {
            if (!this.worldObj.isRemote) {
                ChatMessage.add(this.player,"Master: Thank you hero, you have proven yourself a worthy leader but your quest for kingship is not over. I will be back at the guild and may you continue this good progress.");
            }
            UtilToK.guildFightEnded = true;
            this.setDead();
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
            if (!(this.counterHeal != 5 || UtilToK.guildFightEnded || this.said || this.worldObj.isRemote)) {
                ChatMessage.add(this.player,"Guild Master: My apprentice! The guild is under attack and I came here to ask for your help. Please let us hurry back to the guild!");
                this.said = true;
            }
            if (this.counterHeal > 30) {
                this.player.heal(2.0f);
                this.counterHeal = 0;
            }
            ++this.counterHeal;
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

    protected void attackEntity(Entity entity, float f) {
        if (new ItemStack((Item)Item.swordIron, (int)1).itemID == 267 && this.attackTime <= 0 && f < 2.0f && entity.boundingBox.maxY > this.boundingBox.minY && entity.boundingBox.minY < this.boundingBox.maxY) {
            this.swingItem();
            this.attackTime = 20;
            this.attackEntityAsMob(entity);
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

    public boolean attackEntityFrom(DamageSource damagesource, int i) {
        return true;
    }

    public void swingItem() {
        if (!this.isSwinging || this.swingProgressInt < 0) {
            this.swingProgressInt = -1;
            this.isSwinging = true;
        }
    }
}

