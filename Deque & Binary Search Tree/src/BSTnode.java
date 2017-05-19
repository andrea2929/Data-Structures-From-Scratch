
public class BSTnode {

	protected int val;
	BSTnode left;
	BSTnode right;
	int level;
	
	public BSTnode(int newVal, int lev) {
		val = newVal;
		level = lev;
		left = null;
		right = null;
	}
	
	public void add(int newVal, int lev) {
		if (this.val>newVal) {
			if (this.getLeft() == null) {
				setLeft(new BSTnode(newVal, lev));
			}
			else {
				this.getLeft().add(newVal, lev+1);
			}
		}
		else if (this.val<newVal) {
			if (this.getRight() == null) {
				setRight(new BSTnode(newVal, lev));
			}
			else {
				this.getRight().add(newVal, lev+1);
			}
		}
		else {
			System.out.print("The value: " + newVal + " already exists in the BST at level " + level);
		}
	}
	
	public void inorder() {
		if (getLeft() != null) {
			getLeft().inorder();
		}
		System.out.println(this.val);
		if (getRight() != null) {
			getRight().inorder();
		}
	}
	
	//Getters and setters; made them all just in case
	public void setLeft(BSTnode a) {
		left = a;
	}
	
	public void setRight(BSTnode b) {
		right = b;
	}
	
	public void getLevel(int lev) {
		level = lev;
	}
	
	public void getval(int v) {
		val = v;
	}
	
	public BSTnode getLeft() {
		return left;
	}
	
	public BSTnode getRight() {
		return right;
	}
	
	public int getLevel() {
		return level;
	}
	
	public int getval() {
		return val;
	}
	
}
