
package mods.aginsun.kingdoms.handlers;

import cpw.mods.fml.common.FMLCommonHandler;
import mods.aginsun.kingdoms.TaleOfKingdoms;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ItemDropHelper {
    public static World world = FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(0);

    public static boolean isHostileEntity(EntityLivingBase entityLiving) {
        return entityLiving instanceof EntityBlaze || entityLiving instanceof EntityCaveSpider || entityLiving instanceof EntityCreeper || entityLiving instanceof EntityDragon || entityLiving instanceof EntityEnderman || entityLiving instanceof EntityGhast || entityLiving instanceof EntityMagmaCube || entityLiving instanceof EntityPigZombie || entityLiving instanceof EntitySilverfish || entityLiving instanceof EntitySkeleton || entityLiving instanceof EntitySpider || entityLiving instanceof EntityWitch || entityLiving instanceof EntityWither || entityLiving instanceof EntityZombie;
    }

    public static void dropCoins(EntityPlayer player, EntityLivingBase entityLiving) {
        if (ItemDropHelper.isHostileEntity(entityLiving) && !ItemDropHelper.world.isRemote) {
            entityLiving.dropItem(TaleOfKingdoms.coins.itemID, 1);
            entityLiving.dropItem(TaleOfKingdoms.coins.itemID, 1);
            entityLiving.dropItem(TaleOfKingdoms.coins.itemID, 1);
            entityLiving.dropItem(TaleOfKingdoms.coins.itemID, 1);
            entityLiving.dropItem(TaleOfKingdoms.coins.itemID, 1);
            entityLiving.dropItem(TaleOfKingdoms.coins.itemID, 1);
            entityLiving.dropItem(TaleOfKingdoms.coins.itemID, 1);
            entityLiving.dropItem(TaleOfKingdoms.coins.itemID, 1);
            entityLiving.dropItem(TaleOfKingdoms.coins.itemID, 1);
            entityLiving.dropItem(TaleOfKingdoms.coins.itemID, 1);
            entityLiving.dropItem(TaleOfKingdoms.coins.itemID, 1);
            entityLiving.dropItem(TaleOfKingdoms.coins.itemID, 1);
            entityLiving.dropItem(TaleOfKingdoms.coins.itemID, 1);
            entityLiving.dropItem(TaleOfKingdoms.coins.itemID, 1);
            entityLiving.dropItem(TaleOfKingdoms.coins.itemID, 1);
            entityLiving.dropItem(TaleOfKingdoms.coins.itemID, 1);
            entityLiving.dropItem(TaleOfKingdoms.coins.itemID, 1);
            entityLiving.dropItem(TaleOfKingdoms.coins.itemID, 1);
            entityLiving.dropItem(TaleOfKingdoms.coins.itemID, 1);
            entityLiving.dropItem(TaleOfKingdoms.coins.itemID, 1);
            entityLiving.dropItem(TaleOfKingdoms.coins.itemID, 1);
            entityLiving.dropItem(TaleOfKingdoms.coins.itemID, 1);
            entityLiving.dropItem(TaleOfKingdoms.coins.itemID, 1);
            entityLiving.dropItem(TaleOfKingdoms.coins.itemID, 1);
            entityLiving.dropItem(TaleOfKingdoms.coins.itemID, 1);
            entityLiving.dropItem(TaleOfKingdoms.coins.itemID, 1);
        }
    }
}

