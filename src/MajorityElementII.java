/*
 * https://leetcode.com/problems/majority-element-ii/
*/
import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
	public static void main(String[] args) {
		List<Integer> result = new MajorityElementII().majorityElement(new int[] {3,2,3});		
		for(int num: result)
			System.out.print(num+"->");
		
		System.out.println("\n-------------------------------");
		result = new MajorityElementII().majorityElement(new int[] {1,1,1,3,3,2,2,2});		
		for(int num: result)
			System.out.print(num+"->");
	}
	
	public List<Integer> majorityElement(int[] nums) {
        int vote1=0, maj1=0; 
        int vote2=0, maj2=0;
        for(int n : nums) {
        	if(maj1 == n) {
        		vote1++;
        	}
        	else if(maj2 == n) {
        		vote2++;
        	}
        	else if(vote1 == 0) {
                vote1++; 
                maj1 = n; 
            } else if(vote2 == 0) {
            	vote2++;
            	maj2 = n;
            }
            else {
            	vote1--;
            	vote2--;
            }  
        }
        
        int counter1 = 0, counter2 = 0; 
        
        for(int num : nums) {
        	if(num==maj1) counter1++;
        	if(num==maj2) counter2++;
        }
        
        List<Integer> result = new ArrayList<Integer>();
        
        if(counter1 > nums.length/3)
        	result.add(maj1);
        if(maj2!=maj1 && counter2 > nums.length/3)
        	result.add(maj2);
        
        return result;
        
    }

}
