package me.creepinson.handler;

import net.minecraft.util.IStringSerializable;

public class EnumHandler {

	
	public static enum CrappedWandTypes implements IStringSerializable
	{
		
		crapology("crapology", 0),
		moppity("moppity", 1);

		
		private int ID;
		private String name;
		
		private CrappedWandTypes(String name, int ID){
			
			this.ID = ID;
			this.name = name;
			
		}

		@Override
		public String getName() {
			
			return this.name();
		}


		
		public int getID() {
			
			return ID;
		}

		@Override
		public String toString() {
			
			return super.toString();
		}

		
		
	}
	
	
	
}
