package graph;

import java.util.List;

/**
 * <b>Graph</b> represents an <b>immutable</b> combination of Nodes and Edges. Graph acts as a bridge between all Nodes
 * and Edges and contains a list of Nodes and a list of Edges in the graph.
 */

public class Graph {

    // Fields

    public Graph() {
        throw new RuntimeException("Graph has not yet been implemented");
    }

    public Graph(Node node) {
        throw new RuntimeException("Graph has not yet been implemented");
    }

    public Graph(List<Node> nodes) {
        throw new RuntimeException("Graph has not yet been implemented");
    }

    public void addNode(Node node) {
        throw new RuntimeException("addNode has not yet been implemented");
    }

    public void createEdge(String label, Node outgoingNode, Node incomingNode) {
        throw new RuntimeException("createEdge has not yet been implemented");
    }

    public void swapNodes(Node node1, Node node2) {
        throw new RuntimeException("swapNodes has not yet been implemented");
    }

    public void deleteNode(Node node) {
        throw new RuntimeException("deleteNode has not yet been implemented");
    }

    public void deleteEdge(Edge edge) {
        throw new RuntimeException("deleteEdge has not yet been implemented");
    }

    public void removeEdgeWithNodes(Edge edge) {
        throw new RuntimeException("removeEdgeWithNodes has not yet been implemented");
    }

    public List<Node> getNodes() {
        throw new RuntimeException("getNodes has not yet been implemented");
    }

    public List<Node> getChildren() {
        throw new RuntimeException("getChildren has not yet been implemented");
    }

    public List<Node> getParents() {
        throw new RuntimeException("getParents has not yet been implemented");
    }
}
