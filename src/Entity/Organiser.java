package Entity;

public class Organiser extends User {
    public Organiser(String name, String id) {
        super(name, id); 
        this.name = name;
        this.id = id;
    }
    boolean active = true;
    boolean isActive() {
        return active;
    }
    boolean setActive(boolean active) {
        this.active = active;
        return this.active; 
    }
    @Override
    public void showProfile() {
        System.out.println("Organiser ID: " + id);
        System.out.println("Organiser Name: " + name);
    }
    
}
