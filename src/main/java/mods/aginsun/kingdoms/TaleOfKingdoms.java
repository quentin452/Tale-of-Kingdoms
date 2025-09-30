package mods.aginsun.kingdoms;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.IGuiHandler;
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
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid="taleofkingdoms", name="Tale of Kingdoms", version="1.0.0")
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
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, proxy);
        coins = new Itemcoins();
        GameRegistry.registerItem(coins, "coins");
        LanguageRegistry.addName(coins, "Coins");
    }

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        CommandHandler commandManager = (CommandHandler)event.getServer().getCommandManager();
        commandManager.registerCommand((ICommand)new CommandGoldTaleOfKingdoms());
    }

    @Mod.EventHandler
    public void serverStarted(FMLServerStartedEvent event) {
        FMLCommonHandler.instance().bus().register(new SaveHandlerToK());
        MinecraftForge.EVENT_BUS.register(new PickupHandler());
    }
}

