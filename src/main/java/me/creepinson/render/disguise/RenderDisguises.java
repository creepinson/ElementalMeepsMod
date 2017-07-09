package me.creepinson.render.disguise;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelCreeper;
import net.minecraft.client.model.ModelPig;
import net.minecraft.util.ResourceLocation;

public class RenderDisguises {
	public static RenderDisguise pig = new RenderDisguise(Minecraft.getMinecraft().getRenderManager(), new ModelPig(),
			new ResourceLocation("textures/entity/pig/pig.png"));

	public static RenderDisguise creeper = new RenderDisguise(Minecraft.getMinecraft().getRenderManager(),
			new ModelCreeper(), new ResourceLocation("textures/entity/creeper/creeper.png"));

	public static RenderUnDisguise player = new RenderUnDisguise(Minecraft.getMinecraft().getRenderManager());

}
