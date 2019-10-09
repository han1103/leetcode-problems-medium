import java.util.Stack;

/*
 * https://leetcode.com/problems/simplify-path/
*/
public class SimplifyPath {

	public static void main(String[] args) {
		String path = "/a//b////c/d//././/.."; //"/home//../hshshn/./../h1/h2/h3/";
		//String path = "/a//b///c/d/";
		System.out.println(new SimplifyPath().simplifyPath(path));
	}
	
	public String simplifyPath(String path) {
		String[] elems = path.split("/");
		Stack<String> pathStack = new Stack<>();
		for(String elem : elems) {
			if (elem!=null && !elem.isEmpty() && !elem.equals(".")) {
				if(elem.equals("..")) {
					if(!pathStack.isEmpty())
						pathStack.pop();
				}
				else 
					pathStack.push(elem);
			}
		}
		
		StringBuffer simplifiedPath = new StringBuffer("");
		
		for(String item: pathStack)
			simplifiedPath.append("/"+item);
		if(pathStack.isEmpty())
			simplifiedPath.append("/");
		
		return simplifiedPath.toString();        
	}
}
