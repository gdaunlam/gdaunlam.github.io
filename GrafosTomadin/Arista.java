package grafos;

public class Arista {
	private Nodo origen;
	private int peso;
	private Nodo destino;
	
	public Arista(Nodo origen, int peso, Nodo destino) {
		this.origen = origen;
		this.peso = peso;
		this.destino = destino;
	}

	public Nodo getOrigen() {
		return origen;
	}

	public int getPeso() {
		return peso;
	}

	public Nodo getDestino() {
		return destino;
	}
}
