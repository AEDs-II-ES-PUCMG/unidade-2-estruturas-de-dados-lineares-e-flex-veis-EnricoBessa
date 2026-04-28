import java.util.NoSuchElementException;

public class Pilha<E> {

	private Celula<E> topo;
	private Celula<E> fundo;
	private Celula<E> atual;

	public Pilha() {

		Celula<E> sentinela = new Celula<E>();
		fundo = sentinela;
		topo = sentinela;

	}

	public boolean vazia() {
		return fundo == topo;
	}

	public void empilhar(E item) {

		topo = new Celula<E>(item, topo);
	}

	public E desempilhar() {

		E desempilhado = consultarTopo();
		topo = topo.getProximo();
		return desempilhado;

	}

	public E consultarTopo() {

		if (vazia()) {
			throw new NoSuchElementException("Nao há nenhum item na pilha!");
		}

		return topo.getItem();

	}

	void imprimir() {
		System.out.println(atual.getItem());
		atual = atual.getProximo();
	}

	void imprime_certo() {
		Celula<E> atual = topo;
		certo(atual);
	}

	void certo(Celula<E> atual) {
		if (atual != fundo) {
			certo(atual.getProximo());
			System.out.println(atual.getItem());
		}
	}

	/**
	 * Cria e devolve uma nova pilha contendo os primeiros numItens elementos
	 * do topo da pilha atual.
	 * 
	 * Os elementos são mantidos na mesma ordem em que estavam na pilha original.
	 * Caso a pilha atual possua menos elementos do que o valor especificado,
	 * uma exceção será lançada.
	 *
	 * @param numItens o número de itens a serem copiados da pilha original.
	 * @return uma nova instância de Pilha<E> contendo os numItens primeiros
	 *         elementos.
	 * @throws IllegalArgumentException se a pilha não contém numItens elementos.
	 */
	public Pilha<E> subPilha(int numItens) {
		Pilha<E> retorno = new Pilha<E>();
		Pilha<E> auxiliar = new Pilha<E>();

		for (int i = 0; i < numItens; i++) {
			retorno.empilhar(desempilhar());
			topo = topo.getProximo();
		}

		while (!retorno.vazia()) {
			auxiliar.empilhar(retorno.desempilhar());
		}

		return auxiliar;
	}
}