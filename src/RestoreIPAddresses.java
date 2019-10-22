import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/restore-ip-addresses/
*/
public class RestoreIPAddresses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String s = "25525511135";
		//String s = "12311111112";
		String s = "010010";
		List<String> ipList = new RestoreIPAddresses().restoreIpAddresses(s);
		for(String ip : ipList)
			System.out.println(ip);

	}
	
	private boolean validIP(String s) {
		if(s.charAt(0)=='0' && s.length()>1)
			return false;
		if(Integer.parseInt(s)>255)
			return false;
		return true;
	}
	
	public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        
        if(s.length()<4 || s.length()>12)
        	return result;
        
        for(int i1=0, k1=1; k1<=3; k1++) {
        	i1++;
        	String ipPart1 = s.substring(0, i1);
        	if(validIP(ipPart1)) {
        		for(int i2=i1, k2=1; k2<=3; k2++) {
        			i2++;
        			if(i2>=s.length())
        				break;
        			String ipPart2 = s.substring(i1, i2);
        			if(validIP(ipPart2)) {
        				for(int i3=i2, k3=1; k3<=3; k3++) {
        					i3++;
        					if(i3>=s.length())
        						break;
        					String ipPart3 = s.substring(i2, i3);
        					if(validIP(ipPart3)) {
        						if((i3+3)<s.length())
        							continue;
        						String ipPart4 = s.substring(i3);
        						if(validIP(ipPart4)) {
        							result.add(ipPart1+"."+ipPart2+"."+ipPart3+"."+ipPart4);
        						}
        					}
        				}
        			}
        		}
        	}
        }
        return result;        
    }

}
