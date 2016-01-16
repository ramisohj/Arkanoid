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
public class Gun {
    
    private int xm;
    private int ym;
    private int xl,yl;
    private int xr,yr;
    private Color c;
    private int h;
    
    public Gun(int xm, int ym,Color c){
        this.xm = xm;
        this.ym = ym-10;
        xl = xm-1;
        yl = ym+5;
        xr = xm+1;
        yr = ym+5;
        this.c = c;
        h = 10;
    }
    public void paintGun(Graphics g){
        Geometry.Line.midPointLine(xm, ym, xm, ym+h, g, c);
        Geometry.Line.midPointLine(xl, yl, xl, yl+h, g, c);
        Geometry.Line.midPointLine(xr, yr, xr, yr+h, g, c);    
    }
    //     GUN MAP 
    //                        (xm,ym)
    //                          |
    //                 (xl,yl)  |  (xr,yr)
    //                        | | |
    //                        | | |
    //                        | | |    
    //                        |   |
    //                        |   |
    //
    public void setYM(int ym){
        this.ym = ym;
        updateGun();
    }
    //public void setXM(int xm){
    //    this.xm = xm;
    //}
    public void goUp(){
        ym--;
        updateGun();
    }
    
    public int getYM(){
        return ym;
    }
    public int getXM(){
        return xm;
    }
    public int getYL(){
        return yl;
    }
    public int getXL(){
        return xl;
    }
    public int getYR(){
        return yr;
    }
    public int getXR(){
        return xr;
    }
    private void updateGun(){
        xl = xm-1;
        yl = ym+5;
        xr = xm+1;
        yr = ym+5;
    }
}
