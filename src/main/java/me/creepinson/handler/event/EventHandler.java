package me.creepinson.handler.event;

import me.creepinson.lib.util.Utils;
import me.creepinson.lib.util.render.RenderHelper;
import me.creepinson.lib.util.stuff.Meepon;
import me.creepinson.render.disguise.RenderDisguises;
import me.creepinson.render.particle.MoppityTextures;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class EventHandler {

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onTextureStitch(TextureStitchEvent event) {
        event.getMap().registerSprite(MoppityTextures.moppityAura);
        event.getMap().registerSprite(MoppityTextures.spark);
    }

    @SubscribeEvent
    public void renderBlockPlayer(RenderPlayerEvent.Pre event) {

        EntityPlayer player = event.getEntityPlayer();

        event.setCanceled(true);

        Utils.rh.currentBlock = new Meepon(Blocks.CLAY.getDefaultState(), player.getEntityWorld());
        Utils.rh.currentBlock.render(new BlockPos(0,0,0));


    }
}
