/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.IPickupNotifier
 *  cpw.mods.fml.common.IPlayerTracker
 *  cpw.mods.fml.common.Mod
 *  cpw.mods.fml.common.Mod$EventHandler
 *  cpw.mods.fml.common.Mod$Instance
 *  cpw.mods.fml.common.SidedProxy
 *  cpw.mods.fml.common.event.FMLInitializationEvent
 *  cpw.mods.fml.common.event.FMLPreInitializationEvent
 *  cpw.mods.fml.common.event.FMLServerStartedEvent
 *  cpw.mods.fml.common.event.FMLServerStartingEvent
 *  cpw.mods.fml.common.network.IGuiHandler
 *  cpw.mods.fml.common.network.NetworkMod
 *  cpw.mods.fml.common.network.NetworkRegistry
 *  cpw.mods.fml.common.registry.GameRegistry
 *  cpw.mods.fml.common.registry.LanguageRegistry
 *  net.minecraft.command.CommandHandler
 *  net.minecraft.command.ICommand
 *  net.minecraft.item.Item
 *  net.minecraftforge.common.Configuration
 *  net.minecraftforge.common.MinecraftForge
 */
package mods.aginsun.kingdoms;

import cpw.mods.fml.common.IPickupNotifier;
import cpw.mods.fml.common.IPlayerTracker;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import mods.aginsun.kingdoms.core.CommonProxy;
import mods.aginsun.kingdoms.entities.EntityRegistryToK;
import mods.aginsun.kingdoms.handlers.EntityLivingHandler;
import mods.aginsun.kingdoms.handlers.PickupHandler;
import mods.aginsun.kingdoms.handlers.SaveHandlerToK;
import mods.aginsun.kingdoms.items.Itemcoins;
import mods.aginsun.kingdoms.util.CommandGoldTaleOfKingdoms;
import net.minecraft.command.CommandHandler;
import net.minecraft.command.ICommand;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid="taleofkingdoms", name="Tale of Kingdoms", version="1.5-Pre Release")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class TaleOfKingdoms {
    @Mod.Instance(value="taleofkingdoms")
    public static TaleOfKingdoms instance = new TaleOfKingdoms();
    @SidedProxy(clientSide="mods.aginsun.kingdoms.client.ClientProxy", serverSide="mods.aginsun.core.CommonProxy")
    public static CommonProxy proxy;
    public static Item coins;
    public static int coinID;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();
        coinID = config.get("item", "Coins", 7865).getInt();
        config.save();
    }

    @Mod.EventHandler
    public void load(FMLInitializationEvent event) {
        proxy.registerRenderers();
        proxy.Init();
        EntityRegistryToK.registerEntities();
        MinecraftForge.EVENT_BUS.register((Object)new EntityLivingHandler());
        NetworkRegistry.instance().registerGuiHandler((Object)instance, (IGuiHandler)proxy);
        coins = new Itemcoins(coinID).setUnlocalizedName("Coins");
        LanguageRegistry.addName((Object)coins, (String)"Coins");
    }

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        CommandHandler commandManager = (CommandHandler)event.getServer().getCommandManager();
        commandManager.registerCommand((ICommand)new CommandGoldTaleOfKingdoms());
    }

    @Mod.EventHandler
    public void serverStarted(FMLServerStartedEvent event) {
        GameRegistry.registerPlayerTracker((IPlayerTracker)new SaveHandlerToK());
        GameRegistry.registerPickupHandler((IPickupNotifier)new PickupHandler());
    }
}

