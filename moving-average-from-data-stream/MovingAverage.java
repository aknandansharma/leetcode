import java.util.LinkedList;
import java.util.Queue;

class MovingAverage {
	Queue<Integer> numbers;
	int sum;
	int size;

	/** Initialize your data structure here. */
	public MovingAverage(int size) {
		numbers = new LinkedList<>();
		sum = 0;
		this.size = size;
	}

	public double next(int val) {
		numbers.offer(val);
		sum += val;

		if (numbers.size() == size + 1) {
			sum -= numbers.poll();
		}

		return (double) sum / numbers.size();
	}

}

// Your MovingAverage object will be instantiated and called as such:
// MovingAverage obj = new MovingAverage(size);
// double param_1 = obj.next(val);
