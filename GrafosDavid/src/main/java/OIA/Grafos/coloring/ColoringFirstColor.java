package OIA.Grafos.coloring;

import java.util.ArrayList;

import OIA.Grafos.Grapth;
import OIA.Grafos.coloring.order.Order;

//Supongo que es primero intento terminar con un color
public class ColoringFirstColor implements ColoringMethod {

	@Override
	public Coloring paint(Grapth graph, Order order) {
		ArrayList<Integer> colors = new ArrayList<Integer>();
		int[] colorAssignment = new int[graph.getNodes()];
		int actualAssignments = 0;
		int actualColor = 1;

		while (actualAssignments < graph.getNodes()) {
			for (int orderIndex : order.getOrder()) {
				if (colorAssignment[orderIndex] != 0) {
					continue;
				}
				Double[] adjs = graph.getAdjacents(orderIndex);
				boolean canGetAColor = true;
				for (int i = 0; i < adjs.length; i++) {
					if (adjs[i] != null && colorAssignment[i] == actualColor) {
						canGetAColor = false;
					}
				}
				if (canGetAColor) {
					colorAssignment[orderIndex] = actualColor;
					actualAssignments++;
				}
			}
			actualColor++;
		}

		return new Coloring(colorAssignment);
	}

}
