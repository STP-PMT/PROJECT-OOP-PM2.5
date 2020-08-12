import java.awt.GridLayout;
import javax.swing.JButton;

public class Page2 extends MyPanel {

    private static final long serialVersionUID = 1L;

    public void Frame1() {
        setPanel(20, 20, 588, 450, 39, 54, 73);
        panel.setLayout(new GridLayout(10, 20));
        button = new JButton();
        for (int i = 1; i <= 200; i++) {
            panel.add(new JButton());
        }
        add(panel);
    }

    public void Frame2() {
        setPanel(20, 490, 588, 166);
        add(panel);
    }

    public void Frame3() {
        setPanel(630, 20, 370, 325);
        add(panel);
    }

    public void Frame4() {
        setPanel(630, 365, 370, 292);
        setTextFeild(15, 25, 200, 30);
        panel.add(textField);
        setButton(220, 25, 80, 30, "SELECL");
        panel.add(button);
        setButton(305, 25, 55, 30, "OK");
        panel.add(button);

        setTextFeild(15,65, 200, 30);
        panel.add(textField);
        setButton(220, 65, 140, 30, "OK");
        panel.add(button);

        setTextFeild(15,105, 200, 30);
        panel.add(textField);
        setButton(220, 105, 140, 30, "OK");
        panel.add(button);

        setTaggleButton(15, 150, 170, 90, "SELECL");
        panel.add(toggleButton);
        setTaggleButton(190, 150, 170, 90, "SELECL");
        panel.add(toggleButton);

        add(panel);
    }
}