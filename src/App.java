import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
public class App {
    
    public static void main(String[] args) throws Exception {
        MyFrame frame = new MyFrame();
        frame.add(setFrame1());
        //setFrame2(frame);
        frame.setVisible(true);
    }

    public static JPanel setFrame1() {
        Page1 page1 = new Page1();
        page1.setButton();
        page1.setPLogo();
        page1.setPShow();
        page1.setPButton2();
        return page1;
    }

    public static JPanel setFrame2() {
        Page2 page2 = new Page2();
        page2.Frame1();
        page2.Frame2();
        page2.Frame3();
        page2.Frame4();
        return page2;
    }
}
