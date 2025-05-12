package Class;

public class SimpleElevatorSystem {
    public static void main(String[] args) {
        Elevator elevator = new Elevator();

        //Check Elevator's Idle response
        elevator.move();
        
        //Check Elevator's Up response
        System.out.println("Elevator requested to floor 5:");
        elevator.requestFloor(5);
        elevator.move();

        //Check Elevator's Down response
        System.out.println("Elevator requested to floor 2:");
        elevator.requestFloor(2);
        elevator.move();

        //Checking Up again
        System.out.println("Elevator requested to floor 8:");
        elevator.requestFloor(8);
        elevator.move();
    }
}
