/*
 * Copyright (C) 2023 Hal Perkins.  All rights reserved.  Permission is
 * hereby granted to students registered for University of Washington
 * CSE 331 for use solely during Winter Quarter 2023 for purposes of
 * the course.  No other use, copying, distribution, or modification
 * is permitted without prior written consent. Copyrights for
 * third-party components of this work must be honored.  Instructors
 * interested in reusing these course materials should contact the
 * author.
 */

package pathfinder;

import graph.Edge;
import graph.Graph;
import org.w3c.dom.stylesheets.LinkStyle;
import pathfinder.datastructures.Path;
import pathfinder.datastructures.Point;
import pathfinder.parser.CampusBuilding;
import pathfinder.parser.CampusPath;
import pathfinder.parser.CampusPathsParser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static pathfinder.datastructures.DijkstrasAlgo.findShortestRoute;

public class CampusMap implements ModelAPI {

    private final List<CampusPath> paths = CampusPathsParser.parseCampusPaths("campus_paths.csv");
    private final List<CampusBuilding> buildings =CampusPathsParser.parseCampusBuildings("campus_buildings.csv");

    @Override
    public boolean shortNameExists(String shortName) {
        // TODO: Implement this method exactly as it is specified in ModelAPI
        if (shortName == null) {
            throw new IllegalArgumentException("shortName is null.");
        }
        return buildingNames().containsKey(shortName);
        // throw new RuntimeException("Not Implemented Yet");
    }

    @Override
    public String longNameForShort(String shortName) {
        // TODO: Implement this method exactly as it is specified in ModelAPI
        if (shortName == null) {
            throw new IllegalArgumentException("shortName is null");
        }
        return buildingNames().get(shortName);
        // throw new RuntimeException("Not Implemented Yet");
    }

    @Override
    public Map<String, String> buildingNames() {
        // TODO: Implement this method exactly as it is specified in ModelAPI
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < buildings.size(); i++) {
            map.put(buildings.get(i).getShortName(), buildings.get(i).getLongName());
        }
        return map;
        // throw new RuntimeException("Not Implemented Yet");
    }

    @Override
    public Path<Point> findShortestPath(String startShortName, String endShortName) {
        // TODO: Implement this method exactly as it is specified in ModelAPI
        if (startShortName == null || endShortName == null) {
            return null;
        }
        Graph<Point, Double> graph = new Graph<>();
        Point start = new Point(0, 0);
        Point end = new Point(0, 0);
        Point x1y1 = new Point(0, 0);
        Point x2y2 = new Point(0,0);
        for (int i = 0; i < buildings.size(); i++) {
            graph.addNode(new Point(buildings.get(i).getX(), buildings.get(i).getY()));
            if (buildings.get(i).getShortName().equals(startShortName)) {
                start = new Point(buildings.get(i).getX(), buildings.get(i).getY());
            }
            if (buildings.get(i).getShortName().equals(endShortName)) {
                end = new Point(buildings.get(i).getX(), buildings.get(i).getY());
            }
        }
        for (CampusPath p : paths) {
            graph.addNode(new Point(p.getX1(), p.getY1()));
            graph.addNode(new Point(p.getX2(), p.getY2()));
        }
        for (CampusPath p : paths) {
            x1y1 = new Point(p.getX1(), p.getY1());
            x2y2 = new Point(p.getX2(), p.getY2());
            graph.addEdge(new Edge<>(p.getDistance(), x1y1, x2y2));
        }
        return findShortestRoute(start, end, graph);
        // throw new RuntimeException("Not Implemented Yet");
    }

}
