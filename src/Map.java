import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.Object;


public class Map {
	
	private int length;
	private int width;
	
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
					  
					  	else if (a != ' '&& a != '\n' &&  java.lang.Character.getNumericValue(a) != -1)
					  	{
							map[i][j] = a;
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
	public ArrayList<ArrayList<Object>> mapToList(char[][] map){ // changer les nulls
		
		ArrayList<Object> decor = new ArrayList<Object>();	
		ArrayList<Object> monster = new ArrayList<Object>();
		for (int i = 0; i < map.length; i++){
			for (int j = 0; j < map[i].length;j++)
				switch(map[i][j]){
					case '0':
						break;
					case '1':
						Wall wall = new Wall(40*i,40*j,null);
						decor.add(wall);
					case '2':
					    Jar jar = new Jar(40*i,40*j,null, false);
						decor.add(jar);
					case '3':
						SpawnerFireBalls s = new SpawnerFireBalls(40*i,40*j,null);
						decor.add(s);
					case '4':
						SpawnerMonster sm = new SpawnerMonster(40*i,40*j,null);
						decor.add(sm);
					case '5':
						Door door = new Door(40*i,40*j,null, false);
						decor.add(door);
					case '6':
						Hole hole = new Hole(40*i,40*j,null,1);
						decor.add(hole);
					case '7':
						MovingTrap mT = new MovingTrap(40*i,40*j,null,1);
						decor.add(mT);
					case '8':
						door = new Door(40*i,40*j,null,false);
						decor.add(door);
					case '9':
					    door = new Door(40*i,40*j,null,false);
						decor.add(door);
					//case 'l':
						//Link link = new Link(3,);
						//decor.add(wall);
					/*case 'a':
						Wall wall = new Wall(40*i,40*j,null);
						decor.add(wall);
					case 'b':
						Wall wall = new Wall(40*i,40*j,null);
						decor.add(wall);
					case 'c':
						Wall wall = new Wall(40*i,40*j,null);
						decor.add(wall);*/
					case 'r':
						wall = new Wall(40*i,40*j,null);
						decor.add(wall);
					case 'e':
						wall = new Wall(40*i,40*j,null);
						decor.add(wall);
					case 'b':
						wall = new Wall(40*i,40*j,null);
						decor.add(wall);
					case 'h':
						wall = new Wall(40*i,40*j,null);
						decor.add(wall);
					case 'j':
						wall = new Wall(40*i,40*j,null);
						decor.add(wall);
					case 'k':
						wall = new Wall(40*i,40*j,null);
						decor.add(wall);
					case 'z':
						wall = new Wall(40*i,40*j,null);
						decor.add(wall);
					case 'u':
						wall = new Wall(40*i,40*j,null);
						decor.add(wall);
					case 'i':
						wall = new Wall(40*i,40*j,null);
						decor.add(wall);
					case 'o':
						wall = new Wall(40*i,40*j,null);
						decor.add(wall);
					case 'p':
						wall = new Wall(40*i,40*j,null);
						decor.add(wall);
					case 'q':
						Ranged ranged = new Ranged(1,40*i,40*j,2,3,null);
						monster.add(ranged);
					case 's':
						Bomber bomber= new Bomber(1,40*i,40*j,2,3,null);
						monster.add(bomber);
					case 'd':
						Melee melee = new Melee(2,40*i,40*j,2,3,null);
						monster.add(melee);
					case 'f':
						Underground uG = new Underground(1,40*i,40*j,2,3,null,true);
						monster.add(uG);
					//case 't':
						//Wall wall = new Wall(40*i,40*j,null);
						//decor.add(wall);
					
						}
					}
				
	ArrayList<ArrayList<Object>> list = new ArrayList<ArrayList<Object>>();
	list.add(decor);
	list.add(monster);
	return list;
	
	}
}