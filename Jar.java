
public class Jar extends Decor {
	
	private boolean broken;
	
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
	
	public void trappedMonster() {
		String monsters[]={"Melee","Ranged","Bomber","Underground","Trapped"};
		// RANDOM A RAJOUTER
		
	}
	
	public void randomBonus() {
		String bonus[]={"Heart","BombPlus","ArrowPlus","RangeBomb","Gauntlet","FireStaff","IceStaff","Key","Speed"};
		// RANDOM A RAJOUTER
	} 
	
	public void changeSkin(boolean broken) {
		if (this.getBroken()) { this.setName(brokenSkinName);} //NOM A DONNER //pas convaincu 
	}
	

} 
