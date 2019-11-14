/*
 * https://leetcode.com/problems/lru-cache/
*/
package tripadvisor;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache4  extends LinkedHashMap<Integer, Integer>{
    private int capacity;
    
    public LRUCache4(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity; 
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache4 cache = new LRUCache4(2);
		cache.put(2, 1);
		cache.put(1, 1);
		cache.put(2, 3);
		cache.put(4, 1);
		System.out.println(cache.get(1));    
		System.out.println(cache.get(2));
		
	}

}
