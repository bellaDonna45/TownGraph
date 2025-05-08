package towngraphpackage;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Road_STUDENT_Test {

    private Town town1, town2, town3;
    private Road road1, road2, road3;

    @Before
    public void setUp() {
        town1 = new Town("Town_1");
        town2 = new Town("Town_2");
        town3 = new Town("Town_3");

        road1 = new Road(town1, town2, 5, "Road_1");
        road2 = new Road(town2, town1, 5, "Road_1");
        road3 = new Road(town2, town3, 10, "Road_2");
    }

    @After
    public void tearDown() {
        town1 = town2 = town3 = null;
        road1 = road2 = road3 = null;
    }

    @Test
    public void testCompareTo() {
        assertTrue(road1.compareTo(road3) < 0);
    }

    @Test
    public void testContains() {
        assertTrue(road1.contains(town1));
        assertFalse(road1.contains(town3));
    }

    @Test
    public void testEquals() {
        assertTrue(road1.equals(road2));
        assertFalse(road1.equals(road3));
    }

    @Test
    public void testToString() {
        assertTrue(road1.toString().contains("Road_1"));
    }
}


