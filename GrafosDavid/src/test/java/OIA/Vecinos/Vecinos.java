package OIA.Vecinos;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import OIA.Grafos.Grapth;
import OIA.Grafos.ListGraph;
import OIA.RescatandoALaPrincesa.FileReader;
import OIA.RescatandoALaPrincesa.PathFinder;

public class Vecinos {

	@Test
	public void test() {
		ListGraph mg = new ListGraph(7);
		mg.setEdge(0, 1, 29.0);
		mg.setEdge(1, 4, 3.0);
		mg.setEdge(2, 0, 12.0);
		mg.setEdge(1, 2, 9.0);
		mg.setEdge(3, 4, 16.0);
		mg.setEdge(0, 3, 6.0);
		mg.setEdge(2, 4, 7.0);
		mg.setEdge(3, 5, 78.0);
		mg.setEdge(2, 6, 98.0);
		mg.setEdge(5, 0, 2.0);

		this.aliadar(mg);
	}

	public void aliadar(Grapth gr) {
		Double[][] result = gr.floyd();
	}
}
