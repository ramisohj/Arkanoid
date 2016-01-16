/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.Color;
import java.awt.Graphics;
import static java.lang.Thread.sleep;

/**
 *
 * @author R@MiSoHj
 */
public class Ball{
    
    private int radio;
    private int xc;
    private int yc;
    private int dx;
    private int dy;
    private int dStart;
    
    private double m;
    private Color c;
    
    private int de;
    private int dne;
    private int dn;
    private int dnw;
    private int dw;
    private int dsw;
    private int ds;
    private int dse;
    
    private boolean first[];
    public Ball(){
    }
    
    public Ball(int radio, int xc, int yc,int dx,int dy,Color c){
        this.radio = radio;
        this.xc = xc;
        this.yc = yc;
        this.dx = dx;
        this.dy = dy;
        this.c = c;
        
        first = new boolean [9];
        setAllFirst();
        printFirst();
    }
    
    public void paintBall(Graphics g,  int radio, int xc, int yc){
        Geometry.Circle.paintCircle(xc, yc, radio, g, c);
    }
    
    public int getRadio(){
        return radio;
    }
    public int getXC(){
        return xc;
    }
    public int getYC(){
        return yc;
    }
    public int getDX(){
        return dx;
    }
    public int getDY(){
        return dy;
    }
    public void setDX(int dx){
        this.dx = dx;
    }
    public void setDY(int dy){
        this.dy = dy;
    }
    public void setXC(int x){
        xc = x;
    }
    public void setYC(int y){
        yc =  y;
    }
    public double getM(){
        return m;
    }
    
    
 
    public void wayCalculator(){ 
        m = (double) dy/dx;
        
        if(dx>0 && dy>0){//primer cuadrante 
            if(m>=1){//2 octante
                o2a(first[2]);
            }else{//1 octante
                o1a(first[1]);
            }
        }else{
        if(dx>0 && dy<0){//4 cuadrante
            if(m <= -1){//7 octante
                o7a(first[7]);
            }else{
                o8a(first[8]);//8 octante
            }
        }else{
        if(dx<0 && dy<0){//3 cuadrante
            if(m >= 1){//6 octante
                o6a(first[6]);
            }else{
                o5a(first[5]);//5 octante
            }
        }else{
        if(dx<0 && dy>0){//2 cuadrante
            if(m<=-1){
                o3a(first[3]);//3 octante
            }else{
                o4a(first[4]);//4 octante
            }
        }
        }   
        }         
        }
    } 
    
    
    private void o1a(boolean f){
        System.out.println(".................1 Octant...............");
        
        if(f){
        first[1] = false;    
        dStart = 2*dy - dx;//dstart       
        dne = 2*(dy-dx);
        de = 2*dy;
        
        if(dStart <= 0){//E
            dStart += de;
            xc++;
            System.out.print("-----E-----");
        }else{//NE
            dStart += dne;
            xc++;
            yc++;
            System.out.print("-----NE-----");
        }
        }else{
            
        if(dStart <= 0){//E
            dStart += de;
            xc++;
            System.out.print("-----E-----");
        }else{//NE
            dStart += dne;
            xc++;
            yc++;
            System.out.print("-----NE-----");
        }
        }
    }
    
    private void o2a(boolean f){
        System.out.println(".................2 Octant...............");
        
        if(f){
            first[2] = false; 
        dStart = dy + (2*-dx);
        dn = 2*-dx;
        dne = 2*(dy-dx);
        
        if(dStart >= 0){//N
            System.out.print("-----N-----");
            dStart += dn;
            yc++;
        }else{//NE
            System.out.println("-----NE-----");
            dStart += dne;
            xc++;
            yc++;
        }
        }else{
            if(dStart >= 0){//N
            System.out.print("-----N-----");
            dStart += dn;
            yc++;
        }else{//NE
            System.out.print("-----NE-----");
            dStart += dne;
            xc++;
            yc++;
        }
        }
    }
    
    private void o3a(boolean f){
        System.out.println(".................3 Octant...............");
        if(f){
            first[3] = false; 
        dStart = -dy - (2*dx);
        dn = 2*(-dx);
        dnw = 2*(-dy-dx);
        
        if(dStart <= 0){//N
            System.out.print("-----N-----");
            dStart += dn;
            yc++;
        }else{//NW
            System.out.print("-----NW-----");
            dStart += dnw;
            xc--;
            yc++;
        }
        }else{
            if(dStart <= 0){//N
            System.out.print("-----N-----");
            dStart += dn;
            yc++;
        }else{//NW
           System.out.print("-----NW-----");
            dStart += dnw;
            xc--;
            yc++;
        }
        }
    }
    private void o4a(boolean f){
        System.out.println(".................4 Octant...............");
        if(f){
            first[4] = false; 
        dStart = -2*dy - dx;
        dnw = 2*(-dy-dx);
        dw = 2*-dy;
        
        if(dStart >= 0){//W
            dStart += dw;
            xc--;
            System.out.print("-----W-----");
        }else{//NW
            dStart += dnw;
            xc--;
            yc++;
            System.out.print("-----NW-----");
        }
        }else{
            if(dStart >= 0){//W
            dStart += dw;
            xc--;
            System.out.print("-----W-----");
        }else{//NW
            dStart += dnw;
            xc--;
            yc++;
            //System.out.println("-----NW-----");
        }
        }
    }
    private void o5a(boolean f){
        System.out.println(".................5 Octant...............");
        
        if(f){
            first[5] = false; 
        dStart = 2*-dy + dx;
        dsw = 2*(-dy+dx);
        dw = 2*-dy;
        
        if(dStart <= 0){//W
            System.out.print("-----W-----");
            dStart += dw;
            xc--;
        }else{//SW
            System.out.print("-----SW-----");
            dStart += dsw;
            xc--;
            yc--;
        }
        }else{
            if(dStart <= 0){//W
            System.out.print("-----W-----");
            dStart += dw;
            xc--;
        }else{//SW
            System.out.print("-----SW-----");
            dStart += dsw;
            xc--;
            yc--;
        }
        }
    }
    private void o6a(boolean f){
        System.out.println(".................6 Octant...............");
        
        if(f){
            first[6] = false; 
        dStart = -dy + (2*dx);
        ds = 2*dx;
        dsw = 2*(-dy+dx);
        
        if(dStart <= 0){//SW
            System.out.print("-----SW-----");
            dStart += dsw;
            xc--;
            yc--;
        }else{//S
            System.out.print("-----S-----");
            dStart += ds;
            yc--; ///REPAIR 
        }
        }else{
            if(dStart <= 0){//SW
            System.out.print("-----SW-----");
            dStart += dsw;
            xc--;
            yc--;
        }else{//S
            System.out.print("-----S-----");
            dStart += ds;
            yc--; ///REPAIR 
        }
        }
    }
    private void o7a(boolean f){
        System.out.println(".................7 Octant...............");
        if(f){
            first[7] = false; 
        dStart = dy + (2*dx);
        ds = 2*dx;
        dse = 2*(dy+dx);
        
        if(dStart >= 0){//SE
            System.out.print("-----SE-----");
            dStart += dse;
            xc++;
            yc--;
        }else{//S
            System.out.print("-----S-----");
            dStart += ds;
            yc--;
        }
        }else{
            if(dStart >= 0){//SE
            System.out.print("-----SE-----");
            dStart += dse;
            xc++;
            yc--;
        }else{//S
            System.out.print("-----S-----");
            dStart += ds;
            yc--;
        }
        }
    }
    private void o8a(boolean f){
        System.out.println(".................8 Octant...............");
        if(f){
            first[8] = false; 
        dStart = 2*dy + dx;
        dse = 2*(dy+dx);
        de = 2*dy;
        
        if(dStart >= 0){//E
            System.out.print("-----E-----");
            dStart += de;
            xc++;
        }else{//SE
            System.out.print("-----SE-----");
            dStart += dse;
            xc++;
            yc--;
        }
        }else{
            if(dStart >= 0){//E
            System.out.print("-----E-----");
            dStart += de;
            xc++;
        }else{//SE
            System.out.print("-----SE-----");
            dStart += dse;
            xc++;
            yc--;
        }
        }
    }    
    
    public void setAllFirst(){
        for(int i = 0; i<first.length;i++){
            first[i] = true;
        }
    }
    
    public boolean getFirst(int index){
        return first[index];
    }

    public String printFirst(){
        String ans = "";
        for(int i = 1; i<first.length;i++){
            ans += "; index= "+i+"->"+first[i]+"";
        }
        return ans;
    }
    
}
