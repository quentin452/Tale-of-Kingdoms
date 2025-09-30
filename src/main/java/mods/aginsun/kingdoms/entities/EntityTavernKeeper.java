
package mods.aginsun.kingdoms.entities;

import mods.aginsun.kingdoms.client.guis.GuiTavernGame;
import mods.aginsun.kingdoms.entities.EntityNPC;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import mods.aginsun.kingdoms.util.ChatMessage;

public class EntityTavernKeeper
extends EntityNPC {
    private World worldObj;

    public EntityTavernKeeper(World world) {
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
        if (!this.worldObj.isRemote) {
            ChatMessage.add(entityplayer,"One-Eyed Gambler: Feeling a bit lucky eh?");
        }
        if (this.canInteractWith(entityplayer)) {
            Minecraft minecraft = Minecraft.getMinecraft();
            minecraft.displayGuiScreen((GuiScreen)new GuiTavernGame(entityplayer, this.worldObj));
        }
        return true;
    }
}

