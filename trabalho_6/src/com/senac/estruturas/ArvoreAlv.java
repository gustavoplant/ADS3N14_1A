package com.senac.estruturas;

import java.util.ArrayList;

public class ArvoreAlv extends Arvore{
		
	public int calcFatorBalanc(Node no){
		
		int altEsq, altDir;
		
		altEsq = super.alturaNodo(no.left, 0);
		altDir = super.alturaNodo(no.right, 0);
		
		return altEsq - altDir;
		
	}

}
