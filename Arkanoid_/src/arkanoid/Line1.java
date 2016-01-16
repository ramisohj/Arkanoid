/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package arkanoid;

/**
 *
 * @author Ramisohj
 */
public class Line1 {
    
    int dx;
    int dy;
    int dE;
    int dNE;
    int d;
    int x;
    int y;
    
    public Line1(int x0, int y0, int x1, int y1, int color){
        dx = x1-x0;
        dy = y1 -y0;
        d = 2+dy-dx;
        x = x0;
        y = y0;
        
    }
}
