/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class Frame2 extends JFrame {
    
    Point p = new Point();
    Line l = new Line();
    Circle cir  = new Circle();
    
    
    public static void main(String args[]){
        Frame2 m = new Frame2();
        m.init();
    }
    
    
    public void init(){
        this.setTitle("FRAME GRAFICACION.......");
        this.setSize(800,800);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter()    
        {public void windowClosing(WindowEvent e){System.exit(0);}});
    }
    
    
    public void update(Graphics g){
        
        paint(g);
    }
    
    public void paint(Graphics g){
        //g.drawLine(0,0 , 500, 500);
        //cir.midPointCircle(500, 500, 50, g, Color.red);
        
        //BufferedImage b = new BufferedImage(800, 800, BufferedImage.TYPE_INT_ARGB);
        
        //Image i = new BufferedImage(800, 800, BufferedImage.TYPE_INT_ARGB);
        //Image m1 = image1(200,200,50,Color.BLUE);
       // m1.getGraphics().drawImage(image1(400, 400, 30, Color.red), 0, 0, rootPane);
        
        ///g.drawImage(m1, 0, 0, rootPane);
       
        //cir.midPointCircle(300, 300, 50, g, Color.PINK);
        
        //int n = 800;
        /*
        for(int i = 0; i<800;i++){
            cir.fullCircle(i, i, 50, g, Color.red);
            try {
                sleep(5);
            } catch (InterruptedException ex) {
                Logger.getLogger(Frame2.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            g.setColor(Color.white);
            g.fillRect(0, 0, 800, 800);
        }
        */
        for(int i = 0; i<800;i++){
            
                for(int j = 0 ;j<800;j++){
                cir.fullCircle(i, j, 20, g, Color.red);
                
                
                
                /*
                try {
                   // sleep(30);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Frame2.class.getName()).log(Level.SEVERE, null, ex);
                }
            */
                g.setColor(Color.white);
                g.fillRect(0, 0, 800, 800);
            }
        }
        
        
    }
    
    public void moveCir(int x, int y, Graphics g){
        BufferedImage bi = new BufferedImage(800, 800, BufferedImage.TYPE_INT_ARGB);
        cir.fullCircle(x, y, 50, bi.getGraphics(), Color.red);
        g.drawImage(bi, 0, 0, this);
        
    }

    public void repaint(Graphics g){
        BufferedImage i = new BufferedImage(800, 800, BufferedImage.TYPE_INT_ARGB);
        g = i.getGraphics();
        //g.drawImage(i, 0, 0, this);
        
    }
    
    Image i1;
    
    public Image image1(int xc, int yc, int r,Color c){
        i1 = new BufferedImage(800, 800,BufferedImage.TYPE_INT_RGB);
        i1.getGraphics();
        cir.fullCircle(xc, yc, r,i1.getGraphics(), c);
        return i1;
    }

   
    
    
    
}
