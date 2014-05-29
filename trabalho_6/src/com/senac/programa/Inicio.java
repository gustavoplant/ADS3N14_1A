package com.senac.programa;

import com.senac.estruturas.Arvore;

public class Inicio {

	public static void main(String[] args) {

		String[] lstDesordenada = {"chocolatado","Alface","Caf�","Salgadinho","Batata","Ch�","Amendoim","Cebola","Mortadela","Cenoura","Salame","Piment�o","Salsicha","Repolho","Lingui�a","Chocolate","Tomate","Bacon","Bala","Vagem","Manteiga","Chuchu","Requeij�o","Mistura","L�mpada","Abacaxi","Iogurte","Maisena","F�sforo","Banana","Leite","Fermento","Pilha","Laranja","Pastel","Lim�o","Gelatina","Esponja","Mam�o","Bacalhau","Pudim","Rodo","Maracuj�","Ma��","Gel�ia","Ovos","Amon�aco","Goiabada","Polvilho","Guardanapo"};
		String[] lstOrdenada = {"Abacaxi","Alface","Amendoim","Amon�aco","Bacalhau","Bacon","Bala","Banana","Batata","Caf�","Cebola","Cenoura","Ch�","chocolatado","Chocolate","Chuchu","Esponja","Fermento","F�sforo","Gelatina","Gel�ia","Goiabada","Guardanapo","Iogurte","L�mpada","Laranja","Leite","Lim�o","Lingui�a","Ma��","Maisena","Mam�o","Manteiga","Maracuj�","Mistura","Mortadela","Ovos","Pastel","Pilha","Piment�o","Polvilho","Pudim","Repolho","Requeij�o","Rodo","Salame","Salgadinho","Salsicha","Tomate","Vagem"};
		String[] lstInversa = {"Vagem","Tomate","Salsicha","Salgadinho","Salame","Rodo","Requeij�o","Repolho","Pudim","Polvilho","Piment�o","Pilha","Pastel","Ovos","Mortadela","Mistura","Maracuj�","Manteiga","Mam�o","Maisena","Ma��","Lingui�a","Lim�o","Leite","Laranja","L�mpada","Iogurte","Guardanapo","Goiabada","Gel�ia","Gelatina","F�sforo","Fermento","Esponja","Chuchu","Chocolate","chocolatado","Ch�","Cenoura","Cebola","Caf�","Batata","Banana","Bala","Bacon","Bacalhau","Amon�aco","Amendoim","Alface","Abacaxi"};
		
		Arvore arvoreAVL = new Arvore();
		Arvore arvoreRB = new Arvore();
				
		for (int i=0; i< lstDesordenada.length;i++){
			arvoreRB.inserir(lstDesordenada[i], false);
		}

		System.out.println("Foram feitas "+ arvoreRB.getComp() + " compara��es e "+ arvoreRB.getRot() +" rota��es e a altura da raiz � "+ arvoreRB.alturaRaiz());
		
		String keyNodoRem = "Cebola";
		
		System.out.println("Removendo nodo com a chave "+ keyNodoRem);
		
		if (arvoreRB.deletar(keyNodoRem) == 1){
			System.out.println("Nodo removido com sucesso foram "+ arvoreRB.getComp() +" compara��es e "+ arvoreRB.getRot() + " rota��es");
		}
		else {
			System.out.println("Valor n�o encontrado na �rvore");
		}

	}

}
