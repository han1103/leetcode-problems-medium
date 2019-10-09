/*
 * https://leetcode.com/problems/gas-station/
*/
public class GasStation {
	public static void main(String[] args) {
		System.out.println(new GasStation().canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
		System.out.println(new GasStation().canCompleteCircuitFast(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
		System.out.println(new GasStation().canCompleteCircuitSelfFast(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
	}
	public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i=0; i<gas.length; i++)
        	if(gas[i]>=cost[i] && canComplete(i, gas, cost))
        		return i;
        
        return -1;
    }
	
	boolean canComplete(int index, int[] gas, int[] cost) {
		int gasInTank = 0;
		for(int i=0; i<gas.length; i++) {
			int currIndex = (index+i)%gas.length;
			gasInTank+=(gas[currIndex]-cost[currIndex]);
			if(gasInTank<0)
				return false;
			
		}
		return true;
	}
	
	public int canCompleteCircuitSelfFast(int[] gas, int[] cost) {
		int accumulate = 0;
		int accumulateFromIndex = 0;
		int index = -1;
		
		for(int i=0; i<gas.length; i++) {
			accumulate+=(gas[i]-cost[i]);
			if(accumulate<accumulateFromIndex) {
				index = -1;
				accumulateFromIndex = accumulate;
			}
			else if(index==-1)
				index = i;
		}
		
		if(accumulate>=0)
			return index;
		else
			return -1;
	}
	
	public int canCompleteCircuitFast(int[] gas, int[] cost) {
        int minCostDiff = 0, totalCostDiff = 0, index = -1;
        for(int i=0; i<gas.length; i++){
            totalCostDiff += (gas[i] - cost[i]);
            if(totalCostDiff < minCostDiff){
                minCostDiff = totalCostDiff;
                index = -1;
            }
            else if(index == -1) index = i;
        }
        return totalCostDiff < 0 ? -1 : index;
    }
}
