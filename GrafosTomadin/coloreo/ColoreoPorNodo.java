package grafos.coloreo;

import java.util.List;

import grafos.Arista;
import grafos.Grafo;
import grafos.GrafoNoDirigido;
import grafos.Nodo;
import grafos.coloreo.orden.MetodoOrdenamiento;
import grafos.coloreo.orden.Orden;
import grafos.coloreo.orden.OrdenAleatorio;
import grafos.coloreo.orden.OrdenMatula;
import grafos.coloreo.orden.OrdenWelshPowell;

public class ColoreoPorNodo implements MetodoColoreo {

	@Override
	public Coloreo Pintar(Grafo g, Orden o) {
		int cantColores = 1;
		int color = 1;
		Coloreo coloreo = new Coloreo(g.getCantidadNodos());

		coloreo.incrementarColores();

		for (Nodo n : o.getOrden()) {
			if (coloreo.getColorDelNodo(n.getNumeroDeNodo()) == 0) {
				boolean noEstaPintado = true;

				while (noEstaPintado) {
					if (!adyacenteConColor(n.getNodosConectados(), color, coloreo)) {
						coloreo.setColor(n.getNumeroDeNodo(), color);
						noEstaPintado = false;
					} else {
						color++;

						if (color > cantColores) {
							cantColores++;
							coloreo.incrementarColores();
						}
					}
				}

				color = 1;
			}
		}

		return coloreo;
	}

	private boolean adyacenteConColor(List<Nodo> adyacentes, int color, Coloreo coloreo) {
		for (Nodo n : adyacentes) {
			if (coloreo.getColorDelNodo(n.getNumeroDeNodo()) == color)
				return true;
		}

		return false;
	}

	public static void main(String[] args) {
		int nodos = 5;
		GrafoNoDirigido g = new GrafoNoDirigido(nodos);
		Nodo n0 = new Nodo(0);
		Nodo n1 = new Nodo(1);
		Nodo n2 = new Nodo(2);
		Nodo n3 = new Nodo(3);
		Nodo n4 = new Nodo(4);

		g.addNodo(n0);
		g.addNodo(n1);
		g.addNodo(n2);
		g.addNodo(n3);
		g.addNodo(n4);

		g.addArista(new Arista(n0, 1, n1));
		g.addArista(new Arista(n1, 1, n2));
		g.addArista(new Arista(n1, 2, n3));
		g.addArista(new Arista(n3, 3, n4));

		Orden orden = new Orden(g.getCantidadNodos());
		MetodoOrdenamiento mo = new OrdenMatula();

		orden = mo.generarOrden(g);

		MetodoColoreo col = new ColoreoPorNodo();

		Coloreo c = col.Pintar(g, orden);

		System.out.println("Matula");

		for (int i : c.getColoresAsignados())
			System.out.print(i + " ");

		mo = new OrdenWelshPowell();
		orden = mo.generarOrden(g);

		c = col.Pintar(g, orden);

		System.out.println("\nWelsh-Powell");

		for (int i : c.getColoresAsignados())
			System.out.print(i + " ");

		mo = new OrdenAleatorio();
		orden = mo.generarOrden(g);

		c = col.Pintar(g, orden);

		System.out.println("\nAleatorio");

		for (int i : c.getColoresAsignados())
			System.out.print(i + " ");
	}
}
