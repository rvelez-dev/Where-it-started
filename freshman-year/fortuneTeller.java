
import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;
import java.util.Random;
//magic 8 ball rachel velez

public class magic8ball extends Applet implements ActionListener
{
    Random rand=new Random();
    Font font40=new Font("Comic Sans MS",1,40);
    TextField questionTF=new TextField();
    Button answerBtn=new Button ("Get answer here!");
    Button clearBtn=new Button ("Clear All");
  
    int randNum=10;

    Color purple = new Color (200,50,100);

    public void init()
    { 
        this .setLayout(null);

        answerBtn.setBounds(400,450,100,30);
        this.add(answerBtn);
        answerBtn.addActionListener(this);

        questionTF.setBounds(400,300,210,30);
        this.add(questionTF);

        clearBtn.setBounds (400,400,100,30);
        clearBtn.addActionListener(this);
        this.add(clearBtn);
        
    
    } 

    public void actionPerformed( ActionEvent e) 
    {
        if(e.getSource()==answerBtn) 
        {
            randNum=rand.nextInt(4);
        }
        
        if(e.getSource()==clearBtn)
        {
         randNum=10;
         questionTF.setText("");
        }

        repaint();
    }

    public void paint (Graphics g)
    {
        g.setColor(purple);
      
        g.drawString("Type in a question here!",400,100);
        if(randNum==0)
        g.drawString("Certainly not",200,200);
        if(randNum==1)
        g.drawString("maybee",200,200);
        if(randNum==2)
        g.drawString("looks good!",200,200);
        if(randNum==3)
        g.drawString("Never",200,200);
        
        

        
        
    }

} 
