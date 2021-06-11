import java.util.ArrayList;

public class Fireball1 extends Projectile {
	public Fireball1(int xPos, int yPos,String name, int damage, int direction){
		super(xPos,yPos,name,damage,direction);
	}
	
	private boolean distance(int x, int y,int x2, int y2){
		int x1 = getXPos();
		int y1 = getYPos();
		double dist = ((y1-y2)*x+(x2-x1)*y+x1*y2-x2*y1)/Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
		return Math.abs(dist) < 0.5;
	}
	
	public ArrayList<int[]> FireList(int x2, int y2, int xMax, int yMax){
		ArrayList<int[]> list = new ArrayList<int[]>();
		for(int y=0; y<yMax; y++){
			for(int x=0; x<xMax;x++){
				if(distance(x,y,x2,y2)){
					int[] tableau = new int[2];
					tableau[0] = x;
					tableau[1] = y;
					list.add(tableau);
				}
			}
		}
		int a[] = {getXPos(),getYPos()};
		int b[] = {x2,y2};
		int i; int c = 0; int d = 0;
		for(i = 0; i < list.size(); i++){
			if(list.get(i) == a){
				c = i;
				System.out.print("PD"+c);
			}
			if(list.get(i) == b){
				d = i;
				System.out.print("PD"+d);
			}
		}
		if(c<d){
			for(i =0; i < c; i++){
				list.remove(i);
			}
		}
		else{
			for(i = d+1; i < list.size(); i++){
				list.remove(i);
			}
		}
		return list;
		
	}
	
}
