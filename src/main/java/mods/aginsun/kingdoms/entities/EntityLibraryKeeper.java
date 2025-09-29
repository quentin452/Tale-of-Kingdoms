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

import mods.aginsun.kingdoms.client.guis.GuiLibrary;
import mods.aginsun.kingdoms.entities.EntityNPC;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;
import mods.aginsun.kingdoms.util.ChatMessage;

public class EntityLibraryKeeper
extends EntityNPC {
    private World worldObj;
    public boolean studied = true;
    private int counter = 0;

    public EntityLibraryKeeper(World world) {
        super(world, null, 100.0f);
        this.worldObj = world;
        this.isImmuneToFire = false;
    }

    @Override
    public boolean canBePushed() {
        return false;
    }

    protected void updateEntityActionState() {
        super.updateEntityActionState();
        if (this.counter > 10000) {
            this.studied = true;
            this.counter = 0;
        }
        ++this.counter;
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
                ChatMessage.add(entityplayer,"Librarian: You picked a good day to visit the library, young one");
            }
            minecraft.displayGuiScreen((GuiScreen)new GuiLibrary(entityplayer, this.worldObj, this));
        }
        return true;
    }
}

