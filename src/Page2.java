import java.awt.GridLayout;
import java.awt.Font;
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
        //add selecl file
        setPanel(20, 490, 588, 166);
        setLabel(15,15,100,30,"Selecl File :",15);
        panel.add(label);
        setTextFeild(105, 15, 325, 30);
        panel.add(textField);
        setButton(435, 15, 80, 30, "SELECL");
        panel.add(button);
        setButton(518, 15, 55, 30, "OK");
        panel.add(button);

        //add people
        setLabel(15,55,100,30,"Population :",15);
        panel.add(label);
        setTextFeild(105,55, 325, 30);
        panel.add(textField);
        setButton(435, 55, 138, 30, "OK");
        panel.add(button);

        //
        setLabel(15,95,100,30,"Random     :",15);
        panel.add(label);
        setTextFeild(105,95, 325, 30);
        panel.add(textField);
        setButton(435, 95, 138, 30, "OK");
        panel.add(button);

        add(panel);
    }

    public void Frame3() {
        setPanel(630, 20, 370, 325);
        
        add(panel);
    }

    public void Frame4() {
        setPanel(630, 490, 370, 166);
        
        setTaggleButton(15, 15, 166, 140,"SELECL");
        panel.add(toggleButton);
        setTaggleButton(190, 15, 166, 140, "SELECL");
        panel.add(toggleButton);

        add(panel);
    }
}