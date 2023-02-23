package marvel;

import graph.Edge;
import graph.Graph;
import org.w3c.dom.Node;

import java.util.*;

import static marvel.MarvelParser.parseData;

public class MarvelPaths {

    // Fields


    /**
     * Creats graph using filename.
     *
     * @param filename name of the file csv.
     * @return a graph.
     * @spec.requires filename != null
     */
    public static Graph<String, String> createGraph(String filename) {
        Graph<String, String> graph = new Graph<>();
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
                    graph.addEdge(new Edge<String, String>(edgeLabel, graph.getNode(characters.get(i)), graph.getNode(characters.get(j))));
                    graph.addEdge(new Edge<String, String>(edgeLabel, graph.getNode(characters.get(j)), graph.getNode(characters.get(i))));
                }
            }
        }
        return graph;
    }

    /**
     * Find paths from start node to end node.
     *
     * @param startNode start node.
     * @param destNode end node.
     * @param graph graph.
     * @return return a list of edges between start and end node.
     */
    public static List<Edge<String, String>> findPath(String startNode, String destNode, Graph<String, String> graph) {
        if (graph == null) {
            return new ArrayList<>();
        } else if (startNode == null || destNode == null){
            return new ArrayList<>();
        }else if (!(graph.listNodes().contains(startNode)) || !(graph.listNodes().contains(destNode))){
            return new ArrayList<>();
        }

        Queue<String> checkList = new LinkedList<>();
        Map<String, List<Edge<String, String>>> path = new HashMap<>();

        checkList.add(startNode);
        List<Edge<String, String>> temp = new ArrayList<>();
        path.put(startNode, temp);
        while (!checkList.isEmpty()) {
            String node = checkList.remove();
            if (node.equals(destNode)) {
                return path.get(node);
            } else {
                Set<Edge<String, String>> paths = graph.getAllEdges(node);
                if (paths == null) {
                    paths = new HashSet<>();
                }
                List<Edge<String, String>> listPaths = new ArrayList<>(Objects.requireNonNull(paths));
                Collections.sort(listPaths, new Comparator<Edge<String, String>>() {
                    @Override
                    public int compare(Edge<String, String> o1, Edge<String, String> o2) {
                        if (!o1.getIncomingNode().equals(o2.getIncomingNode())) {
                            return o1.getIncomingNode().compareTo(o2.getIncomingNode());
                        } else if (!o1.getLabel().equals(o2.getLabel())) {
                            return o1.getLabel().compareTo(o2.getLabel());
                        }
                        return 0;
                    }
                });
                for (Edge<String, String> p : listPaths) {
                    if (!path.containsKey(p.getIncomingNode())) {
                        List<Edge<String, String>> currentPaths = new ArrayList<>(path.get(node));
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
