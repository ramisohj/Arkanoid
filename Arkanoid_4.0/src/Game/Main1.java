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
    private ArrayList<ArrayList<Block>> blockList;
    
    

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
        ball = new Ball(10, 500, 500,1,-3,Color.CYAN);
        ship = new Ship(100, 500, 100, 20, Color.red);
        blockList = new ArrayList<ArrayList<Block>>();
        fillBockList();
        blockListUpdatepoints();
        
        while(true){
            try {
            System.out.println("\n");    

            graphDB.clearRect(0, 0, getWidth(), getHeight());
            
            //CRASHES
            borderCrash();
            ship.blockCrash(ball);
            blockListCrashes();
            blockListKill();
            ball.calcWay2();
 
            ship.move();
            ship.updateGuns();        
            ship.paintAllGuns(graphDB);
            ship.updatePoints();//save ship points
            
            //PAINT ELEMENTS
            ship.paintBlock(graphDB);
            ball.paintBall(graphDB,ball.getRadio(), ball.getXC(), ball.getYC());
            
            paintBlockList(graphDB);
            
            repaint();
        
            sleep(5);
            } catch (InterruptedException ex) {
                 System.out.println("there is a error  in the while.....!!!!");
            }
            
            //System.out.println("xc: "+ball.getXC()+"; yc: "+ball.getYC()+"; dx: "+ball.getDX()+"; dy: "+ball.getDY()+"; m: "+ball.getM());       
            //System.out.println(ball.printFirst());
            
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
        if(ball.getYC()<30 && ball.getDY()<0){
            ball.setDY(ball.getDY()*-1);
            ball.setAllFirst();
        }
        if(ball.getYC() >= 570 && ball.getDY()>0){
            ball.setDY(ball.getDY()*-1);
            ball.setAllFirst();
        }
        if(ball.getXC() <= 30 && ball.getDX()<0){
            ball.setDX(ball.getDX()*-1);
            ball.setAllFirst();
        }
        if(ball.getXC() >=570 && ball.getDX()>0){
            ball.setDX(ball.getDX()*-1);
            ball.setAllFirst();
        }       
    }
   
    private void paintBlockList(Graphics g){
        for(ArrayList<Block> lb : blockList){
            for(Block b: lb){
                b.paintBlock(g);
                //System.out.println("   BLOCK PAINTED !!!!!!!!!!!!!!!!!!!!!");
            }
        }
    }
    
    private void blockListCrashes(){
        for(ArrayList<Block> lb : blockList){
            for(Block b: lb){
                b.blockCrash(ball);
                //System.out.println("   BLOCK CRASH  VERIFY   !!!!!!!!!!!!!!!!!!!!!");
            }
        }
    }
    private void blockListUpdatepoints(){
        for(ArrayList<Block> lb : blockList){
            for(Block b: lb){
                b.updatePoints();
                //System.out.println("   BLOCK UPDATE  VERIFY   !!!!!!!!!!!!!!!!!!!!!");
            }
        }        
    }
    
    //KILL BLOCKS FROM LISTBLOCK 
    private void blockListKill(){
        try {
            
            ArrayList<Gun> gunList = ship.getGunlist();
            
            for(ArrayList<Block> lb : blockList){
                for(Block b: lb){
                    int ym;
                    int xm;
                    
                    int xlb;//left block
                    int xrb;//right block
                    int top;//top block
                    int below;//below block
                    
                    for(Gun g :gunList){
                        ym = g.getYM();
                        xm = g.getXM();
                        
                        xlb = b.sideX1;
                        xrb = b.sideX2;
                        top = b.sideY1;
                        below = b.sideY2;
                        
                        if((ym == below)&&(xm>=xlb&&xm<=xrb)){
                            b.killBlock();
                            ship.getGunlist().remove(g);
                        }else
                        if((g.getYL() == below)&&(g.getXL()>=xlb && g.getXL()<=xrb)){
                            b.killBlock();
                            ship.getGunlist().remove(g);
                        }else
                        if((g.getYR() == below) && (g.getXR()>=xlb && g.getXR()<=xrb)){
                            b.killBlock();
                            ship.getGunlist().remove(g);
                        }
                    }
                    if(b.isDead()){
                        lb.remove(b);
                    }
                }
            }  
        } catch (Exception e) {
            System.out.println("ERROR IN THE KILL LIST ");
        }
    }
    
    private void fillBockList(){
        ArrayList<Block> l1 = fillRow(8, 100, 100, 60, 15, Color.BLUE);
        ArrayList<Block> l2 = fillRow(8, 100, 120, 60, 15, Color.BLUE);
        ArrayList<Block> l3 = fillRow(8, 100, 140, 60, 15, Color.BLUE);
        ArrayList<Block> l4 = fillRow(8, 100, 160, 60, 15, Color.BLUE);
        ArrayList<Block> l5 = fillRow(8, 100, 180, 60, 15, Color.BLUE);
        ArrayList<Block> l6 = fillRow(8, 100, 200, 60, 15, Color.BLUE);
        ArrayList<Block> l7 = fillRow(8, 100, 220, 60, 15, Color.BLUE);
        ArrayList<Block> l8 = fillRow(8, 100, 240, 60, 15, Color.BLUE);
        
        blockList.add(l1);
        blockList.add(l2);
        blockList.add(l3);
        blockList.add(l4);
        blockList.add(l5);
        blockList.add(l6);
        blockList.add(l7);
        blockList.add(l8);
    }
    
    private ArrayList<Block> fillRow(int n, int xo, int yo,int w, int h, Color c){
        ArrayList<Block> lb = new ArrayList<Block>();
        
        for(int i = 0; i<n; i++){
            Block block = new Block(xo, yo, w, h, c);
            xo += w;
            lb.add(block);
        }
        return lb;
    }
}
