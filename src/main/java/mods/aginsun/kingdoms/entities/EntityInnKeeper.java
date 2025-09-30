
package mods.aginsun.kingdoms.entities;

import mods.aginsun.kingdoms.client.guis.GuiInnMenu;
import mods.aginsun.kingdoms.entities.EntityNPC;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import mods.aginsun.kingdoms.util.ChatMessage;

public class EntityInnKeeper
extends EntityNPC {
    private World worldObj;

    public EntityInnKeeper(World world) {
        super(world, null, 100.0f);
        this.worldObj = world;
        this.isImmuneToFire = false;
    }

    @Override
    public boolean canBePushed() {
        return false;
    }

    public boolean interact(EntityPlayer entityplayer) {
        if (!this.worldObj.isRemote) {
            ChatMessage.add(entityplayer,"House Keeper: Would you like to take a rest sir?");
        }
        if (this.canInteractWith(entityplayer)) {
            Minecraft minecraft = Minecraft.getMinecraft();
            minecraft.displayGuiScreen((GuiScreen)new GuiInnMenu(entityplayer, this.worldObj));
        }
        return true;
    }
}

