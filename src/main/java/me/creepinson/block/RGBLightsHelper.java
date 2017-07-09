package me.creepinson.block;

import net.minecraft.block.Block;

public class RGBLightsHelper {

	public static float l[] = new float[] { 0F, 1F / 15, 2F / 15, 3F / 15, 4F / 15, 5F / 15, 6F / 15, 7F / 15, 8F / 15,
			9F / 15, 10F / 15, 11F / 15, 12F / 15, 13F / 15, 14F / 15, 1F };

	public static int r[] = new int[] { 0, 15, 0, 8, 0, 10, 0, 10, 5, 15, 8, 15, 0, 15, 15, 15 };

	public static int g[] = new int[] { 0, 0, 15, 3, 0, 0, 15, 10, 5, 10, 15, 15, 8, 0, 12, 15 };

	public static int b[] = new int[] { 0, 0, 0, 0, 15, 15, 15, 10, 5, 13, 0, 0, 15, 15, 10, 15 };

	@Deprecated

	public static Block setBlockColorRGB(Block block, float r, float g, float b) {

		block.setLightLevel(((float) makeRGBLightValue(r, g, b)) / 15F);

		return block;

	}

	@Deprecated
	public static int makeRGBLightValue(float r, float g, float b) {

		// Clamp color channels

		if (r < 0.0f)

			r = 0.0f;

		else if (r > 1.0f)

			r = 1.0f;

		if (g < 0.0f)

			g = 0.0f;

		else if (g > 1.0f)

			g = 1.0f;

		if (b < 0.0f)

			b = 0.0f;

		else if (b > 1.0f)

			b = 1.0f;

		int brightness = (int) (15.0f * Math.max(Math.max(r, g), b));

		return brightness | ((((int) (15.0F * b)) << 15) + (((int) (15.0F * g)) << 10) + (((int) (15.0F * r)) << 5));

	}

}
