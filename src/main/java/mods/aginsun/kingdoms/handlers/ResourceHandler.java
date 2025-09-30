
package mods.aginsun.kingdoms.handlers;

public class ResourceHandler {
    private int woodPool = 0;
    private int cobblePool = 0;
    private int woodResource = 0;
    private int cobbleResource = 0;
    private static ResourceHandler instance = new ResourceHandler();

    public static ResourceHandler getInstance() {
        return instance;
    }

    public void setWoodPool(int i) {
        this.woodPool = i;
    }

    public void setCobblePool(int i) {
        this.cobblePool = i;
    }

    public int getWoodPool() {
        return this.woodPool;
    }

    public int getCobblePool() {
        return this.cobblePool;
    }

    public void addWoodPool(int i) {
        this.woodPool += i;
    }

    public void addCobblePool(int i) {
        this.cobblePool += i;
    }

    public void decreaseWoodPool(int i) {
        this.woodPool -= i;
    }

    public void decreaseCobblePool(int i) {
        this.cobblePool -= i;
    }

    public void setwoodResource(int i) {
        this.woodResource = i;
    }

    public void setcobbleResource(int i) {
        this.cobbleResource = i;
    }

    public int getwoodResource() {
        return this.woodResource;
    }

    public int getcobbleResource() {
        return this.cobbleResource;
    }

    public void addwoodResource(int i) {
        this.woodResource += i;
    }

    public void addcobbleResource(int i) {
        this.cobbleResource += i;
    }

    public void decreasewoodResource(int i) {
        this.woodResource -= i;
    }

    public void decreasecobbleResource(int i) {
        this.cobbleResource -= i;
    }
}

