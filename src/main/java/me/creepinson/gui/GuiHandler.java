package me.creepinson.gui;

import me.creepinson.block.tileentitty.TileComputerCore;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

/**
 * Created by Creepinson on 7/10/2017.
 */
public class GuiHandler implements IGuiHandler
{


    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

            return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        if(ID == 0){



            TileEntity tileEntity = player.worldObj.getTileEntity(new BlockPos(x, y, z));

            if(tileEntity instanceof TileComputerCore)

            {

                TileComputerCore computerCore = (TileComputerCore) tileEntity;

                return new Computer(computerCore.getAppData(), x, y, z);

            }
        }
        return null;
    }
}
