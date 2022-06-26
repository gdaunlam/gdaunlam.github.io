package grafos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public abstract class Grafo {
	protected int[][] matrizAdyacencia;
	protected List<Nodo> nodos;
	protected List<Arista> aristas;
	protected int cantidadNodos;
	protected int cantidadAristas;

	public Grafo() {
		this.aristas = new ArrayList<Arista>();
		this.cantidadAristas = 0;
	}

	public Grafo(int cantNodos) {
		this.nodos = new ArrayList<Nodo>(cantNodos);
		this.aristas = new ArrayList<Arista>();
		this.cantidadNodos = cantNodos;
		this.cantidadAristas = 0;
		this.matrizAdyacencia = new int[this.cantidadNodos][this.cantidadNodos];

		for (int i = 0; i < cantidadNodos; i++) {
			for (int j = 0; j < cantidadNodos; j++) {
				if (i == j)
					this.matrizAdyacencia[i][j] = 0;
				else
					this.matrizAdyacencia[i][j] = Integer.MAX_VALUE;
			}
		}
	}

	public void addNodo(Nodo n) {
		nodos.add(n);
	}

	public void addArista(Arista a) {
		aristas.add(a);
		this.cantidadAristas++;
		a.getOrigen().addConexion(a);
		this.matrizAdyacencia[a.getOrigen().getNumeroDeNodo()][a.getDestino().getNumeroDeNodo()] = a.getPeso();
	}

	public int[][] BFS(Nodo inicio) {
		int distancia[] = new int[cantidadNodos];
		int padre[] = new int[cantidadNodos];

		// recorremos todos los vértices del grafo inicializándolos a NO_VISITADO,
		// distancia INFINITA y padre de cada nodo NULL
		for (Nodo n : nodos) {
			n.setVisitado(false);
			distancia[n.getNumeroDeNodo()] = Integer.MAX_VALUE; /* distancia infinita si el nodo no es alcanzable */
			padre[n.getNumeroDeNodo()] = 0;
		}

		inicio.setVisitado(true);
		distancia[inicio.getNumeroDeNodo()] = 0;
		padre[inicio.getNumeroDeNodo()] = 0;

		Queue<Nodo> Q = new LinkedList<>();

		Q.add(inicio);

		Iterator<Nodo> it = Q.iterator();

		while (it.hasNext()) {
			// extraemos el nodo u de la cola Q y exploramos todos sus nodos adyacentes
			Nodo u = Q.poll();

			for (Nodo v : u.getNodosConectados()) {
				if (!v.isVisitado()) {
					v.setVisitado(true);
					distancia[v.getNumeroDeNodo()] = distancia[u.getNumeroDeNodo()] + 1;
					padre[v.getNumeroDeNodo()] = u.getNumeroDeNodo();
					Q.add(v);
				}
			}
		}

		int ret[][] = new int[2][];

		ret[0] = distancia;
		ret[1] = padre;

		return ret;
	}

	public int[] DFS() {
		int padre[] = new int[cantidadNodos];

		for (Nodo n : nodos) {
			n.setVisitado(false);
			padre[n.getNumeroDeNodo()] = 0;
		}

		for (Nodo u : nodos) {
			if (!u.isVisitado()) {
				padre = DFS_Visitar(u, padre);
			}
		}

		return padre;
	}

	private int[] DFS_Visitar(Nodo u, int[] padre) {
		u.setVisitado(true);

		for (Nodo v : u.getNodosConectados()) {
			if (!v.isVisitado()) {
				padre[v.getNumeroDeNodo()] = u.getNumeroDeNodo();
				padre = DFS_Visitar(v, padre);
			}
		}

		return padre;
	}

	public int[][] getMatrizAdyacencia() {
		return matrizAdyacencia;
	}

	public List<Nodo> getNodos() {
		return nodos;
	}

	public List<Arista> getAristas() {
		return aristas;
	}

	public int getCantidadNodos() {
		return cantidadNodos;
	}

	public int getCantidadAristas() {
		return cantidadAristas;
	}
}
