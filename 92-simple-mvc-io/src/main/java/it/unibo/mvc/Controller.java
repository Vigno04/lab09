package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private static final String PATH = System.getProperty("user.home")
            + File.separator
            + "output.txt";
    private File file = new File(PATH);

    /**
    * Constructor.
    * @param path the path to the file.
    */
    public Controller(final Path path) {
        if (path != null) {
            this.file = path.toFile();
        }
    }

    /**
    * Sets the file that controller points to.
    * @param file the file to set
    */
    public void setFile(final File file) {
        this.file = file;
    }

    /**
    * Gets the file that controller points to.
    * @return the file
    */
    public File getFile() {
        return this.file;
    }

    /**
     * Gets the path of the file that controller points to.
     * @return the path
     */
    public Path getPath() {
        return this.file.toPath();
    }

    /**
     * Gets the path of the file that controller points to as a string.
     * @return the path
     */
    public String getStringPath() {
        return String.valueOf(this.getPath());
    }

    /**
     * Writes the content to the file.
     * @param content the content to write
     */
    public void writeFile(final String content) {
        try {
            Files.writeString(this.getPath(), content);
        } catch (IOException e) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, "error in the writing of the file", e);

        }
    }
}
