package OIA.Grafos;

import java.util.LinkedList;
import java.util.List;

public class ListGraph extends Grapth {
	private List<Node>[] grapth;

	public ListGraph(int lenght) {
		this.grapth = new List[lenght];
		for (int i = 0; i < lenght; i++) {
			this.grapth[i] = new LinkedList<Node>();
		}
	}

	@Override
	public void setEdge(int origin, int destination, Double value) {
		for (Node node : this.grapth[origin]) {
			if (node.number == destination) {
				node.cost = value;
				return;
			}
		}
		this.grapth[origin].add(new Node(destination, value));
	}

	@Override
	public Double getEdge(int origin, int destination) {
		for (Node node : this.grapth[origin]) {
			if (node.number == destination) {
				return node.cost;
			}
		}
		return null;
	}

	@Override
	public int getNodes() {
		return grapth.length;
	}

	@Override
	public Double[] getAdjacents(int origin) {
		Double[] adjascents = new Double[this.grapth.length];
		for (Node node : this.grapth[origin]) {
			adjascents[(int)node.number] = node.cost;
		}
		
		return adjascents;
	}
}
