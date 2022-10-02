import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;

public class Main extends JFrame {
    public Main(){
        setSize(800,500);
        setLocationRelativeTo(null);
        setLayout(null);

    }
    public static void main(String[] args) {
        MyGraphics graphics = new MyGraphics();
        Main F = new Main();
        F.add(graphics);
        F.setVisible(true);
    }
}
class MyGraphics extends JPanel implements MouseMotionListener, MouseListener{
    int x=0,y=0;
    JLabel label;
    Image img = Toolkit.getDefaultToolkit().createImage(System.getProperty("user.dir")+ File.separator+"cro.PNG");
    public  MyGraphics(){
        setSize(800,500);
        setLayout(null);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(img,x,y,this);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x= e.getX()-50;
        y=e.getY()-50;
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("X: "+e.getX()+"\tY: "+e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}