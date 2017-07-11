package me.creepinson.block;

import java.awt.Robot;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.Nullable;

import me.creepinson.block.tileentitty.TileComputerCore;
import me.creepinson.core.ElementalMeeps;
import me.creepinson.lib.proxy.CommonProxy;
import me.creepinson.lib.util.ClientUtils;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ComputerCore extends ModBlocks  implements ITileEntityProvider {

    public ComputerCore(Material mat, String name, CreativeTabs tab, float hardness, float resistance, int harvest,
                        String tool) {
        super(mat, name, tab, hardness, resistance, harvest, tool);
    }


    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {

            CommonProxy.openGui(0, playerIn, worldIn, ElementalMeeps.instance, pos.getX(), pos.getY(), pos.getZ());

        return true;

    }

    @Override
    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, @Nullable ItemStack stack) {
        super.harvestBlock(worldIn, player, pos, state, te, stack);

        worldIn.removeTileEntity(pos);

    }


    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileComputerCore();
    }
}
