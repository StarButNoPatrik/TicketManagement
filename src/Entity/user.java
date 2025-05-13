package Entity;

public abstract class User {
    protected String name;
    protected String id;
    public User(String name, String id) {
        this.name = name;
        this.id = id;
    }
    public abstract void showProfile();

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
