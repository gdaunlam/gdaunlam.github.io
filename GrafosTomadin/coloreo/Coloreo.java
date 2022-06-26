package grafos.coloreo;

public class Coloreo {
	private int colores;
	private int[] coloresAsignados;
	private int nodosPintados; // este me dice si se pintaron todos los nodos

	public Coloreo(int cantidadNodos) {
		coloresAsignados = new int[cantidadNodos];
		nodosPintados = 0;

		for (int i = 0; i < coloresAsignados.length; i++) {
			coloresAsignados[i] = 0;
		}
	}

	public boolean todosEstanPintados() {
		return nodosPintados == coloresAsignados.length;
	}

	public void setColor(int nodo, int color) {
		coloresAsignados[nodo] = color;
		nodosPintados++;
	}

	public void incrementarColores() {
		this.colores++;
	}

	public int getColores() {
		return colores;
	}

	public int[] getColoresAsignados() {
		return coloresAsignados;
	}

	public int getColorDelNodo(int nodo) {
		return coloresAsignados[nodo];
	}
}
