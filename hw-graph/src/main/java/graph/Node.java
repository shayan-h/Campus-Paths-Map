package graph;

import java.util.List;

/**
 * <b>Node</b> is an immutable object which has a unique label and is a parent or child of some other Node. A Node is directed
 * to or/and from an edge or multiple edges.
 */

public class Node {

    // Fields

    /**
     * Creates a new Node.
     *
     * @param label
     * @spec.requires The same label should not already exist.
     * @spec.effects Creates a new Node with a given label.
     */
    public Node(String label) {
        throw new RuntimeException("Node has not yet been implemented");
    }

    /**
     * Creates multiple new Nodes.
     *
     * @param labels
     * @spec.requires !labels.isEmpty()
     * @spec.effects Creates labels.size() new Nodes, each with the given label in the labels list.
     */
    public Node(List<String> labels) {
        throw new RuntimeException("Node has not yet been implemented");
    }

    /**
     * Returns a list of the given parent Node's children Node(s).
     * @param parentNode
     * @return Returns a list of children Node(s) of the parent Node.
     */
    public List<Node> listChildren(Node parentNode) {
        throw new RuntimeException("listChildren has not yet been implemented");
    }

    /**
     * Gets the label given to this Node.
     *
     * @return The String label associated with this Node.
     */
    public String getLabel() {
        throw new RuntimeException("getLabel has not yet been implemented");
    }

    /**
     * Changes the label given to this Node.
     *
     * @param label
     * @spec.effects Replaces the current label of this Node with the given label.
     */
    public void editLabel(String label) {
        throw new RuntimeException("editLabel has not yet been implemented");
    }


}
