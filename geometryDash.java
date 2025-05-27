//Rachel Velez Final Project
import java.awt.*;
import java.applet.*; 
import java.applet.Applet;
import java.awt.event.*;
import java.lang.Math;

public class geometryDash extends Applet implements KeyListener, Runnable
{
    int cubeX=200,cubeY=500,yChange=0;
    int miniCubeX=200,miniCubeY=500,xChangeMini=4,yChangeMini=4;
    int miniCubeX1=200,miniCubeY1=500,xChangeMini1=4,yChangeMini1=4;
    int miniCubeX2=200,miniCubeY2=500,xChangeMini2=3,yChangeMini2=3;
    int miniCubeX3=200,miniCubeY3=500,xChangeMini3=2,yChangeMini3=2;
    int xPTS[]={500,475,525};
    int yPTS[]={490,540,540};
    int xPTS1[]={790,815,765};
    int yPTS1[]={490,540,540};
    int xPTS2[]={840,865,815};
    int yPTS2[]={490,540,540};
    int xPTS3[]={1474,1500,1450};
    int yPTS3[]={445,490,490};
    int xPTS4[]={1575,1600,1550};
    int yPTS4[]={490,540,540};
    int xPTS5[]={1775,1800,1750};//triangle that is not on beat 
    int yPTS5[]={490,540,540};
    int xPTS6[]={2075,2100,2050};
    int yPTS6[]={490,540,540};
    int xPTS7[]={2430,2455,2405};
    int yPTS7[]={490,540,540};
    int xPTS8[]={2630,2655,2605};
    int yPTS8[]={420,470,470};
    int xPTS9[]={2830,2855,2805};
    int yPTS9[]={490,540,540};
    int xRect=1200;
    int xRect1=3100;
    int xRect2=3350;
    int xRect3=1050;
    int xRect4=3100;
    int xRect5=3700;
    int xPlank=2400; 
    int xPlank1=2600; 
    int xPlank2=2800; 
    int loopCt=0; 
    Color darkRed = new Color (128,0,0);
    Color purple= new Color(128,0,128);
    Color blue= new Color(0,0,128);
    Color darkblue= new Color(0,0,64);
    boolean gameOver=false;
    boolean play=true;
    boolean jump=false;
    boolean stand;
    //AudioClip backGroundMusic; 
    //AudioClip died; 
    Image buffer;
    Graphics bufferG;
    Thread main=new Thread(this);

    public void init()
    {
        this.addKeyListener(this);
        resize(1400,700);
        buffer=createImage(this.getWidth(),this.getHeight());
        //backGroundMusic=this.getAudioClip(this.getCodeBase(),"sound.wav");// Sound file from youtube, RAVE by Dxrk 
        //died=this.getAudioClip(this.getCodeBase(),"died.wav");// Sound file from youtube, Geometry Dash Effect 
        bufferG=buffer.getGraphics();
        this.resize(1400,756);

        main.start();

    } 

    public void paint(Graphics g)
    { 
        if(loopCt>=0&&loopCt<510)
        {
            bufferG.setColor(blue);
        }
        else if(loopCt>=530&&loopCt<1035) 
            bufferG.setColor(Color.black);
        else if(loopCt>=1035&&loopCt<1550)
            bufferG.setColor(Color.green);
        else if(loopCt>=1550&&loopCt<2070)
            bufferG.setColor(Color.blue);
        else if(loopCt>=2070&&loopCt<3065)
            bufferG.setColor(Color.white);
        else 
            bufferG.setColor(Color.black);
        bufferG.fillRect(0,0,1400,750);
        if(gameOver)
        {
            bufferG.setColor(Color.yellow);
            bufferG.fillRect(miniCubeX,miniCubeY,20,20);
            bufferG.fillRect(miniCubeX1,miniCubeY1,20,20);
            bufferG.fillRect(miniCubeX2,miniCubeY2,20,20);
            bufferG.fillRect(miniCubeX3,miniCubeY3,20,20);
        }
        else 
        {
            bufferG.setColor(Color.yellow); 
            bufferG.fillRect(cubeX,cubeY,40,40);
        }
        bufferG.setColor(darkblue); 
        bufferG.fillRect(0,540,1400,200);
        bufferG.setColor(purple); 
        bufferG.fillPolygon(xPTS,yPTS,3);
        bufferG.fillPolygon(xPTS1,yPTS1,3);
        bufferG.fillPolygon(xPTS2,yPTS2,3);
        bufferG.fillPolygon(xPTS3,yPTS3,3);
        bufferG.fillPolygon(xPTS4,yPTS4,3);
        //bufferG.fillPolygon(xPTS5,yPTS5,3);
        bufferG.fillPolygon(xPTS6,yPTS6,3);
        bufferG.fillPolygon(xPTS7,yPTS7,3);
        bufferG.fillPolygon(xPTS8,yPTS8,3);
        bufferG.fillPolygon(xPTS9,yPTS9,3);
        bufferG.fillRect(xRect,300,50,40);
        bufferG.fillRect(xRect1,450,50,40);
        bufferG.fillRect(xRect2,450,50,40);
        bufferG.fillRect(xRect3,490,450,50);
        bufferG.fillRect(xRect4,490,450,50);
        bufferG.fillRect(xRect5,490,450,50);
        bufferG.fillRect(xPlank,470,60,20);
        bufferG.fillRect(xPlank1,470,60,20);
        bufferG.fillRect(xPlank2,470,60,20);
        bufferG.setColor(Color.white); 
        //bufferG.drawString("cube x "+cubeX+"    cube y "+cubeY+" xRect4 "+xRect4 ,100,400);

        g.drawImage(buffer,0,0,this);
    }

    public void update(Graphics g)
    { 
        paint(g);;
    }

    public void run()
    {
        //backGroundMusic.play(); 
        while(!gameOver)
        {
            loopCt++;
            for(int i=0;i<3;i++)
            {
                xPTS[i]-=10;
                xPTS1[i]-=10;
                xPTS2[i]-=10;
                xPTS3[i]-=10;
                xPTS4[i]-=10;
                xPTS5[i]-=10;
                xPTS6[i]-=10;
                xPTS7[i]-=10;
                xPTS8[i]-=10;
                xPTS9[i]-=10;
            }
            xRect-=10;
            xRect1-=10;
            xRect2-=10;
            xRect3-=10;
            xRect4-=10;
            xRect5-=10;
            xPlank-=10;
            xPlank1-=10;
            xPlank2-=10;
            Rectangle cubeRect=new Rectangle(cubeX,cubeY,30,30);    
            Rectangle firstRect= new Rectangle(xPTS[0]-25,yPTS[0],40,40);
            Rectangle secondRect= new Rectangle(xPTS1[0]-25,yPTS1[0],40,40);
            Rectangle thirdRect= new Rectangle(xPTS2[0]-25,yPTS2[0],40,40);
            Rectangle fourthRect= new Rectangle(xRect,500,50,40);
            Rectangle fifthRect= new Rectangle(xRect1,450,40,40);
            Rectangle sixthRect= new Rectangle(xRect2,450,40,40);
            Rectangle seventhRect= new Rectangle(xRect3,490,450,50);
            Rectangle eigthRect= new Rectangle(xPTS8[0]-25,yPTS8[0],40,40);
            Rectangle ninthRect= new Rectangle(xPTS9[0]-25,yPTS9[0],40,40);
            Rectangle tenthRect= new Rectangle(xPTS7[0]-25,yPTS7[0],40,40);
            Rectangle rect11= new Rectangle(xPTS6[0]-25,yPTS6[0],40,40);
            Rectangle rect12= new Rectangle(xPTS4[0]-25,yPTS4[0],40,40);
            Rectangle rect13= new Rectangle(xPTS3[0]-25,yPTS3[0],40,40);
            Rectangle rect14= new Rectangle(xRect4,490,450,50);
            Rectangle platform= new Rectangle(xPlank,470,60,10);
            Rectangle platform1= new Rectangle(xPlank1,450,60,10);

            if(cubeRect.intersects(firstRect))
            {   gameOver=true; 
            }
            if(cubeRect.intersects(secondRect))
                gameOver=true; 
            if(cubeRect.intersects(thirdRect))
                gameOver=true;  
            if(cubeRect.intersects(fourthRect))
                gameOver=true;    
            if(cubeRect.intersects(fifthRect))
                gameOver=true;
            if(cubeRect.intersects(sixthRect))
                gameOver=true;            
            /*if(cubeRect.intersects(platform))
            {
            jump=false;
            cubeY=441;
            }
            else if(cubeRect.intersects(platform1))
            {
            jump=false;
            cubeY=410;
            }*/
            if(cubeRect.intersects(seventhRect))
            {
                if(!jump)
                    gameOver=true; 
                else 
                {
                    jump=false;
                    cubeY=450;
                }
            }
               if(cubeRect.intersects(rect14))
            {
                if(!jump)
                    gameOver=true; 
                else 
                {
                    jump=false;
                    cubeY=450;
                }
            }
            if(cubeRect.intersects(eigthRect))
                gameOver=true;    
            if(cubeRect.intersects(ninthRect))
                gameOver=true;   
            if(cubeRect.intersects(tenthRect))
                gameOver=true;     
            if(cubeRect.intersects(rect11))
                gameOver=true;       
            if(cubeRect.intersects(rect12))
                gameOver=true;    
            if(cubeRect.intersects(rect13))
                gameOver=true;                  
            if(cubeY==450&&!jump&&xRect3>-220&&xRect3<-200)
                cubeY=500; 
            if(cubeY==450&&!jump&&xRect4>-260&&xRect4<-240)
                cubeY=500;      
            if(jump)
            {
                yChange++;
                cubeY+=yChange;
                if(cubeY>500)
                {
                    jump=false;
                    stand=true;
                    cubeY=500; 
                }
            }

            repaint();
            try{ main.sleep(20);}
            catch(Exception e){}
        }

        //backGroundMusic.stop(); 
        //died.play(); 

        while(gameOver)
        {
            miniCubeX+=xChangeMini;
            miniCubeY-=yChangeMini;
            miniCubeX1-=xChangeMini1;
            miniCubeY1-=yChangeMini1;
            miniCubeX2+=xChangeMini2;
            miniCubeY2-=yChangeMini2;
            miniCubeX3-=xChangeMini3;
            miniCubeY3-=yChangeMini3;
            repaint();
            try{ main.sleep(20);}
            catch(Exception e){}
        }
    }

    public void keyReleased(KeyEvent e)
    {
        if(jump==false)
        {

        }
    }

    public void keyTyped(KeyEvent e){}

    public void keyPressed(KeyEvent e)
    {
        int code=e.getKeyCode(); 
        if(code==e.VK_UP&&jump==false)
        {
            yChange=-15;
            jump=true; 
        }
    }
}
