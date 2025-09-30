
package mods.aginsun.kingdoms.entities;

import cpw.mods.fml.common.FMLCommonHandler;
import mods.aginsun.kingdoms.client.guis.GuiMageHall;
import mods.aginsun.kingdoms.entities.EntityNPC;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import mods.aginsun.kingdoms.util.ChatMessage;

public class EntityMageKeeper
extends EntityNPC {
    private World worldObj = FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(0);

    public EntityMageKeeper(World world) {
        super(world, new ItemStack(Items.stick), 100.0f);
        this.worldObj = world;
        this.isImmuneToFire = false;
    }

    @Override
    protected boolean canDespawn() {
        return false;
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityplayer) {
        if (this.isDead) {
            return false;
        }
        return entityplayer.getDistanceSqToEntity((Entity)this) <= 64.0;
    }

    @Override
    public boolean canBePushed() {
        return false;
    }

    protected void updateEntityActionState() {
        super.updateEntityActionState();
    }

    @Override
    protected boolean isMovementCeased() {
        return true;
    }

    public boolean interact(EntityPlayer entityplayer) {
        if (this.canInteractWith(entityplayer)) {
            this.heal(100.0f);
            Minecraft minecraft = Minecraft.getMinecraft();
            if (!this.worldObj.isRemote) {
                ChatMessage.add(entityplayer,"Head Mage: Welcome to the mage hall, hero.");
            }
            minecraft.displayGuiScreen((GuiScreen)new GuiMageHall(entityplayer, this.worldObj));
        }
        return true;
    }
}

