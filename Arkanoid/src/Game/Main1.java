/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Geometry.Frame3;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import static java.lang.Thread.sleep;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.swing.JFrame;

/**
 *
 * @author usuario
 */
public class Main1 extends JFrame{
    
    private Ball ball = new Ball();
    private Ship ship;
    
    
    //private Image m;
    
    private Image imageDB;
    private Graphics graphDB;
    
    
    
    
    public static void main(String args[]) {
        Main1 m = new Main1();
        m.init();
        
        
    }

    public void init() {
        
        
        
        this.setTitle("FRAME GRAFICACION.......");
        this.setSize(600, 600);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyPressed(KeyEvent e){
                super.keyPressed(e); 
                ship.addMove(e);
            }
            
        });    
        imageDB = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        graphDB = imageDB.getGraphics();
        run();
    }
    public void paint(Graphics g){
        g.drawImage(imageDB,0,0,this);
    }
    
    private int dx = 8;
    private int dy = 3;
    private int x = 200;
    private int y = 500;
    
    
    public void run() {
        
        try{
        ball = new Ball(10, 200, 200,Color.CYAN);

        ball.calcWay(dx,dy,x,y);
        
        ship = new Ship(100, 500, 100, 20, Color.red);
        
        
        while(true){
            try {
            graphDB.clearRect(0, 0, getWidth(), getHeight());
            ball.calcWay(ball.getDX(),ball.getDY(),ball.getXC(),ball.getYC());
            
            System.out.println("\n");
            
            ship.move();
            ship.updateGuns();
            borderCrash();
            shipCrash();
            ship.paintAllGuns(graphDB);
            ship.updatePoints();
            
            int x1 = 50;   
            int y1 = 50;
            
            
            
            ship.paintBlock(graphDB);
            ball.paintBall(graphDB,ball.getRadio(), ball.getXC(), ball.getYC());
     
            repaint();
        
            sleep(5);
            } catch (InterruptedException ex) {
                 System.out.println("there is a error  in the while.....!!!!");
            }
            
        }
        }catch(Exception e){
            System.out.println("there is a error!!!!");
        }     
    }
    
    @Override
    public void update(Graphics g){
        paint(g);
    }
    
    
    private void borderCrash(){
        
        if(ball.getYC()<=0){
            dy = dy * -1;
            ball.setDY(dy);
        }
        if(ball.getYC() >= 600){
            dy *= -1;
            ball.setDY(dy);
        }
        if(ball.getXC() <= 0){
            dx *=-1;
            ball.setDX(dx);
        }
        if(ball.getXC() >=600){
            dx *= -1;
            ball.setDX(dx);
        }       
    }
    
    
    
    private void shipCrash(){
        ArrayList<Integer> lr = ship.getPointListUp(ball.getRadio(),ball.getXC(), ball.getYC());
        int r2 = (int)Math.pow(ball.getRadio(),2);
        
        if(lr.contains(r2)){
            
        }
        
        if(ball.getDY()>=0){
            //System.out.println("IT'S GOING DOWN.....................................................");
        }else{
            //System.out.println("IT'S GOING UP........................................................");
        }
        
        if(lr.contains(r2) && ball.getDY()>=0){
            //System.out.println(lr.toString());
            //System.out.println("INSIDE OR CRASH !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            if(ball.getDX()>=0){
                dy *=-1;
                ball.setDY(dy);
            }else{
                dx *=1;
                dy *=-1;
                ball.setDX(dx);
                ball.setDY(dy);
            }
        }
        
    }
    

    
}
