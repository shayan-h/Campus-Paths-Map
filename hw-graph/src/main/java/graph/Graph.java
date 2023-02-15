package graph;

import java.util.ArrayList;
import java.util.HashSet;
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
    public static final boolean DEBUG = false;

    // Abstraction Function:
    // Graph, gr, represents a list of Nodes and a list of associated Edges
    // incoming to or from a Node:
    // gr.nodes.get(i..n).contains(gr.edges.get(i..n).getOutgoingNode() && gr.edges.get(i..n).getIncomingNode())
    // || gr.edges.isEmpty()
    //
    //
    // Representation Invariant for every Graph gr:
    // gr.nodes != null && gr.edges != null && gr.nodes.get(i).getLabel() != gr.nodes.get(0..i-1..n).getLabel()
    // && gr.nodes.contains(gr.edges.get(i).getOutgoingNode()) &&
    // gr.nodes.contains(gr.edges.get(i).getIncomingNode())
    // In other words:
    // Nodes and Edges can't be null, a node's label has to be unique, and an edge's outgoing and
    // incoming node must be in the graph. (the outgoing node and incoming node can be the same node).

    /**
     * Creates a new empty Graph.
     *
     * @spec.effects Creates a new Graph.
     */
    public Graph() {
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
        checkRep();
        // throw new RuntimeException("Graph has not yet been implemented");
    }

    /**
     * Checks the representation invariant for the Graph class.
     */
    private void checkRep() {
        assert (nodes != null || edges != null): "Nodes or Edges is null";
        if (DEBUG) {
            for (int i = 0; i < edges.size(); i++) {
                assert (nodes.contains(edges.get(i).getOutgoingNode()) ||
                        nodes.contains(edges.get(i).getIncomingNode())): "Edge associated with node that is not in graph.";
            }
            HashSet<Node> set = new HashSet<>();
            for (int i = 0; i < nodes.size(); i++) {
                if (set.contains(nodes.get(i))) {
                    assert (!set.contains(nodes.get(i))): "Node is not unique";
                    break;
                } else {
                    set.add(nodes.get(i));
                }
            }
        }
    }

    /**
     * Adds the given Node to Graph.
     *
     * @param node Node to add to the Graph.
     * @spec.effects Adds a Node to the list of Nodes in Graph.
     * @return True if Node is added to Graph and false otherwise.
     */
    public boolean addNode(Node node) {
        checkRep();
        if (!nodes.contains(node)) {
            nodes.add(node);
            checkRep();
            return true;
        } else {
            return false;
        }

        // throw new RuntimeException("addNode has not yet been implemented");
    }

    /**
     * Adds the given edge to Graph only if the Edge has an incoming or outgoing node already in
     * the graph.
     *
     * @param edge Edge to add to graph.
     * @spec.effects Adds an Edge to the list of Edges in Graph.
     * @return True if Edge is added to Graph and false otherwise.
     */
    public boolean addEdge(Edge edge) {
        /*
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
         */
        // if (validIn == true && validOut == true) {
            edges.add(edge);
           return true;
        // } else {
            // return false;
        // }
        // throw new RuntimeException("addEdge has not yet been implemented");
    }

    /**
     * Returns a list of Nodes in this Graph.
     *
     * @return List of Nodes.
     */
    public List<Node> listNodes() {
        checkRep();
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
        checkRep();
        return nodes.size();
        // throw new RuntimeException("Size has not yet been implemented");
    }

    /**
     * Clears the graph by clearing all Edges and Nodes.
     *
     * @spec.effects Clears the graph entirely.
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
    public List<Node> listChildren(Node node) {
        checkRep();
        List<Node> list = new ArrayList<>();
        if (!this.nodes.contains(node)) {
            return list;
        } else {
            for (int i = 0; i < this.edges.size(); i++) {
                if (this.edges.get(i).getOutgoingNode().equals(node)) {
                    list.add(this.edges.get(i).getIncomingNode());
                }
            }
        }
        checkRep();
        return list;
    }

    /**
     * Gets a Node given the Node's label.
     *
     * @param label to retrieve the node.
     * @return the Node with the given label.
     */
    public Node getNode(String label) {
        checkRep();
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).getLabel().equals(label)) {
                checkRep();
                return nodes.get(i);
            }
        }
        return null;
    }

    /**
     * Gets an Edge given the Edge's parent node.
     *
     * @param parent to retrieve the Edge.
     * @return the Edge with the given parent node.
     */
    public Edge getEdge(Node parent) {
        checkRep();
        for (int i = 0; i < edges.size(); i++) {
            if (edges.get(i).getOutgoingNode().equals(parent)) {
                checkRep();
                return edges.get(i);
            }
        }
        return null;
    }

}
