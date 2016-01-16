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
import javax.swing.JFrame;

/**
 *
 * @author usuario
 */
public class Frame extends JFrame{
    Geometry gm = new Geometry();
    
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
        gm.putPixel(-100,100,g,Color.BLUE );
        gm.putPixel(-350,50,g,Color.red );
        gm.line(0, 0, 500, 600,g,Color.BLUE);
        gm.midPointLine1(0, 0, 500, 90,g,Color.RED);
        g.setColor(Color.GREEN);
        g.drawLine(0, 0, 500, 92);
        //g.drawLine(0, 100, 800, 100);
        //g.drawLine(0, 300, 800, 300);
        //g.drawLine(300, 0, 300, 800);
        //g.drawLine(100, 0, 100, 800);
        
        //g.drawLine(, 0, 300, 800);
        gm.midPointCircle(500,100,100, g, Color.BLACK);
    }
}
