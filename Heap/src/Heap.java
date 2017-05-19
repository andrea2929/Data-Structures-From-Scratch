
public class Heap {
	int[] elts = new int[100];
	int count = 0;
	
	public void insert(int val) {
		if (count == 0) {
			elts[0] = val;
			count++;
		}
		else if (count == 100) {
			System.out.print("Heap is full");
		}
		else {
			elts[count] = val;
			count++;
		
			filter(count);
		}
	}
	
	public void filter(int current) {
		int parent = (current%2==0)?(current-1)/2:(current/2)-1;
		if (elts[current-1] < elts[parent]) {
			int temp = elts[parent];
			elts[parent] = elts[current-1];
			elts[current-1] = temp;
			
			if (parent>0) filter(parent+1);
		}
	}
	
	public void printit() { // For my own reference
		for (int i = 0; i<100; i++) {
			System.out.println(elts[i]);
		}
	}
	
	public void printinor() {
		int[] store = elts;
		for (int i = count; i>0; i++) {
			System.out.print(deleteMin());
		}
		elts = store;
	}
	
	public boolean isEmpty() {
		if (count == 0)
			return true;
		else
			return false;
	}
	
	public boolean isFull() {
		if (count == 100)
			return true;
		else
			return false;
	}
	
	public int deleteMin() {
		int root = 0;
		
		if(count>0) {
			root = elts[0];
			count--;
			
			if(!isEmpty()){
				elts[0] = elts[count];
				sort(0);
			}
		}
		
		return root;
	}
	
	public void sort(int current) {
		int sibling1 = ((current+1)*2)-1;
		int sibling2= ((current+1)*2);
		
		if ((elts[sibling1] < elts[sibling2])&&(elts[sibling1]<elts[current])) {
			int tmp = elts[sibling1];
			elts[sibling1] = elts[current];
			elts[current] = tmp;
			if(((sibling1+1)*2) < count)
				sort(sibling1);
		}
		else if (elts[sibling2]<elts[current]) {
			int tmp = elts[sibling2];
			elts[sibling2] = elts[current];
			elts[current] = tmp;
			if(((sibling2+1)*2) < count)
				sort(sibling2);
		}
	}
}
