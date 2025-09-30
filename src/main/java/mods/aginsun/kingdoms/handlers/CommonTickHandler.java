
package mods.aginsun.kingdoms.handlers;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import java.util.EnumSet;
import mods.aginsun.kingdoms.handlers.SchematicHandler;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class CommonTickHandler
implements ITickHandler {
    public void tickStart(EnumSet<TickType> type, Object ... tickData) {
    }

    public void tickEnd(EnumSet<TickType> type, Object ... tickData) {
        if (type.equals(EnumSet.of(TickType.SERVER))) {
            this.onTickInGame();
        }
    }

    public EnumSet<TickType> ticks() {
        return EnumSet.of(TickType.SERVER);
    }

    public String getLabel() {
        return "TaleofKingdomsServerTick";
    }

    public void onTickInGame() {
        WorldServer world = FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(0);
        if (world != null) {
            SchematicHandler.getInstance().update((World)world);
        }
    }
}

