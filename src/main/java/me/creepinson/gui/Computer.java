package me.creepinson.gui;


import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import me.creepinson.api.*;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import org.lwjgl.input.Keyboard;

import me.creepinson.lib.util.Utils;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class Computer extends GuiScreen {
    public static final ResourceLocation resource = new ResourceLocation(Utils.MODID, "textures/gui/computer.png");
    public static CustomButton type1;
    protected List<GuiComponent> components = new ArrayList<>();
    public static CustomButton type2;

    public static CustomButton type3;

    public static GuiSliderFixed type;

    public User currentUser;
    private int x, y, z;
    private NBTTagCompound fileData;
    private NBTTagCompound systemData;
    private FileSystem fileSystem;

    public Computer(NBTTagCompound data, int x, int y, int z) {
        this.fileData = data.getCompoundTag("files");
        this.systemData = data.getCompoundTag("system");
        this.currentUser = new User(fileSystem);
        this.x = x;
        this.y = y;
        this.z = z;
        this.fileSystem = new FileSystem(fileData);


    }


    @Override
    public void initGui() {

        int i = (this.width - 248) / 2;
        int j = (this.height - 166) / 2;
        this.buttonList.clear();

        components.add(new FileBrowser(fileSystem, this, 0,0));

        type1 = this.addButton(new CustomButton(0, i, j, 150, 20, "Turn On", Color.green));
        type1.visible = true;
        type1.enabled = true;
        type2 = this.addButton(new CustomButton(1, i, j + 25, 150, 20, "Shutdown", Color.red));
        type2.visible = true;
        type2.enabled = true;
        type3 = this.addButton(new CustomButton(2, i, j + 50, 150, 20, "Rebiit", new Color(0.0f, 0.5f, 0.0f)));
        type3.visible = true;
        type3.enabled = true;
        type3 = this.addButton(new CustomButton(3, i, j + 75, 150, 20, "Enter Computer", Color.green));
        type3.visible = true;
        type3.enabled = true;

        super.initGui();
    }

    @Override

    public boolean doesGuiPauseGame()

    {

        return false;

    }

    @Override
    public void updateScreen() {
        super.updateScreen();


    }

    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
        Keyboard.enableRepeatEvents(false);

    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {

        type1.drawButton(mc, mouseX, mouseY);
        type2.drawButton(mc, mouseX, mouseY);
        type3.drawButton(mc, mouseX, mouseY);

        for(GuiComponent component : components){



        }
        GlStateManager.color(1.0F, 0.0F, 0.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(resource);
        int i = (this.width - 248) / 2;
        int j = (this.height - 166) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, 248, 166);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }


    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        super.actionPerformed(button);

        switch (button.id) {
            case 1:
                mc.displayGuiScreen(null);
            default:

        }
    }

}
