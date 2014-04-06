package controller;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Jogador;
import structure.Tabuleiro;
import view.Screen;

public class BattleController {

	// objetos
	Screen screen = new Screen();
	Tabuleiro tabuleiro = new Tabuleiro();

	// variaveis de controle
	int frotaSize = 0;
	String cmd = "";
	
	public BattleController(){
		
	}
	
	public void playGame(){
		
		// cria os navios
		
		// porta aviões
		tabuleiro.criarNavio(1,5,1);
		frotaSize = frotaSize + 1;

		// destroyers
		tabuleiro.criarNavio(2,4,2);
		frotaSize = frotaSize + 2;
		
	/*	
		// fragatas
		tabuleiro.criarNavio(2,3,3);
		frotaSize = frotaSize + 2;
	
		// torpedeiros
		tabuleiro.criarNavio(3,2,4);
		frotaSize = frotaSize + 3;

		// submarinos
		tabuleiro.criarNavio(5,1,5);
		frotaSize = frotaSize + 5;
*/
		
		
		screen.showMessage("Bem vindo ao BatleField !!!");
		screen.showMessage("");
		Jogador jogador = new Jogador(screen.showInputScreen("Insira o seu nome"));
		screen.newScreen();
		
		while (frotaSize != 0 && jogador.gameOver() == false){ // laço principal enquanto o jogo estiver rodando
			
			screen.newScreen();
			screen.showHead(jogador.getNome(), jogador.getPontos());
			screen.printTabuleiro(tabuleiro.getBattleField());
			
			cmd = "";
						
			while (true){
				
				cmd = screen.showInputScreen("Insira a coordenada").toLowerCase();
				
				if (cmd.equals("pr")){
					screen.showHead(" RADDAR VIEW " , 0);
					screen.printRaddar(tabuleiro.getRaddar());
					cmd = screen.showInputScreen("Insira qualquer entrada para continuar ...");
					cmd = "next";
					break;
				}
				
				Pattern r = Pattern.compile("^[a-j][0-9]$");
				Matcher m = r.matcher(cmd);
				
				if (m.find()){
					break;
				}
				screen.showMessage("Coordenada incorreta, insira no formato coluna[a-j] linha[0-9]");
			}
			
			if (cmd.equals("next")){
				continue;
			}
			
			char c = cmd.charAt(0);
			char l = cmd.charAt(1);
			
			int retShot = tabuleiro.shot(c, l);
			
			if (retShot == -1){
				screen.showMessage("Você já atirou neste ponto, tente outro ponto !!!");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {

				}
				continue;
			}
			else if (retShot == 0){ // errou
				jogador.sbtPontos(1);
			}
			else if (retShot > 99){ // destruiu um navio
				
				jogador.adcPontos(5);
				frotaSize--;
				
				if (retShot == 100){
					screen.showMessage("Você destruiu um porta aviões (5 pontos)");
				}
				else if (retShot == 200){
					screen.showMessage("Você destruiu um destroyer (5 pontos)");
				}
				else if (retShot == 300){
					screen.showMessage("Você destruiu uma fragata (5 pontos)");
				}
				else if (retShot == 400){
					screen.showMessage("Você destruiu um torpedeiro (5 pontos)");
				}
				else if (retShot == 500){
					screen.showMessage("Você destruiu um submarino (5 pontos)");
				}
				
			}
			else if (retShot > 9){ // acertou um navio
				
				jogador.adcPontos(3);
				if (retShot == 10){
					screen.showMessage("Você acertou um porta aviões (3 pontos)");
				}
				else if (retShot == 20){
					screen.showMessage("Você acertou um destroyer (3 pontos)");
				}
				else if (retShot == 30){
					screen.showMessage("Você acertou uma fragata (3 pontos)");
				}
				else if (retShot == 40){
					screen.showMessage("Você acertou um torpedeiro (3 pontos)");
				}
				else if (retShot == 50){
					screen.showMessage("Você acertou um submarino (3 pontos)");
				}
				
			}
			
		}
		
		if (jogador.gameOver()){
			screen.newScreen();
			screen.showMessage("VOCE PERDEU NAPOLEÃO !!!!!!!");
		}
		else{
			screen.newScreen();
			screen.showMessage("PARABÉNS, VOCÊ GANHOU !!!!!!!");			
		}
	}
}
