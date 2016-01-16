/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Geometry;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author jhosi
 */
public class Point extends JPanel{
    
    private static int x; 
    private static int y;
    
    
    public static void putPixel(int x0, int y0, Graphics g,Color c){
        g.setColor(c);
        setx(x0);
        sety(y0);
        g.drawLine(x,y,x,y);    
    }   
    public static void setx(int x0){
        x = x0;
    }
    public static void sety(int y0){
        y = y0;
    }
    public static int getx(){
        return x;
    }
    public static int gety(){
        return y;
    }
    
}
