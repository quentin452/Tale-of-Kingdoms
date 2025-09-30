
package mods.aginsun.kingdoms.entities;

import cpw.mods.fml.common.FMLCommonHandler;
import mods.aginsun.kingdoms.client.guis.GuiBuildScreen;
import mods.aginsun.kingdoms.entities.EntityNPC;
import mods.aginsun.kingdoms.handlers.WorthyKeeper;
import mods.aginsun.kingdoms.util.Buildings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import mods.aginsun.kingdoms.util.ChatMessage;

public class EntityBuilderKeeper
extends EntityNPC {
    private boolean follow = true;
    private static ItemStack defaultHeldItem = null;

    public EntityBuilderKeeper(World world) {
        super(world, defaultHeldItem, 100.0f);
        this.isImmuneToFire = false;
        if (Buildings.kingdomCreated) {
            this.follow = true;
        }
    }

    @Override
    public boolean canBePushed() {
        return false;
    }

    @Override
    protected boolean isMovementCeased() {
        return this.follow;
    }

    public boolean interact(EntityPlayer entityplayer) {
        if (this.canInteractWith(entityplayer) && WorthyKeeper.getInstance().getWorthy() < 10000.0f && !Buildings.kingdomCreated && !this.world.isRemote) {
            ChatMessage.add(entityplayer,"City Builder: My king! You are still not worthy of creating a kingdom. The Guild Master will prepare you.");
        }
        if (!this.follow || WorthyKeeper.getInstance().getWorthy() >= 10000.0f && Buildings.kingdomCreated && !this.world.isRemote) {
            ChatMessage.add(entityplayer,"City Builder: Lets start building!");
            FMLCommonHandler.instance().showGuiScreen((Object)new GuiBuildScreen(entityplayer, this.world));
        }
        if (this.canInteractWith(entityplayer) && WorthyKeeper.getInstance().getWorthy() >= 10000.0f && this.follow && !Buildings.kingdomCreated && !this.world.isRemote) {
            ChatMessage.add(entityplayer,"City Builder: Let us build your city my liege! Lead the way!");
            this.follow = false;
        }
        return true;
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (!this.follow && !Buildings.kingdomCreated) {
            Minecraft minecraft = Minecraft.getMinecraft();
            EntityClientPlayerMP entityplayersp = minecraft.thePlayer;
            if (entityplayersp != null) {
                float f = entityplayersp.getDistanceToEntity((Entity)this);
                PathEntity pathentity = f > 5.0f && f < 18.0f ? this.world.getPathEntityToEntity((Entity)this, (Entity)entityplayersp, 16.0f, true, false, false, true) : null;
                this.setPathToEntity(pathentity);
            }
        }
    }
}

