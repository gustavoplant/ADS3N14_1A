
public class InsertSort {
	
	static int steps = 0;
	
	public InsertSort(){
		
	}
	

	public int[] Sort (int[] desNros){
		
		int i,c,j;
		int [] retArr = new int[desNros.length];
		
		for (i=1;i< desNros.length;i++){
			c = desNros[i];
			j = i;
			
			while (j > 0 && desNros[j-1] > c){
				steps++;
				desNros[j] = desNros[j-1];
				j = j - 1;
				desNros[j] = c;
			}
		}
		
		for (i=0;i<desNros.length;i++){
			retArr[i] = desNros[i];
		}
				
		return retArr;
	}
	
}
