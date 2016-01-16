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
    
    private boolean isDead;
    
    
    public Block(int xo, int yo,int w, int h,Color c){
        xs = xo;
        ys = yo;
        width = w;
        height = h;
        this.c = c;
        
        isDead = false;
    }
    
        //
        //  (XO,YO)_______________________________
        //      |                                  |
        //      |                                  |
        //      |                                  |
        //      |                                  |
        //      |_________________________________ |
    
    
    public void paintBlock(Graphics g){
        
        paintBorder(g,2,c);

    }
    
    private void paintBorder(Graphics g,int size,Color c){
      
        for(int i = 0; i <= size;i++){
            Geometry.Line.midPointLine(xs, ys+i, xs+width, ys+i, g, c);
        }
        for(int i=0;i<=size;i++){
            Geometry.Line.midPointLine(xs, ys+height-i, xs+width, ys+height-i, g,c);
        }        
        for(int i=0;i<=size;i++){
            Geometry.Line.midPointLine(xs+i, ys, xs+i, ys+height, g, c);
        }
        
        for(int i=0; i<=size;i++){
            Geometry.Line.midPointLine(xs+width-i, ys, xs+width-i, ys+height, g, c);
        }
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
    public boolean isDead(){
        return isDead;
    }
    public void killBlock(){
        isDead = true;
    }
    
    //OPTIONAL FUNCTIONS
    
         //
        // (X1,Y1)_______________________________(x2,y2)
        //      |                                  |
        //      |                                  |
        //      |                                  |
        //      |                                  |
        // (x3,y3)_______________________________(x4,y4)
    
    
    int x1 ;
    int y1 ; 
    
    int x2 ;
    int y2 ;
    
    int x3 ;
    int y3 ;
    
    int x4 ; 
    int y4 ;
    
    int ly;
    int [] lx;          //
                        //                  sideY1
    int sideX1;         //           _______________________
    int sideX2;         //          |                       |
    int sideY1;         //  sideX1  |                       |sideX2
    int sideY2;         //          |_______________________|
                        //                  sideY2
    
    public void updatePoints(){
        x1 = xs;
        y1 = ys; 
    
        x2 = x1+width;
        y2 = ys;
    
        x3 = xs;
        y3 = ys+height;
    
        x4 = x2; 
        y4 = y3;
        
        sideX1 = x1;
        sideX2 = x2;
        sideY1 = y1;
        sideY2 = y3;
    }
    
    
    //CRASH MAIN METHOD !!!!! 
    public void blockCrash(Ball ball){
        if(ball.getDY()>=0){
            crashTopToDown(ball);
        }else{
            crashDownToTop(ball);
        }
    }
    //TOP TO DOWN
    private void crashTopToDown(Ball ball){
        crashTop(ball);
        if(ball.getDX()>=0){
            crashLeft(ball);
        }else{
            crashRight(ball);
        }
    }
    //DOWN TO TOP
    private void crashDownToTop(Ball ball){
        crashDown(ball);
        if(ball.getDX()>=0){
            crashLeft(ball);
        }else{
            crashRight(ball);
        }
    }
    
    private void crashTop(Ball ball){
        int r = (int)Math.pow(ball.getRadio(),2)-(int)Math.pow(sideY1-ball.getYC(),2);
        double xp;
        double xp1;
        double xp2;
        if(r == 0){
            xp = ball.getXC();
            if(xp>=sideX1 && xp<= sideX2 ){
                ball.setDY(ball.getDY()*-1);
                isDead = true;
            }
        }else
        if(r > 0){
            xp1 = Math.sqrt(r) + ball.getXC();
            xp2 = -Math.sqrt(r) + ball.getXC();
            if( (xp1>=sideX1 && xp1<= sideX2 ) ||
                (xp2>=sideX1 && xp2<= sideX2 ) ){
                ball.setDY(ball.getDY()*-1);
                isDead = true;
            }       
        }//else{
        //    System.out.println("IMAGINARY NUMBERS!!!!!!!");
        //}
    }
    private void crashDown(Ball ball){
        int r = (int)Math.pow(ball.getRadio(),2)-(int)Math.pow(sideY2-ball.getYC(),2);
        double xp;
        double xp1;
        double xp2;
        if(r == 0){
            xp = ball.getXC();
            if(xp>=sideX1 && xp<= sideX2 ){
                ball.setDY(ball.getDY()*-1);
                isDead = true;
            }
        }else
        if(r > 0){
            xp1 = Math.sqrt(r) + ball.getXC();
            xp2 = -Math.sqrt(r) + ball.getXC();
            if( (xp1>=sideX1 && xp1<= sideX2 ) ||
                (xp2>=sideX1 && xp2<= sideX2 ) ){
                ball.setDY(ball.getDY()*-1);
                isDead = true;
            }       
        }//else{
           // System.out.println("IMAGINARY NUMBERS!!!!!!!");
        //}
        
    }
    private void crashRight(Ball ball){
        int r = (int)Math.pow(ball.getRadio(),2)-(int)Math.pow(sideX2-ball.getXC(),2);
        double yp;
        double yp1;
        double yp2;
        if(r == 0){
            yp = ball.getYC();
            if(yp>=sideY1 && yp<= sideY2 ){
                ball.setDX(ball.getDX()*-1);
                isDead = true;
            }
        }else
        if(r > 0){
            yp1 = Math.sqrt(r) + ball.getYC();
            yp2 = -Math.sqrt(r) + ball.getYC();
            if( (yp1>=sideY1 && yp1<= sideY2 ) ||
                (yp2>=sideY1 && yp2<= sideY2 ) ){
                ball.setDY(ball.getDX()*-1);
                isDead = true;
            }       
        }//else{
            //System.out.println("IMAGINARY NUMBERS!!!!!!!");
       // }
    }
    private void crashLeft(Ball ball){
        int r = (int)Math.pow(ball.getRadio(),2)-(int)Math.pow(sideX1-ball.getXC(),2);
        double yp;
        double yp1;
        double yp2;
        if(r == 0){
            yp = ball.getYC();
            if(yp>=sideY1 && yp<= sideY2 ){
                ball.setDX(ball.getDX()*-1);
                isDead = true;
            }
        }else
        if(r > 0){
            yp1 = Math.sqrt(r) + ball.getYC();
            yp2 = -Math.sqrt(r) + ball.getYC();
            if( (yp1>=sideY1 && yp1<= sideY2 ) ||
                (yp2>=sideY1 && yp2<= sideY2 ) ){
                ball.setDY(ball.getDX()*-1);
                isDead = true;
            }       
        }else{
            System.out.println("IMAGINARY NUMBERS!!!!!!!");
        }
    }
    
    private int getSqrt(Ball ball){
        int r = -1;
        r = (int)Math.pow(ball.getRadio(),2)-(int)Math.pow(sideY1-ball.getYC(),2);
        return r;
    }
    
    
    
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
