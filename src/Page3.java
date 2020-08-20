import javax.swing.JButton;

public class Page3 extends MyPanel 
{
	static JButton  BHome;	
	
	
    Page3(){
        frame3();
    }
    
    public static JButton getBHome()
    {
    	return BHome;
    }
    public void frame3()
    {
    	
        setPanel(0, 0, 1038, 715, 39, 54, 73);
        
        setImagetoButton(20, 590, 160, 65,"src\\image\\menuHome1.png");
        BHome = getButton();
        panel.add(BHome);
        
        setImagetoPanel(0,0,  1038, 715, "src\\image\\Team.png");
        panel.add(label);
       
        add(panel);
    }

}
