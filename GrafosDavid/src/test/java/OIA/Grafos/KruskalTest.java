package OIA.Grafos;

import static org.junit.Assert.*;

import org.junit.Test;

public class KruskalTest {

	@Test
	public void test() {
		MatrixGraph mg = new MatrixGraph(6);
		mg.setEdge(0, 1, 6.0);
		mg.setEdge(0, 2, 1.0);
		mg.setEdge(0, 3, 5.0);

		mg.setEdge(1, 0, 6.0);
		mg.setEdge(1, 2, 6.0);
		mg.setEdge(1, 4, 3.0);

		mg.setEdge(4, 1, 3.0);
		mg.setEdge(4, 2, 6.0);
		mg.setEdge(4, 5, 6.0);

		mg.setEdge(2, 0, 1.0);
		mg.setEdge(2, 1, 6.0);
		mg.setEdge(2, 3, 4.0);
		mg.setEdge(2, 4, 6.0);
		mg.setEdge(2, 5, 6.0);

		mg.setEdge(3, 0, 5.0);
		mg.setEdge(3, 2, 4.0);
		mg.setEdge(3, 5, 2.0);

		mg.setEdge(5, 3, 2.0);
		mg.setEdge(5, 2, 6.0);
		mg.setEdge(5, 4, 6.0);

		Grapth prim = mg.Kruskal();

		for (int i = 0; i < prim.getNodes(); i++) {
			for (int j = 0; j < prim.getNodes(); j++) {
				Double cost = prim.getEdge(i, j);
				if (cost != null) {
					System.out.println(i+"|"+j+"|"+cost);	
				}
			}
		}
//		1|0|6.0
//		2|0|1.0
//		3|2|4.0
//		4|1|3.0
//		5|3|2.0
	}
}
