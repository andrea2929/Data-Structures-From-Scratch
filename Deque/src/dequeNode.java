
public class dequeNode {
	protected dequeNode next = null;
	protected dequeNode prev = null;
	protected int val;
	
	public dequeNode(int v) {
		val = v;
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
