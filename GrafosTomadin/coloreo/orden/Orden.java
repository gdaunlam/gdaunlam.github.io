package grafos.coloreo.orden;

import grafos.Nodo;

public class Orden {
	private Nodo[] orden;

	public Orden(int tam) {
		orden = new Nodo[tam];
	}

	public Nodo[] getOrden() {
		return orden;
	}

	public void set(Nodo n, int pos) {
		orden[pos] = n;
	}
}
