/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class Block {
    
    private int xs;
    private int ys;
    
    private int xe;
    private int ye;
    
    private int width;
    private int height;
    
    private Color c;
    
    public Block(int xo, int yo,int w, int h,Color c){
        xs = xo;
        ys = yo;
        width = w;
        height = h;
        this.c = c;
    }
    
        //
        //  (XO,YO)_______________________________
        //      |                                  |
        //      |                                  |
        //      |                                  |
        //      |                                  |
        //      |_________________________________ |
    
    
    public void paintBlock(Graphics g){
        
        paintBorder(g,2,Color.ORANGE);
        
        //for(int y = ys; )
    }
    
    private void paintBorder(Graphics g,int size,Color c){
        //System.out.println("ys :"+ys);
        //paint width
        
        for(int i = 0; i <= size;i++){
            Geometry.Line.midPointLine(xs, ys+i, xs+width, ys+i, g, c);
        }
        //Geometry.Line.midPointLine(xs, ys, xs+width, ys, g, Color.RED);
        //Geometry.Line.midPointLine(xs, ys+1, xs+width, ys+1, g, Color.RED);
        for(int i=0;i<=size;i++){
            Geometry.Line.midPointLine(xs, ys+height-i, xs+width, ys+height-i, g,c);
        }
        //Geometry.Line.midPointLine(xs, ys+height, xs+width, ys+height, g, Color.RED);
        //Geometry.Line.midPointLine(xs, ys+height-1, xs+width, ys+height-1, g, Color.RED);
        
        //paint height
        
        for(int i=0;i<=size;i++){
            Geometry.Line.midPointLine(xs+i, ys, xs+i, ys+height, g, c);
        }
        
        //Geometry.Line.midPointLine(xs, ys, xs, ys+height, g, Color.RED);
        //Geometry.Line.midPointLine(xs+1, ys, xs+1, ys+height, g, Color.RED);
        
        for(int i=0; i<=size;i++){
            Geometry.Line.midPointLine(xs+width-i, ys, xs+width-i, ys+height, g, c);
        }
        //Geometry.Line.midPointLine(xs+width, ys, xs+width, ys+height, g, Color.RED);
        //Geometry.Line.midPointLine(xs+width-1, ys, xs+width-1, ys+height, g, Color.RED);
        //System.out.println("ys :"+ys);
    }
    
    public void setX(int x){
        xs = x;
    }
    public void setY(int y){
        ys = y;
    }
    public int getX(){
        return xs;
    }
    public int getY(){
        return ys;
    }
    
    
    
    
    //OPTIONAL FUNCTIONS
    
         //
        // (X1,Y1)_______________________________(x2,y2)
        //      |                                  |
        //      |                                  |
        //      |                                  |
        //      |                                  |
        // (x3,y3)_______________________________(x4,y4)
    
    
    int x1 = xs;
    int y1 = ys;
    
    
    int x2 = x1+width;
    int y2 = ys;
    
    int x3 = xs;
    int y3 = ys+height;
    
    int x4 = x2; 
    int y4 = y3;
    
    int ly;
    int [] lx;
    
    
    public ArrayList<Integer> getPointListUp(int r,int xc, int yc){
        
        ArrayList<Integer> lr = new ArrayList<Integer>();
        x1 = xs;
        y1 = ys;
        
        lx = new int[width];
        ly = ys;
        int countX = x1;//count x
        //System.out.println("radio: "+r+"; xc: "+xc+" ;yc "+yc+"; x1: "+x1+"; y1: "+y1);
        for(int i = 0; i<width;i++){
            lx[i]= countX;
            countX++;
        }
        for(int i = 0;i<width;i++){
            lr.add(getRadio2(r,xc,yc,lx[i],ly));
        } 
        return lr;
    }
    private int getRadio2(int r, int xc, int yc, int x1, int y1){
        int  res = 0;
        res = (int)(Math.pow(x1-xc, 2)+Math.pow(y1-yc, 2));
        return res;
    }
}
