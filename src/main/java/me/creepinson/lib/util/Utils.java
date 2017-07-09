package me.creepinson.lib.util;

import me.creepinson.lib.util.render.RenderHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Utils {

	public static RenderHelper rh = new RenderHelper();

//MAIN MOD STUFF
    public static final String MODID = "meeprtek";
    public static final String VERSION = "Meeping-Alpha";
 
    public static final String SEVERPROXY = "me.creepinson.lib.proxy.CommonProxy";
    public static final String CLIENTPROXY = "me.creepinson.lib.proxy.ClientProxy";
    
//END MAIN MOD STUFF
	
	private static Logger logger;
	
	public static Logger getLogger(){
		
		if(logger == null){
			logger = LogManager.getFormatterLogger(MODID);
		}
		
		return logger;
		
	}
    
    
}
