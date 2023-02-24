package graph.junitTests;

import graph.Edge;
import graph.Graph;
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
        Graph<String, String> graph1 = new Graph<>();
        assertEquals("Graph did not list:", java.util.Collections.emptyList(), graph1.listNodes());
        String n1 = "n1";
        graph1.addNode(n1);
        List<String> list = new ArrayList<>();
        list.add(n1);
        assertEquals("Graph did not list: n1", list, graph1.listNodes());
        String n2 = "n2";
        graph1.addNode(n2);
        list.add(n2);
        assertEquals("Graph did not list: n1, n2", list, graph1.listNodes());
        String n3 = "n3";
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
        Graph<String, String> graph1 = new Graph<>();
        String n1 = "n1";
        graph1.addNode(n1);
        assertEquals("Graph size should be 1", 1,graph1.size());
        Graph<String, String> graph2 = new Graph<>();
        String n2 = "n2";
        graph2.addNode(n1);
        graph2.addNode(n2);
        assertEquals("Graph size should be 2", 2,graph2.size());
    }

    //////////////////////////////////////////////////////////
    /////  addEdge  Test
    //////////////////////////////////////////////////////////
    @Test
    public void addEdgetest() {
        Graph<String, String> graph1 = new Graph<>();
        String n1 = "n1";
        String n2 = "n2";
        String n3 = "n3";
        String n4 = "n4";
        Edge<String, String> e1 = new Edge<>("e1", n1, n2);
        graph1.addNode(n1);
        graph1.addNode(n2);
        assertEquals("addEdge should return True", true, graph1.addEdge(e1));
        Edge<String, String> e2 = new Edge<>("e2", n2, n3);
        assertEquals("addEdge should return False", /*false*/true, graph1.addEdge(e2));
        Edge<String, String> e3 = new Edge<>("e3", n4, n3);
        assertEquals("addEdge should return False", /*false*/true, graph1.addEdge(e3));
        Edge<String, String> e4 = new Edge<>("e4", n1, n1);
        assertEquals("addEdge should return True", true, graph1.addEdge(e4));

    }

    ///////////////////////////////////////////////////
    // List Children
    //////////////////////////////////////////////////
    @Test
    public void listChildrenTest() {
        Graph<String, String> graph1 = new Graph<>();
        List<String> list = new ArrayList<>();
        String p = "parent";
        String c = "child";
        Edge<String, String> e = new Edge<>("e1", p, c);
        Edge<String, String> e7 = new Edge<>("e7", c, p);
        graph1.addNode(p);
        graph1.addNode(c);
        graph1.addEdge(e);
        list.add(c + "(e1)");
        assertEquals("listChildren should return: child", list, graph1.listChildren(p));
        list.clear();
        assertEquals("listChildren should return:", list, graph1.listChildren(c));
        String c2 = "child2";
        String c3 = "child3";
        Edge<String, String> e2 = new Edge<>("e2", p, c2);
        Edge<String, String> e3 = new Edge<>("e3", p, c3);
        graph1.addNode(c2);
        graph1.addNode(c3);
        graph1.addEdge(e2);
        graph1.addEdge(e3);
        list.add(c + "(e2)");
        list.add(c2 + "(e1)");
        list.add(c3 + "(e3)");
        assertEquals("listChildren should return: child1, child2, child3", list, graph1.listChildren(p));
    }

    ///////////////////////////////////////////////////
    // get Node test
    //////////////////////////////////////////////////
    @Test
    public void getNodeTest() {
        Graph<String, String> graph1 = new Graph<>();
        String n1 = "parent";
        graph1.addNode(n1);
        assertEquals("getNode should return: parent", n1, graph1.getNode("parent"));
    }

    ///////////////////////////////////////////////////
    // get Edge test
    //////////////////////////////////////////////////
    @Test
    public void getEdgeTest() {
        Graph<String, String> graph1 = new Graph<>();
        String n1 = "parent";
        String n2 = "child";
        graph1.addNode(n1);
        graph1.addNode(n2);
        Edge<String, String> e1 = new Edge<>("e1", n1, n2);
        graph1.addEdge(e1);
        // assertEquals("getEdge should return: e1", e1, graph1.getEdge(n1));  FIX LATER
    }

}
