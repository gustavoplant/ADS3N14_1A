package structure;

import java.util.ArrayList;
import java.util.Random;
import model.Navio;

public class Tabuleiro extends Navio {
	
	char[][] battleField = new char[10][10]; // matriz para marcar os tiros e acertos
	int[][] raddar = new int[10][10]; // variavel para registrar onde estão os navios (guarda o ID do objeto)
	ArrayList<Navio> frota = new ArrayList<>(); // array que armazena o ponteiro para a instância do objeto Navio
	
	
	public Tabuleiro(){
		
		// popula o tabuleiro
		for (int c = 0;c<=9;c++){
			for (int l = 0;l<=9;l++){
				battleField[c][l] = '.';
			}
		}
		
		// popula o raddar
		for (int c = 0;c<=9;c++){
			for (int l = 0;l<=9;l++){
				raddar[c][l] = -1;
			}
		}		
		
	}


	public int shot (char col,char linha){
		/*
		 * função que registra um tiro e registra nas matrizes de exibição (battleField) e controle (raddar)
		 * 
		 * se acertar verifica se afundou o navio
		 *    se sim retorna uma centena de 100 a 500 representando o tipo de navio
		 *    se não retorna uma dezena de 10 - 50 reprentando o tipo de navio
		 *    
		 * se errar retorna 0
		 */
		
		// convert o char para a posicao da coluna sendo A == 0
		int c = (int) col;
		c = c - 97;
		
		int l = (int) linha;
		
		int shotId = raddar[c][l];
		
		if (shotId > -1){
			if (frota.get(shotId).isLost() == true){
				return frota.get(shotId).getType() * 100;
			}
			else {
				return frota.get(shotId).getType() * 10;
			}
		}
		
		this.battleField[c][l] = '-';
		return 0;	
	}
	
	public void criarNavio(int qtd, int tam, int tipo){
		
		for (int q=1;q <= qtd;q++){
		
			boolean exit = false;
			boolean livre = true;
			int lr = -1;
			int cr = -1;
			
			Random randomGen = new Random();
			
			while (!exit){
				
				cr = randomGen.nextInt(9 - tam);
				lr = randomGen.nextInt(9);
				
				int col = cr;
				int linha = lr;
				
				for (int i=0; i <= tam; i++){
					if (this.raddar[cr][lr] > -1){
						livre = false;
						break;
					}
					cr++;
				}
				
				if (livre){
					
					frota.add(new Navio(tam, tipo));
					
					int navID = frota.size() - 1;
									
					for (int i=0; i <= tam; i++){
						this.raddar[col][linha] = navID;
						col++;
					}
					
					exit = true;
				}
			}
		}
	}
	
}
