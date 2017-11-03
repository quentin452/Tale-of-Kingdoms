package mods.aginsun.kingdoms.util;

import cpw.mods.fml.common.FMLCommonHandler;
import mods.aginsun.kingdoms.handlers.GoldKeeper;
import mods.aginsun.kingdoms.handlers.ResourceHandler;
import mods.aginsun.kingdoms.handlers.WorthyKeeper;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public final class CommandGoldTaleOfKingdoms extends CommandBase
{
    public String i;
    public GoldKeeper gold;
    public Minecraft mc = Minecraft.getMinecraft();
    public World world = FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(0);

    public String getCommandName()
    {
        return "tok";
    }

    public void processCommand(ICommandSender sender, String[] args)
    {
        if(args[0].equals("worthy"))
        {
            WorthyKeeper.getInstance().addWorthy(10000.0F);
        }
        else
        {
            ResourceHandler.getInstance().addcobbleResource(2400);
            ResourceHandler.getInstance().addwoodResource(2400);
        }
    }

    public String getCommandUsage(ICommandSender icommandsender)
    {
        return null;
    }
}