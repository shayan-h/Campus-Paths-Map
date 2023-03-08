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

package campuspaths;

import campuspaths.utils.CORSFilter;
import com.google.gson.Gson;
import pathfinder.CampusMap;
import pathfinder.datastructures.Path;
import pathfinder.datastructures.Point;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SparkServer {

    public static void main(String[] args) {
        CORSFilter corsFilter = new CORSFilter();
        corsFilter.apply();
        // The above two lines help set up some settings that allow the
        // React application to make requests to the Spark server, even though it
        // comes from a different server.
        // You should leave these two lines at the very beginning of main().

        // TODO: Create all the Spark Java routes you need here.

        CampusMap campusMap = new CampusMap();
        Spark.get("/home-page", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                return "Home Page";
            }
        });
        Spark.get("/find-campus-path", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                String start = request.queryParams("start");
                String dest =  request.queryParams("dest");
                if (start == null || dest == null) {
                    Spark.halt(400, "Start or destination is invalid");
                }
                Path<Point> shortestPath = campusMap.findShortestPath(start, dest);
                Gson gson = new Gson();
                String jsonResponse = gson.toJson(shortestPath);
                return jsonResponse;
            }
        });
    }

}
