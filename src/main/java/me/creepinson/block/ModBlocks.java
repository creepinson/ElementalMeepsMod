package me.creepinson.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class ModBlocks extends Block {

	public ModBlocks(Material mat, String name, CreativeTabs tab, float hardness, float resistance, int harvest,
			String tool) {
		super(mat);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
		setHardness(hardness);
		setResistance(resistance);
		setHarvestLevel(tool, harvest);
	}

	public ModBlocks(Material mat, String name, CreativeTabs tab, float hardness, float resistance) {
		super(mat);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
		setHardness(hardness);
		setResistance(resistance);
	}

}
