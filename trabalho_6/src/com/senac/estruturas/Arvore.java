package com.senac.estruturas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Arvore {
	
	private Node root;
	private int comp = 0;
	int res;
	String tmp;
	
	
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public Arvore(){
		this.root = null;
	}
	
	public int getComp() {
		return comp;
	}

	public void setComp(int comp) {
		this.comp = comp;
	}
		
	public Node inserir (String key){
		
		Node retNode = null;
		
		if (this.root == null){
			this.root = new Node(key);
			this.root.parent = null;
			retNode = this.root;
		}
		else{
			
			buscaPosicao(this.root,key);
		}
		
		return retNode;
	}
	
	
	
	public Node buscaPosicao(Node node, String key){
		
		Node retNode = null;
		int res;
		
		res = key.compareToIgnoreCase(node.key);
		
		if(res < 0){ // se é para inserir a esquerda
			
			if(node.left == null){
				node.left = new Node(key);
				node.left.parent = node;
				retNode = node.left;
			}
			else
				buscaPosicao(node.left,key);
		  	}
		
		else if(res > 0){ // se é para inserir a direita
			
		   if(node.right == null){
			   node.right = new Node(key);
			   node.right.parent = node;
			   retNode = node.right;
		   }
		   else{
			   buscaPosicao(node.right, key);
		   }
		}
		
		return retNode;
		
	}
	
	public int alturaNodo (Node nodo,int curr){
		
		int ret = 0;
		
		if (nodo.left == null && nodo.right == null && curr > 0){ // se o nodo não é folha, acrescentar 1
			return curr + 1;
		}
		
		else if (nodo.left == null && nodo.right == null){
			return curr;
		}
		else {
			if (nodo.left != null)
				ret = alturaNodo(nodo.left, curr + 1);
			
			if (nodo.right != null)
				ret = alturaNodo(nodo.right, curr + 1); 
		}
		
		return ret;	
	}

	public Node procurar(String key){
		
		Node currentNode = this.root;
		this.comp = 0;
	   
		while(currentNode != null){
			
			res = key.compareToIgnoreCase(currentNode.key);
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
	
	public String[] procurarToArray(String key){
		
		Node resp = null;
		String[] ret = {"",""};
		
		resp = this.procurar(key);
		
		if (resp == null){
			return ret;
		}
		
		return ret;
	}
	
	public int deletar(String key){
		
		Node resp = procurar(key);
		
		if (resp != null){
			
			if (resp.left == null && resp.right == null){ // o nodo é uma folha
				
				if (resp.key.equals(resp.parent.left.key)){ // o nodo é folha esquerda do pai 
					resp.parent.left = null;
					return 1;
				}
				else { // o nodo é folha direita do pai
					resp.parent.right = null;
					return 1;
				}
			}
			else if (resp.left != null && resp.right == null){ // o nodo tem filho a esquerda
				
				if (resp.key.equals(resp.parent.left.key)){ // o nodo é folha esquerda do pai 
					resp.parent.left = resp.left;
					return 1;
				}
				else { // o nodo é folha direita do pai
					resp.parent.right = resp.left;
					return 1;
				}
				
			}
			else if (resp.left == null && resp.right != null){ // o nodo tem filho a direita
				
				if (resp.key.equals(resp.parent.left.key)){ // o nodo é folha esquerda do pai 
					resp.parent.left = resp.right;
					return 1;
				}
				else { // o nodo é folha direita do pai
					resp.parent.right = resp.right;
					return 1;
				}
				
			}
			else { // o nodo tem dois filhos
				Node sucessor = null;
				sucessor = buscaNodoEsquerdo(resp.right);
				
				if (sucessor.right != null){ // se sucessor tem filho a direita apontar a raiz do sucessor para esse filho
					sucessor.parent.left = sucessor.right;
				}
				
				if (resp.key.equals(resp.parent.left.key)){ // se nodo a ser removido é nodo filho esquerdo atualiza link na raiz para o sucesso
					resp.parent.left = sucessor;
				}
				else { // senão nodo removido é filho direito
					resp.parent.right = sucessor;
				}
			}
		}
		
		return 0;
		
	}
	
	private Node buscaNodoEsquerdo(Node nodo){
		
		Node nodoFinal;
				
		if (nodo.left != null){
			nodoFinal = buscaNodoEsquerdo(nodo.left);
		}
		else {
			nodoFinal = nodo;
		}
		
		return nodoFinal; 
	}
	
}
