
public class Link extends Character {
	
private String name;
private int numberBomb;
private int rangeBomb;
private int numberArrow;
private boolean gauntlet;
private boolean key;

public Link (int lifePoint, int xPos, int yPos, int speed,int direction, String name,int numberBomb, int rangeBomb, int numberArrow, boolean gauntlet, boolean key)
{
	super(lifePoint, xPos, yPos, speed, direction);
	this.name = name;
	this.numberBomb = numberBomb;
	this.rangeBomb = rangeBomb;
	this.numberArrow = numberArrow;
	this.gauntlet = gauntlet;
	this.key = key;
	
}
public String getName()
{
	return name;
}

public void setName(String name)
{
	this.name = name;
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
	setYPos(yPos + 1);
}

public void moveDown ()
{
	setYPos(yPos - 1);
}

public void moveRight ()
{
	setYPos(xPos + 1);
}

public void moveLeft ()
{
	setYPos(xPos - 1);
}

public void setBomb()
{
	bomb bomb = new bomb(xPos, yPos) ;
}

public void pushBombUp(bomb bomb)
{
	bomb.setYPos(bomb.getYPos() + 1);
}

public void pushBombDown(bomb bomb)
{
	bomb.setYPos(bomb.getYPos() - 1);
}

public void pushBombRight(bomb bomb)
{
	bomb.setXPos(bomb.getXPos() + 1);
}

public void pushBombLeft(bomb bomb)
{
	bomb.setXPos(bomb.getXPos() - 1);
}

public void fireArrow() //interface?
{
	arrow arrow = new arrow(xPos, yPos,direction);
}

public void resetAttributes()
{
	lifePoint = 3;
	xPos = 0;
	yPos = 0;
	speed = 325;
	direction = 2;
	name = "link";
	rangeBomb = 2;
	numberBomb = 1;
	numberArrow = 0;
	gauntlet = false;
	key = false;
	
}
//touch
}
