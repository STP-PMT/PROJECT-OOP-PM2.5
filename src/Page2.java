import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

import java.util.Random;
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
	private JTextField Random1;
	private JTextField Random2;
	private JButton Random_Ok;
	private JButton SeclectFile;
	private JButton Rain1;
	private int returnVal = 3;
	private int returnPeople = 0;
	private File file;
	private JFileChooser chooser;
	private FileNameExtensionFilter filter;
	private int numPeople;
	private TextArea TextDetail;
	private JPanel PDetail;
	
	int start;
	int end;

	public Page2() {
		setTable();
		setInputFile();
		setDetail();
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

		setLabel(105, 95, 100, 30, "Between ", 15);
		PInputFile.add(label);
		setTextFeild(175, 95, 110, 30);
		Random1 = getTextFeild();
		PInputFile.add(Random1);
		setLabel(295, 95, 100, 30, "and ", 15);
		PInputFile.add(label);
		setTextFeild(330, 95, 100, 30);
		Random2 = getTextFeild();
		PInputFile.add(Random2);
		setButton(435, 95, 138, 30, "OK");
		Random_Ok = getButton();
		PInputFile.add(Random_Ok);

		SeclectFile.addActionListener(this);
		SeclectFile_OK.addActionListener(this);
		Population_Ok.addActionListener(this);
		Random_Ok.addActionListener(this);
		add(PInputFile);
	}

	public void setDetail() {
		setPanel(630, 20, 370, 450);
		PDetail = getPanel();
		setTextAarea(15, 15, 340, 200,
				"Population:\nDust volume:\nGood health:\nSick:\nPercentage of population sick :");
		textArea = getTextArea();
		textArea.setEditable(false);
		PDetail.add(textArea);
		setImagetoPanel(15, 230, 340, 200, "src\\image\\K5.png");
		PDetail.add(label);
		add(PDetail);
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
		PTable = getPanel();
		PTable.setLayout(new GridLayout(10, 20));
		System.out.println(Dust.size());
		JButton[] PArea = new JButton[Dust.size()];
		for (int i = 0; i < Dust.size(); i++) {
			PArea[i] = new JButton();
			setTableColor(Dust.get(i), PArea[i], PTable);
		}
		add(PTable);
		// repaint();
	}

	public void setTableColor(int Dust, JButton Area, JPanel PTable) {
		Random rand = new Random();
		
		if (Dust <= 50 && Dust >= 0) {
			Area.setBackground(new Color(0, 204, 0));
		} else if (Dust > 50 && Dust <= 100) {
			Area.setBackground(new Color(255, 255, 0));
		} else if (Dust > 100 && Dust <= 150) {
			Area.setBackground(new Color(255, 128, 0));
		} else if (Dust > 150 && Dust <= 250) {
			Area.setBackground(new Color(255, 64, 0));
		}
		Area.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(start >= 0&& end >0) {
					int dust = 0;
					if (Dust <= 50 && Dust >= 0) {
						dust = rand.nextInt(10);
					} else if (Dust > 50 && Dust <= 100) {
						dust = rand.nextInt(10) + 10;
					} else if (Dust > 100 && Dust <= 150) {
						dust = rand.nextInt(10) + 20;
					} else if (Dust > 150 && Dust <= 250) {
						dust = rand.nextInt(21) + 30;
					}
					PDetail.remove(textArea);
					numPeople = rand.nextInt((end - start) + 1) + start;
					setTextAarea(15, 15, 340, 200, "population\t\t  : " + numPeople + "\nDust volume\t\t  : " + Dust
							+ "\nGood health\t\t  : " + (numPeople - (int) (numPeople * dust / 100)) + "\nSick\t\t  : "
							+ (int) (numPeople * dust / 100) + "\nPercentage of population sick\t  : " + dust + " %");
					textArea = getTextArea();
					textArea.setEditable(false);
					PDetail.add(textArea);
				}else {
				int dust = 0;
				if (Dust <= 50 && Dust >= 0) {
					dust = rand.nextInt(10);
				} else if (Dust > 50 && Dust <= 100) {
					dust = rand.nextInt(10) + 10;
				} else if (Dust > 100 && Dust <= 150) {
					dust = rand.nextInt(10) + 20;
				} else if (Dust > 150 && Dust <= 250) {
					dust = rand.nextInt(21) + 30;
				}
				PDetail.remove(textArea);
				setTextAarea(15, 15, 340, 200, "population\t\t  : " + numPeople + "\nDust volume\t\t  : " + Dust
						+ "\nGood health\t\t  : " + (numPeople - (int) (numPeople * dust / 100)) + "\nSick\t\t  : "
						+ (int) (numPeople * dust / 100) + "\nPercentage of population sick\t  : " + dust + " %");
				textArea = getTextArea();
				textArea.setEditable(false);
				PDetail.add(textArea);}
				repaint();
			}
		});
		PTable.add(Area);
	}

	public void setTable(ArrayList<Integer> numDust) {
		setVisible(false);
		remove(PTable);
		setPeople(numDust);
		setVisible(true);

	}

	public void setSelectFile() {
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
	}

	public void setNewTable() {
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
			reader.close();
			setTable(numDust);
		} catch (IOException e1) {
			System.err.println("IOException: " + e1.getMessage());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == SeclectFile) {
			setSelectFile();
			Population.setEditable(true);
			Random1.setEditable(true);
			Random2.setEditable(true);
		} else if (e.getSource() == SeclectFile_OK) {
			if (returnVal == 0 && returnPeople == 1) {
				setNewTable();
				returnPeople = 0;
				returnVal = 3;
			} else {
			}
		} else if (e.getSource() == Population_Ok) {
			if (returnVal == 0 && returnPeople == 0)
				try {
					String text = Population.getText();
					System.err.print("Num: " + text);
					numPeople = Integer.parseInt(text);
					returnPeople = 1;
					setNewTable();
					returnPeople = 0;
					returnVal = 3;
					Random1.setEditable(false);
					Random2.setEditable(false);
					Population.setEditable(false);
					Random1.setText("");
					Random2.setText("");
				} catch (Exception e2) {
					System.err.print("Exception: " + e2.getMessage());
				}
		} else if (e.getSource() == Random_Ok) {
			if (returnVal == 0 && returnPeople == 0) {
				String text1 = Random1.getText();
				String text2 = Random2.getText();
				Random rand = new Random();
				try {
					start = Integer.parseInt(text1);
					end = Integer.parseInt(text2);
					numPeople = rand.nextInt((end - start) + 1) + start;
					returnPeople = 1;
					setNewTable();
					returnPeople = 0;
					returnVal = 3;
					Population.setEditable(false);
					Random1.setEditable(false);
					Random2.setEditable(false);
					Population.setText("");
				} catch (Exception e2) {
					System.err.print("Exception: " + e2.getMessage());
				}
			}
		}
	}
}
