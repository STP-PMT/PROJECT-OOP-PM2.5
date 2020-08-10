
public class App {
    public static void main(String[] args) throws Exception {
        //MyFrame frame1 = new MyFrame();
        MyFrame frame2 = new MyFrame();

        //setFrame1(frame1);
        setFrame2(frame2);
        //frame1.setVisible(true);
        frame2.setVisible(true);
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
        //page2.setLayout(new BoxLayout(page2,BoxLayout.Y_AXIS));
        page2.Frame1();
        page2.Frame2();
        page2.Frame3();
        page2.Frame4();
        frame.add(page2);
    }

}
