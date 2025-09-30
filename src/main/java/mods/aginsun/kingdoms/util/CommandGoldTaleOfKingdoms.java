
package mods.aginsun.kingdoms.util;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import mods.aginsun.kingdoms.handlers.GoldKeeper;
import mods.aginsun.kingdoms.handlers.ResourceHandler;
import mods.aginsun.kingdoms.handlers.WorthyKeeper;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class CommandGoldTaleOfKingdoms
extends CommandBase {
    public GoldKeeper gold;
    public Minecraft mc = FMLClientHandler.instance().getClient();
    public World world = FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(0);
    public String i;

    public String getCommandName() {
        return "tok";
    }

    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length > 0 && args[0].equals("worthy")) {
            float oldWorthy = WorthyKeeper.getInstance().getWorthy();
            WorthyKeeper.getInstance().addWorthy(10000.0f);
            float newWorthy = WorthyKeeper.getInstance().getWorthy();
            sendMessage(sender, "Added 10000 worthy points! Worthy: " + oldWorthy + " -> " + newWorthy);
        } else if (args.length > 0) {
            ResourceHandler.getInstance().addcobbleResource(2400);
            ResourceHandler.getInstance().addwoodResource(2400);
            sendMessage(sender, "Added 2400 cobble and 2400 wood resources!");
        } else {
            sendMessage(sender, "Usage: /tok worthy or /tok <anything else>");
        }
    }

    public void sendMessage(ICommandSender sender, String message) {
        sender.addChatMessage(new ChatComponentText(message));
    }

    public String getCommandUsage(ICommandSender icommandsender) {
        return "/tok [worthy] - Tale of Kingdoms commands";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2; // OP level 2 required
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return sender.canCommandSenderUseCommand(this.getRequiredPermissionLevel(), this.getCommandName());
    }
}

