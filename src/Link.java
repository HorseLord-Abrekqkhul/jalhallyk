import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

public class Link extends Character {
	

private int numberBomb;
private int rangeBomb;
private int numberArrow;
private boolean gauntlet;
private boolean key;

Image rock = Toolkit.getDefaultToolkit().getImage("res/Rock.png");

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

public void moveUp (List<Decor> d,List<Bomb> b, List<Monster> monster)

{
	direction = 2;
	int k = 1;
	for(int j = 0; j < touchList(d,b,monster).get(0).size(); j++){
		if(touchList(d,b,monster).get(0).get(j)[1] == 3){
			System.out.println(touchList(d,b,monster).get(0).get(j)[1]);
			k = 0;
		}
	}
	setYPos(yPos - k*speed); //panel 
	tick(getIAD(),5);
}

public void moveDown (List<Decor> d,List<Bomb> b, List<Monster> monster)
{
	direction = 3;
	int k = 1;
	for(int j = 0; j < touchList(d,b,monster).get(0).size(); j++){
		if(touchList(d,b,monster).get(0).get(j)[1] == 2){
			System.out.println(touchList(d,b,monster).get(0).get(j)[1]);
			k = 0;
		}
	}
	setYPos(yPos + k*speed); //panel
	tick(getIAD(),5);
}

public void moveRight (List<Decor> d,List<Bomb> b, List<Monster> monster)
{
	direction = 1;
	int k = 1;
	for(int j = 0; j < touchList(d,b,monster).get(0).size(); j++){
		if(touchList(d,b,monster).get(0).get(j)[1] == 0){
			System.out.println(touchList(d,b,monster).get(0).get(j)[1]);
			k = 0;
		}
	}
	setXPos(xPos + k*speed);
	tick(getIAD(),5);
}

public void moveLeft (List<Decor> d,List<Bomb> b, List<Monster> monster)
{
	direction = 0;
	int k = 1;
	for(int j = 0; j < touchList(d,b,monster).get(0).size(); j++){
		if(touchList(d,b,monster).get(0).get(j)[1] == 1){
			System.out.println(touchList(d,b,monster).get(0).get(j)[1]);
			k = 0;
		}
	}
	setXPos(xPos - k*speed);
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
	if (k == 1){
		liste.add( new Bomb(x+5, y+5, image, 1)) ;
	}
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

	
}
