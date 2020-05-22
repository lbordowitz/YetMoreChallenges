package io.github.lbordowitz;

import java.util.LinkedList;
import java.util.List;

public class Node {
    public List<Node> neighbors;

    public String label;
    public Node(String label) {
        this.label = label;
        neighbors = new LinkedList<>();
    }

    public static int getDiameter(List<Node> graph) {
        // IMPLEMENT YOUR ALGORITHM HERE

        return 0;
    }

    public void addNeighbor(Node n) {
        this.neighbors.add(n);
    }
}
