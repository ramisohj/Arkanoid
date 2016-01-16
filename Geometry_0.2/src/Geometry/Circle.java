/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Geometry;

import java.awt.Color;
import java.awt.Graphics;
import static java.lang.Thread.sleep;

/**
 *
 * @author jhosi
 */
public class Circle extends Point{

    
    
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

    private void circlePoints(int x, int y,int xc, int yc,  Graphics g, Color c) {
       
        putPixel( x + xc , y + yc, g, c);
        putPixel( x + xc, -y + yc, g, c);
        putPixel(-x + xc,  y + yc, g, c);
        putPixel(-x + xc, -y + yc, g, c);  
        
        putPixel( y + xc, x + yc, g, c);
        putPixel( y + xc,-x + yc, g, c);
        putPixel(-y + xc, x + yc, g, c);
        putPixel(-y + xc,-x + yc, g, c);
    }
    
    public void fullCircle(int xc, int yc,int radio, Graphics g, Color c){
        int r_x;
        int r_y;
        int r_w;
        int r_h;
        
        int x;
        int y;
        int d;
        
        x = 0;
        y = radio;
        d = 1-radio;
        circlePoints(x,y,xc,yc,g,c);
        //System.out.println("x = "+x+"; y = "+y);
        
        int l = (int)(Math.sin(Math.toRadians(45))*radio);
        full(xc, yc,l,g,c);
        
        
        while(y>x){
            if(d<0){//sector E
                d = d + x*2+3;
                x++;
                circlePoints(x, y, xc, yc, g, c);
                
            }else{//sector SE
                d = d + (x-y)*2+5;
                x++;
                y--;
                
                for(int i = 0; i<=x;i++){
                    circlePoints(i, y, xc, yc, g, c);
                    circlePoints(y, i, xc, yc, g, c);
                }
            }
        }
        r_x = xc+x;
        r_y = yc-y;
        r_w = 2*x;
        r_h = 2*y;
        circlePoints(r_x, r_y, r_w, r_h, g, c);
        
        
        
    }
    
    
    public void full(int xc, int yc, int radio, Graphics g, Color c){
        
        int xstart = xc-radio;
        int xend = xc+radio;
        int ystart = yc-radio;
        int yend = yc+radio;
        
        for(int i = xstart; i<xend; i++){
            for(int j= ystart; j<yend;j++){
                putPixel(i, j, g, c);
            }
        }
    
    }
    
    
    public void midPointCircle2(int xc, int yc,int radio,Graphics g, Color c){
    
        for(int i = 0; i<=radio;i++){
            midPointCircle(xc, yc, i, g, c);
        }
        
    }
    
}
