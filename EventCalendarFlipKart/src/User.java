public class User {

    private String id;
    private String name;
    private long workingHoursStarting;
    private long workingHoursEnd;

    public User(String id, String name, long workingHoursStarting, long workingHoursEnd) {
        this.id = id;
        this.name = name;
        this.workingHoursStarting = workingHoursStarting;
        this.workingHoursEnd = workingHoursEnd;
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

    public long getWorkingHoursStarting() {
        return workingHoursStarting;
    }

    public void setWorkingHoursStarting(long workingHoursStarting) {
        this.workingHoursStarting = workingHoursStarting;
    }

    public long getWorkingHoursEnd() {
        return workingHoursEnd;
    }

    public void setWorkingHoursEnd(long workingHoursEnd) {
        this.workingHoursEnd = workingHoursEnd;
    }
}
