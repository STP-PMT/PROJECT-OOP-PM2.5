public class Page3 extends MyPanel {
    Page3(){
        frame3();
    }
    public void frame3()
    {
        setPanel(0, 0, 1038, 715, 39, 54, 73);
        
        setImagetoPanel(0,0,  1038, 715, "src\\image\\Team.png");
        panel.add(label);
        setImagetoButton(20, 590, 160, 65,"src\\image\\menuHome1.png");
        panel.add(button);
        add(panel);
    }

}
