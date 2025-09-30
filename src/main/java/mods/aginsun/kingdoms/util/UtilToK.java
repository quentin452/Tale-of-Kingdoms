
package mods.aginsun.kingdoms.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;

public class UtilToK {
    public static final String Version = "1.5-Pre Release";
    public static final String modid = "taleofkingdoms";
    public static int libraryInvestment;
    public static boolean guildFightEnded;
    public static boolean guildFightStarted;
    public static int townX;
    public static int townY;
    public static int townZ;
    public static int burningVillages;
    public static int reficulHoles;
    public static int bindLight;

    public static void spawnEntity(World world, String name, ChunkCoordinates position) {
        EntityLivingBase entityliving = (EntityLivingBase)EntityList.createEntityByName((String)name, (World)world);
        entityliving.setLocationAndAngles((double)position.posX, (double)position.posY, (double)position.posZ, 0.0f, 0.0f);
        world.spawnEntityInWorld((Entity)entityliving);
    }
}

