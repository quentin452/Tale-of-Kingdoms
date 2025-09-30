
package mods.aginsun.kingdoms.entities;

import mods.aginsun.kingdoms.client.guis.GuiBank;
import mods.aginsun.kingdoms.entities.EntityNPC;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;
import mods.aginsun.kingdoms.util.ChatMessage;

public class EntityBankerKeeper
extends EntityNPC {
    public EntityBankerKeeper(World world) {
        super(world, null, 40.0f);
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
                ChatMessage.add(entityplayer,"Banker: I will keep your gold safe.");
            }
            minecraft.displayGuiScreen((GuiScreen)new GuiBank(entityplayer, this.world));
        }
        return true;
    }
}

