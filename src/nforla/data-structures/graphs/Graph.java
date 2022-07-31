package graphs;

import trees.BinarySearchTree;

import java.util.*;

/**
 * Very basic implementation of an undirected graph using adjacency list (in a hash map)
 * for Algorithms & Data Structures Course
 * */
public class Graph {

    private int numberOfNodes;
    private Map<Integer, List<Integer>> adjacencyList;

    public Graph() {
        numberOfNodes = 0;
        adjacencyList = new HashMap<>();
    }

    public void addVertex(Integer node) {
        if(node == null) {
            System.out.println("Can't add null node");
            return;
        }
        if(adjacencyList.containsKey(node)) {
            System.out.println("Node already exists");
            return;
        }
        adjacencyList.put(node, new ArrayList<>());
        numberOfNodes++;
    }

    public void removeVertex(Integer node) {
        if(node == null) {
            System.out.println("Can't add null node");
            return;
        }
        if(!adjacencyList.containsKey(node)) {
            System.out.println("Node doesn´t exists");
            return;
        }

        var nodeEdges = adjacencyList.get(node).toArray();

        for (Object nodeEdge : nodeEdges) {
            this.removeEdge(node, (Integer) nodeEdge);
        }
        adjacencyList.remove(node);
    }

    public void addEdge(Integer node1, Integer node2) {
        if(!adjacencyList.containsKey(node1) || !adjacencyList.containsKey(node2)) {
            System.out.println("Both nodes have to exists in the graph");
            return;
        }
        var node1Connections = adjacencyList.get(node1);
        if(!node1Connections.contains(node2)) {
            node1Connections.add(node2);
            var node2Connections = adjacencyList.get(node2);
            node2Connections.add(node1);
        }
    }

    public void removeEdge(Integer node1, Integer node2) {
        if(!adjacencyList.containsKey(node1) || !adjacencyList.containsKey(node2)) {
            System.out.println("Both nodes have to exists in the graph");
            return;
        }
        adjacencyList.get(node1).remove(node2);
        adjacencyList.get(node2).remove(node1);
    }

    public void showConnections() {
        for (var node: adjacencyList.keySet()) {
            System.out.printf("Node %d --> %s%n", node, adjacencyList.get(node));
        }
    }

    public static void main(String[] args) {

        Graph graph = new Graph();
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);

        graph.addEdge(3, 1);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);
        graph.addEdge(4, 5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(6, 5);
        //graph.removeEdge(6, 5);
        graph.removeVertex(4);
        graph.showConnections();

    }
}
