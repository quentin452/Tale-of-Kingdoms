
package mods.aginsun.kingdoms.client.render;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderBipedToK
extends RenderBiped {
    private String location;

    public RenderBipedToK(ModelBiped par1ModelBiped, float par2, String location) {
        super(par1ModelBiped, par2);
        this.location = "textures/entities/" + location + ".png";
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return new ResourceLocation("taleofkingdoms", this.location);
    }

    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
        super.doRender(par1Entity, par2, par4, par6, par8, par9);
    }
}

