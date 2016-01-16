/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author usuario
 */
public class Frame extends JFrame{
    Point p = new Point();
    Line l = new Line();
    Circle cir  = new Circle();
    
    public static void  main(String args []){
        Frame f = new Frame();
      
        f.init();
    }
    
    public void init(){
        this.setTitle("FRAME GRAFICACION.......");
        this.setSize(800,800);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter()    
        {public void windowClosing(WindowEvent e){System.exit(0);}});
    }
    
    public void paint(Graphics g){
        
       
        
        //gm.putPixel(-100,100,g,Color.BLUE );
        
        p.putPixel(-350,50,g,Color.red );
        l.line(0, 0, 500, 500,g,Color.BLUE);
        
        
        l.midPointLine(0, 0, 500, 800,g,Color.BLACK);
        g.setColor(Color.red);
        g.drawLine(0, 0, 500, 840);
            
        //g.setColor(Color.GREEN);
        cir.midPointCircle(600, 600, 50, g, Color.CYAN);
        
        cir.midPointCircle(500, 500, 100, g, Color.CYAN);
        cir.midPointCircle(500, 400, 100, g, Color.CYAN);
        cir.midPointCircle(500, 600, 100, g, Color.CYAN);
        cir.midPointCircle(400, 400, 100, g, Color.CYAN);
        cir.midPointCircle(400, 600, 100, g, Color.CYAN);
        
        cir.midPointCircle(500,100,100, g, Color.BLACK);
        
        
        
        int j = 500;
        int n = 0;
        
        for(int i = 0; i<800;i++){
            
            
            cir.midPointCircle(i,i,10, g, Color.red);                        
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            cir.midPointCircle(n, 250, 10, g, Color.red);
            cir.midPointCircle(i, j,10 , g, Color.red);
            j--;
            cir.midPointCircle(250, n, 10, g, Color.red);
            n++;
           
        }
        
        /*
        for(int i = 800; i>=0;i--){
            
            for(int j = 0;j<800;j++){
                gm.midPointCircle(i,i,10, g, Color.CYAN);                        
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        */
        
        
        
    }
}
