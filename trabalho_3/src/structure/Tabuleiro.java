package structure;

import java.util.Random;

public class Tabuleiro {
	
	int[][] battleField = new int[10][10];
	
	public Tabuleiro (){
		
		// popula o tabuleiro
		for (int c = 0;c<=9;c++){
			for (int l = 0;l<=9;l++){
				battleField[c][l] = 0;
			}
		}
		
	}

	public void marcarPos (char col,char linha, int val){
		// convert o char para a posicao da coluna sendo A == 0
		int c = (int) col;
		c = c - 97;
		
		int l = (int) linha;
		l--;
		
		this.battleField[c][l] = val;
		
	}
	
	public int criarNavio(int tam, int tipo){
		
		boolean exit = false;
		boolean livre = true;
		int lr = -1;
		int cr = -1;
		
		Random randomGen = new Random();
		
		while (!exit){
			
			lr = randomGen.nextInt(9);
			cr = randomGen.nextInt(9 - tam);
			
			int col = cr;
			
			for (int i=0; i <= tam; i++){
				if (this.battleField[col][lr] != 0){
					livre = false;
				}
				col++;
			}
			
			if (livre){
				
				col = cr;
				
				for (int i=0; i <= tam; i++){
					this.battleField[col][lr] = tipo;
					col++;
				}
				
				exit = true;
			}
		}
		
		String ret = String.valueOf(lr) + String.valueOf(cr);
		return Integer.parseInt(ret);
		
		
	}
}
