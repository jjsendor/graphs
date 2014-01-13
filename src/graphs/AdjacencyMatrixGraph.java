package graphs;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Graph implementation based on adjacency matrix.
 */
public class AdjacencyMatrixGraph implements Graph {

	private boolean[][] matrix;	//	adjacency matrix
	private int n;	// number of vertices

	/**
	 * Creates new graph.
	 *
	 * @param v	number of vertices in the graph
	 */
	public AdjacencyMatrixGraph(int v) {
		this.n = v;
		matrix = new boolean[n][n];
	}

	@Override
	public boolean adjacent(int x, int y) {
		return matrix[x][y];
	}

	@Override
	public int[] neighbors(int x) {
		int[] t = new int[n];
		int j = 0;

		for (int i = 0; i < n; i++) {
			if (matrix[x][i]) {
				t[j++] = i;
			}
		}

		int[] neighbors = new int[j];
		System.arraycopy(t, 0, neighbors, 0, j);

		return neighbors;
	}

	@Override
	public boolean add(int x, int y) {
		boolean exists = matrix[x][y];
		matrix[x][y] = true;
		matrix[y][x] = true;

		return !exists;
	}

	@Override
	public boolean delete(int x, int y) {
		boolean exists = matrix[x][y];
		matrix[x][y] = false;
		matrix[y][x] = false;

		return exists;
	}

	@Override
	public int vertices() {
		return n;
	}

	@Override
	public void dfs(int start, VertexVisitor vv) {
		boolean visited[] = new boolean[n];

		Stack<Integer> stack = new Stack<Integer>();

		stack.push(start);

		do {
			int x = stack.pop();

			if (!visited[x]) {
				vv.visit(x);
				visited[x] = true;

				for (int i = 0; i < n; i++) {
					if (matrix[x][i]) {
						stack.push(i);
					}
				}
			}
		} while (!stack.empty());
	}

	@Override
	public void bfs(int start, VertexVisitor vv) {
		boolean visited[] = new boolean[n];

		LinkedList<Integer> queue = new LinkedList<Integer>();

		queue.add(start);
		visited[start] = true;

		do {
			int x = queue.remove();

			vv.visit(x);

			for (int i = 0; i < n; i++) {
				if (matrix[x][i]) {
					if (!visited[i]) {
						queue.add(i);
						visited[i] = true;
					}
				}
			}
		} while (!queue.isEmpty());
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j]) {
					sb.append("1 ");
				}
				else {
					sb.append("0 ");
				}
			}
			sb.append(System.getProperty("line.separator"));
		}

		return sb.toString();
	}

}
