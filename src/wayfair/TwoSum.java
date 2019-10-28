/*
 * https://leetcode.com/problems/two-sum/submissions/
*/
package wayfair;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {2, 7, 11, 15};
		int target = 9;
		
		int[] result = new TwoSum().twoSum(nums, target);
		
		for(int num : result)
			System.out.print(num+"\t");
	}

	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		for(int i=0; i<nums.length; i++)
			for(int j=i+1; j<nums.length; j++)
				if(nums[i]+nums[j]==target) {
					result[0]=i;
					result[1]=j;
				}
					
		
		return result;
    }

	public int[] twoSumHash(int[] nums, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<nums.length; i++) {
			map.put(nums[i], i);
		}
		
		for(int i=0; i<nums.length; i++) {
			if(map.containsKey(target-nums[i])) {
				int j = map.get(target-nums[i]);
				if(i!=j) {
					result[0] = i;
					result[1] = j;
					break;
				}
			}
				
		}
		
		return result;
    }
}
