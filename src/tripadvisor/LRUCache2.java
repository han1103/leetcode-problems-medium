/*
 * https://leetcode.com/problems/lru-cache/
*/
package tripadvisor;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache2 {

	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	int capacity;
	LinkedList<Integer> keyList = new LinkedList<Integer>();
	Map<Integer, Integer> counterMap = new HashMap<Integer, Integer>();
	
	public LRUCache2(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
    	Integer val = map.get(key); 
    	if(val!=null) {
    		//keyList.remove(Integer.valueOf(key));
        	keyList.add(key);
        	counterMap.put(key, counterMap.getOrDefault(key, 0)+1);
    		return val;
    	}
    	else
    		return -1;
    }
    
    public void put(int key, int value) {
    	//keyList.remove(Integer.valueOf(key));
    	counterMap.put(key, counterMap.getOrDefault(key, 0)+1);
    	keyList.add(key);
    	map.put(key, value);
    	if(map.size()>capacity) {
    		while(true) {
    			int head = keyList.remove();
    			int counter = counterMap.get(head);
    			if(counter==1) {
    				map.remove(head);
    				counterMap.remove(head);
    				break;
    			}
    			else
    				counterMap.put(head, --counter);
    		}
    	}
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache2 cache = new LRUCache2(2);
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));       // returns 1
		cache.put(3, 3);    // evicts key 2
		System.out.println(cache.get(2));       // returns -1 (not found)
		cache.put(4, 4);    // evicts key 1
		System.out.println(cache.get(1));       // returns -1 (not found)
		System.out.println(cache.get(3));       // returns 3
		System.out.println(cache.get(4));       // returns 4
		
	}

}
