public class edgeNode {
	private int startVertex;
	private int adjacentVertex;
	private int weight;
	private edgeNode next;
	
	public edgeNode( int X,  int  Y, int W )  {
		  this.startVertex = X;
		  this.adjacentVertex = Y;
		  this.weight = W;
		  this.next = null;
	}
	
	public void setWeight(int w) {
		this.weight = w;
	}
	
	public int getWeight( ) {
		return this.weight;
	}
	
	public void setAdjacentVertex(int y) {
		this.adjacentVertex = y;
	}
	
	public int getAdjacentVertex( ) {
		return this.adjacentVertex;
	}
	
	public edgeNode getNext( ) {
		return this.next;
	}
	
	public void setNext(edgeNode e) {
		this.next = e;
	}
	
	public int getStartVertex( ) {
		return this.startVertex;
	}
	
	public void setStartVertex( int x ) {
		this.startVertex = x;
	}
}
