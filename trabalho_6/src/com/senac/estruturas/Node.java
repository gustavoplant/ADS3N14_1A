package com.senac.estruturas;

	public class Node {
		protected String key;
		protected int color; // 0 black - 1 red
		protected Node left;
		protected Node right;
		protected Node parent;
		
  	
	public Node(){}
	
	public Node(String key){
		this.key = key;
	}
	
	public Node(String key,int color){
		this.key = key;
		this.color = color;
	}

}
