package Geometry;


import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usuario
 */
public class Geometry extends JFrame {
    
    public void putPixel(int x, int y,Graphics g,Color c){
        g.setColor(c);
        g.drawLine(x, y, x, y);
    }
    public void line(int x0, int y0, int x1, int y1, Graphics g,Color c){
        //para tipos de pendiente = 0<m<1 
        int x;
        float dx;
        float dy;
        float y;
        float m;
        dy = y1-y0;
        dx = x1-x0;
        m = dy/dx;
        y = y0;
        
        for(x = 0;x < x1;x++){
            putPixel(x,Math.round(y),g,c);
            y = y+m;
        }
    }
    
    public void midPointLine( int x0, int y0, int x1, int y1,Graphics g,Color c){
        
        int dx = x1-x0;
        int dy = y1-y0;
        //float m = dy/dx;
        
        if(dy<dx){
            midPointLine0(x0, y0, x1, y1, g, c);
        }else{
            System.out.println("iAM HERE MID1");
            midPointLine1(x0, y0, x1, y1, g, c);
        }
    }
    
    public void midPointLine0(int x0, int y0, int x1, int y1,Graphics g,Color c){
        int dx;
        int dy;
        int de;
        int dne;
        int d;
        int x;
        int y;
        
        dx = x1-x0;
        dy = y1 -y0;
        d = 2*dy -dx;
        de = 2*dy;
        dne = 2*(dy-dx);
        x = x0;
        y = y0;
        
        putPixel(x, y,g,c);
        
        while(x <x1){
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
    
    
    public void midPointLine1(int x0, int y0, int x1, int y1,Graphics g,Color c){
        int dx;
        int dy;
        int dn;
        int dne;
        int d;
        int x;
        int y;
        
        dx = x1-x0;
        dy = y1 -y0;
        d = dx*2 -dy;
        dn = 2*dx;
        dne = 2*(dx-dy);
        x = x0;
        y = y0;
        
        putPixel(x, y,g,c);
        
        while(y <y1){
            if(d <= 0){
                d = d+dn;
                y--;
            }else{
                d = d + dne;
                x--;
                y--;
                
            }
            putPixel(x, y,g,c);
        }
    }
    
    
    public void midPointCircle(int xc, int yc,int radio,Graphics g, Color c){
        int x;
        int y;
        int d;
        int de;
        int dse;
        
        x = 0;
        y = radio;
        d = 1-radio;
        de = 3;
        dse = -2*radio  +5;
        
        circlePoints(x,y,xc,yc,g,c);
        //System.out.println("x = "+x+"; y = "+y);
        while(y>x){
            if(d<0){//sector E
                d = d +de;
                de = de +2;
                dse = dse +2;
                x++;
            }else{//sector SE
                d = d +dse;
                de = de +2;
                dse = dse +4;
                x++;
                y--;
            }
            //System.out.println("x = "+x+"; y = "+y);
            circlePoints(x, y,xc,yc, g, c);
        }
        
    }

    public void circlePoints(int x, int y,int xc, int yc,  Graphics g, Color c) {
       
        putPixel( x + xc , y + yc, g, c);
        putPixel( x + xc, -y + yc, g, c);
        putPixel(-x + xc,  y + yc, g, c);
        putPixel(-x + xc, -y + yc, g, c);  
        
        putPixel( y + xc, x + yc, g, c);
        putPixel( y + xc,-x + yc, g, c);
        putPixel(-y + xc, x + yc, g, c);
        putPixel(-y + xc,-x + yc, g, c);
    }

   
}
