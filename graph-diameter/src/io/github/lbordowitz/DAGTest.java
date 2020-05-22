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

    @Test
    public void MostafaTest() {
        // create graph nodes
        List<Node> graph = Arrays.asList(
                new Node("0"),
                new Node("1"),
                new Node("2"),
                new Node("3"),
                new Node("4"),
                new Node("5"),
                new Node("6"),
                new Node("7")
        );

        // set up directed graph edges
        graph.get(0).addNeighbor(graph.get(3));
        graph.get(1).addNeighbor(graph.get(2));
        graph.get(2).addNeighbor(graph.get(3));
        graph.get(3).addNeighbor(graph.get(4));
        graph.get(4).addNeighbor(graph.get(5));
        graph.get(4).addNeighbor(graph.get(6));
        graph.get(6).addNeighbor(graph.get(7));

        assertEquals(5, Node.getDiameter(graph));
    }

    @Test
    public void ForkTest() {
        // create graph nodes
        List<Node> graph = Arrays.asList(
                new Node("root"),
                new Node("1a"),
                new Node("2a"),
                new Node("1b"),
                new Node("2b"),
                new Node("3b"),
                new Node("4b"),
                new Node("end")
        );

        // set up directed graph edges
        graph.get(0).addNeighbor(graph.get(1));
        graph.get(1).addNeighbor(graph.get(2));
        graph.get(2).addNeighbor(graph.get(7));

        graph.get(0).addNeighbor(graph.get(3));
        graph.get(3).addNeighbor(graph.get(4));
        graph.get(4).addNeighbor(graph.get(5));
        graph.get(5).addNeighbor(graph.get(6));
        graph.get(6).addNeighbor(graph.get(7));

        assertEquals(4, Node.getDiameter(graph));
    }
}
