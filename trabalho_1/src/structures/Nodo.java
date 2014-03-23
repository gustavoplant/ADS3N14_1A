package structures;

public class Nodo<T> {
	private T chave;
	private Nodo<T> next;
	
	public Nodo()
	{
		chave = null;
		next = null;
	}

	public T getChave() {
		return chave;
	}

	public void setChave(T chave) {
		this.chave = chave;
	}

	public Nodo<T> getNext() {
		return next;
	}

	public void setNext(Nodo<T> next) {
		this.next = next;
	}
}