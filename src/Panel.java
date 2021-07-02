import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;



public class Panel extends JPanel{
	public int x,y;
	public Image image;
	
	public Panel() {
		x = 0;   
		y = 0;
	}
	
    public Panel(String filename,int PosX, int PosY) {
		x = PosX;   
		y = PosY;
    	image = Toolkit.getDefaultToolkit().createImage(filename);
    	
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
		g.drawImage(image,x,y, null);
	
	}

}
