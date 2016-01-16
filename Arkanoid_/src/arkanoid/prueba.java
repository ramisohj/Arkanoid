package arkanoid;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;


 class MiCanvas extends JFrame
{
   // Llama directamente a paint(), evitando el borrado del componente
     
     public static void main(String args []){
        MiCanvas m = new MiCanvas();
        m.init();
     }
  
     
     public void init(){
         
        this.setTitle("Other");
        this.setSize(500, 500);
        this.setResizable(true);
        //this.repaint();
        this.setVisible(true);
     
     }
     
     
    @Override
   public void update (Graphics g){
      paint (g);
   }

    @Override
   public void paint (Graphics g){
      // Se crea una imagen del mismo tamaño que el Canvas
      BufferedImage imagen = new BufferedImage (500, 500,1);
     
      // Se dibuja en la imagen
      imagen.getGraphics().drawLine(8, 8, 400, 400);
      // Se "pega" la imagen sobre el componente
      g.drawImage(imagen, 0, 0, this);
      
   }
}