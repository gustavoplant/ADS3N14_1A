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
		
		// porta avi�es
		tabuleiro.criarNavio(1,5,1);
		frotaSize = frotaSize + 1;

		// destroyers
		tabuleiro.criarNavio(2,4,2);
		frotaSize = frotaSize + 2;
		
		
		// fragatas
		tabuleiro.criarNavio(2,3,3);
		frotaSize = frotaSize + 2;
	
		// torpedeiros
		tabuleiro.criarNavio(3,2,4);
		frotaSize = frotaSize + 3;

		// submarinos
		tabuleiro.criarNavio(5,1,5);
		frotaSize = frotaSize + 5;
	
		
		screen.showMessage("Bem vindo ao BatleField !!!");
		screen.showMessage("");
		Jogador jogador = new Jogador(screen.showInputScreen("Insira o seu nome"));
		screen.newScreen();
		
		while (frotaSize != 0 && jogador.gameOver() == false){ // la�o principal enquanto o jogo estiver rodando
			
			screen.newScreen();
			screen.showHead(jogador.getNome(), jogador.getPontos());
			screen.printTabuleiro(tabuleiro.getBattleField());
			
			cmd = "";
						
			while (true){
				
				cmd = screen.showInputScreen("Insira a coordenada").toLowerCase();
				
				if (cmd.equals("pr")){
					screen.newScreen();
					screen.showHead(" RADDAR VIEW " , 0);
					screen.printRaddar(tabuleiro.getRaddar());
					cmd = screen.showInputScreen("Precione ENTER para continuar ...",false);
					cmd = "next";
					break;
				}
				
				Pattern r = Pattern.compile("^[a-j][0-9]$");
				Matcher m = r.matcher(cmd);
				
				if (m.find()){
					break;
				}
				screen.showWarnMsg("Coordenada incorreta, insira no formato coluna[a-j] linha[0-9]",1000);
			}
			
			if (cmd.equals("next")){
				continue;
			}
			
			char c = cmd.charAt(0);
			char l = cmd.charAt(1);
			
			int retShot = tabuleiro.shot(c, l);
			
			if (retShot == -1){
				screen.showWarnMsg("Voc� j� atirou neste ponto, tente outro ponto !!!",1000);
				continue;
			}
			else if (retShot == 0){ // errou
				jogador.sbtPontos(1);
			}
			else if (retShot > 99){ // destruiu um navio
				
				jogador.adcPontos(5);
				frotaSize--;
				
				if (retShot == 100){
					screen.showWarnMsg("Voc� destruiu um porta avi�es (5 pontos)",3000);
				}
				else if (retShot == 200){
					screen.showWarnMsg("Voc� destruiu um destroyer (5 pontos)",3000);
				}
				else if (retShot == 300){
					screen.showWarnMsg("Voc� destruiu uma fragata (5 pontos)",3000);
				}
				else if (retShot == 400){
					screen.showWarnMsg("Voc� destruiu um torpedeiro (5 pontos)",3000);
				}
				else if (retShot == 500){
					screen.showWarnMsg("Voc� destruiu um submarino (5 pontos)",3000);
				}
				
			}
			else if (retShot > 9){ // acertou um navio
				
				jogador.adcPontos(3);
				if (retShot == 10){
					screen.showWarnMsg("Voc� acertou um porta avi�es (3 pontos)",3000);
				}
				else if (retShot == 20){
					screen.showWarnMsg("Voc� acertou um destroyer (3 pontos)",3000);
				}
				else if (retShot == 30){
					screen.showWarnMsg("Voc� acertou uma fragata (3 pontos)",3000);
				}
				else if (retShot == 40){
					screen.showWarnMsg("Voc� acertou um torpedeiro (3 pontos)",3000);
				}
				else if (retShot == 50){
					screen.showWarnMsg("Voc� acertou um submarino (3 pontos)",3000);
				}
			}
			
		}
		
		if (jogador.gameOver()){
			screen.newScreen();
			screen.showMessage("VOCE PERDEU NAPOLE�O !!!!!!!");
		}
		else{
			screen.newScreen();
			screen.showMessage("PARAB�NS, VOC� GANHOU !!!!!!!");			
		}
	}
}
