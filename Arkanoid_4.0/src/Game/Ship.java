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
 * @author usuario
 */
public class Ship extends Block{

    private ArrayList<Gun> gunList;
    private ArrayDeque<Integer> movNave;
    
    
    public Ship(int xo, int yo, int w, int h, Color c) {
        super(xo, yo, w, h, c);
        gunList = new ArrayList<Gun>();
        movNave = new ArrayDeque<Integer>();
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
            if(gun.getYM()<=0){
                gunList.remove(gun);
            }
            //System.out.println("Gun nro: "+i+";......................ym= "+gun.getYM()+"; xm= "+gun.getXM());  
            i++;
        }
        }catch(Exception e){
            System.out.println("error in the updateGuns!!!!");
        }
    }
    
    public ArrayList<Gun> getGunlist(){
        return gunList;
    }
    
    private void shipCrash( Ball ball){

        ArrayList<Integer> lr = getPointListUp(ball.getRadio(),ball.getXC(), ball.getYC());
        int r2 = (int)Math.pow(ball.getRadio(),2);
        
        if(lr.contains(r2) && ball.getDY()>=0){
            ball.setDY(ball.getDY()*-1);
            ball.setAllFirst();
        }   
    }         
}
