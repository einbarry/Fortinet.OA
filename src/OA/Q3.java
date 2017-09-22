package OA;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*This is a Np-Hard problem, I could not find a solution with polynomial time.
My approach is : 1, find all the subset of this list, whose sum is equal to List_sum divid by k, store it in the res
					subset stores index of int in list instead of its value
				 2, among the res, find whether there exists a subset of res, which contains k elements and those elements 
				 	do not have duplicated numbers in the original list.*/

/*Time complexity : O(4^n) | the getAllSubSet funtion worse case call 2^n times, so it has O(2^n), worse case has 2^n subset.
							 so for the findPossibleSubSet funtion the total hight of the tree is 2^n, so total is 2 ^ (2 ^n) = 4 ^ n
Space complexity: O(4^n) | the height of the tree*/
							 


public class Q3 {
	public static boolean separate(List<Integer> list, int k) {
		if(list == null || list.size() < 1) return false;
		List<List<Integer>> res = new ArrayList<>();
		// get the sum of original list
		int sum = getSum(list); 
		// if reminder do not equal to 0, return false
		if(sum % k != 0) return false; 
		// find all the subset of list whose sum equals to sum / k
		getAllSubSet(list, 0, 0, sum / k, res, new ArrayList<Integer>()); 
		// whether there exists a subset in res , contains k elements and those elements do not have duplicated numbers in the original list.
		return findPossibleSubSet(res ,0,list.size(), new HashSet<Integer>()); 
	}
	
	static int getSum(List<Integer> list) {
		int sum = 0;
		for(int i : list) {
			sum += i;
		}
		return sum;
	}
	
	
	/**
     * Get all the subset of input list, whose sum equals to target
     * By using dfs, level n represents that we now consider to choose the nth element in the list.
     * 
     * @param  input  the original list
     * 		   index  index of cur element in the list
     * 		   sum    the total sum from root node to curren node
     * 		   target equals to the sum of original list divided by k
     * 		   res    the list contains all the subset	
     * 		   cur    the list contains the subset on current path
     */
	private static void getAllSubSet(List<Integer> input, int index, int sum, 
									int target, List<List<Integer>> res, List<Integer> cur) {
		if(sum > target) return;
		if(index == input.size()) {
			if(sum == target) res.add(new ArrayList<>(cur));
			return;
		}
		
		
			cur.add(index);
			getAllSubSet(input, index + 1, sum + input.get(index),target, res, cur);
			cur.remove(cur.size() - 1);
			getAllSubSet(input, index + 1, sum ,target, res, cur);
		
		
	}
	
	/**
     * Using DFS to search, whether there exist a subset of res, 
     * which contains k elements and those elements do not have duplicated numbers in the original list.
     * 
     * the height of the tree is K, every node can split to branch, which represents whether we choose cur elements
     * in the res indexed by level index 
     * 
     * @param  res    the list contains all the subset	
     * 		   index  index of cur element in the res
     * 		   size   the total length of the original list
     * 		   target equals to the sum of original list divided by k
     * 		   set    store the elements from the original list	by their index
     */
	private static boolean findPossibleSubSet(List<List<Integer>> res, int index, 
												int size, Set<Integer> set) {
		if(index == res.size()) {
			if(set.size() == size) {
				return true;
			} else {
				return false;
			}
		}
		
		List<Integer> cur_list = res.get(index);
		boolean pick = false;
		if(!isDup(cur_list, set)) {
			inset(cur_list,set);
			pick = findPossibleSubSet(res, index + 1, size, set);
			if (pick == true) return true;
			remove(cur_list, set);
		}
		boolean notPick = findPossibleSubSet(res, index + 1, size,  set);
		
		return pick || notPick;
	}
	
	private static boolean isDup(List<Integer> cur, Set<Integer> set) {
		for(int i : cur) {
			if(set.contains(i)) return true;
		}
		return false;
	}
	
	private static void inset (List<Integer> cur, Set<Integer> set) {
		for(int i : cur) {
			set.add(i);
		}
	}
	private static void remove(List<Integer> cur, Set<Integer> set) {
		for(int i : cur) {
			set.remove(i);
		}
	}
}
