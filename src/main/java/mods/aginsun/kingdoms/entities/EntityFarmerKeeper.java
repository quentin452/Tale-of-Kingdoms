
package mods.aginsun.kingdoms.entities;

import mods.aginsun.kingdoms.client.guis.GuiFoodKeeper;
import mods.aginsun.kingdoms.entities.EntityNPC;
import mods.aginsun.kingdoms.handlers.GoldKeeper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;

public class EntityFarmerKeeper
extends EntityNPC {
    private static ItemStack defaultHeldItem = new ItemStack(Item.hoeIron, 1);
    public static GoldKeeper gold;

    public EntityFarmerKeeper(World world) {
        super(world, defaultHeldItem, 100.0f);
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
        Minecraft minecraft = ModLoader.getMinecraftInstance();
        if (this.canInteractWith(entityplayer)) {
            minecraft.displayGuiScreen((GuiScreen)new GuiFoodKeeper(entityplayer, this.worldObj));
        }
        return true;
    }
}

