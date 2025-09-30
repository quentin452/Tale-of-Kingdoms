
package mods.aginsun.kingdoms.entities;

import cpw.mods.fml.common.FMLCommonHandler;
import java.util.List;
import java.util.Random;
import mods.aginsun.kingdoms.entities.EntityNPC;
import mods.aginsun.kingdoms.entities.EntityReficulGuardian;
import mods.aginsun.kingdoms.entities.EntityReficulMage;
import mods.aginsun.kingdoms.entities.EntityReficulSoldier;
import mods.aginsun.kingdoms.handlers.WorthyKeeper;
import mods.aginsun.kingdoms.util.UtilToK;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.potion.Potion;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import mods.aginsun.kingdoms.util.ChatMessage;

public class EntityGuildMember
extends EntityNPC {
    private World worldObj = FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(0);
    private EntityPlayer player;
    private static ItemStack defaultHeldItem = new ItemStack(Items.iron_sword, 1);
    private boolean fight = false;
    private int counter = 0;
    public boolean isSwinging;
    public int swingProgressInt;
    protected int attackStrength;

    public EntityGuildMember(World world) {
        super(world, defaultHeldItem, 40.0f);
        this.worldObj = world;
        this.isImmuneToFire = true;
        this.attackStrength = 15;
    }

    @Override
    public boolean canBePushed() {
        return false;
    }

    public boolean interact(EntityPlayer entityplayer) {
        this.player = entityplayer;
        if (UtilToK.guildFightEnded) {
            ItemStack itemstack = entityplayer.inventory.getCurrentItem();
            if (itemstack != null) {
                if (itemstack.getItem() == net.minecraft.init.Items.wooden_sword) {
                    defaultHeldItem = new ItemStack(net.minecraft.init.Items.wooden_sword, 1);
                    entityplayer.inventory.setInventorySlotContents(entityplayer.inventory.currentItem, null);
                    if (!this.worldObj.isRemote) {
                        ChatMessage.add(entityplayer,"Guild Member: Get Ready.");
                    }
                    this.fight = true;
                } else if (!this.worldObj.isRemote) {
                    ChatMessage.add(entityplayer,"Guild Member: Greetings. You seem like a tough fighter. Give me a wooden sword and lets have a sparing match!");
                }
            } else if (!this.worldObj.isRemote) {
                ChatMessage.add(entityplayer,"Guild Member: Greetings. You seem like a tough fighter. Give me a wooden sword and lets have a sparing match!");
            }
        } else if (!this.worldObj.isRemote) {
            ChatMessage.add(entityplayer,"Guild Member: Damn this Reficules");
        }
        return true;
    }

    public void onDeath(DamageSource damagesource) {
        if (this.fight) {
            WorthyKeeper.getInstance().addWorthy(50.0f);
            if (this.player != null && !this.worldObj.isRemote) {
                ChatMessage.add(this.player,"Guild Member: Your a good fighter my friend, I will let the guild master know of your strength.");
            }
        }
    }

    protected void updateEntityActionState() {
        List list;
        super.updateEntityActionState();
        if (this.fight) {
            ++this.counter;
            if (this.counter == 10 && !this.worldObj.isRemote) {
                ChatMessage.add(this.player,"Guild Member: 3");
            }
            if (this.counter == 20 && !this.worldObj.isRemote) {
                ChatMessage.add(this.player,"Guild Member: 2");
            }
            if (this.counter == 30 && !this.worldObj.isRemote) {
                ChatMessage.add(this.player,"Guild Member: 1");
            }
            if (this.counter == 40 && !this.worldObj.isRemote) {
                ChatMessage.add(this.player,"Guild Member: Begin!");
                this.entityToAttack = this.player;
            }
        }
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
        if (this.entityToAttack == null && !this.hasPath() && !(list = this.worldObj.getEntitiesWithinAABB(EntityCreature.class, AxisAlignedBB.getBoundingBox((double)this.posX, (double)this.posY, (double)this.posZ, (double)(this.posX + 1.0), (double)(this.posY + 1.0), (double)(this.posZ + 1.0)).expand(20.0, 4.0, 20.0))).isEmpty()) {
            Entity entity = (Entity)list.get(this.worldObj.rand.nextInt(list.size()));
            if (entity instanceof EntityCreeper) {
                entity.setDead();
            } else if (entity instanceof EntityMob || entity instanceof EntityReficulSoldier || entity instanceof EntityReficulGuardian || entity instanceof EntityReficulMage) {
                defaultHeldItem = new ItemStack(net.minecraft.init.Items.iron_sword, 1);
                this.entityToAttack = entity;
            }
        }
    }

    protected void jump() {
        Random random = new Random();
        if (random.nextInt(15) == 0) {
            this.motionY = 0.42f;
            if (this.isSprinting()) {
                float f = this.rotationYaw * 0.01745329f;
                this.motionX -= (double)(MathHelper.sin((float)f) * 0.2f);
                this.motionZ += (double)(MathHelper.cos((float)f) * 0.2f);
            }
            this.isAirBorne = true;
        }
    }

    protected void attackEntity(Entity entity, float f) {
        if (this.attackTime <= 0 && f < 2.0f && entity.boundingBox.maxY > this.boundingBox.minY && entity.boundingBox.minY < this.boundingBox.maxY) {
            this.attackTime = 20;
            this.swingItem();
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

    public void swingItem() {
        if (!this.isSwinging || this.swingProgressInt < 0) {
            this.swingProgressInt = -1;
            this.isSwinging = true;
        }
    }
}

