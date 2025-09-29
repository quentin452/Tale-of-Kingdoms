/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.registry.EntityRegistry
 *  net.minecraft.entity.Entity
 */
package mods.aginsun.kingdoms.entities;

import cpw.mods.fml.common.registry.EntityRegistry;
import java.awt.Color;
import mods.aginsun.kingdoms.TaleOfKingdoms;
import mods.aginsun.kingdoms.entities.EntityBankerKeeper;
import mods.aginsun.kingdoms.entities.EntityBarracksKeeper;
import mods.aginsun.kingdoms.entities.EntityBuilderKeeper;
import mods.aginsun.kingdoms.entities.EntityDefendArcher;
import mods.aginsun.kingdoms.entities.EntityDefendBandit;
import mods.aginsun.kingdoms.entities.EntityDefendKnight;
import mods.aginsun.kingdoms.entities.EntityDefendMage;
import mods.aginsun.kingdoms.entities.EntityDefendMarker;
import mods.aginsun.kingdoms.entities.EntityDefendPaladin;
import mods.aginsun.kingdoms.entities.EntityDefendPriest;
import mods.aginsun.kingdoms.entities.EntityDefendWarrior;
import mods.aginsun.kingdoms.entities.EntityFarmerKeeper;
import mods.aginsun.kingdoms.entities.EntityFisher;
import mods.aginsun.kingdoms.entities.EntityFoodKeeper;
import mods.aginsun.kingdoms.entities.EntityForgeKeeper;
import mods.aginsun.kingdoms.entities.EntityGuildMaster;
import mods.aginsun.kingdoms.entities.EntityGuildMember;
import mods.aginsun.kingdoms.entities.EntityHeadCommander;
import mods.aginsun.kingdoms.entities.EntityHired;
import mods.aginsun.kingdoms.entities.EntityHunterKeeper;
import mods.aginsun.kingdoms.entities.EntityInnKeeper;
import mods.aginsun.kingdoms.entities.EntityKingdomWorker;
import mods.aginsun.kingdoms.entities.EntityLibraryKeeper;
import mods.aginsun.kingdoms.entities.EntityLoneTraveller;
import mods.aginsun.kingdoms.entities.EntityLostVillager;
import mods.aginsun.kingdoms.entities.EntityLumber;
import mods.aginsun.kingdoms.entities.EntityMageKeeper;
import mods.aginsun.kingdoms.entities.EntityMarker2Keeper;
import mods.aginsun.kingdoms.entities.EntityMarkerKeeper;
import mods.aginsun.kingdoms.entities.EntityPriestKeeper;
import mods.aginsun.kingdoms.entities.EntityQuarry;
import mods.aginsun.kingdoms.entities.EntityReficulGuardian;
import mods.aginsun.kingdoms.entities.EntityReficulMage;
import mods.aginsun.kingdoms.entities.EntityReficulSoldier;
import mods.aginsun.kingdoms.entities.EntityShopKeeper;
import mods.aginsun.kingdoms.entities.EntityStableMaster;
import mods.aginsun.kingdoms.entities.EntityStockKeeper;
import mods.aginsun.kingdoms.entities.EntityTavernKeeper;
import mods.aginsun.kingdoms.entities.EntityVillageMember;
import mods.aginsun.kingdoms.entities.EntityWeaponKeeper;
import mods.aginsun.kingdoms.entities.EntityWorkerMember;
import net.minecraft.entity.Entity;

public class EntityRegistryToK {
    public static void registerEntities() {
        EntityRegistryToK.registerEntity(EntityStableMaster.class, "StableMaster", 214);
        EntityRegistryToK.registerEntity(EntityFisher.class, "Fisher", 215);
        EntityRegistryToK.registerEntity(EntityLumber.class, "Lumber", 216);
        EntityRegistryToK.registerEntity(EntityWorkerMember.class, "WorkerMember", 217);
        EntityRegistryToK.registerEntity(EntityDefendMarker.class, "DefendMark", 218);
        EntityRegistryToK.registerEntity(EntityMageKeeper.class, "MageKeeper", 219);
        EntityRegistryToK.registerEntity(EntityGuildMaster.class, "GuildMaster", 220);
        EntityRegistryToK.registerEntity(EntityInnKeeper.class, "InnKeeper", 221);
        EntityRegistryToK.registerEntity(EntityHunterKeeper.class, "GuildKeeper", 222);
        EntityRegistryToK.registerEntity(EntityBuilderKeeper.class, "BuilderKeeper", 223);
        EntityRegistryToK.registerEntity(EntityBankerKeeper.class, "Banker", 224);
        EntityRegistryToK.registerEntity(EntityBarracksKeeper.class, "BarracksKeeper", 225);
        EntityRegistryToK.registerEntity(EntityDefendArcher.class, "DefendArcher", 226);
        EntityRegistryToK.registerEntity(EntityDefendBandit.class, "DefendBandit", 227);
        EntityRegistryToK.registerEntity(EntityDefendKnight.class, "DefendKnight", 228);
        EntityRegistryToK.registerEntity(EntityDefendMage.class, "DefendMage", 229);
        EntityRegistryToK.registerEntity(EntityDefendPaladin.class, "DefendPaladin", 230);
        EntityRegistryToK.registerEntity(EntityDefendPriest.class, "DefendPriest", 231);
        EntityRegistryToK.registerEntity(EntityDefendWarrior.class, "DefendWarrior", 232);
        EntityRegistryToK.registerEntity(EntityFarmerKeeper.class, "Farmer", 233);
        EntityRegistryToK.registerEntity(EntityFoodKeeper.class, "FoodKeeper", 234);
        EntityRegistryToK.registerEntity(EntityQuarry.class, "Quarry", 235);
        EntityRegistryToK.registerEntity(EntityWeaponKeeper.class, "WeaponKeeper", 236);
        EntityRegistryToK.registerEntity(EntityGuildMember.class, "GuildMember", 237);
        EntityRegistryToK.registerEntity(EntityHired.class, "Hired", 238);
        EntityRegistryToK.registerEntity(EntityForgeKeeper.class, "ForgeKeeper", 239);
        EntityRegistryToK.registerEntity(EntityHeadCommander.class, "HeadCommander", 240);
        EntityRegistryToK.registerEntity(EntityKingdomWorker.class, "KingdomWorker", 241);
        EntityRegistryToK.registerEntity(EntityLibraryKeeper.class, "LibraryKeeper", 242);
        EntityRegistryToK.registerEntity(EntityLoneTraveller.class, "LoneTraveller", 243);
        EntityRegistryToK.registerEntity(EntityLostVillager.class, "LostVillager", 244);
        EntityRegistryToK.registerEntity(EntityMarkerKeeper.class, "Marker", 245);
        EntityRegistryToK.registerEntity(EntityMarker2Keeper.class, "Marker2", 246);
        EntityRegistryToK.registerEntity(EntityPriestKeeper.class, "PriestKeeper", 247);
        EntityRegistryToK.registerEntity(EntityReficulGuardian.class, "ReficulGuardian", 248);
        EntityRegistryToK.registerEntity(EntityReficulMage.class, "ReficulMage", 249);
        EntityRegistryToK.registerEntity(EntityReficulSoldier.class, "ReficulSoldier", 250);
        EntityRegistryToK.registerEntity(EntityShopKeeper.class, "ShopKeeper", 251);
        EntityRegistryToK.registerEntity(EntityStockKeeper.class, "StockKeeper", 252);
        EntityRegistryToK.registerEntity(EntityTavernKeeper.class, "TavernKeeper", 253);
        EntityRegistryToK.registerEntity(EntityVillageMember.class, "VillageMember", 254);
    }

    private static void registerEntity(Class<? extends Entity> entityClass, String name, int id) {
        EntityRegistry.registerGlobalEntityID(entityClass, (String)name, (int)id, (int)Color.red.getRGB(), (int)Color.green.getRGB());
        EntityRegistry.registerModEntity(entityClass, (String)name, (int)id, (Object)TaleOfKingdoms.instance, (int)250, (int)2, (boolean)false);
    }
}

