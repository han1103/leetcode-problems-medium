package tripadvisor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class TopKFrequent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * int k=2; String[] words = new String[] {"i", "love", "leetcode", "i", "love",
		 * "coding"};
		 */		/*
		 * int k=4; String[] words = new String[] {"the", "day", "is", "sunny", "the",
		 * "the", "the", "sunny", "is", "is"};
		 */
		int k=4;
		String[] words = new String[] {"glarko","zlfiwwb","nsfspyox","pwqvwmlgri","qggx","qrkgmliewc","zskaqzwo","zskaqzwo","ijy","htpvnmozay","jqrlad","ccjel","qrkgmliewc","qkjzgws","fqizrrnmif","jqrlad","nbuorw","qrkgmliewc","htpvnmozay","nftk","glarko","hdemkfr","axyak","hdemkfr","nsfspyox","nsfspyox","qrkgmliewc","nftk","nftk","ccjel","qrkgmliewc","ocgjsu","ijy","glarko","nbuorw","nsfspyox","qkjzgws","qkjzgws","fqizrrnmif","pwqvwmlgri","nftk","qrkgmliewc","jqrlad","nftk","zskaqzwo","glarko","nsfspyox","zlfiwwb","hwlvqgkdbo","htpvnmozay","nsfspyox","zskaqzwo","htpvnmozay","zskaqzwo","nbuorw","qkjzgws","zlfiwwb","pwqvwmlgri","zskaqzwo","qengse","glarko","qkjzgws","pwqvwmlgri","fqizrrnmif","nbuorw","nftk","ijy","hdemkfr","nftk","qkjzgws","jqrlad","nftk","ccjel","qggx","ijy","qengse","nftk","htpvnmozay","qengse","eonrg","qengse","fqizrrnmif","hwlvqgkdbo","qengse","qengse","qggx","qkjzgws","qggx","pwqvwmlgri","htpvnmozay","qrkgmliewc","qengse","fqizrrnmif","qkjzgws","qengse","nftk","htpvnmozay","qggx","zlfiwwb","bwp","ocgjsu","qrkgmliewc","ccjel","hdemkfr","nsfspyox","hdemkfr","qggx","zlfiwwb","nsfspyox","ijy","qkjzgws","fqizrrnmif","qkjzgws","qrkgmliewc","glarko","hdemkfr","pwqvwmlgri"};
		
		List<String> result = new TopKFrequent().topKFrequent(words, k);		
		for(String str : result)
			System.out.print(str+"\t");
		
		System.out.println("\n------------------------------");
		result = new TopKFrequent().topKFrequentFast(words, k);		
		for(String str : result)
			System.out.print(str+"\t");

		System.out.println("\n------------------------------");
		result = new TopKFrequent().topKFrequentAns(words, k);		
		for(String str : result)
			System.out.print(str+"\t");
	
	}

	class Frequency implements Comparable<Frequency> {
		String word;
		int frequency;
		
		public Frequency() {
			
		}
		
		public Frequency(String word, int frequency) {
			// TODO Auto-generated constructor stub
			this.word = word;
			this.frequency = frequency;
		}

		@Override
		public int compareTo(Frequency o) {
			// TODO Auto-generated method stub
			if (this.frequency==o.frequency)
				return this.word.compareTo(o.word);
			else if (this.frequency>o.frequency)
				return -1;
			else
				return 1;
		}			
	}
	
	void append(List<Frequency> picks, String word) {
		Frequency newElem = new Frequency(word, 1);
		for(int i=picks.size()-1; i>=0; i--) {
			if(newElem.compareTo(picks.get(i))>=0) {				
				picks.add(i+1, newElem);
				return;
			}
		}
		picks.add(0, newElem);		
	}

	public List<String> topKFrequentFast(String[] words, int k) {
		List<String> result = new ArrayList<String>(); 
		
		if(words==null || words.length==0 || k==0)
			return result;
				
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		Comparator<String> comparator = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int freq1 = map.get(o1);
				int freq2 = map.get(o2);
				if(freq1 < freq2)
					return -1;
				else if(freq1 > freq2)
					return 1;
				else
					return -1*o1.compareTo(o2);
			}
		};
		
		PriorityQueue<String> heap = new PriorityQueue<String>(comparator);
		
		for(String word : words) {
			int count = 1;
			if(map.containsKey(word))
				count = map.get(word);
			count++;
			map.put(word, count);
		}
		
		for(String word : map.keySet()) {
			heap.add(word);
			if(heap.size()>k)
				heap.remove();			
		}
		
		while(!heap.isEmpty()) {
			result.add(heap.poll());
		}
			
		Collections.reverse(result);
		
		return result;
    }

    public List<String> topKFrequentAns(String[] words, int k) {
        Map<String, Integer> count = new HashMap();
        for (String word: words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> heap = new PriorityQueue<String>(
                (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                w2.compareTo(w1) : count.get(w1) - count.get(w2) );

        for (String word: count.keySet()) {
            heap.offer(word);
            if (heap.size() > k) heap.poll();
        }

        List<String> ans = new ArrayList();
        while (!heap.isEmpty()) ans.add(heap.poll());
        Collections.reverse(ans);
        return ans;
    }
    
	public List<String> topKFrequent(String[] words, int k) {
		List<String> result = new ArrayList<String>(); 
		
		if(words==null || words.length==0 || k==0)
			return result;
				
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for(String word : words) {
			int count = 1;
			if(map.containsKey(word))
				count = map.get(word);
			count++;
			map.put(word, count);
		}
		
		List<Frequency> list = new LinkedList<Frequency>();
		for(Map.Entry<String, Integer> entry: map.entrySet()) {
			list.add(new Frequency(entry.getKey(), entry.getValue()));
		}
		Collections.sort(list);
		
		for(int i=0; i<k; i++)
			result.add(list.get(i).word);
			
		return result;
    }
}

