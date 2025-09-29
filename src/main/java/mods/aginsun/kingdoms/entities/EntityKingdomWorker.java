/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityList
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.world.World
 */
package mods.aginsun.kingdoms.entities;

import java.util.List;
import mods.aginsun.kingdoms.entities.EntityMarker2Keeper;
import mods.aginsun.kingdoms.entities.EntityNPC;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityKingdomWorker
extends EntityNPC {
    public static ItemStack defaultHeldItem = new ItemStack(Item.axeIron, 1);
    public Entity marker2 = null;
    private World worldObj;
    private int counter = 0;
    public boolean move = false;
    public boolean isSwinging;
    public int swingProgressInt;

    public EntityKingdomWorker(World world) {
        super(world, defaultHeldItem, 30.0f);
        this.worldObj = world;
        this.isImmuneToFire = false;
    }

    @Override
    protected boolean isMovementCeased() {
        return this.move;
    }

    public boolean interact(EntityPlayer entityplayer) {
        return true;
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
        if (this.worldObj.rand.nextInt(5) == 0) {
            this.swingItem();
        }
        if (this.counter > 200) {
            List list = this.worldObj.getEntitiesWithinAABB(EntityMarker2Keeper.class, AxisAlignedBB.getBoundingBox((double)this.posX, (double)this.posY, (double)this.posZ, (double)(this.posX + 1.0), (double)(this.posY + 1.0), (double)(this.posZ + 1.0)).expand(16.0, 16.0, 16.0));
            if (!list.isEmpty()) {
                this.entityToAttack = this.marker2 = (Entity)list.get(this.worldObj.rand.nextInt(list.size()));
            }
            this.counter = 0;
        } else {
            ++this.counter;
        }
    }

    public void createMarker() {
        this.marker2 = EntityList.createEntityByName((String)"Marker2", (World)this.worldObj);
        this.marker2.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
        this.worldObj.spawnEntityInWorld(this.marker2);
        defaultHeldItem = new ItemStack(Item.pickaxeIron, 1);
        System.out.println("marker");
    }
}

