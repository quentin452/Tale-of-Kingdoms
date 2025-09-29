/*
 * Decompiled with CFR 0.152.
 */
package mods.aginsun.kingdoms.util;

import java.util.ArrayList;

public class Buildings {
    private static ArrayList<Boolean> buildingList = new ArrayList();
    public static boolean createGuild;
    public static boolean kingdomCreated;
    public static boolean smallhouse1;
    public static boolean smallhouse2;
    public static boolean largehouse1;
    public static boolean well;
    public static boolean itemshop;
    public static boolean stockmarket;
    public static boolean isTier2;
    public static boolean smallhouse3;
    public static boolean smallhouse4;
    public static boolean largehouse2;
    public static boolean builderhouse;
    public static boolean barracks;
    public static boolean foodshop;
    public static boolean blockshop;
    public static boolean isTier3;
    public static boolean smallhouse5;
    public static boolean smallhouse6;
    public static boolean smallhouse7;
    public static boolean largehouse3;
    public static boolean tavern;
    public static boolean chapel;
    public static boolean library;
    public static boolean magehall;
    public static boolean isTier4;
    public static boolean bridge;
    public static boolean castle;
    public static boolean colloseum;
    public static boolean easternTower;
    public static boolean fishHut;
    public static boolean lightHouse;
    public static boolean mill;
    public static boolean observerPost;
    public static boolean smallhouse8;
    public static boolean smallhouse9;
    public static boolean smallhouse10;
    public static boolean smallhouse11;
    public static boolean largehouse4;
    public static boolean northernTower1;
    public static boolean northernTower2;
    public static boolean stables;
    public static boolean zeppelin;

    public static void registerBuildings() {
        Buildings.addBuilding(createGuild);
        Buildings.addBuilding(kingdomCreated);
        Buildings.addBuilding(smallhouse1);
        Buildings.addBuilding(smallhouse2);
        Buildings.addBuilding(largehouse1);
        Buildings.addBuilding(well);
        Buildings.addBuilding(itemshop);
        Buildings.addBuilding(stockmarket);
        Buildings.addBuilding(isTier2);
        Buildings.addBuilding(smallhouse3);
        Buildings.addBuilding(largehouse2);
        Buildings.addBuilding(builderhouse);
        Buildings.addBuilding(smallhouse4);
        Buildings.addBuilding(barracks);
        Buildings.addBuilding(foodshop);
        Buildings.addBuilding(blockshop);
        Buildings.addBuilding(isTier3);
        Buildings.addBuilding(tavern);
        Buildings.addBuilding(smallhouse5);
        Buildings.addBuilding(smallhouse6);
        Buildings.addBuilding(smallhouse7);
        Buildings.addBuilding(chapel);
        Buildings.addBuilding(largehouse3);
        Buildings.addBuilding(library);
        Buildings.addBuilding(magehall);
        Buildings.addBuilding(isTier4);
        Buildings.addBuilding(bridge);
        Buildings.addBuilding(castle);
        Buildings.addBuilding(colloseum);
        Buildings.addBuilding(easternTower);
        Buildings.addBuilding(fishHut);
        Buildings.addBuilding(largehouse4);
        Buildings.addBuilding(lightHouse);
        Buildings.addBuilding(mill);
        Buildings.addBuilding(northernTower1);
        Buildings.addBuilding(northernTower2);
        Buildings.addBuilding(observerPost);
        Buildings.addBuilding(smallhouse8);
        Buildings.addBuilding(smallhouse9);
        Buildings.addBuilding(smallhouse10);
        Buildings.addBuilding(smallhouse11);
        Buildings.addBuilding(stables);
        Buildings.addBuilding(zeppelin);
        Buildings.addBuilding(stables);
        Buildings.addBuilding(stables);
    }

    public static void addBuilding(boolean x) {
        buildingList.add(x);
    }

    public static void setBuildingTrue(int number) {
        boolean h = buildingList.get(number);
        h = true;
        buildingList.set(number, h);
    }

    public static void setBuildingState(boolean x, int number) {
        boolean h = buildingList.get(number);
        h = x;
        buildingList.set(number, h);
    }

    public static boolean getBuilding(int number) {
        return Buildings.getBuildingList().get(number);
    }

    public static ArrayList<Boolean> getBuildingList() {
        return buildingList;
    }

    public void setBuildingList(ArrayList<Boolean> buildingList) {
        Buildings.buildingList = buildingList;
    }
}

