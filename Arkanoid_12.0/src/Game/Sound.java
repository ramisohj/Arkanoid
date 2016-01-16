/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import javazoom.jl.player.Player;

/**
 *
 * @author usuario
 */
public class Sound { 
    
    InputStream in;
    String music; 
    FileInputStream fis;
    BufferedInputStream bis;
    Player player;
       
    public void move(){                              
        play("D:/sounds/move.mp3");
    }
    public void shotGun(){                                 
        play("D:/sounds/shot.mp3");
    }
    public void explosion(){             
        play("D:/sounds/explosion.mp3");
    }
    public void crash(){
        play("D:/sounds/crash.mp3");
    }
    public void soundtrack(){
        play("D:/sounds/soundTrack2.mp3");
    }
    private void play(String dir){             
        music =dir;                      
        try {
        fis = new FileInputStream(music);
        bis = new BufferedInputStream(fis);
        player = new Player(bis);     
        new Thread() {
            public void run() {
                try { player.play(); }
                catch (Exception e) { System.out.println(e); }
            }
        }.start();        
        } catch (Exception e) {
            System.out.println(" music error!!!!!!!!!!!");
        }
    }
    
}
