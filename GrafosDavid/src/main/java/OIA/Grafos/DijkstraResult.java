package OIA.Grafos;


import java.util.ArrayList;
import java.util.List;

public class DijkstraResult {
	public double[] precedents;
	public Double[] costs;

	public DijkstraResult(double[] precedents, Double[] costs) {
		super();
		this.precedents = precedents;
		this.costs = costs;
	}

	public List<Double> getPrecedents(double i) {
		List<Double> res = new ArrayList<Double>();
		double anterior = precedents[(int) i];
		res.add(i);

		while (anterior != i) {
			res.add(anterior);
			i = anterior;
			anterior = precedents[(int) anterior];
		}

		return res;
	}
}
