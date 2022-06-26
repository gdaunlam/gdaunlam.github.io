package grafos;

import java.util.ArrayList;

public class GrafoNoDirigido extends Grafo {
	private int costo;

	public GrafoNoDirigido(int cantNodos) {
		this.nodos = new ArrayList<Nodo>(cantNodos);
		this.cantidadNodos = cantNodos;
		this.matrizAdyacencia = new int[this.cantidadNodos][this.cantidadNodos];

		for (int i = 0; i < cantidadNodos; i++) {
			for (int j = 0; j < cantidadNodos; j++) {
				if (i == j)
					this.matrizAdyacencia[i][j] = 0;
				else
					this.matrizAdyacencia[i][j] = Integer.MAX_VALUE;
			}
		}

		costo = 0;
	}

	@Override
	public void addArista(Arista a) {
		aristas.add(a);
		this.cantidadAristas++;
		this.matrizAdyacencia[a.getOrigen().getNumeroDeNodo()][a.getDestino().getNumeroDeNodo()] = a.getPeso();
		a.getOrigen().addConexion(a);
		a.getDestino().addConexion(new Arista(a.getDestino(), a.getPeso(), a.getOrigen()));
		costo += a.getPeso();
	}

	public int getCosto() {
		return this.costo;
	}
}
