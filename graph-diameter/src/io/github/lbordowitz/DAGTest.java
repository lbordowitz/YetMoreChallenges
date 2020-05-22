package io.github.lbordowitz;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DAGTest {

    @Test
    public void BasicTest() {
        // create graph nodes
        List<Node> graph = Arrays.asList(
            new Node("0"),
            new Node("1"),
            new Node("2"),
            new Node("3")
        );

        // set up directed graph edges
        graph.get(0).addNeighbor(graph.get(1));
        graph.get(0).addNeighbor(graph.get(2));
        graph.get(0).addNeighbor(graph.get(3));
        graph.get(1).addNeighbor(graph.get(2));
        graph.get(1).addNeighbor(graph.get(3));
        graph.get(2).addNeighbor(graph.get(3));

        assertEquals(1, Node.getDiameter(graph));
    }
}