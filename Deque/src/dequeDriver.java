import java.io.File;
import java.util.Scanner;

public class dequeDriver{
	protected static deque dq= new deque();
	// Variable to store the deque
	
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
				String command = filescan.next();

				//I store the command in a variable for my if statements
				
				// System.out.println(command); TEST OUTPUT
				
				if (command.equalsIgnoreCase("IF")) {
					dq.insertFront(Integer.parseInt(filescan.next()));
				}
				else if (command.equalsIgnoreCase("IR")) {
					dq.insertRear(Integer.parseInt(filescan.next()));
				}
				else if (command.equalsIgnoreCase("PR")) {
					dq.printDeque();
				}
				else if (command.equalsIgnoreCase("DR")) {
					dq.deleteRear();
				}
				else if (command.equalsIgnoreCase("DF")) {
					dq.deleteFront();
				}
				else {
					System.out.println("That command is not recognized: " + command);
				}
				// I used equalsIgnoreCase so that I wouldn't have to worry about case sensitivity
				// and the else makes sure there's a prompt when the command isn't something I'm
				// checking for
				
				// dq.printDeque(); TEST OUTPUT
			}
		}
		
		else {
			System.out.println("File did not work :(");
		}
	}
}
