package me.creepinson.tileentity.render;

import java.util.Map;
import java.util.UUID;

import javax.annotation.Nullable;

import org.lwjgl.opengl.GL11;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.mojang.authlib.minecraft.MinecraftProfileTexture.Type;

import me.creepinson.block.model.ModelCreepinoSkull;
import me.creepinson.lib.util.Utils;
import me.creepinson.tileentity.TECreepinoSkull;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelHumanoidHead;
import net.minecraft.client.model.ModelSkeletonHead;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.common.model.TRSRTransformation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TESRCreepinoSkull extends TileEntitySpecialRenderer<TECreepinoSkull> {
	public static TESRCreepinoSkull instance;
	private static final ResourceLocation text = new ResourceLocation(Utils.MODID, "textures/blocks/creep_head.png");
	private final ModelCreepinoSkull skull = new ModelCreepinoSkull();

	public void renderTileEntityAt(TECreepinoSkull te, double x, double y, double z, float partialTicks,
			int destroyStage) {
		EnumFacing enumfacing = EnumFacing.getFront(te.getBlockMetadata() & 7);

		this.renderSkull((float) x, (float) y, (float) z, EnumFacing.NORTH, (float) (te.getSkullRotation() * 360) / 16.0F, destroyStage);
		this.renderSkull((float) x, (float) y, (float) z, EnumFacing.EAST, (float) (te.getSkullRotation() * 360) / 16.0F, destroyStage);
		this.renderSkull((float) x, (float) y, (float) z, EnumFacing.SOUTH, (float) (te.getSkullRotation() * 360) / 16.0F, destroyStage);
		this.renderSkull((float) x, (float) y, (float) z, EnumFacing.WEST, (float) (te.getSkullRotation() * 360) / 16.0F, destroyStage);

	
	
	}

	public void setRendererDispatcher(TileEntityRendererDispatcher rendererDispatcherIn) {
		super.setRendererDispatcher(rendererDispatcherIn);
		instance = this;
	}

	public void renderSkull(float x, float y, float z, EnumFacing facing, float p_188190_5_, int destroyStage) {
		
		ModelBase modelbase = this.skull;
		this.bindTexture(text);
		if (destroyStage >= 0) {
			this.bindTexture(DESTROY_STAGES[destroyStage]);
			GlStateManager.matrixMode(5890);
			GlStateManager.pushMatrix();
			GlStateManager.scale(4.0F, 2.0F, 1.0F);
			GlStateManager.translate(0.0625F, 0.0625F, 0.0625F);
			GlStateManager.matrixMode(5888);
			GlStateManager.popMatrix();
		} else {

		

		}

		GlStateManager.pushMatrix();
		GlStateManager.disableCull();

		if (facing == EnumFacing.UP) {
			GlStateManager.translate(x + 0.5F, y, z + 0.5F);
		} else {
			switch (facing) {
			case NORTH:
				GlStateManager.translate(x + 0.5F, y + 0.25F, z + 0.74F);
				break;
			case SOUTH:
				GlStateManager.translate(x + 0.5F, y + 0.25F, z + 0.26F);
				p_188190_5_ = 180.0F;
				break;
			case WEST:
				GlStateManager.translate(x + 0.74F, y + 0.25F, z + 0.5F);
				p_188190_5_ = 270.0F;
				break;
			case EAST:
			default:
				GlStateManager.translate(x + 0.26F, y + 0.25F, z + 0.5F);
				p_188190_5_ = 90.0F;
			}
			GlStateManager.popMatrix();
		}
		
	}
}