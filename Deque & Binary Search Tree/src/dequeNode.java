
public class dequeNode {
	protected dequeNode next = null;
	protected dequeNode prev = null;
	protected int val;
	protected BSTnode node;
	
	public dequeNode(int v) {
		val = v;
	}
	
	public dequeNode(BSTnode n) {
		node = n;
	}
	
	public BSTnode getNode() {
		return node;
	}
	
	public dequeNode getNext() {
		return next;
	}
	
	public dequeNode getPrev() {
		return prev;
	}
	
	public int getVal() {
		return val;
	}
	
	public void setNext(dequeNode n) {
		next = n;
	}
	
	public void setPrev(dequeNode p) {
		prev = p;
	}
	
}
