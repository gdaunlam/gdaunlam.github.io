package grafos.coloreo;

import java.util.List;

import grafos.Grafo;
import grafos.Nodo;
import grafos.coloreo.orden.Orden;

public class ColoreoPorColor implements MetodoColoreo {

	@Override
	public Coloreo Pintar(Grafo g, Orden o) {
		Coloreo coloreo = new Coloreo(g.getCantidadNodos());
		int color = 0; // primer color

		while (!coloreo.todosEstanPintados()) {
			coloreo.incrementarColores();
			color++; // primer color

			for (Nodo n : o.getOrden()) {
				if (coloreo.getColorDelNodo(n.getNumeroDeNodo()) == 0
						&& !adyacenteConColor(n.getNodosConectados(), color, coloreo)) {
					coloreo.setColor(n.getNumeroDeNodo(), color);
				}
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
}
