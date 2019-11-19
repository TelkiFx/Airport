public class Plane {

  private String id;
  private int capacity;

  public Plane(String id, int capacity) {
    this.id = id;
    this.capacity = capacity;
  }

  public String getId() {
    return id;
  }

  public String getInfo() {
    if (capacity == 0) {
      return id + " (empty)";
    } else if (capacity == 1) {
      return id + " (" + capacity + " person)";
    } else {
      return id + " (" + capacity + " ppl)";
    }
  }

}
