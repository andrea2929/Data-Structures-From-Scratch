import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DAGdriver {
	
	public static void main( String [ ] args ) throws FileNotFoundException  {
		  Scanner input = new Scanner(System.in);
		  System.out.print("Input your filename:");
		  String filename = input.nextLine();
		  //Setting up a scanner to take an input as a filename
		  
		  filename = "/Users/halenkampa1/Documents/DAG.txt";
		  File file = new File(filename); // Creating a file out of the filename
			
		  if (file.isFile()) { //If the file is real we'll go through the program
			  Scanner filescan = new Scanner(file);
			  
			  int NV = filescan.nextInt();
			  int NE = filescan.nextInt();
			  //Since NV and NE are only input once I don't have them in the loop
			  
			  DAG G = new DAG(NV);
			  //Constructing the graph after to use the numVertices (NV)
			  //Gotten from input
			  
			  for ( int a = 0; a < NE; a++ ) {
				  G.setXY( filescan.nextInt(), filescan.nextInt());
			  } //Adds all the edges
			  
			  G.topologicalSort();
			  
		  }
	}
	
}
