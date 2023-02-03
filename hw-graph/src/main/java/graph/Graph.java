package graph;

import java.util.List;

/**
 * <b>Graph</b> represents an <b>immutable</b> combination of Nodes and Edges. Graph acts as a bridge between all Nodes
 * and Edges and contains a list of Nodes in the graph.
 */

public class Graph {

    // Fields

    /**
     * Creates a new Graph.
     *
     * @spec.effects Creates a new Graph.
     */
    public Graph() {
        throw new RuntimeException("Graph has not yet been implemented");
    }

    /**
     * Creates multiple new Nodes and adds them in the Graph.
     *
     * @param labels list of Strings to label each Node.
     * @spec.requires !labels.isEmpty()
     * @spec.effects Creates labels.size() new Nodes, each with the given label in the labels list.
     */
    public void addMultipleNodes(List<String> labels) {
        throw new RuntimeException("addMultipleNodes has not yet been implemented");
    }

    /**
     * Adds the given Node to Graph.
     *
     * @param node Node to add to the Graph.
     * @spec.effects Adds a Node to the list of Nodes in Graph.
     */
    public void addNode(Node node) {
        throw new RuntimeException("addNode has not yet been implemented");
    }

    /**
     * Returns a list of Nodes in this Graph.
     *
     * @return List of Nodes.
     */
    public List<Node> listNodes() {
        throw new RuntimeException("listNodes has not yet been implemented");
    }

    /**
     * Returns the number of Nodes in this Graph.
     *
     * @return the size of this Graph.
     */
    public int size() {
        throw new RuntimeException("Size has not yet been implemented");
    }

}
