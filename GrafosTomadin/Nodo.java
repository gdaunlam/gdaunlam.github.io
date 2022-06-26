package grafos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Nodo {
	private int grado;
	private String etiqueta = "";
	private int numeroDeNodo;
	private List<Arista> conexiones; // lista de todas las aristas del nodo
	private HashMap<Nodo, Integer> nodosDestino; // todos los nodos que se conectan con el nodo actual
	private boolean visitado = false;
	private int costo = 0; // solo usado para Dijkstra con cola de prioridad

	// solo usado para Dijkstra con cola de prioridad
	public Nodo(Nodo n, int costo) {
		this.etiqueta = n.etiqueta;
		this.grado = n.grado;
		this.numeroDeNodo = n.numeroDeNodo;
		this.conexiones = n.conexiones;
		this.nodosDestino = n.nodosDestino;
		this.costo = costo;
	}

	public Nodo(String etiqueta, int numNodo) {
		this.etiqueta = etiqueta;
		this.grado = 0;
		this.numeroDeNodo = numNodo;
		this.conexiones = new ArrayList<Arista>();
		nodosDestino = new HashMap<Nodo, Integer>();
	}

	public Nodo(int numNodo) {
		this.grado = 0;
		this.numeroDeNodo = numNodo;
		this.conexiones = new ArrayList<Arista>();
		nodosDestino = new HashMap<Nodo, Integer>();
	}

	public void addConexion(Arista a) {
		conexiones.add(a);
		nodosDestino.put(a.getDestino(), a.getPeso());
		incrementarGrado();
	}

	public int getPesoNodoDestino(Nodo n) {
		return nodosDestino.get(n) == null ? 0 : nodosDestino.get(n);
	}

	// Solo usado para Dijkstra con cola de prioridad
	public int getCosto() {
		return costo;
	}

	public List<Arista> getConexiones() {
		return conexiones;
	}

	public List<Nodo> getNodosConectados() {
		return nodosDestino.keySet().stream().collect(Collectors.toList());
	}

	public void setVisitado(boolean s) {
		visitado = s;
	}

	public boolean isVisitado() {
		return visitado;
	}

	public int getNumeroDeNodo() {
		return this.numeroDeNodo;
	}

	public String getEtiqueta() {
		return this.etiqueta;
	}

	public int getGrado() {
		return this.grado;
	}

	public void incrementarGrado() {
		this.grado++;
	}
}
