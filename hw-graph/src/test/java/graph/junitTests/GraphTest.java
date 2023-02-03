package graph.junitTests;

import graph.Edge;
import graph.Graph;
import graph.Node;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
public class GraphTest {
    //////////////////////////////////////////////////////////
    /////  list Nodes
    //////////////////////////////////////////////////////////

    @Test
    public void listNodesTest() {
        Graph graph1 = new Graph();
        assertEquals("Graph did not list:", "", graph1.listNodes());
        Node n1 = new Node("n1");
        graph1.addNode(n1);
        assertEquals("Graph did not list: n1", "n1", graph1.listNodes());
        Node n2 = new Node("n2");
        graph1.addNode(n2);
        assertEquals("Graph did not list: n1, n2", "n1, n2", graph1.listNodes());
        Node n3 = new Node("n3");
        graph1.addNode(n3);
        assertEquals("Graph did not list: n1, n2, n3", "n1, n2, n3", graph1.listNodes());
    }

    //////////////////////////////////////////////////////////
    /////  add multiple nodes
    //////////////////////////////////////////////////////////
    @Test
    public void addMultipleNodesTest() {
        Graph graph1 = new Graph();
        List<String> label = new ArrayList<String>();
        label.add("n1");
        label.add("n2");
        graph1.addMultipleNodes(label);
        assertEquals("Graph does not contain: n1, n2", "n1, n2", graph1.listNodes());
        label.add("n3");
        graph1.addMultipleNodes(label);
        assertEquals("Graph does not contain: n1, n2, n3", "n1, n2, n3", graph1.listNodes());
        label.add("n4");
        graph1.addMultipleNodes(label);
        assertEquals("Graph does not contain: n1, n2, n3, n4", "n1, n2, n3, n4", graph1.listNodes());
    }

    //////////////////////////////////////////////////////////
    /////  Size  Test
    //////////////////////////////////////////////////////////
    @Test
    public void sizeTest() {

        assertEquals("Graph size should be 0", 0,new Graph().size());
        Graph graph1 = new Graph();
        Node n1 = new Node("n1");
        graph1.addNode(n1);
        assertEquals("Graph size should be 1", 1,graph1.size());
        Graph graph2 = new Graph();
        Node n2 = new Node("n2");
        graph2.addNode(n1);
        graph2.addNode(n1);
        assertEquals("Graph size should be 2", 2,graph2.size());
    }

}
