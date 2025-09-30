
package mods.aginsun.kingdoms.handlers;

import java.util.HashMap;
import mods.aginsun.kingdoms.handlers.Schematic;

public class SchematicRegistry {
    private static HashMap<Integer, Schematic> list = new HashMap();

    public static void registerAllBuildings(int i, int j, int k) {
        SchematicRegistry.addSchematic(1, new Schematic("/mods/aginsun/kingdoms/schematics/tier1/Tier1").setPosition(i, j, k));
        SchematicRegistry.addSchematic(2, new Schematic("/mods/aginsun/kingdoms/schematics/tier1/Tier1SmallHouse1").setPosition(i + 6, j + 1, k + 37));
        SchematicRegistry.addSchematic(3, new Schematic("/mods/aginsun/kingdoms/schematics/tier1/Tier1SmallHouse2").setPosition(i + 6, j + 1, k + 15));
        SchematicRegistry.addSchematic(6, new Schematic("/mods/aginsun/kingdoms/schematics/tier1/Tier1Blacksmith").setPosition(i + 18, j + 1, k + 4));
        SchematicRegistry.addSchematic(4, new Schematic("/mods/aginsun/kingdoms/schematics/tier1/Tier1LargeHouse1").setPosition(i + 19, j + 1, k + 35));
        SchematicRegistry.addSchematic(5, new Schematic("/mods/aginsun/kingdoms/schematics/tier1/Tier1Well").setPosition(i + 23, j + 1, k + 26));
        SchematicRegistry.addSchematic(7, new Schematic("/mods/aginsun/kingdoms/schematics/tier1/Tier1StockMarket").setPosition(i + 35, j + 1, k + 16));
        SchematicRegistry.addSchematic(8, new Schematic("/mods/aginsun/kingdoms/schematics/tier2/Tier2").setPosition(i, j, k));
        SchematicRegistry.addSchematic(9, new Schematic("/mods/aginsun/kingdoms/schematics/tier2/Tier2SmallHouse1").setPosition(i + 59, j + 1, k + 42));
        SchematicRegistry.addSchematic(10, new Schematic("/mods/aginsun/kingdoms/schematics/tier2/Tier2SmallHouse2").setPosition(i + 14, j + 1, k + 74));
        SchematicRegistry.addSchematic(11, new Schematic("/mods/aginsun/kingdoms/schematics/tier2/Tier2LargeHouse1").setPosition(i + 59, j + 1, k + 61));
        SchematicRegistry.addSchematic(12, new Schematic("/mods/aginsun/kingdoms/schematics/tier2/Tier2BuilderHouse").setPosition(i + 14, j + 1, k + 58));
        SchematicRegistry.addSchematic(13, new Schematic("/mods/aginsun/kingdoms/schematics/tier2/Tier2Barracks").setPosition(i + 57, j + 1, k + 14));
        SchematicRegistry.addSchematic(14, new Schematic("/mods/aginsun/kingdoms/schematics/tier2/Tier2FoodShop").setPosition(i + 40, j + 1, k + 65));
        SchematicRegistry.addSchematic(15, new Schematic("/mods/aginsun/kingdoms/schematics/tier2/Tier2BlockShop").setPosition(i + 41, j + 1, k + 42));
        int i1 = i - 10;
        int k1 = k - 5;
        SchematicRegistry.addSchematic(16, new Schematic("/mods/aginsun/kingdoms/schematics/tier3/Tier3").setPosition(i1, j, k1));
        SchematicRegistry.addSchematic(17, new Schematic("/mods/aginsun/kingdoms/schematics/tier3/Tier3SmallHouse1").setPosition(i1 + 81, j + 1, k1 + 123));
        SchematicRegistry.addSchematic(18, new Schematic("/mods/aginsun/kingdoms/schematics/tier3/Tier3SmallHouse2").setPosition(i1 + 81, j + 1, k1 + 47));
        SchematicRegistry.addSchematic(19, new Schematic("/mods/aginsun/kingdoms/schematics/tier3/Tier3SmallHouse3").setPosition(i1 + 83, j + 1, k1 + 65));
        SchematicRegistry.addSchematic(20, new Schematic("/mods/aginsun/kingdoms/schematics/tier3/Tier3LargeHouse1").setPosition(i1 + 103, j + 1, k1 + 72));
        SchematicRegistry.addSchematic(21, new Schematic("/mods/aginsun/kingdoms/schematics/tier3/Tier3Tavern").setPosition(i1 + 35, j + 1, k1 + 123));
        SchematicRegistry.addSchematic(22, new Schematic("/mods/aginsun/kingdoms/schematics/tier3/Tier3Chapel").setPosition(i1 + 93, j, k1 + 100));
        SchematicRegistry.addSchematic(23, new Schematic("/mods/aginsun/kingdoms/schematics/tier3/Tier3Library").setPosition(i1 + 103, j + 1, k1 + 20));
        SchematicRegistry.addSchematic(24, new Schematic("/mods/aginsun/kingdoms/schematics/tier3/Tier3MageHall").setPosition(i1 + 105, j + 1, k1 + 46));
        int j1 = j - 6;
        SchematicRegistry.addSchematic(25, new Schematic("/mods/aginsun/kingdoms/schematics/tier4/Tier4").setPosition(i1, j1, k1));
        SchematicRegistry.addSchematic(26, new Schematic("/mods/aginsun/kingdoms/schematics/tier4/Tier4Bridge").setPosition(i1 + 130, j + 1, k1 + 90));
        SchematicRegistry.addSchematic(27, new Schematic("/mods/aginsun/kingdoms/schematics/tier4/Tier4Castle").setPosition(i1 + 51, j1 - 5, k1 + 151));
        SchematicRegistry.addSchematic(28, new Schematic("/mods/aginsun/kingdoms/schematics/tier4/Tier4Colloseum").setPosition(i1 + 142, j + 1, k1 + 36));
        SchematicRegistry.addSchematic(29, new Schematic("/mods/aginsun/kingdoms/schematics/tier4/Tier4EasternTower").setPosition(i1 + 103, j + 1, k1 + 133));
        SchematicRegistry.addSchematic(30, new Schematic("/mods/aginsun/kingdoms/schematics/tier4/Tier4FishHut").setPosition(i1 + 110, j + 1, k1 + 151));
        SchematicRegistry.addSchematic(31, new Schematic("/mods/aginsun/kingdoms/schematics/tier4/Tier4LightHouse").setPosition(i1 + 114, j - 1, k1 + 186));
        SchematicRegistry.addSchematic(32, new Schematic("/mods/aginsun/kingdoms/schematics/tier4/Tier4Mill").setPosition(i1 + 20, j + 1, k1 + 126));
        SchematicRegistry.addSchematic(33, new Schematic("/mods/aginsun/kingdoms/schematics/tier4/Tier4ObserverPost").setPosition(i1 + 32, j + 1, k1 + 90));
        SchematicRegistry.addSchematic(34, new Schematic("/mods/aginsun/kingdoms/schematics/tier4/Tier4SmallHouse1").setPosition(i1 + 145, j + 1, k1 + 108));
        SchematicRegistry.addSchematic(35, new Schematic("/mods/aginsun/kingdoms/schematics/tier4/Tier4SmallHouse2").setPosition(i1 + 145, j + 1, k1 + 122));
        SchematicRegistry.addSchematic(36, new Schematic("/mods/aginsun/kingdoms/schematics/tier4/Tier4SmallHouse3").setPosition(i1 + 170, j + 1, k1 + 80));
        SchematicRegistry.addSchematic(37, new Schematic("/mods/aginsun/kingdoms/schematics/tier4/Tier4SmallHouse4").setPosition(i1 + 170, j + 1, k1 + 95));
        SchematicRegistry.addSchematic(38, new Schematic("/mods/aginsun/kingdoms/schematics/tier4/Tier4LargeHouse").setPosition(i1 + 170, j, k1 + 109));
        SchematicRegistry.addSchematic(39, new Schematic("/mods/aginsun/kingdoms/schematics/tier4/Tier4NorthernTower1").setPosition(i1 + 144, j + 1, k1 + 77));
        SchematicRegistry.addSchematic(40, new Schematic("/mods/aginsun/kingdoms/schematics/tier4/Tier4NorthernTower2").setPosition(i1 + 181, j + 1, k1 + 68));
        SchematicRegistry.addSchematic(41, new Schematic("/mods/aginsun/kingdoms/schematics/tier4/Tier4Stables").setPosition(i1 + 131, j + 1, k1 + 142));
        SchematicRegistry.addSchematic(42, new Schematic("/mods/aginsun/kingdoms/schematics/tier4/Tier4Zeppelin").setPosition(i1 + 171, j + 1, k1 + 138));
        SchematicRegistry.addSchematic(43, new Schematic("/mods/aginsun/kingdoms/schematics/tier4/Tier4Stables1").setPosition(i1 + 169, j, k1 + 163));
        SchematicRegistry.addSchematic(44, new Schematic("/mods/aginsun/kingdoms/schematics/tier4/Tier4Stables2").setPosition(i1 + 131, j, k1 + 164));
    }

    private static void addSchematic(int id, Schematic schematic) {
        list.put(id, schematic);
    }

    public static Schematic getSchematic(int id) {
        return list.get(id);
    }
}

