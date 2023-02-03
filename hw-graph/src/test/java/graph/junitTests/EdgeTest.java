package graph.junitTests;

import graph.Edge;
import graph.Node;
import org.junit.Test;
import static org.junit.Assert.*;

public class EdgeTest {


    ///////////////////////////////////////////////////
    // getLabel
    //////////////////////////////////////////////////
    @Test
    public void getLabelTest() {
        String label = "label1";
        Node node1 = new Node("node1");
        Node node2 = new Node("node2");
        Edge e1 = new Edge(label, node1, node2);
        assertEquals("getLabel did not return: label1", "label1", e1.getLabel());
    }

    ///////////////////////////////////////////////////
    // editLabel
    //////////////////////////////////////////////////
    @Test
    public void editLabelTest() {
        String label = "label1";
        Node node1 = new Node("node1");
        Node node2 = new Node("node2");
        Edge e1 = new Edge(label, node1, node2);
        e1.editLabel("newLabel");
        assertEquals("editLabel did not return: newLabel", "newLabel", e1.getLabel());
    }

}
