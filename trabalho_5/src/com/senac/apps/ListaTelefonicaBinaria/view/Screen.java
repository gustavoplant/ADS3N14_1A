package com.senac.apps.ListaTelefonicaBinaria.view;

import java.util.Scanner;

public class Screen {

	
	public void showHead(){
		System.out.println("-----------------------------------------------------------");
		System.out.println("Happy Binary Tree Friends Phone Book - Lista telef�nica");
		System.out.println("-----------------------------------------------------------");
	}
	
	public void newScreen (){
		System.out.println("                                                      ");
		System.out.println("                                                      ");
		System.out.println("                                                      ");
		System.out.println("                                                      ");
		System.out.println("                                                      ");
		System.out.println("                                                      ");
		System.out.println("                                                      ");
		System.out.println("                                                      ");
		System.out.println("                                                      ");
		System.out.println("                                                      ");
		System.out.println("                                                      ");
		System.out.println("                                                      ");
		System.out.println("                                                      ");
		System.out.println("                                                      ");
		System.out.println("                                                      ");
		System.out.println("                                                      ");
		System.out.println("                                                      ");
		System.out.println("                                                      ");
		System.out.println("                                                      ");
		System.out.println("                                                      ");
		System.out.println("                                                      ");
	}
	
	public void showMessage(String msg){
		/*
		 * Exibe uma mensagem para o usu�rio
		 */
		System.out.println(msg);
	}
	
	public void showContact(String nome, String telefone, int comp){
		/*
		 * imprime um contato na tela
		 */
		System.out.println("------------------- CONTATO ENCONTRADO ---------------------");
		System.out.println("NOME: " + nome);
		System.out.println("TELEFONE: " + telefone);
		System.out.println("QUANTIDADE DE COMPARA��ES: " + comp);
		System.out.println("------------------------------------------------------------");
	}
	
	public void showWarnMsg(String msg,int sleepTime){
		/* mostra uma mensagem de alerta para o usu�rio
		 * e aguarda expirar o valor de sleepTime para prosseguir
		 */
		
		if (sleepTime < 1)
			return;
		
		System.out.println(msg);
		
		try {
			Thread.sleep(sleepTime);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public String showInputScreen(String msg,boolean vrfIn){
		/*
		 * Exibe uma mensagem para o usu�rio e aguarda ele entrar com algum dado
		 * se a verifica��o estiver em true, ele n�o prossegue enquanto o usu�rio
		 * n�o inserir um valor.
		 */
		
		Scanner sc = new Scanner(System.in);
		String ret = "";
		
		if (vrfIn){
			while (ret.equals("")){
				System.out.print(msg + ":");
				ret = sc.nextLine();
			}
		}
		else {
			System.out.print(msg + ":");
			ret = sc.nextLine();
		}
		
		return ret;
	}
	
	public char showSingleInputScreen(String msg,boolean vrfIn){
		/*
		 * Exibe uma mensagem para o usu�rio e aguarda ele entrar com um �nico caracter
		 * para prosseguir.
		 * 
		 * se a op��o vrfIn estiver setada em true verifica se um caractere v�lido foi inserido ao inv�s do enter
		 * 
		 */
		
		Scanner sc = new Scanner(System.in);
		char ret = ' ';
		
		if (vrfIn){
			
			do {
				System.out.print(msg + ":");
				ret = sc.next().toCharArray()[0];
				
			} while (!Character.isLetter(ret));
		}
		else {
			System.out.print(msg + ":");
			ret = sc.next().charAt(0);
		}
		
		return ret;
	}

}
