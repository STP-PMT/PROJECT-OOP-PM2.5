
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class App {
	static int p = 0;

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
		AtionNextFrame(cardLayout, frame);
		frame.setVisible(true);
	}

	public static void AtionNextFrame(CardLayout cardLayout, MyFrame frame) {
		(Page1.getButtonMenu1()).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(frame.getContentPane(), "page2");
				p = 2;
			}
		});

		(Page1.getButtonMenu2()).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(frame.getContentPane(), "page3");
				p = 3;
			}
		});

		(Page3.getBHome()).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(frame.getContentPane(), "page1");
				p = 0;
			}
		});

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (p == 2 || p == 3) {
					cardLayout.show(frame.getContentPane(), "page1");
					p = 0;
				} else {
					System.exit(0);
				}
			}
		});
	}
}
