package tripadvisor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WordBreak {

	boolean[] notWork;

	boolean wordBreakRec(String s, List<String> wordDict, int index) {
		if (notWork[index])
			return false;
		for (String word : wordDict) {
			if (s.startsWith(word)) {
				if (s.length() == word.length()
						|| wordBreakRec(s.substring(word.length()), wordDict, index + word.length()))
					return true;
			}
		}

		notWork[index] = true;

		return false;
	}

	boolean wordBreak(String s, List<String> wordDict) {
		if (s == null || s.length() == 0)
			return false;

		notWork = new boolean[s.length()];

		return wordBreakRec(s, wordDict, 0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "leetcode";
		String[] wordArray = new String[] { "leet", "code" };
		List<String> wordDict = Arrays.asList(wordArray);
		System.out.println(new WordBreak().wordBreak(s, wordDict));
	}

}
