package OIA.Coloring;

import static org.junit.Assert.*;

import org.junit.Test;

import OIA.Grafos.Grapth;
import OIA.Grafos.ListGraph;
import OIA.Grafos.coloring.Coloring;
import OIA.Grafos.coloring.ColoringFirstColor;
import OIA.Grafos.coloring.ColoringMethod;
import OIA.Grafos.coloring.order.OrderMethod;
import OIA.Grafos.coloring.order.WelshPowelOrder;

public class ColoringTest {

	@Test
	public void test() {
		ListGraph mg = new ListGraph(5);
		mg.setEdge(0, 1, 1.0);
		mg.setEdge(1, 0, 1.0);
		mg.setEdge(1, 3, 1.0);
		mg.setEdge(3, 1, 1.0);
		mg.setEdge(0, 3, 1.0);
		mg.setEdge(3, 0, 1.0);
		
		mg.setEdge(3, 4, 1.0);
		mg.setEdge(3, 4, 1.0);
		mg.setEdge(2, 4, 1.0);
		mg.setEdge(4, 2, 1.0);
		
		ColoringMethod cm = new ColoringFirstColor();
		OrderMethod om = new WelshPowelOrder();
		
		Coloring colors = cm.paint(mg, om.generateOrder(mg));
		
		for (int i = 0; i < colors.getColors(); i++) {
			System.out.print(i+" "+colors.getColor(i));
			System.out.println();
		}
	}
}
