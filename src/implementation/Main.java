package implementation;
import java.util.Scanner;

import Entity.Attendee;
import system.EventBookingSystem;

public class Main {
    public static void main(String[] args) {
        EventBookingSystem system = new EventBookingSystem();
        Scanner scanner = new Scanner(System.in);

        try {
            system.loadEvents();
        } catch (Exception e) {
            System.out.println("No saved events found. Starting fresh.");
        }

        while (true) {
            System.out.println("\n1. Register Attendee\n2. Add Event\n3. Book Ticket\n4. Show Events\n5. Save & Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter attendee ID and name:");
                    system.registerUser(new Attendee(scanner.nextLine(), scanner.nextLine()));
                    break;
                case 2:
                    System.out.println("Enter event title and ticket count:");
                    system.addEvent(new Event(scanner.nextLine(), scanner.nextInt()));
                    break;
                case 3:
                    System.out.println("Enter attendee ID and event title:");
                    // (In real code, lookup attendee/event first)
                    system.bookTicket(new Attendee("temp", "temp"), new Event(scanner.nextLine(), 0));
                    break;
                case 4:
                    system.showEvents();
                    break;
                case 5:
                    try {
                        system.saveEvents();
                        System.out.println("Data saved. Exiting.");
                        return;
                    } catch (Exception e) {
                        System.out.println("Error saving data!");
                    }
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}