/*
 * https://leetcode.com/problems/longest-palindromic-substring/
*/
package tripadvisor;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new LongestPalindromicSubstring().longestPalindrome("cbhhhhhbd"));
		System.out.println(new LongestPalindromicSubstring().longestPalindromeCenter("ccd"));
	}

	boolean isPaindrom(String s) {
		for(int i=0; i<s.length()/2; i++) {
			if(s.charAt(i)!=s.charAt(s.length()-1-i))
				return false;
		}
		return true;
	}
	
	String longestFromIndex(String s, int index) {
		String result = "";
		
		for(int i=s.length(); i>index; i--) {
			String str = s.substring(index, i);
			if(isPaindrom(str)) {
				result = str;
				break;
			}
		}
		
		return result;
	}
	
	public String longestPalindrome(String s) {
		if(s==null || s.length()==0 ||s.length()==1)
			return s;
		
		String result = "";
		
		for(int i=0; i<s.length()-1; i++) {
			String str = longestFromIndex(s, i);
			if(str.length()>result.length())
				result = str;
		}
		
		return result;
    }

	public String longest1Center(String s, int index) {
		int start=index, end=index;
		while(start>=0 && end<s.length())
		{
			if(s.charAt(start)!=s.charAt(end))
				break;
			start--;
			end++;
		} 
		start++;
		end--;
		return s.substring(start, end+1);
	}
	
	public String longest2Center(String s, int index) {
		if(s.charAt(index)!=s.charAt(index+1))
			return "";
		
		int start=index, end=index+1;
		while(start>=0 && end<s.length())
		{
			if(s.charAt(start)!=s.charAt(end))
				break;
			start--;
			end++;
		} 
		start++;
		end--;
		return s.substring(start, end+1);
	}
	
	public String longestPalindromeCenter(String s) {
		if(s==null || s.length()==0 ||s.length()==1)
			return s;
		if(s.length()==2) {
			if(s.charAt(0)==s.charAt(1))
				return s;
			else
				return s.substring(0,1);
		}
		
		String result = "";
		
		for(int i=0; i<s.length()-1; i++) {
			String str = longest1Center(s, i);
			if(str.length() > result.length())
				result = str;
			str = longest2Center(s, i);
			if(str.length() > result.length())
				result = str;
		}
		
		return result;
    }

}
