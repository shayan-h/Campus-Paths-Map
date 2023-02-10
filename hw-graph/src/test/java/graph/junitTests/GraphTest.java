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
        assertEquals("Graph did not list:", java.util.Collections.emptyList(), graph1.listNodes());
        Node n1 = new Node("n1");
        graph1.addNode(n1);
        List<Node> list = new ArrayList<>();
        list.add(n1);
        assertEquals("Graph did not list: n1", list, graph1.listNodes());
        Node n2 = new Node("n2");
        graph1.addNode(n2);
        list.add(n2);
        assertEquals("Graph did not list: n1, n2", list, graph1.listNodes());
        Node n3 = new Node("n3");
        graph1.addNode(n3);
        list.add(n3);
        assertEquals("Graph did not list: n1, n2, n3", list, graph1.listNodes());
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
        graph2.addNode(n2);
        assertEquals("Graph size should be 2", 2,graph2.size());
    }

    //////////////////////////////////////////////////////////
    /////  addEdge  Test
    //////////////////////////////////////////////////////////
    @Test
    public void addEdgetest() {
        Graph graph1 = new Graph();
        Node n1 = new Node("n1");
        Node n2 = new Node("n2");
        Node n3 = new Node("n3");
        Node n4 = new Node("n4");
        Edge e1 = new Edge("e1", n1, n2);
        graph1.addNode(n1);
        graph1.addNode(n2);
        assertEquals("addEdge should return True", true, graph1.addEdge(e1));
        Edge e2 = new Edge("e2", n2, n3);
        assertEquals("addEdge should return False", false, graph1.addEdge(e2));
        Edge e3 = new Edge("e3", n4, n3);
        assertEquals("addEdge should return False", false, graph1.addEdge(e3));
        Edge e4 = new Edge("e4", n1, n1);
        assertEquals("addEdge should return True", true, graph1.addEdge(e4));

    }

    ///////////////////////////////////////////////////
    // List Children
    //////////////////////////////////////////////////
    @Test
    public void listChildrenTest() {
        Graph graph1 = new Graph();
        List<Node> list = new ArrayList<>();
        Node p = new Node("parent");
        Node c = new Node("child");
        Edge e = new Edge("e1", p, c);
        Edge e7 = new Edge("e7", c, p);
        graph1.addNode(p);
        graph1.addNode(c);
        graph1.addEdge(e);
        list.add(c);
        assertEquals("listChildren should return: child", list, graph1.listChildren(p));
        list.clear();
        assertEquals("listChildren should return:", list, graph1.listChildren(c));
        Node c2 = new Node("child2");
        Node c3 = new Node("child3");
        Edge e2 = new Edge("e2", p, c2);
        Edge e3 = new Edge("e3", p, c3);
        graph1.addNode(c2);
        graph1.addNode(c3);
        graph1.addEdge(e2);
        graph1.addEdge(e3);
        list.add(c);
        list.add(c2);
        list.add(c3);
        assertEquals("listChildren should return: child1, child2, child3", list, graph1.listChildren(p));
    }

}
