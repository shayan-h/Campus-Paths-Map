package graph;

import java.util.List;

/**
 * <b>Node</b> is an immutable object which has a label and is a parent or child of some other Node directed
 * to, from, or both an edge or multiple edges.
 */

public class Node {

    // Fields

    public Node(String label) {
        throw new RuntimeException("Node has not yet been implemented");
    }

    public Node(List<String> labels) {
        throw new RuntimeException("Node has not yet been implemented");
    }

    public Node getParentNode() {
        throw new RuntimeException("getParentNode has not yet been implemented");
    }

    public Node getChildNode() {
        throw new RuntimeException("getChildNode has not yet been implemented");
    }

    public String getLabel() {
        throw new RuntimeException("getLabel has not yet been implemented");
    }

    public void editLabel(String label) {
        throw new RuntimeException("editLabel has not yet been implemented");
    }

}
