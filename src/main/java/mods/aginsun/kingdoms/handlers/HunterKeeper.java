/*
 * Decompiled with CFR 0.152.
 */
package mods.aginsun.kingdoms.handlers;

public class HunterKeeper {
    private boolean hunter = false;
    private static HunterKeeper instance = new HunterKeeper();

    public static HunterKeeper getInstance() {
        return instance;
    }

    public void setHunter(boolean a) {
        this.hunter = a;
    }

    public boolean getHunter() {
        return this.hunter;
    }
}

