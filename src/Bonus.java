import java.awt.Image;
import java.awt.Toolkit;

public class Bonus extends Decor {
	private int number;
	private int maxSpeed;
	
	public Bonus(int xPos, int yPos,Image image,int number){
		super(xPos,yPos,image);
		this.number = number;
	}

public void activation(Link l){
	switch (this.number){
	case 0: //Heart
		if(l.getLifePoint()<3) {
		l.setLifePoint(l.getLifePoint()+1); //ATTENTION VIE MAXIMUM
		System.out.println("Coeur");
		break;
		}
	case 1: //Bombplus
		l.setNumberBomb(l.getNumberBomb()+1); //
		break;
	case 2: //RangeBomb
		l.setRangeBomb(l.getRangeBomb()+1); //
		break;
	case 3: //ArrowPlus
		if(l.getNumberArrow()<99) {
		l.setNumberArrow(l.getNumberArrow()+1); //
		System.out.println("Flèche");
		break;
		}
	case 4: //Speed
		if(l.getSpeed()<maxSpeed) {
		l.setSpeed(l.getSpeed()+1); //coeff ï¿½ dï¿½terminer
		break;
		}
	case 5: //Gauntlet
		l.setGauntlet(true);
		break;
	case 6: //Key
		l.setKey(true);
		break;
	case 7: //FireStaff
		//for m in liste monstre
		//m.setLifePoint(m.getLifePoint()-1)
		System.out.println("FireStaff");
		break;
	case 8: //IceStaff
		//for m in liste monstre
		//m.setSpeed(m.getSpeed()/2)
		System.out.println("IceStaff");
		break;
	case 9: //Coin
		l.setNumberCoin(l.getNumberCoin()+1);
		System.out.println("Coin Coin");
		break;
		
	}
}

}