package grafos.algoritmos;

import java.util.Iterator;
import java.util.PriorityQueue;

import grafos.Arista;
import grafos.GrafoNoDirigido;
import grafos.Nodo;

public class Prim {
	public static GrafoNoDirigido AlgoritmoPrim_Cola(GrafoNoDirigido gnd) {
		int verticesTotales = gnd.getCantidadNodos(); // Obtengo la cantidad total de vértices
		Nodo vOrigen = gnd.getNodos().get(0);

		if (vOrigen != null) {
			GrafoNoDirigido gNuevo = new GrafoNoDirigido(verticesTotales);
			gnd.getNodos().stream().forEach((v) -> {
				gNuevo.addNodo(new Nodo(v.getEtiqueta(), v.getNumeroDeNodo()));
			});

			// Para esta implementación, los pesos son números enteros.
			PriorityQueue<Arista> cola = new PriorityQueue<>(
					(Arista a1, Arista a2) -> Integer.compare(a1.getPeso(), a2.getPeso()));

			int cont = 0;

			while (cont < verticesTotales - 1) {
				for (Iterator<Arista> it = vOrigen.getConexiones().iterator(); it.hasNext();) {
					Arista arc = it.next();

					if (!arc.getDestino().isVisitado()) {
						cola.offer(arc);
					}
				}

				Arista arista = cola.poll();

				arista.getOrigen().setVisitado(true);

				if (!arista.getDestino().isVisitado()) {
					arista.getDestino().setVisitado(true);
					gNuevo.addArista(arista);
					cont++;
					vOrigen = arista.getDestino();
				}
			}

			return gNuevo;
		}

		return null;
	}
}
