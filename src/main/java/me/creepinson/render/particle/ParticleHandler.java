package me.creepinson.render.particle;

import java.util.Random;

import me.creepinson.render.particle.moppity.MoppityAura;
import me.creepinson.render.particle.moppity.Spark;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ParticleHandler {

	public void randAura(ParticleHandler ph, EntityPlayer player) {
		Random rand = new Random();
		int randParticle;
		randParticle = rand.nextInt(5);
		switch (randParticle) {
		case 0:
			ph.moppityAuraRed(player);
			break;
		case 1:
			ph.moppityAuraGreen(player);
			break;
		case 2:
			ph.moppityAuraBlue(player);
			break;
		case 3:
			ph.moppityAuraAqua(player);
			break;
		case 4:
			ph.moppityAuraMagenta(player);
			break;
		}
	}

	public void randAuraPos(ParticleHandler ph, BlockPos player, World world) {
		Random rand = new Random();
		int randParticle;
		randParticle = rand.nextInt(5);
		switch (randParticle) {
		case 0:
			ph.auraBluePos(player, world);
			break;
		case 1:
			ph.auraGreenPos(player, world);
			break;
		case 2:
			ph.auraRedPos(player, world);
			break;
		case 3:
			ph.auraMagentaPos(player, world);
			break;
		case 4:
			ph.auraAquaPos(player, world);
			break;
		}
	}

	public void spark(Entity theEntity) {
		double motionX = theEntity.world.rand.nextGaussian() * 0.02D;
		double motionY = theEntity.world.rand.nextGaussian() * 0.02D;
		double motionZ = theEntity.world.rand.nextGaussian() * 0.02D;
		Particle particleMysterious = new Spark(theEntity.world,
				theEntity.posX + theEntity.world.rand.nextFloat() * theEntity.width * 2.0F - theEntity.width,
				theEntity.posY + 0.5D + theEntity.world.rand.nextFloat() * theEntity.height,
				theEntity.posZ + theEntity.world.rand.nextFloat() * theEntity.width * 2.0F - theEntity.width, motionX,
				motionY, motionZ);
		Minecraft.getMinecraft().effectRenderer.addEffect(particleMysterious);
	}

	public void moppityAuraBlue(Entity theEntity) {
		double motionX = theEntity.world.rand.nextGaussian() * 0.02D;
		double motionY = theEntity.world.rand.nextGaussian() * 0.02D;
		double motionZ = theEntity.world.rand.nextGaussian() * 0.02D;
		Particle particleMysterious = new MoppityAura(theEntity.world,
				theEntity.posX + theEntity.world.rand.nextFloat() * theEntity.width * 2.0F - theEntity.width,
				theEntity.posY + 0.5D + theEntity.world.rand.nextFloat() * theEntity.height,
				theEntity.posZ + theEntity.world.rand.nextFloat() * theEntity.width * 2.0F - theEntity.width, motionX,
				motionY, motionZ);
		particleMysterious.setRBGColorF(0.0F, 0.0F, 1.0F);
		Minecraft.getMinecraft().effectRenderer.addEffect(particleMysterious);
	}

	public void moppityAuraRed(Entity theEntity) {
		double motionX = theEntity.world.rand.nextGaussian() * 0.02D;
		double motionY = theEntity.world.rand.nextGaussian() * 0.02D;
		double motionZ = theEntity.world.rand.nextGaussian() * 0.02D;
		Particle particleMysterious = new MoppityAura(theEntity.world,
				theEntity.posX + theEntity.world.rand.nextFloat() * theEntity.width * 2.0F - theEntity.width,
				theEntity.posY + 0.5D + theEntity.world.rand.nextFloat() * theEntity.height,
				theEntity.posZ + theEntity.world.rand.nextFloat() * theEntity.width * 2.0F - theEntity.width, motionX,
				motionY, motionZ);
		particleMysterious.setRBGColorF(1.0F, 0.0F, 0.0F);
		Minecraft.getMinecraft().effectRenderer.addEffect(particleMysterious);
	}

	public void moppityAuraGreen(Entity theEntity) {
		double motionX = theEntity.world.rand.nextGaussian() * 0.02D;
		double motionY = theEntity.world.rand.nextGaussian() * 0.02D;
		double motionZ = theEntity.world.rand.nextGaussian() * 0.02D;
		Particle particleMysterious = new MoppityAura(theEntity.world,
				theEntity.posX + theEntity.world.rand.nextFloat() * theEntity.width * 2.0F - theEntity.width,
				theEntity.posY + 0.5D + theEntity.world.rand.nextFloat() * theEntity.height,
				theEntity.posZ + theEntity.world.rand.nextFloat() * theEntity.width * 2.0F - theEntity.width, motionX,
				motionY, motionZ);
		particleMysterious.setRBGColorF(0.0F, 1.0F, 0.0F);
		Minecraft.getMinecraft().effectRenderer.addEffect(particleMysterious);
	}

	public void moppityAuraMagenta(Entity theEntity) {
		double motionX = theEntity.world.rand.nextGaussian() * 0.02D;
		double motionY = theEntity.world.rand.nextGaussian() * 0.02D;
		double motionZ = theEntity.world.rand.nextGaussian() * 0.02D;
		Particle particleMysterious = new MoppityAura(theEntity.world,
				theEntity.posX + theEntity.world.rand.nextFloat() * theEntity.width * 2.0F - theEntity.width,
				theEntity.posY + 0.5D + theEntity.world.rand.nextFloat() * theEntity.height,
				theEntity.posZ + theEntity.world.rand.nextFloat() * theEntity.width * 2.0F - theEntity.width, motionX,
				motionY, motionZ);
		particleMysterious.setRBGColorF(1.0F, 0.0F, 1.0F);
		Minecraft.getMinecraft().effectRenderer.addEffect(particleMysterious);
	}

	public void moppityAuraAqua(Entity theEntity) {
		double motionX = theEntity.world.rand.nextGaussian() * 0.02D;
		double motionY = theEntity.world.rand.nextGaussian() * 0.02D;
		double motionZ = theEntity.world.rand.nextGaussian() * 0.02D;
		Particle particleMysterious = new MoppityAura(theEntity.world,
				theEntity.posX + theEntity.world.rand.nextFloat() * theEntity.width * 2.0F - theEntity.width,
				theEntity.posY + 0.5D + theEntity.world.rand.nextFloat() * theEntity.height,
				theEntity.posZ + theEntity.world.rand.nextFloat() * theEntity.width * 2.0F - theEntity.width, motionX,
				motionY, motionZ);
		particleMysterious.setRBGColorF(0.0F, 1.0F, 1.0F);
		Minecraft.getMinecraft().effectRenderer.addEffect(particleMysterious);
	}

	public void sparkPos(BlockPos pos, World world) {
		double motionX = world.rand.nextGaussian() * 0.02D;
		double motionY = world.rand.nextGaussian() * 0.02D;
		double motionZ = world.rand.nextGaussian() * 0.02D;
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		Particle particleMysterious = new Spark(world, x,
				y, z, motionX, motionY, motionZ);
		Minecraft.getMinecraft().effectRenderer.addEffect(particleMysterious);
	}
	public void auraBluePos(BlockPos pos, World world) {
		double motionX = world.rand.nextGaussian() * 0.02D;
		double motionY = world.rand.nextGaussian() * 0.02D;
		double motionZ = world.rand.nextGaussian() * 0.02D;
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		Particle particleMysterious = new MoppityAura(world, x,
				y, z, motionX, motionY, motionZ);
		particleMysterious.setRBGColorF(0.0F, 0.0F, 1.0F);
		Minecraft.getMinecraft().effectRenderer.addEffect(particleMysterious);
	}
	public void auraRedPos(BlockPos pos, World world) {
		double motionX = world.rand.nextGaussian() * 0.02D;
		double motionY = world.rand.nextGaussian() * 0.02D;
		double motionZ = world.rand.nextGaussian() * 0.02D;
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		Particle particleMysterious = new MoppityAura(world, x,
				y, z, motionX, motionY, motionZ);
		particleMysterious.setRBGColorF(1.0F, 0.0F, 0.0F);
		Minecraft.getMinecraft().effectRenderer.addEffect(particleMysterious);
	}
	public void auraAquaPos(BlockPos pos, World world) {
		double motionX = world.rand.nextGaussian() * 0.02D;
		double motionY = world.rand.nextGaussian() * 0.02D;
		double motionZ = world.rand.nextGaussian() * 0.02D;
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		Particle particleMysterious = new MoppityAura(world, x,
				y, z, motionX, motionY, motionZ);
		particleMysterious.setRBGColorF(0.0F, 1.0F, 1.0F);
		Minecraft.getMinecraft().effectRenderer.addEffect(particleMysterious);
	}
	public void auraMagentaPos(BlockPos pos, World world) {
		double motionX = world.rand.nextGaussian() * 0.02D;
		double motionY = world.rand.nextGaussian() * 0.02D;
		double motionZ = world.rand.nextGaussian() * 0.02D;
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		Particle particleMysterious = new MoppityAura(world, x,
				y, z, motionX, motionY, motionZ);
		particleMysterious.setRBGColorF(1.0F, 0.0F, 1.0F);
		Minecraft.getMinecraft().effectRenderer.addEffect(particleMysterious);
	}
	public void auraGreenPos(BlockPos pos, World world) {
		double motionX = world.rand.nextGaussian() * 0.02D;
		double motionY = world.rand.nextGaussian() * 0.02D;
		double motionZ = world.rand.nextGaussian() * 0.02D;
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		Particle particleMysterious = new MoppityAura(world, x,
				y, z, motionX, motionY, motionZ);
		particleMysterious.setRBGColorF(0.0F, 1.0F, 0.0F);
		Minecraft.getMinecraft().effectRenderer.addEffect(particleMysterious);
	}


}
