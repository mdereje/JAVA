import java.util.Arrays;
/*
	You are a professional robber planning to rob houses along a street. 
	Each house has a certain amount of money stashed, the only constraint 
	stopping you from robbing each of them is that adjacent houses have 
	security system connected and it will automatically contact the police 
	if two adjacent houses were broken into on the same night.

	Given a list of non-negative integers representing the amount of money 
	of each house, determine the maximum amount of money you can rob tonight 
	without alerting the police.


*/

public class HouseRobber{


	public static void main(String[] args){
		HouseRobber test = new HouseRobber();

		int[] houses = {50, 10, 13, 50};

		System.out.println(Arrays.toString(houses));
		System.out.println(test.rob(houses));
		System.out.println(test.rob_answer(houses));

	}


	public int rob(int[] houses){		
		if(houses == null || houses.length == 0){
			return 0;
		}		

		int num_houses = houses.length;
		int[] cur_houses = new int[num_houses + 1];
		cur_houses[0] = 0;
		cur_houses[1] = houses[0];

		for(int i=2; i < num_houses+1; i++){
			cur_houses[1] = Math.max(cur_houses[i-1], cur_houses[i-2] + houses[i-1]);
		}

		return cur_houses[num_houses];
	}

	public int rob_answer(int[] num) {
	    if(num==null || num.length==0)
	        return 0;
	 
	    int n = num.length;
	 
	    int[] dp = new int[n+1];
	    dp[0]=0;
	    dp[1]=num[0];
	 
	    for (int i=2; i<n+1; i++){	    	

	       	dp[i] = Math.max(dp[i-1], dp[i-2]+num[i-1]);
	       	System.out.println("temp_array  : " + Arrays.toString(dp) + " i-1: " + (i-1));
    		System.out.println("temp_array  : " + Arrays.toString(dp) + " i-2: " + (i-2));
	    	System.out.println("houses_array: " + Arrays.toString(num) + " i-1: " + (i-1));
	    }
	 
	    return dp[n];
	}
}