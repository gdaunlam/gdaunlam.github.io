package grafos.algoritmos;

import grafos.Arista;
import grafos.Grafo;
import grafos.GrafoDirigido;
import grafos.Nodo;

public class FloydWarshall {
	private int numNodos;
	private int[][] distancia; // Matriz de adyacencia, para almacenar los arcos del grafo
	private boolean[][] warshallC; // Matriz de Existencias de Caminos (Warshall - Path)

	public FloydWarshall(Grafo g) {
		numNodos = g.getCantidadNodos();
		warshallC = new boolean[numNodos][numNodos];
		distancia = g.getMatrizAdyacencia();

		if (g.getClass() == GrafoDirigido.class) {
			for (Arista a : g.getAristas()) {
				distancia[a.getOrigen().getNumeroDeNodo()][a.getDestino().getNumeroDeNodo()] = a.getPeso();
			}
		} else {
			for (Arista a : g.getAristas()) {
				distancia[a.getOrigen().getNumeroDeNodo()][a.getDestino().getNumeroDeNodo()] = a.getPeso();
				distancia[a.getDestino().getNumeroDeNodo()][a.getOrigen().getNumeroDeNodo()] = a.getPeso();
			}
		}
	}

	public void AlgoritmoFloydWarshall() {
		// Obtener la matriz de existencia de caminos
		for (int i = 0; i < numNodos; i++)
			for (int j = 0; j < numNodos; j++)
				warshallC[i][j] = (distancia[i][j] != Integer.MAX_VALUE);

		int valSum;

		// Iterar
		for (int k = 0; k < numNodos; k++) {
			for (int i = 0; i < numNodos; i++) {
				for (int j = 0; j < numNodos; j++) {
					warshallC[i][j] = (warshallC[i][j] || (warshallC[i][k] && warshallC[k][j]));

					// Para evitar que la suma de infinitos de un numero negativo se hace esta
					// pregunta. Si alguno de los valores es "infinito" se asigna otro "infinito",
					// caso contrario se procede a asignar la suma
					valSum = (distancia[i][k] == Integer.MAX_VALUE || distancia[k][j] == Integer.MAX_VALUE)
							? Integer.MAX_VALUE
							: (distancia[i][k] + distancia[k][j]);
					distancia[i][j] = Math.min(distancia[i][j], valSum);
				}
			}
		}
	}

	public int[][] getDistancias() {
		return distancia;
	}

	public boolean[][] getCaminos() {
		return warshallC;
	}
}
