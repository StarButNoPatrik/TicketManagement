package system;
import java.io.*;
import java.util.*;

import Entity.Attendee;
import Entity.Event;
import Entity.Organiser;
import Entity.Ticket;
import Entity.User;
import exceptions.InvalidBookingException;

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
                .filter(a -> a.getId().equals(attendeeId))
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


    public void saveEvents() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("events.dat"))) {
            oos.writeObject(events);
            System.out.println("Events saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving events.");
        }
    }

    @SuppressWarnings("unchecked")
	public void loadEvents() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("events.dat"))) {
            events = (List<Event>) ois.readObject();
            System.out.println("Events loaded successfully.");
        } catch (Exception e) {
            System.out.println("No previous events found.");
        }
    }
    // Display
    public void showEvents() {
        if (events.isEmpty()) {
            System.out.println("No events available.");
        } else {
            for (Event e : events) {
                System.out.println(e);
            }
        }
    }
}
