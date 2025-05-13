package model;

import java.util.Iterator;
import java.util.List;

import Entity.User;
import annotations.RoleRequired;

@RoleRequired(role = "Admin")
public class Admin extends User {
    public Admin(String id, String name) {
        super(id, name);
    }
    @Override
    public void showProfile() {
        System.out.println("Admin Profile - ID: " + id + ", Name: " + name);
    }

    public void removeEvent(List<Event> events, String title) {
        Iterator<Event> iterator = events.iterator();
        while (iterator.hasNext()) {
            Event event = iterator.next();
            if (event.getTitle().equals(title)) {
                iterator.remove();
                System.out.println("Event removed: " + title);
                return;
            }
        }
        System.out.println("Event not found: " + title);
    }
}