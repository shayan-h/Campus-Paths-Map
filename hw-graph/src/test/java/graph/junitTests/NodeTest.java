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
