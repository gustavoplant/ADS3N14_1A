
package com.senac.estruturas;

public class Node {
    
    public String key;
    public Node left;
    public Node right;
    public Node parent;
    int color; // 0 - sem cor / 1 - preto (true)/ 2 - verm (false)
    
    
    public Node(String chave){
    	/*
    	 * Nodo sem cor
    	 */
        this.key =   chave; 
        this.color =   0; 
    }
    
    public Node (String chave, int cor){
    	/*
    	 * Nodo com cor (árvore rubro negra)
    	 */
    	this.key = chave;
    	this.color = cor;
    }
    
    
}
