import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Insets;


public class MyPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private final int X_WIDTH = 1038;
    private final int Y_HIGTH = 715;

    protected JPanel panel;
    protected JLabel label;
    protected JButton button;
    protected JTextField textField;
    protected Insets insets;

    public MyPanel() {
        setSize(X_WIDTH, Y_HIGTH);
        setLayout(null);
        setBackground(new Color(39, 54, 73));
    }

    public void setPanel(int Xl, int Yl, int X, int Y, int r, int g, int b) {
        insets = this.getInsets();
        this.panel = new JPanel(null);
        this.panel.setBounds(Xl+ insets.left, Yl+insets.right, X+insets.top, Y+insets.bottom);
        this.panel.setBackground(new Color(r, g, b));
        repaint();
    }

    public void setPanel(int Xl, int Yl, int X, int Y) {
        this.panel = new JPanel(null);
        this.panel.setBounds(Xl+ insets.left, Yl+insets.right, X+insets.top, Y+insets.bottom);
        this.panel.setBackground(new Color(0, 174, 169));
        repaint();
    }

    public JPanel getPanel() {
        return this.panel;
    }

    public void setImagetoButton(int Xl, int Yl, int X, int Y, String Url) {
        button = new JButton(new ImageIcon(Url));
        button.setBounds(Xl, Yl, X, Y);
    }

    public JButton getImagetoButton() {
        return this.button;
    }

    public void setImagetoPanel(int Xl, int Yl, int X, int Y, String Url) {
        label = new JLabel(new ImageIcon(Url));
        label.setBounds(Xl, Yl, X, Y);
    }

    public JLabel getImagetoPanel() {
        return this.label;
    }

    public void setTextFeild(int Xl, int Yl, int X, int Y){
        textField = new JTextField();
        textField.setBounds(Xl, Yl, X, Y);
    }

    public void setButton(int Xl, int Yl, int X, int Y,String name){
        button = new JButton(name);
        button.setBounds(Xl, Yl, X, Y);
    }

    public void setButton(int Xl, int Yl, int X, int Y){
        button = new JButton();
        button.setBounds(Xl, Yl, X, Y);
    }

    public void setLabel(int Xl, int Yl, int X, int Y,String text,int font){
        label = new JLabel(text);
        label.setBounds(Xl, Yl, X, Y);
        label.setFont(new Font(text, Font.PLAIN, font));
    }
}