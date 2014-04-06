package controller;

import java.util.Scanner;

import model.Jogador;
import structure.Tabuleiro;
import view.Screen;

public class BattleController {
	
	Screen screen = new Screen();
	Tabuleiro tabuleiro = new Tabuleiro();
	Scanner sc = new Scanner(System.in);
	
	public BattleController(){
		
	}
	
	public void playGame(){
		
		screen.showMessage("Bem vindo ao BatleField !!!");
		screen.showMessage("");
		Jogador jogador = new Jogador(screen.showInputScreen("Insira o seu nome"));
	}
}
