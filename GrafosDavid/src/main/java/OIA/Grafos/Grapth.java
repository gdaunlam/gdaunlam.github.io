package OIA.Grafos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class Grapth {
	abstract public void setEdge(int origin, int destination, Double value);

	abstract public Double getEdge(int origin, int destination);

	abstract public int getNodes();

	abstract public Double[] getAdjacents(int node);

	public DijkstraResult dijkstra(int ini) {
		Double[] minCosts = this.getAdjacents(ini);
		double[] precedents = new double[minCosts.length];
		List<Integer> noVisitedKeys = new LinkedList<Integer>();

		for (int i = 0; i < this.getNodes(); i++) {
			noVisitedKeys.add(i);
			precedents[i] = ini;
		}
		noVisitedKeys.remove(ini);

		while (noVisitedKeys.size() > 0) {
			// obtengo i
			Double iValue = Double.MAX_VALUE;
			Integer i = noVisitedKeys.get(0);
			for (Integer index : noVisitedKeys) {
				if (minCosts[index] != null && minCosts[index] < iValue) {
					iValue = minCosts[index];
					i = index;
				}
			}
			// quito a i de la lista
			noVisitedKeys.remove(i);
			// modifico los costos
			for (int j = 0; j < minCosts.length; j++) {
				Double costOfJ = minCosts[j];
				Double costOfI = minCosts[i];
				Double costFromIToJFromMatrix = this.getEdge(i, j);

				boolean existsAnotherWay = costOfI != null && costFromIToJFromMatrix != null;
				boolean isTheWayTohimself = j == ini;
				if (existsAnotherWay && !isTheWayTohimself) {
					if (costOfJ == null || costOfJ > costOfI + costFromIToJFromMatrix) {
						minCosts[j] = costOfI + costFromIToJFromMatrix;
						precedents[j] = i;
					}
				}
			}
		}

		return new DijkstraResult(precedents, minCosts);
	}

	public Grapth prim() {
		int ini = 0;
		Double[] minCosts = this.getAdjacents(ini);
		double[] precedents = new double[this.getNodes()];
		List<Integer> noVisitedKeys = new LinkedList<Integer>();
		MatrixGraph mg = new MatrixGraph(this.getNodes());

		for (int i = 0; i < this.getNodes(); i++) {
			noVisitedKeys.add(i);
			precedents[i] = ini;
		}
		noVisitedKeys.remove(ini);

		while (noVisitedKeys.size() > 0) {
			Double iValue = Double.MAX_VALUE;
			Integer i = noVisitedKeys.get(0);
			for (Integer index : noVisitedKeys) {
				if (minCosts[index] != null && minCosts[index] < iValue) {
					iValue = minCosts[index];
					i = index;
				}
			}
			noVisitedKeys.remove(i);

			for (int j = i; j < minCosts.length; j++) {
				Double costOfJFromMinCost = minCosts[j];
				Double costOfJFromMatrix = this.getEdge(i, j);

				if (costOfJFromMatrix != null) {
					if (costOfJFromMinCost == null || costOfJFromMinCost > costOfJFromMatrix) {
						minCosts[j] = costOfJFromMatrix;
						precedents[j] = i;
					}
				}
			}
		}
		for (int i = 0; i < precedents.length; i++) {
			mg.setEdge((int) i, (int) precedents[i], minCosts[i]);
		}

		return mg;
	}

	public Grapth Kruskal() {
		double[] identifiers = new double[this.getNodes()];
		List<Edge> edges = new ArrayList<Edge>();
		MatrixGraph mg = new MatrixGraph(this.getNodes());

		for (int i = 0; i < this.getNodes(); i++) {
			identifiers[i] = i;
		}

		for (int i = 0; i < this.getNodes(); i++) {
			for (int j = 0; j < this.getNodes(); j++) {
				if (this.getEdge(i, j) != null) {
					edges.add(new Edge(i, j, this.getEdge(i, j)));
				}
			}
		}
		edges.sort(null);

		for (Edge edge : edges) {
			boolean pathFinded = true;
			for (int i = 0; i < identifiers.length - 1; i++) {
				if (identifiers[i] != identifiers[i + 1]) {
					pathFinded = false;
				}
			}
			if (pathFinded) {
				return mg;
			}
			if (identifiers[edge.from] != identifiers[edge.to]) {
				mg.setEdge(edge.from, edge.to, edge.cost);
				double identifiersTo = identifiers[edge.to];
				for (int i = 0; i < identifiers.length; i++) {
					if (identifiers[i] == identifiersTo) {
						identifiers[i] = identifiers[edge.from];
					}
				}
			}
		}
		return mg;
	}

	public void BFS() {
		List<Integer> noVisitedKeys = new LinkedList<Integer>();
		boolean[] visitedKeys = new boolean[this.getNodes()];
		noVisitedKeys.add(0);

		while (noVisitedKeys.size() > 0) {
			int actual = noVisitedKeys.get(0);
			Double[] adjacents = this.getAdjacents(actual);
			for (int i = 0; i < adjacents.length; i++) {
				if (adjacents[i] != null && !visitedKeys[i]) {
					noVisitedKeys.add(i);
					visitedKeys[i] = true;
//					Hacer algo
					System.out.println(i);
				}
			}
			noVisitedKeys.remove(0);
		}
	}

	public Double[][] floyd() {
		Double[][] result = new Double[this.getNodes()][this.getNodes()];
		for (int i = 0; i < this.getNodes(); i++) {
			result[i] = this.getAdjacents(i);
		}

		for (int i = 0; i < this.getNodes(); i++) {
			for (int j = 0; j < this.getNodes(); j++) {
				for (int j2 = 0; j2 < this.getNodes(); j2++) {
					Double costOfIJ = result[j][j2];
					Double costOfIJ2 = result[j][i];
					Double costOfJ2J = result[i][j2];

					boolean existsAnotherWay = costOfIJ2 != null && costOfJ2J != null;
					boolean isTheWayTohimself = j == j2;
					if (existsAnotherWay && !isTheWayTohimself) {
						if (costOfIJ == null || costOfIJ > costOfIJ2 + costOfJ2J) {
							result[j][j2] = costOfIJ2 + costOfJ2J;
						}
					}
				}
			}
		}
		return result;
	}
}
