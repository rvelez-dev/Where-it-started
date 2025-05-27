
import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;

//// mouse rachelll

public class MousePractice extends Applet implements MouseListener
{
    int mouseX=-200,mouseY=-200;

    public void init()
    {
        this.addMouseListener(this);
    }

    public void paint(Graphics g)
    { 
        g.drawString("you clicked at x="+mouseX+"and y="+mouseY,10,10);
    }


    public void mouseClicked(MouseEvent e)
    {
        mouseX=e.getX();
        mouseY=e.getY();

        repaint();
    }

    public void mousePressed(MouseEvent e){}


    public void mouseReleased(MouseEvent e){}


    public void mouseEntered(MouseEvent e){}


    public void mouseExited (MouseEvent e){}
}
