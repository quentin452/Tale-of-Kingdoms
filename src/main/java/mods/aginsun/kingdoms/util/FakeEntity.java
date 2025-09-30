
package mods.aginsun.kingdoms.util;

public class FakeEntity {
    public double posX;
    public double posY;
    public double posZ;
    public String entityName;

    public FakeEntity(String entityName, double posX, double posY, double posZ) {
        this.entityName = entityName;
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
    }
}

