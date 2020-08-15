import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.sun.javafx.geom.Edge;

import sun.security.util.Debug;

public class Page2 extends MyPanel {

	private static final long serialVersionUID = 1L;
	JButton Rain1;
	JButton btnSeclect;
	JButton btnOK;
	JTextField log;
	File file;
	int returnVal = 3;
	JPanel nArea;
	boolean isOk = false;

	JFileChooser chooser = new JFileChooser();
	FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt File", "txt");

	public void Frame1() {
		JButton Pbutton;
		setPanel(20, 20, 588, 450, 39, 54, 73);
		panel.setLayout(new GridLayout(10, 20));
		button = new JButton();
		for (int i = 1; i <= 200; i++) {
			panel.add(new JButton());
		}
		add(panel);
	}

	public void people(ArrayList<Integer> Dust) {
		setPanel(20, 20, 588, 450, 39, 54, 73);
		panel.setLayout(new GridLayout(10, 20));
		System.out.println(Dust.size());
		JButton[] PArea = new JButton[Dust.size()];
		for (int i = 0; i < Dust.size(); i++) {
			PArea[i] = new JButton();
			if (Dust.get(i) < 50) {
				PArea[i].setBackground(new Color(0, 255, 0));
			} else {
				PArea[i].setBackground(new Color(255, 0, 0));
			}
			panel.add(PArea[i]);
		}
		add(panel);
	}

	public void Frame2() {
		// add select file
		setPanel(20, 490, 588, 166);
		setLabel(15, 15, 100, 30, "Select File :", 15);
		panel.add(label);
		setTextFeild(105, 15, 325, 30);
		log = getTextFeild();
		log.setEditable(false);
		panel.add(log);
		setButton(435, 15, 80, 30, "SELECT");
		btnSeclect = getButton();
		btnSeclect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ActionSelectFile(e);
			}
		});
		panel.add(btnSeclect);
		setButton(518, 15, 55, 30, "OK");
		btnOK = getButton();
		btnOK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ActionOKFile(e);
			}
		});
		panel.add(btnOK);

		// add people
		setLabel(15, 55, 100, 30, "Population :", 15);
		panel.add(label);
		setTextFeild(105, 55, 325, 30);
		panel.add(textField);
		setButton(435, 55, 138, 30, "OK");
		panel.add(button);

		//
		setLabel(15, 95, 100, 30, "Random     :", 15);
		panel.add(label);
		setTextFeild(105, 95, 325, 30);
		panel.add(textField);
		setButton(435, 95, 138, 30, "OK");
		panel.add(button);

		add(panel);
	}

	public void Frame3() {
		setPanel(630, 20, 370, 450);
		setTextAarea(15, 15, 340, 200,
				"population:\nDust volume:\nGood health:\nSick:\nPercentage of population sick :");
		textArea.setEditable(false);
		panel.add(textArea);
		setImagetoPanel(15, 230, 340, 200, "src\\image\\K5.png");
		panel.add(label);
		add(panel);
	}

	public void Frame4() {
		JToggleButton button2;

		setPanel(630, 490, 370, 166);

		setButton(15, 15, 166, 140, "Artificial rain", 15);
		Rain1 = getButton();
		panel.add(Rain1);

		setTaggleButton(190, 15, 166, 140, "Natural rain", 15);
		button2 = getToggleButton();
		panel.add(button2);

		add(panel);
	}

	private void ActionSelectFile(ActionEvent e) {
		chooser.setFileFilter(filter);
		if (e.getSource() == btnSeclect) {
			returnVal = chooser.showOpenDialog(Page2.this);
			System.out.println(returnVal);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = chooser.getSelectedFile();
				log.setText(file.getPath());
			} else {
				log.setText("");
			}
		}

	}

	private void ActionOKFile(ActionEvent e) {
		if (returnVal == 0) {
			file = chooser.getSelectedFile();
			try {
				String p = file.getPath();
				Path path = Paths.get(p);
				BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
				ArrayList<Integer> numDust = new ArrayList<Integer>();
				Scanner scanner = new Scanner(path);
				while (scanner.hasNext()) {
					if (scanner.hasNextInt()) {
						numDust.add(scanner.nextInt());
					} else {
						scanner.next();
					}
				}
				
				setVisible(false);
				removeAll();
				people(numDust);
				add(panel);
				add(getFrame24());
				setVisible(true);

				reader.close();
			} catch (IOException e1) {
				System.err.println("IOException: " + e1.getMessage());
			}
		}else {}
		
		log.setEditable(true);
		log.setText(file.getPath());
		log.setEditable(false);
		
	}

	public static JPanel getFrame24() {
		Page2 page2 = new Page2();
		page2.Frame2();
		page2.Frame3();
		page2.Frame4();
		return page2;
	}

}