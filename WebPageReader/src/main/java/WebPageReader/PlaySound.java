package WebPageReader;

import javax.media.*;
import java.io.*;
import java.util.*;

public class PlaySound {
	
	public static String FILE_LOCATION;
	
	public static void play() throws Exception{
		
		//path of the audio file to play
		 File f=new File(FILE_LOCATION);
		
		 // Create a Player object that realizes the audio
		 final Player p=Manager.createRealizedPlayer(f.toURI().toURL());
	
		  // plays the sound waits 10 seconds and then restarts the program loop
		  p.start();
		  Thread.sleep(ReadJenkins.CHECK_FOR_JOBS);
		  ReadJenkins.findCurrentJob();			 
		   
	}
	
}