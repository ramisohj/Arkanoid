/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package arkanoid;

import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author usuario
 */
public class Pixel extends  JFrame {
    
    static JFrame frame;
    
    public static void main(String args[]){
        
        frame = new JFrame("Graficacion....");
        frame.setBounds(50, 50, 400, 500);
        
        Graphics g = frame.getGraphics();
        
        g.drawLine(10, 10, 100, 100);
        frame.paint(g);
        frame.setVisible(true);
    }
    
    
    public void writePixel(int x,int y,int color,Graphics g){
        g.drawLine(x, y, x, y);
    }
    
    public void res(){
        
    }
    

}
