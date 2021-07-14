import java.awt.Image;
import java.awt.Toolkit;
import java.util.List;
import java.util.ArrayList;

public class ImageAnimeDirection {
	private List<Image> liste;
	public final static int GAUCHE = 0;
	public final static int DROITE = 1;
	public final static int HAUT = 2;
	public final static int BAS = 3;
	
	String nomBase;
	private int frames;
	
	public ImageAnimeDirection(String nomBase, int frames) {
		this.frames = frames;
		this.nomBase = nomBase;
		liste = new ArrayList<Image>();
		
		for(String dir : new String[]{"Left", "Right", "Up", "Down"}){
			for(int i = 1; i<= frames; i++){
				liste.add(Toolkit.getDefaultToolkit().getImage(nomBase + dir + Integer.toString(i) + ".png"));
				System.out.println(nomBase + dir + Integer.toString(i) + ".png");
			}
		}
	}
	
	public int getFrames(){
		return this.frames;
	}
	
	public Image getImage(Link link){
		if(link.getDirection() == GAUCHE){
			return liste.get(link.getActualFrame() -1);
		}
		else if(link.getDirection() == DROITE){
			return liste.get(link.getActualFrame() + frames-1);
		}
		else if(link.getDirection() == HAUT){
			return liste.get(link.getActualFrame() + 2*frames-1);
		}
		else{
			return liste.get(link.getActualFrame() + 3*frames-1);
		}
	}
	
	public Image getImage(Arrow a){
		if(a.getDirection() == GAUCHE){
			return liste.get(a.getActualFrame() -1);
		}
		else if(a.getDirection() == DROITE){
			return liste.get(a.getActualFrame() + frames-1);
		}
		else if(a.getDirection() == HAUT){
			return liste.get(a.getActualFrame() + 2*frames-1);
		}
		else{
			return liste.get(a.getActualFrame() + 3*frames-1);
		}
	}
	
}
	