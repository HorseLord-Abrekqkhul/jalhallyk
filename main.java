import java.util.ArrayList;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fireball1 fire = new Fireball1(20,20,"feu",1,1);
		ArrayList<int[]> list = new ArrayList<int[]>();
		list = fire.FireList(0, 0, 50, 50);
		int[] tab= new int[2];
		for(int i = 0; i < list.size(); i++){
			tab = list.get(i);
			System.out.println("i:" + i + " x =" + tab[0] + " y =" + tab[1]);
		}
	}

}
