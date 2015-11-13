package WebPageReader;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AnalyzeOutput {

	public static boolean ISFINISHED;
	public static boolean ISSUCCESS;
	public static boolean ISABORTED;
	
	public static void PostBuildOutput(String console){
		
		if(ISFINISHED == true){
			
			String lastLine = console.substring(console.length() - 17, console.length());
			String result = lastLine.substring(lastLine.length() - 7, lastLine.length());
			//String finished = lastLine.substring(lastLine.length() - 17, lastLine.length()- 9);			
							
			if(result.endsWith("SUCCESS")){
				ISSUCCESS = true;
				PlaySound.FILE_LOCATION = "resources/win.wav"; 
				System.out.println("[Info!] The build has finished successfully!");
			}
			if(result.endsWith("ABORTED")){
				ISABORTED = true;
				PlaySound.FILE_LOCATION = "resources/abort.wav";
				System.out.println("[Info!] The build was aborted!");
			}
			if(result.endsWith("FAILURE")){
				ISSUCCESS = false;
				ISABORTED = false;
				PlaySound.FILE_LOCATION = "resources/fail.wav";
				System.out.println("[Info!] The build has failed!");
			}			
			
			try {
				PlaySound.play();
			} catch (Exception p) {
				// TODO Auto-generated catch block
				Logger.getLogger(AnalyzeOutput.class.getName()).log(Level.WARNING, "Was not able to find soundfile!", p);
			}
			
		}
	}		

	public boolean isFinished(){
		return ISFINISHED;
	}
	
	public boolean isSuccess(){
		return ISSUCCESS;
	}
		
}
