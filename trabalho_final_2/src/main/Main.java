
package main;

import grafo.util.Dijkstra;
import grafo.util.Aresta;
import grafo.util.Grafo;
import grafo.util.Vertice;
import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import model.Carro;

public class Main {
	
	private static double valorComb;
	
     public static void main(String[] args) throws FileNotFoundException, IOException {
    	
        Scanner ler = new Scanner(System.in);
        int origem,destino;
        Grafo g = new Grafo();
        leArquivo(g);
        //System.out.println(g);
        
        
        System.out.print("Digite o ponto de PARTIDA: ");
        origem = ler.nextInt();
        System.out.print("Digite o ponto de DESTINO: ");
        destino = ler.nextInt();
        System.out.print("Digite o preço do combustível: ");
        valorComb = Double.parseDouble(ler.next());
        calculaCaminho(g,origem,destino);
        
        
    }
     
    public static void calculaCaminho(Grafo g,int origem,int destino){
        List<Vertice> nodes = g.getVertices();
        Dijkstra d = new Dijkstra(g);
        ArrayList<Vertice> caminho;
        Double custoPedagio = 0.0;
        
        
        d.calcula(nodes.get(origem));        
        caminho = d.getCaminho(nodes.get(destino));
        custoPedagio = d.custo.get(caminho.get(caminho.size() - 1));
        
        Carro veiculo = new Carro(40.0,15.0,180,180.0);
        
        System.out.println("---- CALCULANDO ROTA DO PONTO "+ origem + " ATÉ O PONTO "+ destino +" partindo com tanque cheio -------------------\n");
        
        int i = 0;
        
        do {
        	
        	if (i == caminho.size() - 1){
        		
        		DecimalFormat df2 = new DecimalFormat("#.##");
        		DecimalFormat df3 = new DecimalFormat("#.###");
        		
        		System.out.println("CHEGOU NO DESTINO FINAL !\n");
        		
        		System.out.println("\n\n---- ESTATÍSTICAS -----");
        		System.out.println("Km percorridos: " + df3.format(veiculo.getOdometro()));
        		System.out.println("Combustível utilizado: " + df3.format(veiculo.getLitrosConsumidos()) + " litros");
        		System.out.println("Custo com pedágio: R$ " + df2.format(custoPedagio));
        		System.out.println("Custo com combustível: R$ " + df2.format(valorComb * veiculo.getLitrosConsumidos()));
        		System.out.println("\nCUSTO TOTAL: R$ " + df2.format((valorComb * veiculo.getLitrosConsumidos() + custoPedagio)));

        		
        		
        		break;
        	}
        		
    		if (veiculo.checarTanque(caminho.get(i), caminho.get(i + 1))){
    			if (veiculo.checarTempo(caminho.get(i), caminho.get(i + 1))){
    				System.out.println("ORIGEM: "+ caminho.get(i).getNome() + "    DESTINO:"+ caminho.get(i + 1).getNome()); 
    				veiculo.rodar(caminho.get(i), caminho.get(i + 1));
    				i++;
    			}
    			else {
    				System.out.println("---> PARADA para descançar, ponto: "+ caminho.get(i).getNome());
    				veiculo.setTempoDirecao(180);
    			}
    		}
    		else {
    			System.out.println("---> PARADA para abastecer, ponto: "+ caminho.get(i).getNome());
    			veiculo.reabastecer();
    		}
        
        } while (i < caminho.size());
        
    }
     
    public static void leArquivo(Grafo grafo) throws FileNotFoundException, IOException{
    	    	
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
