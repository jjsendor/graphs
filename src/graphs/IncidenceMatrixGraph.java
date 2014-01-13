package graphs;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Graph implementation based on incidence matrix.
 */
public class IncidenceMatrixGraph implements Graph {

	private int m, n;	// number of edges and vertices
	private boolean matrix[][];	// incidence matrix

	/**
	 * Creates new graph.
	 *
	 * @param v	number of vertices
	 */
	public IncidenceMatrixGraph(int v) {
		this.n = v;
		this.m = 0;
		matrix = new boolean[n][m];
	}

	@Override
	public boolean adjacent(int x, int y) {
		for (int i = 0; i < m; i++) {
			if (matrix[x][i] && matrix[y][i]) {
				return true;
			}
		}

		return false;
	}

	@Override
	public int[] neighbors(int x) {
		int[] t = new int[n];
		int k = 0;

		for (int i = 0; i < m; i++) {
			if (matrix[x][i]) {
				for (int j = 0; j < n; j++) {
					if (x != j && matrix[j][i]) {
						t[k++] = j;
						break;
					}
				}
			}
		}

		int[] neighbors = new int[k];
		System.arraycopy(t, 0, neighbors, 0, k);

		return neighbors;
	}

	@Override
	public boolean add(int x, int y) {
		boolean[][] matrix2 = new boolean[n][m + 1];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matrix2[i][j] = matrix[i][j];
			}
		}

		matrix2[x][m] = true;
		matrix2[y][m] = true;

		matrix = matrix2;
		m++;

		return true;
	}

	@Override
	public boolean delete(int x, int y) {
		boolean[][] matrix2 = new boolean[n][m - 1];

		for (int i = 0, j = 0; i < m; i++, j++) {
			if (matrix[x][i] && matrix[y][i]) {
				j--;
			}
			else {
				for (int k = 0; k < n; k++) {
					matrix2[k][j] = matrix[k][i];
				}
			}
		}

		matrix = matrix2;
		m--;

		return false;
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

				for (int i = 0; i < m; i++) {
					if (matrix[x][i]) {
						for (int j = 0; j < n; j++) {
							if (x != j && matrix[j][i]) {
								stack.push(i);
								break;
							}
						}
					}
				}
			}
		} while (!stack.empty());
	}

	@Override
	public void bfs(int start, VertexVisitor vv) {
		boolean visited[] = new boolean[n];

		LinkedList<Integer> queue = new LinkedList<Integer>();

		queue.push(start);
		visited[start] = true;

		do {
			int x = queue.remove();

			vv.visit(x);

			for (int i = 0; i < m; i++) {
				if (matrix[x][i]) {
					for (int j = 0; j < n; j++) {
						if (x != j && matrix[j][i]) {
							if (!visited[i]) {
								queue.add(i);
								visited[i] = true;
								break;
							}
						}
					}
				}
			}
		} while (!queue.isEmpty());
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
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
