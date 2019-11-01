/*
 * https://leetcode.com/problems/maximum-number-of-balloons/
*/
package wayfair;

import java.util.HashMap;
import java.util.Map;

public class MaxNumBalloons {
	int numOfBalllons(Map<Character, Integer> map) {
		int num = map.getOrDefault('b', 0);
		if(num==0)
			return 0;
		num = Math.min(map.getOrDefault('a', 0), num);
		if(num==0)
			return 0;
		num = Math.min(map.getOrDefault('l', 0)/2, num);
		if(num==0)
			return 0;
		num = Math.min(map.getOrDefault('o', 0)/2, num);
		if(num==0)
			return 0;
		num = Math.min(map.getOrDefault('n', 0), num);
		if(num==0)
			return 0;
						
		return num;
	}
	public int maxNumberOfBalloons(String text) {
		if(text==null || text.length()<6)
			return 0;
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(int i=0; i<text.length(); i++) {
			char c = text.charAt(i);
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		
		return numOfBalllons(map);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new MaxNumBalloons().maxNumberOfBalloons("nlaebolko"));
		System.out.println(new MaxNumBalloons().maxNumberOfBalloons("loonbalxballpoon"));
		System.out.println(new MaxNumBalloons().maxNumberOfBalloons("leetcode"));
	}

}
