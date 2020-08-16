import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Page1 extends MyPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	//Attribute method setPanelMenu
	private JPanel Pmenu;
	private JButton Bmenu1;
	private JButton Bmenu2;
	
	//Attribute method setPaneLogo
	private JPanel PLogo;
	private JLabel LImage;
	
	//Attribute method setPaneRain
	private JPanel PRain;
	private JLabel LGif;
	
	//Attribute method setPaneLogo
	private JPanel PFace;
	private JButton FaceGreen;
	private JButton FaceYellow;
	private JButton FaceOrange;
	private JButton FaceRad;

	public void setPanelMenu() {

		setPanel(630, 365, 370, 292, 0, 174, 169);
		Pmenu = getPanel();
		setImagetoButton(20, 20, 330, 120, "src\\image\\menu1.png");
		Bmenu1 = getButton();
		setImagetoButton(20, 160, 330, 120, "src\\image\\menu2.png");
		Bmenu2 = getButton();
		Bmenu1.addActionListener(this);
		Bmenu1.addActionListener(this);
		Pmenu.add(Bmenu2);
		Pmenu.add(Bmenu1);
		add(Pmenu);
	}

	public void setPanelLogo() {
		setPanel(630, 20, 370, 325, 0, 174, 169);
		PLogo = getPanel();
		setImagetoPanel(0, 0, 370, 325, "src\\image\\pm.png");
		LImage = getLabel();
		PLogo.add(LImage);
		add(PLogo);
	}

	public void setPanelRain() {
		setPanel(20, 20, 588, 450, 0, 174, 169);
		PRain = getPanel();
		setImagetoPanel(20, 20, 548, 410, "src\\image\\Rain.gif");
		LGif = getLabel();
		PRain.add(LGif);
		add(PRain);
	}

	public void setPanelFace() {
		setPanel(20, 490, 588, 166, 0, 174, 169);
		PFace = getPanel();
		setImagetoButton(20, 20, 125, 125, "src\\image\\p1.png");
		FaceGreen = getButton();
		setImagetoButton(162, 20, 125, 125, "src\\image\\p2.png");
		FaceYellow = getButton();
		setImagetoButton(299, 20, 125, 125, "src\\image\\p3.png");
		FaceOrange = getButton();
		setImagetoButton(436, 20, 125, 125, "src\\image\\p4.png");
		FaceRad = getButton();
		PFace.add(FaceGreen);
		PFace.add(FaceYellow);
		PFace.add(FaceOrange);
		PFace.add(FaceRad);
		add(PFace);
	}

	public static JPanel getFrame2() {
		Page2 page2 = new Page2();
		page2.Frame1();
		page2.Frame2();
		page2.Frame3();
		page2.Frame4();
		return page2;
	}

	public static JPanel getFrame1() {
		Page1 page1 = new Page1();
		page1.setPanelMenu();
		page1.setPanelLogo();
		page1.setPanelRain();
		page1.setPanelFace();
		return page1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Bmenu1) {
			setVisible(false);
			removeAll();
			add(getFrame2());
			setVisible(true);
		} else if (e.getSource() == Bmenu2) {
			setVisible(false);
			removeAll();
			add(getFrame2());
		}
	}
}