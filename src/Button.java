import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException; 
import javax.imageio.ImageIO;
import javax.swing.JButton;

public class Button extends JButton implements MouseListener{
  private Image img;

  public Button(){
    super();
    try {
      img = ImageIO.read(new File("res/1.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    this.addMouseListener(this);
  }

  public void paintComponent(Graphics g){
    Graphics2D g2d = (Graphics2D)g;
    g2d.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
  }

  public void mouseClicked(MouseEvent event) {
  }

  public void mouseEntered(MouseEvent event) {    //change l image du bouton (surbrillance ou quoi
    try {
      img = ImageIO.read(new File("2.png"));   
    } catch (IOException e) {
      e.printStackTrace();
    }    
  }

  public void mouseExited(MouseEvent event) { // remet l image de base
    try {
      img = ImageIO.read(new File("1.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }    
  }

  public void mousePressed(MouseEvent event) { // jcrois qu on pourrais faire le action listener directement ici, a voir
    try {
      img = ImageIO.read(new File("fondBoutonClic.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }    
  }

 // public void mouseReleased(MouseEvent event) {
 /*

     if((event.getY() > 0 && event.getY() < this.getHeight()) && (event.getX() > 0 && event.getX() < this.getWidth())){

      try {
        img = ImageIO.read(new File("1.png"));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    else{
      try {
        img = ImageIO.read(new File("1.png")); 
      } catch (IOException e) {
        e.printStackTrace();
      }
    }   
  }  
  */

}