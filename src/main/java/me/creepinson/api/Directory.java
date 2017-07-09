package me.creepinson.api;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Creepinson on 7/9/2017.
 */
public class Directory extends File {

    private List<File> fileList = new ArrayList<>();

    public Directory(String folderName) {
        super(folderName);
    }


    public boolean add(File file) {
        return add(file, false);
    }

    public boolean add(File file, boolean override)

    {

        if (file == null)

            throw new IllegalArgumentException("A null file can not be added to a folder");


        if (hasFile(file.fileName))

        {

            if (!override) return false;

            fileList.remove(getFile(file.fileName));

        }


        fileList.add(file);

        file.parent = this;

        return true;

    }


    public void delete(String name) {
        File file = getFile(name);

        if (file != null)

        {

            file.parent = null;

            fileList.remove(file);

        }
    }


    public void delete(File file) {
        if (file != null) {
            file.parent = null;
            fileList.remove(file);
        }
    }


    public boolean hasFile(String name)

    {

        return fileList.stream().anyMatch(file -> file.fileName.equalsIgnoreCase(name));

    }


    @Nullable

    public File getFile(String name)

    {

        return fileList.stream().filter(file -> file.fileName.equalsIgnoreCase(name)).findFirst().orElse(null);

    }


    public boolean hasFolder(String name)

    {

        return fileList.stream().anyMatch(file -> file.isDirectory() && file.fileName.equalsIgnoreCase(name));

    }


    @Nullable

    public Directory getDirectory(String name)

    {

        return (Directory) fileList.stream().filter(file -> file.isDirectory() && file.fileName.equalsIgnoreCase(name)).findFirst().orElse(null);

    }


    public List<File> getFiles()

    {

        return fileList;

    }


    public void setFiles(List<File> files)

    {

        this.fileList = files;

    }


    @Override
    public boolean isDirectory()

    {

        return true;

    }


    @Override

    public NBTTagCompound toNBT()

    {

        NBTTagCompound tag = new NBTTagCompound();

        tag.setString("name", fileName);

        NBTTagList list = new NBTTagList();

        for (File file : fileList)

        {

            list.appendTag(file.toNBT());

        }

        tag.setTag("files", list);

        return tag;

    }


    public static Directory fromNBT(NBTTagCompound tag)

    {

        Directory folder = new Directory(tag.getString("name"));

        NBTTagList list = (NBTTagList) tag.getTag("files");

        for (int i = 0; i < list.tagCount(); i++)

        {

            NBTTagCompound fileTag = list.getCompoundTagAt(i);

            if (fileTag.hasKey("files"))

            {

                folder.add(Directory.fromNBT(fileTag));

            } else

            {

                folder.add(File.fromNBT(fileTag));

            }

        }

        return folder;

    }


    @Override

    public void setData(NBTTagCompound data)

    {

        throw new RuntimeException("Data can not be set to a folder");

    }


    @Override

    @Nullable

    public NBTTagCompound getData()

    {

        throw new RuntimeException("Folders do not contain data");

    }


    @Override

    public File copy()

    {

        Directory folder = new Directory(fileName);

        fileList.forEach(f -> {

            folder.add(f.copy());

        });

        return folder;

    }

}