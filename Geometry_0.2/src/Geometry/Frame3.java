
package Geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author jhosi
 */
public class Frame3 extends JFrame {

    Point p = new Point();
    Line l = new Line();
    Circle cir = new Circle();

    public static void main(String args[]) {
        Frame3 m = new Frame3();
        m.init();
    }

    public void init() {
        this.setTitle("FRAME GRAFICACION.......");
        this.setSize(600, 600);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void paint(Graphics g) {

        int x = 300;
        int y = 600;
        int radio = 20;

        Image m1 = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);

        getImage(m1, x, y, radio, Color.red);

        for (int i = 0; i < 600; i++) {

            g.setColor(Color.black);
            m1.getGraphics().setColor(Color.black);
            
            getImage(m1, i, i, radio, Color.pink);
            getImage(m1,i+30,i+30,10,Color.BLUE);
            getImage(m1,i-40,i+40,15,Color.GREEN);
            
            block(m1, i+50, i-50, 10, 20, Color.black);
            g.drawImage(m1, 0, 0, this);
            //g.setColor(Color.white);
            //g.fillRect(0, 0, 600, 600);
            try {
                sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Frame3.class.getName()).log(Level.SEVERE, null, ex);
            }
            m1.getGraphics().setColor(Color.black);
            m1.getGraphics().fillRect(0, 0, 600, 600);
            //repaint();
        }

        /*
         while(true){
            
         cir.fullCircle(x, y, radio, g, Color.red);        
            
            
            
            
         y--;
         try {
         sleep(30);
         } catch (InterruptedException ex) {
         Logger.getLogger(Frame3.class.getName()).log(Level.SEVERE, null, ex);
         }
            
            
         g.setColor(Color.white);
         g.fillRect(0, 0, 800, 800);
            
            
         }
         */
        //l.midPointLine(0,0,80, 600, g, Color.red);
    }

    public void getImage(Image m, int xc, int yc, int radio, Color c) {

        cir.fullCircle(xc, yc, radio, m.getGraphics(), c);

    }
    
    
    public void block(Image cont, int x, int y, int w, int h,Color c){
         
        int xe = x+w;
        int xs = x;
        
        for(int j = y;j<=w+y;j++){
           l.midPointLine(xs, j, xe, j,cont.getGraphics(), c);
        }
        
        //return im;
    }
    
    

}
