/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.Color;
import java.awt.Font;
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
 * @author R@MiSoHj
 */
public class Main extends JFrame{
    
    private Ball ball = new Ball();
   
    
    private Wall wall = new Wall();
    
    private Ship ship;
    private Image imageDB;
    private Graphics graphDB;
    
    //final width = 1366 ;
    //final height = 744 ;
    private final int width = 1366;
    private final int height = 744;
    private Sound sound;

    public void init() {
        //final width = 1366 ;
        //final height = 744 ;
        this.setTitle("ARKANOID");
        this.setSize(width, height);
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
        imageDB = new BufferedImage(getWidth()-300, getHeight(), BufferedImage.TYPE_INT_RGB);
        graphDB = imageDB.getGraphics();
        //sound = new Sound();
        run();
    }
    public void paint(Graphics g){
        g.drawImage(imageDB,0,0,this);
    } 
    int min;
    public void run() {
        try{
        ball = new Ball(10, 500, 500,-1,-1,Color.white);
        ship = new Ship(100, 500, 120, 30, Color.cyan);
        
        wall.fillBockList();
        wall.blockListUpdatepoints();
        //sound.soundtrack();
        while(true){
            System.out.println(min);
            playMusic();
            try {
            //System.out.println("\n");    
            
            graphDB.clearRect(0,0, getWidth(), getHeight());
            //CRASHES
            menu();
            
            ship.shipCrash(ball);
            
            wall.blockListCrashes(ball);
            
            wall.blockListKill(ship);
            ball.wayCalculator();
            
            ship.move();
            ship.updateGuns();        
            ship.paintAllGuns(graphDB);
            ship.updatePoints();//save ship points
            
            //PAINT ELEMENTS
            ship.paintShip(graphDB);
            ball.paintBall(graphDB,ball.getRadio(), ball.getXC(), ball.getYC());  
            wall.paintBlockList(graphDB);
            //--wall.painBlockMaze(graphDB);
            
            //efects
            wall.boomEfect(graphDB);
            wall.boomListUpdate();
            
            repaint();
            sleep(2);
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
    private void playMusic(){
        if(min >=11000){
            sound.soundtrack();
            min = 0;
        }
        min++;
    }
    
    public void menu(){
        Geometry.Line.midPointLine(0,47,width, 47, graphDB, Color.ORANGE);
        Geometry.Line.midPointLine(0,697,width, 697, graphDB, Color.ORANGE);
    }
    private void borderCrash(Ball ball){
        if(ball.getYC()<=57 && ball.getDY()<0){
            ball.setDY(ball.getDY()*-1);
            ball.setAllFirst();
            sound.crash();
        }
        if(ball.getYC() >= (height-57) && ball.getDY()>0){
            ball.setDY(ball.getDY()*-1);
            ball.setAllFirst();
            sound.crash();
        }
        if(ball.getXC() <= 8 && ball.getDX()<0){
            ball.setDX(ball.getDX()*-1);
            ball.setAllFirst();
            sound.crash();
        }
        if(ball.getXC() >=(width -8) && ball.getDX()>0){
            ball.setDX(ball.getDX()*-1);
            ball.setAllFirst();
            sound.crash();
        }       
    }
}
