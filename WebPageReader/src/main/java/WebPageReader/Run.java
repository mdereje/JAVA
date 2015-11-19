package WebPageReader;

/**
 *@mdereje@scholastic.com
 *This program checks Jenkins
 *
*/
public class Run 
{
    public static void main( String[] args )
    {    	   	     
        
    	PlaySound.FILE_LOCATION = "resources/fail.wav"; 
    	try {
			PlaySound.play();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//ReadJenkins.findCurrentJob();
    }
}
