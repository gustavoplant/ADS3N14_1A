package model;

public class Contato {
	private String nome;
	private String tel;

	public Contato () {
		this.nome = null;
		this.tel = null;
	}
	
	public Contato (String nome,String tel){
		this.nome = nome;
		this.tel = tel;
	}

	public String getNome() {
		return nome;
	}

	public String getTel() {
		return tel;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
}
