/*
 * https://leetcode.com/problems/combinations/
 */
import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> result = new Combinations().combine(7, 5);
		
		for(List<Integer> list : result) {
			for(int elem : list)
				System.out.print(elem+"->");
			
			System.out.println();
		}
	}
    
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> currResult = new ArrayList<>();
        if(k>n)
        	return currResult;
        else if(k==n) {
        	List<Integer> list = new ArrayList<>();
        	for(int i=1; i<=k; i++)
        		list.add(i);
        	currResult.add(list);
        	return currResult;
        }
        
        List<List<Integer>> result = combineRecursive(n, k, 1, currResult);
        
        return result;
    }
	
	List<Integer> deepCopyList(List<Integer> list) {
		List<Integer> deepCopy = new ArrayList<>();
		for(Integer elem : list)
			deepCopy.add(elem);
		
		return deepCopy;
	}
	
	List<List<Integer>> combineRecursive(int n, int k, int currK, List<List<Integer>> currResult) {
		List<List<Integer>> result = new ArrayList<>();
		
		if(currK>k)
			return currResult;
		
		if(currK==1) {
			for(int i=1; i<=n; i++) {
				List<Integer> list = new ArrayList<>();
				list.add(i);
				result.add(list);				
			}
		}
		else {
			for(List<Integer> list : currResult) {
				int lastNum = list.get(currK-2);
				for(int i=lastNum+1; i<=n; i++) {
					List<Integer> newList = new ArrayList(list);
					newList.add(i);
					result.add(newList);
				}
			}						
		}
		return combineRecursive(n, k, (++currK), result);
			
	}
}
