public class hashTable {
	private int tableSize;
	private String[] table;
	
	public hashTable(int size) {
		table = new String[size];
		tableSize = size;
	}
	
	public int hashFunc(String word) {
		char[] ch = word.toCharArray();
		int length = word.length();
		int sum, i;
		for(sum=0,i=0;i<length;i++) {
			sum+=ch[i];
		}
		return sum % tableSize;
	}
	
	int lookup(String x) {
		int hash = hashFunc(x);
		
		if(table[hash] == null)
			return -1;
		else if (table[hash].equals(x))
			return hash;
		else if (!table[hash].equals(x)) {
			int i = 1;
			int n = (hash + i*i) % tableSize;
			while((table[n]!=null)) {
				if(table[n].equals(x))
					return n;
				
				i++;
				n = (hash + i*i) % tableSize;
			}
			return -1;
		}
		else
			return -1;
	}
	
	void markNowEmpty(int i) {
		table[i] = "####";
	}
	
	void insert(String x) {
		int hash = hashFunc(x);
		if(table[hash] != null && table[hash] != "####") {
			int i = 1;
			int n = (hash + i*i) % tableSize;
			while (table[n] != null) {
				i++;
				n = (hash + i*i) % tableSize;
			}
			table[n] = x;
		}
		else {
			table[hash] = x;
		}
	}
	
	void print() {
		for (int i = 0; i<tableSize; i++) {
			System.out.println(table[i]);
		}
	}
	
}
