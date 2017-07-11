package me.creepinson.api;

/**
 * Created by Creepinson on 7/9/2017.
 */
public class User {

    public Directory homeFolder;
    private String username;

    public User(String username, FileSystem fileSystem) {

        this.username = username;
        if (!fileSystem.getUsersFolder().hasFolder(username)) {
            fileSystem.addUser(username);
            this.homeFolder = fileSystem.getUserFolder(username);
        } else {
            this.homeFolder = fileSystem.getUserFolder(username);

        }
    }


    public User(FileSystem fileSystem) {

        this.username = "User 1";
        if (!fileSystem.getUsersFolder().hasFolder("Core User")) {
            fileSystem.addUser("User 1");
            this.homeFolder = fileSystem.getUserFolder("Core User");

        } else {
            this.homeFolder = fileSystem.getUserFolder("Core User");
        }
    }


    public String getUsername() {
        return username;
    }

}
