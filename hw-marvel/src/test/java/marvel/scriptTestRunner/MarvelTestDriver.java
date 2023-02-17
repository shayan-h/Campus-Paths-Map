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

package marvel.scriptTestRunner;

import graph.Graph;

import java.io.*;
import java.util.HashMap;
import graph.Edge;
import graph.Graph;

import java.io.*;
import java.util.*;
import static marvel.MarvelPaths.createGraph;
import static marvel.MarvelPaths.findPath;


/**
 * This class implements a testing driver which reads test scripts from
 * files for testing Graph, the Marvel parser, and your BFS algorithm.
 */
public class MarvelTestDriver {

    private final Map<String, Graph> graphs = new HashMap<>();
    private final PrintWriter output;
    private final BufferedReader input;

    // Leave this constructor public
    public MarvelTestDriver(Reader r, Writer w) {
        // TODO: Implement this, reading commands from `r` and writing output to `w`.
        // See GraphTestDriver as an example.
        input = new BufferedReader(r);
        output = new PrintWriter(w);

    }

    // Leave this method public
    public void runTests() throws IOException {
        // TODO: Implement this.
        String inputLine;
        while((inputLine = input.readLine()) != null) {
            if((inputLine.trim().length() == 0) ||
                    (inputLine.charAt(0) == '#')) {
                // echo blank and comment lines
                output.println(inputLine);
            } else {
                // separate the input line on white space
                StringTokenizer st = new StringTokenizer(inputLine);
                if(st.hasMoreTokens()) {
                    String command = st.nextToken();

                    List<String> arguments = new ArrayList<>();
                    while(st.hasMoreTokens()) {
                        arguments.add(st.nextToken());
                    }

                    executeCommand(command, arguments);
                }
            }
            output.flush();
        }
    }

    private void executeCommand(String command, List<String> arguments) {
        try {
            switch(command) {
                case "LoadGraph":
                    makeGraph(arguments);
                    break;
                case "CreateGraph":
                    createGraph2(arguments);
                case "FindPath":
                    makePath(arguments);
                    break;
                case "AddNode":
                    addNode(arguments);
                    break;
                case "AddEdge":
                    addEdge(arguments);
                    break;
                case "ListChildren":
                    listChildren(arguments);
                default:
                    output.println("Unrecognized command: " + command);
                    break;
            }
        } catch(Exception e) {
            String formattedCommand = command;
            formattedCommand += arguments.stream().reduce("", (a, b) -> a + " " + b);
            output.println("Exception while running command: " + formattedCommand);
            e.printStackTrace(output);
        }
    }

    private void createGraph2(List<String> arguments) {
        if(arguments.size() != 1) {
            throw new CommandException("Bad arguments to CreateGraph: " + arguments);
        }

        String graphName = arguments.get(0);
        createGraph(graphName);
    }

    private void createGraph2(String graphName) {
        // TODO Insert your code here.
        Graph graph1 = new Graph();
        graphs.put(graphName, graph1);
        output.println("created graph " + graphName);
    }

    private void makeGraph(List<String> arguments) {
        if(arguments.size() != 1) {
            throw new CommandException("Bad arguments to CreateGraph: " + arguments);
        }

        String graphName = arguments.get(0);
        String filename = arguments.get(1);
        makeGraph(graphName, filename);
    }

    private void makeGraph(String graphName, String filename) {
        // TODO Insert your code here.
        Graph graph1 = createGraph(filename);
        graphs.put(graphName, graph1);
        output.println("loaded graph " + graphName);
    }

    private void addNode(List<String> arguments) {
        if(arguments.size() != 2) {
            throw new CommandException("Bad arguments to AddNode: " + arguments);
        }

        String graphName = arguments.get(0);
        String nodeName = arguments.get(1);

        addNode(graphName, nodeName);
    }

    private void addNode(String graphName, String nodeName) {
        // TODO Insert your code here.
        String node1 = nodeName;
        Graph graph1 = graphs.get(graphName);
        graph1.addNode(node1);
        graphs.replace(graphName, graph1);
        output.println("added node " + nodeName + " to " + graphName);
    }

    private void addEdge(List<String> arguments) {
        if(arguments.size() != 4) {
            throw new CommandException("Bad arguments to AddEdge: " + arguments);
        }

        String graphName = arguments.get(0);
        String parentName = arguments.get(1);
        String childName = arguments.get(2);
        String edgeLabel = arguments.get(3);

        addEdge(graphName, parentName, childName, edgeLabel);
    }

    private void addEdge(String graphName, String parentName, String childName,
                         String edgeLabel) {
        // TODO Insert your code here.
        Graph graph1 = graphs.get(graphName);
        // Node p = new Node(parentName);
        // Node c = new Node(childName);
        Edge e = new Edge(edgeLabel, graph1.getNode(parentName), graph1.getNode(childName));

        // graph1.addNode(p);
        // graph1.addNode(c);
        graph1.addEdge(e);
        graphs.replace(graphName, graph1);
        output.println("added edge " + edgeLabel + " from " + parentName + " to " + childName + " in " + graphName);
    }

    private void makePath(List<String> arguments) {
        if(arguments.size() != 2) {
            throw new CommandException("Bad arguments to AddNode: " + arguments);
        }

        String graphName = arguments.get(0);
        String node1 = arguments.get(1);
        String node2 = arguments.get(2);

        makePath(graphName, node1, node2);
    }

    private void makePath(String graphName, String node1, String node2) {
        Graph graph = graphs.get(graphName);
        if (!graph.listNodes().contains(node1)) {
            output.println("unknown: " + node1);
        }
        if (!graph.listNodes().contains(node2)) {
            output.println("unknown: " + node2);
        }
        if (!(graph.listNodes().contains(node1)) && !(graph.listNodes().contains(node2))) {
            output.println("unknown: " + node1);
            output.println("unknown: " + node2);
        }
        List<Edge> list = findPath(node1, node2, graph);
        output.println("path from " + node1 + " to " + node2 + ":");
        if (list == null) {
            output.println("no path found");
        }
        for (int i = 0; i < list.size(); i++) {
            output.println(list.get(i).getOutgoingNode() + " to " + list.get(i).getIncomingNode()
            + " via " + list.get(i).getLabel());
        }
        graphs.put(graphName, graph);
    }

    private void listChildren(List<String> arguments) {
        if(arguments.size() != 2) {
            throw new CommandException("Bad arguments to ListChildren: " + arguments);
        }

        String graphName = arguments.get(0);
        String parentName = arguments.get(1);
        listChildren(graphName, parentName);
    }

    private void listChildren(String graphName, String parentName) {
        // TODO Insert your code here.
        Graph graph1 = graphs.get(graphName);
        String p = graph1.getNode(parentName);
        List<String> list = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        Collections.sort(stringList);
        list = graph1.listChildren(p);
        for (int i = 0; i < list.size(); i++) {
            stringList.add(list.get(i));
        }
        boolean f = true;
        StringBuilder res = new StringBuilder();
        for (String n : stringList) {
            if (f == true) {
                res.append(" " + n);
                f = false;
            } else {
                res.append(" " + n);
            }
        }
        graphs.put(graphName, graph1);
        output.println("the children of " + parentName + " in " + graphName + " are: " + res + "(" + graph1.getEdge(p).getLabel() + ")");
    }

    static class CommandException extends RuntimeException {

        public CommandException() {
            super();
        }

        public CommandException(String s) {
            super(s);
        }

        public static final long serialVersionUID = 3495;
    }


}
