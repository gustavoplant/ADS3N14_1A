package com.senac.programa;

import com.senac.estruturas.Arvore;

public class Inicio {

	public static void main(String[] args) {

		String[] lstDesordenada = {"chocolatado","Alface","Caf�","Salgadinho","Batata","Ch�","Amendoim","Cebola","Mortadela","Cenoura","Salame","Piment�o","Salsicha","Repolho","Lingui�a","Chocolate","Tomate","Bacon","Bala","Vagem","Manteiga","Chuchu","Requeij�o","Mistura","L�mpada","Abacaxi","Iogurte","Maisena","F�sforo","Banana","Leite","Fermento","Pilha","Laranja","Pastel","Lim�o","Gelatina","Esponja","Mam�o","Bacalhau","Pudim","Rodo","Maracuj�","Ma��","Gel�ia","Ovos","Amon�aco","Goiabada","Polvilho","Guardanapo"};
		String[] lstOrdenada = {"Abacaxi","Alface","Amendoim","Amon�aco","Bacalhau","Bacon","Bala","Banana","Batata","Caf�","Cebola","Cenoura","Ch�","chocolatado","Chocolate","Chuchu","Esponja","Fermento","F�sforo","Gelatina","Gel�ia","Goiabada","Guardanapo","Iogurte","L�mpada","Laranja","Leite","Lim�o","Lingui�a","Ma��","Maisena","Mam�o","Manteiga","Maracuj�","Mistura","Mortadela","Ovos","Pastel","Pilha","Piment�o","Polvilho","Pudim","Repolho","Requeij�o","Rodo","Salame","Salgadinho","Salsicha","Tomate","Vagem"};
		String[] lstInversa = {"Vagem","Tomate","Salsicha","Salgadinho","Salame","Rodo","Requeij�o","Repolho","Pudim","Polvilho","Piment�o","Pilha","Pastel","Ovos","Mortadela","Mistura","Maracuj�","Manteiga","Mam�o","Maisena","Ma��","Lingui�a","Lim�o","Leite","Laranja","L�mpada","Iogurte","Guardanapo","Goiabada","Gel�ia","Gelatina","F�sforo","Fermento","Esponja","Chuchu","Chocolate","chocolatado","Ch�","Cenoura","Cebola","Caf�","Batata","Banana","Bala","Bacon","Bacalhau","Amon�aco","Amendoim","Alface","Abacaxi"};
		
		Arvore arvoreAVL = new Arvore();
		Arvore arvoreRB1 = new Arvore();
		Arvore arvoreRB2 = new Arvore();
		Arvore arvoreRB3 = new Arvore();
		
		
		System.out.println("------------- Itens desordenados -------------");
		for (int i=0; i< lstDesordenada.length;i++){
			arvoreRB1.inserir(lstDesordenada[i], false);
		}

		System.out.println("Foram feitas "+ arvoreRB1.getComp() + " compara��es e "+ arvoreRB1.getRot() +" rota��es e a altura da raiz � "+ arvoreRB1.alturaRaiz());
		
		System.out.println("------------- Itens Ordenados -------------");
		for (int i=0; i< lstDesordenada.length;i++){
			arvoreRB2.inserir(lstOrdenada[i], false);
		}
		System.out.println("Foram feitas "+ arvoreRB2.getComp() + " compara��es e "+ arvoreRB2.getRot() +" rota��es e a altura da raiz � "+ arvoreRB2.alturaRaiz());
		
		System.out.println("------------- Itens lista inversa -------------");
		for (int i=0; i< lstDesordenada.length;i++){
			arvoreRB3.inserir(lstInversa[i], false);
		}
		System.out.println("Foram feitas "+ arvoreRB3.getComp() + " compara��es e "+ arvoreRB3.getRot() +" rota��es e a altura da raiz � "+ arvoreRB3.alturaRaiz());
		
				
		
		
		String keyNodoRem = "Cebola";
		
		System.out.println("Removendo nodo com a chave "+ keyNodoRem);
		
		if (arvoreRB1.deletar(keyNodoRem) == 1){
			System.out.println("Nodo removido com sucesso foram "+ arvoreRB1.getComp() +" compara��es e "+ arvoreRB1.getRot() + " rota��es");
		}
		else {
			System.out.println("Valor n�o encontrado na �rvore");
		}
		
	}

}
