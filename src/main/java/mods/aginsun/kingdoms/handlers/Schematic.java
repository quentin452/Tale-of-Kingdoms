/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.nbt.CompressedStreamTools
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.nbt.NBTTagList
 */
package mods.aginsun.kingdoms.handlers;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import mods.aginsun.kingdoms.TaleOfKingdoms;
import mods.aginsun.kingdoms.util.FakeBlock;
import mods.aginsun.kingdoms.util.FakeEntity;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class Schematic {
    private ArrayList<FakeBlock> blockList = new ArrayList();
    private ArrayList<FakeEntity> entityList = new ArrayList();
    private byte[] blocksArray;
    private byte[] dataArray;
    private short height;
    private short length;
    private short width;
    public int x;
    public int y;
    public int z;
    public int speed;

    public Schematic(String s) {
        InputStream entityData = TaleOfKingdoms.class.getResourceAsStream(s + ".dat");
        InputStream schematicData = TaleOfKingdoms.class.getResourceAsStream(s + ".schematic");
        NBTTagCompound nbtSchematic = null;
        NBTTagCompound nbtEntities = null;
        try {
            nbtSchematic = CompressedStreamTools.readCompressed((InputStream)schematicData);
            nbtEntities = CompressedStreamTools.readCompressed((InputStream)entityData);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        this.writeSchematic(nbtSchematic);
        if (s.contains("Tier4")) {
            this.writeEntitiesTier4(nbtEntities);
        } else if (s.contains("Tier3")) {
            this.writeEntitiesTier3(nbtEntities);
        } else {
            this.writeEntities(nbtEntities);
        }
    }

    private void writeSchematic(NBTTagCompound nbt) {
        this.height = nbt.getShort("Height");
        this.length = nbt.getShort("Length");
        this.width = nbt.getShort("Width");
        this.blocksArray = nbt.getByteArray("Blocks");
        this.dataArray = nbt.getByteArray("Data");
        for (int y = 0; y < this.height; ++y) {
            for (int x = 0; x < this.width; ++x) {
                for (int z = 0; z < this.length; ++z) {
                    int index = y * this.width * this.length + z * this.width + x;
                    this.blockList.add(new FakeBlock(this.blocksArray[index], this.dataArray[index], x, y, z));
                }
            }
        }
    }

    private void writeEntities(NBTTagCompound nbt) {
        NBTTagList list = nbt.getTagList("Entities");
        for (int i = 0; i < list.tagCount(); ++i) {
            NBTTagCompound nbt1 = (NBTTagCompound)list.tagAt(i);
            String s = nbt1.getString("EntityName");
            double posX = nbt1.getDouble("posX");
            double posY = nbt1.getDouble("posY");
            double posZ = nbt1.getDouble("posZ");
            this.entityList.add(new FakeEntity(s, posX, posY, posZ));
        }
    }

    private void writeEntitiesTier4(NBTTagCompound nbt) {
        NBTTagList list = nbt.getTagList("Entities");
        for (int i = 0; i < list.tagCount(); ++i) {
            NBTTagCompound nbt1 = (NBTTagCompound)list.tagAt(i);
            String s = nbt1.getString("EntityName");
            double posX = nbt1.getDouble("posX");
            double posY = nbt1.getDouble("posY");
            double posZ = nbt1.getDouble("posZ");
            this.entityList.add(new FakeEntity(s, posX + 10.0, posY, posZ + 5.0));
        }
    }

    private void writeEntitiesTier3(NBTTagCompound nbt) {
        NBTTagList list = nbt.getTagList("Entities");
        for (int i = 0; i < list.tagCount(); ++i) {
            NBTTagCompound nbt1 = (NBTTagCompound)list.tagAt(i);
            String s = nbt1.getString("EntityName");
            double posX = nbt1.getDouble("posX");
            double posY = nbt1.getDouble("posY");
            double posZ = nbt1.getDouble("posZ");
            this.entityList.add(new FakeEntity(s, posX - 10.0, posY, posZ - 5.0));
        }
    }

    public ArrayList<FakeBlock> getBlockList() {
        return this.blockList;
    }

    public ArrayList<FakeEntity> getEntityList() {
        return this.entityList;
    }

    public void setBlockList(ArrayList<FakeBlock> blockList) {
        this.blockList = blockList;
    }

    public Schematic setPosition(int posX, int posY, int posZ) {
        this.x = posX;
        this.y = posY;
        this.z = posZ;
        return this;
    }

    public Schematic setSpeed(int i) {
        this.speed = i;
        return this;
    }
}

