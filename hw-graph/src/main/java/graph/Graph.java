package graph;

import java.util.*;

/**
 * <b>Graph</b> represents an <b>immutable</b> combination of Nodes and Edges in the form of two
 * lists, one for nodes and the other for Edges. It also includes a hashmap for the entire
 * combination of edges in nodes in Graph. Graph is a generic class and takes in two generic parameters.
 * Graph does not allow an Edge to be added unless the Edge's outgoing and incoming node are in
 * the Nodes list (only one node is required to be related to the Edge).
 */

public class Graph<N, E> {

    // Fields

    private List<N> nodes;
    private List<Edge<N, E>> edges;
    private HashMap<N, Set<Edge<N, E>>> allGraph;
    public static final boolean DEBUG = false;

    // Abstraction Function:
    // Graph, gr, represents a list of Nodes and a list of associated Edges and a hashmap of both.
    // Incoming to or from a Node:
    // gr.nodes.get(i..n).contains(gr.edges.get(i..n).getOutgoingNode() && gr.edges.get(i..n).getIncomingNode())
    // || gr.edges.isEmpty()
    //
    //
    // Representation Invariant for every Graph gr:
    // gr.allGraph != null && gr.nodes != null && gr.edges != null && gr.nodes.get(i).getLabel() != gr.nodes.get(0..i-1..n).getLabel()
    // && gr.nodes.contains(gr.edges.get(i).getOutgoingNode()) &&
    // gr.nodes.contains(gr.edges.get(i).getIncomingNode())
    // In other words:
    // Nodes and Edges can't be null, the graph hashmap can't be either, a node's label has to be unique, and an edge's outgoing and
    // incoming node must be in the graph. (the outgoing node and incoming node can be the same node).

    /**
     * Creates a new empty Graph.
     *
     * @spec.effects Creates a new Graph.
     */
    public Graph() {
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
        allGraph = new HashMap<>();
        checkRep();
        // throw new RuntimeException("Graph has not yet been implemented");
    }

    /**
     * Checks the representation invariant for the Graph class.
     */
    private void checkRep() {
        assert (nodes != null || allGraph != null || allGraph != null): "Graph is null";

        if (DEBUG) {
            for (int i = 0; i < edges.size(); i++) {
                assert (nodes.contains(edges.get(i).getOutgoingNode()) ||
                        nodes.contains(edges.get(i).getIncomingNode())): "Edge associated with node that is not in graph.";
            }
            HashSet<N> set = new HashSet<>();
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
     * @param node Node of generic type to add to the Graph.
     * @spec.effects Adds a Node to the list of Nodes in Graph.
     * @return True if Node is added to Graph and false otherwise.
     */
    public boolean addNode(N node) {
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
    public boolean addEdge(Edge<N, E> edge) {
            if (!allGraph.containsKey(edge.getOutgoingNode())) {
                allGraph.put(edge.getOutgoingNode(), new HashSet<>());
            }
            allGraph.get(edge.getOutgoingNode()).add(edge);
            edges.add(edge);
            return true;
    }

    /**
     * Returns a list of Nodes in this Graph.
     *
     * @return List of nodes represented by generic type.
     */
    public List<N> listNodes() {
        checkRep();
        List<N> list = new ArrayList<>(nodes);
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
        allGraph.clear();
    }

    /**
     * Returns a list of the given parent Node's children Node(s).
     *
     * @param node Parent node of generic type.
     * @return Returns a list of children Node(s) of generic type of the parent Node.
     */
    public List<N> listChildren(N node) {
        List<N> result = new ArrayList<>();
        if(allGraph.get(node) != null) {
            List<Edge<N, E>> ed = new ArrayList<>(allGraph.get(node));
            for (Edge<N, E> e : ed) {
                result.add(e.getIncomingNode());
            }
        }
        return result;
    }

    /**
     * Gets a Node given the Node's label.
     *
     * @param label of generic type to retrieve the node.
     * @return the Node of generic type with the given label.
     */
    public N getNode(N label) {
        checkRep();
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).equals(label)) {
                checkRep();
                return nodes.get(i);
            }
        }
        return null;
    }

    /**
     * Gets all edges from a given parent node.
     *
     * @param parent (generic type) parent node.
     * @return returns a hashset of edges.
     */
    public Set<Edge<N, E>> getAllEdges(N parent) {
        return allGraph.get(parent);
    }

    /**
     * Gets an Edge given the Edge's parent node and child node of generic type.
     *
     * @param parent, child of generic type to retrieve the Edge.
     * @return the Edge with the given parent node and child node.
     */
    public Edge<N, E> getEdge(N parent, N child) {
        List<Edge<N, E>> list = edges;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getOutgoingNode().equals(parent) && list.get(i).getIncomingNode().equals(child)) {
                return list.get(i);
            }

        }
        return null;
    }

    /**
     * Gets an Edge given the Edge's parent node of generic type.
     *
     * @param parent of generic type to retrieve the Edge.
     * @return the Edge with the given parent node.
     */
    public Edge<N, E> getFirstEdge(N parent) {
        List<Edge<N, E>> list = edges;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getOutgoingNode().equals(parent)) {
                return list.get(i);
            }

        }
        return null;
    }

}
