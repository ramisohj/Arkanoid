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
public class Wall {
    
    private ArrayList<ArrayList<Block>> blockList;
    private Sound sound;
    public Wall(){
        blockList = new ArrayList<ArrayList<Block>>();
        sound = new Sound();
    }
    
    
    public void paintBlockList(Graphics g){
        for(ArrayList<Block> lb : blockList){
            for(Block b: lb){
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
                        lb.remove(b);
                        sound.explosion();
                    }
                }
            }  
        } catch (Exception e) {
            System.out.println("ERROR IN THE KILL LIST ");
        }
    }
    
    public void fillBockList(){
        ArrayList<Block> l1 = fillRow(5, 300, 100, 200, 20, Color.BLUE);
        ArrayList<Block> l2 = fillRow(5, 200, 130, 200, 20, Color.BLUE);
        ArrayList<Block> l3 = fillRow(5, 300, 160, 200, 20, Color.BLUE);
        ArrayList<Block> l4 = fillRow(5, 200, 190, 200, 20, Color.BLUE);
        ArrayList<Block> l5 = fillRow(5, 300, 220, 200, 20, Color.BLUE);
        ArrayList<Block> l6 = fillRow(5, 200, 250, 200, 20, Color.BLUE);
        ArrayList<Block> l7 = fillRow(5, 300, 280, 200, 20, Color.BLUE);
        ArrayList<Block> l8 = fillRow(5, 200, 310, 200, 20, Color.BLUE);
        
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
            
            if(i%3 ==0 ){
                Block block = new Block(xo, yo, w, h, Color.WHITE);
                xo += w+2;
                block.setForEver();
                lb.add(block);
            }else{
                  
                Block block = new Block(xo, yo, w, h, c);
                xo += w;
                lb.add(block);
            }
            
        }
        return lb;
    }
}
