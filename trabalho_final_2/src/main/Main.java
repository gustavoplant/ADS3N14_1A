
package main;

import grafo.util.Dijkstra;
import grafo.util.Aresta;
import grafo.util.Grafo;
import grafo.util.Vertice;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
     public static void main(String[] args) throws FileNotFoundException, IOException {
    	
        Scanner ler = new Scanner(System.in);
        int origem,destino;
        Grafo g = new Grafo();
        leArquivo(g);
        System.out.println(g);
        
        
        System.out.print("Digite o vertice de origem: ");
        origem = ler.nextInt();
        System.out.print("Digite o vertice de destino: ");
        destino = ler.nextInt();
        calculaCaminho(g,origem,destino);
        
        
    }
     
    public static void calculaCaminho(Grafo g,int origem,int destino){
        List<Vertice> nodes = g.getVertices();
        Dijkstra d = new Dijkstra(g);
        
        d.calcula(nodes.get(origem));        
        d.getCaminho(nodes.get(destino));
    }
     
    public static void leArquivo(Grafo grafo) throws FileNotFoundException, IOException{
    	
    	/*
    	grafo.addAresta(grafo.addVertice(0,10.3,8.7), grafo.addVertice(1,11.8,3.4), 2);
    	grafo.addAresta(grafo.addVertice(0,10.3,8.7), grafo.addVertice(2,11.8,3.4), 4);
    	
    	grafo.addAresta(grafo.addVertice(1,10.3,8.7), grafo.addVertice(0,11.8,3.4), 2);
    	grafo.addAresta(grafo.addVertice(1,10.3,8.7), grafo.addVertice(2,11.8,3.4), 5);
    	grafo.addAresta(grafo.addVertice(1,10.3,8.7), grafo.addVertice(3,11.8,3.4), 1);
    	
    	grafo.addAresta(grafo.addVertice(2,10.3,8.7), grafo.addVertice(0,11.8,3.4), 4);
    	grafo.addAresta(grafo.addVertice(2,10.3,8.7), grafo.addVertice(1,11.8,3.4), 5);
    	grafo.addAresta(grafo.addVertice(2,10.3,8.7), grafo.addVertice(3,11.8,3.4), 6);
    	grafo.addAresta(grafo.addVertice(2,10.3,8.7), grafo.addVertice(4,11.8,3.4), 2);
    	
    	grafo.addAresta(grafo.addVertice(3,10.3,8.7), grafo.addVertice(1,11.8,3.4), 1);
    	grafo.addAresta(grafo.addVertice(3,10.3,8.7), grafo.addVertice(2,11.8,3.4), 6);
    	grafo.addAresta(grafo.addVertice(3,10.3,8.7), grafo.addVertice(4,11.8,3.4), 3);
    	
    	grafo.addAresta(grafo.addVertice(4,10.3,8.7), grafo.addVertice(2,11.8,3.4), 2);
    	grafo.addAresta(grafo.addVertice(4,10.3,8.7), grafo.addVertice(3,11.8,3.4), 3);
    	*/
    	
    	ArrayList<Vertice> lstVert = new ArrayList<>();
    	
        FileInputStream fstream = new FileInputStream("grafo.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String linha;
        char dataType = ' ';
        String valor[];

        while ((linha = br.readLine()) != null)   {
        	
        	// se linha estiver vazia ignora
        	if (linha.contentEquals("")){
        		continue;
        	}
        	
        	if (linha.contentEquals("vertices")){
        		dataType = 'v';
        		continue;
        	}
        	
        	if (linha.contentEquals("arestas")){
        		dataType = 'a';
        		continue;
        	}
        	
        	
            valor = linha.split(" ");
        	
        	if (dataType ==  'v'){ // lendo vértices
        		lstVert.add(grafo.addVertice(Integer.parseInt(valor[0]),Double.parseDouble(valor[1]),Double.parseDouble(valor[2])));
        	}
        	else if (dataType ==  'a') { // lendo arestas
        		grafo.addAresta(lstVert.get(Integer.parseInt(valor[0])),lstVert.get(Integer.parseInt(valor[1])),Double.parseDouble(valor[2]));
        	}
        	
        }


        br.close();
    }
}
