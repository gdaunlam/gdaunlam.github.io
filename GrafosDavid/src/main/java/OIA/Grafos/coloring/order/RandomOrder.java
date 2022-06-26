package OIA.Grafos.coloring.order;

import java.util.ArrayList;
import java.util.Collections;

import OIA.Grafos.Grapth;

public class RandomOrder implements OrderMethod {

	@Override
	public Order generateOrder(Grapth graph) {
		ArrayList<Integer> order = new ArrayList<Integer>();
		for (int i = 0; i < graph.getNodes(); i++) {
			order.add(i);
		}
		Collections.shuffle(order);
		
		Integer[] shuffleOrder = new Integer[graph.getNodes()];
		order.toArray(shuffleOrder);
		return new Order(shuffleOrder);
	}
}
