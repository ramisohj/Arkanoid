/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author R@MiSoHj
 */
public class Ball{
    
    private int radio;
    private int xc;
    private int yc;
    private int dx;
    private int dy;
    private int d;
    private int de;
    private int dde;
    private double m;
    private Color c;
    
    
    public Ball(){
    }
    
    public Ball(int radio, int xc, int yc,Color c){
        this.radio = radio;
        this.xc = xc;
        this.yc = yc;
        this.c = c;
    }
    
    public void paintBall(Graphics g,  int radio, int xc, int yc){
        Geometry.Circle.fullCircle(xc, yc, radio, g, c);
    }
    
    public void calcWay(int dx, int dy, int xc, int yc){
        this.dx = dx;
        this.dy = dy;
        this.xc = xc;
        this.yc = yc;
        
        m = (double) dy/dx;
        
        if(dx>0 && dy>0){
            if(m>=1){
                c1Higher();
            }else{
                c1Less();
            }
        }else{
        if(dx>0 && dy<0){
            if(m <= -1){
                c2Less();
            }else{
                c2Higher();
            }
        }else{
        if(dx<0 && dy<0){
            if(m >= 1){
                c3Less();
            }else{
                c3Higher();
            }
        }else{
        if(dx<0 && dy>0){
            if(m<=-1){
                c4Higher();
            }else{
                c4Less();
            }
        }
        }   
        }         
        }
    } 
    
    private void c1Higher(){
        d = dy + (2*-dx);
        dde = 2*-dx;
        de = 2*(dy-dx);
        
        if(d >= 0){
            d += dde;
            yc++;
        }else{
            d += de;
            xc++;
            yc++;
        }
    }
    
    private void c1Less(){
        d = 2*dy - dx;
        dde = 2*(dy-dx);
        de = 2*dy;
        
        if(d <= 0){
            d += de;
            xc++;
        }else{
            d += dde;
            xc++;
            yc++;
        }
    }
    
    private void c2Higher(){
        d = 2*dy + dx;
        dde = 2*dy+dx;
        de = 2*dy;
        
        if(d >= 0){
            d += de;
            xc++;
        }else{
            d += dde;
            xc++;
            yc++;
        }
    }
    
    private void c2Less(){
        d = dy + (2*dx);
        dde = 2*dx;
        de = 2*dy+dx;
        
        if(d >= 0){
            d += dde;
            xc++;
            yc--;
        }else{
            d += de;
            yc--;
        }
    }
    private void c3Less(){
        d = -dy + (2*dx);
        dde = 2*dx;
        de = 2*(-dy+dx);
        
        if(d <= 0){
            d += dde;
            xc--;
            yc--;
        }else{
            d += dde;
            xc--;
        }
    }
    
    private void c3Higher(){
        d = 2*-dy + dx;
        dde = 2*(-dy+dx);
        de = 2*-dy;
        
        if(d <= 0){
            d += de;
            xc--;
        }else{
            d += dde;
            xc--;
            yc--;
        }
    }
    
    private void c4Less(){
        d = -2*dy - dx;
        dde = 2*(-dy-dx);
        de = 2*-dy;
        
        if(d >= 0){
            d += de;
            xc--;
        }else{
            d += de;
            xc--;
            yc++;
        }
    }
    
    private void c4Higher(){
        d = -dy - (2*dx);
        dde = 2*(-dx);
        de = 2*(-dy-dx);
        
        if(d <= 0){
            d += dde;
            yc++;
        }else{
            d += de;
            xc--;
            yc++;
        }
    }
    
    public int getRadio(){
        return radio;
    }
    public int getXC(){
        return xc;
    }
    public int getYC(){
        return yc;
    }
    public int getDX(){
        return dx;
    }
    public int getDY(){
        return dy;
    }
    public void setDX(int dx){
        this.dx = dx;
    }
    public void setDY(int dy){
        this.dy = dy;
    }
    public void setXC(int x){
        xc = x;
    }
    public void setYC(int y){
        yc =  y;
    }
}
