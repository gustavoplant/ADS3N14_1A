package com.senac.apps.ListaTelefonicaBinaria.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


import com.senac.apps.ListaTelefonicaBinaria.model.Contato;
import com.senac.apps.ListaTelefonicaBinaria.view.Screen;


public class ListaTelefonicaController {
	
	private Screen objScreen = new Screen();
	private Contato objContato = new Contato();
	private String contactFile = "contatos.txt"; 
	
	public ListaTelefonicaController() {
	}

	public void start(){
		
		loadFile(contactFile);
		
		char opt = ' ';
		String input;
		
		objScreen.showHead();
		
		while (opt != 's'){
		
			opt = Character.toLowerCase(objScreen.showSingleInputScreen("Pressione [I] para INSERIR, [E] para EXCLUIR, [P] para PROCURAR, [L] para LISTAR, [S] SAIR",true));
		
			switch (opt){
				case 'i':
					
					String nome =  objScreen.showInputScreen("Insira o nome",true);
					String tel =  objScreen.showInputScreen("Insira o telefone",true);
					objContato.cadastrar(nome, tel);
					
				break;
				
				case 'p':
					input =  objScreen.showInputScreen("Insira o nome a ser pesquisado",true);
					
					if (objContato.procurar(input)){
						objScreen.showContact(objContato.getNome(),objContato.getTelefone(),objContato.getQtdComparacoes());
					}
					else {
						objScreen.showWarnMsg("CONTATO N�O ENCONTRADO",3000);
					}
				break;
				
				case 'l':
					char sOpt = ' ';
					boolean sair = false;
					
					while (!sair){
					
						sOpt = Character.toLowerCase(objScreen.showSingleInputScreen("Pressione:\n A - Travessia prefixa \n B - Travessia infixa\n C - Travessia posfixa\n D - Busca em largura\n E - Busca em profundidade", true));
						
						switch (sOpt){
						
							case 'a':
								objScreen.showContactList(objContato.listarContatos(sOpt),"Travessia prefixa");
								sair = true;
							break;
						
							case 'b':
								objScreen.showContactList(objContato.listarContatos(sOpt),"Travessia infixa");
								sair = true;								
							break;
						
							case 'c':
								objScreen.showContactList(objContato.listarContatos(sOpt),"Travessia posfixa");
								sair = true;								
							break;
						
							case 'd':
								objScreen.showContactList(objContato.listarContatos(sOpt),"Busca em largura");
								sair = true;								
							break;
						
							case 'e':
								objScreen.showContactList(objContato.listarContatos(sOpt),"Busca em profundidade");
								sair = true;								
							break;
							
							default:
								objScreen.showWarnMsg("Op��o inv�lida de listagem", 3000);
							break;
						}
					}
				break;
				
				case 'e':
					input =  objScreen.showInputScreen("Insira o nome a ser exclu�do",true);
					
					if(objContato.excluir(input) == 1){
						objScreen.showWarnMsg("Contato Exclu�do com sucesso",2000);
					}
					else {
						objScreen.showWarnMsg("Contato n�o encontrado",2000);
					}
				break;
				
				case 's':
					//saveFile(contactFile);
					objScreen.showMessage("Aplicativo encerrado !");
				break;
			}
		}
	}
	
	
	private void loadFile(String filename) {
		
		try {
			
			Scanner arq = new Scanner(new FileReader(filename));
			
			while(arq.hasNext()) {				
				objContato.cadastrar(arq.nextLine(), arq.nextLine());
			}
		} 
		catch (FileNotFoundException e) {
			objScreen.showMessage(e.getMessage());
		}
	}
	
	public void saveFile(String filename) {
		
		FileWriter arq = null;
		try {
			arq = new FileWriter(filename,false);
			
			arq.append("aqui");
		} catch (IOException e) {
			objScreen.showMessage(e.getMessage());
		} finally {
			if (arq != null)
				try {
					arq.close();
				} catch (IOException e) {
					objScreen.showMessage(e.getMessage());
				}
		}
	}
}
