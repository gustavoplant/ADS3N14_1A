package model;

public class Navio{
	
	private int type;
	private int pieces;
	
	public int getType() {
		return type;
	}

	public int getPieces() {
		return pieces;
	}
	
	public Navio(){
		
	}
	
	public Navio (int size, int type){
		this.type = type;
		this.pieces = size;
	}
	
	public boolean isLost(){
		
		this.pieces--;
		
		if (this.pieces == 0){
			return true;
		}
		
		return false;
	}



}
