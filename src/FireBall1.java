import java.util.ArrayList;

public class FireBall1 extends Projectile {
	
	private int pos = 0;
	private int mytick = 1;
	private ArrayList<int[]> listpos;
	
	public FireBall1(int xPos, int yPos,ImageAnimeDirection IAD, int damage, int o, int direction,int x2, int y2, int xMax, int yMax){
		super(xPos,yPos,IAD,damage,o,direction);
		
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
		int i; int c = 0; int d = 0;
		for(i = 0; i < list.size(); i++){
			//if(Math.abs(list.get(i)[0] - getXPos()) < 0.5 && Math.abs(list.get(i)[1] - getYPos()) < 0.5){
			if(list.get(i)[0] == getXPos() && list.get(i)[1] == getYPos()){
				c = i;
				//System.out.print("origine "+c + "\n");
			}
			/*
			if(list.get(i)[0] == x2 && list.get(i)[1] == y2){
				d = i;
				//System.out.print("cible "+d + "\n");
			}
			*/
		}
		
		int dx = getXPos() - x2;
		int dy = getYPos() - y2;
		
		listpos = new ArrayList<int[]>();
		if(c == 0 || c == list.size()){
			for(i =0; i < list.size(); i++){
				listpos.add(list.get(i));
			}
		}
		else{
			if(testSign(list.get(c)[0] - list.get(c+1)[0],dx) && testSign(list.get(c)[1] - list.get(c+1)[1],dy)){
				for(i = c; i < list.size(); i++){
				listpos.add(list.get(i));
				}
			}
			else{
				for(i = 0; i < c; i++){
				listpos.add(list.get(i));
				}
			}
		}
	}
	
	public int getPos(){
		return this.pos;
	}
	
	public ArrayList<int[]> getList(){
		return this.listpos;
	}
	
	public void tick(){
		this.mytick++;
		if(this.mytick == 2) {
			this.pos++;
			mytick = 1;
		}
	}
	
	private boolean distance(int x, int y,int x2, int y2){
		int x1 = getXPos();
		int y1 = getYPos();
		double dist = ((y1-y2)*x+(x2-x1)*y+x1*y2-x2*y1)/Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
		return Math.abs(dist) < 0.5;
	}
	
	private boolean testSign(int a,int b){
		if(a < 0 && b < 0){
			return true;
		}
		else if(a == 0 && b == 0){
			return true;
		}
		else if(a > 0 && b > 0){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void move(){
		if(pos < listpos.size()){
			setXPos(listpos.get(pos)[0]);
			setYPos(listpos.get(pos)[1]);
		}
	}	
}
