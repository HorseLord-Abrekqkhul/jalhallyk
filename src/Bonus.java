import java.awt.Image;

public class Bonus extends Decor {
	private int number;
	
	public Bonus(int xPos, int yPos,Image image,int number){
		super(xPos,yPos,image);
		this.number = number;
	}

public void activation(Link l){
	switch (this.number){
	case 0: //Heart
		l.setLifePoint(l.getLifePoint()+1); //ATTENTION VIE MAXIMUM
		break;
	case 1: //Bombplus
		l.setNumberBomb(l.getNumberBomb()+1); //
		break;
	case 2: //RangeBomb
		l.setRangeBomb(l.getRangeBomb()+1); //
		break;
	case 3: //ArrowPlus
		l.setNumberArrow(l.getNumberArrow()+1); //
		break;
	case 4: //Speed
		l.setSpeed(l.getSpeed()+1); //coeff � d�terminer
		break;
	case 5: //Gauntlet
		l.setGauntlet(true);
		break;
	case 6: //Key
		l.setKey(true);
		break;
	case 7: //FireStaff
		//for m in liste monstre
		//m.setLifePoint(m.getLifePoint()-1)
		break;
	case 8: //IceStaff
		//for m in liste monstre
		//m.setSpeed(m.getSpeed()/2)
		break;

	}
}

}