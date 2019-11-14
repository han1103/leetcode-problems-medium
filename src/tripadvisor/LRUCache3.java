/*
 * https://leetcode.com/problems/lru-cache/
*/
package tripadvisor;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache3 {
	int capacity;
	LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<Integer, Integer>() {
		protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) 
        { 
            return size() > capacity; 
        } 
	};
	
	public LRUCache3(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
		/*
		 * if(cache.containsKey(key)) { int value = cache.get(key); cache.remove(key);
		 * cache.put(key, value); return value; } else return -1;
		 */
    	return cache.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
    	cache.remove(key);
        cache.put(key, value);
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache3 cache = new LRUCache3(2);
		cache.put(2, 1);
		cache.put(1, 1);
		cache.put(2, 3);
		System.out.println(cache.get(1));
		cache.put(4, 1);
		System.out.println(cache.get(1));    
		System.out.println(cache.get(3));
		
	}

}
