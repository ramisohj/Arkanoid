/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 *
 * @author R@MiSoHj
 */
public class Ship extends Block{

    
    private Sound sound;
    private ArrayList<Gun> gunList;
    private ArrayDeque<Integer> movNave;
    
    
    public Ship(int xo, int yo, int w, int h, Color c) {
        super(xo, yo, w, h, c);
        gunList = new ArrayList<Gun>();
        movNave = new ArrayDeque<Integer>();
        sound = new Sound();
    }
    
    public void addMove(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            movNave.push(e.getKeyCode());
        }else
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            movNave.push(e.getKeyCode());
        }else
        if(e.getKeyCode() == KeyEvent.VK_UP){
            movNave.push(e.getKeyCode());
        }else
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            movNave.push(e.getKeyCode());
        }else
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            movNave.push(e.getKeyCode());
        }
    }
    
    public void move(){    
        if(!movNave.isEmpty()){
            //s.move();
            //System.out.println("\n");
            int key = movNave.poll();
            if(key == KeyEvent.VK_RIGHT){
                setX(getX()+15);
                //System.out.println("-------------------------------RIGHT-------------------------");
            }else
            if(key == KeyEvent.VK_LEFT){             
                setX(getX()-15);
                //System.out.println("-------------------------------LEFT-------------------------");
            }else   
            if(key == KeyEvent.VK_UP){
                setY(getY()-15);
                //System.out.println("-------------------------------UP-------------------------");
            }else
            if(key == KeyEvent.VK_DOWN){
                setY(getY()+15);
                //System.out.println("-------------------------------DOWN-------------------------");
            }else
            if(key == KeyEvent.VK_SPACE){
                atack(Color.red);
                //System.out.println("-------------------------------ATACK-------------------------");
            }
            }
    }

    public void atack(Color c){
       int xm = ((x2-x1)/2)+x1;
       int ym = y1;
       System.out.println("ATACK!!!!!!!!!!!!!!!!!!!!!!!");
       sound.shotGun();
       Gun g = new Gun(xm, ym, c);
       gunList.add(g);
    }
    
    public void paintAllGuns(Graphics g){
        
        for(Gun gun : gunList){
            gun.goUp();
        } 
        if(!gunList.isEmpty()){
            for(Gun gun : gunList){
                //System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!ATACK!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                gun.paintGun(g);
            }
        }
    }
    
    public void updateGuns(){
        try{
        int i = 0;
        //System.out.println("Nro guns: ..............."+gunList.size());
        for(Gun gun : gunList){
            if(gun.getYM()<=47){
                gunList.remove(gun);
                sound.explosion();
            }
            //System.out.println("Gun nro: "+i+";......................ym= "+gun.getYM()+"; xm= "+gun.getXM());  
            i++;
        }
        }catch(Exception e){
            System.out.println("error in the updateGuns!!!!");
        }
    }
    private void paintDavidStar(){
        
    }
    public ArrayList<Gun> getGunlist(){
        return gunList;
    }
    
    //             X1       X2      X3     X4
    //              | ______|_______|_______|
    //              |                       |
    //              |                       |
    //              |_______________________|
    //
    private int xn1;
    private int xn2;
    private int xn3;
    private int xn4;
    private int div;
    public void shipCrash( Ball ball){
         div = super.getWidht()/3;
         xn1 = super.getX();
         xn2 = xn1+div;
         xn3 = xn2+div;
         xn4 = xn3+div;

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
                
                if(xp>=xn1 && xp<xn2){
                    rightTopShip(ball);
                }else
                if(xp>=xn2 && xp<xn3){
                    midTopShip(ball);
                }else
                if(xp>=xn3 && xp<=xn4){
                    leftTopShip(ball);
                }
                
                //ball.setDY(ball.getDY()*-1);
               
            }
        }else
        if(r > 0){
            xp1 = Math.sqrt(r) + ball.getXC();
            xp2 = -Math.sqrt(r) + ball.getXC();
            if( (xp1>=sideX1 && xp1<= sideX2 ) ||
                (xp2>=sideX1 && xp2<= sideX2 ) ){
                 
                if((xp1>=xn1 && xp1<xn2) || (xp2>=xn1 && xp2<xn2)){
                    rightTopShip(ball);
                }else
                if((xp1>=xn2 && xp1<xn3) || (xp2>=xn2 && xp2<xn3)){
                    midTopShip(ball);
                }else
                if((xp1>=xn3 && xp1<=xn4) || (xp2>=xn2 && xp2<xn3)){
                    leftTopShip(ball);
                }
                //ball.setDY(ball.getDY()*-1);
               
            }       
        }//else{
        //    System.out.println("IMAGINARY NUMBERS!!!!!!!");
        //}
    }
    private void leftTopShip(Ball ball){
        if(ball.getDX()>=0){
            ball.setDY(-1);
            ball.setDX(2);
        }else{
            ball.setDY(-1);
            ball.setDX(-2);
        }
        ball.setAllFirst();
        sound.crash();
    }
    private void midTopShip(Ball ball){
        if(ball.getDX()>=0){
            ball.setDY(-1);
            ball.setDX(1);
        }else{
            ball.setDY(-1);
            ball.setDX(-1);
        }
        ball.setAllFirst();
        sound.crash();
    }
    private void rightTopShip(Ball ball){
        if(ball.getDX()>=0){
            ball.setDY(-1);
            ball.setDX(2);
        }else{
            ball.setDY(-1);
            ball.setDX(-2);
        }
        ball.setAllFirst();
        sound.crash();
    }
    private void crashDown(Ball ball){
        int r = (int)Math.pow(ball.getRadio(),2)-(int)Math.pow(sideY2-ball.getYC(),2);
        double xp;
        double xp1;
        double xp2;
        if(r == 0){
            xp = ball.getXC();
            if(xp>=sideX1 && xp<= sideX2 ){
                if(xp>=xn1 && xp<xn2){
                    rightBelowShip(ball);
                }else
                if(xp>=xn2 && xp<xn3){
                    midBelowShip(ball);
                }else
                if(xp>=xn3 && xp<=xn4){
                    leftBelowShip(ball);
                }
                
            }
        }else
        if(r > 0){
            xp1 = Math.sqrt(r) + ball.getXC();
            xp2 = -Math.sqrt(r) + ball.getXC();
            if( (xp1>=sideX1 && xp1<= sideX2 ) ||
                (xp2>=sideX1 && xp2<= sideX2 ) ){
                if((xp1>=xn1 && xp1<xn2) || (xp2>=xn1 && xp2<xn2)){
                    rightBelowShip(ball);
                }else
                if((xp1>=xn2 && xp1<xn3) || (xp2>=xn2 && xp2<xn3)){
                    midBelowShip(ball);
                }else
                if((xp1>=xn3 && xp1<=xn4) || (xp2>=xn2 && xp2<xn3)){
                    leftBelowShip(ball);
                }
                 
            }       
        }//else{
           // System.out.println("IMAGINARY NUMBERS!!!!!!!");
        //}
        
    }
    private void leftBelowShip(Ball ball){
        if(ball.getDX()>=0){
            ball.setDY(1);
            ball.setDX(2);
        }else{
            ball.setDY(1);
            ball.setDX(-2);
        }
        ball.setAllFirst();
        sound.crash();
    }
    private void midBelowShip(Ball ball){
        if(ball.getDX()>=0){
            ball.setDY(1);
            ball.setDX(1);
        }else{
            ball.setDY(1);
            ball.setDX(-1);
        }
        ball.setAllFirst();
        sound.crash();
    }
    private void rightBelowShip(Ball ball){
        if(ball.getDX()>=0){
            ball.setDY(1);
            ball.setDX(2);
        }else{
            ball.setDY(1);
            ball.setDX(-2);
        }
        ball.setAllFirst();
        sound.crash();
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
            }       
        }else{
            //System.out.println("IMAGINARY NUMBERS!!!!!!!");
        }         
    }
}