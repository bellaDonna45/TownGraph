package towngraphpackage;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TownGraphManager_STUDENT_Test {

    private TownGraphManagerInterface graph;
    private String[] town;

    @Before
    public void setUp() throws Exception {
        graph = new TownGraphManager();
        town = new String[5];
        for (int i = 0; i < 5; i++) {
            town[i] = "Town_" + i;
            graph.addTown(town[i]);
        }

        graph.addRoad(town[0], town[1], 2, "Road_1");
        graph.addRoad(town[1], town[2], 3, "Road_2");
        graph.addRoad(town[2], town[3], 4, "Road_3");
    }

    @After
    public void tearDown() {
        graph = null;
    }

    @Test
    public void testAddTownAndRoad() {
        assertTrue(graph.containsTown("Town_0"));
        assertEquals("Road_1", graph.getRoad("Town_0", "Town_1"));
    }

    @Test
    public void testGetPath() {
        ArrayList<String> path = graph.getPath("Town_0", "Town_3");
        assertEquals(3, path.size());
        assertEquals("Town_0 via Road_1 to Town_1 2 mi", path.get(0).trim());
        assertEquals("Town_1 via Road_2 to Town_2 3 mi", path.get(1).trim());
    }

    @Test
    public void testDeleteTown() {
        assertTrue(graph.deleteTown("Town_4"));
        assertFalse(graph.containsTown("Town_4"));
    }

    @Test
    public void testDeleteRoadConnection() {
        assertTrue(graph.containsRoadConnection("Town_0", "Town_1"));
        assertTrue(graph.deleteRoadConnection("Town_0", "Town_1", "Road_1"));
        assertFalse(graph.containsRoadConnection("Town_0", "Town_1"));
    }

    @Test
    public void testAllRoadsAndTowns() {
        ArrayList<String> roads = graph.allRoads();
        ArrayList<String> towns = graph.allTowns();
        assertEquals(3, roads.size());
        assertEquals(5, towns.size());
    }
}

