package me.creepinson.handler;


import me.creepinson.block.CreepinoSkull;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockHandler {
	public static Block BlockMobChamberCore;



	public static void init() {

		BlockMobChamberCore = new CreepinoSkull(Material.ROCK, "momo",
				CreativeTabHandler.MEEPR_BLOCKS, 5F, 15F, 3, "pickaxe");

		
	}

	public static void register() {


		GameRegistry.register(BlockMobChamberCore);
		GameRegistry.register(new ItemBlock(BlockMobChamberCore).setRegistryName(BlockMobChamberCore.getRegistryName()));
	}

	public static void registerRenders() {

		 registerRender(BlockMobChamberCore);


	}

	public static void registerRender(Block block) {

		Item item = Item.getItemFromBlock(block);
		ModelLoader.setCustomModelResourceLocation(item, 0,
				new ModelResourceLocation(item.getRegistryName(), "inventory"));

	}

}
