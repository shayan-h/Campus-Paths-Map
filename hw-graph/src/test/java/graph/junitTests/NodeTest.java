package graph.junitTests;

import graph.Edge;
import graph.Graph;
import graph.Node;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
public class NodeTest {


    ///////////////////////////////////////////////////
    // List Children
    //////////////////////////////////////////////////
    @Test
    public void listChildrenTest() {
        List<Node> children = new ArrayList<>();
        Node p = new Node("parent");
        Node c1 = new Node("child1");
        Edge e1 = new Edge("e1", p, c1);
        children.add(c1);
        assertEquals("listChildren should return: child1", children, p.listChildren());
        Node c2 = new Node("child2");
        Edge e2 = new Edge("e2", p, c2);
        children.add(c2);
        assertEquals("listChildren should return: child1, child2", children, p.listChildren());
        Node c3 = new Node("child3");
        Edge e3 = new Edge("e3", p, c3);
        children.add(c3);
        assertEquals("listChildren should return: child1, child2, child 3", children, p.listChildren());
    }

    ///////////////////////////////////////////////////
    // getLabel
    //////////////////////////////////////////////////
    @Test
    public void getLabelTest() {
        String label = "node1";
        Node node1 = new Node(label);
        assertEquals("getLabel did not return: node1", "node1", node1.getLabel());
    }

    ///////////////////////////////////////////////////
    // editLabel
    //////////////////////////////////////////////////
    @Test
    public void editLabelTest() {
        String label = "newLabel";
        Node node1 = new Node("oldLabel");
        node1.editLabel(label);
        assertEquals("editLabel did not return: newLabel", "newLabel", node1.getLabel());
    }

}
