import java.util.ArrayList;
import java.util.List;

/**
 * A synchronization practice problem requiring us to synchronize the usage of a single bathroom by both the genders.
 * A bathroom is being designed for the use of both males and females in an office but requires the following constraints to be maintained:
 *
 * 1. There cannot be men and women in the bathroom at the same time.
 * 2. There should never be more than three employees in the bathroom simultaneously.
 * 3. The solution should avoid deadlocks. For now, though, don’t worry about starvation.
 */
public class UnisexBathroomProblemManager {
    public static void main(String[] args) {
        UnisexBathroomProblem unisexBathroomProblem = new UnisexBathroomProblem(3);
        List<Thread> males = new ArrayList<>();
        List<Thread> females = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Integer val = i;
            Thread t1 = new Thread(() -> {
                try {
                    unisexBathroomProblem.useBathroom(new Person("Male-" + val, Gender.MALE));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            males.add(t1);
            t1.start();
        }

        for (int i = 0; i < 5; i++) {
            Integer val = i;
            Thread t1 = new Thread(() -> {
                try {
                    unisexBathroomProblem.useBathroom(new Person("Female-" + val, Gender.FEMALE));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            t1.start();
            females.add(t1);
        }
        males.stream().forEach((t) -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        females.stream().forEach((t) -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
