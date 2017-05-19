
public class HEAP1 {
	int[] elts = new int[100];
	int count = 0;
	
	public void insert(int val) {
		if (isEmpty()) { // Checking if the heap is empty
			elts[0]=val; // If it is just increment count and put the val in 0 spot
			count++;
		}
		else if (isFull()) // Checking if heap is full
			System.out.print("array is full");
		else { // Otherwise
			elts[count]=val; // Put val at end
			int current = count;
			
			while((current!=0)&&(elts[current]<elts[((current-1)/2)])) {
				int temp = elts[((current-1)/2)];
				elts[((current-1)/2)] = elts[current];
				elts[current] = temp;
				
				current = ((current-1)/2);
			} // Sort the val up for as long as it's smaller than its parent
			count++; // Lastly increment count
			
		}
	}
	
	public void printit() { // Just for my own verification everything's going right
		for (int i = 0; i<count; i++) { // for loop prints array
			System.out.println(elts[i]);
		}
	}
	
	public void inorder() { // Empty's heap and prints everything in order
		for(int i = count; i > 0; i--) {
			System.out.println(deleteMin());
		}
	}
	
	public boolean isEmpty() { // Checks if count is zero
		if (count == 0)
			return true;
		else
			return false;
	}
	
	public boolean isFull() { // Checks if count is 100
		if (count == 100)
			return true;
		else
			return false;
	}
	
	public int deleteMin() {
		int root = 0; // Initialize root in case heap is empty
		if (isEmpty()) { // if Heap is empty there's nothing to delete
			System.out.print("Heap is already empty");
		}
		else {
			root = elts[0]; // Stores number deleted in root
			count--; // subtracts from count
			
			elts[0] = elts[count]; // Puts the bottom right leaf into the root
			
			
			// This is where it gets difficult (a.k.a. I had a lot of trouble and
			// ended up making a long complicated loop)
			int current = 0;
			int sibling1 = ((current+1)*2)-1; // left child
			int sibling2 = ((current+1)*2); // right child
			int half = count/2;
			// Initializing variables for while loop, siblings 1 and 2 are children to the current
			// half is half the count, and current is the position of what is currently at the root
			// that needs to be filtered down the tree
			
			while (((elts[current] > elts[sibling1])||(elts[current] > elts[sibling2]))&&(current<half)) {
				// while the value of the node that needs to be filtered (going to call it current from now on)
				// is less than one of it's siblings AND has at least one sibling this function will
				// use if statements to check if it needs to switch places
				sibling1 = ((current+1)*2)-1;
				sibling2 = ((current+1)*2);
				// Updates sibling locations
				
				if(sibling2>count) { // Checks if current as a right child
					if (elts[sibling1]<elts[current]) { 
						// If the right child is less than current it'll switch them
						int tmp = elts[current];
						elts[current] = elts[sibling1];
						elts[sibling1] = tmp;
						
						current = sibling1; 
						// Updates current's location (I could just put 100 or something because
						// it has to end here
					}
				}
				else if ((elts[current] > elts[sibling1])&&(elts[sibling1]<elts[sibling2])) {
					// If it's sibling1 (the left child) that's lower than current, and it's the lower of
					// the two children then I switch current and sibling1
					int tmp = elts[current];
					elts[current] = elts[sibling1];
					elts[sibling1] = tmp;
					
					current = sibling1;
				}
				else {
					// Otherwise, due to all the previous conditions being false, there's only one option
					// sibling2 is lower than current AND it's lower than sibling1 I switch current and sibling2
					int tmp = elts[current];
					elts[current] = elts[sibling2];
					elts[sibling2] = tmp;
					
					current = sibling2;
				}
			}
			
		}
		
		return root; // Return the value that was deleted from the root
	}
	
}
