package me.creepinson.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;

import org.lwjgl.opengl.GL11;

public class GuiSliderFixed extends GuiButton {

public float sliderPosition = 1.0F;
public float sliderMaxValue = 1.0F;
public float sliderMinValue = 1.0F;
public boolean dragging = false;
public String label;

public GuiSliderFixed(int id, int x, int y, String label, float defaultValue, float maxValue, float minValue) {
    super(id, x, y, 150, 20, label);
    this.label = label;
    this.sliderMaxValue = maxValue;
    this.sliderMinValue = minValue;
    this.sliderPosition = (defaultValue - minValue) / (maxValue - minValue);
    this.displayString = label;
}

protected int getHoverState(boolean par1) {
    return 0;
}
public void setSliderValue(float value)
{
    this.sliderPosition = (value - this.sliderMinValue) / (this.sliderMaxValue - this.sliderMinValue);
    this.displayString = this.label;

 
}
public float getSliderValue()
{
    return this.sliderMinValue + (this.sliderMaxValue - this.sliderMinValue) * this.sliderPosition;
}
/**
 * Gets the slider's position.
 * @return The position of the slider, which will under normal circumstances be between 0 and 1, unless it was
 * manually set out of that range.
 */
public float getSliderPosition()
{
    return this.sliderPosition;
}


@Override
public void drawButton(Minecraft mc, int mouseX, int mouseY)
{
    if (this.visible)
    {
        FontRenderer fontrenderer = mc.fontRendererObj;
        mc.getTextureManager().bindTexture(BUTTON_TEXTURES);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
        int k = this.getHoverState(this.hovered);
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.blendFunc(770, 771);
        this.mouseDragged(mc, mouseX, mouseY);
        int l = 14737632;

        if (packedFGColour != 0)
        {
            l = packedFGColour;
        }
        else if (!this.enabled)
        {
            l = 10526880;
        }
        else if (this.hovered)
        {
            l = 16777120;
        }

        this.drawCenteredString(fontrenderer, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, l);
    }
}

protected void mouseDragged(Minecraft par1Minecraft, int par2, int par3) {
    if (this.enabled && this.visible && this.packedFGColour == 0) {
        if (this.dragging) {
            this.sliderPosition = (float) (par2 - (this.xPosition + 4)) / (float) (this.width - 8);

            if (this.sliderPosition < 0.0F) {
                this.sliderPosition = 0.0F;
            }

            if (this.sliderPosition > 1.0F) {
                this.sliderPosition = 1.0F;
            }

        }

        this.displayString = label + ": " + (int) (sliderPosition * sliderMaxValue);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.drawTexturedModalRect(this.xPosition + (int) (this.sliderPosition * (float) (this.width - 8)), this.yPosition, 0, 66, 4, 20);
        this.drawTexturedModalRect(this.xPosition + (int) (this.sliderPosition * (float) (this.width - 8)) + 4, this.yPosition, 196, 66, 4, 20);
    }
}

public boolean mousePressed(Minecraft par1Minecraft, int par2, int par3) {
    if (super.mousePressed(par1Minecraft, par2, par3)) {
        this.sliderPosition = (float) (par2 - (this.xPosition + 4)) / (float) (this.width - 8);

        if (this.sliderPosition < 0.0F) {
            this.sliderPosition = 0.0F;
        }

        if (this.sliderPosition > 1.0F) {
            this.sliderPosition = 1.0F;
        }

        this.dragging = true;
        return true;
    } else {
        return false;
    }
}

public void mouseReleased(int par1, int par2) {
    this.dragging = false;
}
}