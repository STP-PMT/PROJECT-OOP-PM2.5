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

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Page2 extends MyPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel PTable;
	private JPanel PInputFile;
	private JButton SeclectFile_OK;
	private JTextField log;
	private JTextField Population;
	private JButton Population_Ok;
	private JTextField Random;
	private JButton Random_Ok;
	private JButton SeclectFile;
	private JButton Rain1;
	private int returnVal = 3;
	private File file;
	private JPanel nArea;
	private JFileChooser chooser;
	private FileNameExtensionFilter filter;

	public Page2() {
		setTable();
		setInputFile();
		Frame3();
		Frame4();
	}

	public void setTable() {
		setPanel(20, 20, 588, 450, 39, 54, 73);
		PTable = getPanel();
		PTable.setLayout(new GridLayout(20, 10));
		for (int i = 1; i <= 200; i++) {
			PTable.add(new JButton());
		}
		add(PTable);
	}

	public void setInputFile() {
		setPanel(20, 490, 588, 166);
		PInputFile = getPanel();
		setLabel(15, 15, 100, 30, "Select File :", 15);
		PInputFile.add(label);
		setLabel(15, 55, 100, 30, "Population :", 15);
		PInputFile.add(label);
		setLabel(15, 95, 100, 30, "Random     :", 15);
		PInputFile.add(label);

		setTextFeild(105, 15, 325, 30);
		log = getTextFeild();
		log.setEditable(false);
		PInputFile.add(log);
		setButton(435, 15, 80, 30, "SELECT");
		SeclectFile = getButton();
		PInputFile.add(SeclectFile);
		setButton(518, 15, 55, 30, "OK");
		SeclectFile_OK = getButton();
		PInputFile.add(SeclectFile_OK);

		setTextFeild(105, 55, 325, 30);
		Population = getTextFeild();
		PInputFile.add(Population);
		setButton(435, 55, 138, 30, "OK");
		Population_Ok = getButton();
		PInputFile.add(Population_Ok);

		setTextFeild(105, 95, 325, 30);
		Random = getTextFeild();
		PInputFile.add(textField);
		setButton(435, 95, 138, 30, "OK");
		Random_Ok = getButton();
		PInputFile.add(Random_Ok);

		SeclectFile.addActionListener(this);
		SeclectFile_OK.addActionListener(this);
		add(PInputFile);
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

	public void setPeople(ArrayList<Integer> Dust) {
		setPanel(20, 20, 588, 450, 39, 54, 73);
		panel.setLayout(new GridLayout(20, 10));
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

	public void setNewTable(ArrayList<Integer> numDust) {
		setVisible(false);
		remove(PTable);
		setPeople(numDust);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == SeclectFile) {
			chooser = new JFileChooser();
			filter = new FileNameExtensionFilter(".txt File", "txt");

			chooser.setFileFilter(filter);
			returnVal = chooser.showOpenDialog(Page2.this);
			System.out.println(returnVal);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = chooser.getSelectedFile();
				log.setText(file.getPath());
			} else {
				log.setText("");
			}
		} else if (e.getSource() == SeclectFile_OK) {
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
					scanner.close();
					setNewTable(numDust);
					reader.close();
				} catch (IOException e1) {
					System.err.println("IOException: " + e1.getMessage());
				}
			} else {
			}
		}else if() {
			
		}

	}

}