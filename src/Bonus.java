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
		Sound.playSound("bonus");
		System.out.println("Coeur");
		break;
		}
	case 1: //Bombplus
		l.setNumberBomb(l.getNumberBomb()+1); //
		break;
	case 2: //RangeBomb
		l.setRangeBomb(l.getRangeBomb()+1); //
		Sound.playSound("bonus");

		break;
	case 3: //ArrowPlus
		if(l.getNumberArrow()<99) {
		l.setNumberArrow(l.getNumberArrow()+1); //
		Sound.playSound("bonus");
		System.out.println("Fl�che");
		break;
		}
	case 4: //Speed
		if(l.getSpeed()<maxSpeed) {
		l.setSpeed(l.getSpeed()+1); //coeff � d�terminer
		Sound.playSound("bonus");
		break;
		}
	case 5: //Gauntlet
		l.setGauntlet(true);
		Sound.playSound("bonus");
		break;
	case 6: //Key
		l.setKey(true);
		Sound.playSound("bonus");
		break;
	case 7: //FireStaff
		//for m in liste monstre
		//m.setLifePoint(m.getLifePoint()-1)
		l.setStaff(0);
		System.out.println("FireStaff");
		Sound.playSound("bonus");
		break;
	case 8: //IceStaff
		//for m in liste monstre
		//m.setSpeed(m.getSpeed()/2)
		l.setStaff(1);
		System.out.println("IceStaff");
		Sound.playSound("bonus");

		break;
	case 9: //Rupee
		l.setNumberCoin(l.getNumberCoin()+1);
		System.out.println("Coin Coin");
		Sound.playSound("rupee");
		break;
		
	}
}

}