package wayfair;

public class TwoSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = new int[] {0,0,1,2};
		int target = 0;
		int[] result = new TwoSumII().twoSum(numbers, target);
	
		for(int num : result)
			System.out.print(num+"\t");
	}

	int binarySearch(int[] numbers, int target, int index) {
		int start = index, end = numbers.length-1;
		if(numbers[start]==target)
			return start;
		if(numbers[start]>target)
			return -1;
		if(numbers[end]<target)
			return -1;
		if(start>=end-1) {
			if(numbers[end]==target)
				return end;
			else
				return -1;
		}
		while(start<end-1) {
			int mid = (start+end)/2;
			if(numbers[mid]==target)
				return mid;
			else if(numbers[mid]<target)
				start = mid;
			else
				end = mid;
		}
		if(numbers[end]==target)
			return end;
		else if(numbers[start]==target)
			return start;
		else
			return -1;	
	}
	
	public int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		
		for(int i=0; i<numbers.length; i++) {
			int found = binarySearch(numbers, target-numbers[i], i+1);
			if(found!=-1) {
				result[0] = i+1;
				result[1]=found+1;
				break;
			}
		}
		
		return result;		
    }
}
