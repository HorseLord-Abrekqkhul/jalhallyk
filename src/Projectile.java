import java.util.List;


public class Projectile extends Damage {
	private int direction;
	private int x;
	private int y;
	
	public Projectile(int xPos, int yPos,ImageAnimeDirection IAD,int c, int damage, int direction){
		super(xPos,yPos,IAD,c,damage);
		this.direction = direction;
		this.x = xPos;
		this.y = yPos;
	}
	
	
	public int getDirection()
	{ 
		return direction;
	}
	
	public void setDirection (int direction)
	{
		this.direction = direction;
	}
	
	public void move(){
		if(direction == 0){
			setXPos(getXPos() - 10);
			tick(getIAD(),getC());
		}
		if(direction == 1){
			setXPos(getXPos() + 10);
			tick(getIAD(),getC());
		}
		if(direction == 2){
			setYPos(getYPos() - 10); //panel 
			tick(getIAD(),getC());
		}
		if(direction == 3){
			setYPos(getYPos() + 10); //panel
			tick(getIAD(),getC());
		}
	}
	
	public int projectileInteraction(List<Link> link, List<Monster> monster, List<Decor> decor, List<Bomb> bomb){
		for(int i = 0; i < link.size(); i++){
			if(((direction == 0 || direction == 1) && (getXPos() > x + 40)) 
					|| ((direction == 2 || direction == 3) && (getYPos() > y + 40))){
				if(touch2(getXPos(),getYPos(),link.get(i).getXPos(),link.get(i).getYPos()) != -1){
					link.get(i).setLifePoint(link.get(i).getLifePoint()-1*link.get(i).getInvincible());
					link.get(i).setInvicible();
					System.out.println("Link a perdu une vie, il lui reste "+ link.get(i).getLifePoint() + " vies.");
					return 1;
				}
			}
		}
		for(int i = 0; i < monster.size(); i++){
			if(touch2(getXPos(),getYPos(),monster.get(i).getXPos(),monster.get(i).getYPos()) != -1){
				monster.get(i).setLifePoint(monster.get(i).getLifePoint()-1*monster.get(i).getInvincible());
				monster.get(i).setInvicible();
				System.out.println("Monstre n�" + i + " a perdu une vie, il lui reste "+ monster.get(i).getLifePoint() + " vies.");
				return 1;
			}
		}
		for(int i = 0; i < decor.size(); i++){
			if(touch2(getXPos(),getYPos(),decor.get(i).getXPos(),decor.get(i).getYPos()) != -1
					&& decor.get(i).getClass() != Floor.class){
				System.out.println("hihihi je me suis plant� dans un decor");
				return 2;
			}
		}
		for(int i = 0; i < bomb.size(); i++){
			if(touch2(getXPos(),getYPos(),bomb.get(i).getXPos(),bomb.get(i).getYPos()) != -1){
				bomb.get(i).setTime(15);
				return 3;
			}
		}
		move();
		return 0;
	}
	
}
	