
public class DAG {
	private boolean[][] G;
	private int[] inDegree;
	private boolean[] scheduled;
	private int numvertices;
	
	DAG( int N ) {
		G = new boolean[N][N];
		inDegree = new int[N];
		scheduled = new boolean[N];
		numvertices = N;
	}
	
	public void setXY(int X, int Y) {
		G[X][Y] = true;
	}
	
	public void setInDegree() {
		for (int x = 0; x < G.length; x++) {
			int sum = 0;
			for (int y = 0; y < G.length; y++) {
				if (G[y][x])
					sum++;
			}
			inDegree[x] = sum;
		}
	}
	
	public void topologicalSort() {
		setInDegree();
		int numScheduled = 0;
		while ( numScheduled < numvertices) {
			for (int i = 0; i < inDegree.length; i++) {
				if ((inDegree[i] == 0)&&(scheduled[i] != true)) {
					System.out.println(i + "");
					scheduled[i] = true;
					numScheduled++;
					
					for (int x = 0; x < G[i].length; x++) {
						if (G[i][x] == true)
							inDegree[x]-=1;
					}
					
				}
			}
		}
	}
	
}
