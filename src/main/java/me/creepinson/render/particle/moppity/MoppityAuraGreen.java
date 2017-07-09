package me.creepinson.render.particle.moppity;

import me.creepinson.render.particle.MoppityTextures;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.world.World;

public class MoppityAuraGreen extends Particle
{
	
    public MoppityAuraGreen(World parWorld,
            double parX, double parY, double parZ,
            double parMotionX, double parMotionY, double parMotionZ) 
    {
        super(parWorld, parX, parY, parZ, parMotionX, parMotionY, parMotionZ);
		this.setParticleTextureIndex(7);
        particleScale = 2.0F;
        setRBGColorF(0.0F, 1.0F, 0.0F);
    }
    
    @Override
    public int getFXLayer() {
        return 0; // THE IMPORTANT PART
    }
    
}