package it.unibo.mvc;

import java.util.List;

/**
 * Controller is an interface that defines the methods that a controller class must implement.
 */
public interface Controller {

    /**
     * Sets the next string to print.
     * @param nextString the next string to print
     */
    void setNextString(String nextString);

    /**
     * Gets the next string to print.
     * @return the next string to print
     */
    String getNextString();

    /**
     * Gets the history of strings.
     * @return the history of strings
     */
    List<String> getStringsHistory();

    /**
     * Prints the current string.
     */
    void printCurrentString();
}
