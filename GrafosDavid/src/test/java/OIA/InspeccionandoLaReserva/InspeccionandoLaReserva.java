package OIA.InspeccionandoLaReserva;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import OIA.Grafos.Grapth;
import OIA.Grafos.ListGraph;
import OIA.RescatandoALaPrincesa.FileReader;
import OIA.RescatandoALaPrincesa.PathFinder;

public class InspeccionandoLaReserva {

	@Test
	public void test() {
		ListGraph mg = new ListGraph(10);
        mg.setEdge(0,1,1.0);
        mg.setEdge(0,8,1.0);
        mg.setEdge(1,6,1.0);
        mg.setEdge(1,2,1.0);
        mg.setEdge(2,3,1.0);
        mg.setEdge(3,5,1.0);
        mg.setEdge(3,4,1.0);
        mg.setEdge(4,7,1.0);
        mg.setEdge(4,9,1.0);
        mg.setEdge(5,4,1.0);
        mg.setEdge(5,7,1.0);
        mg.setEdge(6,5,1.0);
        mg.setEdge(7,9,1.0);
        mg.setEdge(8,2,1.0);
        mg.setEdge(8,9,1.0);

		this.inspeccionar(mg);
//		14
	}
	
	public void inspeccionar(Grapth gr) {
		List<Integer> noVisitedKeys = new LinkedList<Integer>();
		noVisitedKeys.add(0);
		int respuesta = 0;
		
		while (noVisitedKeys.size() > 0) {
			int actual = noVisitedKeys.get(0);
			Double[] adjacents = gr.getAdjacents(actual);
			int numberOfAdyascents = 0;

			for (int i = 0; i < adjacents.length; i++) {
				if (adjacents[i] != null ) {
					noVisitedKeys.add(i);
					numberOfAdyascents++;
				}
			}
			if(numberOfAdyascents == 0) {
				respuesta++;
			}
			noVisitedKeys.remove(0);
		}
		
		System.out.println(respuesta);
	}

}
