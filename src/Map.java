import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


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
	
	public int[][] loadMap(FileInputStream fis)// pas sur qu il faille mettre try catch
	{
		int[][] map = new int[length][width];
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
							map[i][j] = java.lang.Character.getNumericValue(a);
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
}

