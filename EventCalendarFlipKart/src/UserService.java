import java.util.Map;

public class UserService {

    private Map<String, User> userMap;

    private Map<String, Team> teamMap;

    public void registerUser(User u) {
        userMap.put(u.getId(), u);
    }

    public void registerTeam(Team t) {
        teamMap.put(t.getId(), t);
    }

}
