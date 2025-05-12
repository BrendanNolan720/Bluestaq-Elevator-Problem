package Class;

import java.util.LinkedList;
import java.util.Queue;

import enums.Direction;

class Elevator {
	 	private int currentFloor;
	 	private Direction direction;
	 	private Queue<Integer> requests;

	    public Elevator() { 
	        currentFloor = 1;
	        direction = Direction.IDLE;
	        this.requests = new LinkedList<>();
	    }
	    
	    public void requestFloor(int floor) {
	        if (!requests.contains(floor)) {
	            requests.offer(floor);
	            if (direction == Direction.IDLE) {
	            	if (floor > currentFloor) {
	            	    direction = Direction.UP;
	            	} else {
	            	    direction = Direction.DOWN;
	            	}
	            }
	        }
	    }
	    
	    public int getCurrentFloor() {
	        return currentFloor;
	    }

	    public Direction getDirection() {
	        return direction;
	    }

	    public void move() {
	        if (requests.isEmpty()) {
	            direction = Direction.IDLE;
	            System.out.println("Elevator is idle at floor " + currentFloor);
	            return;
	        }

	        int nextFloor = requests.poll();
	        System.out.println("Moving " + direction + "" + " from floor " + currentFloor);
	        while (currentFloor != nextFloor) {
	            if (direction == Direction.UP) {
	                currentFloor++;
	                System.out.println("Going to floor " + currentFloor);
	            } else if (direction == Direction.DOWN) {
	                currentFloor--;
	                System.out.println("Going to floor " + currentFloor);
	            }
	        }
	        System.out.println("Arrived at floor " + currentFloor);

	        if (requests.isEmpty()) {
	            direction = Direction.IDLE;
	        } else {
	            int nextRequest = requests.peek();
	            if (nextRequest > currentFloor) {
	                direction = Direction.UP;
	            } else {
	                direction = Direction.DOWN;
	            }
	        }
	    }
	}
