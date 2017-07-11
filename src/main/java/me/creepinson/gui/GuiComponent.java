package me.creepinson.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Creepinson on 7/10/2017.
 */
public abstract class GuiComponent extends Gui {
    protected int width, height;
    public ResourceLocation getComponentTex() {
        return componentTex;
    }

    public void setComponentTex(ResourceLocation componentTex) {
        this.componentTex = componentTex;
    }

    protected ResourceLocation componentTex;
    protected Gui parentGui;

    protected int x, y;

    protected String displayName;

    public GuiComponent(String displayName, int x, int y, Gui parentGui) {

        this.parentGui = parentGui;
        this.displayName = displayName;
        this.x = x;
        this.y = y;


    }




    public abstract void init();

    public void updateGui(int newX, int newY) {

        this.x = newX;
        this.y = newY;

    }

    public abstract void render(Gui gui, int x, int y, float partialTicks, Minecraft mc);


}
