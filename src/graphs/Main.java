package graphs;

import java.util.Arrays;

public class Main {

	private static VertexVisitor pvv = new PrintVertexVisitor();

	public static void main(String[] args) {
		adjacencyMatrix();
		incidenceMatrix();
	}

	private static void incidenceMatrix() {
		Graph g = new IncidenceMatrixGraph(4);
		
		g.add(0, 1);
		g.add(0, 2);
		g.add(0, 3);
		g.add(2, 3);

		printInfo(g);
	}

	private static void adjacencyMatrix() {
		Graph g = new AdjacencyMatrixGraph(6);

		g.add(0, 0);
		g.add(0, 1);
		g.add(0, 4);
		g.add(1, 4);
		g.add(1, 2);
		g.add(2, 3);
		g.add(3, 4);
		g.add(3, 5);

		printInfo(g);
	}

	private static void printInfo(Graph g) {
		System.out.println(g);

		for (int i = 0; i < g.vertices(); i++) {
			int[] neighbors = g.neighbors(i);
			System.out.println(i + ": " + Arrays.toString(neighbors));

			System.out.print("DFS");
			g.dfs(i, pvv);
			System.out.println();
			
			System.out.print("BFS");
			g.bfs(i, pvv);
			System.out.println();
		}
	}

	private static class PrintVertexVisitor implements VertexVisitor {

		@Override
		public void visit(int v) {
			System.out.print(" -> " + v);
		}
		
	}

}
