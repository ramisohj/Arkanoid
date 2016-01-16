/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/**
 *
 * @author usuario
 */
public class Test extends JFrame{
    
    public static void main(String args[]){
        Test t = new Test();
        t.init();
    }
    
    public void init() {
        //final width = 1366 ;
        //final height = 744 ;
        this.setTitle("ARKANOID");
        this.setSize(600, 600);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });    
    }
    
    public void paint(Graphics g){
        g.setColor(Color.yellow);
        //Geometry.Line.midPointLine(20,400, 500, 100, g, Color.red);
        //Geometry.Line.midPointLine(20,20, 500, 450, g, Color.blue);
        //Geometry.Line.midPointLine(500, 600, 20,20, g, Color.black);
        Geometry.Line.midPointLine(60,250,450, 250, g, Color.black);
        //g.drawLine(570, 30, 30,540);
        //g.drawLine(50, 550, 450,550);
    }
    
}
