import java.util.TreeSet;
/*
This class is to calculate cost of different routes
 */
public class cost {
    private int total = 0;

    //prints different route networks and cost of building those networks.
    public int getCost(TreeSet<Link> links) {
        System.out.println("The rail network consists of:");
        for (Link l : links) {
            System.out.println("  " + l);
            total += l.getLength();
        }
        return total;
    }

    // print total cost.
    public String toString() {
        return "The total cost is: " + total;
    }
}
