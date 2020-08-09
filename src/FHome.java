import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Button;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FHome extends JFrame {
    private static final long serialVersionUID = 1L;
    private final int X_WIDTH = 1038;
    private final int Y_HIGTH = 715;

    private JPanel panel;

    public FHome() {
        setSize(X_WIDTH, Y_HIGTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
    }

    public void setPButton() {
        panel = new JPanel(null);
        panel.setBounds(630, 365, 370, 292);
        panel.setBackground(new Color(255, 0, 0));

        Button b1 = new Button("Home");
        Button b2 = new Button("Home");

        b1.setBounds(20, 20, 330, 120);
        b2.setBounds(20, 160, 330, 112);

        panel.add(b1);
        panel.add(b2);
        add(panel);
    }

    public void setPLogo() {
        panel = new JPanel(null);
        panel.setBounds(630, 20, 370, 325);
        panel.setBackground(new Color(255, 0, 0));
        add(panel);
    }

    public void setPShow() {
        panel = new JPanel(null);
        panel.setBounds(20, 20, 588, 450);
        panel.setBackground(new Color(255, 0, 0));
        add(panel);
    }

    public void setPButton2() {
        panel = new JPanel(null);
        panel.setBounds(20, 490, 588, 166);
        panel.setBackground(new Color(255, 0, 0));

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

    public JPanel setPanel(int XL, int YL, int XW, int YH) {
        JPanel panel = new JPanel(null);
        panel.setBounds(XL, YL, XW, YH);
        return panel;
    }
}