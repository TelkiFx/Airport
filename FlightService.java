import java.util.Scanner;

public class FlightService {

  private Scanner scanner;
  private AirportPanel airportPanel;

  public FlightService(Scanner scanner, AirportPanel airportPanel) {
    this.scanner = scanner;
    this.airportPanel = airportPanel;
  }

  public void start() {
    System.out.println();
    System.out.println("Flight service");
    System.out.println("------------");
    System.out.println();

    while (true) {
      menu();
      String choice = scanner.nextLine();

      if (choice.equals("1")) {
        printAllPlanes();
      } else if (choice.equals("2")) {
        printAllFlights();
      } else if (choice.equals("3")) {
        printPlaneInfo();
      } else if (choice.equals("x")) {
        break;
      }
    }
  }

  public void menu() {
    System.out.println("Choose operation:");
    System.out.println("[1] Print planes");
    System.out.println("[2] Print flights");
    System.out.println("[3] Print plane info");
    System.out.println("[x] Quit");
    System.out.print("> ");
  }

  public void printPlaneInfo() {
    System.out.print("Give plane ID: ");
    String id = scanner.nextLine();
    for (Plane plane : airportPanel.getPlanes().values()) {
      if (plane.getId().equalsIgnoreCase(id)) {
        System.out.println(plane.getInfo());
      }
    }
  }

  public void printAllFlights() {
    for (Flight flight : airportPanel.getFlights()) {
      System.out.println(flight.getInfo());
    }
  }

  public void printAllPlanes() {
    for (Plane plane : airportPanel.getPlanes().values()) {
      System.out.println(plane.getInfo());
    }
  }

}
