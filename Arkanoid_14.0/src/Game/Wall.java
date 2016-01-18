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
public class Wall{
    
    private ArrayList<ArrayList<Block>> blockList;
    private ArrayList<Block> boomList;
    public int width;
    public int height;
    
    private Sound sound;
    public Wall(){
        blockList = new ArrayList<ArrayList<Block>>();
        boomList = new ArrayList<Block>();
        sound = new Sound();
    }
    
    
    public void paintBlockList(Graphics g){
        for(ArrayList<Block> lb : blockList){
            for(Block b: lb){
                b.paintSvastik(g);
                b.paintBlock(g);
                //System.out.println("   BLOCK PAINTED !!!!!!!!!!!!!!!!!!!!!");
            }
        }
    }
    
    //KILL BLOKCS WITH BALL CRASHES
    public void blockListCrashes(Ball ball){
        for(ArrayList<Block> lb : blockList){
            for(Block b: lb){
                b.blockCrash(ball);
                //System.out.println("   BLOCK CRASH  VERIFY   !!!!!!!!!!!!!!!!!!!!!");
            }
        }
    }
    public void blockListUpdatepoints(){
        for(ArrayList<Block> lb : blockList){
            for(Block b: lb){
                b.updatePoints();
                //System.out.println("   BLOCK UPDATE  VERIFY   !!!!!!!!!!!!!!!!!!!!!");
            }
        }        
    }
    public void boomEfect(Graphics g){
        for(Block b:boomList){
            b.boomEfect(g);
        }
    }
    public void boomListUpdate(){
        try {
            for(Block b:boomList){
                if(b.deadBoom){
                    boomList.remove(b);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    //KILL BLOCKS FROM LISTBLOCK  WITH SHIP GUN'S 
    public void blockListKill(Ship ship){
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
                            if(!b.getForEver()){
                                b.killBlock(); 
                            }
                            ship.getGunlist().remove(g);
                        }else
                        if((g.getYL() == below)&&(g.getXL()>=xlb && g.getXL()<=xrb)){
                            if(!b.getForEver()){
                                b.killBlock();
                            }
                            ship.getGunlist().remove(g);
                        }else
                        if((g.getYR() == below) && (g.getXR()>=xlb && g.getXR()<=xrb)){
                            if(!b.getForEver()){
                                b.killBlock();
                            }
                            ship.getGunlist().remove(g);
                        }  
                    }
                    if(b.isDead()){
                        boomList.add(b);
                        lb.remove(b);
                        //sound.explosion();
                    }
                }
            }  
        } catch (Exception e) {
            System.out.println("ERROR IN THE KILL LIST ");
        }
    }
    
    
    /*
    private int [][] maze  =   {{1,1,2,0,1,2,1,1,1,1},
                                {1,2,1,1,2,1,2,1,1,2},
                                {1,2,1,1,0,1,1,1,1,1},
                                {1,1,1,2,2,1,2,1,1,1},
                                {1,1,1,2,2,1,2,1,1,1}};
      */
    private int [][] maze  =   {{1,1,2,0,1,2,1,1},
                                {1,2,1,1,2,1,2,1},
                                {1,2,1,1,0,1,1,1},
                                {1,1,1,2,2,1,2,1},
                                {1,1,1,2,2,1,2,1},
                                {1,1,1,2,2,1,2,1},
                                {2,0,2,0,2,0,2,0},};
    
    
                        //                  sideY1
    int sideX1 = 0;         //   (xo,yo) _______________________
    int sideX2 = 0;         //          |                       |
    int sideY1 = 0;         //  sideX1  |                       |sideX2
    int sideY2 = 0;         //          |_______________________|
                        //                  sideY2
    
    
    public void fillBockList(){
        fillBlockMaze(100, 300, 100, 20);
    }
    
    public void fillBlockMaze(int x0, int y0, int w,int h){
        int row = maze.length;
        int col = maze[0].length;
        int xStart = x0;
        sideX1 = x0;
        sideY1 = y0;
        sideX2 = sideX1 + (w+2)*col+(w/2);
        sideY2 = sideY1 + (h+2)*row;
        for(int i = 1;i<=row;i++){
            ArrayList<Block> lb = new ArrayList<Block>();
            for(int j = 0;j<col;j++){
                Block b;
                int num = maze[i-1][j];
                if(num == 1){
                    b = new Block(x0, y0, w, h, Color.red);
                    lb.add(b);
                }else{
                if(num == 2){
                    b = new Block(x0, y0, w, h, Color.white);
                    b.setForEver();
                    lb.add(b);
                }else{
                    b = null;
                }    
                }
                x0+=w+2;
            } 
            blockList.add(lb); 
            y0+=h+2;
            if(i%2==0){
                x0 = xStart;
            }else{
                x0 = xStart+w/2;//go to right ---->
            }
        } 
    }
    
    
    
}
