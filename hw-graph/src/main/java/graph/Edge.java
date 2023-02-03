package graph;

/**
 * <b>Graph</b> is an immutable object that has a label, and outgoing Node and incoming Node associated
 * with it. An Edge's incoming Node can be the same as it's outgoing Node.
 */

public class Edge {

    // Fields

    /**
     * Constructs a new Edge.
     *
     * @param label
     * @param outgoingNode
     * @param incomingNode
     * @spec.requires label should not be duplicate of existing Edge's label
     * @spec.effects Creates a new Edge directed to and outgoing from Nodes. Incoming and Outgoing Node can
     * be the same.
     */
    public Edge(String label, Node outgoingNode, Node incomingNode) {
        throw new RuntimeException("Edge has not yet been implemented");
    }

    /**
     * Retrieves the Node that this Edge is incoming to.
     *
     * @return Node that this Edge is incoming to otherwise known as the child Node.
     */
    public Node getIncomingNode() {
        throw new RuntimeException("getIncomingNode has not yet been implemented");
    }


    /**
     * Retrieves the Node that this Edge is outgoing from.
     *
     * @return Node that this Edge is outgoing from otherwise known as the parent Node.
     */
    public Node getOutgoingNode() {
        throw new RuntimeException("getOutgoingNode has not yet been implemented");
    }

    /**
     * States True if this Edge is directed towards the same Node it is outgoing from and false otherwise.
     *
     * @return True if Edge is directed towards the same Node it is from and False if not.
     */
    public boolean isDirectedToSelf() {
        throw new RuntimeException("isDirectedToSelf has not yet been implemented");
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
     * Changes the incoming Node of this Edge to the given Node.
     *
     * @param incomingNode
     * @spec.effects Replaces the existing incoming Node of this Edge to the given Node.
     */
    public void directTo(Node incomingNode) {
        throw new RuntimeException("directTo has not yet been implemented");
    }

    /**
     * Changes the outgoing Node of this Edge to the given Node.
     *
     * @param outgoingNode
     * @spec.effects Replaces the existing outgoing Node of this Edge to the given Node.
     */
    public void directFrom(Node outgoingNode) {
        throw new RuntimeException("directFrom has not yet been implemented");
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
