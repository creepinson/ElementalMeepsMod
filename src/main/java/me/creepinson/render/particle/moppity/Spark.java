package me.creepinson.render.particle.moppity;

import me.creepinson.render.particle.MoppityTextures;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.world.World;

public class Spark extends Particle {
	public Spark(World parWorld, double parX, double parY, double parZ, double parMotionX, double parMotionY,
			double parMotionZ) {
		super(parWorld, parX, parY, parZ, parMotionX, parMotionY, parMotionZ);
		this.setParticleTexture(Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(MoppityTextures.spark.toString()));
		particleScale = 2.0F;
	}

	@Override
	public int getFXLayer() {
		return 1; // THE IMPORTANT PART
	}
}