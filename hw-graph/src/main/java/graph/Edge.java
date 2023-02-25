package graph;

/**
 * <b>Edge</b> is an immutable object that has a label, and outgoing Node and incoming Node associated
 * with it and takes in two generic type parameters. An Edge's incoming Node can be the same as it's outgoing Node. Multiple Edges can be directed
 * to or from the same two Nodes.
 */

public class Edge<N, E> {

    // Fields
    private E label;
    private N outgoingNode;
    private N incomingNode;

    // Abstract Function:
    // Edge e, represents a connection between a parent node and a child node.
    //
    // Representation Invariant of an Edge e:
    // e.label != null && e.incomingNode != null &&
    // e.outgoingNode != null
    // In other words:
    // An Edge must have a label and an outgoing and incoming node assigned to it.


    /**
     * Constructs a new Edge.
     *
     * @param label of generic type to assign label to Edge.
     * @param outgoingNode Node of generic type to assign outgoing node to edge.
     * @param incomingNode Node of generic type to assign incoming node to edge.
     * @spec.effects Creates a new Edge directed to and outgoing from Nodes. Incoming and Outgoing Node can
     * be the same.
     */
    public Edge(E label, N outgoingNode, N incomingNode) {
        this.label = label;
        this.outgoingNode = outgoingNode;
        this.incomingNode = incomingNode;
        checkRep();
        // throw new RuntimeException("Edge has not yet been implemented");
    }

    /**
     * Checks the representation invariant for the Edge class.
     */
    private void checkRep() {
        assert (this.label != null): "This Edge label is null";
        assert (this.incomingNode != null || this.outgoingNode != null): "Edge incoming or outgoing node is null";
    }

    /**
     * Gets the label of generic type given to this Edge.
     *
     * @return The generic type label associated with this Edge.
     */
    public E getLabel() {
        checkRep();
        return this.label;
        // throw new RuntimeException("getLabel has not yet been implemented");
    }

    /**
     * Assigns the label associated with this Edge to a new label of generic type given through the input.
     *
     * @param label of generic type to replace the label of edge.
     * @spec.effects Replaces the label of this Edge with a new one of generic type.
     */
    public void editLabel(E label) {
        checkRep();
        this.label = label;
        // throw new RuntimeException("editLabel has not yet been implemented");
    }

    /** Retrieves the Node of generic type that this Edge is incoming to.
     *
     * @return Node of generic type that this Edge is incoming to otherwise known as the child Node.
     */
    public N getIncomingNode() {
        checkRep();
        return this.incomingNode;
        // throw new RuntimeException("getIncomingNode has not yet been implemented");
    }

    /**
     * Retrieves the Node of generic type that this Edge is outgoing from.
     *
     * @return Node of generic type that this Edge is outgoing from otherwise known as the parent Node.
     */
    public N getOutgoingNode() {
        checkRep();
        return this.outgoingNode;
        // throw new RuntimeException("getOutgoingNode has not yet been implemented");
    }

    /**
     * Overrides the equals method to check if two Edges are equal.
     * @param o Object which can either be an instance of Edge or not.
     * @return True if the Edges are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Edge) {
            Edge e1 = (Edge) o;
            if (e1.outgoingNode.equals(this.outgoingNode) && e1.incomingNode.equals(this.incomingNode)) {
                return this.label.equals(e1.label);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }


}
