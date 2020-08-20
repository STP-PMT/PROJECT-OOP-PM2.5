
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {

    public static void main(String[] args) throws Exception {
        Page1 page1 = new Page1();
        Page2 page2 = new Page2();
        Page3 page3 = new Page3();

        CardLayout cardLayout = new CardLayout();
        MyFrame frame = new MyFrame();
        frame.getContentPane().setLayout(cardLayout);
        frame.getContentPane().add(page1);
        frame.getContentPane().add(page2);
        frame.getContentPane().add(page3);
        cardLayout.addLayoutComponent(page1, "page1");
        cardLayout.addLayoutComponent(page2, "page2");
        cardLayout.addLayoutComponent(page3, "page3");
        AtionNextFrame(cardLayout,frame);
        frame.setVisible(true);
    }
    public static void AtionNextFrame(CardLayout cardLayout,MyFrame frame){
        (Page1.getButtonMenu1()).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(frame.getContentPane(), "page2");
            }
        });

        (Page1.getButtonMenu2()).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(frame.getContentPane(), "page3");
            }
        });
        

        (Page3.getBHome()).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(frame.getContentPane(), "page1");
            }
        });
    }
}
