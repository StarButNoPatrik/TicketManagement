package system;
import java.io.*;
import java.util.*;
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
    public void bookTicket(String attendeeId, String eventTitle) throws InvalidBookingException {
        Attendee attendee = attendees.stream()
                .filter(a -> a.id.equals(attendeeId))
                .findFirst()
                .orElse(null);

        Event event = events.stream()
                .filter(e -> e.getTitle().equalsIgnoreCase(eventTitle))
                .findFirst()
                .orElse(null);

        if (attendee == null || event == null || !event.isAvailable()) {
            throw new InvalidBookingException("Invalid booking attempt.");
        }

        Ticket ticket = new Ticket(attendee, event);
        tickets.add(ticket);
        event.setAvailableTickets(event.getAvailableTickets() - 1);
        System.out.println("Ticket successfully booked.");
    }

    // File Persistence
    public void saveEvents() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("events.txt"))) {
            oos.writeObject(events);
        }
    }

    @SuppressWarnings("unchecked")
    public void loadEvents() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("events.txt"))) {
            events = (List<Event>) ois.readObject();
        }
    }

    // Display
    public void showEvents() {
        events.forEach(event -> System.out.println(event.getTitle() + " - Tickets: " + event.getAvailableTickets()));
    }
}

