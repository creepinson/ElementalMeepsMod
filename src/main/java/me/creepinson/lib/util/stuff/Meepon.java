package me.creepinson.lib.util.stuff;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.UUID;

import static net.minecraft.util.EnumBlockRenderType.MODEL;

/**
 * Created by Creepinson on 6/30/2017.
 */
public class Meepon {


    private static final Minecraft mc = Minecraft.getMinecraft();


    private IBlockState renderingState;
    private World world = null;

    public Meepon(IBlockState state, World worldIn) {

        this.renderingState = state;
        this.world = worldIn;


    }

    public void render(BlockPos blockpos) {


        if (renderingState.getRenderType() == MODEL) {

            GlStateManager.pushMatrix();

            mc.getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);

            Tessellator tessellator = Tessellator.getInstance();

            VertexBuffer vertexbuffer = tessellator.getBuffer();


            vertexbuffer.begin(7, DefaultVertexFormats.BLOCK);


            GlStateManager.disableLighting();
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 15 * 16, 15 * 16);
            GlStateManager.translate((float) ((double) blockpos.getX() - 0.5D), (float) ((double) blockpos.getY()), (float) (double) blockpos.getZ() - 0.5D);
            BlockRendererDispatcher blockrendererdispatcher = Minecraft.getMinecraft().getBlockRendererDispatcher();
            blockrendererdispatcher.getBlockModelRenderer().renderModel(world, blockrendererdispatcher.getModelForState(renderingState), renderingState, blockpos, vertexbuffer, false, MathHelper.getPositionRandom(blockpos));
            tessellator.draw();
            GlStateManager.enableLighting();
            GlStateManager.popMatrix();


        }

    }
}