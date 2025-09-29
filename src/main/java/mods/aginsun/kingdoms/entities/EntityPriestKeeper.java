/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.FMLCommonHandler
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityCreature
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.src.ModLoader
 *  net.minecraft.world.World
 */
package mods.aginsun.kingdoms.entities;

import cpw.mods.fml.common.FMLCommonHandler;
import mods.aginsun.kingdoms.client.guis.GuiPriest;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;
import mods.aginsun.kingdoms.util.ChatMessage;

public class EntityPriestKeeper
extends EntityCreature {
    private World worldObj = FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(0);

    public EntityPriestKeeper(World world) {
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

    protected void updateEntityActionState() {
        super.updateEntityActionState();
    }

    protected boolean isMovementCeased() {
        return true;
    }

    public boolean interact(EntityPlayer entityplayer) {
        if (this.canInteractWith(entityplayer)) {
            this.heal(100.0f);
            Minecraft minecraft = ModLoader.getMinecraftInstance();
            if (!this.worldObj.isRemote) {
                ChatMessage.add(entityplayer,"Head Priest: The light order gives blessing to you.");
            }
            minecraft.displayGuiScreen((GuiScreen)new GuiPriest(entityplayer, this.worldObj));
        }
        return true;
    }
}

