package grafos.coloreo.orden;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import grafos.Grafo;
import grafos.Nodo;

public class OrdenAleatorio implements MetodoOrdenamiento {

	@Override
	public Orden generarOrden(Grafo g) {
		Orden orden = new Orden(g.getCantidadNodos());

		for (Nodo n : g.getNodos()) {
			orden.set(n, n.getNumeroDeNodo());
		}

		orden = shuffle(orden.getOrden());

		return orden;
	}

	// Implementing Fisher–Yates shuffle
	private Orden shuffle(Nodo[] nodos) {
		// If running on Java 6 or older, use `new Random()` on RHS here
		Random rnd = ThreadLocalRandom.current();

		for (int i = nodos.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			// Simple swap
			Nodo a = nodos[index];
			nodos[index] = nodos[i];
			nodos[i] = a;
		}

		Orden nuevoOrden = new Orden(nodos.length);

		for (int i = 0; i < nodos.length; i++) {
			nuevoOrden.set(nodos[i], i);
		}

		return nuevoOrden;
	}
}
