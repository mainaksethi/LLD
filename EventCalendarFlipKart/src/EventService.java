import java.util.*;

public class EventService {

    Map<User, Set<Event>> userToEventMap;

    Map<String, Event> eventMap;

    public Set<Event> getEventsForUser(User u) {
        return userToEventMap.get(u);
    }

    public List<Slot> getAvailableTimeSlots(User user) {
        Set<Event> events = userToEventMap.get(user);
        List<Event> eventsList = events.stream().toList();
        eventsList.sort(new Comparator<Event>() {
            @Override
            public int compare(Event o1, Event o2) {
                if (o1.getFromTimestamp() < o2.getFromTimestamp()) {
                    return -1;
                }
                return 1;
            }
        });

        List<Slot> slots = new ArrayList<>();

        Long startTime = user.getWorkingHoursStarting();

        for (Event e: eventsList) {
            if (startTime < e.getFromTimestamp()) {
                slots.add(new Slot(startTime, e.getFromTimestamp()));
            }
            startTime = e.getToTimestamp();
        }
        if (startTime < user.getWorkingHoursEnd()) {
            slots.add(new Slot(startTime, user.getWorkingHoursEnd()));
        }
        return slots;
    }

    public void createEvent(Event e) {
        for (User user: e.getUsers()) {
            if (!eventInAvailableTimeSlot(user, e)) {
                throw new EventCannotBeCreatedException();
            }
        }
        List<Team> teams = e.getTeams();
        for (Team t1: teams) {
            List<User> users = t1.getUsers();
            Integer repCount = 0;
            for (User user: users) {
                if (eventInAvailableTimeSlot(user, e)) {
                    repCount++;
                    e.addUser(user);
                }
                if(repCount == e.getRepresentation()) {
                    break;
                }
            }
            if (repCount < e.getRepresentation()) {
                throw new EventCannotBeCreatedException();
            }
        }
        for (User u: e.getAllUsersAttendingMeeting()) {
            if (userToEventMap.get(u) == null) {
                userToEventMap.put(u, new HashSet<>());
            }
            Set<Event> events = userToEventMap.get(u);
            events.add(e);
        }
    }

    public boolean eventInAvailableTimeSlot(User u, Event e) {
        List<Slot> slots = getAvailableTimeSlots(u);
        for (Slot slot: slots) {
            if (slot.getStartTime() <= e.getFromTimestamp() && slot.getEndTime() >= e.getToTimestamp()) {
                return true;
            }
        }
        return false;
    }
}
