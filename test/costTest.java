import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class costTest {

    public static final String city1Name = "City1";
    public static final String city2Name = "City2";
    public static final int distance = 4;
    @Test
    void getCost() {
        City city1 = new City(city1Name);
        City city2 = new City(city2Name);
        Link link = new Link(city1, city2, distance, "green");
        TreeSet<Link> l = new TreeSet<>();
        l.add(link);
        cost c = new cost();
        int actual = c.getCost(l);
        assertEquals(4,actual, "getCost did not return correct answer");
    }

}