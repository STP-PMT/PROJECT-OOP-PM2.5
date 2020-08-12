import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Insets;

import java.io.File;
import java.io.IOException;

public class MyPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private final int X_WIDTH = 1038;
    private final int Y_HIGTH = 715;

    protected JPanel panel;
    protected JLabel label;
    protected JButton button;
    protected JTextField textField;
    protected Insets insets;
    protected JToggleButton toggleButton;
    protected Font font;

    public MyPanel() {
        setSize(X_WIDTH, Y_HIGTH);
        setLayout(null);
        setBackground(new Color(39, 54, 73));
    }

    public void setPanel(int Xl, int Yl, int X, int Y, int r, int g, int b) {
        insets = this.getInsets();
        this.panel = new JPanel(null);
        this.panel.setBounds(Xl, Yl, X, Y);
        this.panel.setBackground(new Color(r, g, b));
        this.repaint();
    }

    public void setPanel(int Xl, int Yl, int X, int Y) {
        this.panel = new JPanel(null);
        this.panel.setBounds(Xl, Yl, X, Y);
        this.panel.setBackground(new Color(0, 174, 169));
        this.repaint();
    }

    public JPanel getPanel() {
        return this.panel;
    }

    public void setImagetoButton(int Xl, int Yl, int X, int Y, String Url) {
        this.button = new JButton(new ImageIcon(Url));
        this.button.setBounds(Xl, Yl, X, Y);
    }

    public JButton getImagetoButton() {
        return this.button;
    }

    public void setImagetoPanel(int Xl, int Yl, int X, int Y, String Url) {
        this.label = new JLabel(new ImageIcon(Url));
        this.label.setBounds(Xl, Yl, X, Y);
    }

    public JLabel getImagetoPanel() {
        return this.label;
    }

    public void setTextFeild(int Xl, int Yl, int X, int Y) {
        this.textField = new JTextField();
        this.textField.setBounds(Xl, Yl, X, Y);
    }

    public JTextField getTextFeild() {
        return textField;
    }

    public void setButton(int Xl, int Yl, int X, int Y, String name) {
        this.button = new JButton(name);
        this.button.setBounds(Xl, Yl, X, Y);
    }

    public void setButton(int Xl, int Yl, int X, int Y) {
        this.button = new JButton();
        this.button.setBounds(Xl, Yl, X, Y);
    }

    public void setButton(int Xl, int Yl, int X, int Y,String name,int size) {
        this.button = new JButton(name);
        this.button.setFont(new Font(name,Font.BOLD,size));
        this.button.setBounds(Xl, Yl, X, Y);
    }

    public void setLabel(int Xl, int Yl, int X, int Y, String text,int size) {
        this.label = new JLabel(text);
        this.label.setBounds(Xl, Yl, X, Y);
        this.label.setFont(new Font(text, Font.BOLD, size));
    }

    public void setTaggleButton(int Xl, int Yl, int X, int Y) {
        toggleButton = new JToggleButton();
        toggleButton.setBounds(Xl, Yl, X, Y);
    }

    public void setTaggleButton(int Xl, int Yl, int X, int Y, String name) {
        toggleButton = new JToggleButton(name);
        toggleButton.setBounds(Xl, Yl, X, Y);
    }

    public void setTaggleButton(int Xl, int Yl, int X, int Y, String name,int size) {
        toggleButton = new JToggleButton(name);
        toggleButton.setFont(new Font(name,Font.BOLD,size));
        toggleButton.setBounds(Xl, Yl, X, Y);
    }

    public JToggleButton getToggleButton(){
        return this.toggleButton;
    }

    public JButton getButton(){
        return this.button;
    }

}