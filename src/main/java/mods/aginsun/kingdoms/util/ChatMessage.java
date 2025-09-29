package mods.aginsun.kingdoms.util;
import net.minecraft.util.ChatComponentText;
import net.minecraft.entity.player.EntityPlayer;

public class ChatMessage {
    public static void add(EntityPlayer player,String message) {
        player.addChatMessage(new ChatComponentText(message));
    }
}
