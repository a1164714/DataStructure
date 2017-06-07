package queue.queue.simulatorline;

import queue.queue.IQueue;
import queue.queue.array.ArrayQueue;

public class WaitLine {
	private IQueue<Customer> line;
	private int numberOfArrivals;
	private int numberServed;
	private int totalTimeWaited;

	public WaitLine() {
//		line = new LinkedQueue<Customer>();
		line = new ArrayQueue<Customer>();
		numberOfArrivals = 0;
		numberServed = 0;
		totalTimeWaited = 0;
	}

	public void simulate(int duration, double arrivalProbability,
			int maxTransactionTime) {
		int transactionTimeLeft = 0;
		for (int clock = 0; clock < duration; clock++) {
			if (Math.random() < arrivalProbability) {
				numberOfArrivals++;
				int transactionTime = (int) (Math.random() * maxTransactionTime + 1);
				line.enqueue(new Customer(clock, transactionTime,
						numberOfArrivals));
				System.out.println("Customer " + numberOfArrivals
						+ " enters line at time " + clock
						+ ". Transaction time is " + transactionTime);
			}
			if (transactionTimeLeft > 0) {
				transactionTimeLeft--;
			} else if (!line.isEmpty()) {
				Customer nextCustomer = line.dequeue();
				transactionTimeLeft = nextCustomer.getTransactionTime() - 1;
				int timeWaited = clock - nextCustomer.getArrivalTime();
				totalTimeWaited += timeWaited;
				numberServed++;
				System.out.println("Customer "
						+ nextCustomer.getCustomerNumber()
						+ " begins service at time " + clock
						+ ". Time waited is " + timeWaited);
			}
		}
	}

	public void displayResults() {
		System.out.println();
		System.out.println("服务的顾客数量 : " + numberServed);
		System.out.println("顾客总等待时间 : " + totalTimeWaited);
		double averageTimeWaited = ((double) totalTimeWaited) / numberServed;
		System.out.println("顾客平均等待时间 : " + averageTimeWaited);
		int leftInLine = numberOfArrivals - numberServed;
		System.out.println("队列中剩余顾客数量 : " + leftInLine);
	}
	
	public static void main(String[] args) {
		WaitLine line = new WaitLine();
		line.simulate(20, 0.5, 4);
		line.displayResults();
	}
}
