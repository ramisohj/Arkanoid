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
    
    
    public static void line(int x0, int y0, int xn, int yn, Graphics g, Color c){
     
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
    
    private static Graphics g ;
    private static Color c;
    private static int x1,y1;
    private static int x2,y2;
    private static int dx,dy;
    
    public static void midPointLine( int x1, int y1, int x2, int y2,Graphics g,Color c){
        Line.g = g;
        Line.c = c;
        Line.x1 = x1;
        Line.y1 = y1;
        Line.x2 = x2;
        Line.y2 = y2;
        getDXDY();
        //System.out.println("x1= "+x1+"; y1= "+y1+"; x2= "+x2+"; y2= "+y2);
        //System.out.println("dx= "+dx+"; dy= "+dy);
        paintLine();
    }

    private static  void paintLine(){ 
        double m;        
        m = (double) dy/dx;
        
        
        if(dx == 0){
            horizontalLine();
        }else{
        if(dy == 0){
            verticalLine();
        }else{
        if(dx>0 && dy>0){//primer cuadrante 
            if(m>=1){//2 octante
                o2();
            }else{//1 octante
                o1();
            }
        }else{
        if(dx>0 && dy<0){//4 cuadrante
            if(m <= -1){//7 octante
                o7();
            }else{
                o8();//8 octante
            }
        }else{
        if(dx<0 && dy<0){//3 cuadrante
            if(m >= 1){//6 octante
                o6();
            }else{
                o5();//5 octante
            }
        }else{
        if(dx<0 && dy>0){//2 cuadrante
            if(m<=-1){
                o3();//3 octante
            }else{
                o4();//4 octante
            }
        }
        }   
        }         
        }
        }
        }
    } 
    private static void soapX(){
        int xs;
        int ys;
        if(x1 > x2){
            xs = x1;
            ys = y1;
            
            x1 = x2;
            y1 = y2;
            x2 = xs;
            y2 = ys;
        }
    } 
    private static void soapY(){
        int xs;
        int ys;
        if(y1 > y2){
            xs = x1;
            ys = y1;
            
            x1 = x2;
            y1 = y2;
            x2 = xs;
            y2 = ys;
        }
    }
    private static void getDXDY(){
        int deltaX = Math.abs(x1 -x2);
        int deltaY = Math.abs(y1-y2);
        
        if(deltaX>deltaY){
            soapX();
            //System.out.println("--------------DELTA----X-----------");
        }else{
            soapY();
            //System.out.println("--------------DELTA----Y-----------");
        }
        
        dx = x2-x1;
        dy = y2-y1;
    }
    private static void horizontalLine(){
        soapY();
        //System.out.println("x1 = "+x1+"; y1 = "+y1);
        //System.out.println("x2 = "+x2+"; y2 = "+y2);
        for(int y= y1; y<=y2;y++){
            putPixel(x1, y, g, c);
            //System.out.println("x = "+x+"; y = "+y1);
        }
    }
    private static void verticalLine(){
        soapX();
        for(int x = x1;x<=x2;x++){
            putPixel(x,y1, g, c);
            //System.out.println("x = "+x+"; y = "+y1);
        }
    }
    private static void o1(){
      
        //System.out.println(".................1 Octant...............");
        int dStart = 2*dy - dx;//dstart       
        int dne = 2*(dy-dx);
        int de = 2*dy;
        
        putPixel(x1, y1, g, c);
        while(x1<x2){  
            if(dStart <= 0){//E
                dStart += de;
                x1++;
                //System.out.print("-----E-----");
            }else{//NE
                dStart += dne;
                x1++;
                y1++;
                //System.out.print("-----NE-----");
            }
            putPixel(x1, y1, g, c);
        }
    }
    
    private static void o2(){
        //System.out.println(".................2 Octant...............");
        
        int dStart = dy + (2*-dx);
        int dn = 2*-dx;
        int dne = 2*(dy-dx);
        
        putPixel(x1, y1, g, c);
        while(y1<y2){
            if(dStart >= 0){//N
                //System.out.print("-----N-----");
                dStart += dn;
                y1++;
            }else{//NE
                //System.out.print("-----NE-----");
                dStart += dne;
                x1++;
                y1++;
            }
            putPixel(x1, y1, g, c);
        }
    }
    
    private static void o3(){
        //System.out.println(".................3 Octant...............");
       
        int dStart = -dy - (2*dx);
        int dn = 2*(-dx);
        int dnw = 2*(-dy-dx);
        
        putPixel(x1, y1, g, c);
        while(y1<y2){
            if(dStart <= 0){//N
                //System.out.print("-----N-----");
                dStart += dn;
                y1++;
            }else{//NW
                //System.out.print("-----NW-----");
                dStart += dnw;
                x1--;
                y1++;
            }
            putPixel(x1, y1, g, c);
        }
    }
    private static void o4(){
        //System.out.println(".................4 Octant...............");
      
        int dStart = -2*dy - dx;
        int dnw = 2*(-dy-dx);
        int dw = 2*-dy;
        
        putPixel(x1, y1, g, c);
        while(x1>x2){
            if(dStart >= 0){//W
                dStart += dw;
                x1--;
                //System.out.print("-----W-----");
            }else{//NW
                dStart += dnw;
                x1--;
                y1++;
                //System.out.println("-----NW-----");
            }
            putPixel(x1, y1, g, c);
        }
    }
    private static void o5(){
        //System.out.println(".................5 Octant...............");
        
        int dStart = 2*-dy + dx;
        int dsw = 2*(-dy+dx);
        int dw = 2*-dy;
        
        putPixel(x1, y1, g, c);
        while(x1>x2){
            if(dStart <= 0){//W
                //System.out.print("-----W-----");
                dStart += dw;
                x1--;
            }else{//SW
                //System.out.print("-----SW-----");
                dStart += dsw;
                x1--;
                y1--;
            }
            putPixel(x1, y1, g, c);
        }
    }
    private static void o6(){
        //System.out.println(".................6 Octant...............");
        
        int dStart = -dy + (2*dx);
        int ds = 2*dx;
        int dsw = 2*(-dy+dx);
        
        putPixel(x1, y1, g, c);
        while(y1>y2){
            if(dStart <= 0){//SW
                //System.out.print("-----SW-----");
                dStart += dsw;
                x1--;
                y1--;
            }else{//S
                //System.out.print("-----S-----");
                dStart += ds;
                y1--; ///REPAIR 
            }
            putPixel(x1, y1, g, c);
        }
    }
    private static void o7(){
        //System.out.println(".................7 Octant...............");
        
        int dStart = dy + (2*dx);
        int ds = 2*dx;
        int dse = 2*(dy+dx);
        
        putPixel(x1, y1, g, c);
        while(y1>y2){
            if(dStart >= 0){//SE
                //System.out.print("-----SE-----");
                dStart += dse;
                x1++;
                y1--;
            }else{//S
                //System.out.print("-----S-----");
                dStart += ds;
                y1--;
            }
            putPixel(x1, y1, g, c);
        }
    }
    private static void o8(){
        //System.out.println(".................8 Octant...............");
        
        int dStart = 2*dy + dx;
        int dse = 2*(dy+dx);
        int de = 2*dy;
        
        putPixel(x1, y1, g, c);
        while(x1<x2){
            if(dStart >= 0){//E
                //System.out.print("-----E-----");
                dStart += de;
                x1++;
            }else{//SE
                //System.out.print("-----SE-----");
                dStart += dse;
                x1++;
                y1--;
            }
            putPixel(x1, y1, g, c);
        }
    }    
}
