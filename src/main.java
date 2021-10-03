import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		
		//new Fenetre();
		
		Map map = new Map(16,16,"1","3","1");
		char[][] tableau = new char[16][16];
		tableau = map.loadRoom();
		ArrayList<Decor> decor = map.mapToListDecor(tableau);
		ArrayList<Monster> monstre = map.mapToListMonster(tableau);
		Sound.playSound("swag");
		new Fenetre(decor,monstre,map);
			}
}
	
	/*	// TODO Auto-generated method stub
		Fireball1 fire = new Fireball1(25,25,"feu",1,1);
		ArrayList<int[]> list = new ArrayList<int[]>();
		list = fire.FireList(40, 40, 50, 50);
		ArrayList<Integer> listposx = new ArrayList<Integer>();
		ArrayList<Integer> listposy = new ArrayList<Integer>();
		for(int i = 0; i < list.size(); i++){
			listposx.add(list.get(i)[0]);
			listposy.add(list.get(i)[0]);
		}
		int p = 0;
		for(int i = 0;i < 50; i++){
			System.out.print("\n");
			for(int j = 0; j < 50; j++){
				for(int k = 0; k < listposx.size(); k++){
					if(listposx.get(k) == i && listposy.get(k) == j){
						System.out.print("x");
						p = 1;
					}
				}
				if(p==0){
					System.out.print(".");
				}
				p = 0;
			}
		}
	}
*/
//}
//}