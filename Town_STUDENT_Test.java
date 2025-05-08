package towngraphpackage;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Town_STUDENT_Test {

    private Town town1, town2, town3;

    @Before
    public void setUp() {
        town1 = new Town("Town_1");
        town2 = new Town("Town_1");
        town3 = new Town("Town_2");
    }

    @After
    public void tearDown() {
        town1 = town2 = town3 = null;
    }

    @Test
    public void testEquals() {
        assertTrue(town1.equals(town2));
        assertFalse(town1.equals(town3));
    }

    @Test
    public void testCompareTo() {
        assertEquals(0, town1.compareTo(town2));
        assertTrue(town1.compareTo(town3) < 0);
    }

    @Test
    public void testToString() {
        assertEquals("Town_1", town1.toString());
    }

    @Test
    public void testHashCode() {
        assertEquals(town1.hashCode(), town2.hashCode());
    }
}


