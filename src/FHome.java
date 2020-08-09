import java.awt.Button;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FHome extends JFrame {
    private static final long serialVersionUID = 1L;
    private final int X_WIDTH = 1038;
    private final int Y_HIGTH = 715;

    private JPanel panel;

    public FHome() {
        setSize(X_WIDTH, Y_HIGTH);
        setTitle("PM 2.5");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(true);
        getContentPane().setBackground(new Color(39,54,73));
        try {
            setIconImage(ImageIO.read(new File("src\\image\\Icon.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setPButton() {
        panel = new JPanel(null);
        panel.setBounds(630, 365, 370, 292);
        panel.setBackground(new Color(0, 174, 169));

        JButton b1 = new JButton(new ImageIcon("src\\image\\menu1.png"));
        b1.setBounds(20, 20, 330, 120);
        panel.add(b1);

        JButton b2 = new JButton(new ImageIcon("src\\image\\menu2.png"));
        b2.setBounds(20, 160, 330, 120);
        panel.add(b2);

        //b1.setBounds(20, 20, 330, 120);
        //b2.setBounds(20, 160, 330, 112);

        //panel.add(b1);
        //panel.add(b2);
        add(panel);
    }

    public void setPLogo() {
        panel = new JPanel(null);
        JLabel picLabel = new JLabel(new ImageIcon("src\\image\\pm.png"));
        picLabel.setBounds(0, 0, 370, 325);
        panel.add(picLabel);
        panel.setBounds(630, 20, 370, 325);
        panel.setBackground(new Color(255, 0, 0));
        add(panel);
    }

    public void setPShow() {
        panel = new JPanel(null);
        JLabel picLabel = new JLabel(new ImageIcon("src\\image\\Rain.gif"));
        picLabel.setBounds(20, 20, 548, 410);
        panel.add(picLabel);

        panel.setBounds(20, 20, 588, 450);
        panel.setBackground(new Color(0, 174, 169));
        add(panel);
    }

    public void setPButton2() {
        panel = new JPanel(null);
        panel.setBounds(20, 490, 588, 166);
        panel.setBackground(new Color(0, 174, 169));

        JButton b1 = new JButton(new ImageIcon("src\\image\\p1.png"));
        b1.setBounds(20, 20, 125, 125);
        panel.add(b1);
        JButton b2 = new JButton(new ImageIcon("src\\image\\p2.png"));
        b2.setBounds(162, 20, 125, 125);
        panel.add(b2);
        JButton b3 = new JButton(new ImageIcon("src\\image\\p3.png"));
        b3.setBounds(299, 20, 125, 125);
        panel.add(b3);
        JButton b4 = new JButton(new ImageIcon("src\\image\\p4.png"));
        b4.setBounds(436, 20, 125, 125);
        panel.add(b4);

        add(panel);
    }
}