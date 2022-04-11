/*
 * This class takes inputs, compute route costs and route available
 * and displays the output accordingly
 */
import java.util.*;

public class RouteCost {

  public static void main(String [] args) {
    Scanner inp = new Scanner(System.in);
    TreeSet<Link> links = new TreeSet<Link>();
    String color;

    String name = inp.nextLine();
    // copy of the input String so that it can be displayed if exception is thrown
    String copyName = name;
    /*
    This part checks if the input given is valid
    if it's not valid it throws exception
    and displays input string entered.
     */
    try {
      while(!name.equals("done")) {
        // split the input string in an Array
        String separator[] = name.split(" ",4);
        if(separator.length < 3) {
          throw new InputMismatchException();
        }
        else if(separator.length==3) {
          City city1 = City.find(separator[0]);
          String distance = separator[1];
          try {
            Integer.parseInt(distance);
          } catch (NumberFormatException e) {
            System.out.println("Invalid line: " + name);
            return;
          }
          int length = Integer.parseInt(separator[1]);
          City city2 = City.find(separator[2]);
          Link l = new Link(city1, city2, length, null);
        }
        else if(separator.length == 4) {
          City c1 = City.find(separator[0]);
          String distance = separator[1];
          try {
            Integer.parseInt(distance);
          } catch (NumberFormatException e) {
            System.out.println("Invalid line: "+name);
            return;
          }
          int length = Integer.parseInt(separator[1]);
          City c2 = City.find(separator[2]);
          color = separator[3];
          if(!color.equals("green") && !color.equals("red") && !color.equals("")) {
            throw new InputMismatchException();
          }
          else {
            Link l = new Link(c1,c2,length,color);
          }
        }
        else {
          System.out.println("Invalid line: " + name);
        }
        name = inp.nextLine();
      }
    }
    catch (InputMismatchException e) {
      System.out.println("Invalid line: " + copyName);
      System.exit(0);
    }

    String input= inp.nextLine();
    while (!input.equals("done")) {
      String separator1[] = input.split(" ", 3);
      if (separator1.length < 2 || separator1.length > 3) {
        System.out.println("Invalid line: "+ input);
        return;
      }
      City c1 = City.find(separator1[0]);
      City c2 = City.find(separator1[1]);
      String colour = null;
      if(separator1.length == 3) {
        colour = separator1[2];
        if (!colour.equals("green") && !(colour.equals("red"))) {
          System.out.println("Invalid line: "+ input);
          return;
        }
      }
      c1.makeTree(colour);
      if (!c1.getLinksTo(c2, links, colour)) {
        System.out.println("Error: Route not found! " + separator1[0]);
        return;
      }
      input = inp.nextLine();
    }

    cost c = new cost();
    c.getCost(links);
    System.out.println(c.toString());
  }
}