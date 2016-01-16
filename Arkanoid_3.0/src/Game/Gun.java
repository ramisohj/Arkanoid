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
 * @author jhosi
 */
public class Gun {
    
    private int xm;
    private int ym;
    private Color c;
    
    public Gun(int xm, int ym,Color c){
        this.xm = xm;
        this.ym = ym-10;
        this.c = c;
    }
    public void paintGun(Graphics g){
        Geometry.Line.midPointLine(xm, ym, xm, ym+10, g, c);
        Geometry.Line.midPointLine(xm-1, ym+5, xm-1, ym+12, g, c);
        Geometry.Line.midPointLine(xm+1, ym+5, xm+1, ym+12, g, c);  
    }
    public void setYM(int ym){
        this.ym = ym;
    }
    public void setXM(int xm){
        this.xm = xm;
    }
    public void goUp(){
        ym--;
    }
    
    public int getYM(){
        return ym;
    }
    public int getXM(){
        return xm;
    }
}
