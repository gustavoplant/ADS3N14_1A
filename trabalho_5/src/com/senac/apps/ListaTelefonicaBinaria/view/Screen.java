package com.senac.apps.ListaTelefonicaBinaria.view;

import java.util.Scanner;

public class Screen {

	
	public void showHead(){
		System.out.println("-----------------------------------------------------------");
		System.out.println("Happy Binary Tree Friends Phone Book - Lista telefônica");
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
		 * Exibe uma mensagem para o usuário
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
		System.out.println("QUANTIDADE DE COMPARAÇÕES: " + comp);
		System.out.println("------------------------------------------------------------");
	}
	
	public void showWarnMsg(String msg,int sleepTime){
		/* mostra uma mensagem de alerta para o usuário
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
		 * Exibe uma mensagem para o usuário e aguarda ele entrar com algum dado
		 * se a verificação estiver em true, ele não prossegue enquanto o usuário
		 * não inserir um valor.
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
		 * Exibe uma mensagem para o usuário e aguarda ele entrar com um único caracter
		 * para prosseguir.
		 * 
		 * se a opção vrfIn estiver setada em true verifica se um caractere válido foi inserido ao invés do enter
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
