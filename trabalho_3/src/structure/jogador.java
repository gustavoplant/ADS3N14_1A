package structure;

public class jogador {
	
	private String nome = null;
	private int pontos = 0;
	
	public String getNome() {
		return nome;
	}

	public int getPontos() {
		return pontos;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
	public jogador (String nome){
		this.nome = nome;
		this.pontos = 15;
	}
	
	public void adcPontos (int qtd){
		this.pontos = this.pontos + qtd;
	}
	
	public void sbtPontos (int qtd){
		this.pontos = this.pontos - qtd;
	}
}
