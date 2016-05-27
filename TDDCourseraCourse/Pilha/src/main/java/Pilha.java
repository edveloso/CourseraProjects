
public class Pilha {

	private final Object[] elementos;
	private int quantidade;
	
	public Pilha(int maximo) {
		elementos = new Object[maximo];
	}

	public boolean estaVazia() {
		return quantidade == 0;
	}

	public int tamanho() {
		return quantidade;
	}

	public void empilha(Object elemento) {
		if(quantidade == elementos.length)
			throw new PilhaCheiaException("N�o � possivel empilhar mais elementos");
		this.elementos[quantidade] = elemento;
		quantidade++;
		
	}
	public Object topo() {
		return elementos[quantidade-1];
	}

	public Object desempilha() {
		if(estaVazia())
			throw new PilhaVaziaException("N�o � possivel desempilhar");
		Object topo = topo();
		quantidade--;
		return topo;
	}

}
