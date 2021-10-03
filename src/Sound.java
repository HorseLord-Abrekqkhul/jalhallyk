import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.swing.JOptionPane;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


public class Sound {

	public static void playSound(String name){
	InputStream in;
	try{
		in = new FileInputStream(new File(name + ".wav"));
		AudioStream audios = new AudioStream(in);
		AudioPlayer.player.start(audios);
	}
	catch(Exception e){
		JOptionPane.showMessageDialog(null,e);
	}
	}
	
	public static boolean isFinished (AudioStream audios){
		try{
		if (audios.available() == 0)
			return true;
		}
		catch (Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
		return false;
	}
}