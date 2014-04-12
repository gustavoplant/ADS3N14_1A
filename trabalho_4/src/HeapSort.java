public class HeapSort {
	
	static int[] nrosArr = new int[80];
	static int comp = 0;
	static int trocas = 0;
	
	public HeapSort (int[] aux){
		HeapSort.nrosArr = aux;
	}
	
	public int [] sort(){
		
		buildMaxHeap(nrosArr);
		int n = nrosArr.length;
 
		for (int i = nrosArr.length - 1; i > 0; i--){
			swap(nrosArr, i , 0);
			maxHeapify(nrosArr, 0, --n);
		}
         
		return nrosArr;
	}
	
	private  void buildMaxHeap(int[] nrosArr){
		for (int i = nrosArr.length/2 - 1; i >= 0; i--)
			maxHeapify(nrosArr, i , nrosArr. length );
	}
	
	private  void maxHeapify(int[] nrosArr, int pos, int n){
		
		int max;
		int l = 2 * pos + 1;
		int right = 2 * pos + 2;
		comp++;
		if ( (l < n) && (nrosArr[l] > nrosArr[pos]) ){
             max = l;
		}
		else{
			max = pos;
		}
		comp++;
		if (right < n && nrosArr[right] > nrosArr[max]){
			max = right;
		}
		if (max != pos){
			swap(nrosArr, pos, max);
			maxHeapify(nrosArr, max, n);
		}
	}
 
	public  void swap ( int[ ] nrosArr, int j, int aposJ ){
		trocas++;
		int aux = nrosArr [ j ];
		nrosArr [ j ] = nrosArr [ aposJ ];
		nrosArr [ aposJ ] = aux;
	}
}