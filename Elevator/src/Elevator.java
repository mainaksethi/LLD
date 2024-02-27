import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 1. Elevator has button which are pressed to move the elevator to certain floor.
 * 2. Every Floor has buttons which will call the elevator.
 * 3.
 */

public class Elevator {
    public static void main(String[] args) {
        new Elevator().main2();
    }

    public void main2() {
        ElevatorModel elevatorModel = new ElevatorModel(0);
        elevatorModel.elevatorButtonPressed(2);
        elevatorModel.elevatorButtonPressed(4);
        elevatorModel.floorButtonPressed(1, Direction.DOWN);
    }


    // Handle halt state.
    class ElevatorModel {

        private Direction direction;

        private Integer existingFloor;

        private boolean isElevatorMoving = false;

        private TreeSet<Integer> floorStack = new TreeSet<Integer>();

        private Set<Integer> reverseDirectionFloorStack = new HashSet<Integer>();

        public ElevatorModel(Integer existingFloor) {
            this.existingFloor = existingFloor;
        }

        void elevatorButtonPressed(Integer elevatorButton) {
            floorStack.add(elevatorButton);
            if (!isElevatorMoving) {
                moveElevator(existingFloor > elevatorButton ? Direction.UP : Direction.DOWN);
            }
        }

        void floorButtonPressed(Integer floor, Direction direction) {
            if (direction == this.direction) {
                floorStack.add(floor);
            } else {
                reverseDirectionFloorStack.add(floor);
            }
            if (!isElevatorMoving) {
                moveElevator(existingFloor > floor ? Direction.UP : Direction.DOWN);
            }
        }

        Integer getNextFloor() {
            if(direction == Direction.UP) {
                return floorStack.higher(existingFloor);
            } else {
                return floorStack.lower(existingFloor);
            }
        }

        public void moveElevator(Direction direction) {
            isElevatorMoving = true;
            this.direction = direction;
            this.start();
        }

        public void start() {
            while(true) {
                Integer nextFloor = getNextFloor();
                if (nextFloor == null) {
                    changeDirection();
                    nextFloor = getNextFloor();
                }
                if (nextFloor == null) {
                    break;
                }
                System.out.println("Elevator moving to " + nextFloor);
                floorStack.remove(nextFloor);
                existingFloor = nextFloor;
            }
            haltElevator();
        }

        private void changeDirection() {
            direction = direction == Direction.DOWN ? Direction.UP : Direction.DOWN;
            for (Integer floor: reverseDirectionFloorStack) {
                floorStack.add(floor);
            }
        }

        private void haltElevator() {
            System.out.println("Elevator stopped at " + existingFloor);
            isElevatorMoving = false;
        }
    }

    enum Direction {
        UP,
        DOWN;
    }
}