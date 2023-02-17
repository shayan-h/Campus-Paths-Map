package marvel;

import graph.Edge;
import graph.Graph;
import org.w3c.dom.Node;

import java.util.*;

import static marvel.MarvelParser.parseData;

public class MarvelPaths {

    // Fields


    public static Graph createGraph(String filename) {
        Graph graph = new Graph();
        HashMap<String, HashSet<String>> tempMap = new HashMap<>();
        tempMap = parseData(filename);
        HashMap<String, List<String>> charComic = new HashMap<>();
        List<String> characters = new ArrayList<>();

        // Converting tempMap's hashsets into lists for charComic
        for (String s : tempMap.keySet()) {
            charComic.put(s, new ArrayList<>(tempMap.get(s)));
        }
        // Adds each of the lists of characters from charComic to a characters list.
        for (String s : charComic.keySet()) {
            characters.add("$" + s);
            characters.addAll(charComic.get(s));
        }
        // Adds each of the characters from the characters list to the graph as nodes.
        for (String s : characters) {
            if (!s.startsWith("$")) {
                graph.addNode(s);
            }
        }

        String edgeLabel = "";
        for (int i = 0; i < characters.size(); i++) {
            for (int j = i + 1; j < characters.size(); j++) {
                if (characters.get(i).startsWith("$") || i == 0) {
                    edgeLabel = characters.get(i).substring(1);
                    j = characters.size();
                } else if (characters.get(j).startsWith("$")) {
                    j = characters.size();
                }
                else {
                    graph.addEdge(new Edge(edgeLabel, graph.getNode(characters.get(i)), graph.getNode(characters.get(j))));
                    graph.addEdge(new Edge(edgeLabel, graph.getNode(characters.get(j)), graph.getNode(characters.get(i))));
                }
            }
        }
        return graph;
    }

    public static List<Edge> findPath(String startNode, String destNode, Graph graph) {
        if (graph == null) {
            return new ArrayList<>();
        } else if (startNode == null || destNode == null){
            return new ArrayList<>();
        }else if (!(graph.listNodes().contains(startNode)) || !(graph.listNodes().contains(destNode))){
            return new ArrayList<>();
        }

        Queue<String> checkList = new LinkedList<>();
        Map<String, List<Edge>> path = new HashMap<>();

        checkList.add(startNode);
        List<Edge> temp = new ArrayList<>();
        path.put(startNode, temp);
        while (!checkList.isEmpty()) {
            String node = checkList.remove();
            if (node.equals(destNode)) {
                return path.get(node);
            } else {
                Set<Edge> paths = graph.getAllEdges(node);
                List<Edge> listPaths = new ArrayList<>(paths);
                Collections.sort(listPaths, new Comparator<Edge>() {
                    @Override
                    public int compare(Edge o1, Edge o2) {
                        if (!o1.getIncomingNode().equals(o2.getIncomingNode())) {
                            return o1.getIncomingNode().compareTo(o2.getIncomingNode());
                        } else if (!o1.getLabel().equals(o2.getLabel())) {
                            return o1.getLabel().compareTo(o2.getLabel());
                        }
                        return 0;
                    }
                });
                for (Edge p : listPaths) {
                    if (!path.containsKey(p.getIncomingNode())) {
                        List<Edge> currentPaths = new ArrayList<>(path.get(node));
                        currentPaths.add(p);
                        path.put(p.getIncomingNode(), currentPaths);
                        checkList.add(p.getIncomingNode());
                    }
                }
            }
        }
        return new ArrayList<>();
    }
}
