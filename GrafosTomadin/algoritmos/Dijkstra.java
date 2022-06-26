package grafos.algoritmos;

import java.util.ArrayList;
import java.util.PriorityQueue;

import grafos.Arista;
import grafos.Grafo;
import grafos.GrafoDirigido;
import grafos.GrafoNoDirigido;
import grafos.Nodo;

public class Dijkstra {
	private int[] vectorCostosMinimos; // D
	private int[] vectorPredecesores; // P
	private int[][] matAdy;
	private ArrayList<Nodo> listaNodos;
	private Nodo nodoInicial;

	public Dijkstra(Grafo g, Nodo nodoInicial) {
		vectorCostosMinimos = new int[g.getCantidadNodos()];
		vectorPredecesores = new int[g.getCantidadNodos()];
		listaNodos = (ArrayList<Nodo>) g.getNodos();
		matAdy = g.getMatrizAdyacencia();
		this.nodoInicial = nodoInicial;
	}

	public int[] getVectorCostosMinimos() {
		return vectorCostosMinimos;
	}

	public int[] getVectorPredecesores() {
		return vectorPredecesores;
	}

	private ArrayList<Nodo> getSucesores(Nodo n) {
		ArrayList<Nodo> nodos = new ArrayList<Nodo>(n.getConexiones().size());

		for (Arista a : n.getConexiones()) {
			nodos.add(a.getDestino());
		}

		return nodos;
	}

	public void AlgoritmoDijkstra_SinCola() {
		for (int i = 0; i < listaNodos.size(); i++) {
			vectorCostosMinimos[i] = matAdy[nodoInicial.getNumeroDeNodo()][i];
		}

		vectorCostosMinimos[nodoInicial.getNumeroDeNodo()] = 0;
		nodoInicial.setVisitado(true);

		Nodo v = nodoInicial;
		int nodosVisitados = 1;

		while (nodosVisitados < listaNodos.size()) {
			// v = nodo de menor distancia a s que no fue visitado aun
			int menorDistancia = Integer.MAX_VALUE;

			for (Nodo n : listaNodos) {
				if (!n.isVisitado() && menorDistancia > vectorCostosMinimos[n.getNumeroDeNodo()]) {
					menorDistancia = vectorCostosMinimos[n.getNumeroDeNodo()];
					v = n;
				}
			}

			v.setVisitado(true);
			nodosVisitados++;

			for (Nodo w : getSucesores(v)) {
				if (vectorCostosMinimos[w.getNumeroDeNodo()] > vectorCostosMinimos[v.getNumeroDeNodo()]
						+ v.getPesoNodoDestino(w)) { // peso(v, w))
					vectorCostosMinimos[w.getNumeroDeNodo()] = vectorCostosMinimos[v.getNumeroDeNodo()]
							+ v.getPesoNodoDestino(w); // peso(v, w);
					vectorPredecesores[w.getNumeroDeNodo()] = v.getNumeroDeNodo();
				}
			}
		}
	}

	public void AlgoritmoDijkstra_ConCola() {
		vectorCostosMinimos[nodoInicial.getNumeroDeNodo()] = 0;

		PriorityQueue<Nodo> pq = new PriorityQueue<Nodo>(listaNodos.size(), (n1, n2) -> {
			return n1.getCosto() - n2.getCosto();
		});

		pq.add(new Nodo(nodoInicial, 0));

		while (!pq.isEmpty()) {
			Nodo u = pq.poll();

			u.setVisitado(true);

			for (Nodo v : u.getNodosConectados()) {
				if (!v.isVisitado()
						&& vectorCostosMinimos[v.getNumeroDeNodo()] > vectorCostosMinimos[u.getNumeroDeNodo()]
								+ u.getPesoNodoDestino(v)) { // peso(u, v))
					vectorCostosMinimos[v.getNumeroDeNodo()] = vectorCostosMinimos[u.getNumeroDeNodo()]
							+ u.getPesoNodoDestino(v); // peso(u, v);
					vectorPredecesores[v.getNumeroDeNodo()] = u.getNumeroDeNodo();
					pq.add(new Nodo(v, vectorCostosMinimos[v.getNumeroDeNodo()]));
				}
			}
		}
	}
}
