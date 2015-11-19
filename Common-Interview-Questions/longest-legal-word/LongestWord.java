import java.io.FileReader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

/*
	Given a string of characters, find the longest legal word. (word legallity checker is given.)
*/
public class LongestWord{

	public static void main(String[] args) throws IOException{
	
		// BufferedReader in =  new BufferedReader(new InputStreamReader(System.in));
		// String input = in.readLine();
		LongestWord check = new LongestWord();
		String s = "lorewkfjoeifcatujehatiofhjezfrehoughtonregiguvjvjcaejhfr";

		String longest_word = check.findLongest(s);
		
		if(longest_word.equals("houghton")){
			System.out.println("Longest word in the string is: " + longest_word);
		}

	}

	public boolean isWordReal(String word) throws IOException{
		
		FileReader file = new FileReader("Words.txt");

		BufferedReader reader = new BufferedReader(file);
		String text;
		while((text = reader.readLine()) != null){
			if(word.equals(text)){
				return true;
			}
		}
		reader.close();
		return false;
	}

	public String findLongest(String word) throws IOException{
		
		String curLongest = "";
		String maxLongest = "";

		for(int i = 0; i < word.length(); i++){
			for(int j = i+1; j < word.length(); j++){

				if(isWordReal(word.substring(i,j))){
					curLongest = word.substring(i,j);
				}
				if(curLongest.length() > maxLongest.length()){
					maxLongest = curLongest;
				}
			}
		}

		return maxLongest;
	}
}