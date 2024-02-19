import java.util.List;

public class Team {

    private String id;
    private List<User> users;

    public Team(String id, List<User> users) {
        this.id = id;
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
