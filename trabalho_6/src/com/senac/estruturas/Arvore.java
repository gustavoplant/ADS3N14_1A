
package com.senac.estruturas;


public class Arvore {
    
    public Node raiz;
	public int comp = 0;
    public int rot = 0;
    private boolean rbt = false;
    
    public int getComp() {
		return comp;
	}
	public int getRot() {
		return rot;
	}

	public void setComp(int comp) {
		this.comp = comp;
	}

	public void setRot(int rot) {
		this.rot = rot;
	}
    
    public Arvore(){
        this.raiz = null;
    }
    
    public void inserir(String chave){
    	
    	this.rbt = false;
    	
        if(this.raiz == null){
            this.raiz = new Node(chave);
            this.raiz.parent = null;
        }else{
            inserirValor(this.raiz,chave);
        }
    }
    
    public void inserir(String chave, boolean cor){
    	
    	this.rbt = true;
    	
        if(this.raiz == null){
            this.raiz = new Node(chave,true);
            this.raiz.parent = null;
        }else{
            inserirValor(this.raiz,chave,cor);
        }
    }
    
    private void inserirValor(Node node,String key){
    	
		int res;
		res = key.compareToIgnoreCase(node.key);
		this.comp++;
		
		if(res < 0){ // se é para inserir a esquerda
			if(node.left == null){
				node.left = new Node(key);
				node.left.parent = node;
			}
			else {
				inserirValor(node.left,key);
			}
		}
		else if(res > 0){ // se é para inserir a direita
			if(node.right == null){
				node.right = new Node(key);
				node.right.parent = node;
			}
			else{
				inserirValor(node.right,key);
			}
		}
    }
    
    private void inserirValor(Node node,String key,boolean cor){
    	
		int res;
		res = key.compareToIgnoreCase(node.key);
		this.comp++;
		
		if(res < 0){ // se é para inserir a esquerda
			if(node.left == null){
				node.left = new Node(key,cor);
				node.left.parent = node;
				caso1(node.left);
			}
			else {
				inserirValor(node.left,key,cor);
			}
		}
		else if(res > 0){ // se é para inserir a direita
			if(node.right == null){
				node.right = new Node(key,cor);
				node.right.parent = node;
				caso1(node.right);
			}
			else{
				inserirValor(node.right,key,cor);
			}
		}
    	
    }
        
    private Node getTio(Node no){
    	
    	if (no.parent.parent != null){
    		
    		if (no.parent.parent.right == no.parent){
    			if (no.parent.parent.left != null){
    				return no.parent.parent.left;
    			}
    		}
    		else if (no.parent.parent.left == no.parent){
    			if (no.parent.parent.right != null){
    				return no.parent.parent.right;
    			}
    		}
    	}

    	return new Node();
        
    }
    
    private Node getIrmao(Node no){
    	if (no.parent.left == no){
    		if (no.parent.right == null){
    			return new Node();
    		}
    		return no.parent.right;
    		
    	}
    	else {
    		if (no.parent.left == null){
    			return new Node();
    		}
    		return no.parent.left;
    	}
    }
    
    private void caso1(Node no){
        if(no.parent == null){
            no.color = true;
        }
        else{
        	caso2(no);
        }
    }
    
    private void caso2(Node no){
    	
        if(no.parent.color == false){
        	caso3(no);
        }
        
    }
    private void caso3(Node no){
    	
	    if(getTio(no).color == false && no.parent.color == false){
	        no.parent.color = true;
	        getTio(no).color = true;
            caso1(no.parent.parent); 
	    }else{
	        caso4(no);
	    }
	    
    }
    
    private void caso4(Node no){
    	
    	Node tmpParent = no.parent; 
        if(no.parent.color == false && getTio(no).color == true){
        	if (no.parent.left == no && no.parent.parent.right == no.parent){
        		rotacionaDir(no.parent);
        	}
        	else if (no.parent.right == no && no.parent.parent.left == no.parent){
        		rotacionaEsq(no.parent);
        	}
        	caso5(tmpParent);
        }
    }
    
    
    private void caso5(Node no){
    	
    	if(no.parent.color == false && getTio(no).color == false){
            no.parent.color = true;
            getTio(no).color = true;
            no.parent.parent.color = false;
    	
	    	if (no.parent.left == no && no.parent.parent.left == no.parent){
	    		rotacionaDir(no.parent.parent);
	    	}
	    	else if (no.parent.right == no && no.parent.parent.right == no.parent){
	    		rotacionaEsq(no.parent.parent);
	    	}
    	}
    }
    
    
    private void rotacionaEsq(Node no){
    	//System.out.println("rotacionou a esquerda");
    	this.rot++;
        Node n = no.right;
        substituiNodo(no, n);
        no.right = n.left;
        if(n.left != null){
            n.left.parent = no;
        }
        n.left = no;
        no.parent = n;
    }
    private void rotacionaDir(Node no){
    	//System.out.println("rotacionou a direita");
    	this.rot++;
        Node n = no.left;
        substituiNodo(no, n);
        no.left = n.right;
        if(n.right != null){
            n.right.parent = no;
        }
        n.right = no;
        no.parent = n;
    }
    
    private void substituiNodo(Node velho,Node novo){
        if(velho.parent == null){
            this.raiz = novo;
        }else{
            if(velho == velho.parent.left){
                velho.parent.left = novo;
            }else{
                velho.parent.right = novo;
            }
        }
        if(novo != null){
            novo.parent = velho.parent;
        }
    }
    
    
    public int alturaRaiz(){
    	return this.alturaNodo(this.raiz,0);
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
		
		Node currentNode = this.raiz;
		this.comp = 0;
	   
		while(currentNode != null){
			
			this.comp++;
			int res = key.compareToIgnoreCase(currentNode.key);
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
	
	public int deletar(String key){
		
		this.comp = 0;
		this.rot = 0;
		boolean r = false;
		
		Node resp = procurar(key);
		
		if (resp != null){
			
			if (resp.left == null && resp.right == null){ // o nodo é uma folha
				
				if (resp == resp.parent.left){ // o nodo é folha esquerda do pai 
					resp.parent.left = null;
					return 1;
				}
				else { // o nodo é folha direita do pai
					resp.parent.right = null;
					return 1;
				}
			}
			else if (resp.left != null && resp.right == null){ // o nodo tem filho a esquerda
				
				if (resp == resp.parent.left){ // o nodo é folha esquerda do pai 
					resp.parent.left = resp.left;
					
					// se é uma arvore RB pintar o nodo de preto
					if (this.rbt == true && resp.color == true){
						remCaso1(resp.parent.left);
					}
					
					return 1;
				}
				else { // o nodo é folha direita do pai
					resp.parent.right = resp.left;
					
					// se é uma arvore RB pintar o nodo de preto
					if (this.rbt == true && resp.color == true){
						remCaso1(resp.parent.right);
					}
					
					return 1;
				}
				
			}
			else if (resp.left == null && resp.right != null){ // o nodo tem filho a direita
				
				if (resp == resp.parent.left){ // o nodo é folha esquerda do pai 
					resp.parent.left = resp.right;
					
					// se é uma arvore RB pintar o nodo de preto
					if (this.rbt == true && resp.color == true){
						remCaso1(resp.parent.left);
					}
					
					return 1;
				}
				else { // o nodo é folha direita do pai
					resp.parent.right = resp.right;
					
					// se é uma arvore RB pintar o nodo de preto
					if (this.rbt == true && resp.color == true){
						remCaso1(resp.parent.right);
					}					
					
					return 1;
				}
				
			}
			else { // o nodo tem dois filhos
				Node sucessor = null;
				sucessor = buscaNodoEsquerdo(resp.right);
				
				if (sucessor.right != null){ // se sucessor tem filho a direita apontar a raiz do sucessor para esse filho
					sucessor.parent.left = sucessor.right;
				}
				
				if (resp.parent != null){ // se não é a raiz
				
					if (resp == resp.parent.left){ // se nodo a ser removido é nodo filho esquerdo atualiza link na raiz para o sucesso
						resp.parent.left = sucessor;
					}
					else { // senão nodo removido é filho direito
						resp.parent.right = sucessor;
					}
				}
				else { // senão atualiza a raiz
					
					sucessor.left = raiz.left;
					sucessor.right = raiz.right;
					sucessor.color = true;
					sucessor.parent = null;
					this.raiz = sucessor;
					r = true;			
				}
				
				// se é um nodo RB e preto
				if (this.rbt == true && resp.color == true && r == false){
					remCaso1(sucessor);
				}
			}
			return 1;
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
     
	private void remCaso1(Node no){
		if (no != this.raiz){
			remCaso2(no);
		}
	}
	
	private void remCaso2(Node no){
		
		if (no.color == true && no.parent.color == true && getIrmao(no).color == false){
			no.parent.color = false;
			getIrmao(no).color = true;
			
			if (no.parent.left == no){
				rotacionaEsq(no.parent);
			}
			else {
				rotacionaDir(no.parent);
			}
			
			
		}
		remCaso3(no);
	}
	
	private void remCaso3(Node no){
		
		if (getIrmao(no) != null && getIrmao(no).left != null && getIrmao(no).right != null){
			if (no.color == true && no.parent.color == true && getIrmao(no).color == true && getIrmao(no).left.color == true && getIrmao(no).right.color == true){
				getIrmao(no).color = false;
				remCaso1(no);
			}
		}
		remCaso4(no);
	}
	
	private void remCaso4(Node no){
		
		if (getIrmao(no) != null && getIrmao(no).left != null && getIrmao(no).right != null){
			
			if (no.color == true && getIrmao(no).color == true && getIrmao(no).left.color == true && getIrmao(no).right.color == true && no.parent.color == false ){	
				no.parent.color = true;
				getIrmao(no).color = false;
			}
			else {
				remCaso5(no);
			}
		}
		
		remCaso5(no);
	}
	
	private void remCaso5(Node no){
		
		if (getIrmao(no) != null && getIrmao(no).left != null && getIrmao(no).right != null){
			if (no == no.parent.left && getIrmao(no).color == true && getIrmao(no).right.color == true && getIrmao(no).left.color == false ){
				getIrmao(no).color = false;
				getIrmao(no).left.color = true;
				rotacionaDir(getIrmao(no));
				remCaso6(no);
			}
			else if (no == no.parent.right && getIrmao(no).color == true && getIrmao(no).right.color == true && getIrmao(no).left.color == false ){
				getIrmao(no).color = false;
				getIrmao(no).left.color = true;
				rotacionaEsq(getIrmao(no));
				remCaso6(no);
			}
		}
		
	}
	
	private void remCaso6(Node no){
		
		if (getIrmao(no) != null && getIrmao(no).right != null ){
			if (no == no.parent.left && getIrmao(no).color == true && getIrmao(no).right.color == false){
				getIrmao(no).color = no.parent.color;
				no.parent.color = true;
				getIrmao(no).right.color = true;
				rotacionaEsq(no.parent);
			}
			else if (no == no.parent.right && getIrmao(no).color == true && getIrmao(no).right.color == false){
				getIrmao(no).color = no.parent.color;
				no.parent.color = true;
				getIrmao(no).right.color = true;
				rotacionaDir(no.parent);
			}
		}
	}
}
