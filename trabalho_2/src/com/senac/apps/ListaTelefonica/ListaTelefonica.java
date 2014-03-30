package com.senac.apps.ListaTelefonica;

import com.senac.apps.ListaTelefonica.controller.ListaController;
import com.senac.apps.ListaTelefonica.view.ConsoleView;

public class ListaTelefonica {
	
	public static void main(String[] args) {
		ConsoleView view = new ConsoleView();
		ListaController controller = new ListaController(view);
		String command = "";
		
		controller.loadFile("telefones.dat");
		view.message("Digite 'ajuda' para comandos validos.");
		
		int mostraCont = 0;
		
		while (!command.equals("sair")) {
			
			if (mostraCont == 1){
				controller.showContato();
				mostraCont = 0;
			}
			
			command = view.read("Comando").toLowerCase();
			if (command.equals("avancar")){
				controller.nextContato();
				mostraCont = 1;
			}
			else if (command.equals("voltar")){
				controller.previousContato();
				mostraCont = 1;
			}
			else if (command.equals("inserir")){
				controller.insertContato();
				mostraCont = 0;
			}
			else if (command.equals("excluir")){
				controller.removeContato();
				mostraCont = 0;
			}
			else if (command.equals("procurar")){
				controller.searchContato("",false);
				mostraCont = 1;
			}
			else if (command.equals("procurarbin")){
				controller.searchContatoBinario();
				mostraCont = 1;
			}
			else if (command.equals("ajuda")){
				view.message("ajuda  avancar  voltar  inserir  excluir  procurar procurarbin sair");
				mostraCont = 0;
			}
			else if (command.equals("sair")){
				controller.saveFile("telefones.dat");
				System.exit(0);
			}
			else{
				view.message("COMANDO INVÁLIDO ! \npossiveis comandos: ajuda  avancar  voltar  inserir  excluir  procurar procurarbin sair");
				mostraCont = 0;
			}
		}
	}

}
