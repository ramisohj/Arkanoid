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
 * @author R@MiSoHj
 */
public class Main extends JFrame{
    
    private Ball ball = new Ball();
    private Ball b1 = new Ball();
    private Ball b2 = new Ball();
    private Ball b3 = new Ball();
    private Ball b4 = new Ball();
    
    
    private Wall wall = new Wall();
    
    private Ship ship;
    private Image imageDB;
    private Graphics graphDB;
    
    //final width = 1366 ;
    //final height = 744 ;
    private final int width = 1366;
    private final int height = 744;
    

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
        imageDB = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        graphDB = imageDB.getGraphics();
        run();
    }
    
    
    public void paint(Graphics g){
        g.drawImage(imageDB,0,0,this);
    }
     
    public void run() {
        
        try{
        ball = new Ball(50, 500, 500,-1,-1,Color.CYAN);
        b1 = new Ball(50, 50, 500,-1,4,Color.WHITE);
        b2 = new Ball(50, 50, 500,-1,2,Color.DARK_GRAY);
        b3 = new Ball(50, 50, 500,1,-6,Color.LIGHT_GRAY);
        b4 = new Ball(50, 50, 500,-1,-4,Color.BLUE);
        ship = new Ship(100, 500, 120, 20, Color.red);
        
        wall.fillBockList();
        wall.blockListUpdatepoints();
        
        while(true){
            try {
            System.out.println("\n");    
            
            
            
            graphDB.clearRect(0, 0, getWidth(), getHeight());
            Geometry.Line.midPointLine( 500, 500,800, 10, graphDB, Color.red);
            //CRASHES
            menu();
            borderCrash(ball);
            borderCrash(b1);
            borderCrash(b2);
            borderCrash(b3);
            borderCrash(b4);
            
            ship.shipCrash(ball);
            ship.shipCrash(b1);
            ship.shipCrash(b2);
            ship.shipCrash(b3);
            ship.shipCrash(b4);
            
            wall.blockListCrashes(ball);
            wall.blockListCrashes(b1);
            wall.blockListCrashes(b2);
            wall.blockListCrashes(b3);
            wall.blockListCrashes(b4);
            
            wall.blockListKill(ship);
            ball.wayCalculator();
            b1.wayCalculator();
            b2.wayCalculator();
            b3.wayCalculator();
            b4.wayCalculator();
            
            ship.move();
            ship.updateGuns();        
            ship.paintAllGuns(graphDB);
            ship.updatePoints();//save ship points
            
            //PAINT ELEMENTS
            ship.paintBlock(graphDB);
            ball.paintBall(graphDB,ball.getRadio(), ball.getXC(), ball.getYC());
            b1.paintBall(graphDB, b1.getRadio(), b1.getXC(), b1.getYC());
            b2.paintBall(graphDB, b2.getRadio(), b2.getXC(), b2.getYC());
            b3.paintBall(graphDB, b3.getRadio(), b3.getXC(), b3.getYC());
            b4.paintBall(graphDB, b4.getRadio(), b4.getXC(), b4.getYC());
            
            wall.paintBlockList(graphDB);
            
            repaint();
            //update(graphDB);
            
            
            System.out.println("xc: "+ball.getXC()+"; yc: "+ball.getYC()+"; dx: "+ball.getDX()+"; dy: "+ball.getDY()+"; m: "+ball.getM());       
            System.out.println("Visitados : " +ball.printFirst());
            //System.out.println(ball.printFirst());
            
            sleep(3);
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
    
    public void menu(){
        Geometry.Line.midPointLine(0,47,width, 47, graphDB, Color.ORANGE);
        Geometry.Line.midPointLine(0,697,width, 697, graphDB, Color.ORANGE);
    }
    private void borderCrash(Ball ball){
        if(ball.getYC()<=57 && ball.getDY()<0){
            ball.setDY(ball.getDY()*-1);
            ball.setAllFirst();
        }
        if(ball.getYC() >= (height-57) && ball.getDY()>0){
            ball.setDY(ball.getDY()*-1);
            ball.setAllFirst();
        }
        if(ball.getXC() <= 8 && ball.getDX()<0){
            ball.setDX(ball.getDX()*-1);
            ball.setAllFirst();
        }
        if(ball.getXC() >=(width -8) && ball.getDX()>0){
            ball.setDX(ball.getDX()*-1);
            ball.setAllFirst();
        }       
    }
}
