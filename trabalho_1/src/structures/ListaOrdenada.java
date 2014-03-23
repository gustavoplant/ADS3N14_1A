package structures;

public class ListaOrdenada<T extends Comparable<T>>
				extends ListaEncadeada<T>
{	
	public Nodo<T> procuraNodo(Nodo<T> needle)
	{
		Nodo<T> atual = getHead();
		Nodo<T> anterior = null;
		T chaveNeedle = needle.getChave();
		
		while (atual != null) {
			T chaveAtual = atual.getChave();
			int cmp = chaveNeedle.compareTo(chaveAtual);
			if (cmp == 0)
				return atual; 
			if (cmp < 0)
				return anterior;
			anterior = atual;
			atual = atual.getNext();
		}
		return anterior;
	}
	
	@Override
	public void append(Nodo<T> novo)
	{
		insert(novo);
	}
	
	@Override
	public void insert(Nodo<T> novo, Nodo<T> anterior)
	{
		insert(novo);
	}
	
	@Override
	public void insert(Nodo<T> novo)
	{
		Nodo<T> anterior = procuraNodo(novo);
		
		if (anterior == null) {
			novo.setNext(head);
			head = novo;
			if (tail == null)
				tail = novo;
		} else {
			novo.setNext(anterior.getNext());
			anterior.setNext(novo);
			if (tail == anterior)
				tail = novo;
		}
		
	}
}
