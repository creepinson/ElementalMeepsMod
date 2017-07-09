package me.creepinson.item;

import java.util.Random;

import me.creepinson.core.MeeperTek;
import me.creepinson.handler.CreativeTabHandler;
import me.creepinson.handler.EnumHandler;
import me.creepinson.handler.EnumHandler.CrappedWandTypes;
import me.creepinson.render.particle.ParticleHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class ItemCrappedWand extends Item {
	Random rand = new Random();

	public ItemCrappedWand(String unlocalizedName, String registryName) {

		this.setRegistryName(registryName);
		this.setCreativeTab(CreativeTabHandler.MEEPR_WANDS);
		this.setHasSubtypes(true);
	}

	@Override
	public void getSubItems(Item item, CreativeTabs tab, NonNullList<ItemStack> items) {
		for (int i = 0; i < CrappedWandTypes.values().length; i++)
			items.add(new ItemStack(item, 1, i));

	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		for (int i = 0; i < CrappedWandTypes.values().length; i++) {
			if (stack.getItemDamage() == i) {
				return EnumHandler.CrappedWandTypes.values()[i].getName() + "wand";
			}

			else {
				continue;
			}

		}
		return EnumHandler.CrappedWandTypes.crapology.getName() + "wand";

	}

	@Override

	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {

		if (!world.isRemote) {

			ParticleHandler ph = MeeperTek.ph;
			RayTraceResult pos = player.rayTrace(100, 20);

			double x = pos.getBlockPos().getX();

			double y = pos.getBlockPos().getY();

			double z = pos.getBlockPos().getZ();

			switch (player.getHeldItem(hand).getMetadata()) {
			case 0:
				ph.spark(player);
				
				break;
			case 1:
				moppityWand(world, player, hand);
				break;
			}

			return new ActionResult(EnumActionResult.SUCCESS, new ItemStack(this));
		} else {

			return new ActionResult(EnumActionResult.FAIL, new ItemStack(this));

		}

	}

	public void moppityWand(World world, EntityPlayer player, EnumHand hand) {

	}

}
