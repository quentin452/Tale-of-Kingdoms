
package mods.aginsun.kingdoms.client.handlers;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import mods.aginsun.kingdoms.client.guis.GuiStartConquest;
import mods.aginsun.kingdoms.util.Buildings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;

public class KeyBindingHandler {
    public static KeyBinding keyStartConquest = new KeyBinding("Start Conquest", 21, "Tale of Kingdoms");

    public static void registerKeyBindings() {
        ClientRegistry.registerKeyBinding(keyStartConquest);
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        Minecraft mc = Minecraft.getMinecraft();
        
        if (keyStartConquest.isPressed()) {
            if (mc.currentScreen == null && !Buildings.getBuilding(0)) {
                mc.displayGuiScreen(new GuiStartConquest(mc));
            }
        }
    }
}

