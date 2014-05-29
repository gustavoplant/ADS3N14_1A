
package com.senac.estruturas;

public class Node {
    
    public String key;
    public Node left;
    public Node right;
    public Node parent;
    boolean color;
    
    public Node (){
    	/*
    	 * representa um node nil
    	 */
    	this.color = true;    			
    }
    
    
    public Node(String chave){
    	/*
    	 * Nodo sem cor
    	 */
        this.key =   chave;  
    }
    
    public Node (String chave, boolean cor){
    	/*
    	 * Nodo com cor (árvore rubro negra)
    	 */
    	this.key = chave;
    	this.color = cor;
    }
    
    
}
