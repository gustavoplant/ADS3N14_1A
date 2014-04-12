
public class InsertSort {
	
	static int trocas = 0;
	static int comp = 0;
	
	public InsertSort(){
		
	}
	

	public int[] Sort (int[] desNros){
		
		int i,c,j;
		int [] retArr = new int[desNros.length];
		
		for (i=1;i< desNros.length;i++){
			c = desNros[i];
			j = i;
			
			if ((j > 0 && desNros[j-1] <= c)) // conta uma comparacao qdo o item esta na posição correta no vetor
				comp++;
			
			while (j > 0 && desNros[j-1] > c){
				desNros[j] = desNros[j-1];
				j = j - 1;
				desNros[j] = c;
				trocas++;
			}
			

		}
		
		for (i=0;i<desNros.length;i++){
			retArr[i] = desNros[i];
		}
				
		return retArr;
	}
	
}
