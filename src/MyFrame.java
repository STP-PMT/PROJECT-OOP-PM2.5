import java.awt.Color;
import java.awt.Dimension;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;


public class MyFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private final int X_WIDTH = 1038;
    private final int Y_HIGTH = 715;

    public MyFrame() {
        setSize(X_WIDTH, Y_HIGTH);
        setTitle("PM2.5 Simulation");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setMinimumSize(new Dimension(X_WIDTH,Y_HIGTH));
        getContentPane().setBackground(new Color(39, 54, 73));
        setIcon();
    }

    public void setIcon() {
        try {
            setIconImage(ImageIO.read(new File("src\\image\\Icon.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}