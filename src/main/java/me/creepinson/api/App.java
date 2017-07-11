package me.creepinson.api;

import javax.annotation.Nullable;

/**
 * Created by Creepinson on 7/10/2017.
 */
public class App {
    private FileSystem fileSystem;
    private final String NAME;
    private final String displayName;

    public App(String name, String displayName){
        this.NAME = name;
        this.displayName = displayName;
    }

    public void setFileSystem(FileSystem fileSystem)

    {

        this.fileSystem = fileSystem;

    }



    public FileSystem getFileSystem()

    {

        return fileSystem;

    }
    @Nullable
    public Directory getApplicationFolder()

    {

        Directory home = fileSystem.getMainUserHome();

        if(home.hasFolder("Application Data"))

        {

            Directory apps = (Directory) home.getFile("App Files");

            if(!apps.hasFolder(NAME))

            {

                apps.add(new Directory(NAME), true);

            }

            return (Directory) apps.getFile(NAME);

        }

        return null;

    }

}
