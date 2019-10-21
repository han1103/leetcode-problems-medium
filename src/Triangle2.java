import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * https://leetcode.com/problems/triangle/
*/
public class Triangle2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * TreeNodeSum root = new TreeNodeSum(2); root.left = new TreeNodeSum(3);
		 * root.right = new TreeNodeSum(4); TreeNodeSum mid = new TreeNodeSum(5);
		 * root.left.left = new TreeNodeSum(6); root.left.right = mid; root.right.left =
		 * mid; root.right.right = new TreeNodeSum(7); mid = new TreeNodeSum(1);
		 * TreeNodeSum mid2 = new TreeNodeSum(8); root.left.left.left = new
		 * TreeNodeSum(4); root.left.left.right = mid; root.left.right.left = mid;
		 * root.left.right.right = mid2; root.right.right.left = mid2;
		 * root.right.right.right = new TreeNodeSum(3);
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
		
		System.out.println(new Triangle2().minimumTotal(triangle));	
	}

	public class TreeNodeSum {
		int val;
		int sum;
		TreeNodeSum left;
		TreeNodeSum right;

		TreeNodeSum(int x) {
			val = x;
			sum = Integer.MIN_VALUE;
		}
	}

	TreeNodeSum setupTree(List<List<Integer>> triangle) {
		TreeNodeSum root = new TreeNodeSum(triangle.get(0).get(0));
		
		List<TreeNodeSum> preLayerNodes = new ArrayList<TreeNodeSum>();
		preLayerNodes.add(root);
		
		for(int i=1; i<triangle.size(); i++) {
			List<TreeNodeSum> currLayerNodes = new ArrayList<TreeNodeSum>();
			for(Integer num : triangle.get(i))
				currLayerNodes.add(new TreeNodeSum(num));
			
			Iterator<TreeNodeSum> currLayerItr = currLayerNodes.iterator();
			TreeNodeSum currLayerNode = currLayerItr.next();
			for(TreeNodeSum preLayerNode: preLayerNodes) {
				preLayerNode.left = currLayerNode;
				currLayerNode = currLayerItr.next();
				preLayerNode.right = currLayerNode;
			}
			
			preLayerNodes = currLayerNodes;
		}
		
		return root;		
	}
	
	public int minimumTotal(List<List<Integer>> triangle) {
		TreeNodeSum root = setupTree(triangle);
		
		return minimumTotalTree(root);
	}

	public int minimumTotalTree(TreeNodeSum root) {
		return minimumTotalTreeRecursive(root);
	}
	
	int minimumTotalTreeRecursive(TreeNodeSum root) {
		if(root==null)
			return 0;
		if(root.sum == Integer.MIN_VALUE)
			root.sum = root.val + Math.min(minimumTotalTreeRecursive(root.left), minimumTotalTreeRecursive(root.right));
		return root.sum;
	}
}
