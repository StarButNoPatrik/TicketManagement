package Entity;

public abstract class User {
    protected String name;
    protected String id;
    public user(String name, String id) {
        this.name = name;
        this.id = id;
    }
    abstract void showProfile();

    
}
