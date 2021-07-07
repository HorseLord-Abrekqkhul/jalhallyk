import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;



public class Panel extends JPanel{
	public int x,y,x2,y2,z,x3,y3;
	public Image image,image2,image3;
	
	public Panel() {
		x = 0;   
		y = 0;
	}
	
    public Panel(String filename,int PosX, int PosY,String filename2,int PosX2,int PosY2) {
		x = PosX;   
		y = PosY;
		x2 = PosX2;
		y2 = PosY2;
    	image = Toolkit.getDefaultToolkit().createImage(filename);
    	image2 = Toolkit.getDefaultToolkit().createImage(filename2);
    	image3 = Toolkit.getDefaultToolkit().createImage("res/void.png");
    	/*
        try { image = ImageIO.read(new File(filename)); }
        catch(IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not open file: " + filename);
        }
        if (image == null)
            throw new RuntimeException("Invalid image file: " + filename);
            */
    }
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//g.drawRect(x, 300, 20, 40);

		g.drawImage(image2,x2,y2, null);
		g.drawImage(image3,x3,y3, null);
		g.drawImage(image, x, y+30, x+30, y, z, 30, z+30 , 0, null);
		//g.drawImage(image,x,y, null);

		
	}

}
