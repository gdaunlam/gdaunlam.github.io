package OIA.Metro;

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

public class Metro {

	@Test
	public void test() {
		ListGraph mg = new ListGraph(6);
		mg.setEdge(0, 1, 1.0);
		mg.setEdge(1, 2, 1.0);
		mg.setEdge(3, 4, 1.0);
//		mg.setEdge(1, 3, 1.0);
//		mg.setEdge(3, 4, 1.0);
//		mg.setEdge(4, 6, 1.0);
//		mg.setEdge(5, 6, 1.0);

		this.contruir(mg);
//		2
	}

//	Otra implemetnacion era con dijkstra asignandole menos costo a
//	las aristas que tenian tuneles
//	ACTUALIZACION: lo anterior no aplica pues si hay un camino 
//	de tuneles solamente que son tantos que hacen mas factible
//	usar un puente entonces se va a ir por el puente
//	ACTUALIZACION: el parche para lo anterior es que el peso de 
//	los tuneles sea 0
	public void contruir(Grapth gr) {
		int[] identifiers = new int[gr.getNodes()];
		for (int i = 0; i < gr.getNodes(); i++) {
			identifiers[i] = i;
		}
		for (int i = 0; i < gr.getNodes(); i++) {//n
			for (int j = 0; j < gr.getNodes(); j++) {//n
				if (gr.getEdge(i, j) != null) {
					int identifierOfJ = identifiers[j];
					for (int j2 = 0; j2 < identifiers.length; j2++) {//n
						if (identifiers[j2] == identifierOfJ) {
							identifiers[j2] = identifiers[i];
						}
					}
				}
			}
		}
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < identifiers.length; i++) {
			set.add(identifiers[i]);
		}
		System.out.println(set.size()-1);
	}
}
