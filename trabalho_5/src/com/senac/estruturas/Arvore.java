package com.senac.estruturas;

public class Arvore {
	
	private Node root;
	private int comp = 0;
	int res;
	String tmp;
	
	
	public Arvore(){
		this.root = null;
	}
	
	public int getComp() {
		return comp;
	}

	public void setComp(int comp) {
		this.comp = comp;
	}
	
	public void inserir(String[] key){
		
	}

	public Node procurar(String key){
		
		Node currentNode = this.root;  
	   
		while(currentNode != null){
			
			res = key.compareToIgnoreCase(currentNode.key[0]);
			this.setComp(this.getComp() + 1);
			
			if(res == 0){
				return currentNode;
			}
			else if(res < 0){
				currentNode = currentNode.left;
			}
			else{
				currentNode = currentNode.right;
			}
		}
		
		return currentNode;
	}
	

}
