package OIA.Grafos;

import java.util.Arrays;

public class MatrixGraph extends Grapth {
	private Double[][] costMatrix;

	public MatrixGraph(int numberOfNodes) {
		costMatrix = new Double[numberOfNodes][numberOfNodes];
		for (Double[] ds : costMatrix) {
			Arrays.fill(ds, null);
		}
	}

	@Override
	public void setEdge(int origin, int destination, Double value) {
		costMatrix[origin][destination] = value;
	}

	@Override
	public Double getEdge(int origin, int destination) {
		return costMatrix[origin][destination];
	}

	@Override
	public int getNodes() {
		return costMatrix.length;
	}

	@Override
	public Double[] getAdjacents(int node) {
		return this.costMatrix[node].clone();
	}
}
