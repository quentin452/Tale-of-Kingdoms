
package mods.aginsun.kingdoms.entities;

import mods.aginsun.kingdoms.client.guis.GuiWardenMenu;
import mods.aginsun.kingdoms.entities.EntityNPC;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import mods.aginsun.kingdoms.util.ChatMessage;

public class EntityBarracksKeeper
extends EntityNPC {
    private static ItemStack defaultHeldItem = new ItemStack(Items.iron_sword, 1);

    public EntityBarracksKeeper(World world) {
        super(world, defaultHeldItem, 20.0f);
    }

    @Override
    public boolean canBePushed() {
        return false;
    }

    public boolean interact(EntityPlayer entityplayer) {
        if (!this.worldObj.isRemote) {
            ChatMessage.add(entityplayer,"Warden: The guild's warden at your service.");
        }
        if (this.canInteractWith(entityplayer)) {
            Minecraft.getMinecraft().displayGuiScreen((GuiScreen)new GuiWardenMenu(entityplayer, this.worldObj));
        }
        return true;
    }
}

