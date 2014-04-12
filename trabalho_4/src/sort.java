
public class sort {


	public static void main(String[] args) {
		
		int qtdNros = 50;
		
		
		methods objM = new methods();
		
		int[] nrosDes = new int[qtdNros];
		int[] nrosOrdIns = new int[qtdNros];
		int[] nrosOrdHeap = new int[qtdNros];
		
		nrosDes= objM.genList(qtdNros);
		
		int [] tmp = new int [] {0,1,2,3,4,5,6,7,8,9};
		
		nrosDes = tmp;
		
		InsertSort objIS = new InsertSort();
		
		System.out.println("*** ARRAY ORIGINAL DESORDENADO ***");
		objM.printArr(nrosDes);
		System.out.print("\n\n");
				
		System.out.println("--> ORDENADO POR INSERT SORT <--");
		nrosOrdIns = objIS.Sort(nrosDes);
		objM.printArr(nrosOrdIns);
		System.out.println(objIS.comp + " comparações foram executadas");
		System.out.println(objIS.trocas + " trocas foram executadas");
		System.out.print("\n\n");
		
		
		System.out.println("--> ORDENADO POR HEAP SORT <--");
		HeapSort objHS = new HeapSort(nrosDes);
		nrosOrdHeap = objHS.sort();
		objM.printArr(nrosOrdHeap);
		System.out.println(objHS.comp + " comparações foram executadas");
		System.out.println(objHS.trocas + " trocas foram executadas");
		
	}
	


}
