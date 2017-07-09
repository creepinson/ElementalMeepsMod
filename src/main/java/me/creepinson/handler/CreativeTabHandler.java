package me.creepinson.handler;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabHandler {


	public static final CreativeTabs MEEPR_WANDS = new CreativeTabs("MeeprWands"){
	    @Override public ItemStack getTabIconItem() {
	        return new ItemStack(ItemHandler.crappedWand, 1, 0);
	    }
	};
	public static final CreativeTabs MEEPR_BLOCKS = new CreativeTabs("MeeprBlocks"){
	    @Override public ItemStack getTabIconItem() {
	        return new ItemStack(BlockHandler.BlockMobChamberCore, 1);
	    }
	};
	
}
