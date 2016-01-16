/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package arkanoid;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JFrame;

/**
 *
 * @author usuario
 */
public class Other extends JFrame {
    
    public static void main (String args [] ){
        Other m = new  Other();
     
    }
    
    public Other(){
        this.setTitle("Or");
        this.setSize(500, 500);
        this.setResizable(false);
        this.setVisible(true);
 
    }
 
    @Override
    public void paint(Graphics g){
        g.drawLine(50, 50, 500, 500);
     
    }
    
}
