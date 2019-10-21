/*
 * https://leetcode.com/problems/summary-ranges/
*/
import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> rangers = new SummaryRanges().summaryRanges(new int[] {-2147483648,-2147483647,2147483647});
		
		for(String range : rangers)
			System.out.println(range);

	}

	public List<String> summaryRanges(int[] nums) {
		List<String> rangers = new ArrayList<String>();

		if(nums==null || nums.length==0)
			return rangers;
		
		int startNum = nums[0];
		int prevNum = startNum;
		
		for(int i=1; i<nums.length; i++) {
			if(nums[i]==prevNum+1)
				prevNum = nums[i];
			else {
				if(startNum==prevNum)
					rangers.add(String.valueOf(startNum));
				else
					rangers.add(String.valueOf(startNum)+"->"+String.valueOf(prevNum));
				startNum = nums[i];
				prevNum = nums[i];
			}
				
		}

		if(startNum==prevNum)
			rangers.add(String.valueOf(startNum));
		else
			rangers.add(String.valueOf(startNum)+"->"+String.valueOf(prevNum));
		
		return rangers;
	}
}
