import java.util.ArrayList;
import java.util.List;

public class TreeTraverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		System.out.println("---------PreOrder----------------");
		new TreeTraverse().preOrder(root);
		System.out.println("\n---------PostOrder----------------");
		new TreeTraverse().postOrder(root);
		System.out.println("\n---------InOrder----------------");
		new TreeTraverse().inOrder(root);
		System.out.println("\n---------BFS----------------");
		new TreeTraverse().bfs(root);
	}

	public void preOrder(TreeNode root) {
		if(root == null)
			return;
		System.out.print(root.val+"->");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public void postOrder(TreeNode root) {
		if(root == null)
			return;		
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.val+"->");
	}

	public void inOrder(TreeNode root) {
		if(root == null)
			return;		
		inOrder(root.left);		
		System.out.print(root.val+"->");
		inOrder(root.right);
	}
	
	public void bfs(TreeNode root) {
		if(root==null)
			return;
		System.out.print(root.val);
		
		List<TreeNode> currLayer = new ArrayList<TreeNode>();
		if(root.left!=null)
			currLayer.add(root.left);
		if(root.right!=null)
			currLayer.add(root.right);
		
		while(!currLayer.isEmpty()) {
			List<TreeNode> nextLayer = new ArrayList<TreeNode>();
			for(TreeNode node : currLayer) {
				System.out.print("->"+node.val);
				if(node.left!=null)
					nextLayer.add(node.left);
				if(node.right!=null)
					nextLayer.add(node.right);
			}
			currLayer = nextLayer;
		}
	}
	
}
