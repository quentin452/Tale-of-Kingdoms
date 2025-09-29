/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.src.ModLoader
 *  net.minecraft.world.World
 */
package mods.aginsun.kingdoms.entities;

import mods.aginsun.kingdoms.client.guis.GuiHunter;
import mods.aginsun.kingdoms.entities.EntityNPC;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;
import mods.aginsun.kingdoms.util.ChatMessage;

public class EntityHunterKeeper
extends EntityNPC {
    private World worldObj;

    public EntityHunterKeeper(World world) {
        super(world, null, 100.0f);
        this.worldObj = world;
        this.isImmuneToFire = false;
    }

    @Override
    public boolean canBePushed() {
        return false;
    }

    @Override
    protected boolean isMovementCeased() {
        return true;
    }

    public boolean interact(EntityPlayer entityplayer) {
        if (this.canInteractWith(entityplayer)) {
            this.heal(100.0f);
            Minecraft minecraft = ModLoader.getMinecraftInstance();
            if (!this.worldObj.isRemote) {
                ChatMessage.add(entityplayer,"Guild Master: Welcome to the order, hero.");
            }
            minecraft.displayGuiScreen((GuiScreen)new GuiHunter(entityplayer, this.worldObj));
        }
        return true;
    }
}

