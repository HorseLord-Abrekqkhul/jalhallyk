
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
	setYPos(yPos - 1); //panel 
	direction = 1;
}

public void moveDown ()
{
	setYPos(yPos + 1); //panel
	direction = 2;
}

public void moveRight ()
{
	setXPos(xPos + 1);
	direction = 3;
}

public void moveLeft ()
{
	setXPos(xPos - 1);
	direction = 4;
}

public Bomb setBomb(int xPos, int yPos, String name, int damage)
{
	Bomb bomb = new Bomb(xPos, yPos, name, damage) ;
	return bomb;
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

public Arrow fireArrow(int xPos, int yPos,String name, int damage, int direction) //interface?
{
	Arrow arrow = new Arrow(xPos, yPos, name, damage, direction);
	return arrow;
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
