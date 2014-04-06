
public class sort {


	public static void main(String[] args) {
		
		/*
		int qtdNros = 8;
		
		
		int [] nros = new int[qtdNros];
		int [] nros2 = new int[qtdNros + 1];
		
		methods objMethods = new methods();
		
		nros = objMethods.genList(qtdNros);
		
		System.out.println("Array Original:");
		
		for (int i = 0; i < nros.length;i++){
			System.out.print(nros[i] + " ");
		}
		
		nros2 = objMethods.insertSort(nros);
		
		System.out.println("\n\nArray ordenado:");
		
		for (int i = 0; i < nros2.length - 1;i++){
			System.out.print(nros2[i] + " ");
		}
		
		
		System.out.println("\n\nTotal de iteracoes: " + nros2[nros2.length - 1]);
		*/
		
		int [] nros = {6,5,3,1,8,7,2,4};

		int [] nros2 = new int[nros.length];
		
		HeapSort objHP = new HeapSort(nros);
		
		nros2 = objHP.sort();

		for (int i=0; i < nros2.length; i++){
			System.out.print(nros2[i] + " ");
		}

	}
	


}
