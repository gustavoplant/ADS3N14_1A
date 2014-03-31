package controller;

import structure.Tabuleiro;

public class BattleController {
	
	Tabuleiro tabuleiro = new Tabuleiro();
	
	public BattleController(){
		tabuleiro.criarNavio(4,1);
	}
}
