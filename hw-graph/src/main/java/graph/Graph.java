package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>Graph</b> represents an <b>immutable</b> combination of Nodes and Edges in the form of two separate
 * lists, one for nodes and the other for graphs. Graph acts as a bridge between all Nodes
 * and Edges and does not allow an Edge to be added unless the Edge's outgoing and incoming node are in
 * the Nodes list (only one node is required to be related to the Edge).
 */

public class Graph {

    // Fields

    private List<Node> nodes;
    private List<Edge> edges;

    // Abstraction Function:
    // Graph, gr, represents a list of Nodes with any associated Edges
    // incoming to or from a Node:
    // nodes[0..i], representation: subpart of nodes in which each node is
    //
    //
    // Representation Invariant for every Graph gr:
    // nodes != null && nodes.get[i].label != nodes[0..i-1..n].label
    // &&

    /**
     * Creates a new empty Graph.
     *
     * @spec.effects Creates a new Graph.
     */
    public Graph() {
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
        // throw new RuntimeException("Graph has not yet been implemented");
    }

    /**
     * Adds the given Node to Graph.
     *
     * @param node Node to add to the Graph.
     * @spec.effects Adds a Node to the list of Nodes in Graph.
     */
    public void addNode(Node node) {
        nodes.add(node);
        // throw new RuntimeException("addNode has not yet been implemented");
    }

    /**
     * Adds the given edge to Graph.
     *
     * @param edge
     * @spec.effects Adds an Edge to the list of Edges in Graph.
     */
    public boolean addEdge(Edge edge) {
        boolean validOut = false;
        boolean validIn = false;
        for (int i = 0; i < nodes.size(); i++) {
            if (edge.getOutgoingNode().equals(nodes.get(i))) {
                validOut = true;
                break;
            } else {
                validOut = false;
            }
        }
        for (int i = 0; i < nodes.size(); i++) {
            if (edge.getIncomingNode().equals(nodes.get(i))) {
                validIn = true;
                break;
            } else {
                validIn = false;
            }
        }
        if (validIn == true && validOut == true) {
            return true;
        } else {
            return false;
        }
        // throw new RuntimeException("addEdge has not yet been implemented");
    }

    /**
     * Returns a list of Nodes in this Graph.
     *
     * @return List of Nodes.
     */
    public List<Node> listNodes() {
        List<Node> list = new ArrayList<>(nodes);
        return list;
        // throw new RuntimeException("listNodes has not yet been implemented");
    }

    /**
     * Returns the number of Nodes in this Graph.
     *
     * @return the size of this Graph.
     */
    public int size() {
        return nodes.size();
        // throw new RuntimeException("Size has not yet been implemented");
    }

    /**
     *
     *
     *
     */
    public void clearGraph() {
        this.nodes.clear();
        this.edges.clear();
    }

    /**
     * Returns a list of the given parent Node's children Node(s).
     *
     * @return Returns a list of children Node(s) of the parent Node.
     */
    public List<Node> listChildren(Node node) { // edges: n1,n2  n3,n1  n1,n7, n1,n8 nodes: *n1*, n2, n3
        List<Node> list = new ArrayList<>();
        if (!this.nodes.contains(node)) {
            return list;
        } else {
            for (int i = 0; i < edges.size(); i++) {
                if (edges.get(i).getOutgoingNode().equals(node)) {
                    list.add(edges.get(i).getIncomingNode());
                }
            }
        }
        return list;
    }

}
