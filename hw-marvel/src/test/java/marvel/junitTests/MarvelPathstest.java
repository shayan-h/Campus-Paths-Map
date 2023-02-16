package marvel.junitTests;

import graph.Edge;
import graph.Graph;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static marvel.MarvelPaths.createGraph;


public class MarvelPathstest {

    //////////////////////////////////////////////////////////
    /////  Marvel Paths Test (Graph list children)
    //////////////////////////////////////////////////////////
    @Test
    public void createGraphTest() {
        String filename = "marvel.csv";
        Graph marvelGraph = createGraph(filename);
        Graph graph = new Graph();
        String venusii = "VENUS-II";
        String humanRobot = "HUMAN-ROBOT";
        String marvelboyiii = "MARVEL-BOY-III/ROBER";
        String gorillaman = "GORILLA-MAN";
        String threedmancharles = "3-D-MAN/CHARLES-CHAN";
        String richardmilhojones = "RICHARD-MILHO-JONES";
        String wasp = "WASP/JANET-VAN-DYNE";
        String libragustav = "LIBRA/GUSTAV-BRANDT";
        String cap = "CAPTAIN-AMERICA";
        String antman = "ANT-MAN/DR.-HENRY-J.";
        String hawk = "HAWK";
        String pharaohramatut = "PHARAOH-RAMA-TUT";
        Edge wi1 = new Edge("WI?-9", venusii, humanRobot);
        Edge wi2 = new Edge("WI?-9", venusii, marvelboyiii);
        Edge wi3 = new Edge("WI?-9", venusii, gorillaman);
        Edge wi4 = new Edge("WI?-9", venusii, threedmancharles);
        Edge avf1 = new Edge("AVF-4", venusii, humanRobot);
        Edge avf2 = new Edge("AVF-4", venusii, gorillaman);
        Edge avf3 = new Edge("AVF-4", venusii, richardmilhojones);
        Edge avf4 = new Edge("AVF-4", venusii, threedmancharles);
        Edge avf5 = new Edge("AVF-4", venusii, wasp);
        Edge avf6 = new Edge("AVF-4", venusii, libragustav);
        Edge avf7 = new Edge("AVF-4", venusii, cap);
        Edge avf8 = new Edge("AVF-4", venusii, hawk);
        Edge avf9 = new Edge("AVF-4", venusii, antman);
        Edge avf10 = new Edge("AVF-4", venusii, marvelboyiii);
        Edge avf11 = new Edge("AVF-5", venusii, marvelboyiii);
        Edge avf12 = new Edge("AVF-5", venusii, richardmilhojones);
        Edge avf13 = new Edge("AVF-5", venusii, pharaohramatut);
        Edge avf14 = new Edge("AVF-5", venusii, gorillaman);
        Edge avf15 = new Edge("AVF-5", venusii, humanRobot);
        Edge avf16 = new Edge("AVF-5", venusii, cap);
        Edge avf17 = new Edge("AVF-5", venusii, hawk);
        Edge avf18 = new Edge("AVF-5", venusii, threedmancharles);
        Edge avf19 = new Edge("AVF-5", venusii, antman);
        Edge avf20 = new Edge("AVF-5", venusii, wasp);
        graph.addNode(venusii);
        graph.addNode(marvelboyiii);
        graph.addNode(gorillaman);
        graph.addNode(humanRobot);
        graph.addNode(threedmancharles);
        graph.addNode(wasp);
        graph.addNode(cap);
        graph.addNode(richardmilhojones);
        graph.addNode(antman);
        graph.addNode(libragustav);
        graph.addNode(pharaohramatut);
        graph.addNode(hawk);
        graph.addEdge(wi1);
        graph.addEdge(wi2);
        graph.addEdge(wi3);
        graph.addEdge(wi4);
        graph.addEdge(avf1);
        graph.addEdge(avf2);
        graph.addEdge(avf3);
        graph.addEdge(avf4);
        graph.addEdge(avf5);
        graph.addEdge(avf6);
        graph.addEdge(avf7);
        graph.addEdge(avf8);
        graph.addEdge(avf9);
        graph.addEdge(avf10);
        graph.addEdge(avf11);
        graph.addEdge(avf12);
        graph.addEdge(avf13);
        graph.addEdge(avf14);
        graph.addEdge(avf15);
        graph.addEdge(avf16);
        graph.addEdge(avf17);
        graph.addEdge(avf18);
        graph.addEdge(avf19);
        graph.addEdge(avf20);
        List<String> list = graph.listChildren(venusii);
        List<String> marvelList = marvelGraph.listChildren(venusii);
        Collections.sort(list);
        Collections.sort(marvelList);
        assertEquals("Children do not match:", list, marvelList);
    }

    //////////////////////////////////////////////////////////
    /////  Marvel Paths Mini Test (Graph list children)
    //////////////////////////////////////////////////////////
    @Test
    public void createGraphMini() {
        String filename = "mcu.csv";
        Graph graph = new Graph();
        String n1 = ("Iron-Man");
        String n2 = ("Black-Widow");
        Edge e1 = new Edge("Iron-Man-2", n1, n2);
        Edge e2 = new Edge("Iron-Man-2", n2, n1);
        graph.addNode(n1);
        graph.addNode(n2);
        graph.addEdge(e1);
        graph.addEdge(e2);
        Graph mcuGraph = createGraph(filename);
        assertEquals("Children do not match:", graph.listChildren(n1), mcuGraph.listChildren(n1));
    }
}
