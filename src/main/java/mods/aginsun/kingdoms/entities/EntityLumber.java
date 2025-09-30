package mods.aginsun.kingdoms.entities;

import cpw.mods.fml.common.FMLCommonHandler;
import mods.aginsun.kingdoms.client.guis.GuiLumber;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;
import mods.aginsun.kingdoms.util.ChatMessage;

public class EntityLumber
extends EntityCreature {
    private World worldObj = FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(0);

    public EntityLumber(World world) {
        super(world);
        this.worldObj = world;
        this.isImmuneToFire = false;
    }

    protected boolean canDespawn() {
        return false;
    }

    public boolean canInteractWith(EntityPlayer entityplayer) {
        if (this.isDead) {
            return false;
        }
        return entityplayer.getDistanceSqToEntity((Entity)this) <= 64.0;
    }

    public boolean canBePushed() {
        return false;
    }

    protected boolean isMovementCeased() {
        return true;
    }

    public boolean interact(EntityPlayer entityplayer) {
        if (this.canInteractWith(entityplayer)) {
            this.heal(100.0f);
            Minecraft minecraft = ModLoader.getMinecraftInstance();
            if (!this.worldObj.isRemote) {
                ChatMessage.add(entityplayer,"Foreman: Do you need resources sir?");
            }
            minecraft.displayGuiScreen((GuiScreen)new GuiLumber(entityplayer, this.worldObj));
        }
        return true;
    }
}

