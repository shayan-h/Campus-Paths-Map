package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>Node</b> is an immutable object which has a unique label and is a parent or child of some other Node. A Node is directed
 * to or/and from an edge or multiple edges.
 */

public class Node {

    // Fields
    private String label;
    private List<Edge> edges;

    // Representation Invariant for every Node n:
    // n.label != null && n.listChildren() != null



    /**
     * Creates a new Node.
     *
     * @param label String to assign label name to Node.
     * // @spec.requires The same label should not already exist. //
     * @spec.effects Creates a new Node with a given label.
     */
    public Node(String label) {
        this.label = label;
        edges = new ArrayList<>();
        // throw new RuntimeException("Node has not yet been implemented");
    }

    /**
     * Gets the label given to this Node.
     *
     * @return The String label associated with this Node.
     */
    public String getLabel() {
        return this.label;
        // throw new RuntimeException("getLabel has not yet been implemented");
    }

    /**
     * Changes the label given to this Node.
     *
     * @param label String to replace current label name.
     * @spec.effects Replaces the current label of this Node with the given label.
     */
    public void editLabel(String label) {
        this.label = label;
        // throw new RuntimeException("editLabel has not yet been implemented");
    }


}
