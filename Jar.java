import java.util.Random;


public class Jar extends Decor {
	
	private boolean broken;
	private String brokenSkinName="Inconnu";
	
	public Jar(int xPos, int yPos, String name, boolean broken) {
		super(xPos,yPos,name);
		this.broken=broken;
	}
	
	public void setBroken(boolean broken) {
		this.broken=broken;
	}
	
	public boolean getBroken() {
		return broken;
	}
	
	public Trapped trappedMonster(int lifePoint, int xPos, int yPos, int speed,int direction,String name, boolean hidden) {
		Trapped trapped=new Trapped(lifePoint, xPos, yPos, speed, direction, name);
		return trapped;
		
	}
	
	public String randomBonus() {
		String bonus[]={"Heart","BombPlus","ArrowPlus","RangeBomb","Gauntlet","FireStaff","IceStaff","Key","Speed"};
		Random random=new Random();
		return bonus[random.nextInt(bonus.length)]; 
	}
	
	
	public void changeSkin(boolean broken) {
		if (this.getBroken()) { this.setName(brokenSkinName);} //NOM A DONNER //pas convaincu /la même
	}
	

} 
