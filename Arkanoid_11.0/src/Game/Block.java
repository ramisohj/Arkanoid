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
 * @author R@MiSoHj
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
    private boolean isForEver;
    private Sound sound;
    
    public Block(int xo, int yo,int w, int h,Color c){
        xs = xo;
        ys = yo;
        width = w;
        height = h;
        this.c = c;
        sound = new Sound();
        
        isDead = false;
        isForEver = false;
    }
    
        //
        //  (XO,YO)_______________________________
        //      |                                  |
        //      |                                  |
        //      |                                  |
        //      |                                  |
        //      |_________________________________ |
    
    
    public void paintBlock(Graphics g){  
        paintBorder(g,1,c);
    }
    
    private void paintBorder(Graphics g,int size,Color c){
      
        for(int i = 0; i < size;i++){
            Geometry.Line.midPointLine(xs, ys+i, xs+width, ys+i, g, c);
        }
        for(int i=0;i<size;i++){
            Geometry.Line.midPointLine(xs, ys+height-i, xs+width, ys+height-i, g,c);
        }        
        for(int i=0;i<size;i++){
            Geometry.Line.midPointLine(xs+i, ys, xs+i, ys+height, g, c);
        }
        
        for(int i=0; i<size;i++){
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
    public void setForEver(){
        isForEver = true;
    }
    public boolean  getForEver(){
        return isForEver;
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
    public int getWidht(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    
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
    
    public void paintDavidStar(Graphics g,Color co){
        //int yk = (int)((sideY1*sideY1) - (sideY2*sideY2))+(*2(sideY1-sideY2));
        int radio = (this.getHeight()-2)/2;
        int ym = ((sideY2-sideY1)/2)+sideY1;
        int xm = ((sideX2-sideX1)/2)+sideX1;
        
        int xt = xm;
        int yt = ym + radio;
        int xb = xm;
        int yb = ym - radio;
        
        int yk = (int)((ym*ym)-(yt*yt))/((2*(ym-yt)));
        int xk = (int)Math.sqrt(radio*radio-((yk-ym)*(yk-ym)))+xm;
        int xd = xk-xm;//x delta
        int yd = yk-ym;//y delta
        
        int xp = xm + xd;
        int xn = xm - xd;
        int yp = ym + yd;
        int yn = ym - yd;
        
        int x1a = xp;
        int y1a = yp;
        int x2a = xn;
        int y2a = yp;
        int x3a = xn;
        int y3a = yn;
        int x4a = xp;
        int y4a = yn;
        
        //Geometry.Circle.midPointCircle(xm, ym, radio, g, Color.cyan);
        Geometry.Line.midPointLine(x2a, y2a, x1a, y1a, g, co);
        Geometry.Line.midPointLine(x2a, y2a, xb, yb, g, co);
        Geometry.Line.midPointLine(x1a, y1a, xb, yb, g, co);
        Geometry.Line.midPointLine(x3a, y3a, x4a, y4a, g, co);
        Geometry.Line.midPointLine(x3a, y3a, xt, yt, g, co);
        Geometry.Line.midPointLine(x4a, y4a, xt, yt, g, co);
    }
    
    public void paintSvastik(Graphics g){
        //int yk = (int)((sideY1*sideY1) - (sideY2*sideY2))+(*2(sideY1-sideY2));
        int radio = (this.getHeight()-4)/2;
        int r2 = radio/2;
        int ym = ((sideY2-sideY1)/2)+sideY1;
        int xm = ((sideX2-sideX1)/2)+sideX1;
        
        int radioCir = (this.getHeight()-2)/2;
        Geometry.Circle.midPointCircle(xm, ym, radioCir, g,Color.white);
        
        int xt = xm;
        int yt = ym + radio;
        
        int xb = xm;
        int yb = ym - radio;
        
        int xr = xm+radio;
        int yr = ym;
        
        int xl = xm-radio;
        int yl = ym;
        
        int x1a = xm+r2;
        int y1a = ym+r2;
        int x2a = xm-r2;
        int y2a = ym+r2;
        int x3a = xm-r2;
        int y3a = ym-r2;
        int x4a = xm+r2;
        int y4a = ym-r2;
        
        //Geometry.Circle.midPointCircle(xm, ym, radio, g, Color.cyan);
        Geometry.Line.midPointLine(x1a, y1a, xr, yr, g, Color.red);
        Geometry.Line.midPointLine(x2a, y2a, xt, yt, g, Color.red); 
        Geometry.Line.midPointLine(x3a, y3a, xl, yl, g, Color.red);
        Geometry.Line.midPointLine(x4a, y4a, xb, yb, g, Color.red);
        
        Geometry.Line.midPointLine(x1a, y1a, x3a, y3a, g, Color.red);
        Geometry.Line.midPointLine(x2a, y2a, x4a, y4a, g, Color.red);        
    }
    
    int boomlife = 0;
    boolean deadBoom = false;
    public void boomEfect(Graphics g){

        if(boomlife>=60){
            deadBoom = true;
        }else{
            if(boomlife%5==0){
                for(int y = sideY1; y<=sideY2;y+=5){
                    Geometry.Line.midPointLine(sideX1, y, sideX2, y,g,Color.cyan);
                }
            }
            boomlife++;
        }    
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
        //crashCorner(ball,x1,y1,x2,y2);
        if(ball.getDX()>=0){
            crashLeft(ball);
        }else{
            crashRight(ball);
        }
    }
    //DOWN TO TOP
    private void crashDownToTop(Ball ball){
        crashDown(ball);
        //crashCorner(ball,x3,y3,x4,y4);
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
                ball.setDY(ball.getDY()*-1);//
                ball.setAllFirst();
                sound.crash();
                if(!isForEver){
                    isDead = true;
                } 
            }
        }else
        if(r > 0){
            xp1 = Math.sqrt(r) + ball.getXC();
            xp2 = -Math.sqrt(r) + ball.getXC();
            if( (xp1>=sideX1 && xp1<= sideX2 ) ||
                (xp2>=sideX1 && xp2<= sideX2 ) ){
                ball.setDY(ball.getDY()*-1);
                ball.setAllFirst();
                sound.crash();
                if(!isForEver){
                    isDead = true;
                } 
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
                ball.setAllFirst();
                sound.crash();
                if(!isForEver){
                    isDead = true;
                } 
            }
        }else
        if(r > 0){
            xp1 = Math.sqrt(r) + ball.getXC();
            xp2 = -Math.sqrt(r) + ball.getXC();
            if( (xp1>=sideX1 && xp1<= sideX2 ) ||
                (xp2>=sideX1 && xp2<= sideX2 ) ){
                ball.setDY(ball.getDY()*-1);
                ball.setAllFirst();
                sound.crash();
                if(!isForEver){
                    isDead = true;
                } 
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
                ball.setAllFirst();
                sound.crash();
                if(!isForEver){
                    isDead = true;
                } 
            }
        }else
        if(r > 0){
            yp1 = Math.sqrt(r) + ball.getYC();
            yp2 = -Math.sqrt(r) + ball.getYC();
            if( (yp1>=sideY1 && yp1<= sideY2 ) ||
                (yp2>=sideY1 && yp2<= sideY2 ) ){
                ball.setDX(ball.getDX()*-1);
                ball.setAllFirst();
                sound.crash();
                if(!isForEver){
                    isDead = true;
                } 
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
                ball.setAllFirst();
                sound.crash();
                if(!isForEver){
                    isDead = true;
                } 
            }
        }else
        if(r > 0){
            yp1 = Math.sqrt(r) + ball.getYC();
            yp2 = -Math.sqrt(r) + ball.getYC();
            if( (yp1>=sideY1 && yp1<= sideY2 ) ||
                (yp2>=sideY1 && yp2<= sideY2 ) ){
                ball.setDX(ball.getDX()*-1);
                ball.setAllFirst();
                sound.crash();
                if(!isForEver){
                    isDead = true;
                } 
            }       
        }else{
            //System.out.println("IMAGINARY NUMBERS!!!!!!!");
        }
    }
}
