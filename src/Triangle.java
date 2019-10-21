import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * https://leetcode.com/problems/triangle/
*/
public class Triangle {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * TreeNode root = new TreeNode(2); root.left = new TreeNode(3);
		 * root.right = new TreeNode(4); TreeNode mid = new TreeNode(5);
		 * root.left.left = new TreeNode(6); root.left.right = mid; root.right.left =
		 * mid; root.right.right = new TreeNode(7); mid = new TreeNode(1);
		 * TreeNode mid2 = new TreeNode(8); root.left.left.left = new
		 * TreeNode(4); root.left.left.right = mid; root.left.right.left = mid;
		 * root.left.right.right = mid2; root.right.right.left = mid2;
		 * root.right.right.right = new TreeNode(3);
		 */		
		//System.out.println(new Triangle().minimumTotalTree(root));
		
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		//1st layer
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		triangle.add(list);
		//2nd layer
		list = new ArrayList<Integer>();
		list.add(3);
		list.add(4);
		triangle.add(list);
		//3rd layer
		list = new ArrayList<Integer>();
		list.add(6);
		list.add(5);
		list.add(7);
		triangle.add(list);
		//4th layer
		list = new ArrayList<Integer>();
		list.add(4);
		list.add(1);
		list.add(8);
		list.add(3);
		triangle.add(list);
		
		System.out.println(new Triangle().minimumTotal(triangle));	
	}

	TreeNode setupTree(List<List<Integer>> triangle) {
		TreeNode root = new TreeNode(triangle.get(0).get(0));
		
		List<TreeNode> preLayerNodes = new ArrayList<TreeNode>();
		preLayerNodes.add(root);
		
		for(int i=1; i<triangle.size(); i++) {
			List<TreeNode> currLayerNodes = new ArrayList<TreeNode>();
			for(Integer num : triangle.get(i))
				currLayerNodes.add(new TreeNode(num));
			
			Iterator<TreeNode> currLayerItr = currLayerNodes.iterator();
			TreeNode currLayerNode = currLayerItr.next();
			for(TreeNode preLayerNode: preLayerNodes) {
				preLayerNode.left = currLayerNode;
				currLayerNode = currLayerItr.next();
				preLayerNode.right = currLayerNode;
			}
			
			preLayerNodes = currLayerNodes;
		}
		
		return root;		
	}
	
	public int minimumTotal(List<List<Integer>> triangle) {
		//TreeNode root = setupTree(triangle);
		
		//return minimumTotalTree(root);
		return minimumTotalDP(triangle);
	}

	public int minimumTotalTree(TreeNode root) {
		return minimumTotalTreeRecursive(root);
	}
	
	int minimumTotalTreeRecursive(TreeNode root) {
		if(root==null)
			return 0;
		root.val += (Math.min(minimumTotalTreeRecursive(root.left), minimumTotalTreeRecursive(root.right)));
		root.left = null;
		root.right = null;
		return root.val;
		
	}
	
	public int minimumTotalDP(List<List<Integer>> triangle) {
		int dim = triangle.size();
		
		int[][] dp = new int[dim][];
		
		dp[dim-1] = new int[dim];
		for(int i=0; i<dim; i++) {			
			dp[dim-1][i] = triangle.get(dim-1).get(i);
		}
		
		for(int i=dim-1; i>=1; i--) {
			dp[i-1] = new int[i];
			for(int j=0; j<i; j++)
				dp[i-1][j] = triangle.get(i-1).get(j)+Math.min(dp[i][j], dp[i][j+1]);
		}
		
		return dp[0][0];
	}
}
