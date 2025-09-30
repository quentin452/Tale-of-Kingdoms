
package mods.aginsun.kingdoms.entities;

import cpw.mods.fml.common.FMLCommonHandler;
import java.util.List;
import mods.aginsun.kingdoms.entities.EntityLostVillager;
import mods.aginsun.kingdoms.entities.EntityNPC;
import mods.aginsun.kingdoms.handlers.WorthyKeeper;
import mods.aginsun.kingdoms.util.UtilToK;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import mods.aginsun.kingdoms.util.ChatMessage;

public class EntityLoneTraveller
extends EntityNPC {
    private World worldObj = FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(0);
    private static ItemStack defaultHeldItem = new ItemStack(Items.iron_sword, 1);

    public EntityLoneTraveller(World world) {
        super(world, defaultHeldItem, 20.0f);
        this.worldObj = world;
        this.isImmuneToFire = true;
    }

    @Override
    protected boolean isMovementCeased() {
        return true;
    }

    public boolean interact(EntityPlayer entityplayer) {
        boolean flag1 = false;
        List list = this.worldObj.getEntitiesWithinAABB(EntityCreature.class, AxisAlignedBB.getBoundingBox((double)this.posX, (double)this.posY, (double)this.posZ, (double)(this.posX + 1.0), (double)(this.posY + 1.0), (double)(this.posZ + 1.0)).expand(16.0, 4.0, 16.0));
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); ++i) {
                Entity entity = (Entity)list.get(i);
                if (!this.canEntityBeSeen(entity) || !(entity instanceof EntityLostVillager)) continue;
                entity.setDead();
                WorthyKeeper.getInstance().addWorthy(400.0f);
                flag1 = true;
            }
        }
        if (flag1 && !this.worldObj.isRemote) {
            ChatMessage.add(entityplayer,"Survivor: My king! Thank you for saving them! I will let the guild master know your efforts");
        } else if (!this.worldObj.isRemote) {
            ChatMessage.add(entityplayer,"Survivor: I am gravely lost, my king. I survived the attack but many of our villages burned down. There are still survivors left, hurry and rescue them!");
            ChatMessage.add(entityplayer,"Guild Master: Your quest has started, find the village and save them!");
        }
        UtilToK.burningVillages = 1;
        return true;
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
    }
}

