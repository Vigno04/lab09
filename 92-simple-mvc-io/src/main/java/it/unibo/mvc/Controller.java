package it.unibo.mvc;

import java.io.File;
import java.util.Random;

import javax.swing.JFrame;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
 private static final String PATH = System.getProperty("user.home")
            + File.separator
            + Controller.class.getSimpleName() + ".txt";
    private static final int PROPORTION = 5;
    private final Random randomGenerator = new Random();
    private final JFrame frame = new JFrame(TITLE);
}
