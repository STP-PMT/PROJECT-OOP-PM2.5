import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Page1 extends MyPanel {
   
    private static final long serialVersionUID = 1L;

    public void setButton() {
        JButton button1;
        setPanel(630, 365, 370, 292, 0, 174, 169);
        setImagetoButton(20, 20, 330, 120, "src\\image\\menu1.png");
        button1 = getButton();
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                removeAll();
                add(setFrame2());
                setVisible(true);
            }
        });

        panel.add(button);
        setImagetoButton(20, 160, 330, 120, "src\\image\\menu2.png");
        panel.add(button);
        add(panel);
    }

    public void setPLogo() {
        setPanel(630, 20, 370, 325, 0, 174, 169);
        setImagetoPanel(0, 0, 370, 325, "src\\image\\pm.png");
        panel.add(label);
        add(panel);
    }

    public void setPShow() {
        setPanel(20, 20, 588, 450, 0, 174, 169);
        setImagetoPanel(20, 20, 548, 410, "src\\image\\Rain.gif");
        panel.add(label);
        add(panel);
    }

    public void setPButton2() {
        setPanel(20, 490, 588, 166, 0, 174, 169);
        setImagetoButton(20, 20, 125, 125, "src\\image\\p1.png");
        panel.add(button);
        setImagetoButton(162, 20, 125, 125, "src\\image\\p2.png");
        panel.add(button);
        setImagetoButton(299, 20, 125, 125, "src\\image\\p3.png");
        panel.add(button);
        setImagetoButton(436, 20, 125, 125, "src\\image\\p4.png");
        panel.add(button);
        add(panel);
    }

    public static JPanel setFrame2() {
        Page2 page2 = new Page2();
        page2.Frame1();
        page2.Frame2();
        page2.Frame3();
        page2.Frame4();
        return page2;
    }

    public static JPanel setFrame1() {
        Page1 page1 = new Page1();
        page1.setButton();
        page1.setPLogo();
        page1.setPShow();
        page1.setPButton2();
        return page1;
    }
}