/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arvorebinaria;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Andre
 */
public class Inicio {

    static Arvore  tree;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        tree = new Arvore();
        
        leArquivo();
        
        int opcao; //variavel para armazenar o comando digitado...
        int chave; //variavel para armazenar o comando digitado...
        String valor; //variavel para armazenar o comando digitado...
        Scanner teclado = new Scanner(System.in);
        
        
        do{
            menu();
            opcao = teclado.nextInt();
            
            switch(opcao){
            case 1:
                
                System.out.println("Digite uma chave:");
                chave = teclado.nextInt();
                
                System.out.println("Digite o valor:");
                valor = teclado.next();
                
                adicionarNO(valor,chave);
                break;
                
            case 2:
                System.out.println("Informa a chave para remover:");
                chave = teclado.nextInt();
                removeNo(chave);
                break;
                
            case 3:
                System.out.println("Informa a chave para consultar:");
                chave = teclado.nextInt();
                consultar(chave);
                break;
            
            case 4:
                System.out.println("Caminhamento em ordem:");
                System.out.println("\n");
                tree.caminhaOrdenado(tree.raiz);
                System.out.println("\n");
                break;
            
            case 5:
                System.out.println("Caminhamento prefixado:");
                System.out.println("\n");
                tree.caminhaPrefixado(tree.raiz);
                System.out.println("\n");
                break;
            
            case 6:
                System.out.println("Caminhamento posfixado:");
                System.out.println("\n");
                tree.caminhaPosfixado(tree.raiz);
                System.out.println("\n");
                break;
            
            default:
                System.out.println("Opção inválida.");
            }
        } while(opcao != 0);
        
    }
    
    public static void menu(){
            System.out.println("---------------------------------------------");        
            System.out.println("1 - Adicionar novo no na arvore");        
            System.out.println("2 - Remover no na arvore");        
            System.out.println("3 - Buscar valor na arvore");        
            System.out.println("4 - Mostrar caminhamento em ordem");        
            System.out.println("5 - Mostrar caminhamento prefixado");        
            System.out.println("6 - Mostrar caminhamento posfixado");        
            System.out.println("0 - SAIR");        
            System.out.println("---------------------------------------------");        
            System.out.println("\n Opção:");        
        }
    
    public static void adicionarNO(String valor,int chave){
        
        tree.inserir(valor, chave);
        System.out.println("Inserido com sucesso");
    }
    public static void removeNo(int chave){
        tree.removeNo(tree.raiz, chave);
        System.out.println("removido com sucesso");
    }
    public static void consultar(int chave){
        tree.busca(tree.raiz, chave);
    }
    
    public static void leArquivo() throws FileNotFoundException, IOException{
        
        
        FileInputStream fstream = new FileInputStream("arquivo.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String linha;

        while ((linha = br.readLine()) != null)   {
            String valor[];
            valor = linha.split("=");
            tree.inserir(valor[0], Integer.parseInt(valor[1]));
        }


        br.close();
    }
            
}
