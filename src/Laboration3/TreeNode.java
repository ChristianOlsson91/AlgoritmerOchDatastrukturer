package Laboration3;

class TreeNode<T> {
	TreeNode<T> v;
	TreeNode<T> h;
	T data;
	
	public static void main(String[] args) {
		TreeNode<Integer> n = new TreeNode<>();
		n.data = 22;
		n.v = new TreeNode<Integer>();
		n.v.data = 21;
		n.h = new TreeNode<Integer>();
		n.h.data = 20;
	}
}