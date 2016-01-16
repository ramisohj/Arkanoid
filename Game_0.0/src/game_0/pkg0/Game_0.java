/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_0.pkg0;

import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 * @author jhosi
 */
public class Game_0  extends JFrame{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Game_0 m = new Game_0();
        m.init();
        // TODO code application logic here
    }
    
    /**
     *
     */
    public void init(){
        
        this.setTitle("FRAME GRAFICACION.......");
        this.setSize(800,800);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter()    
        {public void windowClosing(WindowEvent e){System.exit(0);}});
        
    }
    
    public void paint(Graphics g){
        
    }
    
    
}
