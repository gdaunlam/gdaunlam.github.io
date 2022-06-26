package OIA.Grafos;

import static org.junit.Assert.*;

import org.junit.Test;

public class FloydTest {

	@Test
	public void test() {
		ListGraph mg = new ListGraph(3);
		mg.setEdge(0, 1, 1.0);
		mg.setEdge(0, 2, 5.0);
		mg.setEdge(1, 2, 2.0);
		mg.setEdge(2, 0, 5.0);

		Double[][] floyd = mg.floyd();

		for (int i = 0; i < floyd.length; i++) {
			for (int j = 0; j < floyd.length; j++) {
				System.out.print(floyd[i][j] + "|");
			}
			System.out.println();
		}
	}
}
