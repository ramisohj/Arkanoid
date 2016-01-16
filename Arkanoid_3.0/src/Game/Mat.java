/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

/**
 *
 * @author usuario
 */
public class Mat {
    
    public static void main(String args[]){
        Mat m =  new Mat();
        m.init();
    }
    
    public void init(){
        float x = 1;
        float y = 2;
        float xc = 2; 
        float yc = 23;
        float r = 20;
        
        float rx1 = (-(float)Math.sqrt(r*r - (float)Math.pow(y - yc, 2)))+xc;
        float rx2 = ((float)Math.sqrt(r*r - (float)Math.pow(y - yc, 2)))+xc;
        
        float ry1 = (-(float)Math.sqrt(r*r - (float)Math.pow(x - xc, 2)))+yc;
        float ry2 = ((float)Math.sqrt(r*r - (float)Math.pow(x - xc, 2)))+yc;
        
        System.out.println("rx1 = "+rx1+"\nrx2 = "+rx2+"\n\n");
        System.out.println("ry1 = "+ry1+"\nry2 = "+ry2+"\n");
        
    }
}
