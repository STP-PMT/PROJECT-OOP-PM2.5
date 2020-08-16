
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class App{
    
    public static void main(String[] args) throws Exception {
    	JButton button;
    	Page1 page1 = new Page1();
        MyFrame frame = new MyFrame();
        frame.add(setFrame1());
        button=Page1.getButtonMenu1();
        button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MyFrame frame2 = new MyFrame();
				frame2.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent e) {
						frame2.dispose();
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.add(setFrame1());
						frame.setVisible(true);
					}
				});
				frame2.add(getFrame2());
				frame2.setVisible(true);
				
			}
		});
        frame.setVisible(true);
        
    }
    
    public void closingWin(ActionEvent e) {
    	
    }

    public static JPanel setFrame1() {
        Page1 page1 = new Page1();
        page1.setPanelMenu();
        page1.setPanelLogo();
        page1.setPanelRain();
        page1.setPanelFace();
        return page1;
    }
    
    public static JPanel getFrame2() {
		Page2 page2 = new Page2();
		page2.Frame1();
		page2.Frame2();
		page2.Frame3();
		page2.Frame4();
		return page2;
	}

    public static JPanel setFrame3() {
        Page3 page3 = new Page3();
        page3.frame3();
        return page3;
    }
}

