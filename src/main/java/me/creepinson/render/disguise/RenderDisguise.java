package me.creepinson.render.disguise;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderDisguise extends RenderLivingBase
{
    private ResourceLocation texture;


    public RenderDisguise(RenderManager renderManager, ModelBase model, ResourceLocation text)
    {
        super(renderManager, model, 0.5F);
        this.texture = text;
    }



    
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		
		return texture;
	}
}	
	
