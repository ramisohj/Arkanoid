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
    
    private int x; 
    private int y;
    
    
    public void putPixel(int x0, int y0, Graphics g,Color c){
        g.setColor(c);
        setx(x0);
        sety(y0);
        g.drawLine(x,y,x,y);    
    }   
    public void setx(int x0){
        x = x0;
    }
    public void sety(int y0){
        y = y0;
    }
    public int getx(){
        return x;
    }
    public int gety(){
        return y;
    }
    
}
