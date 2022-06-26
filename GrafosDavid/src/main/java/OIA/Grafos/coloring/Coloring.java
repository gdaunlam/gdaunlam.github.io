package OIA.Grafos.coloring;

public class Coloring {
		
		private int colors;
		private int[] colorAssignment;
		
		Coloring(int[] colorAssignment){
			this.colorAssignment = colorAssignment;
			this.colors = colorAssignment.length;
		}
		
		public int getColors() {
			return colors;
		}
		
		public int[] getColorAssignment() {
			return colorAssignment;
		}
		
		public int getColor(int node) {
			return colorAssignment[node];
		}

	}
