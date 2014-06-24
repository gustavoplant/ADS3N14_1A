package grafo.util;

public class Aresta {
    public Vertice origem;
    public Vertice destino;
    public double custo;
    public double distancia;

    public Aresta(Vertice origem, Vertice destino, Double custo) {
        this.origem = origem;
        this.destino = destino;
        this.custo = custo;
        calculaDistancia();
    }
    
    public Vertice getOrigem() {
        return this.origem;
    }
    
    public Vertice getDestino() {
        return this.destino;
    }
    
    public double getCusto() {
        return this.custo;
    }
    
	public void calculaDistancia(){
		this.distancia = (float) Math.sqrt(Math.pow((this.destino.getPosX() - this.origem.getPosX()),2) + Math.pow((this.destino.getPosY() - this.origem.getPosY()),2));
	}
}
