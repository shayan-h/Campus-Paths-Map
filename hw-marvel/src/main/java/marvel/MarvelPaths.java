package marvel;

import graph.Edge;
import graph.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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
}
