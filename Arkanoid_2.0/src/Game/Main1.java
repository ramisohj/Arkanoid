/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

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
    private Image imageDB;
    private Graphics graphDB;
    

    public static void main(String args[]) {
        Main1 m = new Main1();
        m.init();   
    }

    public void init() {
        this.setTitle("ARKANOID");
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
     
    public void run() {
        
        try{
        ball = new Ball(10, 200, 200,1,1,Color.CYAN);
        ship = new Ship(100, 500, 100, 20, Color.red);
        
        
        while(true){
            try {
            graphDB.clearRect(0, 0, getWidth(), getHeight());
            ball.calcWay();

            ship.move();
            ship.updateGuns();
            borderCrash();
            shipCrash();
            ship.paintAllGuns(graphDB);
            ship.updatePoints();
            
            
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
            ball.setDY(ball.getDY()*-1);
        }
        if(ball.getYC() >= 600){
            ball.setDY(ball.getDY()*-1);
        }
        if(ball.getXC() <= 0){
            ball.setDX(ball.getDX()*-1);
        }
        if(ball.getXC() >=600){
            ball.setDX(ball.getDX()*-1);
        }       
    }
   
    private void shipCrash(){
        ArrayList<Integer> lr = ship.getPointListUp(ball.getRadio(),ball.getXC(), ball.getYC());
        int r2 = (int)Math.pow(ball.getRadio(),2);
        
        if(lr.contains(r2) && ball.getDY()>=0){
            if(ball.getDX()>=0){
                ball.setDY(ball.getDY()*-1);
            }else{
                ball.setDY(ball.getDY()*-1);
            }
        }   
    }   
}
