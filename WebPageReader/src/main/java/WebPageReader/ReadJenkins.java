package WebPageReader;

import java.io.IOException;
import java.lang.IllegalArgumentException;
import java.sql.Timestamp;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Example program to list links from a URL.
 */
public class ReadJenkins {
	
	public static Boolean BUILD_RUNNING;
	static String JENKINS_BASE_URL = "http://172.17.35.165:8080";	
	static String CONSOLE_URL;
	public static String CONSOLE_OUTPUT;
	public static long CHECK_FOR_JOBS = 10000;
	public static long CHECK_FOR_JOB_STATUS = 5000;
	
	
    public static void consoleOutput(){
    	    	    	
    	try{
    		java.util.Date date = new java.util.Date();	
    		
    		Document doc = Jsoup.connect(CONSOLE_URL).get();
    		//Element body = doc.body(); //Returns the HTML as a whole    		
    		Elements anchors = doc.select("pre");
    		    		
    		String tempout = anchors.text();
    		System.out.println("[Info!] Console page link: '"+ CONSOLE_URL +"'");
    		if(tempout.equals("")){
    			Thread.sleep(CHECK_FOR_JOB_STATUS);
    			System.out.println("[Info!] Job is in progress - " + new Timestamp(date.getTime()));     			
    			consoleOutput(); //calls itself if test is not complete
    			
    		}else{
    			//Once the sound is played it does not get back to analyze output
    			CONSOLE_OUTPUT = tempout;
    			
    			AnalyzeOutput.ISFINISHED = true; 
    			AnalyzeOutput.PostBuildOutput(CONSOLE_OUTPUT);
    		}    		    		

    	} catch (IllegalArgumentException ex){
    		//Logger.getLogger(ReadJenkins.class.getName()).log(Level.WARNING, "Job console page refused connection!", ex);
    		System.err.println("[Warning!] Job console page refused connection!");
    	} catch (InterruptedException e) {			
    		System.err.println("[Warning!] InterruptedException has occured in consoleOutput()!");
		} catch (Exception s) {
			System.err.println("[Warning!] Connection to Job Console has timed out!");
		}    	    	
    	consoleOutput();
    }
    
 // Finds the link of the current build
    public static void findCurrentJob(){
    	String tempLink = "";
    	try{
    		Document doc = Jsoup.connect(JENKINS_BASE_URL).get();
    		Elements consoleLinks = doc.select("table").select("div").select("table"); 
  		
    		for(Element consoleLink : consoleLinks){    			    			   			
    			tempLink = consoleLink.attr("href");
    			if(!tempLink.equalsIgnoreCase("")){
    				CONSOLE_URL = JENKINS_BASE_URL + tempLink; 
    				BUILD_RUNNING = true;    		
    				consoleOutput();
    			}    			
    		}
    		    		
    		if(tempLink.equals("")){
    			System.out.println("[Info!] No jobs running currently, will check again in " + (CHECK_FOR_JOBS / 1000 )+ " seconds!");
    			Thread.sleep(CHECK_FOR_JOBS);    			
    			findCurrentJob();
    		}
    		 
    	} catch (IOException ex){
    		System.err.println("[Warning!] Jenkins Server refused connection with the app, will try again " + (CHECK_FOR_JOBS / 1000 )+ " seconds!");
    	} catch (InterruptedException e) {
    		System.err.println("[Warning!] Sleep function not working!");
		} catch (Exception s) {	
			System.err.println("[Warning!] Jenkins Server socket exception!");
		}   	
    	try {    		
			Thread.sleep(CHECK_FOR_JOBS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
    	findCurrentJob();
    }
//   //Used for testing! 
//    public static void main(String[] args){
//    	findCurrentJob();    	    	
//    }
}