import java.awt.Font;
public class App {
    public static void main(String[] args) throws Exception {
        MyFrame frame = new MyFrame();
        setFrame1(frame);
        //setFrame2(frame);
        frame.setVisible(true);
    }

    public static void setFrame1(MyFrame frame) {
        Page1 page1 = new Page1();
        page1.setButton();
        page1.setPLogo();
        page1.setPShow();
        page1.setPButton2();
        frame.add(page1);
    }

    public static void setFrame2(MyFrame frame) {
        Page2 page2 = new Page2();
        page2.Frame1();
        page2.Frame2();
        page2.Frame3();
        page2.Frame4();
        frame.add(page2);
    }
}
