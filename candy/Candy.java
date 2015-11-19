import java.util.*;
import java.util.Arrays;
/*
There are N children standing in a line. Each child is assigned a rating value. 
You are giving candies to these children subjected to the following requirements:
	1. Each child must have at least one candy.
	2. Children with a higher rating get more candies than their neighbors.

What is the minimum candies you must give?
*/

public class Candy{

	public static void main(String[] args){	

		Candy test = new Candy();

		int count[] = {34, 22, 10, 60, 30, 22, 10, 13, 38, 42, 2834, 28, 58, 36, 12, 10, 22, 38, 42};
		System.out.println("arrays : " + Arrays.toString(count));
		System.out.println("minCandies : " + test.minimumCandies(count));
	}

	public int minimumCandies(int[] ratings){
		int minNum = 0;
		Set<Integer> uniqueRatings = new HashSet<Integer>();

		for (int i = 0; i < ratings.length; i++){
			uniqueRatings.add(ratings[i]);
		}		
		TreeSet<Integer> sortedUniqueRtings = new TreeSet<Integer>(uniqueRatings);

		for (int i = 0; i < ratings.length; i++){
			minNum = minNum + sortedUniqueRtings.headSet(ratings[i]).size() + 1;
		}
		System.out.println("TreeSet : " + sortedUniqueRtings);
		return minNum;
	}

}