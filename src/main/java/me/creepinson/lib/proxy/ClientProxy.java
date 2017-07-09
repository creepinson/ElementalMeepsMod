package me.creepinson.lib.proxy;

import org.lwjgl.input.Keyboard;

import me.creepinson.core.MeeperTek;
import me.creepinson.entity.EntityMovingBlock;
import me.creepinson.entity.render.RenderMovingBlock;
import me.creepinson.handler.BlockHandler;
import me.creepinson.handler.ItemHandler;
import me.creepinson.render.disguise.RenderDisguises;
import me.creepinson.tileentity.TECreepinoSkull;
import me.creepinson.tileentity.render.TESRCreepinoSkull;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.network.NetworkRegistry;
 
public class ClientProxy extends CommonProxy {
	
	public static KeyBinding[] keyBindings;
	
	
	
	
	@Override
	public void registerRenderers() {

		ItemHandler.registerRenders();
		BlockHandler.registerRenders();
	
		

	
	}
	@Override
	public void preInit() {
		  super.preInit();
		
	}

	public void init() {
		  super.init();
		  ClientRegistry.bindTileEntitySpecialRenderer(TECreepinoSkull.class, new TESRCreepinoSkull());

			RenderingRegistry.registerEntityRenderingHandler(EntityMovingBlock.class,
					new RenderMovingBlock(Minecraft.getMinecraft().getRenderManager()));





			

			
			//KEYBINDS

			// declare an array of key bindings
			keyBindings = new KeyBinding[4]; 
			  
			// instantiate the key bindings
			keyBindings[0] = new KeyBinding("key.elementalmeeps.mobspawner", Keyboard.KEY_GRAVE, "key.elementalmeeps.gui");
			keyBindings[1] = new KeyBinding("key.elementalmeeps.disguisepig", Keyboard.KEY_DOWN, "key.elementalmeeps.render");
			keyBindings[2] = new KeyBinding("key.elementalmeeps.disguisecreeper", Keyboard.KEY_UP, "key.elementalmeeps.render");
			keyBindings[3] = new KeyBinding("key.elementalmeeps.undisguiseplayer", Keyboard.KEY_P, "key.elementalmeeps.render");
		    	    
			// register all the key bindings
			for (int i = 0; i < keyBindings.length; ++i) 
			{
			    ClientRegistry.registerKeyBinding(keyBindings[i]);

			
			
			
	}
	}
	
}
