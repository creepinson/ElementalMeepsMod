package me.creepinson.tileentity;

import me.creepinson.block.RGBLightsHelper;
import me.creepinson.core.MeeperTek;
import me.creepinson.render.particle.ParticleHandler;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TECreepinoSkull extends TileEntity implements ITickable {

	private int skullRotation;
	private static ParticleHandler ph = MeeperTek.ph;
	private static RGBLightsHelper lh = new RGBLightsHelper();
	private int ticks;

	@Override
	public void update() {
		ticks++;

		if (ticks == 40) {
			this.world.getBlockState(this.pos).getBlock().setLightLevel(1.0F);
		}
		if (ticks == 80) {
			this.world.getBlockState(this.pos).getBlock().setLightLevel(0.0F);
		}
		if (ticks == 120) {
			this.world.getBlockState(this.pos).getBlock().setLightLevel(1.0F);
		}
		if (ticks == 160) {

			ticks = 0;

		}
	

	}

	@SideOnly(Side.CLIENT)
	public int getSkullRotation() {
		return this.skullRotation;
	}

	public void setSkullRotation(int rotation) {
		this.skullRotation = rotation;
	}

}