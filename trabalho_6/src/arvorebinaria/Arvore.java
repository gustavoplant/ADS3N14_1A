/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arvorebinaria;

/**
 *
 * @author Andre
 */
public class Arvore {
    
    public Nodo raiz;
    
    public Arvore(){
        this.raiz        =   null;
    }
    
    public void inserir(String chave,int val){
        if(this.raiz == null){
            this.raiz = new Nodo(chave,val,true);
            this.raiz.pai = null;
        }else{
            inserirValor(this.raiz,chave,val);
        }
    }
    
    private void inserirValor(Nodo no,String chave,int val){
        if(val < no.valor){
           if(no.esq == null){
               no.esq = new Nodo(chave,val,false);
               no.esq.pai = no;
               caso1(no);
//               System.out.println("inserindo: "+val+" no pai: "+no.valor+" cor do pai: "+no.cor);
           }else{
               inserirValor(no.esq,chave,val);
           } 
        }else if(val > no.valor){
            if(no.dir == null){
               no.dir = new Nodo(chave,val,false);
               no.dir.pai = no;
               caso1(no);
//               getTio(no);
//               System.out.println("inserindo: "+val+" no pai: "+no.valor+" cor do pai: "+no.cor);
           }else{
               inserirValor(no.dir,chave,val);
           }
        }
    }
    
    private Nodo getTio(Nodo no){
        
        if(no.pai != null && no.pai.pai == null){
            if(no.pai.esq == no){
//                System.out.println("valor: "+no.valor +" meu pai: "+no.pai.valor);
//                System.out.println("sou filho da direita");
                return no.dir;
            }else{
//                System.out.println("valor: "+no.valor +" meu pai: "+no.pai.valor);
//                System.out.println("sou filho da esquerda");
                return no.esq;
            }
        }else if(no.pai != null && no.pai.pai != null){
            if(no.pai.pai.esq == no.pai){
//                System.out.println("valor: "+no.valor +" meu tio: "+no.pai.pai.dir.valor);
//                System.out.println("retonr tio da direita");
                return no.pai.pai.dir;
            }else{
//                System.out.println("valor: "+no.valor +" meu tio: "+no.pai.pai.esq.valor);
//                System.out.println("retonr tio da esquerda");
                return no.pai.pai.esq;
                
            }
        }else{
//            System.out.println("nao tem pai: "+no.valor);
            return null;
        }
        
    }
    
    private void caso1(Nodo no){
        if(no.pai == null){
            no.cor = true;
        }else{
            caso2(no);
        }
    }
    
    private void caso2(Nodo no){
//        System.out.println(no.pai.valor+" caso 2 pro valor: "+no.valor);
        if(no.pai.cor == true){
        
        }else{
            caso3(no);
        }
    }
    private void caso3(Nodo no){
        
        if(getTio(no).cor == false){
            no.pai.cor = true;
            getTio(no).cor = true;
            if(no.pai.pai != null){
                no.pai.pai.cor = false;
                caso1(no.pai.pai);
            } 
        }else{
            caso4(no);
        }
    }
    
    private void caso4(Nodo no){
        if(no == no.pai.dir && no.pai == no.pai.pai.esq){
            rotacionaEsq(no.pai);
            no = no.esq;
        }else if(no == no.pai.esq && no.pai == no.pai.pai.dir){
            rotacionaDir(no.pai);
            no = no.dir;
        }
        caso5(no);
    }
    
    private void caso5(Nodo no){
        no.pai.cor = true;
        getTio(no).cor = false;
        if(no == no.pai.esq && no.pai ==no.pai.pai.esq){
            rotacionaDir(no.pai.pai);
        }else{
            assert no == no.pai.dir && no.pai == no.pai.pai.dir;
            rotacionaEsq(no.pai.pai);
        }
    }
    
    
    private void rotacionaEsq(Nodo no){
        Nodo n = no.dir;
        substituiNodo(no, n);
        no.dir = n.esq;
        if(n.esq != null){
            n.esq.pai = no;
        }
        n.esq = no;
        no.pai = n;
//        System.out.println("rotacioa esq");
    }
    private void rotacionaDir(Nodo no){
        Nodo n = no.esq;
        substituiNodo(no, n);
        no.esq = n.dir;
        if(n.dir != null){
            n.dir.pai = no;
        }
        n.dir = no;
        no.pai = n;
//        System.out.println("rotacioa dir");
    }
    
    private void substituiNodo(Nodo velho,Nodo novo){
        if(velho.pai == null){
            this.raiz = novo;
        }else{
            if(velho == velho.pai.esq){
                velho.pai.esq = novo;
            }else{
                velho.pai.dir = novo;
            }
        }
        if(novo != null){
            novo.pai = velho.pai;
        }
    }
    
    public void busca(Nodo no,int chave){
        
        if(chave == this.raiz.valor){
            System.out.println("O valor procurado é a raiz.");
        }else{
            if(chave == no.valor){
                System.out.println("Encontrou o valor: "+no.chave+" ;para a chave: "+no.valor);
            }else{
                if(chave > no.valor){
                    busca(no.dir,chave);
                }else if(chave < no.valor){
                    busca(no.esq,chave);
                }
            }
        }
    }
    
     public void caminhaPrefixado(Nodo no) {
         if(no != null){
             System.out.print(no.valor+" ");
             caminhaPrefixado(no.esq);
             caminhaPrefixado(no.dir);
             
         }
     }
     public void caminhaPosfixado(Nodo no) {
         if(no != null){
             caminhaPosfixado(no.esq);
             caminhaPosfixado(no.dir);
             System.out.print(no.valor + " ");
         }
     }
     public void caminhaOrdenado(Nodo no) {
         if(no != null){
             caminhaOrdenado(no.esq);
             System.out.print(no.valor + " ");
             caminhaOrdenado(no.dir);
         }
     }
     
     public Nodo removeNo(Nodo no,int val){
         
         if(no != null){
             if(val > no.valor){
                 no.dir = removeNo(no.dir, val);
             }else if(val < no.valor){
                 no.esq = removeNo(no.esq, val);
             }else{
                 if(no.dir != null && no.esq != null){
                     no.valor = encontraMin(no.dir).valor;
                     no.dir = removeMin(no.dir);
                 }else{
                     no = (no.esq != null) ? no.esq : no.dir;
                 }
             }
             return no;
         }else{
             return null;
         }
     }
     
     public Nodo removeMin(Nodo no){
         if(no != null){
             if(no.esq != null){
                 no.esq = removeMin(no.esq);
                 return no;
             }else{
                 return no.dir;
             }
         }
         return null;
     }
     public Nodo encontraMin(Nodo no){
         if(no != null){
             while(no.esq != null){
                 no = no.esq;
             }
         }
         return no;
     }
     
     private Nodo rmCaso1(Nodo no){
         return no = null;
     }
     private Nodo rmCaso2(Nodo no){
         return no = null;
     }
    
}
