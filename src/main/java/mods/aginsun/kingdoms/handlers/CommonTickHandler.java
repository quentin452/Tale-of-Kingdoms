
package mods.aginsun.kingdoms.handlers;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import mods.aginsun.kingdoms.handlers.SchematicHandler;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class CommonTickHandler {
    
    @SubscribeEvent
    public void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            this.onTickInGame();
        }
    }

    public void onTickInGame() {
        WorldServer world = FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(0);
        if (world != null) {
            SchematicHandler.getInstance().update((World)world);
        }
    }
}

