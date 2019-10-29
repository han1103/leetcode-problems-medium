package wayfair;

public class StringCompression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//char[] chars = new char[] {'a','a','b','b','b', 'b', 'b', 'a', 'c','c','c'};
		char[] chars = new char[] {'b', 'b', 'a', 'a', 'a', 'c', 'c', 'a'};
		//char[] chars = new char[] {'b', 'b'};
		new StringCompression().compress(chars);
		System.out.println(chars);
		
		chars = new char[] {'b', 'b', 'a', 'a', 'a', 'c', 'c', 'a'};
		new StringCompression().compressFast(chars);
		System.out.println(chars);
	}
	
	private final char SPECIAL = '0';
	
	int shrink(char[] chars) {
		int shift = 0;
		for(int i=0; i<chars.length; i++) {
			if(chars[i]!=SPECIAL)
				chars[i-shift] = chars[i];
			else
				shift++;				
		}
		for(int i=0; i<shift; i++)
			chars[chars.length-1-i] = ' ';
		
		return shift;
	}
	
	public int compress(char[] chars) {
		if(chars==null)
			return 0;
		if(chars.length<=1)
			return chars.length; 
		char charInCheck = chars[0];
		int startIndex = 0;
		int repeat = 1;
		
        for(int i=1; i<chars.length; i++) {
        	if(chars[i]==charInCheck)
        		repeat++;
        	else {
        		charInCheck = chars[i];
        		if(repeat > 1) {
        			String repeatStr = new Integer(repeat).toString();
        			for(int j=0; j<repeatStr.length(); j++)
        				chars[startIndex+1+j] = repeatStr.charAt(j);
        			for(int j=startIndex+1+repeatStr.length(); j<i; j++)
        				chars[j] = SPECIAL;
        		}
        		repeat = 1;
        		startIndex = i;
        	}
        }
		if(repeat > 1) {
			String repeatStr = new Integer(repeat).toString();
			for(int j=0; j<repeatStr.length(); j++)
				chars[startIndex+1+j] = repeatStr.charAt(j);
			for(int j=startIndex+1+repeatStr.length(); j<chars.length; j++)
				chars[j] = SPECIAL;
		}
		
		return chars.length - shrink(chars);
    }

	public int compressFast(char[] chars) {
		if(chars==null)
			return 0;
		if(chars.length<=1)
			return chars.length; 
		char charInCheck = chars[0];
		int startIndex = 0;
		int repeat = 1;
		int shift = 0;
		
        for(int i=1; i<chars.length; i++) {
        	if(chars[i]==charInCheck)
        		repeat++;
        	else {
        		charInCheck = chars[i];    			
        		if(repeat > 1) {
        			String repeatStr = new Integer(repeat).toString();
        			chars[startIndex-shift] = chars[i-1];
        			for(int j=0; j<repeatStr.length(); j++)
        				chars[startIndex+1+j-shift] = repeatStr.charAt(j);
        			shift+=(repeat-1-repeatStr.length());
/*        			for(int j=startIndex+1+repeatStr.length(); j<i; j++)
        				chars[j] = SPECIAL;
*/        		}
        		else 
        			chars[i-1-shift] = chars[i-1];
        		repeat = 1;
        		startIndex = i;
        	}
        }
		if(repeat > 1) {
			String repeatStr = new Integer(repeat).toString();
			chars[startIndex-shift] = chars[chars.length-1];
			for(int j=0; j<repeatStr.length(); j++)
				chars[startIndex+1+j-shift] = repeatStr.charAt(j);
			shift+=(repeat-1-repeatStr.length());
/*			for(int j=startIndex+1+repeatStr.length(); j<chars.length; j++)
				chars[j] = SPECIAL;
*/		}
		else 
			chars[chars.length-1-shift] = chars[chars.length-1];

		for(int i=0; i<shift; i++)
			chars[chars.length-1-i] = ' ';
		
		return chars.length - shift;
    }
	
}

