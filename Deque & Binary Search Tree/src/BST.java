import java.util.Queue;
import java.util.LinkedList;

public class BST {
	protected BSTnode root;

	public BST() {
		root = null;
	}
	
	public void insert(int val) {
		if (root == null) {
			root = new BSTnode(val, 1);
		}
		else
			root.add(val, 2);
	}
	
	public void levelorder() {
		Queue<BSTnode> q = new LinkedList<BSTnode>();
		if (root == null) {
			System.out.print("Empty BST");
		}
		else{
			q.offer(root);
			int l = 1;
			while(q.peek() != null) {
				BSTnode tmp = q.poll();
				if (tmp.getLeft()!=null) {
					q.offer(tmp.getLeft());
				}
				if (tmp.getRight()!=null) {
					q.offer(tmp.getRight());
				}
				if (l < tmp.getLevel()){
					System.out.println();
					l++;
				}
				System.out.print("  " + tmp.getval() + "  ");
			}
		}
	}
	
	public void inorder() {
		if (root == null) {
			System.out.print("Empty BST");
		}
		else
			root.inorder();
	}
	
}
