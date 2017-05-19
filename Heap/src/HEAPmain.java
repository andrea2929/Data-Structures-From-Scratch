import java.io.File;
import java.util.Scanner;

public class HEAPmain {

	public static void main(String[] args) throws Exception {
		System.out.print("Choose a file path: ");
		Scanner input = new Scanner(System.in);
		
		
		String filename = input.nextLine();
		//First I prompt the user for a file name and store it in filename

		File file = new File(filename); // Creating a file out of the filename
		if (file.isFile()) { // Checking if the file is real
			Scanner filescan = new Scanner(file);
			// If the file is real I create a while loop with
			// a scanner to go through each command
			HEAP1 heap = new HEAP1();
			while(filescan.hasNext()) {
				int num = Integer.parseInt(filescan.next());
				heap.insert(num);
			}
			
			heap.inorder();
			
		}
		
		else {
			System.out.println("File did not work :(");
		}
	}

}
