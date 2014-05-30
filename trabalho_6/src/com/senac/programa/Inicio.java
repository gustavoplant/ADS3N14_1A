package com.senac.programa;

import com.senac.estruturas.Arvore;

public class Inicio {

	public static void main(String[] args) {

		String[] lstDesordenada = {"chocolatado","Alface","Café","Salgadinho","Batata","Chá","Amendoim","Cebola","Mortadela","Cenoura","Salame","Pimentão","Salsicha","Repolho","Linguiça","Chocolate","Tomate","Bacon","Bala","Vagem","Manteiga","Chuchu","Requeijão","Mistura","Lâmpada","Abacaxi","Iogurte","Maisena","Fósforo","Banana","Leite","Fermento","Pilha","Laranja","Pastel","Limão","Gelatina","Esponja","Mamão","Bacalhau","Pudim","Rodo","Maracujá","Maçã","Geléia","Ovos","Amoníaco","Goiabada","Polvilho","Guardanapo"};
		String[] lstOrdenada = {"Abacaxi","Alface","Amendoim","Amoníaco","Bacalhau","Bacon","Bala","Banana","Batata","Café","Cebola","Cenoura","Chá","chocolatado","Chocolate","Chuchu","Esponja","Fermento","Fósforo","Gelatina","Geléia","Goiabada","Guardanapo","Iogurte","Lâmpada","Laranja","Leite","Limão","Linguiça","Maçã","Maisena","Mamão","Manteiga","Maracujá","Mistura","Mortadela","Ovos","Pastel","Pilha","Pimentão","Polvilho","Pudim","Repolho","Requeijão","Rodo","Salame","Salgadinho","Salsicha","Tomate","Vagem"};
		String[] lstInversa = {"Vagem","Tomate","Salsicha","Salgadinho","Salame","Rodo","Requeijão","Repolho","Pudim","Polvilho","Pimentão","Pilha","Pastel","Ovos","Mortadela","Mistura","Maracujá","Manteiga","Mamão","Maisena","Maçã","Linguiça","Limão","Leite","Laranja","Lâmpada","Iogurte","Guardanapo","Goiabada","Geléia","Gelatina","Fósforo","Fermento","Esponja","Chuchu","Chocolate","chocolatado","Chá","Cenoura","Cebola","Café","Batata","Banana","Bala","Bacon","Bacalhau","Amoníaco","Amendoim","Alface","Abacaxi"};
		
		Arvore arvoreAVL = new Arvore();
		Arvore arvoreRB1 = new Arvore();
		Arvore arvoreRB2 = new Arvore();
		Arvore arvoreRB3 = new Arvore();
		
		
		System.out.println("------------- Itens desordenados -------------");
		for (int i=0; i< lstDesordenada.length;i++){
			arvoreRB1.inserir(lstDesordenada[i], false);
		}

		System.out.println("Foram feitas "+ arvoreRB1.getComp() + " comparações e "+ arvoreRB1.getRot() +" rotações e a altura da raiz é "+ arvoreRB1.alturaRaiz());
		
		System.out.println("------------- Itens Ordenados -------------");
		for (int i=0; i< lstDesordenada.length;i++){
			arvoreRB2.inserir(lstOrdenada[i], false);
		}
		System.out.println("Foram feitas "+ arvoreRB2.getComp() + " comparações e "+ arvoreRB2.getRot() +" rotações e a altura da raiz é "+ arvoreRB2.alturaRaiz());
		
		System.out.println("------------- Itens lista inversa -------------");
		for (int i=0; i< lstDesordenada.length;i++){
			arvoreRB3.inserir(lstInversa[i], false);
		}
		System.out.println("Foram feitas "+ arvoreRB3.getComp() + " comparações e "+ arvoreRB3.getRot() +" rotações e a altura da raiz é "+ arvoreRB3.alturaRaiz());
		
				
		
		
		String keyNodoRem = "Cebola";
		
		System.out.println("Removendo nodo com a chave "+ keyNodoRem);
		
		if (arvoreRB1.deletar(keyNodoRem) == 1){
			System.out.println("Nodo removido com sucesso foram "+ arvoreRB1.getComp() +" comparações e "+ arvoreRB1.getRot() + " rotações");
		}
		else {
			System.out.println("Valor não encontrado na árvore");
		}
		
	}

}
