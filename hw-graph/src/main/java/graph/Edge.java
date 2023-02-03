package graph;

/**
 * <b>Graph</b> is an immutable object that has a label, and outgoing Node and incoming Node associated
 * with it. An Edge's incoming Node can be the same as it's outgoing Node. Multiple Edges can be directed
 * to or from the same two Nodes.
 */

public class Edge {

    // Fields

    /**
     * Constructs a new Edge.
     *
     * @param label
     * @param outgoingNode
     * @param incomingNode
     * @spec.effects Creates a new Edge directed to and outgoing from Nodes. Incoming and Outgoing Node can
     * be the same.
     */
    public Edge(String label, Node outgoingNode, Node incomingNode) {
        throw new RuntimeException("Edge has not yet been implemented");
    }

    /**
     * Gets the label given to this Edge.
     *
     * @return The String label associated with this Edge.
     */
    public String getLabel() {
        throw new RuntimeException("getLabel has not yet been implemented");
    }

    /**
     * Assigns the label associated with this Edge to a new label given through the input.
     *
     * @param label
     * @spec.effects Replaces the label of this Edge with a new one.
     */
    public void editLabel(String label) {
        throw new RuntimeException("editLabel has not yet been implemented");
    }

    /**
     * Changes the direction of this Edge by assigning the outgoing Node as the incoming Node and the incoming Node
     * as the new outgoing Node.
     *
     * @spec.effects Flips the direction in which this Edge is going by swapping the incoming Node with the outgoing
     * Node.
     */
    public void swapDirection() {
        throw new RuntimeException("swapDirection has not yet been implemented");
    }




}
