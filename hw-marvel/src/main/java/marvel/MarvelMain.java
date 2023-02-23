package marvel;

import graph.Edge;
import graph.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static marvel.MarvelPaths.createGraph;
public class MarvelMain {

    public static void main(String[] args) {
        MarvelPaths marvelPaths = new MarvelPaths();
        Graph<String, String> graph = new Graph<>();
        graph = createGraph("marvel.csv");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the name of the first character: ");
            String character1 = scanner.nextLine();
            System.out.print("Enter the name of the second character: ");
            String character2 = scanner.nextLine();
            List<Edge<String, String>> edges = marvelPaths.findPath(character1, character2, graph);
            if (edges == null) {
                System.out.println("No path found between " + character1 + " and " + character2);
            } else {
                System.out.println("Path between " + character1 + " and " + character2 + ": " + Arrays.toString(edgesHelper(edges).toArray()));
            }
            System.out.print("Do you want to find another path? (y/n): ");
            String answer = scanner.nextLine();
            if (!answer.equalsIgnoreCase("y")) {
                break;
            }
        }
        scanner.close();
    }

    public static List<String> edgesHelper(List<Edge<String, String>> edges) {
        List<String> list = new ArrayList<>();
        for (Edge<String, String> e : edges) {
            list.add(e.getLabel());
        }
        return list;
    }
}
