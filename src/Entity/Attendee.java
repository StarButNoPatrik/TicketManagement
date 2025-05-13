package Entity;

public class Attendee extends User {
    public Attendee(String name, String id) {
        super(name, id); // Explicitly call the parent class constructor
        this.name = name;
        this.id = id;
    }
@Override
public void showProfile() {
    System.out.println("Attendee ID: " + id);
    System.out.println("Attendee Name: " + name);
}
}
