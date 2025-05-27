import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;

//// pong rachel velez:)

public class pong extends Applet implements KeyListener, Runnable
{
    Color green = new Color (110,200,50);
    Thread main=new Thread(this);
    Font font26=new Font("Comic Sans MS",1,26);
     Font font60=new Font("Comic Sans MS",1,60);
    int ballX=300, ballY=300,xChange=5,yChange=3;
    int leftPaddleX=50,leftPaddleY=400,xpaddle=-10,ypaddle=4;
    int rightPaddleX=400,rightPaddleY=500,xright=5,yright=4;
    int rightScore=0;
    int leftScore=0;
    boolean pause=false;
    Image buffer;
    Graphics bufferG;

    public void init()
    {
        this.addKeyListener(this);
        resize(1400,700);
        buffer=createImage(this.getWidth(),this.getHeight());
        bufferG=buffer.getGraphics();
        this.resize(1400,756);
        main.start();
    } 

    public void paint(Graphics g)
    { 
        bufferG.setColor(Color.white);

        bufferG.fillRect(0,0,this.getWidth(),this.getHeight());
        bufferG.setColor(green);
        bufferG.fillRect(0,0,this.getWidth(),this.getHeight());
        bufferG.setColor(Color.white);
        bufferG.fillRect(50,leftPaddleY,10,70);
        bufferG.fillRect(1300,rightPaddleY,10,70);
        bufferG.fillOval(ballX,ballY,20,20);
        bufferG.fillRect(650,0,3,700);
        bufferG.drawOval(500,225,300,300);
         bufferG.setFont(font60);
         bufferG.drawString("PONG",570,400);
        bufferG.setFont(font26);
        bufferG.drawString(""+leftScore,100,100);
        bufferG.drawString(""+rightScore,1000,100);
        if (leftScore==3)
        {
            bufferG.drawString("you have won the game!",300,300);
        }
        if (rightScore==3)
        {
            bufferG.drawString("you have won the game!",300,300);
        }
        g.drawImage(buffer,0,0,this); 

    }

    public void update(Graphics g)
    { 
        paint(g);;
    }

    public void run()
    {
        while(leftScore<3&&rightScore<3)
        {  
            if(pause==false)
            {
                
            ballX=ballX+xChange;
            ballY=ballY+yChange;
            Rectangle leftRect=new Rectangle(50,leftPaddleY,10,70);
            Rectangle rightRect=new Rectangle(1300,rightPaddleY,10,70);
            Rectangle ballRect=new Rectangle(ballX,ballY,20,20);
            if(leftRect.intersects(ballRect))
            {
                xChange=xChange*-1;
                xChange++;
            }

            if(rightRect.intersects(ballRect))
            {
                xChange=xChange*-1;

            }

            if(ballY<5|| ballY>700)
            {
                yChange=-1*yChange;

            }
            if(ballX<5)
            {
                rightScore=rightScore+1;
                ballX=650;
                xChange=xChange*-1;
            }
            if(ballX>1300) 
            {
                leftScore=leftScore+1; 
                ballX=650;
                xChange=xChange*-1;
            }
            if(leftPaddleY<0)
            {
                leftPaddleY=5;
            }
            if(rightPaddleY<0)
            {
                rightPaddleY=5; 
            }
            if(leftPaddleY>1350)
            {
                leftPaddleY=0;
            }

            repaint();
            try{ main.sleep(20);}
            catch(Exception e){}
        }
    }

    }

    public void keyReleased(KeyEvent e)
    {
        int code=e.getKeyCode();

        if(code==e.VK_Q)
        {
            leftPaddleY=leftPaddleY-20;
        }
        if(code==e.VK_A)
        {
            leftPaddleY=leftPaddleY+20;
        }
        if(code==e.VK_UP)
        {
            rightPaddleY=rightPaddleY-20;   
        }
        if(code==e.VK_DOWN)
        {
            rightPaddleY=rightPaddleY+20;
        }
        if(code==e.VK_SPACE)
        {
          pause=!pause;
        }
    }

    public void keyTyped(KeyEvent e){}

    public void keyPressed(KeyEvent e){}

}
