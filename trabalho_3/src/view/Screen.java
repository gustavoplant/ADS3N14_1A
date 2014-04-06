package view;

import java.util.Scanner;

public class Screen {
	/*
	 * classe para exibir o tabuleiro
	 * 
	 */
	
	public void showHead(String player,int points){
		System.out.println("------------------------------------------------------");
		System.out.println("---- "+ player +"      PONTOS: "+ points );
		System.out.println("------------------------------------------------------");
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
	}
	
	public void showMessage(String msg){
		System.out.println(msg);
	}
	
	public String showInputScreen(String msg){
		
		Scanner sc = new Scanner(System.in);
		String ret = "";
		
		while (ret.equals("")){
			System.out.print(msg + ":");
			ret = sc.nextLine();
		}
		
		return ret;
	}

}
