
public class Bonus extends Item {
	private int number;
	
	public Bonus(int xPos, int yPos,String name,int number){
		super(xPos,yPos,name);
		this.number = number;
	}

public boolean isCaught(){
	return true;
}

public void finalyze(){
	switch (this.number){
	case 0: //Heart
		Link.setLifePoint(Link.getLifePoint()+1); //ATTENTION VIE MAXIMUM
		break;
	case 1: //Bombplus
		Link.setNumberBomb(Link.getNumberBomb()+1); //
		break;
	case 2: //RangeBomb
		Link.setRangeBomb(Link.getRangeBomb()+1); //
		break;
	case 3: //ArrowPlus
		Link.setNumberArrow(Link.getNumberArrow()+1); //
		break;
	case 4: //Speed
		Link.setSpeed(Link.getSpeed()+1); //coeff à déterminer
		break;
	case 5: //Gauntlet
		Link.setGauntlet(true);
		break;
	case 6: //Key
		Link.setKey(true);
		break;
	case 7: //FireStaff
		//for m in liste monstre
		//m.setLifePoint(m.getLifePoint()-1)
		break;
	case 8: //IceStaff
		//for m in liste monstre
		//m.setSpeed(m.getSpeed()/2)
		break;
	case 9:
		break;
	case 10:
		break;
	case 11:
		break;
	case 12:
		break;
	}
}

public void activation(Bonus bonus){
	bonus = null;
	System.gc();
}
}