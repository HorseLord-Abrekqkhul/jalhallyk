import java.awt.Image;
import java.util.List;

public class Link extends Character {
	

private int numberBomb;
private int rangeBomb;
private int numberArrow;
private boolean gauntlet;
private boolean key;

public Link (int lifePoint, int xPos, int yPos, int speed,int direction, ImageAnimeDirection image,int numberBomb, int rangeBomb, int numberArrow, boolean gauntlet, boolean key)
{
	super(lifePoint, xPos, yPos, speed, direction, image);
	this.numberBomb = numberBomb;
	this.rangeBomb = rangeBomb;
	this.numberArrow = numberArrow;
	this.gauntlet = gauntlet;
	this.key = key;	
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

public void moveUp ()
{
	setYPos(yPos - 2); //panel 
	direction = 2;
	tick(getIAD(),5);
}

public void moveDown ()
{
	setYPos(yPos + 2); //panel
	direction = 3;
	tick(getIAD(),5);
}

public void moveRight ()
{
	setXPos(xPos + 2);
	direction = 1;
	tick(getIAD(),5);
}

public void moveLeft ()
{
	setXPos(xPos - 2);
	direction = 0;
	tick(getIAD(),5);
}

public List<Bomb> setBomb(List<Bomb> liste, Image image)
{
	liste.add( new Bomb(xPos, yPos, image, 1)) ;
	return liste;
}

public void pushBombUp(Bomb bomb)
{
	bomb.setYPos(bomb.getYPos() + 1);
}

public void pushBombDown(Bomb bomb)
{
	bomb.setYPos(bomb.getYPos() - 1);
}

public void pushBombRight(Bomb bomb)
{
	bomb.setXPos(bomb.getXPos() + 1);
}

public void pushBombLeft(Bomb bomb)
{
	bomb.setXPos(bomb.getXPos() - 1);
}

public List<Arrow> fireArrow(List<Arrow> liste, ImageAnimeDirection IAD){
	tick(getIAD(),5);
	if(getActualFrame() == 6){
		liste.add(new Arrow(xPos, yPos, IAD, 5, 3, direction));
	}
	return liste;
	 
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
//touch
}
