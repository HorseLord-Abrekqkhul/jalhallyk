import java.awt.Image;
import java.awt.Toolkit;
import java.util.List;
import java.util.Random;


public class Jar extends Decor {
	
	Image heart = Toolkit.getDefaultToolkit().getImage("res/Heart.png");
	private boolean broken;
	//private String brokenSkinName="Inconnu";
	
	public Jar(int xPos, int yPos, Image name, boolean broken) {
		super(xPos,yPos,name);
		this.broken=broken;
	}
	
	public void setBroken(boolean broken) {
		this.broken=broken;
	}
	
	public boolean getBroken() {
		return broken;
	}
	
	public Trapped trappedMonster(int lifePoint, int xPos, int yPos, int speed,int direction,ImageAnimeDirection image, boolean hidden) {
		Trapped trapped=new Trapped(lifePoint, xPos, yPos, speed, direction, image);
		return trapped;
		
	}
	
	public void randomBonus(List<Bonus> bonus, int x, int y) {
		//random a faire ici
		bonus.add(new Bonus(x,y,heart,0));
	}
	
	public void changeSkin(boolean broken) {
		//if (this.getBroken()) { this.setImage(brokenSkinName);} //NOM A DONNER //pas convaincu /la m�me
	}
	

} 
