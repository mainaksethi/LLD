package models;

public class Rider {

    private String name;

    public Rider(String name, String id) {
        this.name = name;
        this.id = id;
    }

    private String id;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
