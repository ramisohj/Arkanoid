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
    private final int width = 1000;
    private final int height = 744;
    private Sound sound;
    
    
    Image imageMenu;
    Graphics gm ;

    public void init() {
        //final width = 1366 ;
        //final height = 744 ;
        this.setTitle("ARKANOID");
        this.setSize(width+300, height);
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
        imageDB = new BufferedImage(getWidth()+300, getHeight(), BufferedImage.TYPE_INT_RGB);
        graphDB = imageDB.getGraphics();

        sound = new Sound();
        run();
    }
    
    
    public void paint(Graphics g){
        g.drawImage(imageDB,0,0, this); 
    }
     
    int min;
    public void run() {
        try{
        ball = new Ball(10, 500, 660,-1,-1,Color.white);
        ship = new Ship(500, 685, 120, 30, Color.cyan);
        
        wall.fillBockList();
        wall.blockListUpdatepoints();
        //sound.soundtrack();
        
        margin();
        while(true){
            System.out.println(min);
            //playMusic();
            try {
            //System.out.println("\n");    
            //graphDB.fillRect(0,0, width, height);
            graphDB.clearRect(26,47, getWidth()-326, getHeight()-72);
            
            //CRASHES
            
            verifyCrashes();
            //borderCrash(ball);
            //ship.shipCrash(ball);
            //wall.blockListCrashes(ball);
            
            //UPDATE ELEMENTS
            wall.blockListKill(ship);
            ball.wayCalculator();
            wall.boomListUpdate();
            
            ship.move();
            ship.updateGuns();          
            ship.updatePoints();//save ship points
            
            //PAINT ELEMENTS
            ship.paintAllGuns(graphDB);
            ship.paintShip(graphDB);
            ball.paintBall(graphDB,ball.getRadio(), ball.getXC(), ball.getYC());  
            wall.paintBlockList(graphDB);
            //--wall.painBlockMaze(graphDB); 
            //efects
            wall.boomEfect(graphDB);
            
            
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
    private void verifyCrashes(){
        borderCrash(ball);
        
        //CRASHES TO THE SHIPBALL FALLING DOWN 
        if((ball.getYC()+ball.getRadio())>=ship.sideY1 && ball.getDY()>=0){
            ship.shipCrash(ball);
        }
        //CRASHES TO THE WALL  WITH BALL
        boolean cmpSideY2 = (ball.getYC()-ball.getRadio())<=wall.sideY2 && ball.getDY()<=0;
        boolean cmpSideY1 = (ball.getYC()+ball.getRadio())>=wall.sideY1 && ball.getDY()>=0;
        if(cmpSideY1 || cmpSideY2){
            wall.blockListCrashes(ball);
        }
    }
    private void playMusic(){
        if(min >=11000){
            sound.soundtrack();
            min = 0;
        }
        min++;
    }
    
    public void menu(){
        
        
    }
    public void margin(){
       graphDB.setColor(Color.blue);
       graphDB.fillRect(1000,0,1300,800);//Menu Block, right side 
       graphDB.fillRect(0,0,1000,46);//top
       graphDB.fillRect(0,719,1000,744);//below
       graphDB.fillRect(0,26,26,800);//left side 
       Geometry.Line.midPointLine(1000,0, 1000, 800,graphDB, Color.red);//right Side
       Geometry.Line.midPointLine(0,719, 1300, 719,graphDB, Color.red);//below
       Geometry.Line.midPointLine(0,46, 1300, 46,graphDB, Color.red);//top
       Geometry.Line.midPointLine(25,0,25,800,graphDB, Color.red);//leftSide
   
    
    
       Geometry.Line.midPointLine(wall.sideX1, 0, wall.sideX1,800, graphDB, Color.white);
       Geometry.Line.midPointLine(0,wall.sideY1,1300,wall.sideY1, graphDB, Color.white);
       Geometry.Line.midPointLine(wall.sideX2, 0, wall.sideX2,800, graphDB, Color.white);
       Geometry.Line.midPointLine(0,wall.sideY2,1300,wall.sideY2, graphDB, Color.white);
    
    }
    private void borderCrash(Ball ball){
        if(ball.getYC()<=57 && ball.getDY()<0){
            ball.setDY(ball.getDY()*-1);
            ball.setAllFirst();
            //sound.crash();
        }
        if(ball.getYC() >= (height-36) && ball.getDY()>0){
            ball.setDY(ball.getDY()*-1);
            ball.setAllFirst();
            //sound.crash();
        }
        if(ball.getXC() <= 36 && ball.getDX()<0){
            ball.setDX(ball.getDX()*-1);
            ball.setAllFirst();
            //sound.crash();
        }
        if(ball.getXC() >=(width -11) && ball.getDX()>0){
            ball.setDX(ball.getDX()*-1);
            ball.setAllFirst();
            //sound.crash();
        }       
    }
}
