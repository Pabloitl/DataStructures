package Tarea6.Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Graphics {
    JFrame window;
    JPanel panel;
    JLabel imgLabel;
    private static int DIM = 500;

    public Graphics() {
        window = new JFrame();
        panel = new JPanel();
        imgLabel = new JLabel();

        configure();
    }

    private void configure() {
        String title = "Imagenes";
        Dimension size = new Dimension(DIM, DIM);

        window.setTitle(title);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setSize(size);
        panel.add(imgLabel);
        window.add(panel);
        window.setVisible(true);
    }

    /** Retorna el directorio seleccionado  por el usuario */
    public static String chooseDir(String title) {
        String currentDir = ".";
        JFileChooser prompt = new JFileChooser();

        prompt.setCurrentDirectory(new java.io.File(currentDir));
        prompt.setDialogTitle(title);
        prompt.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        prompt.setAcceptAllFileFilterUsed(false);
        if(prompt.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            return prompt.getSelectedFile().toString();
        System.exit(0);
        return "";
    }

    /** Muestra la imagen al usuario */
    public void changeImage(String image) {
        ImageIcon img = new ImageIcon(new ImageIcon(image)
                .getImage()
                .getScaledInstance(DIM, DIM, Image.SCALE_FAST));

        imgLabel.setIcon(img);
    }


    /** Muesta un mensaje al usuario */
    public static void alert(String msg) {
        JOptionPane.showMessageDialog(null,
                msg,
                null,
                JOptionPane.PLAIN_MESSAGE);
    }
}
