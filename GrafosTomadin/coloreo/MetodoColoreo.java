package grafos.coloreo;

import grafos.Grafo;
import grafos.coloreo.orden.Orden;

public interface MetodoColoreo {
	public Coloreo Pintar(Grafo g, Orden o);
}
