import java.io.File;
import java.util.Scanner;

public class BSTmain{
	protected static BST bst= new BST();
	// Variable to store the binary search tree
	
	public static void main(String [ ] args) throws Exception{
		System.out.print("Choose a file path: ");
		Scanner input = new Scanner(System.in);
		String filename = input.nextLine();
		//First I prompt the user for a file name and store it in filename

		File file = new File(filename); // Creating a file out of the filename
		if (file.isFile()) { // Checking if the file is real
			Scanner filescan = new Scanner(file);
			// If the file is real I create a while loop with
			// a scanner to go through each command
			while(filescan.hasNext()) {
				int num = Integer.parseInt(filescan.next());
				bst.insert(num);
			}
			
			System.out.println("LEVEL ORDER TRAVERSAL\n");
			bst.levelorder();
			
			System.out.println("\n\n\nINORDER TRAVERSAL\n");
			bst.inorder();
		}
		
		else {
			System.out.println("File did not work :(");
		}
	}
}
