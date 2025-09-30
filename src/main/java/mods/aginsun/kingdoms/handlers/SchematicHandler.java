
package mods.aginsun.kingdoms.handlers;

import java.util.ArrayList;
import mods.aginsun.kingdoms.handlers.Schematic;
import mods.aginsun.kingdoms.util.Buildings;
import mods.aginsun.kingdoms.util.FakeBlock;
import mods.aginsun.kingdoms.util.FakeEntity;
import mods.aginsun.kingdoms.util.UtilToK;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.world.World;

public class SchematicHandler {
    private static SchematicHandler instance = new SchematicHandler();
    private ArrayList<FakeBlock> torchList = new ArrayList();
    private ArrayList<Schematic> buildingList = new ArrayList();
    private int index;

    public static SchematicHandler getInstance() {
        return instance;
    }

    public void addBuilding(Schematic schematic) {
        this.buildingList.add(schematic);
    }

    public ArrayList<Schematic> getBuildingList() {
        return this.buildingList;
    }

    public void update(World world) {
        if (!this.buildingList.isEmpty()) {
            Schematic x = this.buildingList.get(0);
            if (x != null) {
                ArrayList<FakeBlock> arrayList = x.getBlockList();
                ArrayList<FakeEntity> arrayList1 = x.getEntityList();
                if (!arrayList.isEmpty() || !arrayList1.isEmpty()) {
                    for (int i = 0; i < x.speed; ++i) {
                        if (this.index < arrayList.size()) {
                            FakeBlock block = arrayList.get(this.index);
                            if (block != null && world.getBlockId(x.x + block.posX, x.y + block.posY, x.z + block.posZ) != block.blockID) {
                                if (block.blockID == 0) {
                                    world.setBlockToAir(x.x + block.posX, x.y + block.posY, x.z + block.posZ);
                                }
                                if (block.blockID == Block.torchWood.blockID || block.blockID == Block.doorWood.blockID || block.blockID == Block.ladder.blockID || block.blockID == Block.trapdoor.blockID) {
                                    this.torchList.add(block);
                                } else {
                                    world.setBlock(x.x + block.posX, x.y + block.posY, x.z + block.posZ, block.blockID, block.metadata, 3);
                                }
                            }
                            ++this.index;
                            continue;
                        }
                        if (this.index < arrayList.size() + arrayList1.size()) {
                            FakeEntity entity = arrayList1.get(this.index - arrayList.size());
                            EntityLiving entity1 = (EntityLiving)EntityList.createEntityByName((String)entity.entityName, (World)world);
                            if (entity1 != null) {
                                if (Buildings.getBuilding(1)) {
                                    entity1.setPosition((double)UtilToK.townX + entity.posX, (double)UtilToK.townY + entity.posY, (double)UtilToK.townZ + entity.posZ);
                                } else {
                                    entity1.setPosition((double)x.x + entity.posX, (double)x.y + entity.posY + 1.5, (double)x.z + entity.posZ);
                                }
                                world.spawnEntityInWorld((Entity)entity1);
                            } else {
                                System.out.println("ERRRROR " + entity.entityName);
                            }
                            ++this.index;
                            continue;
                        }
                        for (FakeBlock block : this.torchList) {
                            world.setBlock(x.x + block.posX, x.y + block.posY, x.z + block.posZ, block.blockID, block.metadata, 3);
                        }
                        this.index = 0;
                        if (!this.buildingList.isEmpty()) {
                            this.buildingList.remove(0);
                        }
                        this.torchList.clear();
                        System.out.println("REMOVED BUILDING");
                    }
                } else {
                    System.out.println("EMPTY LISTS");
                }
            } else {
                System.out.println("CANNOT FIND SCHEMATIC");
            }
        }
    }

    public float getProgressCurrentBuilding() {
        if (this.buildingList.isEmpty()) {
            return 0.0f;
        }
        ArrayList<FakeBlock> arrayList = this.buildingList.get(0).getBlockList();
        float index = this.index;
        float f = index / (float)arrayList.size() * 100.0f;
        return f;
    }
}

