
package com.senac.estruturas;


public class Arvore {
    
    public Node raiz;
    
    public Arvore(){
        this.raiz = null;
    }
    
    public void inserir(String chave){
    	
        if(this.raiz == null){
            this.raiz = new Node(chave);
            this.raiz.parent = null;
        }else{
            inserirValor(this.raiz,chave);
        }
    }
    
    public void inserir(String chave, boolean cor){
    	
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
		
		if(res < 0){ // se � para inserir a esquerda
			if(node.left == null){
				node.left = new Node(key);
				node.left.parent = node;
			}
			else {
				inserirValor(node.left,key);
			}
		}
		else if(res > 0){ // se � para inserir a direita
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
		
		if(res < 0){ // se � para inserir a esquerda
			if(node.left == null){
				node.left = new Node(key,cor);
				node.left.parent = node;
				caso1(node.left);
			}
			else {
				inserirValor(node.left,key,cor);
			}
		}
		else if(res > 0){ // se � para inserir a direita
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
	        no.parent.parent.color = false;
            caso1(no.parent.parent); 
	    }else{
	        caso4(no);
	    }
	    
    }
    
    private void caso4(Node no){
        if(no.parent.color == false && getTio(no).color == true){
        	if (no.parent.right == no && no.parent.parent.left == no.parent){
        		rotacionaEsq(no.parent);
        	}
        	else if (no.parent.parent.right == no.parent && no.parent.left == no){
        		rotacionaDir(no);
        		no = no.parent;
        	}
        }
        caso5(no.parent);
    }
    
    private void caso5(Node no){
    	

    	if(no.parent.color == false && getTio(no).color == true){
            no.parent.color = true;
            getTio(no).color = false;
    	}
    	
    	if (no.parent == no.parent.parent.right){
    		rotacionaEsq(no.parent.parent);
    	}
    	else {
    		rotacionaDir(no.parent.parent);
    	}
        
    }
    
    
    private void rotacionaEsq(Node no){
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
    
     public Node removeNo(Node no,String key){
    	 
    	 int res;
         
         if(no != null){
        	 
        	 res = key.compareToIgnoreCase(no.key);

        	 if(res < 0){ // se chave nodo maior
        		 no.left = removeNo(no.left, key);
        	 }
        	 else if(res > 0){ // se key maior que nodo
        		 no.right = removeNo(no.right, key);
        	 }
        	 else{
        		 
                 if(no.right != null && no.left != null){
                     no.key = encontraMin(no.right).key;
                     no.right = removeMin(no.right);
                 }else{
                     no = (no.left != null) ? no.left : no.right;
                 }
        	 }
             return no;
         }
         else{
             return null;
         }
     }
     
     public Node removeMin(Node no){
         if(no != null){
             if(no.left != null){
                 no.left = removeMin(no.left);
                 return no;
             }else{
                 return no.right;
             }
         }
         return null;
     }
     
     public Node encontraMin(Node no){
         if(no != null){
             while(no.left != null){
                 no = no.left;
             }
         }
         return no;
     }
     
     private Node rmCaso1(Node no){
         return no = null;
     }
     private Node rmCaso2(Node no){
         return no = null;
     }
    
}
