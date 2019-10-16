/*
 * https://leetcode.com/problems/compare-version-numbers/
*/
public class CompareVersion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new CompareVersion().compareVersion("0.1", "1.1"));
		System.out.println(new CompareVersion().compareVersion("1.01", "1"));
		System.out.println(new CompareVersion().compareVersion("7.5.2.4", "7.5.3"));
		System.out.println(new CompareVersion().compareVersion("1.01", "1.001"));
		System.out.println(new CompareVersion().compareVersion("1.0", "1.0.0"));
	}

	public int compareVersion(String version1, String version2) {
		int result = 0;
		
		String[] ver1 = version1.split("\\.");
		String[] ver2 = version2.split("\\.");

		int minLen = Math.min(ver1.length, ver2.length);
		
		for(int i=0; i<minLen; i++) {
			int ver1Num = Integer.parseInt(ver1[i]);
			int ver2Num = Integer.parseInt(ver2[i]);
			if(ver1Num > ver2Num)
				return 1;
			else if(ver1Num < ver2Num)
				return -1;
		}
		
		String[] ver;
		boolean flagVer1 = false;
		if(ver1.length > minLen) {
			ver = ver1;
			flagVer1 = true;
		}
		else
			ver = ver2;
		
		for(int i=minLen; i<ver.length; i++) {
			int verNum = Integer.parseInt(ver[i]);
			if(verNum > 0)
				return flagVer1?1:-1;
		}

		return result;
	}
}
