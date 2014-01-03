package graphs;

/**
 * Interface for vertex visitor functionality, used in graph search operations.
 */
public interface VertexVisitor {

	/**
	 * Visits a graph node.
	 *
	 * @param v	graph node
	 */
	public void visit(int v);

}

