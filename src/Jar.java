import java.awt.Image;
import java.awt.Toolkit;
import java.util.List;


public class Jar extends Decor {
	
	Image heart = Toolkit.getDefaultToolkit().getImage("res/Heart.png"); 
	Image rubis = Toolkit.getDefaultToolkit().getImage("res/Rubis.png"); 
	Image arrowPlus = Toolkit.getDefaultToolkit().getImage("res/ArrowPlus.png"); 
	Image iceStaff = Toolkit.getDefaultToolkit().getImage("res/IceStaff.png"); 
	Image key = Toolkit.getDefaultToolkit().getImage("res/Key.png"); 
	Image speed = Toolkit.getDefaultToolkit().getImage("res/SpeedBonus.png"); 
	Image gauntlet = Toolkit.getDefaultToolkit().getImage("res/Gauntlet2.png"); 
	Image fireStaff = Toolkit.getDefaultToolkit().getImage("res/FireStaff.png"); 
	Image bombRange = Toolkit.getDefaultToolkit().getImage("res/BombRange.png");	
	Image bombPlus = Toolkit.getDefaultToolkit().getImage("res/BombPlus.png"); 
	
	
	private Image bonusImage[]={heart,bombPlus,bombRange,arrowPlus,speed,gauntlet,key,fireStaff,iceStaff,rubis};
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
		int bonusType=-1;
		java.util.Random r=new java.util.Random( ) ; 
		int random = r.nextInt(100);
		int random2=r.nextInt(3);
		if(random%2==0) {
			bonusType=9;
		}
		if(random%5==0) {
			bonusType=0;
		}
		if(random%20==0) {
			if(random2==0) {bonusType=7;}
			else if(random2==1) {bonusType=8;}
			else{bonusType=3;}
		}
		if(bonusType>=0) {
		bonus.add(new Bonus(x,y,bonusImage[bonusType],bonusType));
		}
	}
	
	public void changeSkin(boolean broken) {
		//if (this.getBroken()) { this.setImage(brokenSkinName);} //NOM A DONNER //pas convaincu /la m�me
	}
	

} 
