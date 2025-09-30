package mods.aginsun.kingdoms.client.guis;

import mods.aginsun.kingdoms.client.guis.GuiScreenToK;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import mods.aginsun.kingdoms.util.ChatMessage;

public class GuiInnMenu
extends GuiScreenToK {
    private World worldObj;
    public EntityPlayer player;
    boolean goldchecker = false;
    boolean screenpause = false;
    boolean isResting = false;

    public GuiInnMenu(EntityPlayer player, World world) {
        this.player = player;
        this.worldObj = world;
    }

    public void initGui() {
        if (!this.isResting) {
            this.buttonList.clear();
            this.buttonList.add(new GuiButton(1, this.width / 2 + 110, 180, 100, 20, "Rest in a room."));
            this.buttonList.add(new GuiButton(2, this.width / 2 + 110, 200, 100, 20, "Wait for night time."));
            this.buttonList.add(new GuiButton(3, this.width / 2 + 110, 220, 100, 20, "Exit"));
        } else if (this.isResting) {
            this.buttonList.clear();
            this.buttonList.add(new GuiButton(1, this.width / 2 + 110, 220, 70, 20, "Wake Up."));
        }
    }

    protected void actionPerformed(GuiButton guibutton) {
        if (guibutton.id == 1) {
            if (!this.isResting) {
                this.screenpause = true;
                this.isResting = true;
                this.player.heal(20.0f);
                long l = this.worldObj.getWorldInfo().getWorldTime() + 24000L;
                this.worldObj.getWorldInfo().setWorldTime(l - l % 24000L);
                this.initGui();
            } else {
                this.screenpause = false;
                this.isResting = false;
                this.initGui();
            }
        }
        if (guibutton.id == 2) {
            if (!this.isResting) {
                this.screenpause = true;
                this.isResting = true;
                this.player.heal(20.0f);
                this.worldObj.getWorldInfo().setWorldTime(14000L);
                this.initGui();
            } else {
                this.screenpause = false;
                this.isResting = false;
                this.initGui();
            }
        }
        if (guibutton.id == 3) {
            this.mc.displayGuiScreen(null);
            this.goldchecker = false;
        }
    }

    @Override
    public boolean doesGuiPauseGame() {
        return this.screenpause;
    }

    public void onGuiClosed() {
        if (!this.worldObj.isRemote) {
            ChatMessage.add(this.player,"House Keeper: Have a nice day.");
        }
    }

    public void drawScreen(int i, int j, float f) {
        if (!this.isResting) {
            this.drawCenteredString(this.fontRendererObj, "Time flies when you rest..", this.width / 2, 10, 0xFFEE00);
            this.drawCenteredString(this.fontRendererObj, "Note: You could rest even in daylight but you will wake up the next day", this.width / 2, 20, 0xFFEE00);
        } else {
            this.drawDefaultBackground();
            this.drawCenteredString(this.fontRendererObj, "Resting..", this.width / 2, this.height / 2 - 20, 0xFFEE00);
        }
        for (int k = 0; k < this.buttonList.size(); ++k) {
            GuiButton guibutton = (GuiButton)this.buttonList.get(k);
            guibutton.drawButton(this.mc, i, j);
        }
    }
}

