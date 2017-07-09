package me.creepinson.api;

import net.minecraft.nbt.NBTTagCompound;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Created by Creepinson on 7/9/2017.
 */
public class File {

    protected String fileName;
    protected Directory parent;
    private NBTTagCompound data;

    public File(String fileName, NBTTagCompound data) {
        this.fileName = fileName;
        this.data = data;
    }

    protected File(String fileName) {
        this.fileName = fileName;
    }

    public NBTTagCompound getData() {
        return data;
    }

    public boolean delete()

    {

        if (parent != null)

        {

            parent.delete(this);

            return true;

        }
        return false;
    }

    public void setData(@Nonnull NBTTagCompound newData) {

        if (newData == null)

        {

            throw new RuntimeException("A null compound tag cannot be set to a file");

        }

        this.data = newData;

    }


    public boolean isDirectory()

    {

        return false;

    }


    public NBTTagCompound toNBT() {

        NBTTagCompound tag = new NBTTagCompound();

        tag.setString("name", fileName);

        tag.setTag("data", data);

        return tag;

    }


    public static File fromNBT(NBTTagCompound tag) {
        return new File(tag.getString("name"), tag.getCompoundTag("data"));
    }

    @Override

    public boolean equals(Object obj) {
        if (obj == null) return false;

        if (!(obj instanceof File)) return false;

        return ((File) obj).fileName.equalsIgnoreCase(fileName);
    }

    public File copy() {
        return new File(fileName, data.copy());
    }

    @Nullable

    public Directory getParent()

    {

        return parent;

    }


    public String getName()

    {

        return fileName;

    }


}
