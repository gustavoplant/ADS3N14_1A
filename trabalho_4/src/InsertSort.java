
public class InsertSort {

	public int[] insertSort (int[] desNros){
		
		int i,c,j,cont = 0;
		int [] retArr = new int[desNros.length + 1];
		
		for (i=1;i< desNros.length;i++){
			c = desNros[i];
			j = i;
			
			while (j > 0 && desNros[j-1] > c){
				cont++;
				desNros[j] = desNros[j-1];
				j = j - 1;
				desNros[j] = c;
			}
		}
		
		for (i=0;i<desNros.length;i++){
			retArr[i] = desNros[i];
		}
				
		retArr[desNros.length] = cont;
		
		return retArr;
	}
	
}
