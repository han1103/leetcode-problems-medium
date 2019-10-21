/*
 * https://leetcode.com/problems/majority-element/
*/	
public class MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new MajorityElement().majorityElement(new int[] {1,2,3,1}));
	}

    public int majorityElement(int[] nums) {
        int vote=0, maj=0; 
        for(int n : nums) {
            if(vote == 0) {
                vote++; 
                maj = n; 
            } else {
                vote += (maj == n) ? 1 : -1; 
            }  
        }
        return maj;
    }
}
