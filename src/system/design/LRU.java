package system.design;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LRU {
	int cacheSize;
	Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
	Queue<Integer> keyQueue = new LinkedList<Integer>();
	
	public LRU(int cacheSize) {
		this.cacheSize = cacheSize;		
	}
	
	public int get(int key) {
		if(cache.containsKey(key)) {
			keyQueue.remove(key);
			keyQueue.add(key);
			return cache.get(key);
		}
		else {
			cache.put(key, key);
			keyQueue.add(key);
			if(keyQueue.size()>cacheSize) {
				int removingKey = keyQueue.remove();
				cache.remove(removingKey);
				System.out.println("Removing " + removingKey);
			}
			return key;
		}
	}
	
	public static void main(String[] args) {
		LRU lru = new LRU(2);
		
		lru.get(1);
		lru.get(2);
		lru.get(1);
		lru.get(3);
		lru.get(3);
		lru.get(2);
	}
}
