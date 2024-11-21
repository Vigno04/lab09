package it.unibo.mvc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * SimpleController is a concrete implementation of the Controller interface.
 * It manages a history of strings and allows setting, getting, and printing the current string.
 */
public class SimpleController implements Controller {

    private final List<String> stringsHistory = new LinkedList<>();
    private String nextString;

    /**
     * Sets the next string to be managed by the controller.
     * 
     * @param nextString the next string to be set
     * @throws IllegalArgumentException if the next string is null
     */
    @Override
    public void setNextString(final String nextString) {
        if (nextString == null) {
            throw new IllegalArgumentException("The next string cannot be null");
        } else {
            this.nextString = nextString;
        }
    }

    /**
     * Gets the next string managed by the controller.
     * 
     * @return the next string
     */
    @Override
    public String getNextString() {
        return this.nextString;
    }

    /**
     * Gets the history of strings managed by the controller.
     * 
     * @return a list of strings representing the history
     */
    @Override
    public List<String> getStringsHistory() {
        return new ArrayList<>(this.stringsHistory);
    }

    /**
     * Prints the current string to the standard output and adds it to the history.
     * 
     * @throws IllegalStateException if the next string is not set
     */
    @Override
    public void printCurrentString() {
        if (nextString == null) {
            throw new IllegalStateException("The next string is not set");
        } else {
            System.out.println(this.nextString); // NOPMD: requested by the assignment
            stringsHistory.add(this.nextString);
        }
    }

}
