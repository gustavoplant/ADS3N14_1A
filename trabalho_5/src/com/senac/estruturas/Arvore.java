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
	
	public int[] inserir(String[] key){
		
		int [] inf = new int[2];
		ArrayList<String[]> tmpAL = new ArrayList<>();
		
		if (this.root == null){
			this.root = new Node(key);
			this.root.parent = null;
			inf[0] = 1;
			inf[1] = 1;
		}
		else{
			
			buscaPosicao(this.root,key);
			inf[0] = alturaNodo(procurar(key[0]).parent,0);
			
			tmpAL = tPrefixa(tmpAL, this.root);
			inf[1] = tmpAL.size();
			
		}
		
		return inf;
	}
	
	
	
	private void buscaPosicao(Node node, String[] key){
		
		int res;
		
		
		res = key[0].compareToIgnoreCase(node.key[0]);
		
		if(res < 0){ // se é para inserir a esquerda
			
			if(node.left == null){
				node.left = new Node(key);
				node.left.parent = node;
			}
			else
				buscaPosicao(node.left,key);
		  	}
		
		else if(res > 0){ // se é para inserir a direita
			
		   if(node.right == null){
			   node.right = new Node(key);
			   node.right.parent = node;
		   }
		   else{
			   buscaPosicao(node.right, key);
		   }
		}
		
	}
	
	private int alturaNodo (Node nodo,int curr){
		
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
	
	public String[] procurarToArray(String key){
		
		Node resp = null;
		String[] ret = {"",""};
		
		resp = this.procurar(key);
		
		if (resp == null){
			return ret;
		}
		
		ret[0] = resp.key[0];
		ret[1] = resp.key[1];
		return ret;
	}
	
	public int deletar(String key){
		
		Node resp = procurar(key);
		
		if (resp != null){
			
			if (resp.left == null && resp.right == null){ // o nodo é uma folha
				
				if (resp.key[0].equals(resp.parent.left.key[0])){ // o nodo é folha esquerda do pai 
					resp.parent.left = null;
					return 1;
				}
				else { // o nodo é folha direita do pai
					resp.parent.right = null;
					return 1;
				}
			}
			else if (resp.left != null && resp.right == null){ // o nodo tem filho a esquerda
				
				if (resp.key[0].equals(resp.parent.left.key[0])){ // o nodo é folha esquerda do pai 
					resp.parent.left = resp.left;
					return 1;
				}
				else { // o nodo é folha direita do pai
					resp.parent.right = resp.left;
					return 1;
				}
				
			}
			else if (resp.left == null && resp.right != null){ // o nodo tem filho a direita
				
				if (resp.key[0].equals(resp.parent.left.key[0])){ // o nodo é folha esquerda do pai 
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
				
				if (resp.key[0].equals(resp.parent.left.key[0])){ // se nodo a ser removido é nodo filho esquerdo atualiza link na raiz para o sucesso
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
	
	public ArrayList<String[]> tPrefixa(ArrayList<String[]> param, Node raiz){
		
		
		if (raiz != null ){
			//System.out.print(raiz.key[0] + " ");
			param.add(raiz.key);
			tPrefixa(param,raiz.left);
			tPrefixa(param,raiz.right);
		}
		
		return param;
		
	}
	
	 public ArrayList<String[]> tInfixa (ArrayList<String[]> param, Node raiz){
		 
		 if (raiz != null){
			 tInfixa(param,raiz.left);
			 param.add(raiz.key);
			 tInfixa(param,raiz.right);
		 }
		 
		 return param;
	 }

	 public ArrayList<String[]> tPosFixa(ArrayList<String[]> param, Node raiz){
		 
		 if (raiz != null){
			 tPosFixa(param,raiz.left);
			 tPosFixa(param,raiz.right);
			 param.add(raiz.key);
		 }
		 
		 return param;
	 }
	 
	 public ArrayList<String[]> bLargura (ArrayList<String[]> param, Node raiz){
		/*
		 * função para gerar uma listagem dos itens da árvore utilizando o método de busca em largura
		 */
		 
		 ArrayList<String[]> ret = new ArrayList<>();
		 Queue<Node> lista = new LinkedList<>();
		 Node tmpNode = null;
		 
		 lista.add(raiz);
		 
		 while (!lista.isEmpty()){
			 
			 tmpNode = lista.remove();
			 ret.add(tmpNode.key);
			 
			 if (tmpNode.left != null){
				 lista.add(tmpNode.left);
			 }
			 
			 if (tmpNode.right != null){
				 lista.add(tmpNode.right);
			 }
			 
		 }
		 
		 return ret;
	 }
	 
	 
	 public ArrayList<String[]> bProfundidade (ArrayList<String[]> param, Node raiz){
		 ArrayList<String[]> ret = new ArrayList<>();
		 Stack<Node> pilha = new Stack<>();
		 Node tmpNode = null;
		 
		 pilha.push(raiz);
		 		 
		 while (! pilha.isEmpty()){
			 
			 tmpNode = pilha.pop();	

			 ret.add(tmpNode.key);

			 if (tmpNode.left != null){
				 pilha.push(tmpNode.left);
			 }
			 
			 if (tmpNode.right != null){
				 pilha.push(tmpNode.right);
			 }
			 
		 }
		 
		 return ret;
	 }
}
