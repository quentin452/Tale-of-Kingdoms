
package mods.aginsun.kingdoms.entities;

import java.util.List;
import mods.aginsun.kingdoms.client.guis.GuiWorker;
import mods.aginsun.kingdoms.entities.EntityMarkerKeeper;
import mods.aginsun.kingdoms.entities.EntityNPC;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.init.Blocks;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import mods.aginsun.kingdoms.util.ChatMessage;

public class EntityWorkerMember
extends EntityNPC {
    private World worldObj;
    private EntityPlayer player;
    public static ItemStack defaultHeldItem;
    private boolean markerExist;
    public boolean follow;
    private int hit3;
    public int worktype;
    public boolean freeze;
    public boolean isMining;
    public Entity marker2;
    public boolean isSwinging;
    public int swingProgressInt;

    public EntityWorkerMember(World world) {
        super(world, defaultHeldItem, 30.0f);
        defaultHeldItem = null;
        this.markerExist = false;
        this.follow = true;
        this.hit3 = 0;
        this.worktype = 0;
        this.freeze = false;
        this.isMining = false;
        this.marker2 = null;
        this.worldObj = world;
        this.isImmuneToFire = false;
        Minecraft minecraft = Minecraft.getMinecraft();
        this.player = minecraft.thePlayer;
    }

    @Override
    protected boolean isMovementCeased() {
        return this.freeze;
    }

    public boolean interact(EntityPlayer entityplayer) {
        boolean flag = false;
        if (this.worktype == 0) {
            Minecraft minecraft = Minecraft.getMinecraft();
            minecraft.displayGuiScreen((GuiScreen)new GuiWorker(entityplayer, this.worldObj, this));
        }
        if (!this.worldObj.loadedEntityList.isEmpty()) {
            for (int i = 0; i < this.worldObj.loadedEntityList.size(); ++i) {
                Entity entity = (Entity)this.worldObj.loadedEntityList.get(i);
                if (!(entity instanceof EntityMarkerKeeper)) continue;
                Entity entity1 = entity;
                entity1.setDead();
            }
        }
        this.freeze = false;
        if (this.isMining) {
            this.isMining = false;
        }
        if (this.worktype == 1) {
            int j = (int)this.posY;
            if (this.follow) {
                int k = (int)this.posX - 5;
                while ((double)k < this.posX + 5.0) {
                    for (int l = 0; l < 10; ++l) {
                        int i1 = (int)this.posZ - 5;
                        while ((double)i1 < this.posZ + 5.0) {
                            if (this.worldObj.getBlock(k, j, i1) == Blocks.log && !flag) {
                                for (int j1 = k - 5; j1 <= k + 5; ++j1) {
                                    for (int k1 = j - 5; k1 <= j + 5; ++k1) {
                                        for (int l1 = i1 - 5; l1 <= i1 + 5; ++l1) {
                                            if (this.worldObj.getBlock(j1, k1, l1) != Blocks.leaves) continue;
                                            this.worldObj.setBlock(j1, k1, l1, Blocks.air);
                                        }
                                    }
                                }
                                Entity entity2 = EntityList.createEntityByName((String)"Marker", (World)this.worldObj);
                                entity2.setLocationAndAngles((double)k, (double)j, (double)i1, 0.0f, 0.0f);
                                if (!this.worldObj.isRemote) {
                                    this.worldObj.spawnEntityInWorld(entity2);
                                }
                                System.out.println("newMarker");
                                flag = true;
                                this.markerExist = true;
                            } else {
                                this.markerExist = false;
                            }
                            ++i1;
                        }
                    }
                    ++k;
                }
            }
            if (this.follow && flag && this.worktype == 1 && !this.worldObj.isRemote) {
                ChatMessage.add(this.player,"Worker: Chopping it down sir!");
            }
            if (this.follow && !flag && this.worktype == 1 && !this.worldObj.isRemote) {
                ChatMessage.add(this.player,"Worker: Direct me to a tree and I will start cutting!");
            }
            this.player = entityplayer;
        }
        if (this.worktype == 2 && !this.isMining) {
            if (this.posY < 50.0 && !this.worldObj.isRemote) {
                ChatMessage.add(this.player,"Worker: Mining the stone sir!");
                this.createMine();
                this.isMining = true;
            } else if (!this.worldObj.isRemote) {
                ChatMessage.add(this.player,"Worker: We must go further underground sir!");
            }
        }
        this.player = entityplayer;
        return true;
    }

    protected void jump() {
        if (this.follow && !this.freeze) {
            this.motionY = 0.42f;
            if (this.isSprinting()) {
                float f = this.rotationYaw * 0.01745329f;
                this.motionX -= (double)(MathHelper.sin((float)f) * 0.2f);
                this.motionZ += (double)(MathHelper.cos((float)f) * 0.2f);
            }
            this.isAirBorne = true;
        }
    }

    public void swingItem() {
        if (!this.isSwinging || this.swingProgressInt < 0) {
            this.swingProgressInt = -1;
            this.isSwinging = true;
        }
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
        if (this.worktype == 1) {
            List list = this.worldObj.getEntitiesWithinAABB(EntityMarkerKeeper.class, AxisAlignedBB.getBoundingBox((double)this.posX, (double)this.posY, (double)this.posZ, (double)(this.posX + 1.0), (double)(this.posY + 1.0), (double)(this.posZ + 1.0)).expand(16.0, 16.0, 16.0));
            if (!list.isEmpty()) {
                Entity entity1;
                this.entityToAttack = entity1 = (Entity)list.get(this.worldObj.rand.nextInt(list.size()));
            } else {
                this.follow = true;
            }
            for (int j = (int)this.posX - 3; j <= 3; ++j) {
                for (int k = (int)this.posY - 3; k <= 3; ++k) {
                    for (int l = (int)this.posZ - 3; l <= 3; ++l) {
                        if (this.worldObj.getBlock(j, k, l) != Blocks.leaves) continue;
                        this.worldObj.setBlock(j, k, l, Blocks.air);
                    }
                }
            }
        }
        if (this.follow && this.worktype == 2 && this.marker2 != null) {
            Entity entity;
            this.entityToAttack = entity = this.marker2;
        }
        if (this.entityToAttack != null) {
            float f = this.entityToAttack.getDistanceToEntity((Entity)this);
            if (this.entityToAttack.isEntityAlive()) {
                this.attackEntity(this.entityToAttack, f);
            }
            this.faceEntity(this.entityToAttack, 30.0f, 30.0f);
        }
    }

    protected void attackEntity(Entity entity, float f) {
        Entity obj = entity instanceof EntityMarkerKeeper ? (EntityMarkerKeeper)entity : entity;
        if (this.attackTime <= 0 && f < 2.0f && obj.boundingBox.maxY + 20.0 > this.boundingBox.minY && obj.boundingBox.minY < this.boundingBox.maxY + 20.0 && this.worktype == 1) {
            this.attackTime = 20;
            this.swingItem();
            this.follow = false;
        }
        if (this.attackTime <= 0 && f < 2.0f && obj.boundingBox.maxY > this.boundingBox.minY && obj.boundingBox.minY < this.boundingBox.maxY && this.worktype == 2) {
            this.attackTime = 20;
            this.swingItem();
            this.freeze = true;
            if (this.player != null && this.player.getDistanceSqToEntity((Entity)this) <= 3000.0 && this.hit3 > 8) {
                ItemStack itemstack = new ItemStack(Item.getItemFromBlock(Blocks.cobblestone), 1, 0);
                EntityItem entityitem = new EntityItem(this.worldObj, this.player.posX, this.player.posY, this.player.posZ, itemstack);
                this.player.joinEntityItemWithWorld(entityitem);
                this.hit3 = 0;
            }
            ++this.hit3;
        }
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.follow && !this.markerExist && this.player != null) {
            float f = this.player.getDistanceToEntity((Entity)this);
            PathEntity pathentity = f > 5.0f && f < 18.0f ? this.worldObj.getPathEntityToEntity((Entity)this, (Entity)this.player, 16.0f, true, false, false, true) : null;
            this.setPathToEntity(pathentity);
        }
    }

    public boolean attackEntityFrom(DamageSource damagesource, int i) {
        Entity entity = damagesource.getSourceOfDamage();
        if (entity instanceof EntityPlayer || entity instanceof EntityPlayerSP) {
            defaultHeldItem = null;
            this.follow = false;
            this.worktype = 0;
            Minecraft minecraft = Minecraft.getMinecraft();
            minecraft.displayGuiScreen((GuiScreen)new GuiWorker((EntityPlayer)entity, this.worldObj, this));
        }
        return true;
    }

    private void createMine() {
        int i = (int)this.posX + 1;
        int j = (int)this.posY;
        int k = (int)this.posZ - 3;
        for (int l = 0; l < 5; ++l) {
            for (int j1 = 0; j1 < 3; ++j1) {
                for (int l1 = 1; l1 < 5; ++l1) {
                    this.worldObj.setBlock(i + l, j + j1, k + l1, Blocks.air);
                }
            }
        }
        for (int i1 = 1; i1 < 5; ++i1) {
            for (int k1 = 1; k1 < 7; ++k1) {
                this.worldObj.setBlock(i + i1, j - 2, k + k1, Blocks.stone);
                this.worldObj.setBlock(i + i1, j - 1, k + k1, Blocks.gravel);
            }
        }
        this.worldObj.setBlock(i + 1, j + 0, k + 1, Blocks.stone);
        this.worldObj.setBlock(i + 1, j + 0, k + 2, Blocks.fence);
        this.worldObj.setBlock(i + 1, j + 0, k + 5, Blocks.fence);
        this.worldObj.setBlock(i + 1, j + 0, k + 6, Blocks.cobblestone);
        this.worldObj.setBlock(i + 1, j + 1, k + 1, Blocks.cobblestone);
        this.worldObj.setBlock(i + 1, j + 1, k + 2, Blocks.fence);
        this.worldObj.setBlock(i + 1, j + 1, k + 5, Blocks.fence);
        this.worldObj.setBlock(i + 1, j + 1, k + 6, Blocks.stone);
        this.worldObj.setBlock(i + 1, j + 2, k + 1, Blocks.stone);
        this.worldObj.setBlock(i + 1, j + 2, k + 2, Blocks.planks);
        this.worldObj.setBlock(i + 1, j + 2, k + 3, Blocks.planks);
        this.worldObj.setBlock(i + 1, j + 2, k + 4, Blocks.planks);
        this.worldObj.setBlock(i + 1, j + 2, k + 5, Blocks.planks);
        this.worldObj.setBlock(i + 1, j + 2, k + 6, Blocks.stone);
        this.worldObj.setBlock(i + 1, j + 3, k + 2, Blocks.cobblestone);
        this.worldObj.setBlock(i + 1, j + 3, k + 3, Blocks.cobblestone);
        this.worldObj.setBlock(i + 1, j + 3, k + 4, Blocks.stone);
        this.worldObj.setBlock(i + 1, j + 3, k + 5, Blocks.cobblestone);
        this.worldObj.setBlock(i + 2, j + 0, k + 1, Blocks.cobblestone);
        this.worldObj.setBlock(i + 2, j + 0, k + 2, Blocks.crafting_table);
        this.worldObj.setBlock(i + 2, j + 0, k + 6, Blocks.cobblestone);
        this.worldObj.setBlock(i + 2, j + 1, k + 1, Blocks.stone);
        this.worldObj.setBlock(i + 2, j + 1, k + 6, Blocks.stone);
        this.worldObj.setBlock(i + 2, j + 2, k + 1, Blocks.cobblestone);
        this.worldObj.setBlock(i + 2, j + 2, k + 6, Blocks.cobblestone);
        this.worldObj.setBlock(i + 2, j + 3, k + 2, Blocks.cobblestone);
        this.worldObj.setBlock(i + 2, j + 3, k + 3, Blocks.stone);
        this.worldObj.setBlock(i + 2, j + 3, k + 4, Blocks.cobblestone);
        this.worldObj.setBlock(i + 2, j + 3, k + 5, Blocks.cobblestone);
        this.worldObj.setBlock(i + 3, j + 0, k + 1, Blocks.stone);
        this.worldObj.setBlock(i + 3, j + 0, k + 5, Blocks.cobblestone);
        this.worldObj.setBlock(i + 3, j + 0, k + 6, Blocks.stone);
        this.worldObj.setBlock(i + 3, j + 1, k + 1, Blocks.cobblestone);
        this.worldObj.setBlock(i + 3, j + 1, k + 6, Blocks.cobblestone);
        this.worldObj.setBlock(i + 3, j + 2, k + 1, Blocks.stone);
        this.worldObj.setBlock(i + 3, j + 2, k + 6, Blocks.stone);
        this.worldObj.setBlock(i + 3, j + 3, k + 2, Blocks.stone);
        this.worldObj.setBlock(i + 3, j + 3, k + 3, Blocks.cobblestone);
        this.worldObj.setBlock(i + 3, j + 3, k + 4, Blocks.cobblestone);
        this.worldObj.setBlock(i + 3, j + 3, k + 5, Blocks.stone);
        this.worldObj.setBlock(i + 4, j + 0, k + 1, Blocks.stone);
        this.worldObj.setBlock(i + 4, j + 0, k + 2, Blocks.cobblestone);
        this.worldObj.setBlock(i + 4, j + 0, k + 6, Blocks.stone);
        this.worldObj.setBlock(i + 4, j + 1, k + 1, Blocks.cobblestone);
        this.worldObj.setBlock(i + 4, j + 1, k + 6, Blocks.stone);
        this.worldObj.setBlock(i + 4, j + 2, k + 1, Blocks.stone);
        this.worldObj.setBlock(i + 4, j + 2, k + 6, Blocks.cobblestone);
        this.worldObj.setBlock(i + 4, j + 3, k + 2, Blocks.stone);
        this.worldObj.setBlock(i + 4, j + 3, k + 3, Blocks.stone);
        this.worldObj.setBlock(i + 4, j + 3, k + 4, Blocks.cobblestone);
        this.worldObj.setBlock(i + 4, j + 3, k + 5, Blocks.stone);
        this.worldObj.setBlockMetadataWithNotify(i + 3, j + 2, k + 2, 50, 3);
        this.marker2 = EntityList.createEntityByName((String)"Marker2", (World)this.worldObj);
        this.marker2.setLocationAndAngles((double)(i + 4), (double)(j + 1), (double)(k + 3), 0.0f, 0.0f);
        if (!this.worldObj.isRemote) {
            this.worldObj.spawnEntityInWorld(this.marker2);
        }
    }
}

