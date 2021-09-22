import java.awt.Image;
import java.awt.Toolkit;
import java.util.List;

public class Link extends Character {
	

private int numberBomb;
private int rangeBomb;
private int numberArrow;
private boolean gauntlet;
private boolean key;
private int numberCoin;
private int U = 1;
private int D = 1;
private int L = 1;
private int R = 1;

Image rock = Toolkit.getDefaultToolkit().getImage("res/Rock.png");

public Link (int lifePoint, int xPos, int yPos, int speed,int direction, ImageAnimeDirection image,int numberBomb, int rangeBomb, int numberArrow, boolean gauntlet, boolean key,int numberCoin)
{
	super(lifePoint, xPos, yPos, speed, direction, image);
	this.numberBomb = numberBomb;
	this.rangeBomb = rangeBomb;
	this.numberArrow = numberArrow;
	this.gauntlet = gauntlet;
	this.key = key;	
	this.numberCoin=numberCoin;
}


public int getNumberBomb()
{
	return numberBomb;
}

public void setNumberBomb(int numberBomb)
{ 
	this.numberBomb = numberBomb;
}

public int getRangeBomb()
{
	return rangeBomb;
}

public void setRangeBomb(int rangeBomb)
{
	this.rangeBomb = rangeBomb;
}

public int getNumberArrow()
{
	return numberArrow;
}

public void setNumberArrow(int numberArrow)
{
	this.numberArrow = numberArrow;
}

public boolean getGauntlet()
{
	return gauntlet;
}

public void setGauntlet(boolean gauntlet)
{
	this.gauntlet = gauntlet;
}

public boolean getKey()
{
	return key;
}

public void setKey(boolean key)
{
	this.key = key;
	
}

public int getNumberCoin() {
	return numberCoin;
}

public void setNumberCoin(int numberCoin) {
	this.numberCoin=numberCoin;
}

public void moveUp ()

{
	direction = 2;
	setYPos(yPos - U*speed); //panel 
	tick(getIAD(),5);
}

public void moveDown ()
{
	direction = 3;
	setYPos(yPos + D*speed); //panel
	tick(getIAD(),5);
}

public void moveRight ()
{
	direction = 1;
	setXPos(xPos + R*speed);
	tick(getIAD(),5);
}

public void moveLeft ()
{
	direction = 0;
	setXPos(xPos - L*speed);
	tick(getIAD(),5);
}

public List<Bomb> setBomb(List<Bomb> liste, Image image)
{
	int x,y;
	int k = 1;
	if(xPos%40 <= 20){
		x = xPos - xPos%40;
	}
	else{
		x = xPos + 40 - xPos%40;
	}
	if(yPos%40 <= 20){
		y = yPos - yPos%40;
	}
	else{
		y = yPos + 40 - yPos%40;
	}
	for(int i = 0; i < liste.size(); i++){
		if(x + 5 == liste.get(i).getXPos() && y + 5 == liste.get(i).getYPos()){
			k = 0;
		}
	}
	if (k == 1 && getInvincible() == 1){
		liste.add( new Bomb(x+5, y+5, image, 1)) ;
	}
	return liste;
}

public List<Arrow> fireArrow(List<Arrow> liste, ImageAnimeDirection IAD){
	tick(getIAD(),5);
	if(getActualFrame() == 6){
		liste.add(new Arrow(xPos, yPos, IAD, 5, 3, direction));
	}
	return liste;
	 
	}

public void linkInteraction(List<Decor> decor, List<Monster> monster, List<Bomb> bomb, List<Bonus> bonus, Map map){
	R = 1;
	L = 1;
	D = 1;
	U = 1;
	for(int i = 0; i < decor.size(); i++){
		if(touchDecor(getXPos(),getYPos(),decor.get(i).getXPos(),decor.get(i).getYPos()) != -1 && decor.get(i).getClass() == Door.class){
			int line = ((Door) decor.get(i)).getLine();
			int column = ((Door) decor.get(i)).getColumn();
			int level = ((Door) decor.get(i)).getLevel();
			char[][] tableau = new char[16][16];

			map.saveMap(map.listToMap(decor, monster));
			map.setLevel(Integer.toString(level + Integer.parseInt(map.getLevel())));
			map.setRoomLine(Integer.toString(Integer.parseInt(map.getRoomLine()) - line));
			map.setRoomColumn(Integer.toString(Integer.parseInt(map.getRoomColumn()) - column));
			tableau = map.loadRoom();

			decor.removeAll(decor);
			List<Decor> decor2 = map.mapToListDecor(tableau);
			for(int j = 0; j < decor2.size();j++){
				decor.add(decor2.get(j));
			}
			
			monster.removeAll(monster);
			List<Monster> monster2 = map.mapToListMonster(tableau);
			for(int j = 0; j < monster2.size(); j++){
				monster.add(monster2.get(j));
			}
			
			this.setXPos(40*8);
			this.setYPos(40*8);
			break;
		}
		
		if(decor.get(i).getClass() != Floor.class){
			int a = touchDecor(getXPos(),getYPos(),decor.get(i).getXPos(),decor.get(i).getYPos());
			if(a == 0)
				R = 0;
			if(a == 1)
				L = 0;
			if(a == 2)
				D = 0;
			if(a == 3)
				U = 0;
		}
	}
	for(int i = 0; i < monster.size(); i++){
		int a = touchMonster(getXPos(),getYPos(),monster.get(i).getXPos(),monster.get(i).getYPos());
		if(a == 0){
			if(R != 0 && getInvincible() == 1){
				for(int j = 0; j < 3; j++){
					setXPos(getXPos() - 5);
					for(int k = 0; k < decor.size(); k++){
						if(touchDecor(getXPos(),getYPos(),decor.get(i).getXPos(),decor.get(i).getYPos()) != 0){
							R = 0;
						}
					}
				}
			}
			setLifePoint(getLifePoint()-1*getInvincible());
			setInvicible();
		}
		if(a == 1){
			if(L != 0 && getInvincible() == 1){
				for(int j = 0; j < 3; j++){
					setXPos(getXPos() + 5);
					for(int k = 0; k < decor.size(); k++){
						if(touchDecor(getXPos(),getYPos(),decor.get(i).getXPos(),decor.get(i).getYPos()) != 1){
							L = 0;
						}
					}
				}
			}
			setLifePoint(getLifePoint()-1*getInvincible());
			setInvicible();
		}
		if(a == 2){
			if(D != 0 && getInvincible() == 1){
				for(int j = 0; j < 3; j++){
					setYPos(getYPos() - 5);
					for(int k = 0; k < decor.size(); k++){
						if(touchDecor(getXPos(),getYPos(),decor.get(i).getXPos(),decor.get(i).getYPos()) != 2){
							D = 0;
						}
					}
				}
			}
			setLifePoint(getLifePoint()-1*getInvincible());
			setInvicible();
		}
		if(a == 3){
			if(U != 0 && getInvincible() == 1){
				for(int j = 0; j < 3; j++){
					setYPos(getYPos() + 5);
					for(int k = 0; k < decor.size(); k++){
						if(touchDecor(getXPos(),getYPos(),decor.get(i).getXPos(),decor.get(i).getYPos()) != 3){
							U = 0;
						}
					}
				}
			}
			setLifePoint(getLifePoint()-1*getInvincible());
			setInvicible();
		}
	}
	for(int i = 0; i < bomb.size(); i++){
		int a = touchBomb(getXPos(),getYPos(),bomb.get(i).getXPos(),bomb.get(i).getYPos());
		if(a == 0){
			R = 0;
			if(direction == 1 && gauntlet == true){
				bomb.get(i).setDirection(direction);
			}
		}
		if(a == 1){
			L = 0;
			if(direction == 0 && gauntlet == true){
				bomb.get(i).setDirection(direction);
			}
		}
		if(a == 2){
			D = 0;
			if(direction == 3 && gauntlet == true){
				bomb.get(i).setDirection(direction);
			}
		}
		if(a == 3){
			U = 0;
			if(direction == 2 && gauntlet == true){
				bomb.get(i).setDirection(direction);
			}
		}
	}
	for(int i = 0; i < bonus.size(); i++){
		if(touchMonster(getXPos(),getYPos(),bonus.get(i).getXPos(),bonus.get(i).getYPos()) != -1){
			bonus.get(i).activation(this);
			bonus.remove(i);
		}
	}
}

public void resetAttributes()
{
	lifePoint = 3;
	xPos = 0;
	yPos = 0;
	speed = 325;
	direction = 2;
	rangeBomb = 2;
	numberBomb = 1;
	numberArrow = 0;
	gauntlet = false;
	key = false;
	
}

	
}
