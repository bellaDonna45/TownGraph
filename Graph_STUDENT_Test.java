package towngraphpackage;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Graph_STUDENT_Test {

    private Graph graph;
    private Town[] town;

    @Before
    public void setUp() {
        graph = new Graph();
        town = new Town[4];
        for (int i = 0; i < 4; i++) {
            town[i] = new Town("Town_" + i);
            graph.addVertex(town[i]);
        }

        graph.addEdge(town[0], town[1], 2, "Road_1");
        graph.addEdge(town[1], town[2], 3, "Road_2");
        graph.addEdge(town[2], town[3], 4, "Road_3");
    }

    @After
    public void tearDown() {
        graph = null;
    }

    @Test
    public void testGetEdge() {
        assertEquals(new Road(town[0], town[1], 2, "Road_1"), graph.getEdge(town[0], town[1]));
    }

    @Test
    public void testAddVertex() {
        Town newTown = new Town("Town_4");
        assertFalse(graph.containsVertex(newTown));
        graph.addVertex(newTown);
        assertTrue(graph.containsVertex(newTown));
    }

    @Test
    public void testShortestPath() {
        ArrayList<String> path = graph.shortestPath(town[0], town[3]);
        assertEquals(3, path.size());
        assertEquals("Town_0 via Road_1 to Town_1 2 mi", path.get(0).trim());
    }
}

