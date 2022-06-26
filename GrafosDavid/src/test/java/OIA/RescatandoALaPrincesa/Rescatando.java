package OIA.RescatandoALaPrincesa;

import static org.junit.Assert.*;

import org.junit.Test;

public class Rescatando {

	@Test
	public void test() {
		FileReader fr = new FileReader();
		PathFinder pf = fr.read("src\\main\\java\\OIA\\RescatandoALaPrincesa\\01");
		pf.solve();
	}

}
