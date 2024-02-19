import java.util.List;

public class Event {

    private String id;

    private String name;
    private Long fromTimestamp;

    private Long toTimestamp;

    private List<User> users;

    private List<Team> teams;

    private Integer representation;

    private List<User> allUsersAttendingMeeting;

    public Event(String id, String name, Long fromTimestamp, Long toTimestamp, List<User> users, List<Team> teams, Integer representation) {
        this.id = id;
        this.name = name;
        this.fromTimestamp = fromTimestamp;
        this.toTimestamp = toTimestamp;
        this.users = users;
        this.teams = teams;
        this.representation = representation;
        for (User u: users) {
            allUsersAttendingMeeting.add(u);
        }
    }

    public Long getFromTimestamp() {
        return fromTimestamp;
    }

    public void setFromTimestamp(Long fromTimestamp) {
        this.fromTimestamp = fromTimestamp;
    }

    public Long getToTimestamp() {
        return toTimestamp;
    }

    public void setToTimestamp(Long toTimestamp) {
        this.toTimestamp = toTimestamp;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public Integer getRepresentation() {
        return representation;
    }

    public void setRepresentation(Integer representation) {
        this.representation = representation;
    }

    public List<User> getAllUsersAttendingMeeting() {
        return allUsersAttendingMeeting;
    }

    public void setAllUsersAttendingMeeting(List<User> allUsersAttendingMeeting) {
        this.allUsersAttendingMeeting = allUsersAttendingMeeting;
    }


    public void addUser(User user) {
        allUsersAttendingMeeting.add(user);
    }
}
