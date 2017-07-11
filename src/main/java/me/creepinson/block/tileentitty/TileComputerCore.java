package me.creepinson.block.tileentitty;

import net.minecraft.block.BlockClay;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.items.CapabilityItemHandler;

public class TileComputerCore extends TileEntity implements ITickable, ICapabilityProvider {

    private NBTTagCompound data;

    public TileComputerCore() {
        this.data = new NBTTagCompound();
    }

    public NBTTagCompound getAppData()

    {

        return data;

    }


    public void setAppData(NBTTagCompound data)

    {

        this.data = data;

        markDirty();

    }

    @Override
    public void update() {


    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);

        this.data = compound.getCompoundTag("AppFiles");

    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {

        compound.setTag("AppFiles", data);
        return compound;
    }

    @Override

    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt)

    {

        this.readFromNBT(pkt.getNbtCompound());

    }



    @Override

    public SPacketUpdateTileEntity getUpdatePacket()

    {

        return new SPacketUpdateTileEntity(pos, getBlockMetadata(), this.writeToNBT(new NBTTagCompound()));

    }



    @Override

    public NBTTagCompound getUpdateTag()

    {

        return this.writeToNBT(new NBTTagCompound());

    }

    //
//    @Override
//    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
//        return super.getCapability(capability, facing);
//    }
//
//    @Override
//    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
//        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
//            return true;
//
//        return super.hasCapability(capability, facing);
//    }
}
