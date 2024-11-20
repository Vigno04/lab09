package it.unibo.mvc;

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;

/**
 * A very simple program using a graphical interface.
 */
public final class SimpleGUI {

    private static final String TITLE = "My first java graphical interface";
    private static final int W_PROPORTION = 2;
    private static final int H_PROPORTION = 2;
    private static final int FONT_SIZE = 20;

    private final JFrame frame = new JFrame(TITLE);
    private final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    private final int sw = (int) screen.getWidth();
    private final int sh = (int) screen.getHeight();

    /**
     * Constructor for SimpleGUI.
     */
    public SimpleGUI() {
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        final JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, FONT_SIZE));
        canvas.add(textArea, BorderLayout.CENTER);
        final JButton save = new JButton("Save");
        canvas.add(save, BorderLayout.SOUTH);
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final Controller controller = new Controller(null);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.writeFile(textArea.getText());
            }
        });
    }

    /**
     * Displays the GUI.
     */
    private void display() {
        frame.setLocationByPlatform(true);
        frame.setSize(sw / W_PROPORTION, sh / H_PROPORTION);
        frame.setVisible(true);
    }

    /**
     * Main method to run the GUI application.
     * @param args the command line arguments
     */
    public static void main(final String... args) {
        new SimpleGUI().display();
    }
}
