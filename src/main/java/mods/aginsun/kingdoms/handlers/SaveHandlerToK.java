
package mods.aginsun.kingdoms.handlers;

import cpw.mods.fml.common.IPlayerTracker;
import mods.aginsun.kingdoms.handlers.GoldKeeper;
import mods.aginsun.kingdoms.handlers.HunterKeeper;
import mods.aginsun.kingdoms.handlers.ResourceHandler;
import mods.aginsun.kingdoms.handlers.WorkerHandler;
import mods.aginsun.kingdoms.handlers.WorthyKeeper;
import mods.aginsun.kingdoms.util.Buildings;
import mods.aginsun.kingdoms.util.UtilToK;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class SaveHandlerToK
implements IPlayerTracker {
    private NBTTagCompound nbt;

    public void onPlayerLogin(EntityPlayer player) {
        this.getData(player);
        Buildings.registerBuildings();
    }

    public void onPlayerLogout(EntityPlayer player) {
        this.setData(player);
    }

    public void getData(EntityPlayer player) {
        if (player != null) {
            this.nbt = player.getEntityData().getCompoundTag("PlayerPersisted");
            if (this.nbt != null) {
                boolean tralala = this.nbt.hasKey("Version");
                this.updateSaveFile(this.nbt, tralala);
                HunterKeeper.getInstance().setHunter(this.nbt.getBoolean("hunter"));
                UtilToK.guildFightEnded = this.nbt.getBoolean("guildFightEnded");
                UtilToK.guildFightStarted = this.nbt.getBoolean("guildFightStarted");
                Buildings.createGuild = this.nbt.getBoolean("GuildCreated");
                Buildings.smallhouse1 = this.nbt.getBoolean("smallhouse1");
                Buildings.smallhouse2 = this.nbt.getBoolean("smallhouse2");
                Buildings.largehouse1 = this.nbt.getBoolean("largehouse1");
                Buildings.well = this.nbt.getBoolean("well");
                Buildings.itemshop = this.nbt.getBoolean("itemshop");
                Buildings.stockmarket = this.nbt.getBoolean("stockmarket");
                Buildings.isTier2 = this.nbt.getBoolean("isTier2");
                Buildings.smallhouse3 = this.nbt.getBoolean("smallhouse3");
                Buildings.largehouse2 = this.nbt.getBoolean("largehouse2");
                Buildings.builderhouse = this.nbt.getBoolean("builderhouse");
                Buildings.smallhouse4 = this.nbt.getBoolean("smallhouse4");
                Buildings.barracks = this.nbt.getBoolean("barracks");
                Buildings.foodshop = this.nbt.getBoolean("foodshop");
                Buildings.blockshop = this.nbt.getBoolean("blockshop");
                Buildings.isTier3 = this.nbt.getBoolean("isTier3");
                Buildings.tavern = this.nbt.getBoolean("tavern");
                Buildings.smallhouse5 = this.nbt.getBoolean("smallhouse5");
                Buildings.smallhouse6 = this.nbt.getBoolean("smallhouse6");
                Buildings.smallhouse7 = this.nbt.getBoolean("smallhouse7");
                Buildings.chapel = this.nbt.getBoolean("chapel");
                Buildings.largehouse3 = this.nbt.getBoolean("largehouse3");
                Buildings.library = this.nbt.getBoolean("library");
                Buildings.magehall = this.nbt.getBoolean("magehall");
                Buildings.isTier4 = this.nbt.getBoolean("isTier4");
                Buildings.bridge = this.nbt.getBoolean("bridge");
                Buildings.castle = this.nbt.getBoolean("castle");
                Buildings.easternTower = this.nbt.getBoolean("easternTower");
                Buildings.fishHut = this.nbt.getBoolean("fishHut");
                Buildings.lightHouse = this.nbt.getBoolean("lightHouse");
                Buildings.mill = this.nbt.getBoolean("mill");
                Buildings.observerPost = this.nbt.getBoolean("observerPost");
                Buildings.smallhouse8 = this.nbt.getBoolean("smallhouse8");
                Buildings.smallhouse9 = this.nbt.getBoolean("smallhouse9");
                Buildings.smallhouse10 = this.nbt.getBoolean("smallhouse10");
                Buildings.smallhouse11 = this.nbt.getBoolean("smallhouse11");
                Buildings.largehouse4 = this.nbt.getBoolean("largehouse4");
                Buildings.northernTower1 = this.nbt.getBoolean("northernTower1");
                Buildings.northernTower2 = this.nbt.getBoolean("northernTower2");
                Buildings.colloseum = this.nbt.getBoolean("colloseum");
                Buildings.stables = this.nbt.getBoolean("stables");
                Buildings.zeppelin = this.nbt.getBoolean("zeppelin");
                ResourceHandler.getInstance().setWoodPool(this.nbt.getInteger("woodPool"));
                ResourceHandler.getInstance().setCobblePool(this.nbt.getInteger("cobblePool"));
                ResourceHandler.getInstance().setwoodResource(this.nbt.getInteger("woodResource"));
                ResourceHandler.getInstance().setcobbleResource(this.nbt.getInteger("cobblestoneResource"));
                GoldKeeper.goldTotal = this.nbt.getInteger("GoldTotal");
                UtilToK.townX = this.nbt.getInteger("townX");
                UtilToK.townY = this.nbt.getInteger("townY");
                UtilToK.townZ = this.nbt.getInteger("townZ");
                WorthyKeeper.getInstance().setWorthy(this.nbt.getFloat("worthy"));
                UtilToK.burningVillages = this.nbt.getInteger("burningVillages");
                UtilToK.reficulHoles = this.nbt.getInteger("reficulHoles");
                UtilToK.libraryInvestment = this.nbt.getInteger("libraryInvestment");
                UtilToK.bindLight = this.nbt.getInteger("bindLight");
                GoldKeeper.bankGold = this.nbt.getInteger("bankGold");
                WorkerHandler.getInstance().setQuarryMembers(this.nbt.getInteger("quarryMembers"));
                WorkerHandler.getInstance().setLumberMembers(this.nbt.getInteger("lumberMembers"));
            }
        }
    }

    public void setData(EntityPlayer player) {
        if (player != null) {
            this.nbt = player.getEntityData().getCompoundTag("PlayerPersisted");
            if (this.nbt != null) {
                this.nbt.setBoolean("GuildCreated", Buildings.getBuilding(0));
                this.nbt.setBoolean("hunter", HunterKeeper.getInstance().getHunter());
                this.nbt.setInteger("GoldTotal", GoldKeeper.getGoldTotal());
                this.nbt.setBoolean("hunter", HunterKeeper.getInstance().getHunter());
                this.nbt.setInteger("townX", UtilToK.townX);
                this.nbt.setInteger("townY", UtilToK.townY);
                this.nbt.setInteger("townZ", UtilToK.townZ);
                this.nbt.setBoolean("kingdomCreated", Buildings.getBuilding(1));
                this.nbt.setInteger("woodResource", ResourceHandler.getInstance().getwoodResource());
                this.nbt.setInteger("cobblestoneResource", ResourceHandler.getInstance().getcobbleResource());
                this.nbt.setBoolean("smallhouse1", Buildings.getBuilding(2));
                this.nbt.setBoolean("smallhouse2", Buildings.getBuilding(3));
                this.nbt.setBoolean("largehouse1", Buildings.getBuilding(4));
                this.nbt.setBoolean("well", Buildings.getBuilding(5));
                this.nbt.setBoolean("itemshop", Buildings.getBuilding(6));
                this.nbt.setBoolean("stockmarket", Buildings.getBuilding(7));
                this.nbt.setBoolean("isTier2", Buildings.getBuilding(8));
                this.nbt.setBoolean("smallhouse3", Buildings.getBuilding(9));
                this.nbt.setBoolean("largehouse2", Buildings.getBuilding(10));
                this.nbt.setBoolean("builderhouse", Buildings.getBuilding(11));
                this.nbt.setBoolean("smallhouse4", Buildings.getBuilding(12));
                this.nbt.setBoolean("barracks", Buildings.getBuilding(13));
                this.nbt.setBoolean("foodshop", Buildings.getBuilding(14));
                this.nbt.setBoolean("blockshop", Buildings.getBuilding(15));
                this.nbt.setBoolean("isTier3", Buildings.getBuilding(16));
                this.nbt.setBoolean("smallhouse5", Buildings.getBuilding(17));
                this.nbt.setBoolean("smallhouse6", Buildings.getBuilding(18));
                this.nbt.setBoolean("smallhouse7", Buildings.getBuilding(19));
                this.nbt.setBoolean("largehouse3", Buildings.getBuilding(20));
                this.nbt.setBoolean("tavern", Buildings.getBuilding(21));
                this.nbt.setBoolean("chapel", Buildings.getBuilding(22));
                this.nbt.setBoolean("library", Buildings.getBuilding(23));
                this.nbt.setBoolean("magehall", Buildings.getBuilding(24));
                this.nbt.setBoolean("isTier4", Buildings.getBuilding(25));
                this.nbt.setBoolean("bridge", Buildings.getBuilding(26));
                this.nbt.setBoolean("castle", Buildings.getBuilding(27));
                this.nbt.setBoolean("easternTower", Buildings.getBuilding(28));
                this.nbt.setBoolean("fishHut", Buildings.getBuilding(29));
                this.nbt.setBoolean("lightHouse", Buildings.getBuilding(30));
                this.nbt.setBoolean("mill", Buildings.getBuilding(31));
                this.nbt.setBoolean("observerPost", Buildings.getBuilding(32));
                this.nbt.setBoolean("smallhouse8", Buildings.getBuilding(33));
                this.nbt.setBoolean("smallhouse9", Buildings.getBuilding(34));
                this.nbt.setBoolean("smallhouse10", Buildings.getBuilding(35));
                this.nbt.setBoolean("smallhouse11", Buildings.getBuilding(36));
                this.nbt.setBoolean("largehouse4", Buildings.getBuilding(37));
                this.nbt.setBoolean("northernTower1", Buildings.getBuilding(38));
                this.nbt.setBoolean("northernTower2", Buildings.getBuilding(39));
                this.nbt.setBoolean("colloseum", Buildings.getBuilding(40));
                this.nbt.setBoolean("stables", Buildings.getBuilding(41));
                this.nbt.setBoolean("zeppelin", Buildings.getBuilding(42));
                this.nbt.setInteger("burningVillages", UtilToK.burningVillages);
                this.nbt.setInteger("reficulHoles", UtilToK.reficulHoles);
                this.nbt.setBoolean("guildFightEnded", UtilToK.guildFightEnded);
                this.nbt.setBoolean("guildFightStarted", UtilToK.guildFightStarted);
                this.nbt.setInteger("libraryInvestment", UtilToK.libraryInvestment);
                this.nbt.setInteger("bindLight", UtilToK.bindLight);
                this.nbt.setInteger("bankGold", GoldKeeper.bankGold);
                this.nbt.setFloat("worthy", WorthyKeeper.getInstance().getWorthy());
                this.nbt.setInteger("quarryMembers", WorkerHandler.getInstance().getQuarryMembers());
                this.nbt.setInteger("lumberMembers", WorkerHandler.getInstance().getLumberMembers());
                this.nbt.setInteger("woodPool", ResourceHandler.getInstance().getWoodPool());
                this.nbt.setInteger("cobblePool", ResourceHandler.getInstance().getCobblePool());
                this.nbt.setString("Version", "1.5-Pre Release");
                player.getEntityData().setCompoundTag("PlayerPersisted", this.nbt);
            }
        }
    }

    public void updateSaveFile(NBTTagCompound nbt, boolean requireUpdate) {
        if (!requireUpdate) {
            this.convertToBool("GuildCreated");
            this.convertToBool("hunter");
            this.convertToBool("smallhouse1");
            this.convertToBool("smallhouse2");
            this.convertToBool("largehouse1");
            this.convertToBool("well");
            this.convertToBool("itemshop");
            this.convertToBool("stockmarket");
            this.convertToBool("isTier2");
            this.convertToBool("smallhouse3");
            this.convertToBool("largehouse2");
            this.convertToBool("builderhouse");
            this.convertToBool("smallhouse4");
            this.convertToBool("barracks");
            this.convertToBool("foodshop");
            this.convertToBool("blockshop");
            this.convertToBool("guildFightEnded");
            this.convertToBool("guildFightStarted");
            this.convertToBool("isTier3");
            this.convertToBool("tavern");
            this.convertToBool("smallhouse5");
            this.convertToBool("smallhouse6");
            this.convertToBool("smallhouse7");
            this.convertToBool("chapel");
            this.convertToBool("largehouse3");
            this.convertToBool("library");
            this.convertToBool("magehall");
            this.convertToBool("ForemanCreated");
            this.convertToBool("builderCreated");
            this.convertToInt("woodPool");
            this.convertToInt("cobblePool");
            this.convertToInt("woodResource");
            this.convertToInt("cobblestoneResource");
        }
    }

    public void convertToBool(String name) {
        int i = this.nbt.getInteger(name);
        this.nbt.removeTag(name);
        if (i == 0) {
            this.nbt.setBoolean(name, false);
        } else {
            this.nbt.setBoolean(name, true);
        }
    }

    public void convertToInt(String name) {
        float f = this.nbt.getFloat(name);
        this.nbt.removeTag(name);
        this.nbt.setInteger(name, Math.round(f));
    }

    public void onPlayerChangedDimension(EntityPlayer player) {
    }

    public void onPlayerRespawn(EntityPlayer player) {
    }
}

