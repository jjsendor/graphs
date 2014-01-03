package graphs;

/**
 * Graph interface representing basic graph operations.
 *
 * @author Jakub Sendor
 *
 */
public interface Graph {

	/**
	 * Tests whether there is an edge from node <code>x</code> to node
	 * <code>y</code>.
	 *
	 * @param x	graph node
	 * @param y	graph node
	 *
	 * @return	<code>true</code> if there is and edge between the vertices,
	 * 			<code>false</code> otherwise
	 */
	public boolean adjacent(int x, int y);

	/**
	 * Lists all nodes <code>y</code> such that there is an edge from
	 * <code>x</code> to <code>y</code>.
	 *
	 * @param x	graph node
	 *
	 * @return	list of nodes connected to <code>x</code>
	 */
	public int[] neighbors(int x);

	/**
	 * Adds the edge from <code>x</code> to <code>y</code>, if it is not there.
	 *
	 * @param x	graph node
	 * @param y	graph node
	 *
	 * @return	<code>true</code> if the edge was added,
	 * 			<code>false</code> if there was already the edge from
	 * 			<code>x</code> to <code>y</code>
	 */
	public boolean add(int x, int y);

	/**
	 * Removes the edge from <code>x</code> to <code>y</code>, if it is there.
	 *
	 * @param x	graph node
	 * @param y	graph node
	 *
	 * @return	<code>true</code> if the edge was removed,
	 * 			<code>false</code> if there was no edge from
	 * 			<code>x</code> to <code>y</code>
	 */
	public boolean delete(int x, int y);

	/**
	 * Returns number of vertices.
	 *
	 * @return	number of vertices
	 */
	public int vertices();

	/**
	 * Searches the graph in a depth-first fashion starting from the node
	 * <code>start</code> and invokes {@link VertexVisitor#visit(int)}
	 * method on each visited vertex.
	 *
	 * @param start	starting node
	 * @param vv	object that supplies vertex visiting functionality
	 */
	public void dfs(int start, VertexVisitor vv);

	/**
	 * Searches the graph in a breadth-first fashion starting from the node
	 * <code>start</code> and invokes {@link VertexVisitor#visit(int)}
	 * method on each visited vertex.
	 *
	 * @param start	starting node
	 * @param vv	object that supplies vertex visiting functionality
	 */
	public void bfs(int start, VertexVisitor vv);

}
