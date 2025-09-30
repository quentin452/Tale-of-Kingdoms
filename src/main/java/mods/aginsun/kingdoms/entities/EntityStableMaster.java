
package mods.aginsun.kingdoms.entities;

import mods.aginsun.kingdoms.client.guis.GuiStableMaster;
import mods.aginsun.kingdoms.entities.EntityNPC;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.world.World;

public class EntityStableMaster
extends EntityNPC {
    public EntityStableMaster(World par1World) {
        super(par1World, new ItemStack(Items.lead), 40.0f);
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
            Minecraft.getMinecraft().displayGuiScreen((GuiScreen)new GuiStableMaster());
        }
        return true;
    }
}

