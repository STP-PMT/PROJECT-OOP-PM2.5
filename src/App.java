
import javax.swing.JPanel;
public class App {
    
    public static void main(String[] args) throws Exception {
        MyFrame frame = new MyFrame();
        frame.add(setFrame1());
        frame.setVisible(true);
        
    }

    public static JPanel setFrame1() {
        Page1 page1 = new Page1();
        page1.setPanelMenu();
        page1.setPanelLogo();
        page1.setPanelRain();
        page1.setPanelFace();
        return page1;
    }

    public static JPanel setFrame3() {
        Page3 page3 = new Page3();
        page3.frame3();
        return page3;
    }
}

