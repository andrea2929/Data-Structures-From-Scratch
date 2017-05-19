
public class deque {
	private dequeNode elts;
	private int count = 0; 
	// I know count doesn't matter now that I have isFront in dequeNode, 
	// I just think it is valuable to have the count stored as an integer
	
	public deque() {
		elts = null;
	}
	
	public void insertFront(BSTnode item) {
		if (elts == null) { 
			elts = new dequeNode(item);
			elts.setNext(elts);
			elts.setPrev(elts);
			count++;
		}
		// If there is no pointer value then the array is empty and it will set
		// the new dequeNode to the new first value and setting it as its previous
		// and next while adding 1 to count
		
		else {
			dequeNode temp = new dequeNode(item);
			// Making the new Node as temp
			
			elts.getPrev().setNext(temp);
			temp.setNext(elts);
			temp.setPrev(elts.getPrev());
			elts.setPrev(temp);
			elts = temp;
			count++;
			// Setting up temp as the new front of the dequeNode, giving it the same previous Node as elts,
			// setting elts as its next node, and setting up elts for temp to be its previous node
			// and then finally saving over the path to elts as temp and adding 1 to the count
		}
		
	}
	
	public void insertRear(BSTnode item) {
				if (elts == null) { 
					elts = new dequeNode(item);
					elts.setNext(elts);
					elts.setPrev(elts);
					count++;
				}
				// Same as in insertFront
				
				else {
					dequeNode temp = new dequeNode(item);
					dequeNode prev = elts.getPrev();
					// Setting the new node as temp and setting prev to start as elts
					
					temp.setPrev(prev);
					elts.setPrev(temp);
					temp.setNext(elts);
					prev.setNext(temp);
					count++;
					// Basically just setting the new Node up, putting it as the next Node,
					// setting the previous up as its previous node, and making elts (the first Node)
					// point back to it as its previous and increasing the count by 1
				}
	}
	
	public dequeNode deleteFront() {
		dequeNode removed = elts;
		// After I'm done deleting elts I won't be able to access it so
		// I'm going to store it's value in this
		
		if (elts == null) {
			System.out.println("The deque is empty and so nothing can be deleted");
		}
		// If elts is null then there is nothing to delete and the deque is empty
		
		else if(elts.getNext() == elts) {
			elts.setPrev(null);
			elts.setNext(null);
			elts = null;
			count = 0;
		}
		// I'm looking to see if elts is the only node, which would mean the next node
		// it points to will be itself (set as first). If so, I will delete every reference
		// to and from elts and then make the elts path null and decrease the count to 0
		// (just in case there's some weird error and the count is more than 1)
		
		else {
			dequeNode newFront = elts.getNext();
			newFront.setPrev(elts.getPrev());
			elts.getPrev().setNext(newFront);
			elts.setPrev(null);
			elts.setNext(null);
			removed = elts;
			elts = newFront;
			count--;
			// Sets up the next Node in elts as the new first value and deletes every
			// reference to or from the old elts as well as decreasing the count by 1
		}
		
		return removed;
	}
	
	public int deleteRear() {
		int value = 0;
		// After I'm done deleting elts I won't be able to access it so
		// I'm going to store it's value in this
		
		if (elts == null) {
			System.out.println("The deque is empty and so nothing can be deleted");
		}
		// Same as deleteFront
		
		else if(elts.getNext() == elts) {
			elts.setPrev(null);
			elts.setNext(null);
			elts = null;
			count = 0;
		}
		// Same as deleteFront
		
		else {
			dequeNode prev = elts.getPrev();
			value = prev.getVal();
			// Saved the previous Node as prev just to make the program a little easier
			// could've just done elts.getPrev() everytime I use prev
			
			prev.setNext(null);
			prev.getPrev().setNext(elts);
			elts.setPrev(prev.getPrev());
			prev.setPrev(null);
			count--;
			// Deleted every reference to and from prev, and then took one off the count
		}
		
		return value;
	}
	
	public boolean isempty() {
		return (elts == null);
		// If elts is null I consider it empty
	}
	
	public void printDeque() {
		
		if (elts == null) {
			System.out.println("EMPTY DEQUE");
			// Look at isempty()
		}
		
		else {
			dequeNode current = elts.getNext();
			// Setting current up for the while loop
			
			System.out.println("----- Front -----\n" + elts.getVal());
			while(current != elts) {
				if ((current != null)) {
					System.out.println(current.getVal() + "");
					current = current.getNext();
				}
			}
			System.out.println("----- Rear -----");
			// I printed elts, and then I run a while loop going through each node
		}
	}
}
