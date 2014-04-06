import java.util.Random;

public class methods {
		
	public int[] genList(int qtd){
		
		int[] intArr = new int[qtd];
		
		Random randomGen = new Random();
		
		for (int i = 0; i < qtd; i++){
			intArr[i] = randomGen.nextInt(100);
		}
		
		return intArr;
	}
	
	public void printArr (int[] aux) {
		
		for (int i = 0; i < aux.length; i++){
			System.out.print(aux[i] + " ");
		}
		System.out.print("\n");
	}
}