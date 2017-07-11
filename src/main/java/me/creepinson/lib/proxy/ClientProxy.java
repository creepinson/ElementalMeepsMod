package me.creepinson.lib.proxy;

import org.lwjgl.input.Keyboard;

import me.creepinson.handler.BlockHandler;
import me.creepinson.handler.ItemHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

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
