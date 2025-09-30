
package mods.aginsun.kingdoms.core;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import mods.aginsun.kingdoms.client.guis.GuiSell;
import mods.aginsun.kingdoms.entities.TileEntitySell;
import mods.aginsun.kingdoms.handlers.CommonTickHandler;
import mods.aginsun.kingdoms.handlers.GoldKeeper;
import mods.aginsun.kingdoms.inventory.ContainerSell;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class CommonProxy
implements IGuiHandler {
    public GoldKeeper gold;

    public void registerRenderers() {
    }

    public void Init() {
        TickRegistry.registerTickHandler((ITickHandler)new CommonTickHandler(), (Side)Side.SERVER);
    }

    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        if (id == 1) {
            return new ContainerSell(new TileEntitySell(), player.inventory);
        }
        return null;
    }

    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        if (id == 1) {
            return new GuiSell(player.inventory, new TileEntitySell());
        }
        return null;
    }

    public World getClientWorld() {
        return null;
    }
}

