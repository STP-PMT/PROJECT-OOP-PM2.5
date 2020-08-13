import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JToggleButton;

public class Page2 extends MyPanel implements ActionListener{

    private static final long serialVersionUID = 1L;
    JButton Rain1;
    int n=2;

    public void Frame1() {
        setPanel(20, 20, 588, 450, 39, 54, 73);
        panel.setLayout(new GridLayout(10, 20));
        button = new JButton();
        for (int i = 1; i <= 200; i++) {
            panel.add(new JButton());
        }
        add(panel);
    }

    public void Frame2() {
        // add selecl file
        setPanel(20, 490, 588, 166);
        setLabel(15, 15, 100, 30, "Select File :", 15);
        panel.add(label);
        setTextFeild(105, 15, 325, 30);
        panel.add(textField);
        setButton(435, 15, 80, 30, "SELECT");
        panel.add(button);
        setButton(518, 15, 55, 30, "OK");
        panel.add(button);

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
        setTextAarea(15,15,340,200,"ประชากร\t:\nปริมาณฝุ่น\t:\nสุขภาพดี\t:\nป่วย\t:\nร้อยละของประชากรที่ป่วย :");
        panel.add(textArea);
        setImagetoPanel(15,230, 340, 200, "src\\image\\K1.png");
        panel.add(label);
        add(panel);
    }

    public void Frame4() {
        JToggleButton button2;

        setPanel(630, 490, 370, 166);

        setButton(15, 15, 166, 140, "Artificial rain", 15);
        Rain1 = getButton();
        Rain1.addActionListener(this);
        panel.add(Rain1);

        setTaggleButton(190, 15, 166, 140, "Natural rain", 15);
        button2 = getToggleButton();
        panel.add(button2);

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Rain1){
            
            if (n % 2 == 0) {
                Rain1.setBackground(new Color(0, 255, 0));
                n++;
            } else {
                Rain1.setBackground(new Color(255, 255, 255));
                n=2;
            }
        }

    }
}