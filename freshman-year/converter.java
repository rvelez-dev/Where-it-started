import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;

public class converter extends Applet implements ActionListener
{

    Button yardsBtn=new Button ("get yards");
    Button feetBtn=new Button ("get feet");
    Font font40=new Font("Comic Sans MS",1,40);
    TextField milesTF=new TextField();
    String output="";
    String input="";
    int miles;
    int yards;
    int feet;

    Color purple = new Color (200,50,100);

    public void init()
    { 
        this .setLayout(null);

        yardsBtn.setBounds(100,400,75,30);
        this.add(yardsBtn);
        yardsBtn.addActionListener(this);

        milesTF.setBounds(100,300,75,30);
        this.add(milesTF);

        feetBtn.setBounds (200,300,75,30);
        feetBtn.addActionListener(this);
        this.add(feetBtn);

    } 

    public void actionPerformed( ActionEvent e) 
    {
        if(e.getSource()==yardsBtn) 
        {
            input=milesTF.getText();
            miles=Integer.parseInt(input);
            yards=1760*miles;
            output=miles+"miles is"+yards +"yards";
        }

        if(e.getSource()==feetBtn)
        {

            input=milesTF.getText();
            miles=Integer.parseInt(input);
            feet=1760*miles*3;
            output=miles+" miles is "+feet +" feet";
        }

        repaint();
    }

    public void paint (Graphics g)
    {
        g.setColor(purple);

        g.drawString("Welcome to rachel's distance converter",300,50);
        g.drawString (" ENTER MILES",100,290);
        g.drawString(output,300,500);

    }

} 
