package it.unibo.mvc;

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Paths;
import java.awt.Toolkit;
import javax.swing.JFileChooser;

/**
 * A very simple program using a graphical interface.
 */
public final class SimpleGUIWithFileChooser {

    private static final String TITLE = "My Second java graphical interface";
    private static final int W_PROPORTION = 2;
    private static final int H_PROPORTION = 2;
    private static final int FONT_SIZE = 20;

    private final JFrame frame = new JFrame(TITLE);
    private final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    private final int sw = (int) screen.getWidth();
    private final int sh = (int) screen.getHeight();

    /**
    * This class creates a GUI with options to browse for a text file and display its path,
    * as well as a text area for editing and a save button to save the content.
     */
    public SimpleGUIWithFileChooser() {
        final JPanel canvas = new JPanel();
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas.setLayout(new BorderLayout());


        final JPanel fileBrowser = new JPanel();
        fileBrowser.setLayout(new BorderLayout());
        canvas.add(fileBrowser, BorderLayout.NORTH);

        final JTextArea filePath = new JTextArea();
        filePath.setFont(new Font("Arial", Font.PLAIN, FONT_SIZE));
        filePath.setText(System.getProperty("user.home") + File.separator + "output.txt");
        filePath.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.BLACK));
        final JButton browse = new JButton("Browse");
        fileBrowser.add(filePath, BorderLayout.CENTER);
        fileBrowser.add(browse, BorderLayout.EAST);
        browse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                final FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
                fileChooser.setFileFilter(filter);
                final int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    final File selectedFile = fileChooser.getSelectedFile();
                    filePath.setText(selectedFile.getAbsolutePath());
                } else if (returnValue != JFileChooser.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(null, "Error in opening selected file", "Error", JOptionPane.ERROR_MESSAGE);

                }

            }
        });

        final JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, FONT_SIZE));
        canvas.add(textArea, BorderLayout.CENTER);

        final JButton save = new JButton("Save");
        canvas.add(save, BorderLayout.SOUTH);

        final Controller controller = new Controller(Paths.get(filePath.getText()));
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
    * The main method to launch the SimpleGUIWithFileChooser application.
    *
    * @param args the command line arguments (not used)
    */
    public static void main(final String... args) {
        final SimpleGUIWithFileChooser gui = new SimpleGUIWithFileChooser();
        gui.display();
    }
}
