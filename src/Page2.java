import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Color;

import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Page2 extends MyPanel implements ActionListener {
	int column = 0;
	int row = 1;

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
	private JButton Rain2;
	private int returnVal = 3;
	private int returnPeople = 0;
	private File file;
	private JFileChooser chooser;
	private FileNameExtensionFilter filter;
	private int numPeople;
	private JPanel PDetail;
	private JLabel pic1;
	private JLabel pic2;

	ArrayList<Integer> numDust;
	boolean isRain1Click = false;
	boolean isRain2Click = false;
	int RNumPeople[];
	JButton[] PArea;
	int sick[];
	int good[];
	int pDust[];
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
		PTable.setLayout(new GridLayout(0, 20));
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
		setImagetoPanel(15, 15, 340, 200, "src/image/p8.png");
		pic1 = getLabel();
		PDetail.add(pic1);
		setImagetoPanel(15, 230, 340, 200, "src\\image\\K5.png");
		pic2 = getLabel();
		PDetail.add(pic2);

		setImagetoPanel(0, 0, 0, 0, "");
		PDetail.add(label);
		setTextAarea(0, 0, 0, 0, "");
		PDetail.add(textArea);
		add(PDetail);
	}

	public void Frame4() {
		setPanel(630, 490, 370, 166);

		setButton(15, 15, 166, 140, "Artificial rain", 15);
		Rain1 = getButton();
		panel.add(Rain1);

		setButton(190, 15, 166, 140, "Natural rain", 15);
		Rain2 = getButton();
		panel.add(Rain2);

		Rain1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isRain1Click) {
					Rain1.setBackground(new Color(255, 255, 255));
					isRain1Click = false;
				} else {
					Rain1.setBackground(new Color(0, 255, 0));
					isRain1Click = true;
				}
				System.out.println(isRain2Click);
			}
		});
		Rain2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < numDust.size(); i++) {
					if (numPeople > 0) {
						setButtonColor(i, 50);
					} else {
						setButtonColor(i, 50);
					}
				}
				add(PTable);
			}
		});
		add(panel);
	}

	public void setPeople(ArrayList<Integer> Dust) {
		setPanel(20, 20, 588, 450, 39, 54, 73);
		PTable = getPanel();
		PTable.setLayout(new GridLayout(row, column));

		PArea = new JButton[Dust.size()];
		for (int i = 0; i < Dust.size(); i++) {
			PArea[i] = new JButton();
			if (numPeople > 0) {
				setTableColor(Dust.get(i), PArea[i], PTable, sick[i], good[i], pDust[i], numPeople);
			} else {
				setTableColor(Dust.get(i), PArea[i], PTable, sick[i], good[i], pDust[i], RNumPeople[i]);
			}
		}
		add(PTable);
	}

	public void setTableColor(int Dust, JButton Area, JPanel PTable, int sick, int good, int pDust, int numPeople) {
		if (Dust <= 50 && Dust >= 0) {
			Area.setBackground(new Color(0, 204, 0));
		} else if (Dust > 50 && Dust <= 100) {
			Area.setBackground(new Color(255, 255, 0));
		} else if (Dust > 100 && Dust <= 150) {
			Area.setBackground(new Color(255, 128, 0));
		} else if (Dust > 150 && Dust <= 250) {
			Area.setBackground(new Color(255, 64, 0));
		} else {
			Area.setBackground(new Color(255, 255, 255));
		}
		Area.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (start >= 0 && end > 0 && start != end && start < end) {
					setDetailPeople(numPeople, Dust, sick, good, pDust, Area.getBackground());
				} else {
					setDetailPeople(numPeople, Dust, sick, good, pDust, Area.getBackground());
				}
				repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				PDetail.remove(label);
				PDetail.remove(textArea);
				setImagetoPanel(15, 15, 340, 200, "src/image/p8.png");
				pic1 = getLabel();
				PDetail.add(pic1);
				repaint();
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Rain1(e);
			}
		});
		PTable.add(Area);
	}

	public void setButtonColor(int i, double n) {
		if (numPeople > 0 && numDust.get(i) > 0) {
			int num = 0;
			if (numDust.get(i) - n <= 0) {
				num = 0;
			} else {
				num = (int) (numDust.get(i) - n);
			}
			numDust.remove(i);
			numDust.add(i, num);
			setResult(numPeople, numDust);
			setTableColor(num, PArea[i], PTable, sick[i], good[i], pDust[i], numPeople);

		} else if (numDust.get(i) > 0) {
			int num = 0;
			if (numDust.get(i) - n <= 0) {
				num = 0;
			} else {
				num = (int) (numDust.get(i) - n);
			}
			numDust.remove(i);
			numDust.add(i, num);
			setResult(RNumPeople[i], numDust);
			setTableColor(num, PArea[i], PTable, sick[i], good[i], pDust[i], RNumPeople[i]);

		}
	}

	public void Rain1(MouseEvent e) {
		int[] result = new int[row];
		result[0]=column-1;
		for (int j = 1; j <row; j++) {
			result[j] = (j+1) * column - 1;
		}

		int[] result2 = new int[row];
		result2[0] = 0;
		for (int k = 1; k < row; k++) {
			result2[k] = k * column;
		}
		int a = 1;
		int b = 0;
		int c = 0;
		System.out.println(result.length);
		System.out.println(result2.length);
		if (isRain1Click) {
			for (int i = 0; i < PArea.length; i++) {
				if (e.getSource() == PArea[i]) {
					System.out.println(i);
					for (int j = 0; j < result.length; j++) {
						if (i == result[j] && i == result2[j]) {
							a = 0;
							break;
						} else if (i == result[j]) {
							b++;
							a = 0;
							break;
						} else if (i == result2[j]) {
							c++;
							a = 0;
							break;
						}
					}
					System.out.println("A :" + a);
					System.out.println("B :" + b);
					System.out.println("C :" + c);

					if (a == 1) {
						if (i >= 0 && i < numDust.size()) {
							setButtonColor(i, numDust.get(i) * 0.5);
						}
						if (i + 1 >= 0 && i + 1 < numDust.size()) {
							setButtonColor(i + 1, numDust.get(i + 1) * 0.3);
						}
						if (i - 1 >= 0 && i - 1 < numDust.size()) {
							setButtonColor(i - 1, numDust.get(i - 1) * 0.3);
						}
						if (i + column >= 0 && i + column < numDust.size()) {
							setButtonColor(i + column, numDust.get(i + column) * 0.3);
						}
						if (i - column >= 0 && i - column < numDust.size()) {
							setButtonColor(i - column, numDust.get(i - column) * 0.3);
						}
						if (i + column + 1 >= 0 && i + column + 1 < numDust.size()) {
							setButtonColor(i + column + 1, numDust.get(i + column + 1) * 0.3);
						}
						if (i - column + 1 >= 0 && i - column + 1 < numDust.size()) {
							setButtonColor(i - column + 1, numDust.get(i - column + 1) * 0.3);
						}
						if (i - column - 1 >= 0 && i - column - 1 < numDust.size()) {
							setButtonColor(i - column - 1, numDust.get(i - column - 1) * 0.3);
						}
						if (i + column - 1 >= 0 && i + column - 1 < numDust.size()) {
							setButtonColor(i + column - 1, numDust.get(i + column - 1) * 0.3);
						}
					} else if (b > 0) {
						if (i >= 0 && i < numDust.size()) {
							setButtonColor(i, numDust.get(i) * 0.5);
						}
						if (i - 1 >= 0 && i - 1 < numDust.size()) {
							setButtonColor(i - 1, numDust.get(i - 1) * 0.3);
						}
						if (i + column >= 0 && i + column < numDust.size()) {
							setButtonColor(i + column, numDust.get(i + column) * 0.3);
						}
						if (i - column >= 0 && i - column < numDust.size()) {
							setButtonColor(i - column, numDust.get(i - column) * 0.3);
						}
						if (i - column - 1 >= 0 && i - column - 1 < numDust.size()) {
							setButtonColor(i - column - 1, numDust.get(i - column - 1) * 0.3);
						}
						if (i + column - 1 >= 0 && i + column - 1 < numDust.size()) {
							setButtonColor(i + column - 1, numDust.get(i + column - 1) * 0.3);
						}

					} else if (c > 0) {
						if (i >= 0 && i < numDust.size()) {
							setButtonColor(i, numDust.get(i) * 0.5);
						}
						if (i + 1 >= 0 && i + 1 < numDust.size()) {
							setButtonColor(i + 1, numDust.get(i + 1) * 0.3);
						}
						if (i + column >= 0 && i + column < numDust.size()) {
							setButtonColor(i + column, numDust.get(i + column) * 0.3);
						}
						if (i - column >= 0 && i - column < numDust.size()) {
							setButtonColor(i - column, numDust.get(i - column) * 0.3);
						}
						if (i + column + 1 >= 0 && i + column + 1 < numDust.size()) {
							setButtonColor(i + column + 1, numDust.get(i + column + 1) * 0.3);
						}
						if (i - column + 1 >= 0 && i - column + 1 < numDust.size()) {
							setButtonColor(i - column + 1, numDust.get(i - column + 1) * 0.3);
						}

					}
				}
			}
		}
	}

	public void setDetailPeople(int numPeople, int Dust, int sick, int good, int pDust, Color color) {
		PDetail.remove(pic1);
		PDetail.remove(textArea);
		setTextAarea(15, 15, 340, 200,
				"Population\t\t  : " + numPeople + "\nDust volume\t\t  : " + Dust + "\nHealthy population\t  : " + good
						+ "\nSick population\t\t  : " + sick + "\nPercentage of population sick\t  : " + pDust + " %");
		textArea = getTextArea();
		textArea.setEditable(false);
		textArea.setBackground(color);
		PDetail.add(textArea);
	}

	public void setSelectFile() {
		chooser = new JFileChooser();
		filter = new FileNameExtensionFilter(".txt File", "txt");
		chooser.setFileFilter(filter);
		returnVal = chooser.showOpenDialog(Page2.this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			log.setText(file.getPath());
		} else {
			log.setText("");
		}
	}

	public void setNewTable() {
		Random random = new Random();
		file = chooser.getSelectedFile();
		try {
			int sum;
			Path path = Paths.get(file.getPath());
			numDust = new ArrayList<Integer>();
			BufferedReader br = new BufferedReader(new FileReader(file));
			Scanner scanner = new Scanner(path);
			Scanner scan = new Scanner(br.readLine());
			while (scan.hasNext()) {
				if (scan.hasNextInt()) {
					sum = scan.nextInt();
					column++;
				} else {
					scan.next();
				}
			}

			String st;
			while ((st = br.readLine()) != null) {
				row++;
			}

			while (scanner.hasNext()) {
				if (scanner.hasNextInt()) {
					numDust.add(scanner.nextInt());
				} else {
					scanner.next();
				}
			}
			scanner.close();
			if (numPeople > 0) {
				setResult(numPeople, numDust);
			} else {
				RNumPeople = new int[numDust.size()];
				for (int i = 0; i < numDust.size(); i++) {
					RNumPeople[i] = random.nextInt((end - start) + 1) + start;
					setResult(RNumPeople[i], numDust);
				}
			}
			setTable(numDust);
		} catch (IOException e1) {
			System.err.println("IOException: " + e1.getMessage());
		}
	}

	public void setResult(int num, ArrayList<Integer> Dust) {
		Random rand = new Random();
		sick = new int[Dust.size()];
		good = new int[Dust.size()];
		pDust = new int[Dust.size()];

		for (int i = 0; i < Dust.size(); i++) {
			if (Dust.get(i) <= 50 && Dust.get(i) > 0) {
				pDust[i] = rand.nextInt(10);
			} else if (Dust.get(i) > 50 && Dust.get(i) <= 100) {
				pDust[i] = rand.nextInt(10) + 10;
			} else if (Dust.get(i) > 100 && Dust.get(i) <= 150) {
				pDust[i] = rand.nextInt(10) + 20;
			} else if (Dust.get(i) > 150 && Dust.get(i) <= 250) {
				pDust[i] = rand.nextInt(21) + 30;
			} else {
				pDust[i] = 0;
			}
			sick[i] = (int) (num * pDust[i] / 100);
			good[i] = num - sick[i];
		}
	}

	public void setTable(ArrayList<Integer> numDust) {
		setVisible(false);
		remove(PTable);
		setPeople(numDust);
		setVisible(true);
	}

	public void setEdit(boolean b) {
		Population.setEditable(b);
		Random1.setEditable(b);
		Random2.setEditable(b);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == SeclectFile) {
			setSelectFile();
			setVisible(false);
			remove(PTable);
			setTable();
			setVisible(true);
			setEdit(true);
			Random1.setText("");
			Random2.setText("");
			Population.setText("");
			column = 0;
			numPeople = 0;
			row = 1;
		} else if (e.getSource() == SeclectFile_OK) {
			if (returnVal == 0 && returnPeople == 1) {
				setNewTable();
				returnPeople = 0;
				returnVal = 3;
			}
		} else if (e.getSource() == Population_Ok) {
			if (returnVal == 0 && returnPeople == 0)
				try {
					String text = Population.getText();
					numPeople = Integer.parseInt(text);
					if (numPeople > 0) {
						returnPeople = 1;
						setNewTable();
						returnPeople = 0;
						returnVal = 3;
						setEdit(false);
						Random1.setText("");
						Random2.setText("");
					} else {
						JOptionPane.showMessageDialog(null, "Input again!!");
					}

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Input again!!");
				}
		} else if (e.getSource() == Random_Ok) {
			if (returnVal == 0 && returnPeople == 0) {
				String text1 = Random1.getText();
				String text2 = Random2.getText();
				try {
					start = Integer.parseInt(text1);
					end = Integer.parseInt(text2);
					if (start >= 0 && end > 0 && start != end && start < end) {
						returnPeople = 1;
						setNewTable();
						returnPeople = 0;
						returnVal = 3;
						setEdit(false);
						Population.setText("");
					} else {
						JOptionPane.showMessageDialog(null, "Input again!!");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Input again!!");
				}
			}
		}
	}
}
