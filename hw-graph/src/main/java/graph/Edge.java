package graph;

/**
 * <b>Graph</b> is an immutable object that has a label, and outgoing Node and incoming Node associated
 * with it. An Edge's incoming Node can be the same as it's outgoing Node. Multiple Edges can be directed
 * to or from the same two Nodes.
 */

public class Edge {

    // Fields
    private String label;
    private Node outgoingNode;
    private Node incomingNode;

    // Representation Invariant of an Edge e:
    // e.label != null && e.incomingNode != null &&
    // e.outgoingNode != null


    /**
     * Constructs a new Edge.
     *
     * @param label String to assign label to Edge.
     * @param outgoingNode Node to assign outgoing node to edge.
     * @param incomingNode Node to assign incoming node to edge.
     * @spec.effects Creates a new Edge directed to and outgoing from Nodes. Incoming and Outgoing Node can
     * be the same.
     */
    public Edge(String label, Node outgoingNode, Node incomingNode) {
        this.label = label;
        this.outgoingNode = outgoingNode;
        this.incomingNode = incomingNode;
        // throw new RuntimeException("Edge has not yet been implemented");
    }

    /**
     * Gets the label given to this Edge.
     *
     * @return The String label associated with this Edge.
     */
    public String getLabel() {
        return this.label;
        // throw new RuntimeException("getLabel has not yet been implemented");
    }

    /**
     * Assigns the label associated with this Edge to a new label given through the input.
     *
     * @param label String to replace the label of edge.
     * @spec.effects Replaces the label of this Edge with a new one.
     */
    public void editLabel(String label) {
        this.label = label;
        // throw new RuntimeException("editLabel has not yet been implemented");
    }

    /** Retrieves the Node that this Edge is incoming to.
     *
     * @return Node that this Edge is incoming to otherwise known as the child Node.
     */
    public Node getIncomingNode() {
        return this.incomingNode;
        // throw new RuntimeException("getIncomingNode has not yet been implemented");
    }

    /**
     * Retrieves the Node that this Edge is outgoing from.
     *
     * @return Node that this Edge is outgoing from otherwise known as the parent Node.
     */
    public Node getOutgoingNode() {
        return this.outgoingNode;
        // throw new RuntimeException("getOutgoingNode has not yet been implemented");
    }






}
