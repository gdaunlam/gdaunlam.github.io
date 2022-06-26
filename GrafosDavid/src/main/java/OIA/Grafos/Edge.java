package OIA.Grafos;

public class Edge implements Comparable<Edge> {
	int from;
	int to;
	Double cost;

	public Edge(int from, int to, double cost) {
		super();
		this.from = from;
		this.to = to;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o) {
		return this.cost.compareTo(o.cost);
	}
}
