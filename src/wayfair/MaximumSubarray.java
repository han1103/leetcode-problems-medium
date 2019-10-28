/*
 * https://leetcode.com/problems/maximum-subarray/
*/
package wayfair;

public class MaximumSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] nums = new int[] {2,1,-3,4,-1,2,1,-5,4};
		//int[] nums = new int[] {-3,4,-1,-2,1,-5,4};
		int[] nums = new int[] {-3,-2,-1};
		
		System.out.println(new MaximumSubarray().maxSubArray(nums));
	}

	public int maxSubArray(int[] nums) {
		int currSum = nums[0];
		int maxSum = currSum;
		
		for(int i=1; i<nums.length; i++) {
			if(currSum<=0) {
				currSum=nums[i];
			}
			else
				currSum+=nums[i];
			if(currSum>maxSum)
				maxSum = currSum;
					
		}
		
		return maxSum;
	}
	
    public int maxSubArray1(int[] nums) {
		int max = Integer.MIN_VALUE;
		int sumSoFar = 0;
		
		for(int num : nums) {
			sumSoFar+=num;
			if(sumSoFar > max)
				max = sumSoFar;
			if(sumSoFar<=0)
				sumSoFar = 0;
		}
		
		return max;
    }
}
