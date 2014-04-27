package com.senac.apps.ListaTelefonicaBinaria.view;

import java.util.ArrayList;
import java.util.Scanner;

public class Screen {

	Boolean debug = true;
	
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
	
	public void showDebugMessage(String msg){
		if (this.debug){
			System.out.println("DEBUG: " + msg);
		}
		try {
			Thread.sleep(3000);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
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
	
	public void showContactList(ArrayList<String[]> in,String order){
		System.out.println("------------------- LISTAGEM DE CONTATOS ORDENACAO "+ order +" ---------------------");
		for (int i=0;i<in.size();i++){
			System.out.print(" Contato nro " + (i + 1));
			System.out.print(" Nome:"+ in.get(i)[0]);
			System.out.print(" Telefone:"+ in.get(i)[1]);
			System.out.print(" |");
		}
		System.out.print("\n\n\n");
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
