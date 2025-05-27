import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;
// Rachel Velez
public class multiplechoice extends Applet implements ActionListener
{
    Color blue = new Color (50,200,250);
    Button aBtn=new Button ("A");
    Button bBtn=new Button ("B");
    Button cBtn=new Button ("C");
    Button dBtn=new Button ("D");
    Font font26=new Font("Comic Sans MS",1,26);

    String input;
    String output;
    int letter;

    public void init()
    { 
        this .setLayout(null);

        aBtn.setBounds(300,250,80,40);
        aBtn.addActionListener(this);
        this.add(aBtn);

        bBtn.setBounds(300,300,80,40);
        bBtn.addActionListener(this);
        this.add(bBtn);

        cBtn.setBounds(510,250,80,40);
        cBtn.addActionListener(this);
        this.add(cBtn);

        dBtn.setBounds(510,300,80,40);
        dBtn.addActionListener(this);
        this.add(dBtn);

        

    } 

    public void actionPerformed( ActionEvent e) 
    {
        if(e.getSource()==aBtn) 
        output="correct";
         if(e.getSource()==bBtn) 
        output="wrong";
        if(e.getSource()==cBtn) 
        output="wrong";
          if(e.getSource()==dBtn) 
        output="wrong";
        
        

        repaint();
    }

    Color purple = new Color (200,50,100);
    public void paint (Graphics g)
    {
        
        g.setColor(purple);
        g.drawString("who holds the world record for womens 400m dash",400,100);
        g.drawString("Martia Koch",400,280);
        g.drawString(" Phyllis Francis ", 400,330);
        g.drawString("Shaunae Miller",600,280);
        g.drawString("Stefka Kostadinova",600,330);
       g.setFont(font26);
       g.drawString(output,300,500);

    }
}
