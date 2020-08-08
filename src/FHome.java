import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Button;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FHome extends JFrame {
    private static final long serialVersionUID = 1L;
    private final int X_WIDTH = 1038;
    private final int Y_HIGTH = 715;

    public FHome() {
        setPreferredSize(new Dimension(X_WIDTH, Y_HIGTH));
        setMinimumSize(new Dimension(X_WIDTH,Y_HIGTH));
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        //setResizable(false);
        setBackground(new Color(255,0,0));
        
    }

    public void setPHome() {
        JPanel p1 = new JPanel(null);
        p1.setSize(370,292);
        p1.setLocation(630,365);
        p1.setBackground(new Color(255,0,0));
        Button b1 = new Button("Home");
        Button b2 = new Button("Home");
        b1.setSize(350,130);
        b1.setLocation(10,10);
        b2.setSize(350,130);
        b2.setLocation(10,150);
        p1.add(b1);
        p1.add(b2);
        add(p1);
    }
}