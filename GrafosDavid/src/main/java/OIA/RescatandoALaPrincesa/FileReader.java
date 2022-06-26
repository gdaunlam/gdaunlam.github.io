package OIA.RescatandoALaPrincesa;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import OIA.Grafos.Grapth;
import OIA.Grafos.MatrixGraph;

public class FileReader {
	public PathFinder read(String path) {
		File fl = new File(path);
		Scanner sc = null;

		try {
			sc = new Scanner(fl); 
			double cantidadDeClaros = sc.nextDouble();
			double cantidadDeSenderos = sc.nextDouble();
			double cantidadDeDragones = sc.nextDouble();

			double princessNode = sc.nextDouble();
			double princeNode = sc.nextDouble();

			double[] dragonNodes = new double[(int) cantidadDeDragones];
			for (int i = 0; i < cantidadDeDragones; i++) {
				dragonNodes[i] = sc.nextDouble() - 1;
			}

			Grapth gra = new MatrixGraph((int) cantidadDeClaros);
			for (int i = 0; i < cantidadDeSenderos; i++) {
				int ini = sc.nextInt();
				int fin = sc.nextInt();
				Double cost = sc.nextDouble();
				gra.setEdge(ini - 1, fin - 1, cost);
				gra.setEdge(fin - 1, ini - 1, cost);
			}
			sc.close();

			PathFinder pf = new PathFinder(gra, princessNode - 1, princeNode - 1, dragonNodes);
			return pf;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (sc != null) {
				sc.close();
			}
		}

		return null;
	}
}
