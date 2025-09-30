
package mods.aginsun.kingdoms.handlers;

import java.util.Random;

public class GoldKeeper {
    public static int goldTotal;
    public static int bankGold;
    public static int hunter;
    public static float flint;
    public static float clay;
    public static float iron;
    public static float diamond;
    public static float fish;
    public static float apple;
    public static float string;
    public static float feather;

    public static int getGoldTotal() {
        return goldTotal;
    }

    public static void addGold(int i) {
        goldTotal += i;
    }

    public static void setGoldTotal(int i) {
        goldTotal = i;
    }

    public static void decreaseGold(int i) {
        goldTotal -= i;
    }

    public static int getBankGold() {
        return bankGold;
    }

    public static void addBankGold(int i) {
        bankGold += i;
    }

    public static void setBankGold(int i) {
        bankGold = i;
    }

    public static void decreaseBankGold(int i) {
        bankGold -= i;
    }

    public static int priceItem(String s) {
        if (s.equals("tile.stone")) {
            return 4;
        }
        if (s.equals("tile.grass")) {
            return 0;
        }
        if (s.equals("tile.dirt")) {
            return 0;
        }
        if (s.equals("tile.stonebrick")) {
            return 0;
        }
        if (s.equals("tile.wood")) {
            return 2;
        }
        if (s.equals("tile.sapling")) {
            return 8;
        }
        if (s.equals("tile.bedrock")) {
            return 0;
        }
        if (s.equals("tile.water")) {
            return 0;
        }
        if (s.equals("tile.water")) {
            return 0;
        }
        if (s.equals("tile.lava")) {
            return 0;
        }
        if (s.equals("tile.lava")) {
            return 0;
        }
        if (s.equals("tile.sand")) {
            return 10;
        }
        if (s.equals("tile.gravel")) {
            return 5;
        }
        if (s.equals("tile.oreGold")) {
            return 100;
        }
        if (s.equals("tile.oreIron")) {
            return 80;
        }
        if (s.equals("tile.oreCoal")) {
            return 15;
        }
        if (s.equals("tile.log")) {
            return 5;
        }
        if (s.equals("tile.leaves")) {
            return 0;
        }
        if (s.equals("tile.sponge")) {
            return 0;
        }
        if (s.equals("tile.glass")) {
            return 30;
        }
        if (s.equals("tile.oreLapis")) {
            return 0;
        }
        if (s.equals("tile.blockLapis")) {
            return 180;
        }
        if (s.equals("tile.dispenser")) {
            return 270;
        }
        if (s.equals("tile.sandStone")) {
            return 40;
        }
        if (s.equals("tile.musicBlock")) {
            return 20;
        }
        if (s.equals("tile.bed")) {
            return 40;
        }
        if (s.equals("tile.goldenRail")) {
            return 152;
        }
        if (s.equals("tile.detectorRail")) {
            return 85;
        }
        if (s.equals("tile.pistonStickyBase")) {
            return 185;
        }
        if (s.equals("tile.web")) {
            return 0;
        }
        if (s.equals("tile.tallgrass")) {
            return 0;
        }
        if (s.equals("tile.deadbush")) {
            return 0;
        }
        if (s.equals("tile.pistonBase")) {
            return 105;
        }
        if (s.equals("tile.cloth")) {
            return 12;
        }
        if (s.equals("tile.flower")) {
            return 10;
        }
        if (s.equals("tile.rose")) {
            return 40;
        }
        if (s.equals("tile.mushroom")) {
            return 15;
        }
        if (s.equals("tile.mushroom")) {
            return 15;
        }
        if (s.equals("tile.blockGold")) {
            return 1350;
        }
        if (s.equals("tile.blockIron")) {
            return 765;
        }
        if (s.equals("tile.stoneSlab")) {
            return 6;
        }
        if (s.equals("tile.stoneSlab")) {
            return 6;
        }
        if (s.equals("tile.brick")) {
            return 800;
        }
        if (s.equals("tile.tnt")) {
            return 800;
        }
        if (s.equals("tile.bookshelf")) {
            return 70;
        }
        if (s.equals("tile.stoneMoss")) {
            return 50;
        }
        if (s.equals("tile.obsidian")) {
            return 50;
        }
        if (s.equals("tile.torch")) {
            return 5;
        }
        if (s.equals("tile.fire")) {
            return 0;
        }
        if (s.equals("tile.mobSpawner")) {
            return 0;
        }
        if (s.equals("tile.stairsWood")) {
            return 0;
        }
        if (s.equals("tile.chest")) {
            return 10;
        }
        if (s.equals("tile.redstoneDust")) {
            return 5;
        }
        if (s.equals("tile.oreDiamond")) {
            return 360;
        }
        if (s.equals("tile.blockDiamond")) {
            return 3807;
        }
        if (s.equals("tile.workbench")) {
            return 5;
        }
        if (s.equals("tile.crops")) {
            return 0;
        }
        if (s.equals("tile.farmland")) {
            return 0;
        }
        if (s.equals("tile.furnace")) {
            return 10;
        }
        if (s.equals("tile.furnace")) {
            return 0;
        }
        if (s.equals("tile.sign")) {
            return 13;
        }
        if (s.equals("tile.doorWood")) {
            return 6;
        }
        if (s.equals("tile.ladder")) {
            return 3;
        }
        if (s.equals("tile.rail")) {
            return 30;
        }
        if (s.equals("tile.stairsStone")) {
            return 0;
        }
        if (s.equals("tile.sign")) {
            return 13;
        }
        if (s.equals("tile.lever")) {
            return 1;
        }
        if (s.equals("tile.pressurePlate")) {
            return 2;
        }
        if (s.equals("tile.doorIron")) {
            return 500;
        }
        if (s.equals("tile.pressurePlate")) {
            return 2;
        }
        if (s.equals("tile.oreRedstone")) {
            return 10;
        }
        if (s.equals("tile.oreRedstone")) {
            return 10;
        }
        if (s.equals("tile.notGate")) {
            return 10;
        }
        if (s.equals("tile.notGate")) {
            return 10;
        }
        if (s.equals("tile.button")) {
            return 5;
        }
        if (s.equals("tile.snow")) {
            return 15;
        }
        if (s.equals("tile.ice")) {
            return 0;
        }
        if (s.equals("tile.snow")) {
            return 0;
        }
        if (s.equals("tile.cactus")) {
            return 3;
        }
        if (s.equals("tile.clay")) {
            return 20;
        }
        if (s.equals("tile.reeds")) {
            return 0;
        }
        if (s.equals("tile.jukebox")) {
            return 245;
        }
        if (s.equals("tile.fence")) {
            return 5;
        }
        if (s.equals("tile.pumpkin")) {
            return 120;
        }
        if (s.equals("tile.hellrock")) {
            return 0;
        }
        if (s.equals("tile.hellsand")) {
            return 15;
        }
        if (s.equals("tile.lightgem")) {
            return 60;
        }
        if (s.equals("tile.portal")) {
            return 0;
        }
        if (s.equals("tile.litpumpkin")) {
            return 125;
        }
        if (s.equals("tile.cake")) {
            return 300;
        }
        if (s.equals("tile.diode")) {
            return 25;
        }
        if (s.equals("tile.diode")) {
            return 25;
        }
        if (s.equals("tile.lockedchest")) {
            return 0;
        }
        if (s.equals("tile.trapdoor")) {
            return 3;
        }
        if (s.equals("tile.stonebricksmooth")) {
            return 20;
        }
        if (s.equals("tile.mushroom")) {
            return 0;
        }
        if (s.equals("tile.mushroom")) {
            return 0;
        }
        if (s.equals("tile.fenceIron")) {
            return 32;
        }
        if (s.equals("tile.thinGlass")) {
            return 12;
        }
        if (s.equals("tile.melon")) {
            return 0;
        }
        if (s.equals("tile.pumpkinStem")) {
            return 0;
        }
        if (s.equals("tile.pumpkinStem")) {
            return 0;
        }
        if (s.equals("tile.vine")) {
            return 30;
        }
        if (s.equals("tile.fenceGate")) {
            return 10;
        }
        if (s.equals("tile.stairsBrick")) {
            return 0;
        }
        if (s.equals("tile.stairsStoneBrickSmooth")) {
            return 0;
        }
        if (s.equals("item.shovelIron")) {
            return 87;
        }
        if (s.equals("item.pickaxeIron")) {
            return 257;
        }
        if (s.equals("item.hatchetIron")) {
            return 257;
        }
        if (s.equals("item.flintAndSteel")) {
            return 89;
        }
        if (s.equals("item.apple")) {
            return 20;
        }
        if (s.equals("item.bow")) {
            return 250;
        }
        if (s.equals("item.arrow")) {
            return 4;
        }
        if (s.equals("item.coal")) {
            return 15;
        }
        if (s.equals("item.emerald")) {
            return 405;
        }
        if (s.equals("item.ingotIron")) {
            return 85;
        }
        if (s.equals("item.ingotGold")) {
            return 0;
        }
        if (s.equals("item.swordIron")) {
            return 160;
        }
        if (s.equals("item.swordWood")) {
            return 5;
        }
        if (s.equals("item.shovelWood")) {
            return 6;
        }
        if (s.equals("item.pickaxeWood")) {
            return 8;
        }
        if (s.equals("item.hatchetWood")) {
            return 8;
        }
        if (s.equals("item.swordStone")) {
            return 10;
        }
        if (s.equals("item.shovelStone")) {
            return 6;
        }
        if (s.equals("item.pickaxeStone")) {
            return 14;
        }
        if (s.equals("item.hatchetStone")) {
            return 14;
        }
        if (s.equals("item.swordDiamond")) {
            return 855;
        }
        if (s.equals("item.shovelDiamond")) {
            return 462;
        }
        if (s.equals("item.pickaxeDiamond")) {
            return 1380;
        }
        if (s.equals("item.hatchetDiamond")) {
            return 1380;
        }
        if (s.equals("item.stick")) {
            return 1;
        }
        if (s.equals("item.bowl")) {
            return 0;
        }
        if (s.equals("item.mushroomStew")) {
            return 0;
        }
        if (s.equals("item.swordGold")) {
            return 0;
        }
        if (s.equals("item.shovelGold")) {
            return 0;
        }
        if (s.equals("item.pickaxeGold")) {
            return 0;
        }
        if (s.equals("item.hatchetGold")) {
            return 0;
        }
        if (s.equals("item.string")) {
            return 75;
        }
        if (s.equals("item.feather")) {
            return 2;
        }
        if (s.equals("item.sulphur")) {
            return 150;
        }
        if (s.equals("item.hoeWood")) {
            return 6;
        }
        if (s.equals("item.hoeStone")) {
            return 10;
        }
        if (s.equals("item.hoeIron")) {
            return 172;
        }
        if (s.equals("item.hoeDiamond")) {
            return 921;
        }
        if (s.equals("item.hoeGold")) {
            return 0;
        }
        if (s.equals("item.seeds")) {
            return 0;
        }
        if (s.equals("item.wheat")) {
            return 5;
        }
        if (s.equals("item.bread")) {
            return 15;
        }
        if (s.equals("item.helmetCloth")) {
            return 75;
        }
        if (s.equals("item.chestplateCloth")) {
            return 120;
        }
        if (s.equals("item.leggingsCloth")) {
            return 90;
        }
        if (s.equals("item.bootsCloth")) {
            return 60;
        }
        if (s.equals("item.helmetChain")) {
            return 0;
        }
        if (s.equals("item.chestplateChain")) {
            return 0;
        }
        if (s.equals("item.leggingsChain")) {
            return 0;
        }
        if (s.equals("item.bootsChain")) {
            return 0;
        }
        if (s.equals("item.helmetIron")) {
            return 425;
        }
        if (s.equals("item.chestplateIron")) {
            return 595;
        }
        if (s.equals("item.leggingsIron")) {
            return 560;
        }
        if (s.equals("item.bootsIron")) {
            return 320;
        }
        if (s.equals("item.helmetDiamond")) {
            return 2115;
        }
        if (s.equals("item.chestplateDiamond")) {
            return 3384;
        }
        if (s.equals("item.leggingsDiamond")) {
            return 2961;
        }
        if (s.equals("item.bootsDiamond")) {
            return 1410;
        }
        if (s.equals("item.helmetGold")) {
            return 0;
        }
        if (s.equals("item.chestplateGold")) {
            return 0;
        }
        if (s.equals("item.leggingsGold")) {
            return 0;
        }
        if (s.equals("item.bootsGold")) {
            return 0;
        }
        if (s.equals("item.flint")) {
            return 4;
        }
        if (s.equals("item.porkchopRaw")) {
            return 10;
        }
        if (s.equals("item.porkchopCooked")) {
            return 15;
        }
        if (s.equals("item.painting")) {
            return 25;
        }
        if (s.equals("item.appleGold")) {
            return 1950;
        }
        if (s.equals("item.sign")) {
            return 13;
        }
        if (s.equals("item.doorWood")) {
            return 6;
        }
        if (s.equals("item.bucket")) {
            return 255;
        }
        if (s.equals("item.bucketWater")) {
            return 325;
        }
        if (s.equals("item.bucketLava")) {
            return 345;
        }
        if (s.equals("item.minecart")) {
            return 400;
        }
        if (s.equals("item.saddle")) {
            return 1900;
        }
        if (s.equals("item.doorIron")) {
            return 500;
        }
        if (s.equals("item.redstone")) {
            return 4;
        }
        if (s.equals("item.snowball")) {
            return 0;
        }
        if (s.equals("item.boat")) {
            return 10;
        }
        if (s.equals("item.leather")) {
            return 15;
        }
        if (s.equals("item.milk")) {
            return 270;
        }
        if (s.equals("item.brick")) {
            return 0;
        }
        if (s.equals("item.clay")) {
            return 5;
        }
        if (s.equals("item.reeds")) {
            return 7;
        }
        if (s.equals("item.paper")) {
            return 35;
        }
        if (s.equals("item.book")) {
            return 23;
        }
        if (s.equals("item.slimeball")) {
            return 0;
        }
        if (s.equals("item.minecartChest")) {
            return 0;
        }
        if (s.equals("item.minecartFurnace")) {
            return 0;
        }
        if (s.equals("item.egg")) {
            return 20;
        }
        if (s.equals("item.compass")) {
            return 240;
        }
        if (s.equals("item.fishingRod")) {
            return 24;
        }
        if (s.equals("item.clock")) {
            return 615;
        }
        if (s.equals("item.yellowDust")) {
            return 15;
        }
        if (s.equals("item.fishRaw")) {
            return 10;
        }
        if (s.equals("item.fishCooked")) {
            return 15;
        }
        if (s.equals("item.dyePowder")) {
            return 0;
        }
        if (s.equals("item.bone")) {
            return 15;
        }
        if (s.equals("item.sugar")) {
            return 5;
        }
        if (s.equals("item.cake")) {
            return 300;
        }
        if (s.equals("item.bed")) {
            return 40;
        }
        if (s.equals("item.diode")) {
            return 25;
        }
        if (s.equals("item.cookie")) {
            return 100;
        }
        if (s.equals("item.map")) {
            return 575;
        }
        if (s.equals("item.shears")) {
            return 160;
        }
        if (s.equals("item.melon")) {
            return 40;
        }
        if (s.equals("item.seeds_pumpkin")) {
            return 80;
        }
        if (s.equals("item.seeds_melon")) {
            return 60;
        }
        if (s.equals("item.beefRaw")) {
            return 15;
        }
        if (s.equals("item.beefCooked")) {
            return 20;
        }
        if (s.equals("item.chickenRaw")) {
            return 5;
        }
        if (s.equals("item.chickenCooked")) {
            return 10;
        }
        if (s.equals("item.rottenFlesh")) {
            return 1;
        }
        if (s.equals("item.enderPearl")) {
            return 150;
        }
        if (s.equals("item.record")) {
            return 4000;
        }
        if (s.equals("item.record")) {
            return 4000;
        }
        if (s.equals("item.coins")) {
            return 0;
        }
        if (s.equals("item.philStoneC")) {
            return 300;
        }
        if (s.equals("item.baseRing")) {
            return 800;
        }
        if (s.equals("item.alchemicalCoal")) {
            return 130;
        }
        if (s.equals("item.mobiusFuel")) {
            return 380;
        }
        if (s.equals("item.darkMatter")) {
            return 17964;
        }
        if (s.equals("item.repairCharm")) {
            return 758;
        }
        if (s.equals("tile.novaCatalyst")) {
            return 2360;
        }
        if (s.equals("tile.glowStoneAggregator")) {
            return 960;
        }
        if (s.equals("tile.obsAggregatorOff")) {
            return 1110;
        }
        if (s.equals("tile.interdictionTorch")) {
            return 381;
        }
        if (s.equals("tile.alChest")) {
            return 800;
        }
        if (s.equals("item.redstoneCrystal")) {
            return 30;
        }
        if (s.equals("item.glowstoneCrystal")) {
            return 150;
        }
        if (s.equals("item.lavaCrystal")) {
            return 300;
        }
        if (s.equals("item.slimeCrystal")) {
            return 51;
        }
        if (s.equals("item.mossBallGiant")) {
            return 300;
        }
        if (s.equals("item.woodBowlPumpkinPie")) {
            return 180;
        }
        if (s.equals("item.dDiamondPickaxe")) {
            return 1944;
        }
        if (s.equals("item.stStoneHammer")) {
            return 16;
        }
        if (s.equals("item.iceIceIceAxe")) {
            return 120;
        }
        if (s.equals("item.wIronFryingPan")) {
            return 192;
        }
        if (s.equals("item.lLavaAxe")) {
            return 572;
        }
        if (s.equals("item.mMossyHoe")) {
            return 320;
        }
        if (s.equals("item.sSlimeShovel")) {
            return 400;
        }
        if (s.equals("item.spearWood")) {
            return 4;
        }
        if (s.equals("item.spearStone")) {
            return 6;
        }
        if (s.equals("item.spearSteel")) {
            return 87;
        }
        if (s.equals("item.spearDiamond")) {
            return 407;
        }
        if (s.equals("item.halberdWood")) {
            return 8;
        }
        if (s.equals("item.halberdStone")) {
            return 14;
        }
        if (s.equals("item.halberdSteel")) {
            return 257;
        }
        if (s.equals("item.halberdDiamond")) {
            return 1217;
        }
        if (s.equals("item.battleaxeWood")) {
            return 12;
        }
        if (s.equals("item.battleaxeStone")) {
            return 22;
        }
        if (s.equals("item.battleaxeIron")) {
            return 427;
        }
        if (s.equals("item.battleaxeDiamond")) {
            return 2027;
        }
        if (s.equals("item.warhammerWood")) {
            return 11;
        }
        if (s.equals("item.warhammerStone")) {
            return 15;
        }
        if (s.equals("item.warhammerIron")) {
            return 342;
        }
        if (s.equals("item.warhammerDiamond")) {
            return 1623;
        }
        if (s.equals("item.knifeWood")) {
            return 3;
        }
        if (s.equals("item.knifeStone")) {
            return 5;
        }
        if (s.equals("item.knifeSteel")) {
            return 86;
        }
        if (s.equals("item.knifeDiamond")) {
            return 406;
        }
        if (s.equals("item.javelin")) {
            return 3;
        }
        if (s.equals("item.bayonet")) {
            return 434;
        }
        if (s.equals("item.bullet")) {
            return 30;
        }
        if (s.equals("item.musket")) {
            return 348;
        }
        if (s.equals("item.crossbow")) {
            return 594;
        }
        if (s.equals("item.bolt")) {
            return 22;
        }
        if (s.equals("item.blowgun")) {
            return 21;
        }
        if (s.equals("item.dart")) {
            return 2;
        }
        if (s.equals("item.dynamite")) {
            return 325;
        }
        if (s.equals("item.flailWood")) {
            return 154;
        }
        if (s.equals("item.flailStone")) {
            return 156;
        }
        if (s.equals("item.flailSteel")) {
            return 237;
        }
        if (s.equals("item.flailDiamond")) {
            return 557;
        }
        if (s.equals("item.fireRod")) {
            return 7;
        }
        if (s.equals("item.cannon")) {
            return 519;
        }
        if (s.equals("item.cannonBall")) {
            return 25;
        }
        if (s.equals("tile.stone")) {
            return 4;
        }
        if (s.equals("tile.grass")) {
            return 0;
        }
        if (s.equals("tile.dirt")) {
            return 0;
        }
        if (s.equals("tile.stonebrick")) {
            return 0;
        }
        if (s.equals("tile.wood")) {
            return 2;
        }
        if (s.equals("tile.sapling")) {
            return 8;
        }
        if (s.equals("tile.bedrock")) {
            return 0;
        }
        if (s.equals("tile.water")) {
            return 0;
        }
        if (s.equals("tile.water")) {
            return 0;
        }
        if (s.equals("tile.lava")) {
            return 0;
        }
        if (s.equals("tile.lava")) {
            return 0;
        }
        if (s.equals("tile.sand")) {
            return 10;
        }
        if (s.equals("tile.gravel")) {
            return 5;
        }
        if (s.equals("tile.oreGold")) {
            return 100;
        }
        if (s.equals("tile.oreIron")) {
            return 80;
        }
        if (s.equals("tile.oreCoal")) {
            return 15;
        }
        if (s.equals("tile.log")) {
            return 5;
        }
        if (s.equals("tile.leaves")) {
            return 0;
        }
        if (s.equals("tile.sponge")) {
            return 0;
        }
        if (s.equals("tile.glass")) {
            return 30;
        }
        if (s.equals("tile.oreLapis")) {
            return 0;
        }
        if (s.equals("tile.blockLapis")) {
            return 180;
        }
        if (s.equals("tile.dispenser")) {
            return 270;
        }
        if (s.equals("tile.sandStone")) {
            return 40;
        }
        if (s.equals("tile.musicBlock")) {
            return 20;
        }
        if (s.equals("tile.bed")) {
            return 40;
        }
        if (s.equals("tile.goldenRail")) {
            return 152;
        }
        if (s.equals("tile.detectorRail")) {
            return 85;
        }
        if (s.equals("tile.pistonStickyBase")) {
            return 185;
        }
        if (s.equals("tile.web")) {
            return 0;
        }
        if (s.equals("tile.tallgrass")) {
            return 0;
        }
        if (s.equals("tile.deadbush")) {
            return 0;
        }
        if (s.equals("tile.pistonBase")) {
            return 105;
        }
        if (s.equals("tile.cloth")) {
            return 12;
        }
        if (s.equals("tile.flower")) {
            return 10;
        }
        if (s.equals("tile.rose")) {
            return 40;
        }
        if (s.equals("tile.mushroom")) {
            return 15;
        }
        if (s.equals("tile.mushroom")) {
            return 15;
        }
        if (s.equals("tile.blockGold")) {
            return 1350;
        }
        if (s.equals("tile.blockIron")) {
            return 765;
        }
        if (s.equals("tile.stoneSlab")) {
            return 6;
        }
        if (s.equals("tile.stoneSlab")) {
            return 6;
        }
        if (s.equals("tile.brick")) {
            return 80;
        }
        if (s.equals("tile.tnt")) {
            return 800;
        }
        if (s.equals("tile.bookshelf")) {
            return 70;
        }
        if (s.equals("tile.stoneMoss")) {
            return 50;
        }
        if (s.equals("tile.obsidian")) {
            return 50;
        }
        if (s.equals("tile.torch")) {
            return 5;
        }
        if (s.equals("tile.fire")) {
            return 0;
        }
        if (s.equals("tile.mobSpawner")) {
            return 0;
        }
        if (s.equals("tile.stairsWood")) {
            return 0;
        }
        if (s.equals("tile.chest")) {
            return 10;
        }
        if (s.equals("tile.redstoneDust")) {
            return 5;
        }
        if (s.equals("tile.oreDiamond")) {
            return 360;
        }
        if (s.equals("tile.blockDiamond")) {
            return 3807;
        }
        if (s.equals("tile.workbench")) {
            return 5;
        }
        if (s.equals("tile.crops")) {
            return 0;
        }
        if (s.equals("tile.farmland")) {
            return 0;
        }
        if (s.equals("tile.furnace")) {
            return 10;
        }
        if (s.equals("tile.furnace")) {
            return 10;
        }
        if (s.equals("tile.sign")) {
            return 13;
        }
        if (s.equals("tile.doorWood")) {
            return 6;
        }
        if (s.equals("tile.ladder")) {
            return 3;
        }
        if (s.equals("tile.rail")) {
            return 30;
        }
        if (s.equals("tile.stairsStone")) {
            return 0;
        }
        if (s.equals("tile.sign")) {
            return 13;
        }
        if (s.equals("tile.lever")) {
            return 1;
        }
        if (s.equals("tile.pressurePlate")) {
            return 2;
        }
        if (s.equals("tile.doorIron")) {
            return 500;
        }
        if (s.equals("tile.pressurePlate")) {
            return 2;
        }
        if (s.equals("tile.oreRedstone")) {
            return 10;
        }
        if (s.equals("tile.oreRedstone")) {
            return 10;
        }
        if (s.equals("tile.notGate")) {
            return 10;
        }
        if (s.equals("tile.notGate")) {
            return 10;
        }
        if (s.equals("tile.button")) {
            return 5;
        }
        if (s.equals("tile.snow")) {
            return 15;
        }
        if (s.equals("tile.ice")) {
            return 0;
        }
        if (s.equals("tile.snow")) {
            return 15;
        }
        if (s.equals("tile.cactus")) {
            return 3;
        }
        if (s.equals("tile.clay")) {
            return 20;
        }
        if (s.equals("tile.reeds")) {
            return 0;
        }
        if (s.equals("tile.jukebox")) {
            return 245;
        }
        if (s.equals("tile.fence")) {
            return 5;
        }
        if (s.equals("tile.pumpkin")) {
            return 120;
        }
        if (s.equals("tile.hellrock")) {
            return 0;
        }
        if (s.equals("tile.hellsand")) {
            return 15;
        }
        if (s.equals("tile.lightgem")) {
            return 60;
        }
        if (s.equals("tile.portal")) {
            return 0;
        }
        if (s.equals("tile.litpumpkin")) {
            return 125;
        }
        if (s.equals("tile.cake")) {
            return 300;
        }
        if (s.equals("tile.diode")) {
            return 25;
        }
        if (s.equals("tile.diode")) {
            return 25;
        }
        if (s.equals("tile.lockedchest")) {
            return 0;
        }
        if (s.equals("tile.trapdoor")) {
            return 3;
        }
        if (s.equals("tile.stonebricksmooth")) {
            return 20;
        }
        if (s.equals("tile.mushroom")) {
            return 15;
        }
        if (s.equals("tile.mushroom")) {
            return 15;
        }
        if (s.equals("tile.fenceIron")) {
            return 32;
        }
        if (s.equals("tile.thinGlass")) {
            return 12;
        }
        if (s.equals("tile.melon")) {
            return 0;
        }
        if (s.equals("tile.pumpkinStem")) {
            return 0;
        }
        if (s.equals("tile.pumpkinStem")) {
            return 0;
        }
        if (s.equals("tile.vine")) {
            return 30;
        }
        if (s.equals("tile.fenceGate")) {
            return 10;
        }
        if (s.equals("tile.stairsBrick")) {
            return 0;
        }
        if (s.equals("tile.stairsStoneBrickSmooth")) {
            return 0;
        }
        if (s.equals("tile.saltOre")) {
            return 0;
        }
        if (s.equals("tile.pamcropblock")) {
            return 0;
        }
        if (s.equals("tile.pamFruit")) {
            return 0;
        }
        if (s.equals("tile.pamSapling")) {
            return 15;
        }
        if (s.equals("tile.pamBushes")) {
            return 0;
        }
        if (s.equals("tile.pamcottonCrop")) {
            return 0;
        }
        if (s.equals("tile.pamcottonWild")) {
            return 0;
        }
        if (s.equals("tile.pamcandleberryCrop")) {
            return 0;
        }
        if (s.equals("tile.pamcandleberryBush")) {
            return 0;
        }
        if (s.equals("tile.pamCandlenut")) {
            return 0;
        }
        if (s.equals("tile.pamcandlenutSapling")) {
            return 15;
        }
        if (s.equals("tile.pamOre")) {
            return 0;
        }
        if (s.equals("tile.pamGem")) {
            return 0;
        }
        if (s.equals("tile.pamCobble")) {
            return 1;
        }
        if (s.equals("tile.pamPaver")) {
            return 3;
        }
        if (s.equals("tile.pamBrick")) {
            return 850;
        }
        if (s.equals("tile.pamGlass")) {
            return 15;
        }
        if (s.equals("tile.pamSmooth")) {
            return 5;
        }
        if (s.equals("tile.pamPlank")) {
            return 3;
        }
        if (s.equals("item.shovelIron")) {
            return 87;
        }
        if (s.equals("item.pickaxeIron")) {
            return 257;
        }
        if (s.equals("item.hatchetIron")) {
            return 257;
        }
        if (s.equals("item.flintAndSteel")) {
            return 89;
        }
        if (s.equals("item.apple")) {
            return 20;
        }
        if (s.equals("item.bow")) {
            return 250;
        }
        if (s.equals("item.arrow")) {
            return 4;
        }
        if (s.equals("item.coal")) {
            return 15;
        }
        if (s.equals("item.emerald")) {
            return 405;
        }
        if (s.equals("item.ingotIron")) {
            return 85;
        }
        if (s.equals("item.ingotGold")) {
            return 0;
        }
        if (s.equals("item.swordIron")) {
            return 160;
        }
        if (s.equals("item.swordWood")) {
            return 5;
        }
        if (s.equals("item.shovelWood")) {
            return 6;
        }
        if (s.equals("item.pickaxeWood")) {
            return 8;
        }
        if (s.equals("item.hatchetWood")) {
            return 8;
        }
        if (s.equals("item.swordStone")) {
            return 10;
        }
        if (s.equals("item.shovelStone")) {
            return 6;
        }
        if (s.equals("item.pickaxeStone")) {
            return 14;
        }
        if (s.equals("item.hatchetStone")) {
            return 14;
        }
        if (s.equals("item.swordDiamond")) {
            return 855;
        }
        if (s.equals("item.shovelDiamond")) {
            return 462;
        }
        if (s.equals("item.pickaxeDiamond")) {
            return 1380;
        }
        if (s.equals("item.hatchetDiamond")) {
            return 1380;
        }
        if (s.equals("item.stick")) {
            return 1;
        }
        if (s.equals("item.bowl")) {
            return 0;
        }
        if (s.equals("item.mushroomStew")) {
            return 0;
        }
        if (s.equals("item.swordGold")) {
            return 0;
        }
        if (s.equals("item.shovelGold")) {
            return 0;
        }
        if (s.equals("item.pickaxeGold")) {
            return 0;
        }
        if (s.equals("item.hatchetGold")) {
            return 0;
        }
        if (s.equals("item.string")) {
            return 75;
        }
        if (s.equals("item.feather")) {
            return 2;
        }
        if (s.equals("item.sulphur")) {
            return 150;
        }
        if (s.equals("item.hoeWood")) {
            return 6;
        }
        if (s.equals("item.hoeStone")) {
            return 10;
        }
        if (s.equals("item.hoeIron")) {
            return 172;
        }
        if (s.equals("item.hoeDiamond")) {
            return 921;
        }
        if (s.equals("item.hoeGold")) {
            return 0;
        }
        if (s.equals("item.seeds")) {
            return 0;
        }
        if (s.equals("item.wheat")) {
            return 5;
        }
        if (s.equals("item.bread")) {
            return 15;
        }
        if (s.equals("item.helmetCloth")) {
            return 75;
        }
        if (s.equals("item.chestplateCloth")) {
            return 120;
        }
        if (s.equals("item.leggingsCloth")) {
            return 90;
        }
        if (s.equals("item.bootsCloth")) {
            return 60;
        }
        if (s.equals("item.helmetChain")) {
            return 0;
        }
        if (s.equals("item.chestplateChain")) {
            return 0;
        }
        if (s.equals("item.leggingsChain")) {
            return 0;
        }
        if (s.equals("item.bootsChain")) {
            return 0;
        }
        if (s.equals("item.helmetIron")) {
            return 425;
        }
        if (s.equals("item.chestplateIron")) {
            return 595;
        }
        if (s.equals("item.leggingsIron")) {
            return 560;
        }
        if (s.equals("item.bootsIron")) {
            return 320;
        }
        if (s.equals("item.helmetDiamond")) {
            return 2115;
        }
        if (s.equals("item.chestplateDiamond")) {
            return 3384;
        }
        if (s.equals("item.leggingsDiamond")) {
            return 2961;
        }
        if (s.equals("item.bootsDiamond")) {
            return 1410;
        }
        if (s.equals("item.helmetGold")) {
            return 0;
        }
        if (s.equals("item.chestplateGold")) {
            return 0;
        }
        if (s.equals("item.leggingsGold")) {
            return 0;
        }
        if (s.equals("item.bootsGold")) {
            return 0;
        }
        if (s.equals("item.flint")) {
            return 4;
        }
        if (s.equals("item.porkchopRaw")) {
            return 10;
        }
        if (s.equals("item.porkchopCooked")) {
            return 15;
        }
        if (s.equals("item.painting")) {
            return 25;
        }
        if (s.equals("item.appleGold")) {
            return 9001;
        }
        if (s.equals("item.sign")) {
            return 13;
        }
        if (s.equals("item.doorWood")) {
            return 6;
        }
        if (s.equals("item.bucket")) {
            return 255;
        }
        if (s.equals("item.bucketWater")) {
            return 325;
        }
        if (s.equals("item.bucketLava")) {
            return 345;
        }
        if (s.equals("item.minecart")) {
            return 400;
        }
        if (s.equals("item.saddle")) {
            return 800;
        }
        if (s.equals("item.doorIron")) {
            return 500;
        }
        if (s.equals("item.redstone")) {
            return 4;
        }
        if (s.equals("item.snowball")) {
            return 0;
        }
        if (s.equals("item.boat")) {
            return 10;
        }
        if (s.equals("item.leather")) {
            return 15;
        }
        if (s.equals("item.milk")) {
            return 270;
        }
        if (s.equals("item.brick")) {
            return 0;
        }
        if (s.equals("item.clay")) {
            return 5;
        }
        if (s.equals("item.reeds")) {
            return 7;
        }
        if (s.equals("item.paper")) {
            return 35;
        }
        if (s.equals("item.book")) {
            return 23;
        }
        if (s.equals("item.slimeball")) {
            return 0;
        }
        if (s.equals("item.minecartChest")) {
            return 0;
        }
        if (s.equals("item.minecartFurnace")) {
            return 0;
        }
        if (s.equals("item.egg")) {
            return 20;
        }
        if (s.equals("item.compass")) {
            return 240;
        }
        if (s.equals("item.fishingRod")) {
            return 24;
        }
        if (s.equals("item.clock")) {
            return 615;
        }
        if (s.equals("item.yellowDust")) {
            return 15;
        }
        if (s.equals("item.fishRaw")) {
            return 10;
        }
        if (s.equals("item.fishCooked")) {
            return 15;
        }
        if (s.equals("item.dyePowder")) {
            return 0;
        }
        if (s.equals("item.bone")) {
            return 15;
        }
        if (s.equals("item.sugar")) {
            return 5;
        }
        if (s.equals("item.cake")) {
            return 300;
        }
        if (s.equals("item.bed")) {
            return 40;
        }
        if (s.equals("item.diode")) {
            return 25;
        }
        if (s.equals("item.cookie")) {
            return 100;
        }
        if (s.equals("item.map")) {
            return 575;
        }
        if (s.equals("item.shears")) {
            return 160;
        }
        if (s.equals("item.melon")) {
            return 40;
        }
        if (s.equals("item.seeds_pumpkin")) {
            return 80;
        }
        if (s.equals("item.seeds_melon")) {
            return 60;
        }
        if (s.equals("item.beefRaw")) {
            return 15;
        }
        if (s.equals("item.beefCooked")) {
            return 20;
        }
        if (s.equals("item.chickenRaw")) {
            return 5;
        }
        if (s.equals("item.chickenCooked")) {
            return 10;
        }
        if (s.equals("item.rottenFlesh")) {
            return 1;
        }
        if (s.equals("item.enderPearl")) {
            return 150;
        }
        if (s.equals("item.record")) {
            return 4000;
        }
        if (s.equals("item.record")) {
            return 4000;
        }
        if (s.equals("item.coins")) {
            return 0;
        }
        if (s.equals("item.bonePick")) {
            return 47;
        }
        if (s.equals("item.boneShovel")) {
            return 18;
        }
        if (s.equals("item.boneAxe")) {
            return 47;
        }
        if (s.equals("item.boneHoe")) {
            return 32;
        }
        if (s.equals("item.boneSword")) {
            return 32;
        }
        if (s.equals("item.boneHelm")) {
            return 75;
        }
        if (s.equals("item.boneChest")) {
            return 120;
        }
        if (s.equals("item.boneLegs")) {
            return 105;
        }
        if (s.equals("item.boneBoots")) {
            return 60;
        }
        if (s.equals("item.cottonItem")) {
            return 5;
        }
        if (s.equals("item.cottonseedItem")) {
            return 0;
        }
        if (s.equals("item.wovenclothItem")) {
            return 15;
        }
        if (s.equals("item.cottonfertItem")) {
            return 25;
        }
        if (s.equals("item.cottonHelm")) {
            return 75;
        }
        if (s.equals("item.cottonChest")) {
            return 120;
        }
        if (s.equals("item.cottonLegs")) {
            return 105;
        }
        if (s.equals("item.cottonBoots")) {
            return 60;
        }
        if (s.equals("item.candleberryItem")) {
            return 5;
        }
        if (s.equals("item.candleberryseedItem")) {
            return 0;
        }
        if (s.equals("item.candlewaxItem")) {
            return 45;
        }
        if (s.equals("item.candlenutItem")) {
            return 20;
        }
        if (s.equals("item.hardenedleatherItem")) {
            return 65;
        }
        if (s.equals("item.candlefertItem")) {
            return 25;
        }
        if (s.equals("item.hardenedleatherHelm")) {
            return 325;
        }
        if (s.equals("item.hardenedleatherChest")) {
            return 455;
        }
        if (s.equals("item.hardenedleatherLegs")) {
            return 390;
        }
        if (s.equals("item.hardenedleatherBoots")) {
            return 260;
        }
        if (s.equals("item.cactusPick")) {
            return 8;
        }
        if (s.equals("item.cactusShovel")) {
            return 4;
        }
        if (s.equals("item.cactusAxe")) {
            return 8;
        }
        if (s.equals("item.cactusHoe")) {
            return 6;
        }
        if (s.equals("item.cactusSword")) {
            return 5;
        }
        if (s.equals("item.sandstonePick")) {
            return 122;
        }
        if (s.equals("item.sandstoneShovel")) {
            return 42;
        }
        if (s.equals("item.sandstoneAxe")) {
            return 122;
        }
        if (s.equals("item.sandstoneHoe")) {
            return 82;
        }
        if (s.equals("item.sandstoneSword")) {
            return 81;
        }
        if (s.equals("item.glasssteelPick")) {
            return 317;
        }
        if (s.equals("item.glasssteelShovel")) {
            return 107;
        }
        if (s.equals("item.glasssteelAxe")) {
            return 317;
        }
        if (s.equals("item.glasssteelHoe")) {
            return 212;
        }
        if (s.equals("item.glasssteelSword")) {
            return 211;
        }
        if (s.equals("item.cactusstickItem")) {
            return 1;
        }
        if (s.equals("item.glasssteelItem")) {
            return 105;
        }
        if (s.equals("item.cactusfruitItem")) {
            return 5;
        }
        if (s.equals("item.cactusfruitseedItem")) {
            return 0;
        }
        if (s.equals("item.cactusfruitfertItem")) {
            return 25;
        }
        if (s.equals("item.saltItem")) {
            return 5;
        }
        if (s.equals("item.butterItem")) {
            return 10;
        }
        if (s.equals("item.cheeseItem")) {
            return 15;
        }
        if (s.equals("item.doughItem")) {
            return 10;
        }
        if (s.equals("item.bakedpotatoItem")) {
            return 20;
        }
        if (s.equals("item.butteredpotatoItem")) {
            return 30;
        }
        if (s.equals("item.loadedpotatoItem")) {
            return 60;
        }
        if (s.equals("item.friedeggsItem")) {
            return 40;
        }
        if (s.equals("item.friedpotatoesItem")) {
            return 30;
        }
        if (s.equals("item.saladItem")) {
            return 30;
        }
        if (s.equals("item.saltedcookedfishItem")) {
            return 40;
        }
        if (s.equals("item.pumpkinpieItem")) {
            return 30;
        }
        if (s.equals("item.pizzaItem")) {
            return 60;
        }
        if (s.equals("item.spagettiItem")) {
            return 50;
        }
        if (s.equals("item.pastaItem")) {
            return 25;
        }
        if (s.equals("item.friedonionringsItem")) {
            return 30;
        }
        if (s.equals("item.applepieItem")) {
            return 40;
        }
        if (s.equals("item.applesauceItem")) {
            return 30;
        }
        if (s.equals("item.toastItem")) {
            return 30;
        }
        if (s.equals("item.grilledcheeseItem")) {
            return 50;
        }
        if (s.equals("item.bltsandwichItem")) {
            return 70;
        }
        if (s.equals("item.macncheeseItem")) {
            return 40;
        }
        if (s.equals("item.fishsticksItem")) {
            return 50;
        }
        if (s.equals("item.mashedpotatoesItem")) {
            return 40;
        }
        if (s.equals("item.fishsandwichItem")) {
            return 50;
        }
        if (s.equals("item.cerealItem")) {
            return 30;
        }
        if (s.equals("item.popcornitem")) {
            return 20;
        }
        if (s.equals("item.butteredpopcornItem")) {
            return 30;
        }
        if (s.equals("item.cornonthecobItem")) {
            return 30;
        }
        if (s.equals("item.saltedpeanutsItem")) {
            return 20;
        }
        if (s.equals("item.pbnjsandwichItem")) {
            return 50;
        }
        if (s.equals("item.raisinsItem")) {
            return 20;
        }
        if (s.equals("item.cornbreadmuffinsItem")) {
            return 30;
        }
        if (s.equals("item.tacoItem")) {
            return 60;
        }
        if (s.equals("item.nachosItem")) {
            return 30;
        }
        if (s.equals("item.strawberrypieItem")) {
            return 40;
        }
        if (s.equals("item.peanutbrittleItem")) {
            return 30;
        }
        if (s.equals("item.chocolatebarItem")) {
            return 20;
        }
        if (s.equals("item.driedappleslicesItem")) {
            return 30;
        }
        if (s.equals("item.driedstrawberriesItem")) {
            return 20;
        }
        if (s.equals("item.trailmixItem")) {
            return 50;
        }
        if (s.equals("item.icecreamItem")) {
            return 20;
        }
        if (s.equals("item.chocolateicecreamItem")) {
            return 30;
        }
        if (s.equals("item.strawberryicecreamItem")) {
            return 30;
        }
        if (s.equals("item.picklesItem")) {
            return 30;
        }
        if (s.equals("item.chocolatecoveredfruitItem")) {
            return 30;
        }
        if (s.equals("item.flourItem")) {
            return 5;
        }
        if (s.equals("item.cornmealdoughItem")) {
            return 20;
        }
        if (s.equals("item.cornmuffinmixItem")) {
            return 20;
        }
        if (s.equals("item.tortillaItem")) {
            return 20;
        }
        if (s.equals("item.bottleItem")) {
            return 15;
        }
        if (s.equals("item.mayoItem")) {
            return 20;
        }
        if (s.equals("item.vinegarItem")) {
            return 25;
        }
        if (s.equals("item.peanutbutterItem")) {
            return 20;
        }
        if (s.equals("item.grapejellyItem")) {
            return 25;
        }
        if (s.equals("item.strawberryjamItem")) {
            return 25;
        }
        if (s.equals("item.stockItem")) {
            return 15;
        }
        if (s.equals("item.noodlesoupItem")) {
            return 20;
        }
        if (s.equals("item.hambonesoupItem")) {
            return 40;
        }
        if (s.equals("item.cheesesoupItem")) {
            return 40;
        }
        if (s.equals("item.vegetablesoupItem")) {
            return 40;
        }
        if (s.equals("item.onionsoupItem")) {
            return 40;
        }
        if (s.equals("item.peanutsoupItem")) {
            return 40;
        }
        if (s.equals("item.cucumbersoupItem")) {
            return 40;
        }
        if (s.equals("item.carrotsoupItem")) {
            return 40;
        }
        if (s.equals("item.pumpkinsoupItem")) {
            return 40;
        }
        if (s.equals("item.wheatsoupItem")) {
            return 40;
        }
        if (s.equals("item.potatosoupItem")) {
            return 40;
        }
        if (s.equals("item.oatmealItem")) {
            return 30;
        }
        if (s.equals("item.friedpicklesItem")) {
            return 40;
        }
        if (s.equals("item.shepardpieItem")) {
            return 70;
        }
        if (s.equals("item.strawberryiceItem")) {
            return 20;
        }
        if (s.equals("item.sidesaladItem")) {
            return 80;
        }
        if (s.equals("item.breakfastsandwichItem")) {
            return 70;
        }
        if (s.equals("item.coleslawItem")) {
            return 40;
        }
        if (s.equals("item.fishlettucewrapItem")) {
            return 40;
        }
        if (s.equals("item.fishtacoItem")) {
            return 50;
        }
        if (s.equals("item.porklettucewrapItem")) {
            return 60;
        }
        if (s.equals("item.pastasaladItem")) {
            return 50;
        }
        if (s.equals("item.potatosaladItem")) {
            return 40;
        }
        if (s.equals("item.chocolatepeanutsItem")) {
            return 10;
        }
        if (s.equals("item.pumpkinbreadItem")) {
            return 30;
        }
        if (s.equals("item.scrambledeggsItem")) {
            return 20;
        }
        if (s.equals("item.omeletItem")) {
            return 40;
        }
        if (s.equals("item.sushiItem")) {
            return 20;
        }
        if (s.equals("item.porkfriedriceItem")) {
            return 50;
        }
        if (s.equals("item.fiestariceItem")) {
            return 30;
        }
        if (s.equals("item.stuffedpepperItem")) {
            return 40;
        }
        if (s.equals("item.beansandriceItem")) {
            return 60;
        }
        if (s.equals("item.ricecakeItem")) {
            return 20;
        }
        if (s.equals("item.beanburritoItem")) {
            return 40;
        }
        if (s.equals("item.chiliItem")) {
            return 60;
        }
        if (s.equals("item.bakedbeansItem")) {
            return 50;
        }
        if (s.equals("item.supremepizzaItem")) {
            return 70;
        }
        if (s.equals("item.ricesoupItem")) {
            return 30;
        }
        if (s.equals("item.veggiestirfryItem")) {
            return 70;
        }
        if (s.equals("item.carrotpilafItem")) {
            return 40;
        }
        if (s.equals("item.cornricemedleyItem")) {
            return 40;
        }
        if (s.equals("item.mushroomrisottoItem")) {
            return 40;
        }
        if (s.equals("item.refriedbeansItem")) {
            return 40;
        }
        if (s.equals("item.batterItem")) {
            return 20;
        }
        if (s.equals("item.syrupItem")) {
            return 20;
        }
        if (s.equals("item.berrysyrupItem")) {
            return 20;
        }
        if (s.equals("item.wafflesItem")) {
            return 30;
        }
        if (s.equals("item.fancywafflesItem")) {
            return 50;
        }
        if (s.equals("item.pancakesItem")) {
            return 30;
        }
        if (s.equals("item.fancypancakesItem")) {
            return 50;
        }
        if (s.equals("item.frenchtoastItem")) {
            return 40;
        }
        if (s.equals("item.berrysaladItem")) {
            return 70;
        }
        if (s.equals("item.blueberrymuffinsItem")) {
            return 40;
        }
        if (s.equals("item.raspberrytartItem")) {
            return 40;
        }
        if (s.equals("item.blackberrycobblerItem")) {
            return 40;
        }
        if (s.equals("item.peachcobblerItem")) {
            return 40;
        }
        if (s.equals("item.cherrypieItem")) {
            return 40;
        }
        if (s.equals("item.lemonpieItem")) {
            return 40;
        }
        if (s.equals("item.bananasplitItem")) {
            return 70;
        }
        if (s.equals("item.toastedcoconutItem")) {
            return 20;
        }
        if (s.equals("item.fruitsaladItem")) {
            return 80;
        }
        if (s.equals("item.fruitjuiceItem")) {
            return 30;
        }
        if (s.equals("item.lemonaideItem")) {
            return 40;
        }
        if (s.equals("item.friedeggplantItem")) {
            return 20;
        }
        if (s.equals("item.eggplantparmItem")) {
            return 40;
        }
        if (s.equals("item.stuffedeggplantItem")) {
            return 60;
        }
        if (s.equals("item.teaItem")) {
            return 20;
        }
        if (s.equals("item.raspberryicedteaItem")) {
            return 40;
        }
        if (s.equals("item.chaiteaItem")) {
            return 30;
        }
        if (s.equals("item.coffeeItem")) {
            return 20;
        }
        if (s.equals("item.mochaicecreamItem")) {
            return 40;
        }
        if (s.equals("item.espressoItem")) {
            return 40;
        }
        if (s.equals("item.pickledbeetsItem")) {
            return 30;
        }
        if (s.equals("item.beetsaladItem")) {
            return 50;
        }
        if (s.equals("item.beetsoupItem")) {
            return 40;
        }
        if (s.equals("item.broccolimacItem")) {
            return 50;
        }
        if (s.equals("item.broccolindipItem")) {
            return 30;
        }
        if (s.equals("item.creamedbroccolisoupItem")) {
            return 40;
        }
        if (s.equals("item.grilledsweetpotatoItem")) {
            return 20;
        }
        if (s.equals("item.sweetpotatopieItem")) {
            return 50;
        }
        if (s.equals("item.candiedsweetpotatoesItem")) {
            return 30;
        }
        if (s.equals("item.marshmellowsItem")) {
            return 20;
        }
        if (s.equals("item.splitpeasoupItem")) {
            return 40;
        }
        if (s.equals("item.pineapplehamItem")) {
            return 50;
        }
        if (s.equals("item.turnipsoupItem")) {
            return 40;
        }
        if (s.equals("item.banananutbreadItem")) {
            return 40;
        }
        if (s.equals("item.breadedchickenItem")) {
            return 30;
        }
        if (s.equals("item.chickenparmItem")) {
            return 50;
        }
        if (s.equals("item.chickensandwichItem")) {
            return 60;
        }
        if (s.equals("item.chickennoodlesoupItem")) {
            return 60;
        }
        if (s.equals("item.hamburgerItem")) {
            return 60;
        }
        if (s.equals("item.cheeseburgerItem")) {
            return 70;
        }
        if (s.equals("item.baconcheeseburgerItem")) {
            return 80;
        }
        if (s.equals("item.spagettiandmeatballsItem")) {
            return 70;
        }
        if (s.equals("item.curryriceItem")) {
            return 30;
        }
        if (s.equals("item.donutItem")) {
            return 20;
        }
        if (s.equals("item.chocolatedonutItem")) {
            return 40;
        }
        if (s.equals("item.powdereddonutItem")) {
            return 30;
        }
        if (s.equals("item.jellydonutItem")) {
            return 40;
        }
        if (s.equals("item.frosteddonutItem")) {
            return 40;
        }
        if (s.equals("item.seedsoupItem")) {
            return 1;
        }
        if (s.equals("item.oliveoilItem")) {
            return 20;
        }
        if (s.equals("item.tomatoseedItem")) {
            return 0;
        }
        if (s.equals("item.potatoseedItem")) {
            return 0;
        }
        if (s.equals("item.lettuceseedItem")) {
            return 0;
        }
        if (s.equals("item.onionseedItem")) {
            return 0;
        }
        if (s.equals("item.carrotseedItem")) {
            return 0;
        }
        if (s.equals("item.cornseedItem")) {
            return 0;
        }
        if (s.equals("item.strawberryseedItem")) {
            return 0;
        }
        if (s.equals("item.grapeseedItem")) {
            return 0;
        }
        if (s.equals("item.peanutseedItem")) {
            return 0;
        }
        if (s.equals("item.cucumberseedItem")) {
            return 0;
        }
        if (s.equals("item.spiceseedItem")) {
            return 0;
        }
        if (s.equals("item.riceseedItem")) {
            return 0;
        }
        if (s.equals("item.beansseedItem")) {
            return 0;
        }
        if (s.equals("item.bellpepperseedItem")) {
            return 0;
        }
        if (s.equals("item.eggplantseedItem")) {
            return 0;
        }
        if (s.equals("item.teaseedItem")) {
            return 0;
        }
        if (s.equals("item.coffeeseedItem")) {
            return 0;
        }
        if (s.equals("item.beetseedItem")) {
            return 0;
        }
        if (s.equals("item.broccoliseedItem")) {
            return 0;
        }
        if (s.equals("item.sweetpotatoseedItem")) {
            return 0;
        }
        if (s.equals("item.peasseedItem")) {
            return 0;
        }
        if (s.equals("item.pineappleseedItem")) {
            return 0;
        }
        if (s.equals("item.turnipseedItem")) {
            return 0;
        }
        if (s.equals("item.blueberryseedItem")) {
            return 0;
        }
        if (s.equals("item.blackberryseedItem")) {
            return 0;
        }
        if (s.equals("item.raspberryseedItem")) {
            return 0;
        }
        if (s.equals("item.kiwiseedItem")) {
            return 0;
        }
        if (s.equals("item.tomatoItem")) {
            return 5;
        }
        if (s.equals("item.potatoItem")) {
            return 5;
        }
        if (s.equals("item.lettuceItem")) {
            return 5;
        }
        if (s.equals("item.onionItem")) {
            return 5;
        }
        if (s.equals("item.carrotItem")) {
            return 5;
        }
        if (s.equals("item.cornItem")) {
            return 5;
        }
        if (s.equals("item.strawberryItem")) {
            return 5;
        }
        if (s.equals("item.grapeItem")) {
            return 5;
        }
        if (s.equals("item.peanutItem")) {
            return 5;
        }
        if (s.equals("item.cucumberItem")) {
            return 5;
        }
        if (s.equals("item.peppercornItem")) {
            return 5;
        }
        if (s.equals("item.riceItem")) {
            return 5;
        }
        if (s.equals("item.beansItem")) {
            return 5;
        }
        if (s.equals("item.bellpepperItem")) {
            return 5;
        }
        if (s.equals("item.eggplantItem")) {
            return 5;
        }
        if (s.equals("item.tealeafItem")) {
            return 5;
        }
        if (s.equals("item.coffeebeanItem")) {
            return 5;
        }
        if (s.equals("item.beetItem")) {
            return 5;
        }
        if (s.equals("item.broccoliItem")) {
            return 5;
        }
        if (s.equals("item.sweetpotatoItem")) {
            return 5;
        }
        if (s.equals("item.peasItem")) {
            return 5;
        }
        if (s.equals("item.pineappleItem")) {
            return 5;
        }
        if (s.equals("item.turnipItem")) {
            return 5;
        }
        if (s.equals("item.bananaItem")) {
            return 20;
        }
        if (s.equals("item.cherryItem")) {
            return 20;
        }
        if (s.equals("item.coconutItem")) {
            return 20;
        }
        if (s.equals("item.lemonItem")) {
            return 20;
        }
        if (s.equals("item.orangeItem")) {
            return 20;
        }
        if (s.equals("item.peachItem")) {
            return 20;
        }
        if (s.equals("item.limeItem")) {
            return 20;
        }
        if (s.equals("item.mangoItem")) {
            return 20;
        }
        if (s.equals("item.walnutItem")) {
            return 20;
        }
        if (s.equals("item.pearItem")) {
            return 20;
        }
        if (s.equals("item.plumItem")) {
            return 20;
        }
        if (s.equals("item.oliveItem")) {
            return 20;
        }
        if (s.equals("item.cinnamonItem")) {
            return 20;
        }
        if (s.equals("item.cocoabeanpodItem")) {
            return 20;
        }
        if (s.equals("item.blueberryItem")) {
            return 5;
        }
        if (s.equals("item.blackberryItem")) {
            return 5;
        }
        if (s.equals("item.raspberryItem")) {
            return 5;
        }
        if (s.equals("item.kiwiItem")) {
            return 5;
        }
        if (s.equals("item.tinoreItem")) {
            return 20;
        }
        if (s.equals("item.copperoreItem")) {
            return 20;
        }
        if (s.equals("item.silveroreItem")) {
            return 80;
        }
        if (s.equals("item.cobaltoreItem")) {
            return 100;
        }
        if (s.equals("item.platinumoreItem")) {
            return 300;
        }
        if (s.equals("item.titaniumoreItem")) {
            return 300;
        }
        if (s.equals("item.mithriloreItem")) {
            return 400;
        }
        if (s.equals("item.quartzgemItem")) {
            return 30;
        }
        if (s.equals("item.citrinegemItem")) {
            return 30;
        }
        if (s.equals("item.tanzanitegemItem")) {
            return 30;
        }
        if (s.equals("item.sapphiregemItem")) {
            return 30;
        }
        if (s.equals("item.topazgemItem")) {
            return 30;
        }
        if (s.equals("item.agategemItem")) {
            return 30;
        }
        if (s.equals("item.garnetgemItem")) {
            return 30;
        }
        if (s.equals("item.hematitegemItem")) {
            return 30;
        }
        if (s.equals("item.moonstonegemItem")) {
            return 30;
        }
        if (s.equals("item.aquamarinegemItem")) {
            return 30;
        }
        if (s.equals("item.amethystgemItem")) {
            return 30;
        }
        if (s.equals("item.tigerseyegemItem")) {
            return 30;
        }
        if (s.equals("item.emeraldgemItem")) {
            return 30;
        }
        if (s.equals("item.rubygemItem")) {
            return 30;
        }
        if (s.equals("item.onyxgemItem")) {
            return 30;
        }
        if (s.equals("item.tiningotItem")) {
            return 25;
        }
        if (s.equals("item.copperingotItem")) {
            return 25;
        }
        if (s.equals("item.silveringotItem")) {
            return 85;
        }
        if (s.equals("item.cobaltingotItem")) {
            return 105;
        }
        if (s.equals("item.platinumingotItem")) {
            return 305;
        }
        if (s.equals("item.titaniumingotItem")) {
            return 305;
        }
        if (s.equals("item.mithrilingotItem")) {
            return 405;
        }
        if (s.equals("item.bronzealloyItem")) {
            return 50;
        }
        if (s.equals("item.steelalloyItem")) {
            return 220;
        }
        if (s.equals("item.bronzeingotItem")) {
            return 55;
        }
        if (s.equals("item.steelingotItem")) {
            return 225;
        }
        if (s.equals("item.copperPick")) {
            return 77;
        }
        if (s.equals("item.copperShovel")) {
            return 27;
        }
        if (s.equals("item.copperAxe")) {
            return 77;
        }
        if (s.equals("item.copperHoe")) {
            return 52;
        }
        if (s.equals("item.copperSword")) {
            return 51;
        }
        if (s.equals("item.copperHelm")) {
            return 125;
        }
        if (s.equals("item.copperChest")) {
            return 200;
        }
        if (s.equals("item.copperLegs")) {
            return 175;
        }
        if (s.equals("item.copperBoots")) {
            return 100;
        }
        if (s.equals("item.tinPick")) {
            return 77;
        }
        if (s.equals("item.tinShovel")) {
            return 27;
        }
        if (s.equals("item.tinAxe")) {
            return 77;
        }
        if (s.equals("item.tinHoe")) {
            return 52;
        }
        if (s.equals("item.tinSword")) {
            return 51;
        }
        if (s.equals("item.tinHelm")) {
            return 125;
        }
        if (s.equals("item.tinChest")) {
            return 200;
        }
        if (s.equals("item.tinLegs")) {
            return 175;
        }
        if (s.equals("item.tinBoots")) {
            return 100;
        }
        if (s.equals("item.bronzePick")) {
            return 167;
        }
        if (s.equals("item.bronzeShovel")) {
            return 57;
        }
        if (s.equals("item.bronzeAxe")) {
            return 167;
        }
        if (s.equals("item.bronzeHoe")) {
            return 112;
        }
        if (s.equals("item.bronzeSword")) {
            return 111;
        }
        if (s.equals("item.bronzeHelm")) {
            return 275;
        }
        if (s.equals("item.bronzeChest")) {
            return 440;
        }
        if (s.equals("item.bronzeLegs")) {
            return 385;
        }
        if (s.equals("item.bronzeBoots")) {
            return 220;
        }
        if (s.equals("item.silverPick")) {
            return 257;
        }
        if (s.equals("item.silverShovel")) {
            return 87;
        }
        if (s.equals("item.silverAxe")) {
            return 257;
        }
        if (s.equals("item.silverHoe")) {
            return 172;
        }
        if (s.equals("item.silverSword")) {
            return 171;
        }
        if (s.equals("item.silverHelm")) {
            return 425;
        }
        if (s.equals("item.silverChest")) {
            return 680;
        }
        if (s.equals("item.silverLegs")) {
            return 595;
        }
        if (s.equals("item.silverBoots")) {
            return 340;
        }
        if (s.equals("item.cobaltPick")) {
            return 317;
        }
        if (s.equals("item.cobaltShovel")) {
            return 107;
        }
        if (s.equals("item.cobaltAxe")) {
            return 317;
        }
        if (s.equals("item.cobaltHoe")) {
            return 212;
        }
        if (s.equals("item.cobaltSword")) {
            return 211;
        }
        if (s.equals("item.cobaltHelm")) {
            return 525;
        }
        if (s.equals("item.cobaltChest")) {
            return 840;
        }
        if (s.equals("item.cobaltLegs")) {
            return 735;
        }
        if (s.equals("item.cobaltBoots")) {
            return 420;
        }
        if (s.equals("item.steelPick")) {
            return 677;
        }
        if (s.equals("item.steelShovel")) {
            return 257;
        }
        if (s.equals("item.steelAxe")) {
            return 677;
        }
        if (s.equals("item.steelHoe")) {
            return 512;
        }
        if (s.equals("item.steelSword")) {
            return 511;
        }
        if (s.equals("item.steelHelm")) {
            return 1275;
        }
        if (s.equals("item.steelChest")) {
            return 1800;
        }
        if (s.equals("item.steelLegs")) {
            return 1575;
        }
        if (s.equals("item.steelBoots")) {
            return 900;
        }
        if (s.equals("item.platinumPick")) {
            return 917;
        }
        if (s.equals("item.platinumShovel")) {
            return 307;
        }
        if (s.equals("item.platinumAxe")) {
            return 917;
        }
        if (s.equals("item.platinumHoe")) {
            return 612;
        }
        if (s.equals("item.platinumSword")) {
            return 611;
        }
        if (s.equals("item.platinumHelm")) {
            return 1525;
        }
        if (s.equals("item.platinumChest")) {
            return 2440;
        }
        if (s.equals("item.platinumLegs")) {
            return 2135;
        }
        if (s.equals("item.platinumBoots")) {
            return 1220;
        }
        if (s.equals("item.titaniumPick")) {
            return 917;
        }
        if (s.equals("item.titaniumShovel")) {
            return 307;
        }
        if (s.equals("item.titaniumAxe")) {
            return 917;
        }
        if (s.equals("item.titaniumHoe")) {
            return 612;
        }
        if (s.equals("item.titaniumSword")) {
            return 611;
        }
        if (s.equals("item.titaniumHelm")) {
            return 1525;
        }
        if (s.equals("item.titaniumChest")) {
            return 2440;
        }
        if (s.equals("item.titaniumLegs")) {
            return 2135;
        }
        if (s.equals("item.titaniumBoots")) {
            return 1220;
        }
        if (s.equals("item.mithrilPick")) {
            return 1217;
        }
        if (s.equals("item.mithrilShovel")) {
            return 407;
        }
        if (s.equals("item.mithrilAxe")) {
            return 1217;
        }
        if (s.equals("item.mithrilHoe")) {
            return 812;
        }
        if (s.equals("item.mithrilSword")) {
            return 811;
        }
        if (s.equals("item.mithrilHelm")) {
            return 2025;
        }
        if (s.equals("item.mithrilChest")) {
            return 3240;
        }
        if (s.equals("item.mithrilLegs")) {
            return 2835;
        }
        if (s.equals("item.mithrilBoots")) {
            return 1620;
        }
        if (s.equals("item.blackstonePick")) {
            return 17;
        }
        if (s.equals("item.blackstoneShovel")) {
            return 8;
        }
        if (s.equals("item.blackstoneAxe")) {
            return 17;
        }
        if (s.equals("item.blackstoneHoe")) {
            return 12;
        }
        if (s.equals("item.blackstoneSword")) {
            return 12;
        }
        if (s.equals("item.redstonePick")) {
            return 17;
        }
        if (s.equals("item.redstoneShovel")) {
            return 8;
        }
        if (s.equals("item.redstoneAxe")) {
            return 17;
        }
        if (s.equals("item.redstoneHoe")) {
            return 12;
        }
        if (s.equals("item.redstoneSword")) {
            return 12;
        }
        if (s.equals("item.greenstonePick")) {
            return 17;
        }
        if (s.equals("item.greenstoneShovel")) {
            return 8;
        }
        if (s.equals("item.greenstoneAxe")) {
            return 17;
        }
        if (s.equals("item.greenstoneHoe")) {
            return 12;
        }
        if (s.equals("item.greenstoneSword")) {
            return 12;
        }
        if (s.equals("item.brownstonePick")) {
            return 17;
        }
        if (s.equals("item.brownstoneShovel")) {
            return 8;
        }
        if (s.equals("item.brownstoneAxe")) {
            return 17;
        }
        if (s.equals("item.brownstoneHoe")) {
            return 12;
        }
        if (s.equals("item.brownstoneSword")) {
            return 12;
        }
        if (s.equals("item.bluestonePick")) {
            return 17;
        }
        if (s.equals("item.bluestoneShovel")) {
            return 8;
        }
        if (s.equals("item.bluestoneAxe")) {
            return 17;
        }
        if (s.equals("item.bluestoneHoe")) {
            return 12;
        }
        if (s.equals("item.bluestoneSword")) {
            return 12;
        }
        if (s.equals("item.purplestonePick")) {
            return 17;
        }
        if (s.equals("item.purplestoneShovel")) {
            return 8;
        }
        if (s.equals("item.purplestoneAxe")) {
            return 17;
        }
        if (s.equals("item.purplestoneHoe")) {
            return 12;
        }
        if (s.equals("item.purplestoneSword")) {
            return 12;
        }
        if (s.equals("item.cyanstonePick")) {
            return 17;
        }
        if (s.equals("item.cyanstoneShovel")) {
            return 8;
        }
        if (s.equals("item.cyanstoneAxe")) {
            return 17;
        }
        if (s.equals("item.cyanstoneHoe")) {
            return 12;
        }
        if (s.equals("item.cyanstoneSword")) {
            return 12;
        }
        if (s.equals("item.lightgreystonePick")) {
            return 17;
        }
        if (s.equals("item.lightgreystoneShovel")) {
            return 8;
        }
        if (s.equals("item.lightgreystoneAxe")) {
            return 17;
        }
        if (s.equals("item.lightgreystoneHoe")) {
            return 12;
        }
        if (s.equals("item.lightgreystoneSword")) {
            return 12;
        }
        if (s.equals("item.greystonePick")) {
            return 17;
        }
        if (s.equals("item.greystoneShovel")) {
            return 8;
        }
        if (s.equals("item.greystoneAxe")) {
            return 17;
        }
        if (s.equals("item.greystoneHoe")) {
            return 12;
        }
        if (s.equals("item.greystoneSword")) {
            return 12;
        }
        if (s.equals("item.pinkstonePick")) {
            return 17;
        }
        if (s.equals("item.pinkstoneShovel")) {
            return 8;
        }
        if (s.equals("item.pinkstoneAxe")) {
            return 17;
        }
        if (s.equals("item.pinkstoneHoe")) {
            return 12;
        }
        if (s.equals("item.pinkstoneSword")) {
            return 12;
        }
        if (s.equals("item.limestonePick")) {
            return 17;
        }
        if (s.equals("item.limestoneShovel")) {
            return 8;
        }
        if (s.equals("item.limestoneAxe")) {
            return 17;
        }
        if (s.equals("item.limestoneHoe")) {
            return 12;
        }
        if (s.equals("item.limestoneSword")) {
            return 12;
        }
        if (s.equals("item.yellowstonePick")) {
            return 17;
        }
        if (s.equals("item.yellowstoneShovel")) {
            return 8;
        }
        if (s.equals("item.yellowstoneAxe")) {
            return 17;
        }
        if (s.equals("item.yellowstoneHoe")) {
            return 12;
        }
        if (s.equals("item.yellowstoneSword")) {
            return 2;
        }
        if (s.equals("item.lightbluestonePick")) {
            return 17;
        }
        if (s.equals("item.lightbluestoneShovel")) {
            return 8;
        }
        if (s.equals("item.lightbluestoneAxe")) {
            return 17;
        }
        if (s.equals("item.lightbluestoneHoe")) {
            return 12;
        }
        if (s.equals("item.lightbluestoneSword")) {
            return 12;
        }
        if (s.equals("item.magentastonePick")) {
            return 17;
        }
        if (s.equals("item.magentastoneShovel")) {
            return 8;
        }
        if (s.equals("item.magentastoneAxe")) {
            return 17;
        }
        if (s.equals("item.magentastoneHoe")) {
            return 12;
        }
        if (s.equals("item.magentastoneSword")) {
            return 12;
        }
        if (s.equals("item.orangestonePick")) {
            return 17;
        }
        if (s.equals("item.orangestoneShovel")) {
            return 8;
        }
        if (s.equals("item.orangestoneAxe")) {
            return 17;
        }
        if (s.equals("item.orangestoneHoe")) {
            return 12;
        }
        if (s.equals("item.orangestoneSword")) {
            return 12;
        }
        if (s.equals("item.whitestonePick")) {
            return 17;
        }
        if (s.equals("item.whitestoneShovel")) {
            return 8;
        }
        if (s.equals("item.whitestoneAxe")) {
            return 17;
        }
        if (s.equals("item.whitestoneHoe")) {
            return 12;
        }
        if (s.equals("item.whitestoneSword")) {
            return 12;
        }
        if (s.equals("item.HorseSaddle")) {
            return 330;
        }
        if (s.equals("item.sharkegg")) {
            return 110;
        }
        if (s.equals("item.sharkteeth")) {
            return 75;
        }
        if (s.equals("item.HayStack")) {
            return 45;
        }
        if (s.equals("item.SugarLump")) {
            return 15;
        }
        if (s.equals("item.fishyegg")) {
            return 50;
        }
        if (s.equals("item.bigcatclaw")) {
            return 140;
        }
        if (s.equals("item.whip")) {
            return 355;
        }
        if (s.equals("item.medallion")) {
            return 180;
        }
        if (s.equals("item.kittybed")) {
            return 95;
        }
        if (s.equals("item.litterbox")) {
            return 30;
        }
        if (s.equals("item.woolball")) {
            return 25;
        }
        if (s.equals("item.rope")) {
            return 375;
        }
        if (s.equals("item.petfood")) {
            return 20;
        }
        if (s.equals("item.crochide")) {
            return 120;
        }
        if (s.equals("item.plateCroc")) {
            return 960;
        }
        if (s.equals("item.helmetCroc")) {
            return 600;
        }
        if (s.equals("item.legsCroc")) {
            return 840;
        }
        if (s.equals("item.bootsCroc")) {
            return 480;
        }
        if (s.equals("tile.Bronze Block")) {
            return 405;
        }
        if (s.equals("tile.Bronze Ore")) {
            return 40;
        }
        if (s.equals("tile.Steel Block")) {
            return 1440;
        }
        if (s.equals("tile.Titanium Ore")) {
            return 100;
        }
        if (s.equals("tile.Titanium Wall")) {
            return 150;
        }
        if (s.equals("tile.Ruthenium Ore")) {
            return 470;
        }
        if (s.equals("tile.Ruthenium Block")) {
            return 4320;
        }
        if (s.equals("tile.Platinum Ore")) {
            return 590;
        }
        if (s.equals("tile.Platinum Block")) {
            return 5400;
        }
        if (s.equals("tile.Colored Glass")) {
            return 5;
        }
        if (s.equals("tile.Colored Plank")) {
            return 5;
        }
        if (s.equals("item.Bronze Sword")) {
            return 80;
        }
        if (s.equals("item.Bronze Pickaxe")) {
            return 125;
        }
        if (s.equals("item.Bronze Shovel")) {
            return 45;
        }
        if (s.equals("item.Bronze Axe")) {
            return 125;
        }
        if (s.equals("item.Bronze Hoe")) {
            return 145;
        }
        if (s.equals("item.Bronze Warhammer")) {
            return 400;
        }
        if (s.equals("item.Bronze Battleaxe")) {
            return 360;
        }
        if (s.equals("item.Steel Sword")) {
            return 320;
        }
        if (s.equals("item.Steel Pickaxe")) {
            return 480;
        }
        if (s.equals("item.Steel Shovel")) {
            return 165;
        }
        if (s.equals("item.Steel Axe")) {
            return 480;
        }
        if (s.equals("item.Steel Hoe")) {
            return 320;
        }
        if (s.equals("item.Steel Warhammer")) {
            return 1280;
        }
        if (s.equals("item.Steel Battleaxe")) {
            return 1440;
        }
        if (s.equals("item.Titanium Sword")) {
            return 760;
        }
        if (s.equals("item.Titanium Pickaxe")) {
            return 1140;
        }
        if (s.equals("item.Titanium Shovel")) {
            return 385;
        }
        if (s.equals("item.Titanium Axe")) {
            return 1140;
        }
        if (s.equals("item.Titanium Hoe")) {
            return 760;
        }
        if (s.equals("item.Titanium Warhammer")) {
            return 3040;
        }
        if (s.equals("item.Titanium Battleaxe")) {
            return 3420;
        }
        if (s.equals("item.Ruthenium Sword")) {
            return 960;
        }
        if (s.equals("item.Ruthenium Pickaxe")) {
            return 1440;
        }
        if (s.equals("item.Ruthenium Shovel")) {
            return 485;
        }
        if (s.equals("item.Ruthenium Axe")) {
            return 1440;
        }
        if (s.equals("item.Ruthenium Hoe")) {
            return 960;
        }
        if (s.equals("item.Ruthenium Warhammer")) {
            return 3840;
        }
        if (s.equals("item.Ruthenium Battleaxe")) {
            return 4320;
        }
        if (s.equals("item.Platinum Sword")) {
            return 1200;
        }
        if (s.equals("item.Platinum Pickaxe")) {
            return 1800;
        }
        if (s.equals("item.Platinum Shovel")) {
            return 610;
        }
        if (s.equals("item.Platinum Axe")) {
            return 1800;
        }
        if (s.equals("item.Platinum Hoe")) {
            return 1200;
        }
        if (s.equals("item.Platinum Warhammer")) {
            return 4800;
        }
        if (s.equals("item.Platinum Battleaxe")) {
            return 5400;
        }
        if (s.equals("item.Bronze Ingot")) {
            return 45;
        }
        if (s.equals("item.Bronze Hammer")) {
            return 225;
        }
        if (s.equals("item.Bronze Hammerhead")) {
            return 270;
        }
        if (s.equals("item.Bronze Axehead")) {
            return 315;
        }
        if (s.equals("item.Steel Ingot")) {
            return 160;
        }
        if (s.equals("item.Steel Hammer")) {
            return 800;
        }
        if (s.equals("item.Steel Hammerhead")) {
            return 960;
        }
        if (s.equals("item.Steel Axehead")) {
            return 1120;
        }
        if (s.equals("item.Refined Steel Chunk")) {
            return 80;
        }
        if (s.equals("item.Steel Chunk")) {
            return 40;
        }
        if (s.equals("item.Titanium Ingot")) {
            return 380;
        }
        if (s.equals("item.Titanium Hammer")) {
            return 1900;
        }
        if (s.equals("item.Titanium Hammerhead")) {
            return 2200;
        }
        if (s.equals("item.Titanium Axehead")) {
            return 2600;
        }
        if (s.equals("item.Titanium")) {
            return 100;
        }
        if (s.equals("item.Ruthenium Ingot")) {
            return 480;
        }
        if (s.equals("item.Ruthenium Hammerhead")) {
            return 2880;
        }
        if (s.equals("item.Ruthenium Axehead")) {
            return 3360;
        }
        if (s.equals("item.Platinum Ingot")) {
            return 600;
        }
        if (s.equals("item.Platinum Hammerhead")) {
            return 3600;
        }
        if (s.equals("item.Platinum Axehead")) {
            return 4200;
        }
        if (s.equals("item.Bronze Helmet")) {
            return 225;
        }
        if (s.equals("item.Bronze Chestplate")) {
            return 360;
        }
        if (s.equals("item.Bronze Leggings")) {
            return 315;
        }
        if (s.equals("item.Bronze Boots")) {
            return 180;
        }
        if (s.equals("item.Steel Helmet")) {
            return 800;
        }
        if (s.equals("item.Steel Chestplate")) {
            return 1280;
        }
        if (s.equals("item.Steel Leggings")) {
            return 1120;
        }
        if (s.equals("item.Steel Boots")) {
            return 640;
        }
        if (s.equals("item.Ruthenium Helmet")) {
            return 2400;
        }
        if (s.equals("item.Ruthenium Chestplate")) {
            return 3840;
        }
        if (s.equals("item.Ruthenium Leggings")) {
            return 3360;
        }
        if (s.equals("item.Ruthenium Boots")) {
            return 1920;
        }
        if (s.equals("item.Platinum Helmet")) {
            return 3000;
        }
        if (s.equals("item.Platinum Chestplate")) {
            return 4800;
        }
        if (s.equals("item.Platinum Leggings")) {
            return 4200;
        }
        if (s.equals("item.Platinum Boots")) {
            return 2400;
        }
        if (s.equals("item.eggArrow")) {
            return 50;
        }
        if (s.equals("item.expArrow")) {
            return 100;
        }
        if (s.equals("item.firArrow")) {
            return 15;
        }
        if (s.equals("item.homBow")) {
            return 3000;
        }
        if (s.equals("item.iceArrow")) {
            return 150;
        }
        if (s.equals("item.ligArrow")) {
            return 75;
        }
        if (s.equals("item.BlorpCola")) {
            return 50;
        }
        if (s.equals("item.BandAid")) {
            return 240;
        }
        if (s.equals("item.GooDonut")) {
            return 140;
        }
        if (s.equals("item.Money")) {
            return 10;
        }
        if (s.equals("item.RayGun")) {
            return 1920;
        }
        if (s.equals("item.Frisbee")) {
            return 400;
        }
        if (s.equals("item.RayRay")) {
            return 0;
        }
        if (s.equals("item.GuineaPigRadio")) {
            return 125;
        }
        if (s.equals("item.EvilEgg")) {
            return 200;
        }
        if (s.equals("item.Rocket")) {
            return 95;
        }
        if (s.equals("item.HellAchievement")) {
            return 0;
        }
        if (s.equals("item.GuineaPigAchievement")) {
            return 0;
        }
        if (s.equals("item.PyramidAchievement")) {
            return 0;
        }
        if (s.equals("item.FloobicideAchievement")) {
            return 0;
        }
        if (s.equals("item.FloobicideAchievement")) {
            return 0;
        }
        if (s.equals("item.AtomPacket")) {
            return 300;
        }
        if (s.equals("item.16KRAM")) {
            return 150;
        }
        if (s.equals("item.Battery")) {
            return 150;
        }
        if (s.equals("item.BubbleAchievement")) {
            return 0;
        }
        if (s.equals("item.HotdogAchievement")) {
            return 0;
        }
        if (s.equals("item.CamelAchievement")) {
            return 0;
        }
        if (s.equals("item.HorseHeadGem")) {
            return 1140;
        }
        if (s.equals("item.ArmyGem")) {
            return 2140;
        }
        if (s.equals("item.Gun")) {
            return 1140;
        }
        if (s.equals("item.Bullet")) {
            return 0;
        }
        if (s.equals("item.LifeGem")) {
            return 364;
        }
        if (s.equals("item.Lolly")) {
            return 50;
        }
        if (s.equals("item.ShrinkRay")) {
            return 1890;
        }
        if (s.equals("item.ShrinkShrink")) {
            return 0;
        }
        if (s.equals("item.ArmSword")) {
            return 450;
        }
        if (s.equals("item.Limbs")) {
            return 50;
        }
        if (s.equals("item.BabyJarEmpty")) {
            return 327;
        }
        if (s.equals("item.BabyJarFull")) {
            return 1150;
        }
        if (s.equals("item.Donut")) {
            return 85;
        }
        if (s.equals("item.MobilePhone")) {
            return 0;
        }
        if (s.equals("item.Extinguisher")) {
            return 1920;
        }
        if (s.equals("item.ZebraAchievement")) {
            return 0;
        }
        if (s.equals("item.NonswimmerAchievement")) {
            return 0;
        }
        if (s.equals("item.GrowRay")) {
            return 2670;
        }
        if (s.equals("item.Zebra Helmet")) {
            return 600;
        }
        if (s.equals("item.Zebra Body")) {
            return 960;
        }
        if (s.equals("item.Zebra Legs")) {
            return 840;
        }
        if (s.equals("item.Zebra Boots")) {
            return 480;
        }
        if (s.equals("item.ZebraHide")) {
            return 120;
        }
        if (s.equals("tile.ml_stone_deco")) {
            return 8000;
        }
        if (s.equals("tile.ml_earth_deco")) {
            return 150;
        }
        if (s.equals("tile.ml_wood_deco")) {
            return 150;
        }
        if (s.equals("tile.ml_panel")) {
            return 96;
        }
        if (s.equals("tile.ml_building")) {
            return 0;
        }
        if (s.equals("tile.TFFirefly")) {
            return 30;
        }
        if (s.equals("tile.TFCicada")) {
            return 30;
        }
        if (s.equals("tile.TFPortal")) {
            return 0;
        }
        if (s.equals("tile.TFLog")) {
            return 3;
        }
        if (s.equals("tile.TFLeaves")) {
            return 2;
        }
        if (s.equals("tile.TFMazestone")) {
            return 2;
        }
        if (s.equals("tile.TFHedge")) {
            return 2;
        }
        if (s.equals("item.recipeBook")) {
            return 30;
        }
        if (s.equals("item.Heart Container")) {
            return 200;
        }
        if (s.equals("item.Heart Piece")) {
            return 50;
        }
        if (s.equals("item.ml_denier")) {
            return 3;
        }
        if (s.equals("item.ml_denier_or")) {
            return 150;
        }
        if (s.equals("item.ml_denier_argent")) {
            return 9000;
        }
        if (s.equals("item.ml_ciderapple")) {
            return 3;
        }
        if (s.equals("item.ml_cider")) {
            return 150;
        }
        if (s.equals("item.ml_calva")) {
            return 600;
        }
        if (s.equals("item.ml_tripes")) {
            return 300;
        }
        if (s.equals("item.ml_normanPickaxe")) {
            return 1500;
        }
        if (s.equals("item.ml_normanAxe")) {
            return 1500;
        }
        if (s.equals("item.ml_normanShovel")) {
            return 1500;
        }
        if (s.equals("item.ml_normanHoe")) {
            return 1500;
        }
        if (s.equals("item.ml_villageWand")) {
            return 16000;
        }
        if (s.equals("item.ml_normanBroadsword")) {
            return 150;
        }
        if (s.equals("item.ml_normanHelmet")) {
            return 1500;
        }
        if (s.equals("item.ml_normanPlate")) {
            return 3000;
        }
        if (s.equals("item.ml_normanLegs")) {
            return 1200;
        }
        if (s.equals("item.ml_normanBoots")) {
            return 750;
        }
        if (s.equals("item.ml_parchmentVillagers")) {
            return 30;
        }
        if (s.equals("item.ml_parchmentBuildings")) {
            return 30;
        }
        if (s.equals("item.ml_parchmentItems")) {
            return 30;
        }
        if (s.equals("item.ml_marchmentComplete")) {
            return 150;
        }
        if (s.equals("item.ml_boudin")) {
            return 150;
        }
        if (s.equals("item.ml_tapestry")) {
            return 750;
        }
        if (s.equals("item.ml_raven_amulet")) {
            return 4800;
        }
        if (s.equals("item.ml_dwarves_amulet")) {
            return 9000;
        }
        if (s.equals("item.ml_yddrasil_amulet")) {
            return 4800;
        }
        if (s.equals("item.ml_skoll_hati_amulet")) {
            return 9000;
        }
        if (s.equals("item.ml_parchmentVillageScroll")) {
            return 30;
        }
        if (s.equals("item.ml_rice")) {
            return 96;
        }
        if (s.equals("item.ml_turmeric")) {
            return 150;
        }
        if (s.equals("item.ml_vegcurry")) {
            return 250;
        }
        if (s.equals("item.ml_chickencurry")) {
            return 300;
        }
        if (s.equals("item.ml_brickmould")) {
            return 150;
        }
        if (s.equals("item.ml_rasgullaId")) {
            return 60;
        }
        if (s.equals("item.ml_indianstatue")) {
            return 750;
        }
        if (s.equals("item.ml_parchmentIndianVillagers")) {
            return 30;
        }
        if (s.equals("item.ml_parchmentIndianBuildings")) {
            return 30;
        }
        if (s.equals("item.ml_parchmentIndianItems")) {
            return 30;
        }
        if (s.equals("item.ml_marchmentIndianComplete")) {
            return 150;
        }
        if (s.equals("item.ml_mayanstatue")) {
            return 300;
        }
        if (s.equals("item.ml_maize")) {
            return 9;
        }
        if (s.equals("item.ml_wah")) {
            return 270;
        }
        if (s.equals("item.ml_masa")) {
            return 300;
        }
        if (s.equals("item.ml_parchmentMayanVillagers")) {
            return 30;
        }
        if (s.equals("item.ml_parchmentMayanBuildings")) {
            return 30;
        }
        if (s.equals("item.ml_parchmentMayanItems")) {
            return 30;
        }
        if (s.equals("item.ml_parchmentMayanComplete")) {
            return 150;
        }
        if (s.equals("item.ml_parchmentJapaneseVillagers")) {
            return 30;
        }
        if (s.equals("item.ml_parchmentJapaneseBuildings")) {
            return 30;
        }
        if (s.equals("item.ml_parchmentJapaneseItems")) {
            return 30;
        }
        if (s.equals("item.ml_parchmentJapaneseComplete")) {
            return 150;
        }
        if (s.equals("item.ml_parchmentSadhu")) {
            return 4000;
        }
        if (s.equals("item.Medallion")) {
            return 150;
        }
        if (s.equals("item.crystalWing")) {
            return 450;
        }
        if (s.equals("item.burningWing")) {
            return 30;
        }
        if (s.equals("item.burnedWing")) {
            return 10;
        }
        if (s.equals("item.bullet")) {
            return 30;
        }
        if (s.equals("item.musket")) {
            return 348;
        }
        if (s.equals("item.musket_wood_part")) {
            return 0;
        }
        if (s.equals("item.musket_iron_part")) {
            return 0;
        }
        if (s.equals("item.crossbow")) {
            return 594;
        }
        if (s.equals("item.bolt")) {
            return 22;
        }
        if (s.equals("item.dynamite")) {
            return 325;
        }
        if (s.equals("item.HorseSaddle")) {
            return 330;
        }
        if (s.equals("item.sharkegg")) {
            return 110;
        }
        if (s.equals("item.sharkteeth")) {
            return 75;
        }
        if (s.equals("item.HayStack")) {
            return 45;
        }
        if (s.equals("item.SugarLump")) {
            return 15;
        }
        if (s.equals("item.fishyegg")) {
            return 50;
        }
        if (s.equals("item.bigcatclaw")) {
            return 140;
        }
        if (s.equals("item.whip")) {
            return 355;
        }
        if (s.equals("item.medallion")) {
            return 180;
        }
        if (s.equals("item.kittybed")) {
            return 95;
        }
        if (s.equals("item.litterbox")) {
            return 30;
        }
        if (s.equals("item.woolball")) {
            return 25;
        }
        if (s.equals("item.rope")) {
            return 375;
        }
        if (s.equals("item.petfood")) {
            return 20;
        }
        if (s.equals("item.coins")) {
            return 0;
        }
        if (s.equals("item.Airship")) {
            return 3000;
        }
        if (s.equals("item.Engine")) {
            return 150;
        }
        if (s.equals("item.Balloon")) {
            return 800;
        }
        if (s.equals("item.null")) {
            return 0;
        }
        if (s.equals("item.Flag")) {
            return 9000;
        }
        if (s.equals("item.Hidden Blade")) {
            return 152;
        }
        if (s.equals("item.Journeyman's Blade")) {
            return 152;
        }
        if (s.equals("item.Ornate Blade")) {
            return 70;
        }
        if (s.equals("item.Broken Blade")) {
            return 30;
        }
        if (s.equals("item.Cleaver")) {
            return 88;
        }
        if (s.equals("item.Devouros")) {
            return 316;
        }
        if (s.equals("item.Gladios")) {
            return 324;
        }
        if (s.equals("item.Lich-Bane")) {
            return 365;
        }
        if (s.equals("item.Bastard Sword")) {
            return 408;
        }
        if (s.equals("item.Malaikah")) {
            return 416;
        }
        if (s.equals("item.Aquatos")) {
            return 562;
        }
        if (s.equals("item.Infernos")) {
            return 564;
        }
        if (s.equals("item.Epachos")) {
            return 583;
        }
        if (s.equals("item.Solanis")) {
            return 600;
        }
        if (s.equals("item.Lunos")) {
            return 634;
        }
        if (s.equals("item.Mortis")) {
            return 677;
        }
        if (s.equals("item.Katana")) {
            return 680;
        }
        if (s.equals("item.Shield 1")) {
            return 300;
        }
        if (s.equals("item.Shield 2")) {
            return 300;
        }
        if (s.equals("item.Shield 3")) {
            return 300;
        }
        if (s.equals("item.Shield 4")) {
            return 300;
        }
        if (s.equals("item.Shield 5")) {
            return 300;
        }
        if (s.equals("item.Shield 6")) {
            return 300;
        }
        if (s.equals("item.Shield 7")) {
            return 300;
        }
        if (s.equals("item.Shield 8")) {
            return 300;
        }
        if (s.equals("item.Bratwurst")) {
            return 16;
        }
        if (s.equals("item.Super Cookie")) {
            return 26;
        }
        if (s.equals("item.Weiner")) {
            return 12;
        }
        if (s.equals("item.Alignment Checker")) {
            return 56;
        }
        if (s.equals("item.Fresh Bread")) {
            return 6;
        }
        if (s.equals("item.Potato")) {
            return 6;
        }
        if (s.equals("item.Rope!")) {
            return 24;
        }
        if (s.equals("item.nagaScale")) {
            return 10000;
        }
        if (s.equals("item.bowlSoupBitter")) {
            return 3;
        }
        if (s.equals("item.vinesStrand")) {
            return 1;
        }
        if (s.equals("item.TrainingTreat")) {
            return 50;
        }
        if (s.equals("item.AttackEmblem")) {
            return 0;
        }
        if (s.equals("item.HuntEmblem")) {
            return 100;
        }
        if (s.equals("item.HaltEmblem")) {
            return 100;
        }
        if (s.equals("item.MarchEmblem")) {
            return 100;
        }
        if (s.equals("item.CheckupEmblem")) {
            return 100;
        }
        if (s.equals("item.CollarShears")) {
            return 100;
        }
        if (s.equals("item.DoggyCharm")) {
            return 10000;
        }
        if (s.equals("item.SuperTreat")) {
            return 100;
        }
        if (s.equals("item.MasterTreat")) {
            return 200;
        }
        if (s.equals("item.ThrowBone")) {
            return 100;
        }
        if (s.equals("item.DroolThrowBone")) {
            return 100;
        }
        if (s.equals("item.biofossil")) {
            return 200;
        }
        if (s.equals("item.relic")) {
            return 1000;
        }
        if (s.equals("item.stoneboard")) {
            return 2000;
        }
        if (s.equals("item.DNA")) {
            return 30000;
        }
        if (s.equals("item.TriceratopsEgg")) {
            return 50000;
        }
        if (s.equals("item.ancientsword")) {
            return 15000;
        }
        if (s.equals("item.Brokensword")) {
            return 15;
        }
        if (s.equals("item.FernSeed")) {
            return 200;
        }
        if (s.equals("item.ancientHelmet")) {
            return 12000;
        }
        if (s.equals("item.BrokenHelmet")) {
            return 5;
        }
        if (s.equals("item.SkullStick")) {
            return 10;
        }
        if (s.equals("item.Gen")) {
            return 1500;
        }
        if (s.equals("item.GenAxe")) {
            return 2000;
        }
        if (s.equals("item.GenPickaxe")) {
            return 5000;
        }
        if (s.equals("item.GenSword")) {
            return 8000;
        }
        if (s.equals("item.GenHoe")) {
            return 7000;
        }
        if (s.equals("item.GenShovel")) {
            return 7000;
        }
        if (s.equals("item.dinopedia")) {
            return 500;
        }
        if (s.equals("item.TRexTooth")) {
            return 1000;
        }
        if (s.equals("item.ToothDagger")) {
            return 2000;
        }
        if (s.equals("item.RawChickenSoup")) {
            return 20;
        }
        if (s.equals("item.ChickenEss")) {
            return 15;
        }
        if (s.equals("item.EmptyShell")) {
            return 22;
        }
        if (s.equals("item.SioChiuLe")) {
            return 100;
        }
        if (s.equals("item.MagicConch")) {
            return 20;
        }
        if (s.equals("item.DinoMeat")) {
            return 100;
        }
        if (s.equals("item.CookedDinoMeat")) {
            return 200;
        }
        if (s.equals("item.EmbryoSyringe")) {
            return 390;
        }
        if (s.equals("item.AnimalDNA")) {
            return 500;
        }
        if (s.equals("tile.Feeder")) {
            return 5000;
        }
        if (s.equals("tile.Feeder")) {
            return 5000;
        }
        if (s.equals("tile.Permafrost")) {
            return 200;
        }
        if (s.equals("tile.IcedStone")) {
            return 100;
        }
        if (s.equals("tile.Skull")) {
            return 50;
        }
        if (s.equals("tile.SkullLantern")) {
            return 500;
        }
        if (s.equals("tile.analyzerIdle")) {
            return 8000;
        }
        if (s.equals("tile.analyzerActive")) {
            return 0;
        }
        if (s.equals("tile.cultivateIdle")) {
            return 8000;
        }
        if (s.equals("tile.cultivateActive")) {
            return 0;
        }
        if (s.equals("tile.worktableIdle")) {
            return 8000;
        }
        if (s.equals("tile.fossil")) {
            return 60;
        }
        if (s.equals("item.window")) {
            return 25;
        }
        if (s.equals("item.tableleg")) {
            return 10;
        }
        if (s.equals("item.table")) {
            return 50;
        }
        if (s.equals("tile.wallwood")) {
            return 200;
        }
        if (s.equals("tile.wallstone")) {
            return 200;
        }
        if (s.equals("tile.wallbrick")) {
            return 200;
        }
        if (s.equals("tile.wallcobble")) {
            return 200;
        }
        if (s.equals("tile.lampwood")) {
            return 100;
        }
        if (s.equals("tile.lampstone")) {
            return 150;
        }
        if (s.equals("tile.lampbrick")) {
            return 250;
        }
        if (s.equals("tile.lampcobble")) {
            return 200;
        }
        if (s.equals("tile.lamp")) {
            return 50;
        }
        if (s.equals("tile.lamp")) {
            return 50;
        }
        if (s.equals("tile.tv")) {
            return 8008;
        }
        if (s.equals("tile.tv")) {
            return 8008;
        }
        if (s.equals("tile.lamp")) {
            return 50;
        }
        if (s.equals("tile.lamp")) {
            return 50;
        }
        if (s.equals("tile.window")) {
            return 0;
        }
        if (s.equals("tile.vase")) {
            return 70;
        }
        if (s.equals("tile.table")) {
            return 750;
        }
        if (s.equals("tile.doorGlass")) {
            return 500;
        }
        if (s.equals("tile.glasstrapdoor")) {
            return 200;
        }
        if (s.equals("tile.clock")) {
            return 615;
        }
        if (s.equals("tile.torchglass")) {
            return 300;
        }
        if (s.equals("tile.drawer")) {
            return 200;
        }
        if (s.equals("tile.aquarium")) {
            return 1000;
        }
        if (s.equals("tile.sableBitum")) {
            return 500;
        }
        if (s.equals("item.doorGlass")) {
            return 500;
        }
        if (s.equals("item.clock")) {
            return 615;
        }
        if (s.equals("item.cctv")) {
            return 2000;
        }
        if (s.equals("tile.cctvCamera")) {
            return 3939;
        }
        if (s.equals("item.npcwand")) {
            return 501337;
        }
        if (s.equals("item.diesel")) {
            return 40;
        }
        if (s.equals("item.diesel engine")) {
            return 200;
        }
        if (s.equals("item.piston item")) {
            return 20;
        }
        if (s.equals("item.camshaft item")) {
            return 10;
        }
        if (s.equals("item.cylinder item")) {
            return 20;
        }
        if (s.equals("item.freight car")) {
            return 2000;
        }
        if (s.equals("item.Steamlocomotive")) {
            return 1000;
        }
        if (s.equals("item.Steamlocomotive3")) {
            return 1500;
        }
        if (s.equals("item.GP40")) {
            return 4040;
        }
        if (s.equals("item.tracks builder")) {
            return 9000;
        }
        if (s.equals("item.Passenger car")) {
            return 1000;
        }
        if (s.equals("item.Caboose")) {
            return 1500;
        }
        if (s.equals("item.Grain car")) {
            return 2000;
        }
        if (s.equals("item.Water car")) {
            return 2000;
        }
        if (s.equals("item.Wood transport")) {
            return 1500;
        }
        if (s.equals("item.Passenger2 car")) {
            return 1000;
        }
        if (s.equals("item.locomotive 4")) {
            return 2000;
        }
        if (s.equals("item.GP7")) {
            return 6000;
        }
        if (s.equals("item.Tram")) {
            return 8000;
        }
        if (s.equals("item.Speed")) {
            return 10000;
        }
        if (s.equals("item.EU07")) {
            return 5500;
        }
        if (s.equals("item.Shunter")) {
            return 5000;
        }
        if (s.equals("item.Electric motor")) {
            return 1500;
        }
        if (s.equals("item.Coal dust")) {
            return 150;
        }
        if (s.equals("item.ingotSteel")) {
            return 300;
        }
        if (s.equals("item.Steeldust")) {
            return 200;
        }
        if (s.equals("item.Graphite")) {
            return 150;
        }
        if (s.equals("item.Boiler")) {
            return 407;
        }
        if (s.equals("item.Firebox")) {
            return 407;
        }
        if (s.equals("item.Bogie")) {
            return 250;
        }
        if (s.equals("item.Steelframe")) {
            return 500;
        }
        if (s.equals("item.Steelcab")) {
            return 500;
        }
        if (s.equals("item.Steelchimney")) {
            return 500;
        }
        if (s.equals("item.Yoke")) {
            return 50;
        }
        if (s.equals("item.Balloon")) {
            return 800;
        }
        if (s.equals("item.Zepplin")) {
            return 2000;
        }
        if (s.equals("item.Propeller")) {
            return 100;
        }
        if (s.equals("item.Steam engine")) {
            return 150;
        }
        if (s.equals("item.signal item")) {
            return 100;
        }
        if (s.equals("tile.petrol")) {
            return 200;
        }
        if (s.equals("tile.distil")) {
            return 2000;
        }
        if (s.equals("tile.distil")) {
            return 2000;
        }
        if (s.equals("tile.detectorRailLoco")) {
            return 500;
        }
        if (s.equals("tile.detectorRailPassenger")) {
            return 500;
        }
        if (s.equals("tile.detectorRailFreight")) {
            return 500;
        }
        if (s.equals("tile.signal block")) {
            return 250;
        }
        if (s.equals("tile.signal block active")) {
            return 250;
        }
        if (s.equals("tile.dragonEgg")) {
            return 50000;
        }
        if (s.equals("tile.CopperVein")) {
            return 10;
        }
        if (s.equals("tile.CopperBrick")) {
            return 90;
        }
        if (s.equals("tile.TinVein")) {
            return 10;
        }
        if (s.equals("tile.TinBrick")) {
            return 99;
        }
        if (s.equals("tile.BronzeBrick")) {
            return 180;
        }
        if (s.equals("tile.GoldVein")) {
            return 100;
        }
        if (s.equals("tile.IronVein")) {
            return 80;
        }
        if (s.equals("tile.ManganeseVein")) {
            return 80;
        }
        if (s.equals("tile.ManganeseBrick")) {
            return 720;
        }
        if (s.equals("tile.MithrilVein")) {
            return 300;
        }
        if (s.equals("tile.MithrilBrick")) {
            return 2700;
        }
        if (s.equals("tile.OrichalcumVein")) {
            return 380;
        }
        if (s.equals("tile.OrichalcumBrick")) {
            return 3420;
        }
        if (s.equals("tile.AdamantineVein")) {
            return 900;
        }
        if (s.equals("tile.AdamantineBrick")) {
            return 8100;
        }
        if (s.equals("tile.ZincVein")) {
            return 10;
        }
        if (s.equals("tile.ZincBrick")) {
            return 90;
        }
        if (s.equals("tile.BrassBrick")) {
            return 180;
        }
        if (s.equals("tile.PlatinumVein")) {
            return 400;
        }
        if (s.equals("tile.PlatinumBrick")) {
            return 3600;
        }
        if (s.equals("item.GoldOre")) {
            return 100;
        }
        if (s.equals("item.GoldDust")) {
            return 101;
        }
        if (s.equals("item.GoldCoin")) {
            return 4;
        }
        if (s.equals("item.GoldCoin9")) {
            return 150;
        }
        if (s.equals("item.GoldCoin81")) {
            return 1400;
        }
        if (s.equals("item.IronOre")) {
            return 80;
        }
        if (s.equals("item.IronDust")) {
            return 85;
        }
        if (s.equals("item.PlatinumOre")) {
            return 400;
        }
        if (s.equals("item.PlatinumDust")) {
            return 405;
        }
        if (s.equals("item.PlatinumBar")) {
            return 450;
        }
        if (s.equals("item.PlatinumCoin")) {
            return 5;
        }
        if (s.equals("item.PlatinumCoin9")) {
            return 500;
        }
        if (s.equals("item.PlatinumCoin81")) {
            return 5000;
        }
        if (s.equals("item.SilverOre")) {
            return 30;
        }
        if (s.equals("item.SilverDust")) {
            return 33;
        }
        if (s.equals("item.SilverBar")) {
            return 35;
        }
        if (s.equals("item.SilverCoin")) {
            return 4;
        }
        if (s.equals("item.SilverCoin9")) {
            return 40;
        }
        if (s.equals("item.SilverCoin81")) {
            return 360;
        }
        if (s.equals("item.SteelDust")) {
            return 160;
        }
        if (s.equals("item.SteelBar")) {
            return 165;
        }
        if (s.equals("item.SteelPickaxe")) {
            return 500;
        }
        if (s.equals("item.SteelShovel")) {
            return 200;
        }
        if (s.equals("item.SteelAxe")) {
            return 500;
        }
        if (s.equals("item.SteelHoe")) {
            return 350;
        }
        if (s.equals("item.SteelSword")) {
            return 360;
        }
        if (s.equals("tile.SilverVein")) {
            return 30;
        }
        if (s.equals("tile.SilverBrick")) {
            return 270;
        }
        if (s.equals("item.CopperOre")) {
            return 10;
        }
        if (s.equals("item.CopperDust")) {
            return 12;
        }
        if (s.equals("item.CopperBar")) {
            return 15;
        }
        if (s.equals("item.CopperPickaxe")) {
            return 50;
        }
        if (s.equals("item.CopperShovel")) {
            return 25;
        }
        if (s.equals("item.CopperAxe")) {
            return 50;
        }
        if (s.equals("item.CopperHoe")) {
            return 40;
        }
        if (s.equals("item.CopperSword")) {
            return 42;
        }
        if (s.equals("item.TinOre")) {
            return 10;
        }
        if (s.equals("item.TinDust")) {
            return 12;
        }
        if (s.equals("item.TinBar")) {
            return 15;
        }
        if (s.equals("item.BronzeDust")) {
            return 20;
        }
        if (s.equals("item.BronzeBar")) {
            return 25;
        }
        if (s.equals("item.BronzePickaxe")) {
            return 85;
        }
        if (s.equals("item.BronzeShovel")) {
            return 35;
        }
        if (s.equals("item.BronzeAxe")) {
            return 85;
        }
        if (s.equals("item.BronzeHoe")) {
            return 53;
        }
        if (s.equals("item.BronzeSword")) {
            return 53;
        }
        if (s.equals("item.ManganeseOre")) {
            return 80;
        }
        if (s.equals("item.ManganeseDust")) {
            return 82;
        }
        if (s.equals("item.ManganeseBar")) {
            return 85;
        }
        if (s.equals("item.MithrilOre")) {
            return 300;
        }
        if (s.equals("item.MithrilDust")) {
            return 310;
        }
        if (s.equals("item.MithrilBar")) {
            return 320;
        }
        if (s.equals("item.MithrilPickaxe")) {
            return 980;
        }
        if (s.equals("item.MithrilShovel")) {
            return 400;
        }
        if (s.equals("item.MithrilAxe")) {
            return 980;
        }
        if (s.equals("item.MithrilHoe")) {
            return 650;
        }
        if (s.equals("item.MithrilSword")) {
            return 650;
        }
        if (s.equals("item.OrichalcumOre")) {
            return 380;
        }
        if (s.equals("item.OrichalcumDust")) {
            return 385;
        }
        if (s.equals("item.OrichalcumBar")) {
            return 390;
        }
        if (s.equals("item.OrichalcumPickaxe")) {
            return 1200;
        }
        if (s.equals("item.OrichalcumShovel")) {
            return 420;
        }
        if (s.equals("item.OrichalcumAxe")) {
            return 1200;
        }
        if (s.equals("item.OrichalcumHoe")) {
            return 840;
        }
        if (s.equals("item.OrichalcumSword")) {
            return 840;
        }
        if (s.equals("item.AdamantineOre")) {
            return 900;
        }
        if (s.equals("item.AdamantineDust")) {
            return 910;
        }
        if (s.equals("item.AdamantineBar")) {
            return 920;
        }
        if (s.equals("item.AdamantinePickaxe")) {
            return 3300;
        }
        if (s.equals("item.AdamantineShovel")) {
            return 1300;
        }
        if (s.equals("item.AdamantineAxe")) {
            return 3300;
        }
        if (s.equals("item.AdamantineHoe")) {
            return 2500;
        }
        if (s.equals("item.AdamantineSword")) {
            return 2500;
        }
        if (s.equals("item.ZincOre")) {
            return 10;
        }
        if (s.equals("item.ZincDust")) {
            return 12;
        }
        if (s.equals("item.ZincBar")) {
            return 15;
        }
        if (s.equals("item.BrassDust")) {
            return 20;
        }
        if (s.equals("item.BrassBar")) {
            return 24;
        }
        if (s.equals("item.BrassCoin")) {
            return 2;
        }
        if (s.equals("item.BrassCoin9")) {
            return 30;
        }
        if (s.equals("item.JerrySword")) {
            return 1000000;
        }
        return s.equals("item.BrassCoin81") ? 270 : 0;
    }

    public static void getRandomStock() {
        Random random = new Random();
        int i = 0;
        while (i <= 3) {
            i = random.nextInt(200);
        }
        flint = i;
        i = 0;
        while (i <= 3) {
            i = random.nextInt(200);
        }
        clay = i;
        i = 0;
        while (i <= 3) {
            i = random.nextInt(200);
        }
        iron = i;
        i = 0;
        while (i <= 3) {
            i = random.nextInt(200);
        }
        diamond = i;
        i = 0;
        while (i <= 3) {
            i = random.nextInt(200);
        }
        fish = i;
        i = 0;
        while (i <= 3) {
            i = random.nextInt(200);
        }
        apple = i;
        i = 0;
        while (i <= 3) {
            i = random.nextInt(200);
        }
        string = i;
        i = 0;
        while (i <= 3) {
            i = random.nextInt(200);
        }
        feather = i;
    }

    static {
        hunter = 0;
    }
}

