import java.util.*;

public class mcstGraph {
	private edgeNode[] edgeList;
	private int numVertices;
	
	
	public mcstGraph(int N) {
		this.edgeList = new edgeNode[N];
		this.numVertices = N;
		//Establishing edgeList and numVertices
		
		for(int i = 0; i<N; i++) {
			edgeList[i] = new edgeNode(i,-1,0);
		}
		// Creating dummy variables in the edgeList array

	}
	
	public int PrimsAlg() {
		int totalCost = 0;
		//TotalCost starts at 0
		
		Set<Integer> unvisited = new HashSet<Integer>(numVertices);
		for (int x = 1; x < numVertices; x++) {
			unvisited.add(x);
		}
		//Creating the first set of unvisited, and adding all the nodes but the first
		//Since we start at the first
		
		Set<Integer> visited = new HashSet<Integer>(numVertices);
		visited.add(0);
		//Visited set will start with only the first node because we start at it
		
		Set<edgeNode> currentEdges = new HashSet<edgeNode>(numVertices*numVertices);
		//A list of all the edges that could be linked to at each point and time
		//Will be populated and cleared as things change
		
		while (!unvisited.isEmpty()) {
			for(int v: visited) {
				edgeNode vNode = edgeList[v];
				while (vNode.getNext() != null) {
					edgeNode x = vNode.getNext();
					if(unvisited.contains(x.getAdjacentVertex()))
							currentEdges.add(x);
					vNode = vNode.getNext();
				}
			}
			//In this for loop we go over each visited node's connected edges
			
			int lowestEdgeCost = Integer.MAX_VALUE;
			edgeNode lowestEdge = null;
			//Establishing variables to find the edge with the smallest weight
			
			for (edgeNode E: currentEdges) {
				if(E.getWeight() < lowestEdgeCost) {
					lowestEdge = E;
					lowestEdgeCost = E.getWeight();
				}
			}
			//For loop that finds the edge with the smallest weight out of the currentEdges
			
			System.out.println(lowestEdge.getStartVertex() + " ---- " + lowestEdge.getAdjacentVertex() + " == " + lowestEdge.getWeight());
			
			totalCost = totalCost + lowestEdge.getWeight();
			currentEdges.clear();
			visited.add(lowestEdge.getAdjacentVertex());
			unvisited.remove(lowestEdge.getAdjacentVertex());
			//Adds the weight to total cost and moves nodes from unvisited to visited
			//Clears the currentEdges for next run
		}
		
		return totalCost;
	}
	
	public void insert (int X, int Y, int W) {
		edgeNode edge =  new edgeNode( X, Y , W );
		edge.setNext(edgeList[X].getNext( ));
		edgeList[ X ].setNext(edge);
		
		edge = new edgeNode( Y, X , W );
		edge.setNext( edgeList[Y].getNext( ) );
		edgeList[ Y ].setNext(edge);
		
		//Insets edge for both nodes in the edgeList
	}
	
	public int getNumVertices() {
		return this.numVertices;
	}
	
	public void printGraph() {
		for (edgeNode i: edgeList) {
			edgeNode x = i;
			while (x.getNext() != null) {
				x = x.getNext();
				System.out.println(x.getStartVertex() + " ---- " + x.getAdjacentVertex() + " = " + x.getWeight());
			}
		}
	}
}
