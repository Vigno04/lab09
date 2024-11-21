package it.unibo.mvc;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();
    private final Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    private final int width = (int) dimension.getWidth();
    private final int height = (int) dimension.getHeight();
    private final Controller controller = new SimpleController();
    private final Font buttonFont = new Font("Arial", Font.BOLD, 20);
    private final Font textFont = new Font("Arial", Font.PLAIN, 18);

    /**
    * Constructs a SimpleGUI object and initializes the GUI components.
    */
    @SuppressFBWarnings(
        value = { "EI_EXPOSE_REP2" },
        justification = "The controller is designed to be manipulated this way."
    )
    public SimpleGUI() {

        // Creation of the UI elements
        final JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        final JTextField textField = new JTextField();
        textField.setFont(textFont);
        textField.setText("write here!");
        mainPanel.add(textField, BorderLayout.NORTH);
        final JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(textFont);
        mainPanel.add(textArea, BorderLayout.CENTER);

        final JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 2));
        final JButton printButton = new JButton("Print");
        printButton.setFont(buttonFont);
        final JButton showHistoryButton = new JButton("Show history");
        showHistoryButton.setFont(buttonFont);
        bottomPanel.add(printButton);
        bottomPanel.add(showHistoryButton);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        // Set the size and standard option of the frame
        frame.setContentPane(mainPanel);
        frame.setSize(width / 4, height / 3);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Simple GUI");
        frame.setLocationByPlatform(true);

        // Set the action of the buttons
        printButton.addActionListener(e -> {
            controller.setNextString(textField.getText());
            controller.printCurrentString();
            textField.setText("");
        });
        showHistoryButton.addActionListener(e -> {
            for (final String string : controller.getStringsHistory()) {
                textArea.append(string + "\n");
            }
        });

    }
    private void display() {
        frame.setVisible(true);
    }

    /**
    * The main method to run the SimpleGUI application.
    *
    * @param args the command line arguments
    */
    public static void main(final String[] args) {
        new SimpleGUI().display();
    }

}
