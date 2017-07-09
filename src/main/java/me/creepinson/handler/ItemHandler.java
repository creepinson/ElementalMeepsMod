package me.creepinson.handler;


import me.creepinson.handler.EnumHandler.CrappedWandTypes;
import me.creepinson.item.ItemCrappedWand;
import me.creepinson.lib.util.Utils;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemHandler {
	
	public static Item crappedWand;
	
	
	
	public static void init(){
		
		crappedWand = new ItemCrappedWand("meeprwand", "meeprwand");
		
		
		
	}
	
	
	public static void register(){
		
		registerItem(crappedWand);
		
	}
	
	public static void registerRenders(){
		
		 for(int i = 0; i < CrappedWandTypes.values().length; i++)
			{
	    	  registerRender(crappedWand, i, EnumHandler.CrappedWandTypes.values()[i].getName() + "wand");
			}
		
	}
	
	
	public static void registerItem(Item item){
		
		GameRegistry.register(item);
		Utils.getLogger().info("Registered Item " + item.getUnlocalizedName().substring(5));
		
	}
	
	
	public static void registerRender(Item item){
		
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		Utils.getLogger().info("Registered Render for " + item.getUnlocalizedName().substring(5));
	
	}
	
	 public static void registerRender(Item item, int meta, String fileName){
			
		 ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Utils.MODID + ":" + fileName, "inventory"));
			Utils.getLogger().info("Registered Render for " + item.getUnlocalizedName().substring(5));
			
	 }
	 
	 
	
}