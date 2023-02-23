package pathfinder.datastructures;

import graph.Edge;
import graph.Graph;

import java.util.PriorityQueue;

public class DijkstrasAlgo {


    public static <N, E> Path<N> findShortestRoute(N start, N end, Graph<N, E> graph) {
        PriorityQueue<Path<N>> active = new PriorityQueue<>();
        PriorityQueue<N> finished = new PriorityQueue<>();

        if (graph == null || !graph.listNodes().contains(start) || !graph.listNodes().contains(end)) {
            return null;
        }

        active.add(new Path<>(start));

        while (!active.isEmpty()) {
            Path<N> minPath = active.remove();
            N minDest = minPath.getEnd();
            if (minDest.equals(end)) {
                return minPath;
            }
            if (finished.contains(minDest)) {
                continue;
            }
            for (N child : graph.listChildren(minDest)) {
                if (!finished.contains(child)) {
                    Path<N> newPath = minPath.extend(child, (Double) graph.getEdge(child).getLabel());
                    active.add(newPath);
                }
            }
            finished.add(minDest);
        }
        return null;
    }
}
