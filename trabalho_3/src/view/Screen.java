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
	
	public void printTabuleiro (char[][] arrIn){
		
		System.out.print("   A   B   C   D   E   F   G   H   I   J\n");
		for (int l=0;l<=9;l++){
			System.out.print(l +"  ");
			for (int c=0;c<=9;c++){
				System.out.print(arrIn[c][l] + "   ");
			}
			System.out.print("\n");
		}
		
	}

}
