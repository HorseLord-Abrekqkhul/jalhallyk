import java.awt.Image;


public class SpawnerMonster extends Decor {
	
	public SpawnerMonster(int xPos, int yPos, Image name) {
		super(xPos,yPos,name);
	}
	
	public Monster spawnMonster(int lifePoint, int xPos, int yPos, int speed,int direction,ImageAnimeDirection image) {
		Monster monster = new Monster(lifePoint, xPos, yPos, speed, direction,image);
		return monster;
		
	}
	

}
