import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


public class Map {
	
	private int length;
	private int width;
	Image bigTree = Toolkit.getDefaultToolkit().getImage("res/LittleTree.png");
	Image littleTree = Toolkit.getDefaultToolkit().getImage("res/LittleTree.png");
	Image bg = Toolkit.getDefaultToolkit().getImage("res/BackgroundForest.png");
	Image jar = Toolkit.getDefaultToolkit().getImage("res/Jar.png");
	ImageAnimeDirection melee = new ImageAnimeDirection("res/MeleeRun",1);
	Image rocks = Toolkit.getDefaultToolkit().getImage("res/Rocks.png");
	Image rock = Toolkit.getDefaultToolkit().getImage("res/Rock.png");
	Image root = Toolkit.getDefaultToolkit().getImage("res/Root.png");
	Image obstacles[]={root,rock,rocks,littleTree};
	
	public Map(int length, int width)
	{
		this.length = length;
		this.width = width;
	}
	
	public int getLength()
	{
		return length;
	}
	
	public void setLength(int length)
	{
		this.length = length;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public void setWidth(int width)
	{
		this.width = width;
	}
	
	public char[][] loadMap(FileInputStream fis)// pas sur qu il faille mettre try catch
	{
		char[][] map = new char[length][width];
		try{
			  byte[] buf = new byte[8];
			  int i = 0;
			  int j = 0;
			  char a = ' ';
			  
			  while (fis.read(buf) >= 0){
				  for (byte bit : buf){
					  a = ((char)bit);
					  	if (bit == 10){
					  		i++;
					  		j =0;
					  	}
					  
					  	else if (a != ' '&& a != '\n')
					  	{
							map[j][i] = a;
					  		j++;
					  	}
				  }	  
			  }
			  return map;
		  } catch(IOException e){
			  e.printStackTrace();
		  }finally{
			  try{
				  if(fis != null)
					  fis.close();
			  } catch (IOException e){
				  e.printStackTrace();
			  }
			  
		  }
		return map;		  
	  }
	public static void loadGame(){
		FileInputStream fis = null;
		String level = "2";
		String roomLine = "3";
		String roomColumn = "1";
		try{				
			fis = new FileInputStream(new File("res/niveau"+level+"ligne"+roomLine+"colonne"+roomColumn+".txt"));
			char tableau[][];
			Map map = new Map(16,16);
			tableau = map.loadMap(fis);
			saveMap(tableau,"res/test2.txt");
			ArrayList<Decor> decor = map.mapToListDecor(tableau);
			ArrayList<Monster> monstre = map.mapToListMonster(tableau);
			new Fenetre(decor,monstre);		

				
		} catch(FileNotFoundException e){
			e.printStackTrace();
		} finally{
			try{
				if(fis != null)
					fis.close();
			} catch (IOException e){
				e.printStackTrace();
			}
		}

	}  
	
	
	
	public ArrayList<Decor> mapToListDecor(char[][] map) { // changer les nulls
		
		ArrayList<Decor> decor = new ArrayList<Decor>();	
		for (int i = 0; i < map.length; i++){
			for (int j = 0; j < map[i].length;j++)
				switch(map[i][j]){
					case '0':
						decor.add(new Floor(40*i,40*j,bg));
						break;
					case '1':
						decor.add(new Floor(40*i,40*j,bg));
						decor.add(new Wall(40*i,40*j,bigTree));
						break;
					case '2':
						decor.add(new Floor(40*i,40*j,bg));
						decor.add(new Jar(40*i,40*j,jar, false));
						break;
					case '3':
						decor.add(new Floor(40*i,40*j,bg));
						decor.add(new SpawnerFireBalls(40*i,40*j,null)); //SpawnerFireBall
						break;
					case '4':
						decor.add(new Floor(40*i,40*j,bg));
						decor.add(new SpawnerMonster(40*i,40*j,null)); //SpawnerMonster
						break;
					case '5':
						decor.add(new Floor(40*i,40*j,bg));
						decor.add(new Door(40*i,40*j,null,false,1,1)); //Door
						break;
					case '6':
						decor.add(new Hole(40*i,40*j,null,1)); //Hole
						break;
					case '7':
						decor.add(new Floor(40*i,40*j,bg));
						decor.add(new MovingTrap(40*i,40*j,null,1)); //MovingTrap
						break;
					case '8':
						decor.add(new Floor(40*i,40*j,bg));
						decor.add(new Door(40*i,40*j,null,false,1,1)); //Door
						break;
					case '9':
						decor.add(new Floor(40*i,40*j,bg));
						decor.add(new Door(40*i,40*j,null,false,1,1)); //Exit
						break;
					/*case 'a':
						decor.add(new Wall(40*i,40*j,null));
					case 'b':
						decor.add(new Wall(40*i,40*j,null));
					case 'c':
						decor.add(new Wall(40*i,40*j,null));*/
					case 'r':
						decor.add(new Floor(40*i,40*j,bg));
						java.util.Random r=new java.util.Random( ) ; 
						int random = r.nextInt(4);
						Image obstacle = obstacles[random];
						decor.add(new Wall(40*i,40*j,obstacle));
						break;
					case 'e':
						decor.add(new Wall(40*i,40*j,null)); //Escalier
						break;
					case 'b':
						decor.add(new Wall(40*i,40*j,null)); //ChestBombPow
						break;
					case 'h':
						decor.add(new Wall(40*i,40*j,null)); //ButteHaut
						break;
					case 'j':
						decor.add(new Wall(40*i,40*j,null)); //ButteGauche
						break;
					case 'k':
						decor.add(new Wall(40*i,40*j,null)); //ButteDroite
						break;
					case 'z':
						decor.add(new Wall(40*i,40*j,null)); //ButteBas
						break;
					case 'u':
						decor.add(new Wall(40*i,40*j,null)); //CoinHG
						break;
					case 'i':
						decor.add(new Wall(40*i,40*j,null)); //CoinHD
						break;
					case 'o':
						decor.add(new Wall(40*i,40*j,null)); //CoinBG
						break;
					case 'p':
						decor.add(new Wall(40*i,40*j,null)); //CoinBD
						break;
					//case 't':
						//decor.add(new Wall(40*i,40*j,null));
					case 'q':
						decor.add(new Floor(40*i,40*j,bg));
						break;
					case 's':						
						decor.add(new Floor(40*i,40*j,bg));
						break;
					case 'd':
						decor.add(new Floor(40*i,40*j,bg));
						break;
					case 'f':
						decor.add(new Floor(40*i,40*j,bg));
						break;
						}
					}
		return decor;
	
	}
	
	public ArrayList<Monster> mapToListMonster(char[][] map) { // changer les nulls
			
		ArrayList<Monster> monster = new ArrayList<Monster>();
		for (int i = 0; i < map.length; i++){
			for (int j = 0; j < map[i].length;j++)
				switch(map[i][j]){
					//case 'l':
						//decor.add(new Link(3,(...)));
					case 'q':
						monster.add(new Ranged(1,40*i,40*j,2,3,null)); //Ranged
						break;
					case 's':
						monster.add(new Bomber(1,40*i,40*j,2,3,null)); //Bomber
						break;
					case 'd':
						monster.add(new Melee(2,40*i,40*j,2,3,melee));
						break;
					case 'f':
						monster.add(new Underground(1,40*i,40*j,2,3,null,true)); //Underground
						break;
					
						}
					}
	return monster;
}
	public static void saveMap(char[][] map,String name){ //oblige de mettre static sinon ca bug, pq?
		FileOutputStream fos = null;
		try{
			fos = new FileOutputStream(new File(name));
			for(int i = 0; i < map.length;i ++){
				for(int j = 0; j < map[i].length ;j++){
					fos.write(map[i][j]);
					if (j<map[i].length-1)
						fos.write(' ');
				}
				fos.write('\n');
			}
				
		}
		catch (FileNotFoundException e) {
	         e.printStackTrace();
	    } catch (IOException e) {
	         e.printStackTrace();
	    } finally {
	         try {
	            if (fos != null)
	               fos.close();
	         } catch (IOException e) {
	            e.printStackTrace();
	         }
		
		
	}
	}
}