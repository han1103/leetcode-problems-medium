/*
 * https://leetcode.com/problems/h-index/
*/
package tripadvisor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] citations = new int[] {4,5,16,7,3,1};
		System.out.println(new HIndex().hIndex(citations));
		System.out.println(new HIndex().hIndexFast(citations));
	}

	boolean isHIndex(int[] citations, int h) {
		int counter = 0;
		for(int citation : citations)
			if(citation>=h)
				counter++;
		
		if(counter>=h)
			return true;
		return false;				
	}
	
	public int hIndex(int[] citations) {
		if(citations==null || citations.length==0)
			return 0;
		
		int n = citations.length;
		for(int i=n; i>=1; i--) {
			if(isHIndex(citations, i))
				return i;
		}
		
		return 0;
    }

	public int hIndexFast(int[] citations) {
		if(citations==null || citations.length==0)
			return 0;
		
		int n = citations.length;

		List<Integer> list = new ArrayList<Integer>();
		for(int citation : citations)
			list.add(citation);
		
		Collections.sort(list);
		Collections.reverse(list);
		for(int i=n; i>=1; i--)
			if(list.get(i-1)>=i)
				return i;
		
		return 0;
    }
	
}
