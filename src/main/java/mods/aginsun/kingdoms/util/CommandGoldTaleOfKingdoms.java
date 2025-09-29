/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.client.FMLClientHandler
 *  cpw.mods.fml.common.FMLCommonHandler
 *  net.minecraft.client.Minecraft
 *  net.minecraft.command.CommandBase
 *  net.minecraft.command.ICommandSender
 *  net.minecraft.util.ChatMessageComponent
 *  net.minecraft.world.World
 */
package mods.aginsun.kingdoms.util;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import mods.aginsun.kingdoms.handlers.GoldKeeper;
import mods.aginsun.kingdoms.handlers.ResourceHandler;
import mods.aginsun.kingdoms.handlers.WorthyKeeper;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatMessageComponent;
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
        if (args[0].equals("worthy")) {
            WorthyKeeper.getInstance().addWorthy(10000.0f);
        } else {
            ResourceHandler.getInstance().addcobbleResource(2400);
            ResourceHandler.getInstance().addwoodResource(2400);
        }
    }

    public void sendMessage(ICommandSender sender, String message) {
        sender.sendChatToPlayer(new ChatMessageComponent().addText(message));
    }

    public String getCommandUsage(ICommandSender icommandsender) {
        return null;
    }
}

