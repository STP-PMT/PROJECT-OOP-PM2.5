
import javax.swing.JPanel;
public class App {
    
    public static void main(String[] args) throws Exception {
        MyFrame frame = new MyFrame();
        frame.add(setFrame1());
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

    public static JPanel setFrame3() {
        Page3 page3 = new Page3();
        page3.frame3();
        return page3;
    }
}

