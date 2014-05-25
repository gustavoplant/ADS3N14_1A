
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
    
    public void inserir(String chave, int cor){
    	
        if(this.raiz == null){
            this.raiz = new Node(chave,cor);
            this.raiz.parent = null;
        }else{
            inserirValor(this.raiz,chave,cor);
        }
    }
    
    private void inserirValor(Node node,String key){
    	
		int res;
		res = key.compareToIgnoreCase(node.key);
		
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
    
    private void inserirValor(Node node,String key,int cor){
    	
		int res;
		res = key.compareToIgnoreCase(node.key);
		
		if(res < 0){ // se é para inserir a esquerda
			if(node.left == null){
				node.left = new Node(key,cor);
				node.left.parent = node;
				caso1(node);
			}
			else {
				inserirValor(node.left,key);
			}
		}
		else if(res > 0){ // se é para inserir a direita
			if(node.right == null){
				node.right = new Node(key,cor);
				node.right.parent = node;
				caso1(node);
			}
			else{
				inserirValor(node.right,key);
			}
		}
    	
    }
    
    private Node getTio(Node no){
        
        if(no.parent!= null && no.parent.parent == null){
            if(no.parent.left == no){
                return no.right;
            }else{
                return no.left;
            }
        }else if(no.parent != null && no.parent.parent != null){
            if(no.parent.parent.left == no.parent){
                return no.parent.parent.right;
            }else{
                return no.parent.parent.left;
                
            }
        }else{
            return null;
        }
        
    }
    
    private void caso1(Node no){
        if(no.parent == null){
            no.color = 1;
        }else{
            caso2(no);
        }
    }
    
    private void caso2(Node no){
        if(no.parent.color == 1){
        
        }else{
            caso3(no);
        }
    }
    private void caso3(Node no){
        
        if(getTio(no).color == 2){
            no.parent.color = 1;
            getTio(no).color = 1;
            if(no.parent.parent != null){
                no.parent.parent.color = 2;
                caso1(no.parent.parent);
            } 
        }else{
            caso4(no);
        }
    }
    
    private void caso4(Node no){
        if(no == no.parent.right && no.parent == no.parent.parent.left){
            rotacionaEsq(no.parent);
            no = no.left;
        }else if(no == no.parent.left && no.parent == no.parent.parent.right){
            rotacionaDir(no.parent);
            no = no.right;
        }
        caso5(no);
    }
    
    private void caso5(Node no){
        no.parent.color = 1;
        getTio(no).color = 2;
        if(no == no.parent.left && no.parent ==no.parent.parent.left){
            rotacionaDir(no.parent.parent);
        }else{
            assert no == no.parent.right && no.parent == no.parent.parent.right;
            rotacionaEsq(no.parent.parent);
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
