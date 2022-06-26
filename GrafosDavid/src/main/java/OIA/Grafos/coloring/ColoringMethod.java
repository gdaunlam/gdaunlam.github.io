package OIA.Grafos.coloring;

import OIA.Grafos.Grapth;
import OIA.Grafos.coloring.order.Order;

public interface ColoringMethod {

	public Coloring paint(Grapth graph, Order order);
	
}

