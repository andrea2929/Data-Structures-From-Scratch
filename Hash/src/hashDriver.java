import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class hashDriver {
	static ArrayList<String> commonwords = new ArrayList<String>();
	static int i = 0;
	
	public static void main(String[] args) throws Exception {
		
		//--------FIRST FILEPATH--------//
		
		System.out.print("Choose the first file path: ");
		Scanner input = new Scanner(System.in);
		
		String filename = input.nextLine();
		//filename = "/Users/halenkampa1/Documents/test1.txt";
		//First I prompt the user for a file name and store it in filename

		File file = new File(filename); // Creating a file out of the filename
		
		if (file.isFile()) { // Checking if the file is real
			Scanner filescan = new Scanner(file);
			
			hashTable table = new hashTable(143);
			
			while(filescan.hasNextLine()) {
				String line = filescan.nextLine();
				Scanner linescan = new Scanner(line);
				while(linescan.hasNext()) {
					String word = linescan.next().replaceAll("[^a-zA-Z ]", "").toLowerCase();
					if(table.lookup(word)<0) {
						table.insert(word);
					}
				}
			}
			
			//--------SECOND FILEPATH--------//
			
			System.out.print("Choose the second file path: ");
			
			filename = input.nextLine();
			//filename = "/Users/halenkampa1/Documents/test2.txt";
			
			file = new File(filename); // Creating a file out of the new filename
			
			if (file.isFile()) { // Checking if the file is real
				filescan = new Scanner(file);
				
				while(filescan.hasNextLine()) {
					String line = filescan.nextLine();
					Scanner linescan = new Scanner(line);
					while(linescan.hasNext()) {
						String word = linescan.next().replaceAll("[^a-zA-Z ]", "").toLowerCase();
						if(word.length() >= 3) {
							int foundpos = table.lookup(word);
							if(foundpos >= 0) {
								commonwords.add(word);
								table.markNowEmpty(foundpos);
							}
						}
					}
				}
				
				Collections.sort(commonwords);
				for(int x = 0; x<commonwords.size(); x++) {
					System.out.println(commonwords.get(x));
				}
				//table.print();
			}
			
			else {
				System.out.println("File did not work :(");
			}
			
		}
		
		else {
			System.out.println("File did not work :(");
		}
	}
}
