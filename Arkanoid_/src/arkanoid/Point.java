/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arkanoid;
/**
 *
 * @author R@misohj
 */
public class Point {
    
    private int x;
    private int y;
    
    public Point(int x0, int y0) {
        x = x0;
        y = y0;
    }

    public void setX(int xn) {
        x = xn;
    }
    public void setY(int yn){
        y = yn;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    
}
