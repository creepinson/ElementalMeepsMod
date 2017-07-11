package me.creepinson.api;

import me.creepinson.gui.GuiComponent;
import me.creepinson.lib.util.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import javax.annotation.Nullable;

/**
 * Created by Creepinson on 7/10/2017.
 */
public class FileBrowser extends GuiComponent {

    private FileSystem fileSystem;



    public FileBrowser(FileSystem fileSystem, Gui parent, int x, int y) {
        super("File Browser", x,y, parent);
        this.width = 124;
        this.height = 83;
        this.x = x;
        this.y = y;
        this.parentGui = parent;
        this.fileSystem = fileSystem;
        init();

    }

    public void init(){

        componentTex = new ResourceLocation(Utils.MODID, "textures/gui/apps/filebrowser.png");

    }

    public void render(Gui gui, int x, int y, float partialTicks, Minecraft mc){

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.9F);
        GlStateManager.enableBlend();
        mc.getTextureManager().bindTexture(componentTex);

        gui.drawTexturedModalRect(x, y, 0,0, width, height);

    }

}
