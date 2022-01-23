package interviewQuestions.microsoft;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 *  startTime: 10:16 pm 23rd jan 2022
 *  end time: 10:26
 */
class CircularQueue {
	private List<Integer> list = new ArrayList<>();
	private int capacity;
	private int timeInterval;
	private int currentLocation = 0;

	CircularQueue(int capacity, int timeInterval) {
		this.capacity = capacity;
		this.timeInterval = timeInterval;
	}

	boolean enqueue(int timeStamp) {
		if (list.size() < capacity) {
			list.add(timeStamp);
			return true;
		} else {
			if (timeStamp - list.get(currentLocation) >= timeInterval) {
				list.set(currentLocation, timeStamp);
				currentLocation = (currentLocation + 1) % capacity;
				return true;
			} else {
				return false;
			}
		}
	}
}

public class RateLimitCircularQueue {
	private static int RATE_LIMIT = 3;
	private static int RATE_LIMIT_INTERVAL = 60;

	public static void main(String[] args) {
		CircularQueue cq = new CircularQueue(RATE_LIMIT, RATE_LIMIT_INTERVAL);
		cq.enqueue(20);
		cq.enqueue(30);
		cq.enqueue(55);
		System.out.println(cq.enqueue(60));
		System.out.println(cq.enqueue(90));
	}

}
