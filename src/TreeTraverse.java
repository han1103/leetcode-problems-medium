
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
		System.
	}
}
