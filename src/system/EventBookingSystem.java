package system;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;



import Entity.Attendee;
import Entity.Organiser;
import Entity.User;

public class EventBookingSystem {
    private List<Attendee> attendees = new ArrayList<>();
    private List<Organiser> organisers = new ArrayList<>();
    private List<Event> events = new ArrayList<>();
    private List<Ticket> tickets = new ArrayList<>();

    // User Registration
    public void registerUser(User user) {
        if (user instanceof Attendee) {
            attendees.add((Attendee) user);
        } else if (user instanceof Organiser) {
            organisers.add((Organiser) user);
        }
    }

    // Event Management
    public void addEvent(Event event) {
        events.add(event);
    }

    // Ticket Booking
    public void bookTicket(Attendee attendee, Event event) {
        if (event.isAvailable()) {
            tickets.add(new Ticket(attendee, event));
            event.setAvailableTickets(event.getAvailableTickets() - 1);
        }
    }

    // File Persistence
    public void saveEvents() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("events.dat"))) {
            oos.writeObject(events);
        }
    }

    @SuppressWarnings("unchecked")
    public void loadEvents() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("events.dat"))) {
            events = (List<Event>) ois.readObject();
        }
    }

    // Display
    public void showEvents() {
        events.forEach(event -> System.out.println(event.getTitle() + " - Tickets: " + event.getAvailableTickets()));
    }
}

