package it.unibo.mvc;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private static final String PATH = System.getProperty("user.home")
            + File.separator
            + "output.txt";
    private File file = new File(PATH);

    // Constructor
    public Controller(File file) {
        this.file = file;
    }
    public Controller() {
    }
    public void setFile(File file) {
        this.file = file;
    }
    public File getFile() {
        return this.file;
    }
    public Path getPath() {
        return this.file.toPath();
    }
    //Return the file path as a string
    public String getStringPath() {
        return String.valueOf(this.getPath());
    }
    public void writeFile(String content) {
        try {
            Files.writeString(this.getPath(), content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
