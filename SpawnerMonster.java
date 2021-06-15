
public class SpawnerMonster extends Decor {
	
	public SpawnerMonster(int xPos, int yPos, String name) {
		super(xPos,yPos,name);
	}
	
	public Monster spawnMonster(int lifePoint, int xPos, int yPos, int speed,int direction) {
		Monster monster = new Monster(lifePoint, xPos, yPos, speed, direction);
		return monster;
		
	}
	

}
