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
	
	public void showWarnMsg(String msg,int sleepTime){
		
		if (sleepTime < 1)
			return;
		
		System.out.println(msg);
		
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
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
	
	public String showInputScreen(String msg,boolean vrfIn){
		
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
	
	public void printTabuleiro (char[][] arrIn){
		
		System.out.print("   A   B   C   D   E   F   G   H   I   J\n");
		for (int l=0;l<=9;l++){
			System.out.print(l +"  ");
			for (int c=0;c<=9;c++){
				System.out.print(arrIn[c][l] + "   ");
			}
			System.out.print("\n");
		}
		System.out.println("------------------------------------------------------");
		
	}
	
	public void printRaddar (int[][] arrIn){
		
		System.out.print("   A   B   C   D   E   F   G   H   I   J\n");
		for (int l=0;l<=9;l++){
			System.out.print(l +"  ");
			for (int c=0;c<=9;c++){
				if (arrIn[c][l] < 0){
					System.out.print("*   ");
				}
				else {
					System.out.print(arrIn[c][l] + "   ");
				}
			}
			System.out.print("\n");
		}
		
	}

}
