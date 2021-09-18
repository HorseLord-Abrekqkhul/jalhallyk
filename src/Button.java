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
   

    //On calcule alors la position du texte, et le tour est joué
  }

  public void mouseClicked(MouseEvent event) {
    //Inutile d'utiliser cette méthode ici       
  }

  public void mouseEntered(MouseEvent event) {    
    //Nous changeons le fond de notre image pour le jaune lors du survol, avec le fichier fondBoutonHover.png
    try {
      img = ImageIO.read(new File("2.png"));   
    } catch (IOException e) {
      e.printStackTrace();
    }    
  }

  public void mouseExited(MouseEvent event) {
    //Nous changeons le fond de notre image pour le vert lorsque nous quittons le bouton, avec le fichier fondBouton.png
    try {
      img = ImageIO.read(new File("1.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }    
  }

  public void mousePressed(MouseEvent event) {
    //Nous changeons le fond de notre image pour le jaune lors du clic gauche, avec le fichier fondBoutonClic.png
    try {
      img = ImageIO.read(new File("fondBoutonClic.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }    
  }

  public void mouseReleased(MouseEvent event) {
    //Nous changeons le fond de notre image pour l'orange lorsque nous relâchons le clic avec le fichier fondBoutonHover.png si la souris est toujours sur le bouton
    if((event.getY() > 0 && event.getY() < this.getHeight()) && (event.getX() > 0 && event.getX() < this.getWidth())){
      try {
        img = ImageIO.read(new File("1.png"));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    //Si on se trouve à l'extérieur, on dessine le fond par défaut
    else{
      try {
        img = ImageIO.read(new File("1.png")); 
      } catch (IOException e) {
        e.printStackTrace();
      }
    }   
  }   
}