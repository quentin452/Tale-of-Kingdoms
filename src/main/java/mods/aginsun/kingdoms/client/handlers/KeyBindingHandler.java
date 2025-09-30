
package mods.aginsun.kingdoms.client.handlers;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.TickType;
import java.util.EnumSet;
import mods.aginsun.kingdoms.client.guis.GuiStartConquest;
import mods.aginsun.kingdoms.util.Buildings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;

public class KeyBindingHandler
extends KeyBindingRegistry.KeyHandler {
    private static KeyBinding key = new KeyBinding("Start Conquest", 21);
    private static KeyBinding[] keybindings = new KeyBinding[]{key};
    private static boolean[] booleans = new boolean[]{false};

    public KeyBindingHandler() {
        super(keybindings, booleans);
    }

    public String getLabel() {
        return "Start Conquest";
    }

    public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat) {
        if (FMLClientHandler.instance().getClient().currentScreen == null && kb.getKeyCode() == KeyBindingHandler.key.getKeyCode() && !Buildings.getBuilding(0)) {
            FMLCommonHandler.instance().showGuiScreen((Object)new GuiStartConquest(Minecraft.getMinecraft()));
        }
    }

    public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd) {
    }

    public EnumSet<TickType> ticks() {
        return EnumSet.of(TickType.CLIENT);
    }
}

