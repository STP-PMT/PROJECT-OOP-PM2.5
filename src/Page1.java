import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Page1 extends MyPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	// Attribute method setPanelMenu
	private JPanel Pmenu;
	private static JButton Bmenu1;
	private static JButton Bmenu2;

	// Attribute method setPaneLogo
	private JPanel PLogo;
	private JLabel LImage;

	// Attribute method setPaneRain
	private JPanel PRain;
	private JLabel LGif;

	// Attribute method setPaneLogo
	private JPanel PFace;
	private JButton FaceGreen;
	private JButton FaceYellow;
	private JButton FaceOrange;
	private JButton FaceRad;

	public Page1() {
		setPanelMenu();
		setPanelLogo();
		setPanelRain();
		setPanelFace();
	}

	public JPanel getPanelMenu() {
		return Pmenu;
	}

	public JPanel getPanelLogo() {
		return PLogo;
	}

	public JPanel getPanelRain() {
		return PRain;
	}

	public JPanel getPanelFace() {
		return PFace;
	}

	public static JButton getButtonMenu1() {
		return Bmenu1;
	}

	public static JButton getButtonMenu2() {
		return Bmenu2;
	}

	public void setPanelMenu() {

		setPanel(630, 365, 370, 292, 0, 174, 169);
		Pmenu = getPanel();
		setImagetoButton(20, 20, 330, 120, "src\\image\\menu1.png");
		Bmenu1 = getButton();
		setImagetoButton(20, 160, 330, 120, "src\\image\\menu2.png");
		Bmenu2 = getButton();
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
		FaceGreen.addActionListener(this);

		setImagetoButton(162, 20, 125, 125, "src\\image\\p2.png");
		FaceYellow = getButton();
		FaceYellow.addActionListener(this);

		setImagetoButton(299, 20, 125, 125, "src\\image\\p3.png");
		FaceOrange = getButton();
		FaceOrange.addActionListener(this);

		setImagetoButton(436, 20, 125, 125, "src\\image\\p4.png");
		FaceRad = getButton();
		FaceRad.addActionListener(this);

		PFace.add(FaceGreen);
		PFace.add(FaceYellow);
		PFace.add(FaceOrange);
		PFace.add(FaceRad);
		add(PFace);
	}

	public void setNewFace(String Url) {
		
		remove(PLogo);
		setPanel(630, 20, 370, 325, 0, 174, 169);
		PLogo = getPanel();
		setImagetoPanel(0, 0, 370, 325, Url);
		LImage = getLabel();
		PLogo.add(LImage);
		add(PLogo);
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == FaceGreen) {
			setNewFace("src\\image\\g1.png");
		} else if (e.getSource() == FaceYellow) {
			setNewFace("src\\image\\g2.png");
		} else if (e.getSource() == FaceOrange) {
			setNewFace("src\\image\\g3.png");
		} else if (e.getSource() == FaceRad) {
			setNewFace("src\\image\\g4.png");
		}
	}
}