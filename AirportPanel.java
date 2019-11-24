import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AirportPanel {

  private Map<String, Plane> planes = new HashMap<String, Plane>();
  private List<Flight> flights = new ArrayList<Flight>();
  private Scanner scanner;
  private FlightService flightService;

  public AirportPanel() {
    scanner = new Scanner(System.in);
    flightService = new FlightService(scanner, this);
  }

  public void start() {
    System.out.println("Airport panel");
    System.out.println("--------------------");
    System.out.println();

    while (true) {
      menu();
      String choice = scanner.nextLine();

      if (choice.equals("1")) {
        addPlane();
      } else if (choice.equals("2")) {
        addFlight();
      } else if (choice.equals("x")) {
        break;
      }
    }

    flightService.start();
  }

  private void menu() {
    System.out.println("Choose operation:");
    System.out.println("[1] Add airplane");
    System.out.println("[2] Add flight");
    System.out.println("[x] Exit");
    System.out.print("> ");
  }

  public void addPlane() {
    System.out.print("Give plane ID: ");
    String id = scanner.nextLine();
    System.out.print("Give plane capacity: ");
    int capacity = Integer.parseInt(scanner.nextLine());

    planes.put(id, new Plane(id, capacity));
  }

  public Map<String, Plane> getPlanes() {
    return planes;
  }

  public Plane findPlane(String id) {
    return planes.get(id);
  }

  public void addFlight() {
    System.out.print("Give plane ID: ");
    String id = scanner.nextLine();
    System.out.print("Give departure airport code: ");
    String departureCode = scanner.nextLine();
    System.out.print("Give destination airport code: ");
    String arrivalCode = scanner.nextLine();

    if (findPlane(id) != null) {
      flights.add(new Flight(findPlane(id), departureCode, arrivalCode));
    }
  }

  public List<Flight> getFlights() {
    return flights;
  }

}
