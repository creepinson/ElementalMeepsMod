package me.creepinson.api;

import net.minecraft.nbt.NBTTagCompound;

/**
 * Created by Creepinson on 7/9/2017.
 */
public class FileSystem {


    private Directory rootFolder;
    private Directory usersFolder;
    private Directory mainUserHome;
    public String username;


    public FileSystem(NBTTagCompound data)

    {

        if (!data.hasNoTags())

        {

            rootFolder = Directory.fromNBT(data);

        }

        setupDefaultSetup();

    }


    private void setupDefaultSetup()

    {

        if (username == null)
            username = "Core User";


        if (rootFolder == null)

        {

            rootFolder = new Directory("Root");

        }

        if (!rootFolder.hasFolder("Users"))

        {
            usersFolder = new Directory("Users");
            rootFolder.add(usersFolder, true);

        }

        if (rootFolder.hasFolder("Users")) {

            if (!getUsersFolder().hasFolder(username)) {

                mainUserHome = new Directory(username);
                usersFolder.add(mainUserHome, true);

            }

            if (getUsersFolder().hasFolder(username)) {
                if(!getUsersFolder().hasFolder("App Files")){
                    getUsersFolder().add(new Directory("App Files"));
                }
            }

        }


    }


    public Directory getRootFolder()

    {

        return rootFolder;

    }


    public Directory getUsersFolder()

    {

        return (Directory) rootFolder.getFile("Users");

    }


    public Directory getUserFolder(String username)

    {
        return (Directory) getUsersFolder().getFile(username);
    }

    public Directory getMainUserHome()

    {
        return (Directory) getUsersFolder().getFile("Core User");
    }

    public void removeUser(String username) {
        getUsersFolder().getFile(username).delete();
    }

    public void addUser(String username) {
        if (!getUsersFolder().hasFolder(username)) {
            getUsersFolder().add(new Directory(username));
            this.username = username;
        }
    }
}
