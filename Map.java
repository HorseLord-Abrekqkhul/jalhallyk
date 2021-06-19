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
	
	public void getMap(FileInputStream fis)// pas sur qu il faille mettre try catch
	{
		 try{
			  byte[] buf = new byte[8];
			  int i = 0;
			  int j = 0;
			  char a = ' ';
			  int[][] map = new int[6][6];
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
					  		System.out.println(map[i][j]);
					  		j++;
					  	}
				  }	  
			  }
		  } catch(FileNotFoundException e){
			  e.printStackTrace();
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
		 		 

		 
		  
	  }
}

