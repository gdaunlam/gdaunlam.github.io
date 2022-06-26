package OIA.InspeccionandoLaReserva;

import OIA.Grafos.DijkstraResult;
import OIA.Grafos.Grapth;

public class Solution {
	private Grapth clarosMatrix;
	private double princessNode;
	private double princeNode;
	private double[] dragonNodes;

	public Solution(Grapth matrix, double princessNode, double princeNode, double[] dragonNodes) {
		this.clarosMatrix = matrix;
		this.princessNode = princessNode;
		this.princeNode = princeNode;
		this.dragonNodes = dragonNodes;
	}

	public void solve() {
		DijkstraResult dr = clarosMatrix.dijkstra((int) princessNode);
		if (dr.costs[(int) princeNode] == 0) {
			System.out.println("NO HAY CAMINO");
			return;
		}
		for (double dragonNode : dragonNodes) {
			if (dr.costs[(int) dragonNode] <= dr.costs[(int) princeNode]) {
				System.out.println("INTERCEPTADO");
			}
			return;
		}
		for (Double i : dr.getPrecedents(this.princeNode)) {
			System.out.print((i + 1) + "|");
		}
//		1.0|2.0|6.0|9.0| si comentas el resto, sino INTERCEPTADO
	};
}
