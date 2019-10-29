/*
 * https://leetcode.com/problems/n-repeated-element-in-size-2n-array/
*/
package akamai;

import java.util.HashSet;
import java.util.Set;

public class NRepeated {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] A = new int[]{1,2,3,3};
		int[] A = new int[]{5,1,5,2,5,3,5,4};
		
		System.out.println(new NRepeated().repeatedNTimes(A));
	}

	public int repeatedNTimes(int[] A) {
		int n = A.length/2;
		
		Set<Integer> set = new HashSet<>();
		for(int i=0; i<=n+1; i++) {
			if(set.contains(A[i]))
				return A[i];
			else
				set.add(A[i]);
		}
		
		return Integer.MAX_VALUE;
    }
}
