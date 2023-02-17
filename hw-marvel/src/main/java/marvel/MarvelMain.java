package marvel;

import graph.Graph;

import java.util.Arrays;
import java.util.List;

import static marvel.MarvelPaths.createGraph;
public class MarvelMain {

    public static void main(String[] args) {
        Graph graph = createGraph("marvel.csv");
        List<String> list = graph.listChildren("HULK/DR.-ROBERT-BRUC");
        System.out.println(Arrays.toString(list.toArray()));
    }
}
