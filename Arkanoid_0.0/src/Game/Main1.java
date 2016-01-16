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
    private Image m;
    
    private Image imageDB;
    private Graphics graphDB;
    
    private ArrayDeque<Integer> movNave;
    
    
    public static void main(String args[]) {
        Main1 m = new Main1();
        m.init();
        
        
    }

    public void init() {
        
        movNave = new ArrayDeque<Integer>();
        
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
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    movNave.push(e.getKeyCode());
                }
                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    movNave.push(e.getKeyCode());
                }
                //OPTIONAL
                if(e.getKeyCode() == KeyEvent.VK_UP){
                    movNave.push(e.getKeyCode());
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    movNave.push(e.getKeyCode());
                }
            }
            
        });
                
        
        imageDB = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        graphDB = imageDB.getGraphics();
        run();
    }
    
    
    
    
    public void paint(Graphics g){
        g.drawImage(imageDB,0,0,this);
    }
   
    Block b;
    
    public void run() {  
        ball = new Ball(20, 200, 50,-1,2,Color.CYAN);

        
        b = new Block(100, 100, 100, 20, Color.red);
        
        
        while(true){
            
            try{
            graphDB.clearRect(0, 0, getWidth(), getHeight());
            
            
            ball.calcWay();
            
            System.out.println("------------------------------------------------------------------------------------------------\n");
            
            borderCrash();    
            shipCrash();
             
            if(!movNave.isEmpty()){
                int key = movNave.poll();
                if(key == KeyEvent.VK_RIGHT){
                    System.out.println("PRESSIONED KEY RIGHT..................>>>>>>>");
                    b.setX(b.getX()+10);
                }
                if(key == KeyEvent.VK_LEFT){             
                    b.setX(b.getX()-10);
                    System.out.println("PRESSIONED KEY LEFT..................<<<<<<<<");
                }
                if(key == KeyEvent.VK_UP){
                    b.setY(b.getY()-10);
                }
                if(key == KeyEvent.VK_DOWN){
                    b.setY(b.getY()+10);
                }  
            }           
            b.paintBlock(graphDB);
            ball.paintBall(graphDB, ball.getRadio(), ball.getXC(), ball.getYC());
            repaint();
            sleep(3); 
        }catch(Exception e){
            System.out.println("there is a error!!!!");
        }
        }
    }
    
    @Override
    public void update(Graphics g)
    {
        paint(g);
    }
    
    
    private void borderCrash(){
        shipCrash();
        
        if(ball.getYC()<=35){
            ball.setDY(ball.getDY()*-1);
        }
        if(ball.getYC() >= 575){
            ball.setDY(ball.getDY()*-1);
        }
        if(ball.getXC() <=25){
            ball.setDX(ball.getDX()*-1);
        }
        if(ball.getXC() >=575){
            ball.setDX(ball.getDX()*-1);
        }      
        
        
    }
    
    private void shipCrash(){
        ArrayList<Integer> lr;
        lr = new ArrayList<Integer>();
        lr = b.getPointListUp(ball.getRadio(),ball.getXC(), ball.getYC());
        int r2 = (int)Math.pow(ball.getRadio(),2);
        boolean isCrash = lr.contains(r2);
        if(ball.getDY()>=0){
            System.out.println("IT'S GOING DOWN.................................SHIP_CRASH...........; isCrash: "+isCrash+"........."+"; dy = "+ball.getDY());
            System.out.println("xball: "+ball.getXC()+" ;yball: "+ball.getYC()+"; dy: "+ball.getDY()+"; dx: "+ball.getDX()+"; m: "+ball.getM());
        }else{
            System.out.println("IT'S GOING UP...................................SHIP_CRASH...........; isCrash: "+isCrash+".........."+"; dy = "+ball.getDY());
            System.out.println("xball: "+ball.getXC()+" ;yball: "+ball.getYC()+"; dy: "+ball.getDY()+"; dx: "+ball.getDX()+"; m: "+ball.getM());
        }
        
        if(lr.contains(r2) && ball.getDX()>0 && ball.getDY()<0){
            ball.setDY(ball.getDY()*-1);
            
        }else{   
        if(lr.contains(r2) && ball.getDX()<0 && ball.getDY()<0){
            ball.setDY(ball.getDY()*-1);
        }
        }
        r2 = 0;
    }    
}
