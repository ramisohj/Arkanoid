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
public class Line extends Point {
    
    
    public void line(int x0, int y0, int xn, int yn, Graphics g, Color c){
        
        int x;
        float dx;
        float dy;
        float y;
        float m;
        dy = yn-y0;
        dx = xn-x0;
        m = dy/dx;
        y = y0;
        
        
        for(x = 0;x < xn;x++){
            putPixel(x,Math.round(y),g,c);
            y = y+m;
        }
    }
    
    public void midPointLine( int x0, int y0, int xn, int yn,Graphics g,Color c){
        int dx = xn-x0;
        int dy = yn-y0;
        if(dy<dx){
            //System.out.println("pendiente <0");
            midPointLine0(x0, y0, xn, yn, g, c);
        }else{
            //System.out.println("pendiente >0");
            midPointLine1(x0, y0, xn, yn, g, c);
        }
    }
    
    private void midPointLine0(int x0, int y0, int xn, int yn,Graphics g,Color c){
        int dx;
        int dy;
        int de;
        int dne;
        int d;
        int x;
        int y;
        
        dx = xn-x0;
        dy = yn -y0;
        d = 2*dy -dx;
        de = 2*dy;
        dne = 2*(dy-dx);
        x = x0;
        y = y0;
        
        putPixel(x, y,g,c);
        
        while(x <xn){
            if(d <= 0){
                d = d+de;
                x++;
            }else{
                d = d + dne;
                x++;
                y++;
                
            }
            putPixel(x, y,g,c);
        }
    }
    
    
    private void midPointLine1(int x0, int y0, int xn, int yn,Graphics g,Color c){
        int dx;
        int dy;
        int de;
        int dne;
        int d;
        int x;
        int y;
        
        dx = xn-x0;
        dy = yn -y0;
        d = 2*dx -dy;
        de = 2*dx;
        dne = 2*(dx-dy);
        x = x0;
        y = y0;
        
        putPixel(x, y,g,c);
        
        while(y <yn){
            if(d <= 0){
                d = d+de;
                y++;
            }else{
                d = d + dne;
                x++;
                y++;
                
            }
            putPixel(x, y,g,c);
        }
    }
    
}
