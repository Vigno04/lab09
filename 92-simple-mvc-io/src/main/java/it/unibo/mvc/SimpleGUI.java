package it.unibo.mvc;
import java.awt.Dimension;
import java.awt.TextArea;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final String TITLE = "My first java graphical interface";
    private final JFrame frame = new JFrame(TITLE);

    public SimpleGUI(){
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        final TextArea textArea = new TextArea();
        canvas.add(textArea, BorderLayout.NORTH);
        final JButton write = new JButton("Save");
        canvas.add(write, BorderLayout.SOUTH);
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Controller controller = new Controller();
        write.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
            }
        });
    }

    private void display() {
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(final String... args) {
        new SimpleGUI().display();
     }
}