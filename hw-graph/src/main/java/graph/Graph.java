package graph;

import java.util.*;

/**
 * <b>Graph</b> represents an <b>immutable</b> combination of Nodes and Edges in the form of two separate
 * lists, one for nodes and the other for graphs. Graph acts as a bridge between all Nodes
 * and Edges and does not allow an Edge to be added unless the Edge's outgoing and incoming node are in
 * the Nodes list (only one node is required to be related to the Edge).
 */

public class Graph {

    // Fields

    private List<String> nodes;
    private List<Edge> edges;
    private HashMap<String, Set<Edge>> allGraph;
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
        allGraph = new HashMap<>();
        checkRep();
        // throw new RuntimeException("Graph has not yet been implemented");
    }

    /**
     * Checks the representation invariant for the Graph class.
     */
    private void checkRep() {
        assert (nodes != null || allGraph != null): "Graph is null";
        /*
        if (DEBUG) {
            for (int i = 0; i < edges.size(); i++) {
                assert (nodes.contains(edges.get(i).getOutgoingNode()) ||
                        nodes.contains(edges.get(i).getIncomingNode())): "Edge associated with node that is not in graph.";
            }
            HashSet<String> set = new HashSet<>();
            for (int i = 0; i < nodes.size(); i++) {
                if (set.contains(nodes.get(i))) {
                    assert (!set.contains(nodes.get(i))): "Node is not unique";
                    break;
                } else {
                    set.add(nodes.get(i));
                }
            }
        }
         */
    }

    /**
     * Adds the given Node to Graph.
     *
     * @param node Node to add to the Graph.
     * @spec.effects Adds a Node to the list of Nodes in Graph.
     * @return True if Node is added to Graph and false otherwise.
     */
    public boolean addNode(String node) {
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
            if (!allGraph.containsKey(edge.getOutgoingNode())) {
                allGraph.put(edge.getOutgoingNode(), new HashSet<>());
            }
               allGraph.get(edge.getOutgoingNode()).add(edge);
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
    public List<String> listNodes() {
        checkRep();
        List<String> list = new ArrayList<>(nodes);
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
     * @return Returns a list of children Node(s) of the parent Node.
     */
    public List<String> listChildren(String node) {
        /*
        checkRep();
        List<Edge> list = edges;
        List<String> stringList = new ArrayList<>();
        if (!this.nodes.contains(node)) {
            return stringList;
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getOutgoingNode().equals(node)) {
                    stringList.add(list.get(i).getIncomingNode());
                }
            }
        }
        checkRep();
        return stringList;
         */
        List<String> result = new ArrayList<String>();
        if(allGraph.get(node) != null) {
            List<Edge> ed = new ArrayList<>(allGraph.get(node));
            for (Edge e : ed) {
                result.add(e.getIncomingNode() + "(" + e.getLabel() + ")");
            }
        }
        return result;
    }

    /**
     * Gets a Node given the Node's label.
     *
     * @param label to retrieve the node.
     * @return the Node with the given label.
     */
    public String getNode(String label) {
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
     * Gets an Edge given the Edge's parent node.
     *
     * @param parent to retrieve the Edge.
     * @return the Edge with the given parent node.
     */
    public Set<Edge> getAllEdges(String parent) {
        return allGraph.get(parent);
    }

    public Edge getEdge(String parent) {
        List<Edge> list = edges;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getOutgoingNode().equals(parent)) {
                return list.get(i);
            }
        }
        return null;
    }

}
