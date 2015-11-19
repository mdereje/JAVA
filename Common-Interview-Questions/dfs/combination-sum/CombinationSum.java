import java.util.*;
/*
	Given a set of candidate numbers (C) and a target number (T), 
	find all unique combinations in C where the candidate numbers sums to T. 
	The same repeated number may be chosen from C unlimited number of times.
*/
public class CombinationSum{
	public ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();

	public static void main(String[] args){
		CombinationSum new_list = new CombinationSum();
		ArrayList<Integer> test = new ArrayList<Integer>();
		test.add(2);
		test.add(3);
		test.add(6);
		test.add(7);
		System.out.println(Arrays.toString(test.toArray()));

		//new_list.findSumPath(test, 7);

		System.out.println(Arrays.toString(new_list.combinationSum(new int[]{2,3,6,7}, 7).toArray()));
	}

	//return the first one that adds up to the target number.
/*	public void findSumPath(ArrayList<Integer> candidate, int total){

		findFullCombination(Arrays.sort(candidate), total, 0, new ArrayList<Integer>(), answer);
	}

	public void findFullCombination(ArrayList<Integer> candidate, int total,  int curSum, ArrayList<Integer> cur_candidate, ArrayList<ArrayList<Integer>> answer){
		
		ListIterator<Integer> iter = candidate.listIterator();		
		
		while(iter.hasNext()){		
			//if the map already has the combination advance the iterator.

			if(total < curSum){
				return;
			}
			if(total == curSum && !answer.contains(cur_candidate)){
				answer.add(cur_candidate);
			}			
			cur_candidate.add(iter.next().previous());
			curSum = curSum + iter.next().previous();
			findFullCombination(candidate, total, curSum, cur_candidate, answer)
		}
	}
*/
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
		
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	 
	    if(candidates == null || candidates.length == 0) return result;
	 
	    Arrays.sort(candidates);
	 
	    combinationSum(candidates, target, 0, new ArrayList<Integer>(), result);
	 
	    return result;
	}
 
	public void combinationSum(int[] candidates, int target, int j, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> result){
	   if(target == 0){
	       ArrayList<Integer> temp = new ArrayList<Integer>(curr);
	       result.add(temp);
	       return;
	   }
	 
	   for(int i=j; i<candidates.length; i++){
	       if(target < candidates[i]) 
	            return;
	 
	       curr.add(candidates[i]);
	       combinationSum(candidates, target - candidates[i], i, curr, result);
	       curr.remove(curr.size()-1); 
	   }
	}
}