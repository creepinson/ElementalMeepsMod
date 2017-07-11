package me.creepinson.lib.proxy;

import me.creepinson.block.tileentitty.TileComputerCore;
import me.creepinson.core.ElementalMeeps;
import me.creepinson.gui.GuiHandler;
import me.creepinson.handler.BlockHandler;
import me.creepinson.handler.ItemHandler;
import me.creepinson.handler.event.EventHandler;
import me.creepinson.lib.util.Utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy implements IProxy {
    public void registerRenderers() {

        ItemHandler.registerRenders();
        BlockHandler.registerRenders();

    }

    @Override
    public void preInit() {


    }

    public static void openGui(int guiID, EntityPlayer player, World world, Object instance, int x, int y, int z) {

        player.openGui(instance, guiID, world, x, y, z);


    }

    @Override
    public void init() {


        GameRegistry.registerTileEntity(TileComputerCore.class,
                Utils.MODID + ":" + "tilecomputercore");

    }

    @Override
    public void postInit() {


    }

}