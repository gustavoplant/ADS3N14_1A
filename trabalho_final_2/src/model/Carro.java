package model;

import grafo.util.Vertice;

public class Carro {
	
	private double consumo; // em KM/L
	private double capTanque; // em litros
	private double tanque; // em litros
	private int tempoDirecao; // em minutos
	private double velocidade; // em Km/h
	private double odometro; // em km
	
		
	public double getConsumo() {
		return consumo;
	}

	public double getCapTanque() {
		return capTanque;
	}

	public double getTanque() {
		return tanque;
	}

	public int getTempoDirecao() {
		return tempoDirecao;
	}

	public double getVelocidade() {
		return velocidade;
	}

	public void setConsumo(double consumo) {
		this.consumo = consumo;
	}

	public void setCapTanque(double capTanque) {
		this.capTanque = capTanque;
	}

	public void setTanque(double tanque) {
		this.tanque = tanque;
	}

	public void setTempoDirecao(int tempoDirecao) {
		this.tempoDirecao = tempoDirecao;
	}
	
	public void setVelocidade(double velocidade) {
		this.velocidade = velocidade;
	}
		
	public double getOdometro() {
		return odometro;
	}

	public void setOdometro(double odometro) {
		this.odometro = odometro;
	}

	public Carro(double capTanque, double consumo, int tempoDirecao, double velocidade){
		this.capTanque = capTanque;
		this.consumo = consumo;
		this.tempoDirecao = tempoDirecao;
		this.velocidade = velocidade;
		this.tanque = this.capTanque;
		this.odometro = 0.0;
	}
	
	// reabastece o tanque completando-o
	public void reabastecer (){
		this.tanque = this.capTanque;
	}
	
	// desconta do tempo de dire��o e do tanque a km percorrida
	public void rodar(Vertice origem,Vertice destino){
		double km;
		km = calculaDistancia(origem, destino);
		
		// desconta gasolina
		this.tanque = this.tanque - (km / consumo);
		
		// desconta tempo de direcao
		this.tempoDirecao = tempoDirecao - (int)( km / velocidade * 60);
		
		// incrementa odometro
		this.odometro += km;
	}
	
	public boolean checarTempo(Vertice origem,Vertice destino){
		
		double km;
		km = calculaDistancia(origem, destino);
		
		if (this.tempoDirecao - ( km / velocidade * 60) >= 0 ){
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean checarTanque(Vertice origem,Vertice destino){
		
		double km;
		km = calculaDistancia(origem, destino);
		
		if (this.tanque - (km / consumo) >= 0 ){
			return true;
		}
		else {
			return false;
		}
	}
	
	private double calculaDistancia(Vertice origem,Vertice destino){
		return (float) Math.sqrt(Math.pow((destino.getPosX() - origem.getPosX()),2) + Math.pow((destino.getPosY() - origem.getPosY()),2));
	}
}